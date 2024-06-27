import model.Application;;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 *
 * @author Skeard
 */
public class Main {

    // private static Application app;
	
	/**
	 * Creates the and show gui.
	 */
	public static void createAndShowGUI() {
		new Application("belfort_centre/belfort_centre_1708_1572_SetOfStreets_version_GIS.xml");
	}
	
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}