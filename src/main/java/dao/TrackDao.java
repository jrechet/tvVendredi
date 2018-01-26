package dao;
import tpConnexion.Track;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TrackDao {

    @PersistenceContext(unitName = "pu-h2") // Même nom que ds persistence.xml
    private EntityManager em;

    public List<Track> list(){
    	return em.createQuery("select e from Track e").getResultList();
    }
    
    //ADD
    public void add(Track track) {
        System.out.println("em: " + em);
        em.persist(track);
    }
    
    //DELETE
    public void delete(Long trackId)  {
    	Track trackToDelete = em.find(Track.class, trackId);
    	em.remove(trackToDelete);
    } 
    //public void deleteEntity(Track TrackToDelete){
    // em.remove(Track);
    
    //UPDATE
    public void update(Track track) {
        track = em.merge(track);
        System.out.println("Updated trackId: " + track.getId());
        //em.flush();
    }

    public Track get(Long trackId) {
        return em.find(Track.class, trackId);
    }
}