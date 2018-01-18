package tpBonjour;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value= "BonjourValidator")
public class BonjourValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		 
		String prenom = (String) value;
		 
/* Récupération de la valeur du champ nom saisi */
		 
	
	if (prenom.length() <2) {
		FacesMessage msg = new FacesMessage("Le champ prenom est invalide");
		throw new ValidatorException(msg);
	}
	
	//String nom = (String) component.getAttributes().get("nom");
			
System.out.println("suite validation prenom : " + prenom);
	
/* Récupération de la valeur du champ prenom */
	//String prenom = (String)value;
	
	UIInput nomInput = (UIInput) component.getAttributes().get("nomAttribute");
	String nom = (String) nomInput.getValue();
	
	if (nom.length() <2) {
		FacesMessage msg = new FacesMessage("Le champ nom est invalide");
		throw new ValidatorException(msg);
	}
	 
System.out.println("récupération nom: " + nom);

	if(prenom!=null&&nom!=null&&prenom.equals(nom))
	{
		/* Envoi d'une exception contenant une erreur de validation JSF initialisée avec
		 * le message si les chps sont différents */
		
		throw new ValidatorException(new FacesMessage("Le nom et le prénom doivent être différents"));
	}
}}