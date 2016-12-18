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
	private LinkedList<EquipmentsBank> array = new LinkedList<EquipmentsBank>();
	private LinkedList<Stats> monster = new LinkedList<Stats>();
	private LinkedList<EquipmentsBank> back = new LinkedList<EquipmentsBank>();
	EquipmentsBank bank = new EquipmentsBank();
	public CartsGeneration(){
		Snar();
		back = array;
	}

	public void Snar(){
		//Аммулет ярости
		bank.setType("Amulet");
		bank.setName("Амулет ярости");
		bank.setEffect("Attack");
		bank.setWear(false);
		bank.setValue(2);
		array.add(0,bank);
		//Талисман чесности
		bank = new EquipmentsBank();
		bank.setType("Talisman");
		bank.setName("Талисман чесности");
		bank.setEffect("Evasion");
		bank.setWear(false);
		bank.setValue(3);
		array.add(1,bank);
		//Кольцо мертвого-рыцаря
		bank = new EquipmentsBank();
		bank.setType("Ring");
		bank.setName("Кольцо мертвого рыцаря");
		bank.setEffect("Defends");
		bank.setWear(false);
		bank.setValue(5);
		array.add(2,bank);
		//Кольцо сияющего глаза
		bank = new EquipmentsBank();
		bank.setType("Ring");
		bank.setName("Кольцо сияющего глаза");
		bank.setEffect("Attack");
		bank.setWear(false);
		bank.setValue(6);
		array.add(3,bank);
		//Самоуверенный талисман
		bank = new EquipmentsBank();
		bank.setType("Talisman");
		bank.setName("Самоуверенный талисман");
		bank.setEffect("HP");
		bank.setWear(false);
		bank.setValue(3);
		array.add(4, bank);
		//Амулет тысячи гласов
		bank = new EquipmentsBank();
		bank.setType("Amulet");
		bank.setName("Амулет тысячи гласов");
		bank.setEffect("MP");
		bank.setWear(false);
		bank.setValue(2);
		array.add(5, bank);
		//Слишком заокругленное кольцо
		bank = new EquipmentsBank();
		bank.setType("Ring");
		bank.setName("Слишком заокругленное кольцо");
		bank.setEffect("HP");
		bank.setWear(false);
		bank.setValue(2);
		array.add(6, bank);
		//Амулет тысячи чертей
		bank = new EquipmentsBank();
		bank.setType("Amulet");
		bank.setName("Амулет тысячи чертей");
		bank.setEffect("HP");
		bank.setWear(false);
		bank.setValue(3);
		array.add(7, bank);
		//Талисман кота
		bank = new EquipmentsBank();
		bank.setType("Talisman");
		bank.setName("Талисман кота");
		bank.setEffect("Evasion");
		bank.setWear(false);
		bank.setValue(4);
		array.add(8, bank);
		//Кольцо убегания от ответстенности
		bank = new EquipmentsBank();
		bank.setType("Ring");
		bank.setName("Кольцо убегания от ответстенности");
		bank.setEffect("Attack");
		bank.setWear(false);
		bank.setValue(4);
		array.add(9, bank);
		/**/
		//Монстер: снеговище
		Stats stats = new Stats();
		stats.setDamage(1);
		stats.setDefends(3);
		stats.setHP(2);
		stats.setMP(5);
		monster.add(stats);
	}

	public EquipmentsBank choiceItem(int row){
		bank = array.get(row);
		array.remove(row);
		return bank;
	}

	public Stats choiceMonster(int row){

		return monster.get(0);
	}

	public int getSize(){
		return array.size();
	}
}
