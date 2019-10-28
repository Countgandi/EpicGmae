package com.countgandi.com.game;

import java.awt.Graphics;
import java.util.ArrayList;

import com.countgandi.com.Game;
import com.countgandi.com.game.entities.Entity;
import com.countgandi.com.game.entities.Player;
import com.countgandi.com.game.map.MapHandler;

public class Handler {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public boolean up, down, left, right;
	
	private MapHandler mapHandler;
	private Player player;
	
	public Handler() {
		mapHandler = new MapHandler();
		createPlayer(90 * 32, 90 * 32);
	}
	
	public void tick() {
		Camera.tick(this);
		mapHandler.tick();
		for(Entity e:entities) {
			e.tick();
		}
		player.tick();
	}
	
	public void render(Graphics g) {
		mapHandler.render(g);
		for(Entity e: entities) {
			e.render(g);
		}
		player.render(g);
	}
	
	public void createPlayer(float x, float y) {
		player = new Player(x, y, this);
		Camera.x = x - Game.WIDTH / 2 + player.getWidth() / 2;
		Camera.y = y - Game.HEIGHT / 2 + player.getHeight() / 2;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
