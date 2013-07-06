package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle.Utils;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
}
