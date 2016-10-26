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

public class Information extends JDialog{
	HashMap<String, String> map = new HashMap<String, String>();
	String headString = "", bodyString = "", legsString = "", handLString = "", handRString = "";
	final char[][] shmot = new char[15][5];
	boolean hand = true;
	BufferedImage image, ves;
	JRadioButton one, two, three, four, five, six, seven, eight, head, body, legs, handL, handR;
	final JPanel panel;
	JTabbedPane tabbedPane;
	JScrollPane scrollPane;
	ButtonGroup buttonGroup;
	String word;
	JLabel label = new JLabel();
	public Information(HashMap<String, String> reees) {
		map = reees;
		try{
			image = ImageIO.read(new File("Res/Carts.png"));
			ves = ImageIO.read(new File("Res/kol.png"));
		}catch (Exception e){
		setModal(true);
		}
		int i = 0;
		for(String s : reees.keySet()){
			shmot[i] = s.toCharArray();
			i++;
		}
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(355, 11, 269, 305);
		getContentPane().add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Equipment", null, panel, null);
		thisButton();

		setSize(640,480);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		addButton();

		toEquip();

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cart", null, panel_1, null);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (one.isSelected()) {

						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[0][i]);
						}
						switch (shmot[0][2]) {
							case 'h':
								if(headString == ""){
									one.setVisible(false);
								}else {
									one.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									one.setVisible(false);
								}else {
									one.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':
								if(legsString == ""){
									one.setVisible(false);
								}else {
									one.setText(legsString);
								}
								addLegs(s);

								break;
							case 'r':
								if (hand) {
									if(handRString == ""){
										one.setVisible(false);
									}else {
										one.setText(handRString);
									}
									addhandR(s);
								} else {
									if(handLString == ""){
										one.setVisible(false);
									}else {
										one.setText(handLString);
									}
									addhandL(s);

								}
								break;
						}
					} else if (two.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[1][i]);
						}
						switch (shmot[1][2]) {
							case 'h':
								if(headString == ""){
									two.setVisible(false);
								}else {
									two.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									two.setVisible(false);
								}else {
									two.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':
								if(legsString == ""){
									two.setVisible(false);
								}else {
									two.setText(legsString);
								}
								addLegs(s);
								break;
							case 'r':
								if (hand) {
									if(handRString == ""){
										two.setVisible(false);
									}else {
										two.setText(handRString);
									}
									addhandR(s);
								} else {
									if(handLString == ""){
										two.setVisible(false);
									}else {
										two.setText(handLString);
									}
									addhandL(s);
								}
								break;
						}
					} else if (three.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[2][i]);
						}
						switch (shmot[2][2]) {
							case 'h':
								if(headString == ""){
									three.setVisible(false);
								}else {
									three.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									three.setVisible(false);
								}else {
									three.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':
								if(legsString == ""){
									three.setVisible(false);
								}else {
									three.setText(legsString);
								}
								addLegs(s);
								break;
							case 'r':
								if (hand) {
									if(handRString == ""){
										three.setVisible(false);
									}else {
										three.setText(handRString);
									}
									addhandR(s);
								} else {
									if(handLString == ""){
										three.setVisible(false);
									}else {
										three.setText(handLString);
									}
									addhandL(s);
								}
								break;
						}
					} else if (four.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[3][i]);
						}
						switch (shmot[3][2]) {
							case 'h':
								if(headString == ""){
									four.setVisible(false);
								}else {
									four.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									four.setVisible(false);
								}else {
									four.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':
								if(legsString == ""){
									four.setVisible(false);
								}else {
									four.setText(legsString);
								}
								addLegs(s);
								break;
							case 'r':
								if (hand) {
									if(handRString == ""){
										four.setVisible(false);
									}else {
										four.setText(handRString);
									}
									addhandR(s);
								} else {
									if(handLString == ""){
										four.setVisible(false);
									}else {
										four.setText(handLString);
									}
									addhandL(s);
								}
								break;
						}
					} else if (five.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[4][i]);
						}
						switch (shmot[4][2]) {
							case 'h':
								if(headString == ""){
									five.setVisible(false);
								}else{
									five.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									five.setVisible(false);
								}else{
									five.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':if(legsString == ""){
								five.setVisible(false);
							}else{
								five.setText(legsString);
							}
								addLegs(s);
								break;
							case 'r':
								if (hand) {if(handRString == ""){
									five.setVisible(false);
								}else{
									five.setText(headString);
								}
									addhandR(s);
								} else {if(handLString == ""){
									five.setVisible(false);
								}else{
									five.setText(handLString);
								}
									addhandL(s);
								}
								break;
						}
					} else if (six.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[5][i]);
						}
						switch (shmot[5][2]) {
							case 'h':
								if(headString == ""){
									six.setVisible(false);
								}else{
									six.setText(headString);
								}
								addHead(s);
								break;
							case 'a':if(bodyString == ""){
								six.setVisible(false);
							}else{
								six.setText(bodyString);
							}
								addBody(s);
								break;
							case 'l':if(legsString == ""){
								six.setVisible(false);
							}else{
								six.setText(legsString);
							}
								addLegs(s);
								break;
							case 'r':
								if (hand) {if(handRString == ""){
									six.setVisible(false);
								}else{
									six.setText(handRString);
								}
									addhandR(s);
								} else {if(handLString == ""){
									six.setVisible(false);
								}else{
									six.setText(handLString);
								}
									addhandL(s);
								}
								break;
						}
					} else if (seven.isSelected()) {String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[6][i]);
						}
						switch (shmot[6][2]) {
							case 'h':
								if(headString == ""){
									seven.setVisible(false);
								}else{
									seven.setText(headString);
								}
								addHead(s);
								break;
							case 'a':
								if(bodyString == ""){
									seven.setVisible(false);
								}else{
									seven.setText(bodyString);
								}
								addBody(s);
								break;
							case 'l':if(legsString == ""){
								seven.setVisible(false);
							}else{
								seven.setText(legsString);
							}
								addLegs(s);
								break;
							case 'r':
								if (hand) {if(handRString == ""){
									seven.setVisible(false);
								}else{
									seven.setText(handRString);
								}
									addhandR(s);
								} else {if(handLString == ""){
									seven.setVisible(false);
								}else{
									seven.setText(handLString);
								}
									addhandL(s);
								}
								break;
						}
					} else if (eight.isSelected()) {
						String s = "";
						for (int i = 0; i < 5; i++){
							s += String.valueOf(shmot[7][i]);
						}
						switch (shmot[7][2]) {
							case 'h':
								if(headString == ""){
									eight.setVisible(false);
								}else{
									eight.setText(headString);
								}
								addHead(s);
								break;
							case 'a':if(bodyString == ""){
								eight.setVisible(false);
							}else{
								eight.setText(bodyString);
							}
								addBody(s);
								break;
							case 'l':if(legsString == ""){
								eight.setVisible(false);
							}else{
								eight.setText(legsString);
							}
								addLegs(s);
								break;
							case 'r':
								if (hand) {if(handRString == ""){
									eight.setVisible(false);
								}else{
									eight.setText(handRString);
								}
									addhandR(s);
								} else {if(handLString == ""){
									eight.setVisible(false);
								}else{
									eight.setText(handLString);
								}
									addhandL(s);
								}
								break;
						}
					}
				}catch (Exception arg0){

				}
			}
		});
		btnNewButton.setBounds(59, 293, 89, 23);

		getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(one.isSelected()){
					map.remove(one);
				}
				else if(two.isSelected()){
					map.remove(two.getText());
				}
				else if(three.isSelected()){
					map.remove(three.getText());
				}
				else if(four.isSelected()){
				 	map.remove(four.getText());
				 }
				else if (five.isSelected()){
				 	map.remove(five.getText());
				 }
				else if(six.isSelected()){
				 	map.remove(six.getText());
				 }
				else if(seven.isSelected()){
				 	map.remove(seven.getText());
				 }
				else if(eight.isSelected()){
					map.remove(eight.getText());
				}
			}
		});
		btnNewButton_1.setBounds(59, 327, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(one.isSelected()) {
					label.setIcon(new ImageIcon(image.getSubimage(0, 0, 173, 283)));
					label.setBounds(0, 0, 173, 283);
					panel_1.add(label);
				} if(two.isSelected()){
					label.setIcon(new ImageIcon(image.getSubimage(173, 0, 173, 283)));
					label.setBounds(0, 0, 173, 283);
					panel_1.add(label);
				}if (three.isSelected()){
					label.setIcon(new ImageIcon(image.getSubimage(346, 0, 173, 283)));
					label.setBounds(0, 0, 171, 283);
					panel_1.add(label);
				}if (four.isSelected()){
					label.setIcon(new ImageIcon(image.getSubimage(519, 0, 173, 283)));
					label.setBounds(0, 0, 171, 283);
					panel_1.add(label);
				}
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

	public void addHead(String s){
		if(headString != "") {
			toChange(headString);
			word = headString;
			headString = map.get(s);
		}else{
			headString = map.get(s);
			word = headString;
		}
		head.setText("Head : " + map.get(s));
		toYou(s);
		head.setVisible(true);
		tabbedPane.updateUI();
		panel.updateUI();
	}

	public void addBody(String s){
		if(bodyString != "") {
			toChange(bodyString);
			word = bodyString;
			bodyString = map.get(s);
		}else{
			bodyString = map.get(s);
			word = bodyString;
		}
		body.setText("Body : " + map.get(s));
		toYou(s);
		body.setVisible(true);
		tabbedPane.updateUI();
		panel.updateUI();
	}

	public void addLegs(String s){
		if(legsString != "") {
			toChange(legsString);
			word = legsString;
			legsString = map.get(s);
		}else{
			legsString = map.get(s);
			word = legsString;
		}
		legs.setText("Legs : " + map.get(s));
		toYou(s);
		legs.setVisible(true);
		tabbedPane.updateUI();
		panel.updateUI();
	}

	private void addhandL(String s){
		if(handLString != "") {
			toChange(handLString);
			word = handLString;
			handLString = map.get(s);
		}else{
			handLString = map.get(s);
			word = handLString;
		}
		handL.setText("Hand left : " + map.get(s));
		toYou(s);
		handL.setVisible(true);
		hand = true;
		tabbedPane.updateUI();
		panel.updateUI();
	}

	private void addhandR(String s){
		if(handRString != "") {
			toChange(handRString);
			word = handRString;
			handRString = map.get(s);
		}else{
			handRString = map.get(s);
			word = handRString;
		}
		handR.setText("Hand right : " + map.get(s));
		toYou(s);
		hand = false;
		handR.setVisible(true);
		tabbedPane.updateUI();
		panel.updateUI();
	}

	public HashMap<String, String> returnMap(){
		return map;
	}

	private void addButton() {
		if (shmot[0][0] == 'r') {
			one.setText(map.get(String.valueOf(shmot[0])));
			one.setVisible(true);
		}			if(shmot[1][0] == 'r') {
			two.setText(map.get(String.valueOf(shmot[1])));
			two.setVisible(true);

		}			if(shmot[2][0] == 'r') {
			three.setText(map.get(String.valueOf(shmot[2])));
			three.setVisible(true);

		}			if(shmot[3][0] == 'r') {
			four.setText(map.get(String.valueOf(shmot[3])));
			four.setVisible(true);

		}			if(shmot[4][0] == 'r') {
			five.setText(map.get(String.valueOf(shmot[4])));
			five.setVisible(true);

		}			if(shmot[5][0] == 'r') {
			six.setText(map.get(String.valueOf(shmot[5])));
			six.setVisible(true);

		}			if(shmot[6][0] == 'r') {
			seven.setText(map.get(String.valueOf(shmot[6])));
			seven.setVisible(true);

		}			if(shmot[7][0] == 'r') {
			eight.setText(map.get(String.valueOf(shmot[7])));
			eight.setVisible(true);

		}
		setVisible(true);
	}

	private void addEquip(int j){
		if(shmot[j][2] == 'h'){
			headString = map.get(String.valueOf(shmot[j]));
		head.setText("Head : " + map.get(String.valueOf(shmot[j])));
			head.setVisible(true);
		}if(shmot[j][2] == 'a'){
			bodyString=map.get(String.valueOf(shmot[j]));
		body.setText("Body : " + map.get(String.valueOf(shmot[j])));
			body.setVisible(true);
		}if(shmot[j][2] == 'l'){
			legsString = map.get(String.valueOf(shmot[j]));
		legs.setText("Legs : " + map.get(String.valueOf(shmot[j])));
			legs.setVisible(true);
		}
		if(hand) {
			if (shmot[j][2] == 'r') {
				handRString = map.get(String.valueOf(shmot[j]));
				handR.setText("Hand right : " + map.get(String.valueOf(shmot[j])));
				hand = false;
				handR.setVisible(true);
			}
		}
		else {
			if (shmot[j][2] == 'r'){
				handLString = map.get(String.valueOf(shmot[j]));
				handL.setText("Hand left : " + map.get(String.valueOf(shmot[j])));
				hand = true;
				handL.setVisible(true);
			}
		}
	}

	private void toYou(String s){
		char[] r = s.toCharArray();
		r[0] = 'n';
		String a = map.get(s);
		map.remove(s);
		map.put(String.valueOf(r), a);
	}

	private void toChange(String s) {
		String k = "";
		for (String z : map.keySet()) {
			if (s.equals(map.get(z))) {
				k = z;
				break;
			}
		}
		char[] newPok = k.toCharArray();
		newPok[0] = 'r';
		String newShmot = map.get(k);
		map.remove(k);
		map.put(String.valueOf(newPok), newShmot);
	}

	public void toEquip(){
		for (int j = 0; j < map.size(); j++) {
			if(shmot[j][0] == 'n')
				addEquip(j);
		}
	}

	public void thisButton(){
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 200, 271);
		getContentPane().add(scrollPane);
		buttonGroup = new ButtonGroup();

		head = new JRadioButton();
		head.setBounds(10,10,200,20);
		panel.add(head);
		head.setVisible(false);

		body = new JRadioButton();
		body.setBounds(10,30,200,20);
		panel.add(body);
		body.setVisible(false);

		legs = new JRadioButton();
		legs.setBounds(10, 50,200,20);
		panel.add(legs);
		legs.setVisible(false);

		handL = new JRadioButton();
		handL.setBounds(10,70,200,20);
		panel.add(handL);
		handL.setVisible(false);

		handR = new JRadioButton();
		handR.setBounds(10,90,200,20);
		panel.add(handR);
		handR.setVisible(false);

		one = new JRadioButton();
		one.setBounds(10, 10, 150, 25);
		scrollPane.add(one);
		buttonGroup.add(one);
		one.setVisible(false);

		two = new JRadioButton();
		two.setBounds(10, 35, 150, 25);
		scrollPane.add(two);
		buttonGroup.add(two);
		two.setVisible(false);

		three = new JRadioButton();
		three.setBounds(10, 60, 150, 25);
		scrollPane.add(three);
		buttonGroup.add(three);
		three.setVisible(false);

		four = new JRadioButton();
		four.setBounds(10, 85, 150, 25);
		scrollPane.add(four);
		buttonGroup.add(four);
		four.setVisible(false);

		five = new JRadioButton();
		five.setBounds(10, 110, 150, 25);
		scrollPane.add(five);
		buttonGroup.add(five);
		five.setVisible(false);

		six = new JRadioButton();
		six.setBounds(10, 135, 150, 25);
		scrollPane.add(six);
		buttonGroup.add(six);
		six.setVisible(false);

		seven = new JRadioButton();
		seven.setBounds(10, 160, 150, 25);
		scrollPane.add(seven);
		buttonGroup.add(seven);
		seven.setVisible(false);

		eight = new JRadioButton();
		eight.setBounds(10, 185, 150, 25);
		scrollPane.add(eight);
		buttonGroup.add(eight);
		eight.setVisible(false);

	}
}
