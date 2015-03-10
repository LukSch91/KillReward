package me.bukkit.koarl91;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.HelpCommand;

public class KillRewardCommandHandler implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		
		Command cmd = new HelpCommand(sender);
		sender.getName();
		
		//no args show help
		if (args.length == 0) {
			cmd.execute(sender, command, label, args);
			return true;
		}
		
		switch (args[0].toLowerCase()) {
			case "info":
			cmd = new InfoCommand(sender);
			break;
			case "help":
			cmd = new HelpCommand(sender);
			break;
		}
		
		cmd.execute(sender, command, label, args);
		return true;
	}
}

