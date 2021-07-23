package myWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Color;

public class Window2 {

	private JFrame frame;
	private JButton b1;
	private JButton b2;
	private JScrollPane scroll = new JScrollPane();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
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
	public Window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("게임 윈도우\n");
		frame.setBounds(100, 100, 679, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		b1 = new JButton("공격하기");
		b1.setBounds(38, 53, 180, 63);
		frame.getContentPane().add(b1);
		
		b2 = new JButton("공격하기");
		b2.setBounds(444, 53, 180, 63);
		frame.getContentPane().add(b2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 240, 444, 124);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setColumnHeaderView(textArea);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(38, 153, 199, 20);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(418, 153, 206, 20);
		frame.getContentPane().add(progressBar_1);
	}
}
