package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.TrackDao;
import java.io.Serializable;
import java.util.List;

import tpConnexion.Track;

@ManagedBean
@RequestScoped
public class TrackController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Track track;

	@EJB
	private TrackDao trackDao;
	
	public TrackController() {
		track = new Track();
	}

	public List<Track> list(){
		return trackDao.list();
	}

	//ADD
	public String add() {
		trackDao.add(track);
		return "TrackList";	//Page de la liste des tracks
	}
	
	//DELETE
	public String delete(Long trackId) {
		trackDao.delete(trackId);
		return "TrackList";
	}
	
	//UPDATE
	public String update() {
        System.out.println("Updated track : " + track.getId());
		trackDao.update(this.track);
		return "TrackList";
	}
	
	//Méthode pour permettre l'affichege page d'édition 
	//préremplie avec les champs de la BDD
    public String displayUpdateView(Long TrackId) {
        this.track = trackDao.get(TrackId);
        return "TrackEdit";
    }

	//Getters-Setters -------------------------------------------------------------------
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track Track) {
		this.track = Track;
	}
}