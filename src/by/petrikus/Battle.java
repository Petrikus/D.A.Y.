package by.petrikus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Battle extends JDialog {

    private final JButton btnAttack;
    private final JButton btnMagic;
    private final JLabel enemyLabel;
    private final JLabel mpLabel;
    private final JLabel hpLabel;
    private final JLabel enemyHP;
    private final JLabel decStats;
    BufferedImage gg, punch, DARK, enemy;
    int x = 0, manaPoint = 290, gamma = 350, row = 0, count = 0, cay = 290, dec = 0, coorX = 190, coorY = 190, stepMagic = 0;
    int y = 0, healthPoint = 290, saveHealth = 290;
    double difference = 0;
    boolean stay = true, fight = false, magic = false, decHP = false, decMP = false, decEnemy = false, rand = true, enemyAttack = false, END, WIN;
    private JLabel labelHero;
    private JLabel labelMagic;
    Stats person;
    private int z = 0;
    private int k;
    private boolean enemyMagic = false;
    private boolean first = false;
    private boolean enemyII = false;

    public Battle(Stats person) {
        try {
            gg = ImageIO.read(new File("src/Res/GG.png"));
            punch = ImageIO.read(new File("src/Res/punch.png"));
            DARK = ImageIO.read(new File("src/Res/DARK.png"));
            enemy = ImageIO.read(new File("src/Res/ledi_statika.png"));
        } catch (Exception e) {

        }
        this.person = person;

        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        mpLabel = new JLabel("");
        mpLabel.setOpaque(true);
        mpLabel.setBackground(Color.blue);
        mpLabel.setBounds(0, 20, manaPoint, 20);
        getContentPane().add(mpLabel);

        decStats = new JLabel();
        getContentPane().add(decStats);

        hpLabel = new JLabel("");
        hpLabel.setOpaque(true);

        hpLabel.setBackground(Color.RED);
        hpLabel.setBounds(0, 0, healthPoint, 20);
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
        labelHero.setBounds(128, 90, 167, 280);
        getContentPane().add(labelHero);

        labelMagic = new JLabel("");
        labelMagic.setBounds(200, 100, 192, 192);
        getContentPane().add(labelMagic);

        enemyLabel = new JLabel("");
        enemyLabel.setBounds(428, 90, 150, 296);
        getContentPane().add(enemyLabel);

        JLabel ground = new JLabel(new ImageIcon("src/Res/fon.jpg"));
        ground.setOpaque(false);
        ground.setBounds(0,0,640,480);
        getContentPane().add(ground);
        ground.updateUI();
        setVisible(true);
    }

    public synchronized void enemyMagic() {
        if (enemyMagic) {
            if (first) {
                try {
                    DARK = ImageIO.read(new File("src/Res/ICE.png"));
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
            if (y < 750) {
                try {
                    punch = ImageIO.read(new File("src/Res/ledi_ataka.png"));
                } catch (Exception e) {

                }
                enemyLabel.setIcon(new ImageIcon(punch.getSubimage(y, 0, 150, 290)));
                labelHero.setIcon(new ImageIcon(gg.getSubimage(x, 50, 46, 50)));
                x += 150;
                y += 150;
                try {
                    Thread.sleep(100);
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
            if (y < 835) {
                    try {
                        punch = ImageIO.read(new File("src/Res/rma.png"));
                    } catch (Exception e) {

                    }
                labelHero.setIcon(new ImageIcon(punch.getSubimage(y, 0, 167, 280)));
                enemyLabel.setIcon(new ImageIcon(enemy.getSubimage(z, 50, 46, 50)));
                decStats.setForeground(Color.RED);
                z -= 50;
                y += 167;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                first = true;
                enemyAttack = true;
                decHP = true;
                fight = false;
                y = 0;
                z = 0;
            }
        }
    }

    public synchronized void doMagic() {
        if (magic) {
            if (first) {
                try {
                    DARK = ImageIO.read(new File("src/Res/DARK.png"));
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
            z += 148;
            if (x > 760) {
                x = 0;
            }
            if (z > 444) {
                z = 0;
            }
            labelHero.setIcon(new ImageIcon(gg.getSubimage(x, 0, 144, 280)));
            enemyLabel.setIcon(new ImageIcon(enemy.getSubimage(z, 0, 150, 296)));
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            btnAttack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (stay) {
                        stay = false;
                        fight = true;
                        z = 310;
                        x = 0;
                        decEnemy = true;
                    }
                }
            });
            btnMagic.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(stay) {
                        if (manaPoint > 0 && decMP != true) {
                            stay = false;
                            magic = true;
                            decMP = true;
                            decEnemy = true;
                        }
                    }
                }
            });
            labelHero.updateUI();
        }
    }

    public synchronized void attackHP() {
        if (decHP) {
            k = rand(50);
            rand = false;
            difference = ((double) (person.getHP() - k) / (double) person.getHP());
            difference = (double) saveHealth * difference;
            difference = saveHealth - (int) difference;
            healthPoint -= difference;
            hpLabel.setBounds(0, 0, healthPoint, 20);
            dec++;
            decStats.setVisible(true);
            decStats.setForeground(Color.RED);
            decStats.setText("" + k);
            decStats.setBounds(220, coorY, 40, 20);
            coorY--;
            decHP = false;
            dec = 0;
            coorY = 190;
            rand = false;
            decStats.setVisible(false);
            if (healthPoint <= 0) {
                END = true;
                WIN = false;
            }
        }
    }

    public synchronized void attackMP() {
        if (decMP) {
            if (dec < 40) {
                manaPoint--;
                mpLabel.setBounds(0, 20, manaPoint, 20);
                dec++;
            } else {
                decMP = false;
                dec = 0;
            }
        }
    }


    public synchronized void decEnemy() {
        if (decEnemy) {
            k = rand(person.getDamage());
            rand = false;
            gamma += k;
            enemyHP.setBounds(gamma, 0, 290, 40);
            dec++;
            decStats.setVisible(true);
            decStats.setText("" + k);
            decStats.setBounds(220, coorY, 40, 20);
            coorY--;
            decEnemy = false;
            dec = 0;
            coorY = 190;
            decStats.setVisible(false);
            if (gamma >= 640) {
                END = true;
                WIN = false;
            }
        }
    }

    public int rand(int b) {
        Random r = new Random();
        return r.nextInt(b);
    }

    public String END(){
        if(WIN){
            return "ПОБЕДА!";
        }
        else{
            return "Поражение(";
        }
    }

    public void enemyII(){
        if(enemyII){
            if(stepMagic == 0){
                if (rand(5) % 2 == 0){
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

