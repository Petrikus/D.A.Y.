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
    String monster = "";
    public Character(){
        shmotMap();
    }

    public void newShmot(int count) {
        for (; dressed.size() < count; ) {
            Random r = new Random();
            int k = r.nextInt(carts.array.size());
            char[] shmot = carts.viborItem(k);
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

        }

    }
    public void newMonster(){
                Random r = new Random();
                int k = r.nextInt(carts.monster.size());
                char[] shmot = carts.viborMonster(k);
                String s = "";
                for (int i = 0; i < 5; i++) {
                    s = s + String.valueOf(shmot[i]);
                }
                for (String str : map.keySet()) {
                    if (s.equals(str)) {
                        monster = str;
                        break;
                    }
                }
        }




    public void shmotMap(){
        map.put("r5r0s","Топор ярости");
        map.put("r6r1s","Меч чесности" );
        map.put("r4a2s", "Броня рыцаря-ежика");
        map.put("r3a3s", "Кольчуга из жопы дракона");
        map.put("r4r4s", "Самоуверенный щит");
        map.put("r7r5s", "Молот тысячи гласов");
        map.put("r5r6s", "Слишком заокругленный меч");
        map.put("r4h7s", "Шлем тыс ячи чертей");
        map.put("r3l8s", "Сапоги кота");
        map.put("r4l9s", "Кеды убегания от ответстенности");

        map.put("m1325", "Снеговище");
    }

    public HashMap<String, String> returnMap(){
        return dressed;
    }

    public void addNewElement(HashMap<String, String> dressed){
        this.dressed = dressed;
    }

    public String returnMonster(){return monster;}
}
