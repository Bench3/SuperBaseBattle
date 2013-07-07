package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle;

import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Utils.SuperBaseBattlePlayer;
import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.enums.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.SuperBaseBattle.spawnWorld;
import static com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Utils.Utils.rand;


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
	private Location redSpawn;
	private Location blueSpawn;

	ArrayList<String> playersInGame = new ArrayList<String>();

	public Arena(int minX, int maxX, int minZ, int maxZ, Location redSpawn, Location blueSpawn, int arenaId) {
		this.minX = minX;
		this.maxX = maxX;
		this.minZ = minZ;
		this.maxZ = maxZ;
		this.arenaId = arenaId;
		this.redSpawn = redSpawn;
		this.blueSpawn = blueSpawn;
	}

	public boolean addPlayer(Player player, Team team) {
		if (team == null || player == null || ((redSpawn == null && team == Team.RED) || (blueSpawn == null && team == Team.BLUE)))
			return false;
		SuperBaseBattlePlayer superBaseBattlePlayer = new SuperBaseBattlePlayer(player, team);
		return superBaseBattlePlayer.teleportToArena(this) && superBaseBattlePlayer.giveArmour(team) && playersInGame.add(player.getName());
	}

	public boolean removePlayer(Player player) {
		return playersInGame.remove(player.getName());
	}

	public boolean teleportAllToSpawn() {
		boolean failure = false;
		for (String s : playersInGame)
			if (!Locations.teleportToSpawn(Bukkit.getPlayer(s))) failure = true;
		return !failure;
	}

	public void startGame() {
		generateWall();
	}

	private void generateWall() {
		int wallX = (minX + maxX) / 2;
		Location wallStart = new Location(spawnWorld, wallX, 0, minZ);
		Location wallEnd = new Location(spawnWorld, wallX, spawnWorld.getMaxHeight(), maxZ);
		int startX = wallStart.getBlockX();
		int endX = wallEnd.getBlockX();
		int startZ = wallStart.getBlockZ();
		int endZ = wallEnd.getBlockZ();

		for (int x = startX; x < endX; x++)
			for (int y = wallStart.getBlockY(); y < wallEnd.getBlockY(); y++)
				for (int z = startZ; z < endZ; z++)
					spawnWorld.getBlockAt(x, y, z).setType(rand() ? Material.BEDROCK : rand() ? Material.GLOWSTONE : rand() ? Material.STONE : rand() ? Material.NETHER_BRICK : rand() ? Material.DIAMOND_BLOCK : Material.IRON_BLOCK);
	}

	public int getMinX() {
		return minX;
	}

	public Location getRedSpawn() {
		return redSpawn;
	}

	public Location getBlueSpawn() {
		return blueSpawn;
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
