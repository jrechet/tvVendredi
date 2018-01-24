package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UserDao;
import java.io.Serializable;
import java.util.List;

import tpConnexion.User;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user;

	@EJB
	private UserDao userDao;
	
	public UserController() {
		user = new User();
	}

	public List<User> list(){
		return userDao.list();
	}

	//ADD
	public String add() {
		userDao.add(user);
		return "listUsers";
	}
	
	//DELETE
	public String delete(Long userId) {
		userDao.delete(userId);
		return "listUsers";
	}
	
	//UPDATE
	public String update() {
        System.out.println("update user : " + user.getId());
		userDao.update(this.user);
		return "listUsers";
	}
	
	//Méthode pour permettre l'affichege de la page d'édition préremplie
	//avec les champs de la BDD
    public String displayUpdateView(Long userId) {
        this.user = userDao.get(userId);
        return "edit";
    }

	//Getters-Setters -------------------------------------------------------------------
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}