package by.petrikus;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Petrikus on 17.09.2016.
 */
public class Persona {
    boolean first = true;
    int j = 0;
    Stats monster = new Stats();
    CartsGeneration carts = new CartsGeneration();
    ArrayList<EquipmentsBank> banks = new ArrayList<EquipmentsBank>();

    public void newShmot(int count) {
        for (int i = 0; banks.size() < count;i++ ) {
            Random r = new Random();
            int k = r.nextInt(carts.getSize());
            EquipmentsBank shmot = carts.choiceItem(k);
            JOptionPane.showMessageDialog(null, "Вы получили " + shmot.getName());
            banks.add(shmot);
        }

    }

    public void newMonster(){
                Random r = new Random();
                monster = carts.choiceMonster(0);
        }

    public ArrayList<EquipmentsBank> returnMap(){
        return banks;
    }

    public void addNewElement(ArrayList<EquipmentsBank> dressed){
        banks = dressed;
    }

    public Stats returnMonster(){return monster;}
}
