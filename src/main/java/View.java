import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

class View extends JFrame {

	public JPanel panel;
	public JButton adunare = new JButton("Adunare");
	public JButton scadere = new JButton("Scadere");
	public JButton inmultire = new JButton("Inmultire");
	public JButton derivare = new JButton("Derivare");
	public JButton integrare = new JButton("Integrare");
	public JButton clear = new JButton("Stergere");

	public JTextField polinom1 = new JTextField("", 20);
	public JTextField polinom2 = new JTextField("", 20);
	public JTextField rezultat = new JTextField("", 20);
	public JLabel pol1 = new JLabel("Polinom 1:");
	public JLabel pol2 = new JLabel("Polinom 2:");
	public JLabel rez = new JLabel("Rezultat:");
	public JLabel spatiu = new JLabel("       ");

	Controller controller = new Controller(this);

	
	public View () {
		JFrame frame = new JFrame("Polinom calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 320);
		
		panel = new JPanel();
		JPanel p0 = new JPanel();

		JPanel p1 = new JPanel();
		p1.add(pol1);
		p1.add(polinom1);
		p1.add(spatiu);
		p1.add(pol2);
		p1.add(polinom2);

		JPanel p2 = new JPanel();
		p2.add(adunare);
		p2.add(scadere);
		p2.add(inmultire);
		p2.add(derivare);
		p2.add(integrare);
		p2.add(clear);

		JPanel p3 = new JPanel();
		p3.add(rez);
		p3.add(rezultat);

		panel.add(p0);
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);


		clear.addActionListener(controller);
		adunare.addActionListener(controller);
		scadere.addActionListener(controller);
		inmultire.addActionListener(controller);
		derivare.addActionListener(controller);
		integrare.addActionListener(controller);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.setVisible(true);
		frame.setContentPane(panel);
	}

	public String getPol1() {
		return polinom1.getText();
	}

	public String getPol2() {
		return polinom2.getText();
	}

	public void setRezultat(String rez) {
		rezultat.setText(rez);
	}

	public void clearText() {
		polinom1.setText("");
		polinom2.setText("");
		rezultat.setText("");
	}
}