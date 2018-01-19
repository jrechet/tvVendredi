package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tpConnexion.User;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user;

	public UserController() {
		user = new User();
	}

	public void add() {
		System.out.println(user.getmail());
	}

	// @EJB
	// private
	//
	// public void add() {
	// userDao.add(user);
	//
	// }

	public String display() {
		System.out.println("User connection");
		System.out.println(user.getmail());
		System.out.println(user.getPassword());
		return "display";
	}

	// --Getter - Setter --
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
