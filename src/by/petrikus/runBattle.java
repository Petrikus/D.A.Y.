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
    public runBattle(Battle battle){
        this.battle = battle;
        start();
    }

    public void run(){
        while (battle.END == false) {
            battle.doStay();
            battle.attackMP();
            battle.doMagic();
            battle.doPunch();
            battle.attackHP();
            battle.decEnemy();
            battle.enemyAttack();
            battle.enemyMagic();
        }
           JOptionPane.showMessageDialog(null, battle.END());
    }

    public int prize(){
        return 1;
    }
}

