package fr.Maxime3399.MCube.events.menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.menus.MainMenu;
import fr.Maxime3399.MCube.menus.RankedMenu;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class RankedMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Jeu Classé")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				
				if(item.equalsIgnoreCase("§a§lSaison 1")) {
					
					if(DataUtils.getCurrentSeason() == 1) {
						
						if(cp.getPoints() == -1) {
							
							if(cp.getPlacement_end().equalsIgnoreCase("none")) {
								
								SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
								Date dO = null;
								try {
									dO = sdf.parse(MySQLUtils.getString("infos", "type", "season_1_end", "info_string"));
								} catch (ParseException ex) {
									ex.printStackTrace();
								}
								Date dT = new Date();
								Long result = dO.getTime()-dT.getTime();
								long d = TimeUnit.MILLISECONDS.toDays(result);
								
								if(d < 3) {
									
									p.sendMessage("§cTu ne peux pas te classer car la saison se termine dans moins de 3 jours !");
									p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
									
								}else {
									
									ConfirmMenu.confirm(p);
									new BukkitRunnable() {
										@Override
										public void run() {
											if(ConfirmMenu.getPlayer(p) == 1) {
												ConfirmMenu.removePlayer(p);
												this.cancel();
												Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
													@Override
													public void run() {
														
														Calendar cal = Calendar.getInstance();
														Date dC = new Date();
														cal.setTime(dC);
														cal.add(Calendar.DAY_OF_MONTH, 3);
														dC.setTime(cal.getTimeInMillis());
														cp.setPlacement_end(sdf.format(dC));
														
														cp.setR_time_seconds(0);
														cp.setR_time_minutes(0);
														cp.setR_time_hours(0);
														cp.setR_blocks_place(0);
														cp.setR_blocks_break(0);
														cp.setR_chunks(0);
														cp.setR_damages_take(0);
														cp.setR_damages_give(0);
														cp.setR_jump(0);
														cp.setR_drop(0);
														cp.setR_pickup(0);
														cp.setR_deaths(0);
														cp.setR_kill_animals(0);
														cp.setR_kill_monsters(0);
														cp.setR_kill_players(0);
														cp.setR_food(0);
														cp.setR_craft(0);
														cp.setR_chat(0);
														cp.setR_exp(0);
														cp.setR_portal(0);
														cp.setR_shear(0);
														cp.setR_commands(0);
														cp.setR_advancement(0);
														cp.setR_bed(0);
														cp.setR_armorstand(0);
														cp.setR_enchant(0);
														
														cp.save();
														
														p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 1);
														p.sendMessage("§a§lTu as commancé tes jours de placement !§r\n§eJoue un maximum durant les trois prochains jours afin d'obtenir un haut classement !");
														p.closeInventory();
														
													}
												}, 1);
											}else if(ConfirmMenu.getPlayer(p) == 2) {
												ConfirmMenu.removePlayer(p);
												this.cancel();
												Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
													@Override
													public void run() {
														RankedMenu.openMenu(p);
														p.sendMessage("§cAction annulée !");
														p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_DEATH, 100, 1);
													}
												}, 1);
											}
										}
									}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
									
								}
								
							}
							
						}
						
					}
					
				}else if(item.equalsIgnoreCase("§a§lSaison 2")) {
					
					if(DataUtils.getCurrentSeason() == 2) {
						
						if(cp.getPoints() == -1) {
							
							if(cp.getPlacement_end().equalsIgnoreCase("none")) {
								
								SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
								Date dO = null;
								try {
									dO = sdf.parse(MySQLUtils.getString("infos", "type", "season_2_end", "info_string"));
								} catch (ParseException ex) {
									ex.printStackTrace();
								}
								Date dT = new Date();
								Long result = dO.getTime()-dT.getTime();
								long d = TimeUnit.MILLISECONDS.toDays(result);
								
								if(d < 3) {
									
									p.sendMessage("§cTu ne peux pas te classer car la saison se termine dans moins de 3 jours !");
									p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
									
								}else {
									
									Calendar cal = Calendar.getInstance();
									Date dC = new Date();
									cal.setTime(dC);
									cal.add(Calendar.DAY_OF_MONTH, 3);
									dC.setTime(cal.getTimeInMillis());
									cp.setPlacement_end(sdf.format(dC));
									
									cp.setR_time_seconds(0);
									cp.setR_time_minutes(0);
									cp.setR_time_hours(0);
									cp.setR_blocks_place(0);
									cp.setR_blocks_break(0);
									cp.setR_chunks(0);
									cp.setR_damages_take(0);
									cp.setR_damages_give(0);
									cp.setR_jump(0);
									cp.setR_drop(0);
									cp.setR_pickup(0);
									cp.setR_deaths(0);
									cp.setR_kill_animals(0);
									cp.setR_kill_monsters(0);
									cp.setR_kill_players(0);
									cp.setR_food(0);
									cp.setR_craft(0);
									cp.setR_chat(0);
									cp.setR_exp(0);
									cp.setR_portal(0);
									cp.setR_shear(0);
									cp.setR_commands(0);
									cp.setR_advancement(0);
									cp.setR_bed(0);
									cp.setR_armorstand(0);
									cp.setR_enchant(0);
									
									cp.save();
									
									p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 1);
									p.sendMessage("§a§lTu as commancé tes jours de placement !§r\n§eJoue un maximum durant les trois prochains jours afin d'obtenir un haut classement !");
									p.closeInventory();
									
								}
								
							}
							
						}
						
					}
					
				}else if(item.equalsIgnoreCase("§8§oRetour")) {
					
					MainMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
