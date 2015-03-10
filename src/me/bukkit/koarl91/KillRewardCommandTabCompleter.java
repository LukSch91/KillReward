package me.bukkit.koarl91;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class KillRewardCommandTabCompleter implements TabCompleter {
	
	private static final String[] COMMANDS = {"info", "help"};
	
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if (sender.isOp() || sender.hasPermission("killreward.admin") || sender.hasPermission("killreward." + args[0])) {
			List<String> completions = new ArrayList<>();
			
			if (args.length == 1) {
				String partialCommand = args[0];
				List<String> commands = new ArrayList<>(Arrays.asList(COMMANDS));
				StringUtil.copyPartialMatches(partialCommand, commands, completions);
			}
			if (args.length == 2) {
				String partialPlugin = args[1];
				List<String> plugins = PluginUtil.getPluginNames(false);
				StringUtil.copyPartialMatches(partialPlugin, plugins, completions);
			}
			Collections.sort(completions);
			return completions;
		}
		return null;
	}
}
