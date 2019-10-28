package com.countgandi.com.game.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Camera;

public class MapHandler {
	
	public static float waterTicker;
	public static int MapSizeX = 128, MapSizeY = 128;
	private Tile[][] tileMap = new Tile[128][128];
	
	public MapHandler() {
		loadMap(Assets.map);
	}
	
	public void loadMap(BufferedImage img) {
		MapSizeX = img.getWidth();
		MapSizeY = img.getHeight();
		tileMap = new Tile[MapSizeX][MapSizeY];
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				tileMap[x][y] = getTile(img.getRGB(x, y));
			}
		}
	}
	
	public void tick() {
		waterTicker += 0.1f;
		waterTicker %= 4;
	}
	
	public void render(Graphics g) {
		for (int x = (int) Math.round(Camera.x / Tile.TILE_WIDTH) - 1; x < (int) Math.round(Camera.x / Tile.TILE_WIDTH + Camera.getRectangle().getWidth() / Tile.TILE_WIDTH) + 1; x++) {
			for (int y = (int) Math.round(Camera.y / Tile.TILE_HEIGHT) - 1; y < (int) Math.round(Camera.y / Tile.TILE_HEIGHT + Camera.getRectangle().getHeight() / Tile.TILE_HEIGHT) + 1; y++) {
				if (x >= 0 && y >= 0 && x < tileMap.length && y < tileMap[0].length) {
					g.drawImage(Assets.tiles[tileMap[x][y].getTileValue()], x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, null);
				}
			}
		}
	}
	
	public static Tile getTile(int color) {
		for(Tile t: Tile.values()) {
			if (t.getTileColor() == color) {
				return t;
			}
		}
		return Tile.Grass;
	}

}
