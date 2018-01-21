package dao;
import tpConnexion.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserDao {

    @PersistenceContext(unitName = "src-persistence-unit")
    private EntityManager em;

    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }

}

//Stateless object is an instance of a class without instance fields (instance variables). 
//The class may have fields, but they are compile-time constants (static final).
//
//A very much related term is immutable. 
//Immutable objects may have state, but it does not change when a method is invoked 
//(method invocations do not assign new values to fields). These objects are also thread-safe.