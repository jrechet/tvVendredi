package rest;

import dao.TrackDao;
import dao.UserDao;
import tpConnexion.Track;
import tpConnexion.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("user")
public class UserService {

    @EJB
    private UserDao userDao;
    @EJB
    private TrackDao trackDao;

    private User user;

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public User display(@PathParam("id") Long userId) {
        System.out.println("the user to show " + userId);
        User user = userDao.get(userId);
        System.out.println("the user " + userId + " has " + user.getTrackList().size() + " tracks");

        // filter les informations non désirées
        for (Track track : user.getTrackList()) {
            track.setUser(null);
        }

        return user;
    }

//    public User display(@PathParam("id") Long UserId) {
//	System.out.println("the user to show " + UserId);
//        User userToDisplay = userDao.get(UserId);
//        System.out.println("the userToDisplay" + UserId);
//        System.out.println(userToDisplay.getNom());
//        userToDisplay.getPrenom();
//        userToDisplay.getMail();
//        userToDisplay.getPassword();

//        List<Track> tracks = new ArrayList<>();
//        for (Track trackList : userToDisplay.getTrackList()) {
//            System.out.println("userToDisplayFor" + trackList);
//            Track track = null;
//            Track trackUserToDisplay = new Track();
//            trackUserToDisplay.setId(track.getId());
//            trackUserToDisplay.setTitle(track.getTitle());
//            trackUserToDisplay.setArtist(track.getArtist());
//            tracks.add(trackUserToDisplay);
//        }
//        userToDisplay.setTrackList(tracks);
//        System.out.println("userToDisplayEnd" + tracks);
//        return userToDisplay;
//    }

    //ADD
    @POST
    @Path("add/{nom}/{prenom}/{mail}/{password}")
    public Response add(@PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("mail") String mail, @PathParam("password") String password, @Context UriInfo uriInfo) {
        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setMail(mail);
        user.setPassword(password);
        userDao.add(user);

        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(user.getId())).build()).build();

//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public void add(User user) {
//		userDao.add(user);
    }

    //EDIT
    @PUT
    @Path("edit/{id}/{nom}/{prenom}/{mail}/{password}")
    //Veiller � appeler les params de fa�on identique!! genre pas {id} appel� par userId
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(@PathParam("id") Long userId, @PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("mail") String mail, @PathParam("password") String password) {
        System.out.println("Service - Updating of user:" + userId);
        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setMail(mail);
        user.setPassword(password);

        userDao.update(userId, user);
    }

    //DELETE
    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void delete(@PathParam("id") Long userId) {
        userDao.delete(userId);
    }

    //AddTrackToUser (TTU)
    @POST
    @Path("addTTU/{userId}/{trackId}")
    public void addTTU(@PathParam("userId") Long userId, @PathParam("trackId") Long trackId) {
        System.out.println("adding track " + trackId + " to user " + userId);
        userDao.addTTU(userId, trackId);
    }
}

