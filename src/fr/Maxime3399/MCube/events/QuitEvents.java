package fr.Maxime3399.MCube.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.DisplayUtils;

public class QuitEvents implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p =  e.getPlayer();
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		PlayersManager.removePlayer(cp);
		
		boolean mes = true;
		if(DataUtils.getMaintenance()) {
			
			if(!p.hasPermission("mcube.maintenance")) {
				
				mes = false;
				
			}
			
		}
		
		if(mes) {
			
			e.setQuitMessage("�c�l-�r "+p.getDisplayName());
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						
						DisplayUtils.setDisplay(pls);
						
					}
					
				}
				
			}, 10);
			
		}else {
			
			e.setQuitMessage(null);
			
		}
		
	}

}
