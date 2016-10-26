package by.petrikus;

/**
 * Created by user on 24.10.2016.
 */
import javax.swing.*;

/**
 * Created by user on 16.10.2016.
 */
public class runBattle extends Thread {
    Battle battle;
    boolean es = true;
    public runBattle(Battle battle){
        this.battle = battle;
    }

    public void run(){
        while (es) {
            battle.doStay();
            battle.attackMP();
            battle.doMagic();
            battle.doPunch();
            battle.attackHP();
            battle.decEnemy();
            battle.enemyAttack();
            battle.enemyMagic();
        }
           JOptionPane.showMessageDialog(null, "тт");
    }

    public int prize(){
        return 1;
    }
}

