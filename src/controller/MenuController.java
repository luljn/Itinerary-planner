package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import model.Application;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuController.
 */
@SuppressWarnings("serial")
//MouseInputListener interface utilise MouseMotionListener + MouseListener
public class MenuController implements ActionListener {
	
	/** The app. */
	private Application app;
	
	/**
	 * Instantiates a new menu controller.
	 *
	 * @param app the app
	 */
	public MenuController(Application app) {
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		JMenuItem selectedMenuItem = (JMenuItem) evt.getSource();
		String itemName = selectedMenuItem.getText();
		if (itemName.equals("Export Itinerary")) {
			app.saveExport();
		}
		// To change the current Map.
		if(itemName.equals("Change Map")){
			app.changeMap();
		}
		if(itemName.equals("Exit")){
			app.close();
		}
		if(itemName.equals("About")){
			app.about();
		}
		// Help me(To get help about the usage of the app).
		if(itemName.equals("Help me !")){
			app.helpMe();
		}
		if(itemName.equals("AntiAliasing")){
			app.changeAntiAliasing();
		}
		// To Hide (or see) the Infos Panel.
		if(itemName.equals("Hide or See Infos Panel")){
			app.hideOrSeeInfosPanel();
		}
		// To change Itinerary color.
		if(itemName.equals("Itinerary Color")){
			app.choixCouleur();
		}
		if(itemName.equals("IC - bleu")){
			app.afficherMenuContextuel();
		}
		if(itemName.equals("IC - rouge")){
			app.setItineraryColorToRed();
		}
		// To change starting point color.
		if(itemName.equals("SC - vert")){
			app.setStartingPointColorToGreen();
		}
		if(itemName.equals("SC - bleu")){
			app.setStartingPointColorToBlue();
		}
		if(itemName.equals("SC - rouge")){
			app.setStartingPointColorToRed();
		}
		// To change arrival point color.
		if(itemName.equals("AC - vert")){
			app.setArrivalPointColorToGreen();
		}
		if(itemName.equals("AC - bleu")){
			app.setArrivalPointColorToBlue();
		}
		if(itemName.equals("AC - rouge")){
			app.setArrivalPointColorToRed();
		}
	}
}