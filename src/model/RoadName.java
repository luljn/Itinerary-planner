package model;

import java.util.regex.*;
import java.lang.Character;

// TODO: Auto-generated Javadoc
/**
 * The Class RoadName.
 */
public class RoadName extends Object{

	/** The nom. */
	String nom;
	
	// Format d�finissant les routes non ville ( A36, E54 etc...)
	/** The autoroute pattern. */
	Pattern autoroutePattern = Pattern.compile(".*A(\\d)+.*");
	
	/** The europeenne pattern. */
	Pattern europeennePattern = Pattern.compile(".*E(\\d)+.*");
	
	/** The nationale pattern. */
	Pattern nationalePattern = Pattern.compile(".*N(\\d)+.*");
	
	/** The departementale pattern. */
	Pattern departementalePattern = Pattern.compile(".*D(\\d)+.*");
	
	
	/**
	 * Instantiates a new road name.
	 *
	 * @param oNom the o nom
	 */
	public RoadName(Object oNom){
		super();
		nom = oNom.toString();
	}
	
	/**
	 * Est une autoroute.
	 *
	 * @return true, if successful
	 */
	public boolean estUneAutoroute(){
		Matcher m = autoroutePattern.matcher(nom);
		return m.matches();
	}
	
	/**
	 * Est une europeenne.
	 *
	 * @return true, if successful
	 */
	public boolean estUneEuropeenne(){
		Matcher m = europeennePattern.matcher(nom);
		return m.matches();
	}
	
	/**
	 * Est une nationale.
	 *
	 * @return true, if successful
	 */
	public boolean estUneNationale(){
		Matcher m = nationalePattern.matcher(nom);
		return m.matches();
	}
	
	/**
	 * Est une departementale.
	 *
	 * @return true, if successful
	 */
	public boolean estUneDepartementale(){
		Matcher m = departementalePattern.matcher(nom);
		return m.matches();
	}
	
	/**
	 * Est une ville.
	 *
	 * @return true, if successful
	 */
	public boolean estUneVille(){
		return (!estUneAutoroute() && !estUneEuropeenne() && !estUneNationale() && !estUneDepartementale());
	}
	
	// Extrait la ville du nom de la route ( "ville - nomRoute" )
	/**
	 * Extraire nom ville.
	 *
	 * @return the string
	 */
	public String extraireNomVille(){
		String nomVille = new String(nom);
		int indice = nomVille.indexOf('-');			
			
		// Si un '-' est trouv�, on ne prend que ce qui viens avant
		if(indice > -1){
		 	
			// Prend le nom de la ville
			nomVille = nomVille.substring(0, indice);
			
			// Retire les eventuels espaces apr�s le nom de ville
			while(Character.isWhitespace(nomVille.charAt(indice-1))  ){
				nomVille = nomVille.substring(0, indice-=1);
			}
		}
		// Sinon on garde tout le nom, donc pas de changements
		return nomVille;
	}
}
