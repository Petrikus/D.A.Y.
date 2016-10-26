package by.petrikus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class GameStart extends JFrame{
		int x = 320, y = 190;
		int k = 96;
		int edge = 192;
		int speed = 5;
		int zet = 0;
		public int a = 0, b = 0, level = 1;
		BufferedImage image, gate, box;
		BufferedImage kol, up, down;
		private JLabel label;
		private JLabel labelBox;
		private JLabel damageLabel, background;
		JLabel lblNewLabel_4;
		JLabel label_1;
		JLabel label_2;
		JLabel label_3;
		boolean EAST, NORTH, WEST, SOUTH, or, open = true;
		JLabel Magic;
	Character character = new Character();
		int[][] dungeon;
	private runBattle battle;

	public GameStart(boolean or, int[][] t){
			super("Game");
			this.or = or;
			dungeon = t;
			try {
				image = ImageIO.read(new File("Res/sss.png"));
				kol = ImageIO.read(new File("Res/url.jpg"));
				gate = ImageIO.read(new File("Res/Dec.jpg"));
				box = ImageIO.read(new File("Res/box.png"));
				up = ImageIO.read(new File("Res/up.jpg"));
				down = ImageIO.read(new File("Res/bokovaya_stena.psd"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblNewLabel_4 = new JLabel();
			lblNewLabel_4.setIcon(new ImageIcon(gate.getSubimage(20, 20, 25, 25)));
			lblNewLabel_4.setBounds(320, 25, 25, 25);
			getContentPane().add(lblNewLabel_4);

			label_1 = new JLabel();
			label_1.setIcon(new ImageIcon(gate.getSubimage(20, 20, 25, 25)));
			label_1.setBounds(0, 210, 25, 25);
			getContentPane().add(label_1);

			label_2 = new JLabel();
			label_2.setIcon(new ImageIcon(gate.getSubimage(20, 20, 25, 25)));
			label_2.setBounds(588, 210, 25, 25);
			getContentPane().add(label_2);

			label_3 = new JLabel();
			label_3.setIcon(new ImageIcon(gate.getSubimage(20, 20, 25, 25)));
			label_3.setBounds(320, 420, 25, 25);
			getContentPane().add(label_3);
			if (or){
				k = 0;
				edge = 96;
			}
			setResizable(false);
			setSize(640, 480);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			setLocationRelativeTo(null);

			label = new JLabel("");
			label.setIcon(new ImageIcon(image.getSubimage(k, 0, 32, 32)));
			label.setBounds(x, y, 32, 32);
			getContentPane().add(label);
			
			JButton btnNewButton = new JButton("Up");
			btnNewButton.addKeyListener(new KeyListener(){

				public void keyPressed(KeyEvent e) {
					try{
						
					// TODO Auto-generated method stub
					if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
						y+=speed;
						k += 32;
						zet = 0;
						if (y >= 168 && y <=200 && x >= 258 && x <=300){
							y = 168;
						}
						if (SOUTH){
							if(y >= 385 && (x >= 300 && x <= 340)){
								if (y >= 400){
									aInc();
								}
							}
							else if(y > 400){
								y = 400;
							}
						}
						else if(y > 400){
							y = 400;
						}
						if (k == edge)
						{
							k = edge - 96;
						}
						label.setIcon(new ImageIcon(image.getSubimage(k, 0, 32, 32)));
						label.setBounds(x, y, 32, 32);
					}
					
					if (e.getKeyCode() == KeyEvent.VK_A|| e.getKeyCode() == KeyEvent.VK_LEFT){
						x-=speed;
						k += 32;
						zet = 1;
						if (x <= 300 && x >=260 && y >=173 && y <= 200){
							x = 300;
						}
						if (WEST){
							if (x <= 26 && (y >= 190 && y <= 230)){
								if (x <= 20){
									bDec();
								}
							}
							else if(x < 20){
								x = 20;
							}
						}
						else if(x < 20){
							x = 20;
						}
						if (k == edge)
						{
							k = edge - 96;
						}
						
						label.setIcon(new ImageIcon(image.getSubimage(k, 64, 32, 32)));
						label.setBounds(x, y, 32, 32);
					}
					
					if(e.getKeyCode() == KeyEvent.VK_D|| e.getKeyCode() == KeyEvent.VK_RIGHT){
						x+=speed;
						k += 32;
						zet = 3;
						if(x>=258 && x <=298 && y>=173 && y <=200){
							x = 258;
						}
						if (EAST){
							if(x >= 578 && y > 190 && y < 230){
								if (x >= 590){
									bInc();
								}
						}
							else if(x > 578){
								x = 578;
							}
						}
						else if(x > 578){
							x = 578;
						}
						if (k == edge)
						{
							k = edge - 96;
						}
						label.setIcon(new ImageIcon(image.getSubimage(k, 32, 32, 32)));
						label.setBounds(x, y, 32, 32);
					}
					
					if(e.getKeyCode() == KeyEvent.VK_W|| e.getKeyCode() == KeyEvent.VK_UP){
						y-=speed;
						k += 32;
						zet = 2;
						if (y <=205 && y >=170 && x >= 258 && x <=300){
							y = 205;
						}
						if (NORTH){
							if (y <= 51 && x > 300 && x < 340){
								if (y <= 40){
									aDec();
								}
							}
							else if(y <= 43){
								y = 43;
							}
						}
						else if(y <= 43){
							y = 43;
						}
						if (k == edge)
						{
							k = edge -  96;
						}
						label.setIcon(new ImageIcon(image.getSubimage(k, 96, 32, 32)));
						label.setBounds(x, y, 32, 32);
					}
					if(e.getKeyCode() == KeyEvent.VK_SPACE){
						if (open) {
							if (y <= 205 && y >= 170 && x >= 258 && x <= 300) {
								character.newShmot(4);
								open = false;
							}
						}
						else {
							if (y <= 205 && y >= 170 && x >= 258 && x <= 300) {
								character.newMonster();
								Battle battle = new Battle();
								runBattle runBattle = new runBattle(battle);
								runBattle.start();

							}
						}
					}
					}catch(Exception a){
						
					}
					if(e.getKeyCode() == KeyEvent.VK_I){
						Information information = new Information(character.returnMap());
						character.addNewElement(information.returnMap());
					}
				}


				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
				}

				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
				}
			});
			
			getContentPane().add(btnNewButton);


			gener();

			background = new JLabel();
			background.setIcon(new ImageIcon("Res/background.jpg"));
			background.setBounds(0,0,640,480);
			getContentPane().add(background);
			setVisible(true);
		}
		
		public void bInc(){
			b++;
			x = 26;
			gener();
		}
		
		public void aInc(){
			a++;
			y = 51;
			gener();
		}
		
		public void aDec(){
			a--;
			y = 394;
			gener();
		}
		
		public void bDec(){
			b--;
			x = 578;
		}

	public void gener() {
		try {
			if (dungeon[a + 1][b] == 0) {
				SOUTH = true;
				label_3.setVisible(true);
			} else {
				SOUTH = false;
				label_3.setVisible(false);
			}
		} catch (Exception e) {
			SOUTH = false;
			label_3.setVisible(false);
		}
		try {
			if (dungeon[a - 1][b] == 0) {
				NORTH = true;
				lblNewLabel_4.setVisible(true);
			} else {
				NORTH = false;
				lblNewLabel_4.setVisible(false);
			}
		} catch (Exception e) {
			NORTH = false;
			lblNewLabel_4.setVisible(false);
		}
		try {
			if (dungeon[a][b + 1] == 0) {
				EAST = true;
				label_2.setVisible(true);
			} else {
				EAST = false;
				label_2.setVisible(false);
			}
		} catch (Exception e) {
			EAST = false;
			label_2.setVisible(false);
		}
		try {
			if (dungeon[a][b - 1] == 0) {
				WEST = true;
				label_1.setVisible(true);
			} else {
				WEST = false;
				label_1.setVisible(false);
			}
		} catch (Exception e) {
			WEST = false;
			label_1.setVisible(false);
		}
		/*background = new JLabel();
		background.setIcon(new ImageIcon("Res/background.jpg"));
		background.setBounds(0,0,640,480);
		getContentPane().add(background);*/
		labelBox = new JLabel("");
		labelBox.setIcon(new ImageIcon(box.getSubimage(0,0,32,32)));
		labelBox.setBounds(280, 200, 32, 32);
		getContentPane().add(labelBox);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setIcon(new ImageIcon(up.getSubimage(0,0,640,25)));
		lblNewLabel.setBounds(0, 0, 640, 25);
		getContentPane().add(lblNewLabel);

		damageLabel = new JLabel("" + level);
		damageLabel.setBounds(50, 50, 50, 20);
		getContentPane().add(damageLabel);

		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setIcon(new ImageIcon(kol.getSubimage(0, 0, 25, 455)));
		lblNewLabel_1.setBounds(0, 44, 25, 408);
		getContentPane().add(lblNewLabel_1);


		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(kol.getSubimage(10, 10, 25, 455)));
		lblNewLabel_2.setBounds(612, 44, 25, 408);
		getContentPane().add(lblNewLabel_2);


		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(up));
		lblNewLabel_3.setBounds(25, 427, 609, 25);
		getContentPane().add(lblNewLabel_3);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 634, 23);
		getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem menuItem = new JMenuItem("\u0412 \u0433\u043B\u0430\u0432\u043D\u043E\u0435 \u043C\u0435\u043D\u044E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main main = new Main();
				Main.run();
			}
		});
		mnFile.add(menuItem);

		Magic = new JLabel();
		Magic.setBounds(70, 50, 600, 100);
		getContentPane().add(Magic);

	}
}
