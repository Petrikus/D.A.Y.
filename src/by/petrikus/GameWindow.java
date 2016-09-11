package by.petrikus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	private BufferedImage image, tourch, tourchElse, red;
	FireAnimathion fire = new FireAnimathion();
	public JMenuBar menuBar;
	public JPanel panel ;
	public JLabel lblFire ;
	public JLabel lblFire_1;
	public GameWindow() {
		super("Game");
		setSize(640,480);
		try {
			image = ImageIO.read(new File("Res/Fir.jpg"));
			tourch = ImageIO.read(new File("Res/Tourch.jpg"));
			tourchElse = ImageIO.read(new File("Res/TourchElse.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		 menuBar  = new JMenuBar();
		menuBar.setBounds(0, 0, 634, 21);
		getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 21, 634, 431);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				choiceCharacter choice = new choiceCharacter();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(210, 105, 30));
		btnNewButton.setBounds(229, 172, 167, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOAD GAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setForeground(new Color(204, 102, 0));
		btnNewButton_1.setBounds(229, 261, 167, 52);
		panel.add(btnNewButton_1);
		
		lblFire = new JLabel("");
		lblFire.setBackground(new Color(0, 0, 0));
		lblFire.setIcon(new ImageIcon(image.getSubimage(0, 0, fire.x, fire.y)));
		lblFire.setBounds(73, 11, 95, 244);
		panel.add(lblFire);
		
		lblFire_1 = new JLabel("");
		lblFire_1.setBackground(new Color(0, 0, 0));
		lblFire_1.setIcon(new ImageIcon(image.getSubimage(0, 0, fire.x, fire.y)));
		lblFire_1.setBounds(491, 11, 79, 244);
		panel.add(lblFire_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(tourch.getSubimage(0, 0, 100, 100)));
		label.setBounds(31, 198, 100, 100);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(tourchElse.getSubimage(0,0, 100,100)));
		lblNewLabel.setBounds(482, 198, 100, 100);
		panel.add(lblNewLabel);
		setVisible(true);
		
		
	}
	
	public void Run(){
		fire.run();
		lblFire.setIcon(new ImageIcon(image.getSubimage(fire.z,0,fire.x,fire.y)));
		lblFire_1.setIcon(new ImageIcon(image.getSubimage(fire.z, 0, fire.x, fire.y)));
		try {
			Thread.sleep(75);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	

