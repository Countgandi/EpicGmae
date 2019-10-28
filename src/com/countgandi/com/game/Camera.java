package com.countgandi.com.game;

import java.awt.Rectangle;

import com.countgandi.com.Game;
import com.countgandi.com.game.map.MapHandler;
import com.countgandi.com.game.map.Tile;

public class Camera {
	
	public static float x, y;
	
	public static void tick(Handler handler) {
		if (handler.getPlayer() != null) {
			float xx = ((handler.getPlayer().getX() - x) - Game.WIDTH / 2 + (handler.getPlayer().getWidth()) / 2) * 0.025f;
			float yy = ((handler.getPlayer().getY() - y) - Game.HEIGHT / 2 + (handler.getPlayer().getHeight()) / 2) * 0.025f;
			x += xx;
			y += yy;
		}
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x + Game.WIDTH > MapHandler.MapSizeX * Tile.TILE_WIDTH)
			x = MapHandler.MapSizeX * Tile.TILE_WIDTH - Game.WIDTH;
		if (y + Game.HEIGHT > MapHandler.MapSizeY * Tile.TILE_HEIGHT)
			y = MapHandler.MapSizeY * Tile.TILE_HEIGHT - Game.HEIGHT;
	}
	
	public static Rectangle getRectangle() {
		return new Rectangle((int)x, (int)y, Game.WIDTH, Game.HEIGHT);
	}

}
