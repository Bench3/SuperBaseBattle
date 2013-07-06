package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle;

import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.enums.Team;
import org.bukkit.entity.Player;

/**
 * User: Ben
 * Date: 06/07/13
 * Time: 17:01
 */
public class Locations {

	public static boolean teleportToSpawn(Player player) {
		return player.teleport(SuperBaseBattle.spawnWorld.getSpawnLocation());
	}

	public static boolean teleportToArena(Player player, Team team, Arena arena) {
		return player.teleport(team == Team.RED ? arena.getRedSpawn() : arena.getBlueSpawn());
	}
}
