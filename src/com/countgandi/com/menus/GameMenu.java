package com.countgandi.com.menus;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.countgandi.com.game.Camera;
import com.countgandi.com.game.Handler;

public class GameMenu implements Menu {
	
	private Handler handler;
	
	public GameMenu() {
		handler = new Handler();
	}

	@Override
	public void render(Graphics g) {
		((Graphics2D)g).translate(-Camera.x, -Camera.y);
		handler.render(g);
		((Graphics2D)g).translate(Camera.x, Camera.y);
	}

	@Override
	public void tick() {
		handler.tick();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			handler.up = true;
		}
		if(key == KeyEvent.VK_S) {
			handler.down = true;
		}
		if(key == KeyEvent.VK_A) {
			handler.left = true;
		}
		if(key == KeyEvent.VK_D) {
			handler.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			handler.up = false;
		}
		if(key == KeyEvent.VK_S) {
			handler.down = false;
		}
		if(key == KeyEvent.VK_A) {
			handler.left = false;
		}
		if(key == KeyEvent.VK_D) {
			handler.right = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

}
