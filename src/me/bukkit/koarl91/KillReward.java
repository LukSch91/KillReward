package me.bukkit.koarl91;

import org.bukkit.plugin.java.JavaPlugin;

public class KillReward extends JavaPlugin {
	
	public static KillReward plugin;
	
	@Override
	public void onEnable() {
		this.getCommand("killreward").setExecutor(new KillRewardCommandHandler());
		this.getCommand("killreward").setTabCompleter(new KillRewardCommandTabCompleter());
	}
	
	@Override
	public void onDisable() {
		
	}
}