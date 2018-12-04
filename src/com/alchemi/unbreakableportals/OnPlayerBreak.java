package com.alchemi.unbreakableportals;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnPlayerBreak implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onBreak(BlockBreakEvent e) {
		if (CommandBypass.bypassers.contains(e.getPlayer())) return;
		if (e.getBlock().getType().equals(Material.OBSIDIAN)) {
			Location loc = e.getBlock().getLocation();
			
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					for (int z = -1; z <= 1; z++) {
						
						if (e.getPlayer().getWorld().getBlockAt(loc.clone().add(x, y, z)).getType() == Material.NETHER_PORTAL ||
								e.getPlayer().getWorld().getBlockAt(loc.clone().add(x, y, z)).getType() == Material.LEGACY_PORTAL) {
							
							e.setCancelled(true);
							
						}
						
					}
				}
			}
			
		}
	}
	
}
