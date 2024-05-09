package model;
import java.util.Vector;


// TODO: Auto-generated Javadoc
/**
 * The Class Road.
 */
public class Road {
	// Sens de la route
	/** The sens. */
	private int sens;
	// Liste des points
	/** The points. */
	private Vector<Integer> points;
	
	// Constructeur
	/**
	 * Instantiates a new road.
	 *
	 * @param s the s
	 */
	public Road(int s) {
		points = new Vector<Integer>();
		sens = s;
	}
	
	// Ajoute un numéro de point à la route
	/**
	 * Ajouter num point.
	 *
	 * @param num the num
	 */
	public void ajouterNumPoint(Integer num) {
		points.add(num);
	}

	// Renvoie le point de position pos
	/**
	 * Gets the num point.
	 *
	 * @param pos the pos
	 * @return the num point
	 */
	public Integer getNumPoint(int pos) {
		return points.get(pos);
	}
	
	// Renvoie le nombre de points constituants la route
	/**
	 * Gets the nombre points.
	 *
	 * @return the nombre points
	 */
	public int getNombrePoints() {
		return points.size();
	}
	
	// Renvoie la liste des points
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public Vector<Integer> getPoints() {
		return points;
	}

	/**
	 * Gets the sens.
	 *
	 * @return the sens
	 */
	public int getSens() {
		return sens;
	}
}
