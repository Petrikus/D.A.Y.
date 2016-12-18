package by.petrikus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Information extends JDialog{
    private JList panel;
    ArrayList<EquipmentsBank>map;
	final char[][] shmot = new char[15][5];
    private ListView showList = new ListView();
    private ListView showWear = new ListView();
	BufferedImage image, ves;
	JTabbedPane tabbedPane;
	JScrollPane scrollPane, scrollWear;
	private JList<String> list;
	public Information(ArrayList<EquipmentsBank> reees) {
		map = reees;
		try{
			image = ImageIO.read(new File("Res/Carts.png"));
			ves = ImageIO.read(new File("Res/kol.png"));
		}catch (Exception e){
		setModal(true);
		}
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(355, 11, 269, 305);
		getContentPane().add(tabbedPane);


		thisButton();

		setModal(true);

		setSize(640,480);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cart", null, panel_1, null);
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toEquip(list.getSelectedValue());
			}
		});
		btnNewButton.setBounds(59, 293, 89, 23);

		getContentPane().add(btnNewButton);
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_2.setBounds(59, 361, 89, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnAdd = new JButton("View");
		btnAdd.setBounds(447, 327, 89, 23);
		getContentPane().add(btnAdd);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(ves.getSubimage(0,0, 640, 480)));
		background.setBounds(0,0,640,480);
		getContentPane().add(background);

				setVisible(true);
	}



	public ArrayList<EquipmentsBank> returnMap(){
		return map;
	}

	private void toEquip(String s){
		int i = 0;
		for (EquipmentsBank e : map){
			if(s == e.getName()){
				for (EquipmentsBank newS : map){
					if (newS.getType() == e.getType()) {
						if(newS.isWear()) {
							newS.setWear(false);
							e.setWear(true);
							updateWear();
							i = 0;
							panel.updateUI();
							list.updateUI();
						}
					}
					i++;
				}
				if(i==map.size()){
					e.setWear(true);
					updateWear();
					panel.updateUI();
					list.updateUI();
				}
			}
		}
	}

	private void thisButton(){
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 200, 271);
		getContentPane().add(scrollPane);

        list = new JList<String>(showList);
        scrollPane.setViewportView(list);

        scrollWear = new JScrollPane();
		scrollWear.setBounds(0,0, 260, 300);
		tabbedPane.addTab("Equipment", null, scrollWear, null);

		panel = new JList<String>(showWear);
		scrollWear.setViewportView(panel);

		updateWear();

		panel.updateUI();
        list.updateUI();
	}

	private void updateWear(){
		int i = showList.getSize();
		try {
			for(int j = 0; j < i;) {
				showList.removeElement(j);
			}
		}catch (Exception e){
		}
		i = showWear.getSize();
		try {
			for(int j = 0; j < i;) {
				showWear.removeElement(j);
			}
		}catch (Exception e){

		}
		for (EquipmentsBank s : map){
			if(s.isWear()){
				showWear.addElement(s.getName());
			}
		}

		for (EquipmentsBank s : map){
			if(!s.isWear()){
				showList.addElement(s.getName());
			}
		}
	}
}
