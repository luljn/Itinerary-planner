package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseListener;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelView.
 */
@SuppressWarnings("serial")
public class PanelView extends JScrollPane {
	
	/** The carte. */
	private Map carte;

	/**
	 * Instantiates a new panel view.
	 *
	 * @param isCarte the is carte
	 */
	public PanelView(Map isCarte) {
		super(isCarte);
		carte = isCarte;
		setWheelScrollingEnabled(false);
		getViewport().setBackground(Color.white);
	}

	/**
	 * Gets the carte.
	 *
	 * @return the carte
	 */
	public Map getCarte() {
		return carte;
	}
	
	/**
	 * Deplacer carte.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void deplacerCarte(int x, int y){
		Point positionCourante = getViewport().getViewPosition();
		int newX = (int)positionCourante.getX() + x;
		int newY = (int)positionCourante.getY() + y;
	
		newX = resituerX(newX);
		newY = resituerY(newY);
		
		getViewport().setViewPosition(new Point(newX, newY));
	}
	
	// Ces deux classes repositionnent X et Y pour ne pas afficher en dehors de la carte
	/**
	 * Resituer x.
	 *
	 * @param X the x
	 * @return the int
	 */
	public int resituerX(int X){
		int ancreMaxX = (int) (carte.getWidth() - getViewport().getSize().getWidth());
		if(X > ancreMaxX) X = ancreMaxX;
		if(X < 0) X = 0;
		return X;
	}
	
	/**
	 * Resituer y.
	 *
	 * @param Y the y
	 * @return the int
	 */
	public int resituerY(int Y){
		int ancreMaxY = (int) (carte.getHeight() - getViewport().getSize().getHeight());
		if(Y > ancreMaxY) Y = ancreMaxY;
		if(Y < 0) Y = 0;
		return Y;
	}
	
	/**
	 * Ajouter ecouteur scroll bar.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurScrollBar(MouseListener ecouteur) {
		this.getHorizontalScrollBar().addMouseListener(ecouteur);
		this.getVerticalScrollBar().addMouseListener(ecouteur);
	}
}
