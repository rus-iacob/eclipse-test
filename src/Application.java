import javax.swing.SwingUtilities;


public class Application {
/**
 * Metoda main care porneste aplicatia
 * @param args
 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runApp();
			}
		});
	}
	/**
	 * Metoda statica care instantiaza Contolerul aplicatiei si Interfata
	 */
	public static void runApp() {
		
		ShutDown view = new ShutDown();
		Controller controller = new Controller(view);
		view.setController(controller);
	}

}