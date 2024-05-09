package model;

// TODO: Auto-generated Javadoc
// Classe stockant un element d'un plus court chemin
/**
 * The Class ItineraryState. Store a shortest path element
 */
public class ItineraryState
{
	// Numero de la Node (numéro du point du reseau routier)
	/** The n. */
	public int n;
	// Autres donnees
	/** The g. */
	public int g;

	
	/**
	 * Instantiates a new itinerary state.
	 *
	 * @param nde the node
	 * @param goal the goal
	 */
	public ItineraryState(int nde, int goal)
	{
		n = nde;
		g = goal;
	}
}
