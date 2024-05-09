package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
// TODO: Auto-generated Javadoc


/**
 * The Class AppWindow.
 */
@SuppressWarnings("serial")
public class AppWindow extends JFrame{

	//couleur du tracé ( commun a Carte et Contrôle )
	/** The Constant DefaultItineraireColor. */
	public final static Color DefaultItineraireColor = Color.GREEN;
	
	/** The CONTROLE s_ hauteur. */
	private final int CONTROLES_HAUTEUR = 150;
	
	/** The INFO s_ largeur. */
	private final int INFOS_LARGEUR = 250;
	
	// Dimensions de l'écran
	/** The dim ecran. */
	private Dimension dimEcran;
    
    // Dimensions utilisables du bureau
    /** The largeur util. */
    private int largeurUtil;
    
    /** The hauteur util. */
    private int hauteurUtil;
	
	// Pannels
	/** The pnl vue. */
	private PanelView pnlVue;
	
	/** The pnl ctrl. */
	private PanelControls pnlCtrl;
	
	/** The pnl info. */
	private PanelInformations pnlInfo;
	
	/** The menu bar. */
	private MenuBar menuBar;
	
	
	// Bordure des Panels
	/** The raisedbevel. */
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	
	/** The loweredbevel. */
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	/** The coumpound border. */
	Border coumpoundBorder = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
	
	/**
	 * Instantiates a new app window.
	 *
	 * @param lienCarte the lien carte
	 * @param su the su
	 */
	public AppWindow(String lienCarte, String su) {	
		super("Itinerary planner");
		
		// Recuperer l'apparence par defaut du systeme
		String nativeLF = UIManager.getSystemLookAndFeelClassName();
		
		// Installation de l'apparence
		try {
			UIManager.setLookAndFeel(nativeLF);
		} 
		catch (InstantiationException e) {}
		catch (ClassNotFoundException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		catch (IllegalAccessException e) {}
		
		// Recuperation de la taille de l'ecran
        Toolkit tk = Toolkit.getDefaultToolkit();
        dimEcran = tk.getScreenSize();
        
        // Recuperation des rebords
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration()); 
        
        // Calcul de la taille utilisable sur le bureau
        largeurUtil = (int)(dimEcran.getWidth()-insets.left-insets.right); 
        hauteurUtil = (int)(dimEcran.getHeight()-insets.top-insets.bottom); 
        setPreferredSize(new Dimension(largeurUtil,hauteurUtil));
        
        int h,l;
        
		//Creation of the menu bar
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		//Temp
		//MenuControler menuControler = new MenuControler();
		//fileExportItinerary.addActionListener(menuControler);
		
		// Création du PanelControles
        h = CONTROLES_HAUTEUR;
        l = largeurUtil;
		pnlCtrl = new PanelControls();
		pnlCtrl.setPreferredSize(new Dimension(l, h));
		getContentPane().add(pnlCtrl ,BorderLayout.NORTH);
		
		// Création de la carte
		Map carte = new Map(lienCarte, 40);
		
		// Création du PanelVue avec la carte
		h = hauteurUtil - CONTROLES_HAUTEUR;
		l = largeurUtil - INFOS_LARGEUR;
		pnlVue = new PanelView(carte);
		pnlVue.setPreferredSize(new Dimension(l, h));
		pnlVue.setBorder(coumpoundBorder);
		getContentPane().add(pnlVue, BorderLayout.CENTER);
		
		// Création du PanelInformations
		l = INFOS_LARGEUR;
		h = hauteurUtil;
		pnlInfo = new PanelInformations(l, h, su);
		pnlInfo.setPreferredSize(new Dimension(l,h));
		getContentPane().add(pnlInfo ,BorderLayout.EAST);
		
		// Mise à la taille du bureau pour le mode fenêtre normal
		pack();
		setLocation(insets.left, insets.top);
		
		// Mise en mode fenetre aggrandie
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Opération de fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Gets the panneau controles.
	 *
	 * @return the panneau controles
	 */
	public PanelControls getPanneauControles() {
		return pnlCtrl;
	}

	/**
	 * Gets the panneau infos.
	 *
	 * @return the panneau infos
	 */
	public PanelInformations getPanneauInfos() {
		return pnlInfo;
	}

	/**
	 * Gets the panneau vue.
	 *
	 * @return the panneau vue
	 */
	public PanelView getPanneauVue() {
		return pnlVue;
	}
	
	/**
	 * Gets the menu bar items.
	 *
	 * @return the menu bar items
	 */
	public JMenuItem[] getMenuBarItems(){
		return menuBar.getItems();
	}
	
}
