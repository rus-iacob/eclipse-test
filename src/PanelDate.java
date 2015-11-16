import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelDate extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<String> comboBox;
	private JButton btnGata;
	private Controller controller;
	
	/**
	 * Create the panel.
	 */
	public PanelDate() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblDateUtilizator = new JLabel("Date utilizator:");
		lblDateUtilizator.setForeground(Color.CYAN);
		lblDateUtilizator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblDateUtilizator.setBounds(116, 55, 221, 37);
		add(lblDateUtilizator);
		
		JLabel lblNewLabel = new JLabel("Nume:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(62, 118, 89, 35);
		add(lblNewLabel);
		
		JLabel lblSex = new JLabel("Sex:\r\n");
		lblSex.setForeground(Color.LIGHT_GRAY);
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSex.setBounds(62, 164, 89, 37);
		add(lblSex);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.GRAY);
		textField.setBounds(139, 118, 118, 30);
		add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.GRAY);
		comboBox.setBounds(139, 164, 118, 31);
		add(comboBox);
		
		Vector<String> s= new Vector<String>();
		s.add("Masculin");
		s.add("Feminin");
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>(s);
		comboBox.setModel( dcm );
		
		btnGata = new JButton("Gata");
		btnGata.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				controller.faSerializarea(comboBox.getSelectedIndex(),textField.getText());
			}
		});
		btnGata.setForeground(Color.PINK);
		btnGata.setBackground(Color.BLACK);
		btnGata.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGata.setBounds(231, 216, 89, 35);
		add(btnGata);

	}
	public void setController(Controller controller){
		this.controller=controller;
	}
	
}
