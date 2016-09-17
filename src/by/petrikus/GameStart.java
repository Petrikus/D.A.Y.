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
		JLabel lblNewLabel_4;
		JLabel label_1 ;
		JLabel label_2;
		JLabel label_3;
		int x = 320, y = 240;
		int k = 96;
		int edge = 192;
		int speed = 5;
		int zet = 0;
		public int a = 0, b = 0, level = 1;
		BufferedImage image, gate, box;
		BufferedImage kol;
		private JLabel label;
		private JLabel labelBox;
		private JLabel damageLabel;
		boolean EAST, NORTH, WEST, SOUTH, or, open = true;
		JLabel Magic;
	Character character = new Character();
		int[][] dungeon;
		public GameStart(boolean or, int[][] t){
			super("Game");
			this.or = or;
			dungeon = t;
			try {
				image = ImageIO.read(new File("Res/sss.png"));
				kol = ImageIO.read(new File("Res/url.jpg"));
				gate = ImageIO.read(new File("Res/Dec.jpg"));
				box = ImageIO.read(new File("Res/box.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gener();
			if (or){
				k = 0;
				edge = 96;
			}
			setResizable(false);
			setSize(640, 480);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			setLocationRelativeTo(null);

			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 0, 0);
			getContentPane().add(panel);
			
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
								character.newShmot();
								open = false;
								Magic.setText("Свободного места в рюкзаке" + (8 - character.shmot.length));
							}
						}
					}
					/*if (e.getKeyCode() == KeyEvent.VK_SPACE){
						for(;;){
						r+=64;
						Thread.sleep(50);
						if (r > 320){
							r=0;
							s+=64;
						}
						if (s > 384){
							s = 0;
							break;
						}
						if (zet == 0){
							Magic.setIcon(new ImageIcon(magic.getSubimage(r, s, 64, 64)));
							Magic.setBounds(x-15, y+50, 64, 64);
						}
						if (zet == 1){
							Magic.setIcon(new ImageIcon(magic.getSubimage(r, s, 64, 64)));
							Magic.setBounds(x-50, y-15, 64, 64);
						}
						if (zet == 2){
							Magic.setIcon(new ImageIcon(magic.getSubimage(r, s, 64, 64)));
							Magic.setBounds(x, y-50, 64, 64);
						}
						if (zet == 3){
							Magic.setIcon(new ImageIcon(magic.getSubimage(r, s, 64, 64)));
							Magic.setBounds(x+50, y, 64, 64);
						}
						}}*/
					}catch(Exception a){
						
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
			labelBox = new JLabel("");
			labelBox.setIcon(new ImageIcon(box.getSubimage(0,0,32,32)));
			labelBox.setBounds(280, 200, 32, 32);
			getContentPane().add(labelBox);

			JLabel lblNewLabel = new JLabel("");

			lblNewLabel.setIcon(new ImageIcon(kol.getSubimage(10, 0, 640, 25)));
			lblNewLabel.setBounds(0, 25, 640, 25);
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
			lblNewLabel_3.setIcon(new ImageIcon(kol.getSubimage(20, 20, 640, 25)));
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
			
			Magic = new JLabel("Свободного места в рюкзаке" + (8 - character.shmot.length));
			Magic.setBounds(70, 50, 600, 100);
			getContentPane().add(Magic);				
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
			gener();
		}

	public void gener() {
		try {
			if (dungeon[a + 1][b] == 0) {
				SOUTH = true;
				label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_3.setBounds(320, 420, 40, 40);
				getContentPane().add(label_3);
			} else {
				SOUTH = false;
			}
		} catch (Exception e) {
			SOUTH = false;
		}
		try {
			if (dungeon[a - 1][b] == 0) {
				NORTH = true;
				lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				lblNewLabel_4.setBounds(320, 25, 40, 40);
				getContentPane().add(lblNewLabel_4);
			} else {
				NORTH = false;
			}
		} catch (Exception e) {
			NORTH = false;
		}
		try {
			if (dungeon[a][b + 1] == 0) {
				EAST = true;
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_2.setBounds(588, 210, 40, 40);
				getContentPane().add(label_2);
			} else {
				EAST = false;
			}
		} catch (Exception e) {
			EAST = false;
		}
		try {
			if (dungeon[a][b - 1] == 0) {
				WEST = true;
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_1.setBounds(0, 210, 40, 40);
				getContentPane().add(label_1);
			} else {
				WEST = false;
			}
		} catch (Exception e) {
			WEST = false;
		}
	}
}
