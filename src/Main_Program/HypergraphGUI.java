package Main_Program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import java.awt.CardLayout;

public class HypergraphGUI {

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHyperph = new JFrame();
		frmHyperph.setTitle("Hyperaph!");
		frmHyperph.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\USER\\Desktop\\Eclipse-worksplace\\git\\Hypergraph\\icon.png"));
		frmHyperph.setResizable(false);
		frmHyperph.setBounds(100, 100, 563, 688);
		frmHyperph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHyperph.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmHyperph.getContentPane().add(panel, "name_1147588816189908");
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Основные параметры Гиперграфа:");
		label_1.setBounds(93, 338, 371, 28);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Количество критериев:");
		label_2.setBounds(15, 526, 214, 25);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Количество вершин типа L/R:");
		label_3.setBounds(15, 382, 273, 25);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Количество вершин типа I:");
		label_4.setBounds(93, 465, 250, 25);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Размерность вершин I[i] (через запятую):");
		label_5.setBounds(46, 542, 390, 25);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(343, 553, 176, 31);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(353, 506, 176, 31);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(303, 382, 176, 31);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 492, 176, 31);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JButton button = new JButton("Сгенерировать шаблон EXCEL");
		button.setBounds(134, 583, 309, 33);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Eclipse-worksplace\\git\\Hypergraph\\hyper.jpg"));
		label.setBounds(105, 16, 331, 288);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 320, 557, 2);
		panel.add(separator);
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
