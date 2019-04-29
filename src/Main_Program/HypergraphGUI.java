package Main_Program;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Main_Program.ExampleCard.Pic;
import javax.swing.ImageIcon;

public class HypergraphGUI {

	public class Pic {
		private JFrame frame;

		Pic() {
			frame = new JFrame();
			frame.setTitle("Пример");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setBounds(700, 100, 380, 350);

			JLabel label_5 = new JLabel();
			frame.getContentPane().add(label_5);
			label_5.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Eclipse-worksplace\\git\\Hypergraph\\hyper.jpg"));
			label_5.setBounds(0, 0, 380, 294);
		}
	}

	private JFrame frmHyperph;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HypergraphGUI window = new HypergraphGUI();
					window.frmHyperph.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HypergraphGUI() {
		initialize();
		Pic window2 = new Pic();
		window2.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHyperph = new JFrame();
		frmHyperph.setTitle("Hyperaph!");
		frmHyperph.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\Desktop\\Eclipse-worksplace\\git\\Hypergraph\\icon.png"));
		frmHyperph.setResizable(false);
		frmHyperph.setBounds(100, 100, 563, 688);
		frmHyperph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHyperph.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 557, 615);
		frmHyperph.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_1475742584085726");
		panel_1.setLayout(null);

		JLabel label = new JLabel("Основные параметры Гиперграфа:");
		label.setBounds(93, 5, 371, 28);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_1.add(label);

		JLabel label_1 = new JLabel("Количество критериев:");
		label_1.setBounds(32, 38, 214, 25);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Количество вершин типа L/R:");
		label_2.setBounds(32, 82, 273, 25);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Количество вершин типа I:");
		label_3.setBounds(32, 123, 250, 25);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Размерность вершин I[i] (через запятую):");
		label_4.setBounds(32, 164, 390, 25);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label_4);

		textField = new JTextField();
		textField.setBounds(261, 35, 89, 31);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(320, 79, 89, 31);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(297, 120, 89, 31);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(32, 205, 499, 31);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		panel_1.add(textField_3);

		JButton button = new JButton("Сгенерировать шаблон EXCEL");
		button.setBounds(107, 252, 343, 33);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_1475742599721723");
		panel_2.setLayout(null);

		ButtonGroup BG = new ButtonGroup();

		JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem("Работа");
		radioButtonMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		radioButtonMenuItem_1.setBounds(172, 0, 138, 31);
		frmHyperph.getContentPane().add(radioButtonMenuItem_1);

		JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("Генерация");
		radioButtonMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		radioButtonMenuItem.setSelected(true);
		radioButtonMenuItem.setBounds(0, 0, 155, 31);
		frmHyperph.getContentPane().add(radioButtonMenuItem);

		BG.add(radioButtonMenuItem_1);
		BG.add(radioButtonMenuItem);

		radioButtonMenuItem_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				if (radioButtonMenuItem_1.isSelected())
					cl.show(panel, "name_1475742599721723");
			}
		});
		radioButtonMenuItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				if (radioButtonMenuItem.isSelected())
					cl.show(panel, "name_1475742584085726");
			}
		});

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println(e.toString());
		}
	}
}
