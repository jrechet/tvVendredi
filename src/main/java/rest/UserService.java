package rest;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.UserDao;
import tpConnexion.User;

@Path("user")
public class UserService {

	@EJB
	private UserDao userDao;

	@Path("/display")
	@GET
	@Produces("application/json")
	public User display(@QueryParam("id") Long id) {
		return userDao.get(id);
	}

	//ADD
	@Path("add")
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void add(User user) {
		userDao.add(user);
	}

	//EDIT
	@Path("edit")
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void update(User user) {
		userDao.update(user);
	}

	//DELETE
	@Path("delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Long userId) {
		userDao.delete(userId);
	}
}