package by.petrikus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
    public JMenuBar menuBar;

    public GameWindow() {
        super("Game");
        setSize(640, 480);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);


        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 634, 21);
        getContentPane().add(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenu mnOption = new JMenu("Option");
        menuBar.add(mnOption);


        JLabel tuman = new JLabel(new ImageIcon("src/Res/gif.gif"));
        tuman.setOpaque(false);
        tuman.setBounds(0, 0, 640, 480);
        getContentPane().add(tuman);

        JLabel background = new JLabel(new ImageIcon("src/Res/main.png"));
        background.setOpaque(false);
        background.setBounds(0, 0, 634, 431);
        tuman.add(background);

        JButton btnNewButton = new JButton();
        btnNewButton.setOpaque(true);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choiceCharacter choice = new choiceCharacter();
                hide();
            }
        });
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setText("START");
        btnNewButton.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setForeground(new Color(120, 120, 120));
        btnNewButton.setBounds(240, 261, 180, 52);
        tuman.add(btnNewButton);

        setVisible(true);
    }
}
	

