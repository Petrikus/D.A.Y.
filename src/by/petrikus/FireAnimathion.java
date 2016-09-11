package by.petrikus;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class FireAnimathion implements Runnable {
	int x = 45;
	int y = 140;
	int z = 0;
	public void UpdateFire(){
		z+=47;
		if(z >= 376)
		{
			z = 0;
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		UpdateFire();
	}
	
}
