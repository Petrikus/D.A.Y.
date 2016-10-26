package by.petrikus;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Random;

public class Battle extends JFrame {

    private final JButton btnAttack;
    private final JButton btnMagic;
    private final JLabel enemyLabel;
    private final JLabel mpLabel;
    private final JLabel hpLabel;
    private final JLabel enemyHP;
    private final JLabel decStats;
    BufferedImage gg, punch, DARK, enemy;
    int x = 0, zet = 290, gamma = 350, row = 0, count = 0, cay = 290, dec = 0, koorX = 190, koorY = 190, stepMagic = 0;
    int y = 0;
    boolean stay = true, fight = false, magic = false, decHP = false, decMP = false, decEnemy = false, rand = true, enemyAttack = false, END;
    private JLabel labelHero;
    private JLabel labelMagic;
    private int z = 0;
    private int k;
    private boolean enemyMagic = false;
    private boolean first = false;
    private boolean enemyII = false;

    public Battle() {
        super("Battle");
        try {
            gg = ImageIO.read(new File("Res/GG.png"));
            punch = ImageIO.read(new File("Res/punch.png"));
            DARK = ImageIO.read(new File("Res/DARK.png"));
            enemy = ImageIO.read(new File("Res/enemy.png"));
        } catch (Exception e) {

        }
        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mpLabel = new JLabel("");
        mpLabel.setOpaque(true);
        mpLabel.setBackground(Color.blue);
        mpLabel.setBounds(0, 20, zet, 20);
        getContentPane().add(mpLabel);

        decStats = new JLabel();
        getContentPane().add(decStats);

        hpLabel = new JLabel("");
        hpLabel.setOpaque(true);
        hpLabel.setBackground(Color.RED);
        hpLabel.setBounds(0, 0, 290, 20);
        getContentPane().add(hpLabel);

        enemyHP = new JLabel();
        enemyHP.setOpaque(true);
        enemyHP.setBackground(Color.RED);
        enemyHP.setBounds(gamma, 0, 290, 40);
        getContentPane().add(enemyHP);

        btnAttack = new JButton("Attack");
        btnAttack.setBounds(10, 253, 89, 23);
        getContentPane().add(btnAttack);

        btnMagic = new JButton("Magic");
        btnMagic.setBounds(10, 280, 89, 23);
        getContentPane().add(btnMagic);

        labelHero = new JLabel("");
        labelHero.setIcon(new ImageIcon(gg.getSubimage(x, 0, 45, 60)));
        labelHero.setBounds(128, 90, 140, 280);
        getContentPane().add(labelHero);

        labelMagic = new JLabel("");
        labelMagic.setBounds(200, 100, 192, 192);
        getContentPane().add(labelMagic);

        enemyLabel = new JLabel("");
        enemyLabel.setBounds(200, 190, 100, 66);
        getContentPane().add(enemyLabel);
        setVisible(true);
    }

    public synchronized void enemyMagic() {
        if (enemyMagic) {
            if (first) {
                try {
                    DARK = ImageIO.read(new File("Res/ICE.png"));
                } catch (IOException e) {
                }
                first = false;
            }
            if (row < 960) {
                if (count < 960) {

                    labelMagic.setIcon(new ImageIcon(DARK.getSubimage(count, row, 192, 192)));
                    labelMagic.setBounds(100, 100, 192, 192);
                    decStats.setForeground(Color.blue);
                    try {
                        Thread.sleep(75);
                    } catch (Exception e) {

                    }
                    count += 192;
                } else {
                    count = 0;
                    row += 192;
                }
            } else {
                stay = true;
                enemyMagic = false;
                row = 0;
                count = 0;
                first = true;
            }
        }
    }


    public synchronized void enemyAttack() {
        if (enemyAttack) {
            if (y > 0) {
                try {
                    punch = ImageIO.read(new File("Res/enemyPunch.png"));
                } catch (Exception e) {

                }
                enemyLabel.setIcon(new ImageIcon(punch.getSubimage(y, 0, 100, 60)));
                labelHero.setIcon(new ImageIcon(gg.getSubimage(x, 50, 46, 50)));
                x += 50;
                y -= 99;
                try {
                    Thread.sleep(75);
                } catch (Exception e) {

                }
            } else {
                stay = true;
                y = 0;
                x = 0;
                enemyAttack = false;
            }
        }
    }

