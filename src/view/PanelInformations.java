package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.Application;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelInformations.
 */
@SuppressWarnings("serial")
public class PanelInformations extends JPanel{

	/** The lbl infos. */
	private JLabel lblInfos;
	
	/** The dlm infos. */
	private DefaultListModel dlmInfos; 
	
	/** The jl infos. */
	private JList jlInfos;
	
	/** The jsp infos. */
	private JScrollPane jspInfos;
	
	/** The lbl feuille route. */
	private JLabel lblFeuilleRoute;
	
	/** The dlm feuille route. */
	private DefaultListModel dlmFeuilleRoute; 
	
	/** The jl feuille route. */
	private JList jlFeuilleRoute;
	
	/** The jsp feuille route. */
	private JScrollPane jspFeuilleRoute;
	
	/** The inside border. */
	private Border jspBorder, outsideBorder, insideBorder;
	
	/** The INFO s_ hauteur. */
	private final int INFOS_HAUTEUR = 300;
	
	// Donnees des infos
	/** The longueur_trajet. */
	private String message1, message2, su, longueur_trajet;
	
	/** The id point. */
	private int x, y, idPoint;
	
	/** The arrivee. */
	private int depart = -1, arrivee = -1;
	
	/** The zoom. */
	float zoom = Application.ZOOM_INITIAL;
	
	/**
	 * Instantiates a new panel informations.
	 *
	 * @param l the l
	 * @param h the h
	 * @param su the su
	 */
	public PanelInformations(int l, int h, String su) {
		super();
		this.su = su;
		
		// Creation du Layout (de type BoxLayout)
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		// Ajout du label informations
		lblInfos = new JLabel("Informations :");
		lblInfos.setFont(lblInfos.getFont().deriveFont(Font.BOLD));
		lblInfos.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		lblInfos.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblInfos);
		
		// Creation de la bordure des listes
		outsideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		// A ameliorer
		insideBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		jspBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
		
		//Init feuille route
		dlmFeuilleRoute = new DefaultListModel();
		jlFeuilleRoute = new JList(dlmFeuilleRoute);
		
		// Ajout de la liste scrollable d'informations
		dlmInfos = new DefaultListModel();
		jlInfos = new JList(dlmInfos);
		jlInfos.setLayoutOrientation(JList.VERTICAL);
		jlInfos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlInfos.setVisibleRowCount(-1);
		jspInfos = new JScrollPane(jlInfos);
		jspInfos.setPreferredSize(new Dimension((int)l, INFOS_HAUTEUR));
		jspInfos.setMinimumSize(new Dimension((int)l, INFOS_HAUTEUR));
		jspInfos.setBorder(jspBorder);
		add(jspInfos);
		setMessage("Bienvenue !", "Choisissez un itin\u00e9raire.");
		
		// Ajout du label Feuille de route
		lblFeuilleRoute = new JLabel("Feuille de route :");
		lblFeuilleRoute.setFont(lblFeuilleRoute.getFont().deriveFont(Font.BOLD));
		lblFeuilleRoute.setAlignmentX(Component.CENTER_ALIGNMENT);
		//add(lblFeuilleRoute);
		
		// Ajout de la liste scrollable feuille de route
		
