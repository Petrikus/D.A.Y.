package by.petrikus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.jar.Pack200;

import javax.imageio.ImageIO;

public class CartsGeneration {
	BufferedImage image;
	public LinkedList<String> ses = new LinkedList<String>();
	public CartsGeneration(){
		try {
			image = ImageIO.read(new File("Res/Carts.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Snar();
	}

	public void Snar(){
		//Топор ярости
		ses.add(0,"58h1b");
		//Меч чесности
		ses.add(1,"46h1s");
		//Броня рыцаря ежика
		ses.add(2,"36a1s");

	}

	public char[] vibor(int row){
		char[] vib;
		vib = ses.get(row).toCharArray();
		return vib;
	}
}
