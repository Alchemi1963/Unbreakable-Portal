package com.alchemi.unbreakableportals;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.alchemi.al.Messenger;

public class CommandBypass implements CommandExecutor{

	public static ArrayList<Player> bypassers = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (main.hasPermission(sender, "up.bypass") && sender instanceof Player) {
			if (!bypassers.contains((Player) sender)) {
				bypassers.add((Player) sender);
				Messenger.sendMsg("&9You can now break &dnether portal&9 blocks.", sender);
				return true;
			}
			bypassers.remove((Player) sender);
			Messenger.sendMsg("&9You can no longer break &dnether portal&9 blocks.", sender);
		}
		
		return true;
	}
	
}
