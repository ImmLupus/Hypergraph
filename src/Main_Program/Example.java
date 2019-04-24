package Main_Program;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Example extends Frame {

	Example() {
		// setLayout(new GridLayout(1, 5));
		// setLayout(new FlowLayout());
		setLayout(null);

		Button b = new Button("Button");
		b.setBounds(50, 70, 50, 20);
		add(b);

		JLabel l = new JLabel("Label", SwingConstants.CENTER);
		l.setBounds(110, 70, 50, 20);
		add(l);

		JLabel ent = new JLabel("", SwingConstants.CENTER); // Enter
		ent.setBounds(240, 100, 100, 20);
		add(ent);

		Checkbox c = new Checkbox("Choice");
		c.setBounds(170, 70, 60, 20);
		add(c);

		Choice ch = new Choice();
		for (int i = 1; i < 6; i++) {
			ch.add(i + " ");
		}
		ch.setBounds(240, 70, 40, 20);
		add(ch);

		TextField tf = new TextField("");
		tf.setBounds(50, 100, 100, 20);
		add(tf);

		setSize(400, 200);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);

		tf.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyText(e.getKeyCode()) == "Enter")
					ent.setText(tf.getText());
			}

		});
		
		Graphics g = getGraphics();
	    g.drawImage(new ImageIcon("image.jpg").getImage(), 0, 0, 300, 300, null);

	}

	public static void main(String[] args) {
		Example main = new Example();
	}
}