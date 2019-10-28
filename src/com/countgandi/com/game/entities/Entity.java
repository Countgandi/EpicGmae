package com.countgandi.com.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.countgandi.com.game.Handler;

public abstract class Entity {
	
	protected float x, y, velX, velY;
	protected int width = 32, height = 32, imageWidth = 32, imageHeight = 32, boundingOffx, boundingOffy;
	protected Handler handler;

	public Entity(float x, float y, Handler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle((int)(x + boundingOffx), (int)(x + boundingOffy), width, height);
	}
	
	public Rectangle getImageRectangle() {
		return new Rectangle((int)(x), (int)(x), imageWidth, imageHeight);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getBoundingOffx() {
		return boundingOffx;
	}

	public void setBoundingOffx(int boundingOffx) {
		this.boundingOffx = boundingOffx;
	}

	public int getBoundingOffy() {
		return boundingOffy;
	}

	public void setBoundingOffy(int boundingOffy) {
		this.boundingOffy = boundingOffy;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
