package rest;

import dao.UserDao;
import tpConnexion.User;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ejb.EJB;
import javax.ws.rs.QueryParam;

@Path("/rest")
public class ExRestService {

	    @GET
	    @Produces("text/html")
	    @Path("/yes")
	    public String yes() {
	        return "No";
	    }

	    @EJB
	    private UserDao userDao;
	    
	    @GET
	    @Produces("application/json")
	    @Path("/test")
	    public User test(@QueryParam("id")int id) {
	        User user = new User();
	        user.setMail("testouille.com");
	        return user;
	    }
}
