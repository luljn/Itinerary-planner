package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AboutWindow extends JOptionPane {

	public AboutWindow(){}

	public void showMessageAbout(JFrame frame){

		JOptionPane.showMessageDialog(frame, "Bienvenue sur Itinerary planner, votre outil de calcul d'itinéraire(s) dans la region de belfort.", "Itinerary planner", JOptionPane.INFORMATION_MESSAGE);
	}
}
