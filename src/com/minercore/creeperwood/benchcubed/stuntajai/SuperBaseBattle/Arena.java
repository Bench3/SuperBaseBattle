package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle;

/**
 * User: Ben
 * Date: 06/07/13
 * Time: 14:09
 */
public class Arena {

	private int arenaId;
	private int minX;
	private int maxX;
	private int minZ;
	private int maxZ;

	public Arena(int minX, int maxX, int minZ, int maxZ, int arenaId) {
		this.minX = minX;
		this.maxX = maxX;
		this.minZ = minZ;
		this.maxZ = maxZ;
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMinZ() {
		return minZ;
	}

	public int getMaxZ() {
		return maxZ;
	}

	public int getArenaId() {
		return arenaId;
	}
}
