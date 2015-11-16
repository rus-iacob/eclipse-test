import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InitPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	 String[] boy ={"boss","smechers","smechere"};
	 String[] girl={"lady","frumoaso"};
	 String[] salut={"Hello","Buna","Salut","Hi","Servus"};
	 private JTextField textField;
	 private Controller controller;
	 private JLabel label;
	 
	public InitPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		label = new JLabel("<dinamic>");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(41, 40, 257, 39);
		add(label);
		
		JLabel lblAlegeOptiuneaDorita = new JLabel("Alege optiunea dorita:");
		lblAlegeOptiuneaDorita.setForeground(Color.LIGHT_GRAY);
		lblAlegeOptiuneaDorita.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlegeOptiuneaDorita.setBounds(54, 90, 189, 24);
		add(lblAlegeOptiuneaDorita);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		Vector<String> s= new Vector<String>();
		s.add("Inchidere");
		s.add("Repaus");
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>(s);
		comboBox.setModel( dcm );
		comboBox.setBackground(Color.GRAY);
		comboBox.setBounds(268, 90, 136, 24);
		add(comboBox);
		
		JLabel lblAlegeTimpul = new JLabel("Alege Timpul:");
		lblAlegeTimpul.setForeground(Color.LIGHT_GRAY);
		lblAlegeTimpul.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlegeTimpul.setBounds(54, 127, 189, 29);
		add(lblAlegeTimpul);
		
		textField = new JTextField();
		textField.setBounds(268, 136, 92, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.startThread(comboBox.getSelectedIndex(),Integer.parseInt(textField.getText()));
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnStart.setForeground(Color.PINK);
		btnStart.setBackground(Color.LIGHT_GRAY);
		btnStart.setBounds(141, 191, 157, 39);
		add(btnStart);

	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public void scrieWel(Person person){
		String mesaj=""+salut[(int)(Math.random() * 4)]+" ";
		int aux=(int)(Math.random() * 2);
		if (aux==0) mesaj+=person.getNume();
		else {
			if(person.isSex()==true) 
				mesaj+=boy[(int)(Math.random() * 2)];
			else
				mesaj+=girl[(int)(Math.random() * 2)];
		}
		label.setText(mesaj);
	}
	

}
