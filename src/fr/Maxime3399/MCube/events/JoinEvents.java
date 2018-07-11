package fr.Maxime3399.MCube.events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.schedulers.GeneralSheduler;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.PointsUtils;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		SystemEvents.registerFood(p);
		
		if(MySQLUtils.execute("INSERT INTO `players` (`uuid`, `name`, `rank`, `staff`, `points`, `step`, `tokens`, `credits`, `plus_color`, `legendary_steps`, `placement_end`, `season_1_points`, `r_time_seconds`, `r_time_minutes`, "
				+ "`r_time_hours`, `r_blocks_place`, `r_blocks_break`, `r_chunks`, `r_damages_take`, `r_damages_give`, `r_jump`, `r_drop`, `r_pickup`, `r_deaths`, `r_kill_animals`, `r_kill_monsters`, `r_kill_players`, `r_food`, `r_craft`,"
				+ " `r_chat`, `r_exp`, `r_portal`, `r_shear`, `r_commands`, `r_advancement`, `r_bed`, `r_armorstand`, `r_enchant`) VALUES ('"+p.getUniqueId().toString()+"', '"+p.getName()+"', 'default', 'default', '-1', '0', '0', '0', '§2', 'false', 'none', '-1', '0', '0', "
				+ "'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');", true)) {
			
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
		
		GeneralSheduler.action(p);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if(!cp.getPlacement_end().equalsIgnoreCase("none")) {
					
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
					Date dO = null;
					try {
						dO = sdf.parse(cp.getPlacement_end());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Date dT = new Date();
					
					if(dO.getTime() < dT.getTime()) {
						
						PointsUtils.placePlayer(p);
						
					}
					
				}
				
			}
			
		}, 10);
		
	}

}
