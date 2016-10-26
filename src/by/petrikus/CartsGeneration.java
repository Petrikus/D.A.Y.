package by.petrikus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.jar.Pack200;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CartsGeneration {
	BufferedImage image;
	public LinkedList<String> array = new LinkedList<String>();
	public ArrayList<String> back = new ArrayList<String>();
	public LinkedList<String> monster = new LinkedList<String>();
	public CartsGeneration(){
		try {
			image = ImageIO.read(new File("Res/Carts.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Snar();
		back.addAll(array);
	}

	public void Snar(){
		//Топор ярости
		array.add(0,"r5r0s");
		//Меч чесности
		array.add(1,"r6r1s");
		//Броня рыцаря-ежика
		array.add(2,"r4a2s");
		//Кольчуга из жопы дракона
		array.add(3,"r3a3s");
		//Самоуверенный щит
		array.add(4, "r4r4s");
		//Молот тысячи гласов
		array.add(5, "r7r5s");
		//Слишком заокругленный меч
		array.add(6, "r5r6s");
		//Шлем тысячи чертей
		array.add(7, "r4h7s");
		//Сапоги кота
		array.add(8, "r3l8s");
		//Кеды убегания от ответстенности
		array.add(9, "r4l9s");
		/**/
		//Монстер: снеговище
		monster.add(0, "m1325");
	}

	public char[] viborItem(int row){
			char[] vib;
			vib = array.get(row).toCharArray();
			array.remove(row);
			return vib;
	}

	public char[] viborMonster(int row){
		char[] vib = monster.get(0).toCharArray();
		return vib;
	}
}
