package controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Application;

// TODO: Auto-generated Javadoc
/**
 * The Class SliderController.
 */
public class SliderController implements ChangeListener {

	/** The app. */
	private Application app;
	
	/**
	 * Instantiates a new slider controller.
	 *
	 * @param app the app
	 */
	public SliderController(Application app) {
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	public void stateChanged(ChangeEvent evt) {
		JSlider slider = (JSlider) evt.getSource();
		float val = (float)slider.getValue()/100;
		float oldVal = app.getZoom();
		app.modifyZoom(val - oldVal);
	}

}
