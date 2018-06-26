package fr.Maxime3399.MCube.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class QuitEvents implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p =  e.getPlayer();
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		PlayersManager.removePlayer(cp);
		
		e.setQuitMessage("§c§l-§r "+p.getDisplayName());
		
	}

}
