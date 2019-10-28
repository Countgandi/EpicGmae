package com.countgandi.com.menus;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Menu {
	
	public void render(Graphics g);
	public void tick();
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void mouseDragged(MouseEvent e);

}
