package controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

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

	public void add() {
		System.out.println(user.getmail());
		userDao.add(user);
	}

	public String display() {
		System.out.println("User connection");
		System.out.println(user.getMail());
		System.out.println(user.getPassword());
		return "display";
	}

	// --Getters - Setters --
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.user = user;
	}
	
}
