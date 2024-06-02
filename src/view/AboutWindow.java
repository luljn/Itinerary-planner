package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AboutWindow extends JOptionPane {

		public AboutWindow(){}

		public void showMessageAbout(JFrame frame){

			JOptionPane.showMessageDialog(frame, "Bienvenue sur Itinerary planner, votre outil de calcul d'itinéraire dans la region de belfort.", "Itinerary planner", JOptionPane.INFORMATION_MESSAGE);
		}
}
