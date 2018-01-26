package dao;

import tpConnexion.Track;
import tpConnexion.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "pu-h2") // m�me nom que ds persistence.xml
    private EntityManager em;

    @EJB
    TrackDao trackDao;

    public List<User> list() {
        return em.createQuery("select e from User e").getResultList();
    }

    //ADD
    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }

    //DELETE
    public void delete(Long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);
    }

    //UPDATE
    public void update(Long userId, User user) {
        System.out.println("DAO - Updating of user:" + userId);
        User userToEdit = em.find(User.class, userId);
        userToEdit.setNom(user.getNom());
        userToEdit.setPrenom(user.getPrenom());
        userToEdit.setMail(user.getMail());
        userToEdit.setPassword(user.getPassword());
        em.merge(userToEdit);
        //em.flush();
    }

    public User get(Long userId) {

        return em.find(User.class, userId);
    }

    public void addTTU(Long userId, Long trackId) {
        User user = get(userId);
        System.out.println("User : " + userId);
        Track track = trackDao.get(trackId);
        System.out.println("Track :" + trackId);
        user.getTrackList().add(track);
        em.persist(user);
        track.setUser(user);
        em.persist(track);
    }

    public void deleteTrackFromUser(Long userId, Long trackId) {
        User user = get(userId);
        Track track = trackDao.get(trackId);
        System.out.println("User:" + userId + ", Track: " + trackId);
        user.getTrackList().remove(track);
        em.persist(user);
    }
}

//Stateless object is an instance of a class without instance fields (instance variables). 
//The class may have fields, but they are compile-time constants (static final).
//
//A very much related term is immutable. 
//Immutable objects may have state, but it does not change when a method is invoked 
//(method invocations do not assign new values to fields). These objects are also thread-safe.
