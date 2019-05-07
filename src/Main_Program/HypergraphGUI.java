package Main_Program;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> data;
	private JTextField textField_4;
	int K;
	int LR;
	int I;
	BigInteger count = BigInteger.valueOf(0);
	ArrayList<Integer> Ii = new ArrayList<Integer>();

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
		JButton btnNewButton = new JButton("Вычеслить сложность");
		
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

		Checkbox checkbox = new Checkbox("Сгенерировать случайные веса");
		checkbox.setState(true);
		checkbox.setFont(new Font("Dialog", Font.PLAIN, 18));
		checkbox.setBounds(32, 242, 287, 27);
		panel_1.add(checkbox);

		JButton button = new JButton("Сгенерировать шаблон EXCEL");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int _K = Integer.parseInt(textField.getText());
				int _LR = Integer.parseInt(textField_1.getText());
				int _I = Integer.parseInt(textField_2.getText());
				String _Ii = textField_3.getText();
				// Create Template!!!
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet("Sheet1");
				XSSFRow row = sheet.createRow(0);
				XSSFCell cell = row.createCell(0);
				cell.setCellValue("Количество критериев:");
				cell = row.createCell(1);
				cell.setCellValue(_K);

				row = sheet.createRow(1);
				cell = row.createCell(0);
				cell.setCellValue("Количество вершин типа L/R:");
				cell = row.createCell(1);
				cell.setCellValue(_LR);

				row = sheet.createRow(2);
				cell = row.createCell(0);
				cell.setCellValue("Количество вершин типа I:");
				cell = row.createCell(1);
				cell.setCellValue(_I);

				row = sheet.createRow(3);
				cell = row.createCell(0);
				cell.setCellValue("Размерность вершин I[i] (через запятую):");
				cell = row.createCell(1);
				cell.setCellValue(_Ii);
				btnNewButton.setEnabled(false);
				for (int i = 0, k = 1; k <= _K; i += 3, k++) {
					XSSFRow row2 = sheet.createRow(4 + i + 1);
					XSSFCell cell2 = row2.createCell(0);
					cell2.setCellValue("Веса:");
					XSSFRow row1 = sheet.createRow(4 + i);
					XSSFCell cell1 = row1.createCell(0);
					cell1.setCellValue("Критерий №" + (k));
					for (int l = 1, count = 1; l <= _LR; l++) {
						for (int r = 1; r <= _LR; r++) {
							for (int j = 1; j <= _I; j++, count++) {
								cell1 = row1.createCell(count);
								cell1.setCellValue(l + " " + r + " " + j);
								if (checkbox.getState()) {
									cell2 = row2.createCell(count);
									cell2.setCellValue((int) (Math.random() * 10000));
								}
							}
						}
					}
				}

				try {
					FileOutputStream fileOut = new FileOutputStream("input.xlsx");
					wb.write(fileOut);
					fileOut.close();
					wb.close();

					lblNewLabel.setText("Готово!");
					lblNewLabel.setForeground(new Color(34, 139, 34));
					lblNewLabel.setVisible(true);
				} catch (Exception e) {
					lblNewLabel.setText("Ошибка!");
					lblNewLabel.setForeground(new Color(255, 0, 0));
					lblNewLabel.setVisible(true);
				}
			}
		});
		button.setBounds(108, 275, 343, 33);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(button);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(227, 324, 105, 31);
		panel_1.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_1475742599721723");
		panel_2.setLayout(null);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(282, 21, 106, 20);
		panel_2.add(lblNewLabel_1);

		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {//Высчитать сложность

			@Override
			public void actionPerformed(ActionEvent e) {
				count=BigInteger.valueOf(0);
				recCount(new ArrayList<Integer>(Ii), new ArrayList<Integer>(), LR);
				BigInteger N = fact(BigInteger.valueOf(LR));
				N = N.multiply(count);
				textField_4.setText(N.toString());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(15, 61, 243, 29);
		panel_2.add(btnNewButton);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(273, 63, 269, 26);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		JButton button_1 = new JButton("Прочитать данные");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {// Парсинг данных
				try {
					XSSFWorkbook wb = new XSSFWorkbook(new File("input.xlsx"));
					XSSFSheet sheet = wb.getSheet("Sheet1");
					XSSFRow row = sheet.getRow(0);
					XSSFCell cell = row.getCell(1);
					K = (int) cell.getNumericCellValue();
					row = sheet.getRow(1);
					cell = row.getCell(1);
					LR = (int) cell.getNumericCellValue();
					row = sheet.getRow(2);
					cell = row.getCell(1);
					I = (int) cell.getNumericCellValue();
					row = sheet.getRow(3);
					cell = row.getCell(1);
					String strIi = cell.getStringCellValue();

					for (String c : strIi.split(",")) {
						Ii.add(Integer.parseInt(c));
					}

					data = new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>();// Выделили память
					for (int i = 0; i < K; i++) {
						data.add(new ArrayList<ArrayList<ArrayList<Integer>>>());
						for (int j = 0; j < LR; j++) {
							data.get(i).add(new ArrayList<ArrayList<Integer>>());
							for (int q = 0; q < LR; q++) {
								data.get(i).get(j).add(new ArrayList<Integer>());
								for (int p = 0; p < I; p++)
									data.get(i).get(j).get(q).add(0);
							}
						}
					}

					for (int i = 0, k = 0; k < K; i += 3, k++) {// Считываем данные
						row = sheet.getRow(4 + i + 1);
						for (int l = 0, count = 1; l < LR; l++) {
							for (int r = 0; r < LR; r++) {
								for (int j = 0; j < I; j++, count++) {
									cell = row.getCell(count);
									// System.out.print((int) cell.getNumericCellValue() + " ");
									data.get(k).get(l).get(r).set(j, (int) cell.getNumericCellValue());
								}
							}
						}
					}

					wb.close();
					lblNewLabel_1.setText("Готово!");
					lblNewLabel_1.setForeground(new Color(34, 139, 34));
					lblNewLabel_1.setVisible(true);
					btnNewButton.setEnabled(true);
				} catch (Exception e) {
					lblNewLabel_1.setText("Ошибка!");
					lblNewLabel_1.setForeground(new Color(255, 0, 0));
					lblNewLabel_1.setVisible(true);
				}

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(15, 16, 215, 29);
		panel_2.add(button_1);

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

	void recCount(ArrayList<Integer> a, ArrayList<Integer> v, int k) {
		ArrayList<Integer> tempA = new ArrayList<Integer>(a);
		ArrayList<Integer> tempV = new ArrayList<Integer>(v);

		if (k > 0) {
			for (int i = 0; i < I; i++) {
				if (a.get(i) > 0) {
					tempA.set(i, tempA.get(i) - 1);
					tempV.add(i);
					recCount(tempA, tempV, k - 1);
					tempA.clear();
					tempA.addAll(a);
					tempV.clear();
					tempV.addAll(v);
				}
			}
		} else {
			count = count.add(BigInteger.valueOf(1));
			return;
		}
		return;
	}

	BigInteger fact(BigInteger x) {
		if (!x.equals(BigInteger.valueOf(0))) {
			return x.multiply(fact(x.subtract(BigInteger.valueOf(1))));
		} else
			return BigInteger.valueOf(1);
	}

}
