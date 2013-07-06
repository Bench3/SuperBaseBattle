package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User: Ben
 * Date: 06/07/13
 * Time: 01:06
 */
public class SuperBaseBattle extends JavaPlugin {


	public static ArrayList<Arena> arenaList = new ArrayList<Arena>();
	public static World spawnWorld;

	public static void main(String[] args) {
		// Not Used
	}

	public void onEnable() {
		this.getLogger().info(getDescription().getName() + " Has Been Enabled!");
		if (!new File(getDataFolder(), "Reset.file").exists()) try {
			new File(getDataFolder(), "Reset.file").createNewFile();
			getConfig().set("SBB World", "SuperBaseBattle");
			getConfig().set("Spawn World", "Spawn");
			getConfig().set("Arenas.0.minX", "0");
			getConfig().set("Arenas.0.maxX", "40");
			getConfig().set("Arenas.0.minZ", "0");
			getConfig().set("Arenas.0.maxZ", "40");
			getConfig().set("Arenas.0.RedSpawn", "10,64,20");
			getConfig().set("Arenas.0.BlueSpawn", "30,64,20");
			saveConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		defineVariables();
	}

	public void onDisable() {
		this.getLogger().info(getDescription().getName() + " Has Been Disabled!");
	}

	private void defineVariables() {
		spawnWorld = Bukkit.getWorld(getConfig().getString("SBB World"));
		for (String s : getConfig().getConfigurationSection("Arenas").getKeys(false)) {
			try {
				Integer.valueOf(s);
			} catch (Exception e) {
				continue;
			}
			String[] redSpawn = getConfig().getString("Arenas." + s + ".RedSpawn").split(",");
			String[] blueSpawn = getConfig().getString("Arenas." + s + ".BlueSpawn").split(",");
			int redSpawnX = Integer.valueOf(redSpawn[0]), redSpawnY = Integer.valueOf(redSpawn[1]), redSpawnZ = Integer.valueOf(redSpawn[2]);
			int blueSpawnX = Integer.valueOf(blueSpawn[0]), blueSpawnY = Integer.valueOf(blueSpawn[1]), blueSpawnZ = Integer.valueOf(blueSpawn[2]);

			arenaList.add(new Arena(getConfig().getInt("Arenas." + s + ".minX"), getConfig().getInt("Arenas." + s + ".maxX"), getConfig().getInt("Arenas." + s + ".minZ"), getConfig().getInt("Arenas." + s + ".maxZ"), new Location(Bukkit.getWorld(getConfig().getString("SBB World")), redSpawnX, redSpawnY, redSpawnZ), new Location(Bukkit.getWorld(getConfig().getString("SBB World")), blueSpawnX, blueSpawnY, blueSpawnZ), Integer.valueOf(s)));
		}
	}
}
