package rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import dao.TrackDao;
import tpConnexion.Track;

@Path("Track")
public class TrackService {

	@EJB
	private TrackDao trackDao;
	
	@GET	// Méthode GET
	@Path("/{id}")
	@Produces("application/json")
	public Track display(@PathParam("id") Long id) {
		return trackDao.get(id);
	}
	
	//ADD
	@POST	// Méthode POST
	@Path("{title}/{artist}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void add(@PathParam("title") String title, @PathParam("artist") String artist, @Context UriInfo uriInfo) {
	    Track track = new Track();
	    track.setTitle(title);
	    track.setArtist(artist);
	    trackDao.add(track);
	}
	
	//DELETE
	@Path("delete/{id}")
	@DELETE	// Méthode DELETE à renseigner ds Postman pr les tests
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Long trackId) {
		trackDao.delete(trackId);
		System.out.println("deletion occured for: "+ trackId);
	}
	
	//EDIT
	@Path("edit/{id}/{title}/{artist}")
	@PUT	// Méthode PUT à renseigner ds Postman pr les tests
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void update(@PathParam("id") Long trackId,@PathParam("title") String title,@PathParam("artist") String artist) {
		Track track = new Track();
		track.setId(trackId);
		track.setTitle(title);
		track.setArtist(artist);
		
		trackDao.update(track);
	}
}