package by.petrikus;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Petrikus on 17.09.2016.
 */
public class Character {
    int n = 8;
    public char[][] shmot = new char[n][5];
    boolean first = true;
    int j = 0;
    CartsGeneration carts = new CartsGeneration();
    HashMap<String, String> map = new HashMap<String, String>();
    HashMap<String, String> old = new HashMap<String, String>();
    public Character(){
        shmotMap();
    }

    public void newShmot(){
        if (first) {
            if (j < 8) {
                Random r = new Random();
                int k = r.nextInt(2);
                shmot[j] = carts.vibor(k);
                String s = "";
                for (int i = 0; i < 5; i++) {
                    s = s + String.valueOf(shmot[j][i]) + " ";
                }
                for (String str : map.keySet()) {
                    if (s.equals(str)) {
                        JOptionPane.showMessageDialog(null, "Вы получили " + map.get(str));
                        break;
                    }
                }
                j++;
            }
            else {
                JOptionPane.showMessageDialog(null, "Рюкзак заполнен");
            }
        }
        else {

        }
    }

    public void shmotMap(){
        map.put("5 8 h 1 b ","Топор ярости");
        map.put("4 6 h 1 s ","Меч чесности" );
        map.put( "3 6 a 0 s ","Броня рыцаря-ежика");
    }

    public void oldShot(){

    }
}
