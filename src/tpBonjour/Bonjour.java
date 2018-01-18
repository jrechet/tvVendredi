package tpBonjour;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //précise au serveur: bean géré par JSF comme modèle associé à 1 ou + vues. Le nom du bean = nom de la classe (majuscule en moins) 
@RequestScoped //précise au serveur bean a pr portée la requête. 
public class Bonjour implements Serializable {  //capacité de survivre au redémarrage du serveur. 

	private static final long serialVersionUID = 1L;
	private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }
    public void setNom( String nom ) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }
    
//    public void validateFields(FacesContext context, UIComponent toValidate, Object value){
//    	String nom = (String) value;
//    	
//    	
//    	
//    }
}
