package by.petrikus;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class GameStart extends JFrame{
		JLabel lblNewLabel_4;
		JLabel label_1 ;
		JLabel label_2;
		JLabel label_3;
		
		int Zet = 130, x = 320, y = 240;
		int k = 96;
		int edge = 192;
		int speed = 5;
		int zet = 0;
		int r = 0;
		public int s = 0, a = 0, b = 0;
		BufferedImage image, magic, gate;
		BufferedImage kol;
		private JLabel label;
		boolean EAST, NORTH, WEST, SOUTH, or;
		boolean[] sides = new boolean[4];
		JLabel Magic;
		DungeonGeneretion dungeon = new DungeonGeneretion();
		int[][] array;
		public GameStart(boolean or, boolean[] sides, int countR, int countS, int koorX, int koorY, int[][] t){
			super("Game");
			this.x = koorX;
			this.y = koorY;
			this.or = or;
			this.a = countR;
			this.b = countS;
			array = t;
			try {
				image = ImageIO.read(new File("Res/sss.png"));
				kol = ImageIO.read(new File("Res/url.jpg"));
				magic = ImageIO.read(new File("Res/das.png"));
				gate = ImageIO.read(new File("Res/Dec.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (or){
				k = 0;
				edge = 96;
			}
			SOUTH = sides[0];
			NORTH = sides[1];
			EAST = sides[2];
			WEST = sides[3];
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
						if (SOUTH){
							if(y > 390 || x >= 300 && x <= 340){
								if (y >= 400){
									aInc();
								}
							}
							else if(y >= 395){
								y = 394;
							}
						}
						else if(y >= 394){
							y = 394;
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
						if (WEST){
							if (x <= 26 && y >= 190 && y <= 230){
								if (x <= 20){
									bDec();
								}
							}
							else if(x <= 20){
								x = 20;
							}
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
						if (EAST){
						if(x >= 578 && (y > 190 && y < 230)){
							if (x >= 590){
								bInc();
							}
						}
						else if(x > 585){
							x = 585;
						}
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
						if (NORTH){
							if (y <= 51 && (x > 300 && x < 340)){
								if (y <= 40){
									aDec();
								}
							}
							else if(y <= 43){
								y = 43;
							}
						}
						
						if (k == edge)
						{
							k = edge -  96;
						}
						label.setIcon(new ImageIcon(image.getSubimage(k, 96, 32, 32)));
						label.setBounds(x, y, 32, 32);
					}
					
					if (e.getKeyCode() == KeyEvent.VK_SPACE){
						r+=64;
						if (r > 320){
							r=0;
							s+=64;
						}
						if (s > 384){
							s = 0;
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
						}
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
			
			JLabel lblNewLabel = new JLabel("");
			if (NORTH){
				lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				lblNewLabel_4.setBounds(320, 25, 40, 40);
				getContentPane().add(lblNewLabel_4);
				
			}
			lblNewLabel.setIcon(new ImageIcon(kol.getSubimage(10, 0, 640, 25)));
			lblNewLabel.setBounds(0, 25, 640, 25);
			getContentPane().add(lblNewLabel);
			
			
			JLabel lblNewLabel_1 = new JLabel("");
			if (WEST){
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_1.setBounds(0, 210, 40, 40);
				getContentPane().add(label_1);
			}
			
				lblNewLabel_1.setIcon(new ImageIcon(kol.getSubimage(0, 0, 25, 455)));
			lblNewLabel_1.setBounds(0, 44, 25, 408);
			getContentPane().add(lblNewLabel_1);
			
			
			JLabel lblNewLabel_2 = new JLabel("");
			if(EAST){
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_2.setBounds(588, 210, 40, 40);
				getContentPane().add(label_2);
			}
			lblNewLabel_2.setIcon(new ImageIcon(kol.getSubimage(10, 10, 25, 455)));
			lblNewLabel_2.setBounds(612, 44, 25, 408);
			getContentPane().add(lblNewLabel_2);
			
			
			JLabel lblNewLabel_3 = new JLabel("");
			if(SOUTH){
				label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(gate.getSubimage(20, 20, 40, 40)));
				label_3.setBounds(320, 420, 40, 40);
				getContentPane().add(label_3);
			}
			
			lblNewLabel_3.setIcon(new ImageIcon(kol.getSubimage(20, 20, 640, 25)));
			lblNewLabel_3.setBounds(25, 427, 609, 25);
			getContentPane().add(lblNewLabel_3);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 634, 23);
			getContentPane().add(menuBar);
			
			JMenu mnFile = new JMenu("File");
			menuBar.add(mnFile);
			
			Magic = new JLabel("");
			Magic.setBounds(218, 172, 32, 32);
			getContentPane().add(Magic);				
			setVisible(true);
		}
		public void bInc(){
			b++;
			x = 26;
			dungeon.gener(a, b, x, y, or, array);
			dispose();
		}
		
		public void aInc(){
			a++;
			y = 51;
			dungeon.gener(a, b, x, y, or, array);
			dispose();
		}
		
		public void aDec(){
			a--;
			y = 394;
			dungeon.gener(a, b, x, y, or, array);
			dispose();
		}
		
		public void bDec(){
			b--;
			x = 578;
			dungeon.gener(a, b, x, y, or, array);
			dispose();
		}
}
