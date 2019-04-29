package Main_Program;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;


public class ExampleCard {
	
	public class Pic{
		private JFrame frame;
		
		Pic(){
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
		}
	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleCard window = new ExampleCard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExampleCard() {
		initialize();
		Pic window2 = new Pic();
		window2.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 35, 428, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "Генерация");
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Генерация");
		label.setBounds(126, 72, 125, 20);
		panel_1.add(label);
		
		JRadioButtonMenuItem rdbtnmntmFgdf = new JRadioButtonMenuItem("fgdf");
		rdbtnmntmFgdf.setBounds(0, 108, 173, 31);
		panel_1.add(rdbtnmntmFgdf);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "Проверка");
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Проверка");
		label_1.setBounds(163, 74, 70, 20);
		panel_2.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Генерация", "Проверка"}));
		comboBox.setBounds(289, 0, 109, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout ());
			    cl.show (panel, (String)e.getItem());
				
			}
		});
	}
}
