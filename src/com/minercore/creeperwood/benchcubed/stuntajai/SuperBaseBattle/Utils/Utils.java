package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Utils;

import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Arena;
import com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.SuperBaseBattle;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Random;

/**
 * User: Ben
 * Date: 06/07/13
 * Time: 16:48
 */
public class Utils {

	public static ItemStack setColour(ItemStack is, int red, int green, int blue) {
		LeatherArmorMeta lam = (LeatherArmorMeta) is.getItemMeta();
		lam.setColor(Color.fromRGB(red, green, blue));
		is.setItemMeta(lam);
		return is;
	}

	public static void clearInventory(Player player) {
		player.getInventory().clear();
	}

	public static Arena getArena(int id) {
		for (Arena a : SuperBaseBattle.arenaList)
			if (a.getArenaId() == id)
				return a;
		return null;
	}

	public static boolean rand() {
		return new Random().nextBoolean();
	}
}
