package com.countgandi.com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.countgandi.com.Game;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	
	private Game game;
	
	public InputHandler(Game game) {
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		game.getMenu().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.getMenu().keyReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		game.getMenu().mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		game.getMenu().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		game.getMenu().mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
