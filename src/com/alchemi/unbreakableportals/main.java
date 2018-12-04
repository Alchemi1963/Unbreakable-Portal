package com.alchemi.unbreakableportals;

import java.util.logging.Level;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.permission.Permission;

public class main extends JavaPlugin {

	public static String pluginname;
	public static main instance;
	
	public static boolean VaultPerms = false;
	public static Permission perms;
	
	@Override
	public void onEnable() {
	
		instance = this;
		pluginname = getDescription().getName();
		getServer().getPluginManager().registerEvents(new OnPlayerBreak(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerLeave(), this);
		
		if (setupPermission()) {
			getLogger().log(Level.INFO, "Using Vault based permissions");
			VaultPerms = true;
		}
		
		getCommand("unbreakableportalsbypass").setExecutor(new CommandBypass());
	}
	
	public static boolean hasPermission(Player player, String perm) {
		
		return VaultPerms ? perms.has(player, perm) || player.isOp() : player.hasPermission(perm) || player.isOp();
	}
	
	public static boolean hasPermission(CommandSender sender, String perm) {
		return sender instanceof Player ? sender.isOp() || hasPermission((Player) sender, perm) : true;
	}
	
	private boolean setupPermission() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) return false;
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		if (rsp == null) return false;
		
		perms = rsp.getProvider();
		return perms != null;
	}
	
}
