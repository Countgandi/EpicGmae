package com.countgandi.com.game.entities;

import java.awt.Graphics;

import com.countgandi.com.Assets;
import com.countgandi.com.game.Handler;

public class Player extends Entity {
	
	private static final int speed = 2;

	public Player(float x, float y, Handler handler) {
		super(x, y, handler);
		height = 48;
		imageHeight = 48;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (handler.up) {
			velY = -speed;
		} else if(!handler.down) {
			velY = 0;
		}
		if (handler.down) {
			velY = speed;
		} else if(!handler.up) {
			velY = 0;
		}
		if (handler.left) {
			velX = -speed;
		} else if(!handler.right) {
			velX = 0;
		}
		if (handler.right) {
			velX = speed;
		} else if(!handler.left) {
			velX = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player[0], (int)x, (int)y, imageWidth, imageHeight, null);
	}

}
