package com.countgandi.com.game.map;

public enum Tile {

	/*
	 * Naming conventions: L - left R - right T - top B - bottom I - inside A -
	 * around/surround
	 * 
	 * S - sand G - grass W - water
	 * 
	 */

	Water(10, 0xFF00AAFF),

	Grass(17, 0xFF6A6469),

	// corners for grass to sand
	LTSA_Grass(0, 0xFF6A6851), TSA_Grass(1, 0xFF6A77F1), RTSA_Grass(2, 0xFF6A6C39), RSA_Grass(18, 0xFF6A7BD9), BRSA_Grass(34, 0xFF6A7021), BSA_Grass(33, 0xFF6A7FC1), BLSA_Grass(32, 0xFF6A7409), LSA_Grass(16, 0xFF6A83A9), LTSI_Grass(48, 0xFF6A9349), RTSI_Grass(50, 0xFF6A8F61), RBSI_Grass(82,
			0xFF6A8B79), LBSI_Grass(80, 0xFF6A8791),

	Sand(3, 0xFF3587B4);

	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	private int tileValue, tileColor;

	private Tile(int tileValue, int tileColor) {
		this.tileValue = tileValue;
		this.tileColor = tileColor;
	}

	public int getTileValue() {
		if(tileValue == 10) {
			return (int) (tileValue + MapHandler.waterTicker);
		}
		return tileValue;
	}

	public int getTileColor() {
		return tileColor;
	}
}
