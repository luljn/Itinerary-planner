package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import model.Application;
import org.jdesktop.swingx.autocomplete.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelControls.
 */
@SuppressWarnings("serial")
public class PanelControls extends JPanel {
	
	/** The HAUTEUR. */
	private final int HAUTEUR = 150;
	
	/** The jl depart. */
	private JLabel jlDepart;
	
	/** The jl arrivee. */
	private JLabel jlArrivee;
	
	/** The jl ville. */
	private JLabel jlVille;
	
	/** The jl rue. */
	private JLabel jlRue;
	
	/** The jl point. */
	private JLabel jlPoint;
	
	/** The jcb ville depart. */
	private JComboBox jcbVilleDepart;
	
	/** The jcb ville arrivee. */
	private JComboBox jcbVilleArrivee;
	//constantes de selection de comboBox
	/**
	 * The Enum jcbFlag.
	 */
	public enum jcbFlag {
/** The DEPART. */
DEPART, 
 /** The ARRIVEE. */
 ARRIVEE, 
 /** The BOTH. */
 BOTH};
	
	/** The jcb rue depart. */
	private JComboBox jcbRueDepart;
	
	/** The jcb rue arrivee. */
	private JComboBox jcbRueArrivee;
	
	/** The jcb point depart. */
	private JComboBox jcbPointDepart;
	
	/** The jcb point arrivee. */
	private JComboBox jcbPointArrivee;
	
	/** The jb ok. */
	private JButton jbOk;
	
	/** The jl zoom. */
	private JLabel jlZoom;
	
	/** The js zoom. */
	private JSlider jsZoom;
	
	/** The jb zoom plus. */
	private JButton jbZoomPlus;
	
	/** The jb zoom moins. */
	private JButton jbZoomMoins;
	
	/** The jb zoom global. */
	private JButton jbZoomGlobal;
	
	/** The jb zoom gros plan. */
	private JButton jbZoomGrosPlan;
	
	/** The jb zoom reel. */
	private JButton jbZoomReel;
	
	/** The jp conteneur est. */
	private JPanel jpConteneurEst;
	
	/** The jp conteneur ouest. */
	private JPanel jpConteneurOuest;
	
	/** The contraintes. */
	private GridBagConstraints contraintes;

