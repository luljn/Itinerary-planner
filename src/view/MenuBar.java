package view;


import java.lang.reflect.Array;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuBar.
 */
public class MenuBar extends JMenuBar {
	
	/** The help. */
	private JMenu fileMenu, viewMenu, help, colorManagmentMenu, mode;
	
	/** The exit. */
	private JMenuItem fileExportItinerary, fileChangeMap, about, helpitem, exit, minimizePanelInfos, changeItineraryColor,
	                  changeStartingPointColor, changeArrivalPointColor, ItineraryColorOption1,
					  ItineraryColorOption2, ItineraryColorOption3, StartingPointColor1, StartingPointColor2, StartingPointColor3,
					  ArrivalPointColor1, ArrivalPointColor2, ArrivalPointColor3; 
	
	/** The view anti aliasing. */
	private JCheckBoxMenuItem viewAntiAliasing, utilisationMode, editionMode;
	
	/**
	 * Instantiates a new menu bar.
	 */
	public MenuBar(){
		super();

		fileMenu = new JMenu("File");
		exit = new JMenuItem("Exit");
		fileExportItinerary = new JMenuItem("Export Itinerary");
		fileChangeMap = new JMenuItem("Change Map");		
		fileMenu.add(fileExportItinerary);
		fileMenu.add(fileChangeMap);
		fileMenu.add(exit);
		
		
		viewMenu = new JMenu("View");
		viewAntiAliasing = new JCheckBoxMenuItem("AntiAliasing");
		minimizePanelInfos = new JMenuItem("Hide or See Infos Panel");
		// minimizePanelInfos.addActionListener(null);
		viewAntiAliasing.setState(true);
		viewMenu.add(viewAntiAliasing);
		viewMenu.add(minimizePanelInfos);

		// The menu to manage(change) the colors of map components.
		colorManagmentMenu = new JMenu("Colors");
		changeItineraryColor = new JMenu("Itinerary Color");
		changeStartingPointColor = new JMenu("Starting Point Color");
		changeArrivalPointColor = new JMenu("Arrival Point Color");
		colorManagmentMenu.add(changeItineraryColor);
		colorManagmentMenu.add(changeStartingPointColor);
		colorManagmentMenu.add(changeArrivalPointColor);

		/* 
		 * Colors options
		*/

		// Itinerary
		ItineraryColorOption1 = new JMenuItem("IC - vert");
        ItineraryColorOption2 = new JMenuItem("IC - bleu");
		ItineraryColorOption3 = new JMenuItem("IC - rouge");

		changeItineraryColor.add(ItineraryColorOption1);
		changeItineraryColor.add(ItineraryColorOption2);
		changeItineraryColor.add(ItineraryColorOption3);

		// Arrival point
		ArrivalPointColor1 = new JMenuItem("AC - rouge"); 
		ArrivalPointColor2 = new JMenuItem("AC - vert"); 
		ArrivalPointColor3 = new JMenuItem("AC - bleu");

		changeArrivalPointColor.add(ArrivalPointColor1);
		changeArrivalPointColor.add(ArrivalPointColor2);
		changeArrivalPointColor.add(ArrivalPointColor3);

		// Starting point
		StartingPointColor1 = new JMenuItem("SC - bleu"); 
		StartingPointColor2 = new JMenuItem("SC - rouge");
		StartingPointColor3 = new JMenuItem("SC - vert");

		changeStartingPointColor.add(StartingPointColor1);
		changeStartingPointColor.add(StartingPointColor2);
		changeStartingPointColor.add(StartingPointColor3);
		/* */
		
		help = new JMenu("?");
		helpitem = new JMenuItem("Help me !");
		about = new JMenuItem("About");
		help.add(helpitem);
		help.add(about);

		/*
		 * Mode (utilisation or edition)
		 */

		mode = new JMenu("Mode");
		ButtonGroup group = new ButtonGroup(); // To select one option at a time.
		utilisationMode = new JCheckBoxMenuItem("Utilisation");
		editionMode = new JCheckBoxMenuItem("Edition");
		group.add(utilisationMode);
		group.add(editionMode);
		utilisationMode.setState(true);
		mode.add(utilisationMode);
		mode.add(editionMode);
		
		add(fileMenu);
		add(viewMenu);
		add(mode);
		add(colorManagmentMenu);
		add(help);
	}
	
	/**
	 * Gets the export item.
	 *
	 * @return the export item
	 */
	public JMenuItem getExportItem(){
		return fileExportItinerary;
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public JMenuItem[] getItems(){
		return new JMenuItem[]{fileExportItinerary, fileChangeMap, viewAntiAliasing, minimizePanelInfos, about, helpitem, exit, 
			                   ItineraryColorOption1, ItineraryColorOption2, ItineraryColorOption3, StartingPointColor1, 
							   StartingPointColor2, StartingPointColor3, ArrivalPointColor1, ArrivalPointColor2, ArrivalPointColor3};
		
	}
}
