package Main_Program;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.org.apache.bcel.internal.generic.SWAP;

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
			label_5.setIcon(new ImageIcon("hyper.jpg"));
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
	static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> data;
	static int K;
	static int LR;
	static int I;
	static ArrayList<Integer> Ii = new ArrayList<Integer>();
	JProgressBar progressBar = new JProgressBar();
	JLabel lblNewLabel_2;
	static ArrayList<ArrayList<Integer>> vseI = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> resultVec = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> resultLR = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> resultI = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> max = new ArrayList<Integer>();
	static ArrayList<Integer> min = new ArrayList<Integer>();
	
	static int max_progress = 10000;

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
		JButton btnNewButton = new JButton("Вычислить");
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 18));

		frmHyperph = new JFrame();
		frmHyperph.setTitle("Hypergraph!");
		frmHyperph.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frmHyperph.setResizable(false);
		frmHyperph.setBounds(100, 100, 563, 683);
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
			public void mouseReleased(MouseEvent arg0) { // Создания шаблона в excel
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
					btnNewButton.setEnabled(false);
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
		btnNewButton.addActionListener(new ActionListener() {// Высчитать сложность
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> a = new ArrayList<Integer>(Ii);
				difLR(LR);
				difI(a, new ArrayList<Integer>(), LR);

				new Processing(progressBar, textArea, lblNewLabel_2).execute();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(15, 61, 138, 29);
		panel_2.add(btnNewButton);

		JButton button_1 = new JButton("Прочитать данные");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {// Парсинг данных
				progressBar.setValue(0);
				vseI.clear();
				resultVec.clear();
				resultI.clear();
				resultLR.clear();
				max.clear();
				min.clear();

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
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("");
		progressBar.setMaximum(max_progress);

		progressBar.setBounds(168, 61, 374, 29);
		panel_2.add(progressBar);

		textArea.setBounds(15, 96, 532, 509);
		panel_2.add(textArea);

		lblNewLabel_2 = new JLabel("00:00");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(447, 17, 77, 29);
		panel_2.add(lblNewLabel_2);

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

	void difLR(int n) {
		
	}

	void difI(ArrayList<Integer> a, ArrayList<Integer> v, int k) {
		ArrayList<Integer> tempA = new ArrayList<Integer>(a);
		ArrayList<Integer> tempV = new ArrayList<Integer>(v);

		if (k > 0) {
			for (int i = 0; i < I; i++) {
				if (a.get(i) > 0) {
					tempA.set(i, tempA.get(i) - 1);
					tempV.add(i);
					difI(tempA, tempV, k - 1);
					tempA.clear();
					tempA.addAll(a);
					tempV.clear();
					tempV.addAll(v);
				}
			}
		} else {
			vseI.add(new ArrayList<Integer>(v));
		}
	}

	static class Processing extends SwingWorker<Void, Integer> {

		JProgressBar pb;
		TextArea textArea;
		JLabel lblNewLabel_2;
		Date this_date = new Date();
		int old_i = 0;
		ArrayList<BigInteger> al_bi = new ArrayList<BigInteger>();
		
		int fact(int x) {
			int t[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, };
			return t[x];
		}

		public Processing(JProgressBar pb, TextArea textArea, JLabel lblNewLabel_2) {
			this.pb = pb;
			this.textArea = textArea;
			this.lblNewLabel_2 = lblNewLabel_2;
		}

		@Override
		protected void process(List<Integer> chunks) {
			int i = chunks.get(chunks.size() - 1);
			pb.setValue(i);

			if (i != old_i && i != 0) {
				Date date = new Date();
				date.setTime(date.getTime() - this_date.getTime());
				BigInteger bi_i = BigInteger.valueOf(i);
				BigInteger bi_lr = BigInteger.valueOf(max_progress);
				BigInteger bi_date = BigInteger.valueOf(date.getTime());
				BigInteger sr_bi = BigInteger.ZERO;

				BigInteger bi = bi_lr.multiply(bi_date);
				bi = bi.divide(bi_i);

				/*
				 * if (al_bi.size() < 1300) //Апроксимирующий таймер al_bi.add(bi); for
				 * (BigInteger c : al_bi) sr_bi = sr_bi.add(c); if (al_bi.size() >= 1300) bi =
				 * sr_bi.divide(BigInteger.valueOf(al_bi.size())).add(bi).divide(BigInteger.
				 * valueOf(2)); else bi = sr_bi.divide(BigInteger.valueOf(al_bi.size()));
				 */

				bi = bi.subtract(bi_date);
				lblNewLabel_2.setText(
						(new Date(bi.longValue()).getMinutes()) + " : " + (new Date(bi.longValue()).getSeconds()));
			}
			old_i = i;
		}

		@Override
		protected Void doInBackground() throws Exception {
			boolean more, less, add;
			ArrayList<Integer> vec = new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				max.add(0);
				min.add(Integer.MAX_VALUE);
			}
			
			int str[] = new int[LR];
			for (int i = 0; i < LR; i++)
				str[i] = i;
			int fact = fact(LR);
			int swap[] = new int[LR];
			int a, i, j, m, mm, iter=0;

			for (a = 1; a != fact + 1; a++) {
				mm = a;
				m = LR;
				
				iter++;
				temp.clear();
				for (int c: str) temp.add(c);
				
				publish(iter * max_progress / fact(LR));
				for (int t = 0; t < vseI.size(); t++) {
					vec.clear();
					for (int k = 0; k < K; k++) {
						int count = 0;
						for (int q = 0; q < LR; q++) {
							count += data.get(k).get(q).get(temp.get(q)).get(vseI.get(q).get(q));
						}
						if (count < min.get(k))
							min.set(k, count);
						if (count > max.get(k))
							max.set(k, count);
						vec.add(count);
					}
					if (!resultVec.isEmpty()) { // Расчет несравнимых векторов
						add = true;
						for (int q = 0; q < resultVec.size(); q++) {
							more = false;
							less = false;

							for (int k = 0; k < K; k++) {
								if (vec.get(k) >= resultVec.get(q).get(k)) {
									more = true;
								} else
									less = true;
							}

							if (more == false && less == true) {
								add = false;
								break;
							} else if (more == true && less == false) {
								resultVec.remove(q);
								resultLR.remove(q);
								resultI.remove(q);
								q--;
							}

						}

						if (add == true) {
							resultVec.add(new ArrayList<Integer>(vec));
							resultLR.add(new ArrayList<Integer>(temp));
							resultI.add(new ArrayList<Integer>(vseI.get(t)));
						}
					} else {
						resultVec.add(new ArrayList<Integer>(vec));
						resultLR.add(new ArrayList<Integer>(temp));
						resultI.add(new ArrayList<Integer>(vseI.get(t)));
					}
				}

				while (m > 0) {
					/* Проверка на делимость по модулю. Уменьшаем m */
					if (mm % m == 0) {
						mm /= m--;
					} else {

						j = 0;
						/* Обмен и оборот одной части */
						for (i = LR - m + 1; i <= LR - 1; i++, j++)
							swap[j] = str[i];
						swap[j] = '\0';

						for (i = LR - m; i >= 0; i--, j++)
							swap[j] = str[i];
						//swap[j] = '\0';

						/* Собираем вместе */
						for (i = 0; i <= LR - 1; i++)
							str[i] = swap[i];

						break;
					}
				}
			}
			return null;
		}

		@Override
		protected void done() {
			super.done();
			pb.setValue(100);
			ArrayList<Double> middle = new ArrayList<Double>();

			String s0 = "Релевантный набор по свертке:\n\n";
			String s1 = "Релевантный набор по Арбитражной схеме Нэша\nв качестве статуса-кво - свертка:\n\n";
			String s = "";

			// Заполнение текста во всех векторах
			for (int j = 0; j < resultVec.size(); j++) { // Расчет значений сверток
				double temp_mid = 0;
				for (int i = 0; i < K; i++) {
					temp_mid += (double) (resultVec.get(j).get(i) - min.get(i)) / (double) (max.get(i) - min.get(i));
				}
				middle.add(temp_mid);
			}
			ArrayList<Integer> temp_al = new ArrayList<Integer>();
			double temp_d;
			for (int i = 0; i < resultVec.size() - 1; i++) { // Сортировка несравнимых векторов по значению свертки
				for (int j = i + 1; j < resultVec.size(); j++) {
					if (middle.get(j) > middle.get(i)) {
						temp_d = middle.get(j);
						middle.set(j, middle.get(i));
						middle.set(i, temp_d);

						temp_al.clear();
						temp_al.addAll(resultVec.get(j));
						resultVec.set(j, new ArrayList<Integer>(resultVec.get(i)));
						resultVec.set(i, new ArrayList<Integer>(temp_al));

						temp_al.clear();
						temp_al.addAll(resultLR.get(j));
						resultLR.set(j, new ArrayList<Integer>(resultLR.get(i)));
						resultLR.set(i, new ArrayList<Integer>(temp_al));

						temp_al.clear();
						temp_al.addAll(resultI.get(j));
						resultI.set(j, new ArrayList<Integer>(resultI.get(i)));
						resultI.set(i, new ArrayList<Integer>(temp_al));
					}
				}
			}

			for (int j = 0; j < resultVec.size(); j++) { // Добавление информации о всех несравнимых векторах
				for (int i = 0; i < K; i++) {
					s += resultVec.get(j).get(i) + " ";
				}
				s += "  -> " + String.format("%.4f", middle.get(j));
				s += "\n\n";
			}

			for (int q = 0; q < LR; q++) { // Добавление информации о свертке
				s0 += ((q + 1) + "  " + (resultLR.get(0).get(q) + 1) + "  " + (resultI.get(0).get(q) + 1));
				s0 += "\n";
			}
			s0 += ("-------------------\r\n");
			for (int c : resultVec.get(0))
				s0 += (c + " ");
			s0 += " -> " + String.format("%.4f", middle.get(0));
			s0 += "\n\n=============================\n";

			int nesh = 0, nesh_i = 0; // Функция Нэша
			for (int i = 0; i < resultVec.size(); i++) {
				int sh = 1;
				for (int k = 0; k < K; k++) {
					if (resultVec.get(i).get(k) > resultVec.get(0).get(k))
						sh *= resultVec.get(i).get(k) - resultVec.get(0).get(k);
				}
				if (sh > nesh) {
					nesh = sh;
					nesh_i = i;
				}
			}
			for (int q = 0; q < LR; q++) {
				s1 += ((q + 1) + "  " + (resultLR.get(nesh_i).get(q) + 1) + "  " + (resultI.get(nesh_i).get(q) + 1));
				s1 += "\n";
			}
			s1 += ("-------------------\r\n");
			for (int c : resultVec.get(nesh_i))
				s1 += (c + " ");
			s1 += " -> " + nesh;
			s1 += "\n\n=============================\n";

			textArea.setText(s0 + s1 + s);

			try (FileWriter fw = new FileWriter("output.txt")) { // Запись в файл
				for (int i = 0; i < resultVec.size(); i++) {
					for (int q = 0; q < LR; q++) {
						fw.write((q + 1) + " " + (resultLR.get(i).get(q) + 1) + " " + (resultI.get(i).get(q) + 1));
						fw.write("\r\n");
					}
					fw.write("-------------------\r\n");
					for (int c : resultVec.get(i))
						fw.write(c + " ");
					fw.write("\r\n===================\r\n\r\n");
				}
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