	/**
	 * Instantiates a new panel controls.
	 */
	public PanelControls() {
		super();
		
		//Creation du Panel Ouest
		jpConteneurOuest = new JPanel(new GridBagLayout());
		jpConteneurOuest.setMaximumSize(new Dimension(600, HAUTEUR));
		
		// Creation des contraintes communes
		contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(5, 5, 5, 5);
		contraintes.anchor = GridBagConstraints.LINE_START;
		contraintes.weightx = 0.0;
		
		// Ajout du label Ville
		jlVille = new JLabel("Ville :");
		jlVille.setFont(jlVille.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		jpConteneurOuest.add(jlVille, contraintes);
		
		// Ajout du label Rue
		jlRue = new JLabel("Rue :");
		jlRue.setFont(jlVille.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		jpConteneurOuest.add(jlRue, contraintes);
		
		// Ajout du label Points
		jlPoint = new JLabel("Point :");
		jlPoint.setFont(jlPoint.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		jpConteneurOuest.add(jlPoint, contraintes);
		
		// Contrainte pour les autres composants
		contraintes.anchor = GridBagConstraints.CENTER;
		
		// Ajout du label Depart
		jlDepart = new JLabel("D\u00e9part :");
		jlDepart.setFont(jlDepart.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		jpConteneurOuest.add(jlDepart, contraintes);
		
		// Ajout de la ComboBox de la ville départ
		jcbVilleDepart = new JComboBox();
		jcbVilleDepart.setName("jcbVilleDepart");
		jcbVilleDepart.setPreferredSize(new Dimension(175,20));
		jcbVilleDepart.setEditable(true);
		
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		jpConteneurOuest.add(jcbVilleDepart, contraintes);
		
		// Ajout de la ComboBox de la rue de départ
		jcbRueDepart = new JComboBox();
		jcbRueDepart.setName("jcbRueDepart");
		jcbRueDepart.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		jpConteneurOuest.add(jcbRueDepart, contraintes);
		
		// Ajout de la ComboBox du point de départ
		jcbPointDepart = new JComboBox();
		jcbPointDepart.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 3;
		jpConteneurOuest.add(jcbPointDepart, contraintes);
		
		// Ajout du label Arrivee
		jlArrivee = new JLabel("Arriv\u00e9e :");
		jlArrivee.setFont(jlArrivee.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 2;
		contraintes.gridy = 0;		
		jpConteneurOuest.add(jlArrivee, contraintes);
		
		// Ajout de la ComboBox de la ville d'arrivée
		jcbVilleArrivee = new JComboBox();
		jcbVilleArrivee.setName("jcbVilleArrivee");
		jcbVilleArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 2;
		contraintes.gridy = 1;
		jpConteneurOuest.add(jcbVilleArrivee, contraintes);
		
		// Ajout de la ComboBox de la rue d'arrivée
		jcbRueArrivee = new JComboBox();
		jcbRueArrivee.setName("jcbRueArrivee");
		jcbRueArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 2;
		contraintes.gridy = 2;
		jpConteneurOuest.add(jcbRueArrivee, contraintes);
		
		// Ajout de la ComboBox du point de départ
		jcbPointArrivee = new JComboBox();
		jcbPointArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 2;
		contraintes.gridy = 3;
		jpConteneurOuest.add(jcbPointArrivee, contraintes);
		
		// Bouton pour valider la requete
		jbOk = new JButton("Go");
		jbOk.setFont(new Font(jbOk.getFont().getFontName(), Font.BOLD, 15));
		jbOk.setName("jbOk");
		contraintes.gridx = 3;
		contraintes.gridy = 1;
		contraintes.gridheight = 3;
		contraintes.gridwidth = GridBagConstraints.RELATIVE;
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurOuest.add(jbOk, contraintes);
		
		// Creation du Panel Est
		jpConteneurEst = new JPanel(new GridBagLayout());
		jpConteneurEst.setMaximumSize(new Dimension(400, HAUTEUR));
		
		// Contraintes communes
		contraintes.gridheight = 1;
		contraintes.weightx = 1.0;
		contraintes.fill = GridBagConstraints.NONE;
		
		// Label des zooms
		jlZoom = new JLabel("Zoom :");
		jlZoom.setFont(jlZoom.getFont().deriveFont(Font.BOLD));
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 3;
		contraintes.anchor = GridBagConstraints.CENTER;
		jpConteneurEst.add(jlZoom, contraintes);
		
		contraintes.gridwidth = 1;
		
		// Boutton pour Zoomer
		jbZoomPlus = new JButton();
		jbZoomPlus.setName("jbZoomPlus");
		jbZoomPlus.setText("+");
		jbZoomPlus.setPreferredSize(new Dimension(60, 60));
		contraintes.gridx = 2;
		contraintes.gridy = 1;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurEst.add(jbZoomPlus, contraintes);
		
		//Slider de zoom
		jsZoom = new JSlider();
		jsZoom.setMinimum((int) (Application.ZOOM_MIN*100));
		jsZoom.setMaximum((int) (Application.ZOOM_MAX*100));
		jsZoom.setValue((int) (Application.ZOOM_INITIAL*100));
		jsZoom.setMajorTickSpacing(10);
		jsZoom.setPaintTicks(true);
		jsZoom.setPaintLabels(true);
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		jpConteneurEst.add(jsZoom,contraintes);

		// Boutton pour Dezoomer
		jbZoomMoins = new JButton();
		jbZoomMoins.setName("jbZoomMoins");
		jbZoomMoins.setText("-");
		jbZoomMoins.setPreferredSize(new Dimension(60, 60));
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.anchor = GridBagConstraints.LINE_END;
		jpConteneurEst.add(jbZoomMoins, contraintes);
		
		//Boutton pour avoir une vue d'ensemble (où on ne vois rien d'ailleurs)
		jbZoomGlobal = new JButton("Vue Globale");
		jbZoomGlobal.setName("jbZoomGlobal");
		jbZoomGlobal.setPreferredSize(new Dimension(100, 20));	
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.anchor = GridBagConstraints.CENTER;
		//jpConteneurEst.add(jbZoomGlobal, contraintes);
		
		// Boutton pour remettre le Zoom a la normale
		jbZoomReel = new JButton("R\u00e9initialiser");
		jbZoomReel.setName("jbZoomReel");
		jbZoomReel.setPreferredSize(new Dimension(100, 20));
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		contraintes.anchor = GridBagConstraints.CENTER;
		jpConteneurEst.add(jbZoomReel, contraintes);
		
		//Boutton pour mettre la vue en gros plan
		jbZoomGrosPlan = new JButton("Gros plan");
		jbZoomGrosPlan.setName("jbZoomGrosPlan");
		jbZoomGrosPlan.setPreferredSize(new Dimension(100, 20));	
		contraintes.gridx = 2;
		contraintes.gridy = 2;
		contraintes.anchor = GridBagConstraints.CENTER;
		//jpConteneurEst.add(jbZoomGrosPlan, contraintes);
		
		// Creation du Layout general(de type BoxLayout)	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		add(Box.createHorizontalGlue());
		add(jpConteneurOuest);
		add(Box.createHorizontalGlue());
		add(jpConteneurEst);
		add(Box.createHorizontalGlue());
	}
	
	/**
	 * Ajouter route dans combobox.
	 *
	 * @param route the route
	 * @param flag the flag
	 */
	public void ajouterRouteDansCombobox(String route, jcbFlag flag) {
		switch(flag){
		case DEPART:
			jcbRueDepart.addItem(route);
			break;
		
		case ARRIVEE:
			jcbRueArrivee.addItem(route);
			break;
			
		case BOTH:
			jcbRueDepart.addItem(route);
			jcbRueArrivee.addItem(route);
			break;
		}	
	}
	
	/**
	 * Ajouter ville dans combobox.
	 *
	 * @param ville the ville
	 */
	public void ajouterVilleDansCombobox(String ville){
		jcbVilleDepart.addItem(ville);
		AutoCompleteDecorator.decorate(jcbVilleDepart);
		jcbVilleArrivee.addItem(ville);
		AutoCompleteDecorator.decorate(jcbVilleArrivee);
	}
	
	/**
	 * Gets the nom ville.
	 *
	 * @param flag the flag
	 * @return the nom ville
	 */
	public String getNomVille(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbVilleDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbVilleArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	/**
	 * Gets the nom route.
	 *
	 * @param flag the flag
	 * @return the nom route
	 */
	public String getNomRoute(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbRueDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbRueArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	/**
	 * Gets the num point.
	 *
	 * @param flag the flag
	 * @return the num point
	 */
	public int getNumPoint(jcbFlag flag) {
		int ret = -1;
		switch (flag) {
			case DEPART: ret = (Integer)jcbPointDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (Integer)jcbPointArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	/**
	 * Sets the points.
	 *
	 * @param flag the flag
	 * @param liste the liste
	 */
	public void setPoints(jcbFlag flag, Vector<Integer> liste) {
		JComboBox cmb = new JComboBox();
		switch (flag) {
			case DEPART: cmb = jcbPointDepart; break;
			case ARRIVEE: cmb = jcbPointArrivee; break;
		}
		cmb.removeAllItems();
		if (liste.size() > 0) {
			for (Iterator it = liste.iterator(); it.hasNext();) {
				cmb.addItem(it.next());
			}
		}
	}
	
	/**
	 * Changer texte bouton ok.
	 *
	 * @param texte the texte
	 */
	public void changerTexteBoutonOk(String texte) {
		jbOk.setText(texte);
	}

	/**
	 * Ajouter ecouteur au bouton ok.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonOk(ActionListener ecouteur) {
		jbOk.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom moins.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomMoins(ActionListener ecouteur) {
		jbZoomMoins.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom plus.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomPlus(ActionListener ecouteur) {
		jbZoomPlus.addActionListener(ecouteur);
	}

	/**
	 * Ajouter ecouteur au bouton zoom reel.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomReel(ActionListener ecouteur) {
		jbZoomReel.addActionListener(ecouteur);
	}

	/**
	 * Ajouter ecouteur au bouton zoom global.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomGlobal(ActionListener ecouteur) {
		jbZoomGlobal.addActionListener(ecouteur);	
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom gros plan.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomGrosPlan(ActionListener ecouteur) {
		jbZoomGrosPlan.addActionListener(ecouteur);	
	}
	
	/**
	 * Ajouter ecouteur au slider.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuSlider(ChangeListener ecouteur) {
		jsZoom.addChangeListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur ville depart.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurVilleDepart(ActionListener ecouteur) {
		jcbVilleDepart.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur rue depart.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurRueDepart(ActionListener ecouteur) {
		jcbRueDepart.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur ville arrivee.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurVilleArrivee(ActionListener ecouteur) {
		jcbVilleArrivee.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur rue arrivee.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurRueArrivee(ActionListener ecouteur) {
		jcbRueArrivee.addActionListener(ecouteur);
	}
	
	/**
	 * Ville deja presente.
	 *
	 * @param ville the ville
	 * @return true, if successful
	 */
	public boolean villeDejaPresente(String ville) {
		for(int i=0;i<jcbVilleDepart.getItemCount();i++){
			if(jcbVilleDepart.getItemAt(i).toString().equals(ville)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vider rue combo box.
	 *
	 * @param flag the flag
	 */
	public void viderRueComboBox(jcbFlag flag) {
		switch(flag){
		case ARRIVEE:
			jcbRueArrivee.removeAllItems();
			break;
		
		case DEPART:
			jcbRueDepart.removeAllItems();
			break;
			
		case BOTH:
			jcbRueDepart.removeAllItems();
			jcbRueArrivee.removeAllItems();
			break;
		}	
	}
	
	/**
	 * Sets the slider value.
	 *
	 * @param val the new slider value
	 */
	public void setSliderValue(int val){
		jsZoom.setValue(val);
	}
	
	/**
	 * Sets the icon zoom moins.
	 *
	 * @param icon the new icon zoom moins
	 */
	public void setIconZoomMoins(ImageIcon icon) {
		jbZoomMoins.setIcon(icon);
	}
	
	/**
	 * Sets the icon zoom plus.
	 *
	 * @param icon the new icon zoom plus
	 */
	public void setIconZoomPlus(ImageIcon icon) {
		jbZoomPlus.setIcon(icon);
	}
}
