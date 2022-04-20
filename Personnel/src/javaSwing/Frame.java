package javaSwing;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	public Frame(String title) {
		setTitle(title);
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false); empêche de redimensionner la fênetre manuellement
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
