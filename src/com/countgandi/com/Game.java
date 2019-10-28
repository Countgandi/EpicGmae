package com.countgandi.com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.countgandi.com.game.InputHandler;
import com.countgandi.com.menus.GameMenu;
import com.countgandi.com.menus.Menu;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private static boolean running = false;
	private static Thread thread;
	
	public static int WINDOW_WIDTH = 1600, WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9;
	public static final int WIDTH = 512, HEIGHT = WIDTH / 16 * 9;
	public static final String TITLE = "Girl Thign Game";
	
	private InputHandler inputs;
	private Window window;
	private Menu menu;
	
	public Game() {
		Assets.loadAssets();
		window = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, TITLE, this);
		inputs = new InputHandler(this);
		
		menu = new GameMenu();
		
		this.addKeyListener(inputs);
		this.addMouseListener(inputs);
		this.addMouseMotionListener(inputs);
		
		start();
	}
	
	private double temp_width = WINDOW_WIDTH, temp_height = WINDOW_HEIGHT;
	private void tick() {
		WINDOW_WIDTH = window.getJFrame().getWidth();
		WINDOW_HEIGHT = window.getJFrame().getHeight();
		temp_width = (double)WINDOW_WIDTH / (double)WIDTH;
		temp_height = (double)WINDOW_HEIGHT / (double)HEIGHT;
		
		menu.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		((Graphics2D)g).scale(temp_width, temp_height);
		
		menu.render(g);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
	
	private synchronized void start() {
		if(running) {
			return;
		}
		
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		long start2 = start;
		long current = start;
		int fps = 0;
		
		while(running) {
			current = System.currentTimeMillis();
			
			render();
			fps ++;
			
			if(current - start2 > 1000.0f / 60.0f) {
				tick();
				start2 = current;
			}
			
			if(current - start > 1000) {
				System.out.println("Fps: " + fps);
				fps = 0;
				start = current;
			}
		}
	}
	
	public Menu getMenu() {
		return menu;
	}

}
