package controller;

import javax.swing.*;
import java.awt.event.*;

import model.Application;

// TODO: Auto-generated Javadoc
/**
 * The Class ScrollBarController.
 */
public class ScrollBarController implements MouseListener, KeyListener{

	/** The app. */
	private Application app;

	private boolean isShiftPressed;
	
	/**
	 * Instantiates a new scroll bar controller.
	 *
	 * @param app the app
	 */
	public ScrollBarController(Application app){
		this.app = app;
		this.isShiftPressed = false;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		// app.updateCentre();
		if(app.getModeUtilisation() == "Utilisation"){
			app.updateCentre();
			app.chercherItineraire();
			app.getFenetre().repaint();
			app.getFenetre().revalidate();
		}
		if(app.getModeUtilisation() == "Edition"){
			if (this.isShiftPressed && SwingUtilities.isLeftMouseButton(e)) {
                app.getReseauRoutier().addPointToGraph(app.getFichierXML(), 7777777, 100.0, 100.0);
            }
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// app.updateCentre();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// app.updateCentre();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// app.updateCentre();
	}

	//update le centre apres un deplacement a partir de la Scroll Bar
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		app.updateCentre();
	}
	
	@Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.isShiftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.isShiftPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Non utilisé, mais doit être implémenté
    }

}