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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.schedulers.GeneralSheduler;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.PermissionsUtils;
import fr.Maxime3399.MCube.utils.PointsUtils;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		SystemEvents.registerFood(p);
		
		if(MySQLUtils.execute("INSERT INTO `players` (`uuid`, `name`, `data`, `rank`, `staff`, `other_ranks`, `points`, `step`, `tokens`, `credits`, `crystals`, `legendary_steps`, `placement_end`,"
				+ " `gifts`, `chests`, `last_connection`, `connection_streak`, `fly`, `cos_active`, `cos_plus_color`, `season_1_points`, `season_2_points`, `season_3_points`, `season_4_points`, "
				+ "`season_5_points`, `s_time_seconds`, `s_time_minutes`, `s_time_hours`, `r_time_seconds`, `r_time_minutes`, `r_time_hours`, `r_blocks_place`, `r_blocks_break`, `r_chunks`, "
				+ "`r_damages_take`, `r_damages_give`, `r_jump`, `r_drop`, `r_pickup`, `r_deaths`, `r_kill_animals`, `r_kill_monsters`, `r_kill_players`, `r_food`, `r_craft`, `r_chat`, `r_exp`, "
				+ "`r_portal`, `r_shear`, `r_commands`, `r_advancement`, `r_bed`, `r_armorstand`, `r_enchant`, `home1`, `home2`, `home3`, `home4`, `home5`, `home6`, `home7`, `home8`, `home9`, `home10`,"
				+ " `home11`, `home12`, `home13`, `home14`, `home15`, `home16`, `home17`, `home18`, `home19`, `home20`, `home21`, `home22`, `home23`, `home24`, `home25`, `home26`, `home27`, "
				+ "`home28`, `home29`, `home30`, `home31`, `home32`, `home33`, `home34`, `home35`, `home36`, `home37`, `home38`, `home39`, `home40`) VALUES ('"+p.getUniqueId()+"', '"+p.getName()+"', '"+DataUtils.getData()+"'"
						+ ", 'default',"
				+ " 'default', '', '-1', '0', '0', '0', '0', 'false', 'none', '', '', 'none', '0', 'false', 'cosplus2', 'cosplus2', '-1', '-1', '-1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0',"
				+ " '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', "
				+ "'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none',"
				+ " 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none', 'none');", true)) {
			
			for(Player pls : Bukkit.getOnlinePlayers()) {
				
				pls.sendMessage("§aBienvenue §b§l"+p.getName()+"§r §asur §6§lM-Cube§r §a!");
				pls.playSound(pls.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
				
			}
			
		}
		
		CustomPlayer cp = PlayersManager.addPlayer(p);
		PermissionsUtils.calculPermissions(p);
		
		boolean join = true;
		String reason = "";
		
		if(DataUtils.getMaintenance()) {
			
			if(!p.hasPermission("mcube.maintenance")) {
				
				join = false;
				reason = "§cLe serveur est en maintenance !";
				
			}
			
		}else {
			
			int slots = DataUtils.getSlots();
			
			if(Bukkit.getOnlinePlayers().size() >= slots) {
				
				if(Bukkit.getOnlinePlayers().size() >= slots+DataUtils.getSlotsVIP()) {
					
					if(p.hasPermission("mcube.join")) {
						
						join = false;
						reason = "§c§lLe serveur est entièrement pleins !";
						
					}
					
				}else {
					
					join = false;
					reason = "§cSeveur pleins ! L'accès est réservé aux gradés !";
					
				}
				
			}
			
		}
		
		if(!join) {
			
			e.setJoinMessage(null);
			p.kickPlayer(reason);
			
		}else {
			
			if(cp.isFly()) {
				if(p.hasPermission("mcube.fly")) {
					p.setAllowFlight(true);
					p.setFlying(true);
				}else {
					cp.setFly(false);
					p.setAllowFlight(false);
					PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 100);
					p.addPotionEffect(effect);
				}
			}else {
				p.setAllowFlight(false);
			}
			
			if(!cp.getName().equalsIgnoreCase(p.getName())) {
				
				for(Player pls : Bukkit.getOnlinePlayers()) {
					
					pls.sendMessage("§b§l"+cp.getName()+"§r§e est désormais connu sous le nom de §a§l"+p.getName()+"§r §e!");
					pls.playSound(pls.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
					
				}
				
				cp.setName(p.getName());
				
			}
			
			int co = 1;
			for(Player pls : Bukkit.getOnlinePlayers()) {
				co++;
				Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						DisplayUtils.setDisplay(pls);
					}
				}, co);
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

}
