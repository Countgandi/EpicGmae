package com.countgandi.com;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Assets {
	
	public static BufferedImage[] player;
	public static BufferedImage[] tiles;
	public static BufferedImage map;
	
	/**
	 * This is where the actual:
	 * 		player = loadImage("../player.png")
	 */
	public static void loadAssets() {
		player = loadImageSheet(32, 48, "/tex/female_character.png");
		tiles = loadImageSheet(32, 32, "/tex/tileset.png");
		map = loadImage("/tex/map.png");
	}
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Assets.class.getResourceAsStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.print("Image could not be loaded: " + path);
		return null;
	}
	
	public static BufferedImage[] loadImageSheet(int spriteWidth, int spriteHeight, String path) {
		BufferedImage img = loadImage(path);
		if (img == null) {
			return null;
		}
		int w = img.getWidth() / spriteWidth, h = img.getHeight() / spriteHeight;
		BufferedImage[] imgs = new BufferedImage[w * h];
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				imgs[y * w + x] = img.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight);
			}
		}
		return imgs;
	}

}
