import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class ShutDown {

	private JFrame frame;

	private JPanel panelDate;
	private ActionPanel panelAction;
	private JPanel panelInit;

	@SuppressWarnings("unused")
	private Controller controller;
	private Person person;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShutDown window = new ShutDown();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ShutDown() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_76321823625830");
		panel.setLayout(new CardLayout(0, 0));
		
		panelInit = new InitPanel();
		panel.add(panelInit, "name_76333358364454");
		
		panelAction = new ActionPanel();
		panel.add(panelAction, "name_76375958834252");
		
		panelDate = new PanelDate();
		panel.add(panelDate, "name_76382059083606");
	}
	
	public void schimbaPanel(int index){
		panelInit.setVisible(false);
		panelAction.setVisible(false);
		panelDate.setVisible(false);
		switch(index){
			case 1:panelInit.setVisible(true);
					((InitPanel) panelInit).scrieWel(person);
				break;
			case 2:panelAction.setVisible(true);
				break;
			case 3:panelDate.setVisible(true);
				break;
			default:
				break;
		}
		 
	}

	public void setController(Controller controller) {
		this.controller=controller;
		((InitPanel) panelInit).setController(controller);
		((PanelDate) panelDate).setController(controller);
	}
	public static int minToSec(int min){
		return min*60;
	}
	public static String secToMin(int sec){
		String res=""+sec/60+":";
		res+=""+sec%60;
		return res;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	public void scrieTimpV(int currentTime) {
		panelAction.scrieTimpV(secToMin(currentTime));
		
	}

	public void ascundeTimp() {
		panelAction.ascundeMin();
		
	}

	public void scrieTimpR(int currentTime) {
		panelAction.scrieTimpR(secToMin(currentTime));
		
	}

	public void scrieTimpP(int currentTime) {
		panelAction.scrieTimpP(secToMin(currentTime));
		
	}

	public void scrieTimpG(int currentTime) {
		panelAction.scrieTimpG(secToMin(currentTime));
		
	}

	public void scrieMesaj(String string) {
		panelAction.scrieMesaj(string);
		
	}

}
