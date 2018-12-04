package com.alchemi.unbreakableportals;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeave implements Listener {

	@EventHandler
	public static void onLeave(PlayerQuitEvent e) {
		if (CommandBypass.bypassers.contains(e.getPlayer())) {
			CommandBypass.bypassers.remove(e.getPlayer());
		}
	}
	
}
