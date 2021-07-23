package myWindow;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JProgressBar;

import Player.Player;
import Poketmon.Poketmon;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyView {

	Player p;
	Poketmon other;
	Poketmon mine;
	int myAttackPower;
	int otherAttackPower;
	public static boolean whooseWin;
	public static boolean end;
	
	
	public JFrame frame;
	private JProgressBar progressBar_target;
	private JProgressBar progressBar_me;
	private JLabel label1;
	private JButton playerAttackButton;
	private JButton targetAttackButton;
	private JTextField targetName;
	private JTextField playerName;
	private JLabel label2;
	private JTextArea textArea;
	private JButton save;
	private Image img1;
	private Image img2;
	private Image changedImg;
	private JTextField playerPoketmonName;

	/*
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView window = new MyView();
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
	public MyView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("포켓몬 게임");
		frame.setBounds(100, 100, 722, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label1 = new JLabel("New label");
		label1.setBounds(36, 130, 127, 97);
		
		label2 = new JLabel("New label");
		label2.setBounds(548, 134, 136, 89);
		
		progressBar_target = new JProgressBar();
		progressBar_target.setMaximum(30);
		progressBar_target.setBounds(537, 89, 146, 20);
		progressBar_target.setValue(40); //set initial value
		progressBar_target.setStringPainted(true);
		frame.getContentPane().add(progressBar_target);
		
		progressBar_me = new JProgressBar();
		progressBar_me.setMaximum(30);
		progressBar_me.setBounds(26, 89, 146, 20);
		progressBar_me.setValue(30); //set initial value
		progressBar_me.setStringPainted(true);
		frame.getContentPane().add(progressBar_me);
		
		targetAttackButton = new JButton("공격하기");
		targetAttackButton.setBounds(558, 239, 117, 29);
		frame.getContentPane().add(targetAttackButton);
		
		
		playerAttackButton = new JButton("공격하기");
		playerAttackButton.setBounds(46, 239, 117, 29);
		frame.getContentPane().add(playerAttackButton);
		
		
		
		playerName = new JTextField();
		playerName.setBounds(26, 280, 161, 26);
		frame.getContentPane().add(playerName);
		playerName.setColumns(10);
		
		targetName = new JTextField();
		targetName.setBounds(548, 280, 146, 26);
		frame.getContentPane().add(targetName);
		targetName.setColumns(10);
	
		save = new JButton("save");
		save.setBounds(307, 420, 117, 29);
		frame.getContentPane().add(save);
	
		//사진 왜 안뜨지..?
		img1 = new ImageIcon(this.getClass().getResource("/img/fire.png")).getImage(); //이미지 추가 
		changedImg = img1.getScaledInstance(155, 97, Image.SCALE_SMOOTH); //이미지 크기 조정 
		label1.setIcon(new ImageIcon(changedImg)); //크기 조정한 이미지 추가 
		frame.getContentPane().add(label1);
		
		
		img2 = new ImageIcon(this.getClass().getResource("/img/turtle.png")).getImage(); //이미지 추가 
		changedImg = img2.getScaledInstance(155, 97, Image.SCALE_SMOOTH); //이미지 크기 조정 
		label2.setIcon(new ImageIcon(changedImg)); //크기 조정한 이미지 추가 
		frame.getContentPane().add(label2);

	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 65, 291, 318);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		playerPoketmonName = new JTextField();
		playerPoketmonName.setColumns(10);
		playerPoketmonName.setBounds(26, 306, 161, 26);
		frame.getContentPane().add(playerPoketmonName);
		
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//파일에 쓰기 
				File f = new File("/Users/sewon/OneDrive/세원_2019~ing/이화여대/3학년/객지프/gameLog.txt");
				try {
					PrintWriter pw = new PrintWriter(f);
					
					pw.write(textArea.getText());
					textArea.append("게임기록을 저장합니다. . .\n");
					pw.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("파일 저장을 실패했습니다! ! !");
				}
			}
		});
		
		
	}

	public MyView(Player p, Poketmon other, Poketmon mine, int myAttackPower, int otherAttackPower) {
		this();
		this.p = p;
		this.other = other;
		this.mine = mine;
		this.myAttackPower = myAttackPower;
		this.otherAttackPower = otherAttackPower;
		
		frame.repaint(); //Main.java 실행 시 이미지 띄우기 해결!
		
		playerName.setText("Player : " + p.name);
		playerPoketmonName.setText("포켓몬 : " + mine.name);
		targetName.setText("포켓몬 : " + other.name);
		
		
		progressBar_target.setValue(mine.gethp());
		progressBar_me.setValue(other.gethp());
		
		playerAttackButton.addActionListener(new ActionListener() { //player의 공격 
			public void actionPerformed(ActionEvent e) {
				
				mine.attackbyPoketmon(other, myAttackPower);
				progressBar_target.setValue(other.gethp());
				
				mine.show();
				other.show();
				
				//글자쓰는거 추가해야함!! 오늘 수업 내용 
				textArea.append(mine.name + "이 " + other.name + "님을 공격했습니다! ! !\n");
				
				if(other.gethp() <= 0) {
					targetAttackButton.setEnabled(false);
					playerAttackButton.setEnabled(false);
					whooseWin = true;
					end = true;
					other.sethp(30); //hp 초기화 
					mine.sethp(30); //hp 초기화 
					frame.dispose(); //대결 화면 종료 
				}
			}
		});
		
		targetAttackButton.addActionListener(new ActionListener() { //target의 공격 
			public void actionPerformed(ActionEvent e) {
				
				other.attackbyPoketmon(mine, otherAttackPower);
				progressBar_me.setValue(mine.gethp());
				
				other.show();
				mine.show();
				
				//글자쓰는거 추가해야함 !! 오늘 수업 내용 
				textArea.append(other.name + "이 " + mine.name + "님을 공격했습니다! ! !\n");
				
				if(mine.gethp() <= 0) {
					playerAttackButton.setEnabled(false);
					targetAttackButton.setEnabled(false);
					whooseWin = false;
					end = true;
					other.sethp(30); //hp 초기화 
					mine.sethp(30); //hp 초기화 
					frame.dispose(); //대결 화면 종료 
				}
				
				
			}
		});
		
		
	
	}
}
