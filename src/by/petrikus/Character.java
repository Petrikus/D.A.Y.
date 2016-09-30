package by.petrikus;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Petrikus on 17.09.2016.
 */
public class Character {
    boolean first = true;
    int j = 0;
    CartsGeneration carts = new CartsGeneration();
    HashMap<String, String> map = new HashMap<String, String>();
    HashMap<String, String> dressed = new HashMap<String, String>();
    public Character(){
        shmotMap();
    }

    public void newShmot(){
        if (first) {
            for (; dressed.size() < 4; ) {
                Random r = new Random();
                int k = r.nextInt(carts.array.size());
                char[] shmot = carts.vibor(k);
                String s = "";
                for (int i = 0; i < 5; i++) {
                    s = s + String.valueOf(shmot[i]);
                }
                for (String str : map.keySet()) {
                    if (s.equals(str)) {
                        JOptionPane.showMessageDialog(null, "Вы получили " + map.get(str));
                        dressed.put(str, map.get(str));
                        break;
                    }
                }
                j++;
                first = false;
            }
        }else {
            if (j < 8) {
                Random r = new Random();
                int k = r.nextInt(carts.array.size());
                char[] shmot = carts.vibor(k);
                String s = "";
                for (int i = 0; i < 5; i++) {
                    s = s + String.valueOf(shmot[i]);
                }
                for (String str : map.keySet()) {
                    if (s.equals(str)) {
                        JOptionPane.showMessageDialog(null, "Вы получили " + map.get(str));
                        dressed.put(str, map.get(str));
                        break;
                    }
                }
                j++;
            }
            else {
                JOptionPane.showMessageDialog(null, "Рюкзак заполнен");
            }
        }
        }


    public void shmotMap(){
        map.put("r5r1s","Топор ярости");
        map.put("r6r1s","Меч чесности" );
        map.put("r4a0s", "Броня рыцаря-ежика");
        map.put("r3a0s", "Кольчуга из жопы дракона");
        map.put("r4r1s", "Самоуверенный щит");
        map.put("r7r1s", "Молот тысячи гласов");
        map.put("r5r1s", "Слишком заокругленный меч");
        map.put("r4h0s", "Шлем тысячи чертей");
        map.put("r3l0s", "Сапоги кота");
        map.put("r4l0s", "Кеды убегания от ответстенности");
    }

    public HashMap<String, String> returnMap(){
        return dressed;
    }

    public void addNewElement(HashMap<String, String> dressed){
        this.dressed = dressed;
    }
}
