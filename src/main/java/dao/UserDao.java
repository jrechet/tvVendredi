package dao;
import tpConnexion.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "pu-h2") // même nom que ds persistence.xml
    private EntityManager em;

    public List<User> list(){
    	return em.createQuery("select e from User e").getResultList();
    }
    
    //ADD
    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }
    
    //DELETE
    public void delete(Long userId)  {
    	User userToDelete = em.find(User.class, userId);
    	em.remove(userToDelete);
    } 
    //public void deleteEntity(User userToDelete){
    // em.remove(user);
    
    //UPDATE
    public void update(User user) {
        user = em.merge(user);
        //em.flush();
    }

    public User get(Long userId) {
        return em.find(User.class, userId);
    }
}

//Stateless object is an instance of a class without instance fields (instance variables). 
//The class may have fields, but they are compile-time constants (static final).
//
//A very much related term is immutable. 
//Immutable objects may have state, but it does not change when a method is invoked 
//(method invocations do not assign new values to fields). These objects are also thread-safe.
