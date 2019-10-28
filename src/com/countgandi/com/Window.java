package com.countgandi.com;

import java.awt.Component;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;
	
	public Window(int width, int height, String title, Component comp) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.add(comp);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public JFrame getJFrame() {
		return frame;
	}
	
}
