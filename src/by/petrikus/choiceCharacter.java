package by.petrikus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class choiceCharacter extends JFrame {
	BufferedImage or;
	boolean[] sides = new boolean[4];
	public choiceCharacter(){
		super("Choice");
		try {
			or = ImageIO.read(new File("res/sss.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 194, 172);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DungeonGeneretion dungeon = new DungeonGeneretion();
				dungeon.frame(0,0, 5, 5, false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(or.getSubimage(96, 0, 32, 32)));
		btnNewButton.setBounds(10, 45, 74, 72);
		btnNewButton.setBackground(Color.green);
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DungeonGeneretion dungeon = new DungeonGeneretion();
				dungeon.frame(0,0,5, 5, true);
			}
		});
		button.setIcon(new ImageIcon(or.getSubimage(0, 0, 32, 32)));
		button.setBackground(Color.red);
		button.setBounds(110, 45, 74, 72);
		panel.add(button);
		setVisible(true);
	}
}