    public synchronized void doPunch() {
        if (fight) {
            if (y < 500) {
                try {
                    punch = ImageIO.read(new File("Res/punch.png"));
                } catch (Exception e) {

                }
                labelHero.setIcon(new ImageIcon(punch.getSubimage(y, 0, 100, 60)));
                enemyLabel.setIcon(new ImageIcon(enemy.getSubimage(z, 50, 46, 50)));
                decStats.setForeground(Color.RED);
                z -= 50;
                y += 99;
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                enemyAttack = true;
                decHP = true;
                fight = false;
                y = 501;
                z = 0;
            }
        }
    }

    public synchronized void doMagic() {
        if (magic) {
            if (first) {
                try {
                    DARK = ImageIO.read(new File("Res/DARK.png"));
                } catch (IOException e) {
                }
                first = false;
            }
            if (row < 1152) {
                if (count < 960) {
                    labelMagic.setIcon(new ImageIcon(DARK.getSubimage(count, row, 192, 192)));
                    labelMagic.setBounds(200, 100, 192, 192);
                    decStats.setForeground(Color.blue);
                    try {
                        Thread.sleep(75);
                    } catch (Exception e) {

                    }
                    count += 192;
                } else {
                    count = 0;
                    row += 192;
                }
            } else {
                decHP = true;
                enemyMagic = true;
                magic = false;
                count = 0;
                row = 0;
                first = true;
            }
        }
    }

    public synchronized void doStay() {
        if (stay) {
            x += 152;
            z += 40;
            if (x > 760) {
                x = 0;
            }
            if (z > 160) {
                z = 0;
            }
            labelHero.setIcon(new ImageIcon(gg.getSubimage(x, 0, 144, 280)));
            enemyLabel.setIcon(new ImageIcon(enemy.getSubimage(z, 0, 40, 50)));
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            btnAttack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    stay = false;
                    fight = true;
                    z = 310;
                    x = 0;
                    decEnemy = true;
                }
            });
            btnMagic.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(zet>0 && decMP != true) {
                        stay = false;
                        magic = true;
                        decMP = true;
                        decEnemy = true;
                    }
                }
            });
            labelHero.updateUI();
        }
    }

    public synchronized void attackHP() {
        if (decHP) {
            if (cay <=0){
                END = false;
            }
            if (rand) {
                k = rand(20, 50);
                rand = false;
            }
            if (dec < k) {
                cay--;
                hpLabel.setBounds(0, 0, cay, 20);
                dec++;
                /*decStats.setVisible(true);
                decStats.setForeground(Color.RED);
                decStats.setText("" + k);
                decStats.setBounds(220, koorY,40,20);
                koorY--;*/
            } else {
                decHP = false;
                dec = 0;
                koorY = 190;
                rand = false;
                decStats.setVisible(false);
            }
        }
    }

    public synchronized void attackMP() {
        if (decMP) {
            if (dec < 40) {
                zet--;
                mpLabel.setBounds(0, 20, zet, 20);
                dec++;
            } else {
                decMP = false;
                dec = 0;
            }
        }
    }


    public synchronized void decEnemy() {
        if (decEnemy) {
            if (gamma >= 640){
                END = false;
            }
            if (rand) {
                k = rand(20, 50);
                rand = false;
            }
            if (dec < k) {
                gamma++;
                enemyHP.setBounds(gamma, 0, 290, 40);
                dec++;
                decStats.setVisible(true);
                decStats.setText("" + k);
                decStats.setBounds(220, koorY, 40, 20);
                koorY--;
            } else {
                rand = true;
                decEnemy = false;
                dec = 0;
                koorY = 190;
                decStats.setVisible(false);
            }
        }
    }

    public int rand(int a, int b) {
        Random r = new Random();
        return r.nextInt(b);
    }

    public boolean END(){
        if(END){
            return true;
        }
        else{
            return false;
        }
    }

    public void enemyII(){
        if(enemyII){
            if(stepMagic == 0){
                if (rand(0, 5) % 2 == 0){
                    enemyAttack = true;
                    enemyII = false;
                }
                else {
                    enemyMagic = true;
                    enemyII = false;
                    stepMagic = 0;
                }
            }else{
                enemyAttack = true;
                stepMagic--;
                enemyII = false;
            }
        }
    }
}

