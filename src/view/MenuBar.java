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
	private JMenu fileMenu, viewMenu, help, colorManagmentMenu;
	
	/** The exit. */
	private JMenuItem fileExportItinerary, fileChangeMap, about, helpitem, exit, minimizePanelInfos, changeItineraryColor,
	                  changeStartingPointColor, changeArrivalPointColor, ItineraryColorOption1,
					  ItineraryColorOption2, ItineraryColorOption3; 
	
	/** The view anti aliasing. */
	private JCheckBoxMenuItem viewAntiAliasing;
	
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

		/* */

		ItineraryColorOption1 = new JMenuItem("IC - vert");
        ItineraryColorOption2 = new JMenuItem("IC - bleu");
		ItineraryColorOption3 = new JMenuItem("IC - rouge");

		changeItineraryColor.add(ItineraryColorOption1);
		changeItineraryColor.add(ItineraryColorOption2);
		changeItineraryColor.add(ItineraryColorOption3);

		// changeArrivalPointColor.add(new JMenuItem("rouge"));
		// changeArrivalPointColor.add(new JMenuItem("vert"));

		// changeStartingPointColor.add(new JMenuItem("rouge"));
		// changeStartingPointColor.add(new JMenuItem("vert"));
		/* */
		
		help = new JMenu("?");
		helpitem = new JMenuItem("Help me !");
		about = new JMenuItem("About");
		help.add(helpitem);
		help.add(about);
		
		add(fileMenu);
		add(viewMenu);
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
			                   ItineraryColorOption1, ItineraryColorOption2, ItineraryColorOption3};
		
	}
}