		jlFeuilleRoute.setLayoutOrientation(JList.VERTICAL);
		jlFeuilleRoute.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlFeuilleRoute.setVisibleRowCount(-1);
		jlFeuilleRoute.setCellRenderer(new AfficheurElementListe());
		jspFeuilleRoute = new JScrollPane(jlFeuilleRoute);
		jspFeuilleRoute.add(jlFeuilleRoute);
		jspFeuilleRoute.setPreferredSize(new Dimension((int)l, (int)(h * (float)4/5)));
		jspFeuilleRoute.setBorder(jspBorder);
		jspFeuilleRoute.setVisible(false);
		add(jspFeuilleRoute);
		
		
	}
	
	/**
	 * Ajouter route.
	 *
	 * @param route the route
	 * @param chemin_image the chemin_image
	 */
	public void ajouterRoute(String route, String chemin_image) {
		dlmFeuilleRoute.addElement(new ElementListe(route, chemin_image));
	}
	
	/**
	 * Ajouter route.
	 *
	 * @param route the route
	 */
	public void ajouterRoute(String route) {
		dlmFeuilleRoute.addElement(new ElementListe(route));
	}
	
	/**
	 * Reinitialiser infos.
	 */
	public void reinitialiserInfos() {
		dlmInfos.removeAllElements();
	}
	
	/**
	 * Reinitialiser routes.
	 */
	public void reinitialiserRoutes() {
		dlmFeuilleRoute.removeAllElements();
	}
	
	/**
	 * Sets the message.
	 *
	 * @param mess1 the mess1
	 * @param mess2 the mess2
	 */
	public void setMessage(String mess1, String mess2) {
		message1 = mess1;
		message2 = mess2;
		refaireInfos();
	}
	
	/**
	 * Sets the longueur trajet.
	 *
	 * @param longueur the new longueur trajet
	 */
	public void setLongueurTrajet(String longueur) {
		longueur_trajet = longueur;
		refaireInfos();
	}
	
	/**
	 * Update coord.
	 *
	 * @param x the x
	 * @param y the y
	 * @param idPoint the id point
	 */
	public void updateCoord(int x, int y, int idPoint) {
		this.x = x;
		this.y = y;
		this.idPoint = idPoint;
		refaireInfos();
	}
	
	/**
	 * Update zoom.
	 *
	 * @param zoom the zoom
	 */
	public void updateZoom(float zoom) {
		this.zoom = zoom;
		refaireInfos();
	}
	
	/**
	 * Update depart.
	 *
	 * @param d the d
	 */
	public void updateDepart(int d) {
		depart = d;
		refaireInfos();
	}	
	
	/**
	 * Update arrivee.
	 *
	 * @param a the a
	 */
	public void updateArrivee(int a) {
		arrivee = a;
		refaireInfos();
	}
	
	/**
	 * Refaire infos.
	 */
	private void refaireInfos() {
		dlmInfos.removeAllElements();
		if(message1 != null)
			dlmInfos.addElement(message1);
		if(message2 != null)
			dlmInfos.addElement(message2);
		dlmInfos.addElement(new String("Systeme d'unit\u00e9s : " + su));
		
		dlmInfos.addElement(new String("Point courant :"+idPoint));
		dlmInfos.addElement(new String("Coordonn\u00e9e X : " + x));
		dlmInfos.addElement(new String("Coordonn\u00e9e Y : " + y));
		dlmInfos.addElement(new String("Zoom : " + (int)(zoom * 100) + " %"));
		dlmInfos.addElement(new String(" "));
		dlmInfos.addElement(new String("Longueur du trajet : " + ((longueur_trajet == null) ? "-" : longueur_trajet)));
		dlmInfos.addElement(new String("D\u00e9part : " + ((depart == -1) ? "-" : "Point "+ new Integer(depart).toString())));
		dlmInfos.addElement(new String("Arriv\u00e9e : " + ((arrivee == -1) ? "-" : "Point "+ new Integer(arrivee).toString())));
		dlmInfos.addElement(new String(" "));
		dlmInfos.addElement(new String("Itineraire: "));
		for(Object s: dlmFeuilleRoute.toArray()){
			dlmInfos.addElement(s);
		}
	}
	
	public ArrayList<String> getItinerary(){
		ArrayList<String> itinerary = new ArrayList<String>();
		itinerary.add("Depart : "+ depart + " Arrivee : "+arrivee);
		itinerary.add("Longueur du trajet : " + ((longueur_trajet == null) ? "-" : longueur_trajet));
		itinerary.add("Votre itineraire: "+System.getProperty("line.separator")+System.getProperty("line.separator"));
		for(Object s: dlmFeuilleRoute.toArray()){
			itinerary.add(s.toString());
		}
		return itinerary;
	}
}

class ElementListe {
	  private final String texte;
	  private final String chemin_image;
	  private ImageIcon image;
	  
	  public ElementListe(String texte) {
		  this.texte = texte;
		  this.chemin_image = "";
	  }

	  public ElementListe(String texte, String chemin_image) {
		  this.texte = texte;
		  this.chemin_image = chemin_image;
	  }

	  public String getTitle() {
		  return texte;
	  }
	  
	  public String getCheminImage() {
		  return chemin_image;
	  }

	  public ImageIcon getImage() {
		  if (image == null) {
			  image = new ImageIcon(chemin_image);
		  }
		  return image;
	  }
	  
	  // Override standard toString method to give a useful result
	  public String toString() {
		  return texte;
	  }
}

@SuppressWarnings("serial")
class AfficheurElementListe extends JLabel implements ListCellRenderer {
	
	private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public AfficheurElementListe() {
		setOpaque(true);
	    setIconTextGap(5);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    ElementListe element = (ElementListe) value;
		setText(element.getTitle());
		if (element.getCheminImage() != "") {
			setIcon(element.getImage());
		}
		else {
			setIcon(new ImageIcon());
		}
	    if (isSelected) {
	      setBackground(HIGHLIGHT_COLOR);
	      setForeground(Color.white);
	    }
	    else {
	      setBackground(Color.white);
	      setForeground(Color.black);
	    }
		return this;
	}

}