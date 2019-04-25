package Main_Program;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main extends Frame {

	Main() {
		setLayout(null);
		setTitle("Hypergraph!");
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());
		
		setSize(550, 800);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);

		Graphics g = getGraphics();
		g.drawImage(new ImageIcon("hyper.jpg").getImage(), 90, 70, null);
		g.drawLine(0, 65, 550, 65);
		g.drawLine(0, 360, 550, 360);
		g.drawLine(0, 580, 550, 580);
		
//###########################Вторая часть окна############################################
		JLabel lPage2Label1 = new JLabel("Введите основные параметры Гиперграфа:", SwingConstants.CENTER);
		lPage2Label1.setFont(new Font("Serif", Font.PLAIN, 21));
		lPage2Label1.setBounds(70, 300, 390, 25);
		add(lPage2Label1);
		
		/*JLabel lPage2Label2 = new JLabel("Количество критериев:", SwingConstants.CENTER);
		lPage2Label2.setFont(new Font("Serif", Font.PLAIN, 21));
		lPage2Label2.setBounds(10, 385, 205, 25);
		add(lPage2Label2);
		TextField tfPage2TF2 = new TextField("");
		tfPage2TF2.setFont(new Font("Serif", Font.PLAIN, 21));
		tfPage2TF2.setBounds(220, 385, 50, 25);
		add(tfPage2TF2);*/
		
		JLabel lPage2Label3 = new JLabel("Количество вершин типа L/R:", SwingConstants.CENTER);
		lPage2Label3.setFont(new Font("Serif", Font.PLAIN, 21));
		lPage2Label3.setBounds(10, 410, 265, 25);
		add(lPage2Label3);
		TextField tfPage2TF3 = new TextField("");
		tfPage2TF3.setFont(new Font("Serif", Font.PLAIN, 21));
		tfPage2TF3.setBounds(280, 410, 50, 25);
		add(tfPage2TF3);
		
		JLabel lPage2Label4 = new JLabel("Количество вершин типа I:", SwingConstants.CENTER);
		lPage2Label4.setFont(new Font("Serif", Font.PLAIN, 21));
		lPage2Label4.setBounds(0, 435, 265, 25);
		add(lPage2Label4);
		TextField tfPage2TF4 = new TextField("");
		tfPage2TF4.setFont(new Font("Serif", Font.PLAIN, 21));
		tfPage2TF4.setBounds(265, 435, 50, 25);
		add(tfPage2TF4);
		
		JLabel lPage2Label5 = new JLabel("Размерность вершин I[i] (через запятую):", SwingConstants.CENTER);
		lPage2Label5.setFont(new Font("Serif", Font.PLAIN, 21));
		lPage2Label5.setBounds(5, 460, 380, 25);
		add(lPage2Label5);
		TextField tfPage2TF5 = new TextField("");
		tfPage2TF5.setFont(new Font("Serif", Font.PLAIN, 21));
		tfPage2TF5.setBounds(15, 485, 500, 25);
		add(tfPage2TF5);
		
		Button bPage2Button1 = new Button("Сгенерировать шаблон EXCEL");
		bPage2Button1.setFont(new Font("Serif", Font.PLAIN, 21));
		bPage2Button1.setBounds(120, 515, 290, 35);
		add(bPage2Button1);
		
		

		
		

	}

	public static void main(String[] args) {
		Main main = new Main();
	}
}