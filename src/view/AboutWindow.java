package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AboutWindow extends JFrame {

	private JPanel jpAbout;
	private JLabel bleh;
	
		public AboutWindow(){
			super("About");
			
			String nativeLF = UIManager.getSystemLookAndFeelClassName();
			try {
				UIManager.setLookAndFeel(nativeLF);
			} 
			catch (InstantiationException e) {}
			catch (ClassNotFoundException e) {}
			catch (UnsupportedLookAndFeelException e) {}
			catch (IllegalAccessException e) {}
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
			setPreferredSize(new Dimension(800,600));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			jpAbout = new JPanel();
		
			bleh = new JLabel("Coucou");
			jpAbout.add(bleh);
			add(jpAbout);
			
			
		}
}
