import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;


public class ActionPanel extends JPanel {
	
	private JLabel lblMinsec;
	private JLabel label;
	/**
	 * Create the panel.
	 */
	public ActionPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		label = new JLabel("<dinamic>");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		label.setBounds(29, 42, 379, 50);
		add(label);
		
		lblMinsec = new JLabel("MIN:SEC");
		lblMinsec.setForeground(new Color(255, 165, 0));
		lblMinsec.setFont(new Font("Showcard Gothic", Font.BOLD, 55));
		lblMinsec.setBounds(53, 114, 197, 130);
		add(lblMinsec);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBackground(new Color(0, 0, 0));
		btnStop.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		btnStop.setForeground(new Color(153, 50, 204));
		btnStop.setBounds(287, 192, 121, 50);
		add(btnStop);

	}
	public void ascundeMin(){
		lblMinsec.setVisible(false);
	}
	public void scrieTimpP(String secToMin) {
		lblMinsec.setForeground(new Color(255, 69, 0));
		lblMinsec.setVisible(true);
		lblMinsec.setText(secToMin);
	}
	public void scrieTimpR(String secToMin) {
		lblMinsec.setForeground(new Color(255, 0, 0));
		lblMinsec.setVisible(true);
		lblMinsec.setText(secToMin);
		
	}
	public void scrieTimpV(String secToMin) {
		lblMinsec.setForeground(new Color(0, 255, 0));
		lblMinsec.setVisible(true);
		lblMinsec.setText(secToMin);
	}
	public void scrieTimpG(String secToMin) {
		lblMinsec.setForeground(new Color(255, 165, 0));
		lblMinsec.setVisible(true);
		lblMinsec.setText(secToMin);
		
	}
	public void scrieMesaj(String string) {
		label.setText(string);		
	}
}
