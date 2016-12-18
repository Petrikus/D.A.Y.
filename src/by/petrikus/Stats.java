package by.petrikus;

/**
 * Created by user on 10.10.2016.
 */
public class Stats {
    private int equiHP = 0;
    private int equiMP = 0;
    private int equiDamage = 0;
    private int equiDefend = 0;
    private int equiEvasion = 0;

    public int getMP() {
        return 20 + equiMP;
    }

    public void setMP(int MP) {
        equiMP = equiMP + MP*5;
    }

    public int getHP() {
        return 100+equiHP;
    }

    public void setHP(int HP) {
        equiHP = equiHP + HP*10;
    }

    public int getDamage() {
        return 20+equiDamage;
    }

    public void setDamage(int damage) {equiDamage = equiDamage + damage*5; }

    public int getDefends() {
        return 5+equiDefend;
    }

    public void setDefends(int defends) {
        equiDefend =  equiDefend + defends;
    }

    public int getEvasion() {
        return 5+equiEvasion;
    }

    public void setEvasion(int evasion) {
        equiEvasion = equiEvasion + evasion;
    }
}
