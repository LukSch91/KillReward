package me.bukkit.koarl91;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.bukkit.koarl91.CommandHandler.CommandHandler;

public class KillReward extends JavaPlugin 
{
	
	public static KillReward plugin;
	public static CommandHandler commandHandler = null;
	
	@Override
	public void onEnable() 
	{
		if(commandHandler != null) commandHandler = new CommandHandler();
	}
	
	@Override
	public void onDisable() 
	{
		if(commandHandler!=null) commandHandler.exit();
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		return commandHandler.cmd(sender,command,label,args);	
	}
}