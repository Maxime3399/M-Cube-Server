package fr.Maxime3399.MCube.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(MySQLUtils.execute("INSERT INTO `players` (`uuid`, `name`, `rank`, `staff`, `points`, `step`, `tokens`, `credits`, `plus_color`, `legendary_steps`, `placement_points`, `placement_end`, `season_1_points`) VALUES "
				+ "('"+p.getUniqueId()+"', '"+p.getName()+"', 'default', 'default', '-1', '0', '0', '0', '§2', 'false', '-1', '', '-1');", true)) {
			
			for(Player pls : Bukkit.getOnlinePlayers()) {
				
				pls.sendMessage("§aBienvenue §b§l"+p.getName()+"§r §asur §6§lM-Cube§r §a!");
				pls.playSound(pls.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
				
			}
			
		}
		
		CustomPlayer cp = PlayersManager.addPlayer(p);
		
		if(!cp.getName().equalsIgnoreCase(p.getName())) {
			
			for(Player pls : Bukkit.getOnlinePlayers()) {
				
				pls.sendMessage("§b§l"+cp.getName()+"§r§e est désormais connu sous le nom de §a§l"+p.getName()+"§r §e!");
				pls.playSound(pls.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
				
			}
			
			cp.setName(p.getName());
			
		}
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			DisplayUtils.setDisplay(pls);
			
		}
		
		e.setJoinMessage("§a§l+§r "+p.getDisplayName());
		
	}

}
