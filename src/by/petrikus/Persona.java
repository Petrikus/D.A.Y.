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
            for (int i = 0; i < shmot.length; i++) {
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
        map.put("faa2","Аммулет ярости");
        map.put("fet3","Талисман чесности" );
        map.put("fdr5", "Кольцо мертвого-рыцаря");
        map.put("far6", "Кольцо сияющего глаза");
        map.put("fht3", "Самоуверенный талисман");
        map.put("fma2", "Амулет тысячи гласов");
        map.put("fhr2", "Слишком заокругленное кольцо");
        map.put("fha3", "Амулет тысячи чертей");
        map.put("fet4", "Талисман кота");
        map.put("far4", "Кольцо убегания от ответстенности");

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
