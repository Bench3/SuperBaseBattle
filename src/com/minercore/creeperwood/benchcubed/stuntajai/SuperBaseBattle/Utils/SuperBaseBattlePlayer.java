package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Utils;

import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Arena;
import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Locations;
import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.enums.Team;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 * User: Ben
 * Date: 06/07/13
 * Time: 16:40
 */
public class SuperBaseBattlePlayer {

	private Player player;
	private Team team;

	public SuperBaseBattlePlayer(Player player, Team team) {
		this.player = player;
		this.team = team;
	}

	public boolean teleportToArena(Arena arena) {
		return Locations.teleportToArena(player, team, arena);
	}

	public boolean giveArmour(Team team) {
		ItemStack helmet = Utils.setColour(new ItemStack(Material.LEATHER_BOOTS), team == Team.BLUE ? 0 : 255, 0, team == Team.BLUE ? 255 : 0);
		ItemStack chestplate = Utils.setColour(new ItemStack(Material.LEATHER_BOOTS), team == Team.BLUE ? 0 : 255, 0, team == Team.BLUE ? 255 : 0);
		ItemStack leggings = Utils.setColour(new ItemStack(Material.LEATHER_BOOTS), team == Team.BLUE ? 0 : 255, 0, team == Team.BLUE ? 255 : 0);
		ItemStack boots = Utils.setColour(new ItemStack(Material.LEATHER_BOOTS), team == Team.BLUE ? 0 : 255, 0, team == Team.BLUE ? 255 : 0);
		PlayerInventory pi = player.getInventory();
		pi.setChestplate(chestplate);
		pi.setHelmet(helmet);
		pi.setLeggings(leggings);
		pi.setBoots(boots);
		return true;
	}
}
