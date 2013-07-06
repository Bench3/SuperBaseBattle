package com.minercore.creeperwood.benchcubed.stuntajai.SuperBaseBattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 06/07/13
 * Time: 01:06
 * To change this template use File | Settings | File Templates.
 */
public class SuperBaseBattle extends JavaPlugin {

    public static void main(String[] args){
        // Not Used
    }

    public void onEnable() {
        this.getLogger().info(getDescription().getName() + " Has Been Enabled!");
    }

    public void onDisable() {
        this.getLogger().info(getDescription().getName() + " Has Been Disabled!");
    }
}
