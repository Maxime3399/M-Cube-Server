package fr.Maxime3399.MCube.schedulers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.ChatUtils;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.PointsUtils;

public class GeneralSheduler {
	
	private static HashMap<Player, Integer> afk = new HashMap<>();
	
	public static void action(Player p) {
		
		afk.put(p, 0);
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		cp.setAfk(false);
		
	}
	
	public static void start1() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			boolean mai = DataUtils.getMaintenance();
			
			@Override
			public void run() {
				
				boolean d = true;
				
				if(!DataUtils.getMaintenance()) {
					
					if(mai != DataUtils.getMaintenance()) {
						
						mai = DataUtils.getMaintenance();
						
						Date dEnd = null;
						try {
							dEnd = sdf.parse(MySQLUtils.getString("infos", "type", "season_"+DataUtils.getCurrentSeason()+"_end", "info_string"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Date dS = null;
						try {
							dS = sdf.parse(MySQLUtils.getString("infos", "type", "maintenance_start", "info_string"));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						Date dC = new Date();
						long dif = dC.getTime()-dS.getTime();
						dEnd.setTime(dEnd.getTime()+dif);
						String e = sdf.format(dEnd);
						MySQLUtils.setString("infos", "type", "season_"+DataUtils.getCurrentSeason()+"_end", "info_string", e);
						MySQLUtils.setString("infos", "type", "maintenance_start", "info_string", "");
						
					}
					
					String seasonEnd = null;
					if(seasonEnd == null) {
						seasonEnd = MySQLUtils.getString("infos", "type", "season_"+DataUtils.getCurrentSeason()+"_end", "info_string");
					}
					
					Date dEnd = null;
					try {
						dEnd = sdf.parse(seasonEnd);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Date dCurrent = new Date();
					
					if(dEnd.getTime() < dCurrent.getTime()) {
						
						d = false;
						for(Player pls : Bukkit.getOnlinePlayers()) {
							
							if(pls.getOpenInventory() != null) {
								pls.closeInventory();
							}
							
							PlayersManager.removePlayer(pls);
							
						}
						
						int lastSeason = DataUtils.getCurrentSeason();
						int order = 0;
						for(String st : MySQLUtils.getSortValues("players", "points", "ASC")) {
							
							order = order+1;
							int points = MySQLUtils.getInt("players", "uuid", st, "points");
							if(order == 1) {
								
								//gift TOP 1
								
							}else if(order == 2) {
								
								//gift TOP 2
								
							}else if(order == 3) {
								
								//gift TOP 3
								
							}else {
								
								if(points >= 500) {
									
									//gift Legend
									
								}else if(points >= 400) {
									
									//gift Master
									
								}else if(points >= 300) {
									
									//gift Platinum
									
								}else if(points >= 200) {
									
									//gift Gold
									
								}else if(points >= 100) {
									
									//gift Silver
									
								}else {
									
									//gift Bronze
									
								}
								
							}
							
							MySQLUtils.setInt("players", "uuid", st, "points", -1);
							MySQLUtils.setInt("players", "uuid", st, "season_"+lastSeason+"_points", points);
							
						}
						
						int newSeason = lastSeason+1;
						
						Date dNew = new Date();
						Calendar cal = Calendar.getInstance();
						cal.setTime(dNew);
						cal.add(Calendar.DAY_OF_MONTH, 45);
						dNew.setTime(cal.getTimeInMillis());
						String nd = sdf.format(dNew);
						
						MySQLUtils.execute("INSERT INTO `infos` (`type`, `info_int`, `info_string`) VALUES ('season_"+newSeason+"_end', '0', '"+nd+"');", false);
						seasonEnd = nd;
						MySQLUtils.execute("UPDATE `infos` SET `info_int` = '"+newSeason+"' WHERE `infos`.`type` = 'currentSeason';", false);
						
						for(Player pls : Bukkit.getOnlinePlayers()) {
							
							PlayersManager.addPlayer(pls);
							pls.sendMessage(" \n     §b§l§k||§r  §a§lDébut de la saison §r§6§l"+newSeason+"§r  §b§l§l||§r\n ");
							pls.playSound(pls.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 2);
							DisplayUtils.setDisplay(pls);
							
						}
						
					}
					
				}else {
					
					if(mai != DataUtils.getMaintenance()) {
						
						for(Player pls : Bukkit.getOnlinePlayers()) {
							
							if(!pls.hasPermission("mcube.maintenance")) {
								
								pls.kickPlayer("§cLe serveur est en maintenance !");
								
							}
							
						}
						
						mai = DataUtils.getMaintenance();
						Date dStart = new Date();
						MySQLUtils.setString("infos", "type", "maintenance_start", "info_string", sdf.format(dStart));
						
					}
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						ChatUtils.sendActionBar(pls, "§b§lMAINTENANCE EN COURS", 2, 20, 2);
					}
					
				}
				
				if(d) {
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						
						CustomPlayer cps = PlayersManager.getCustomPlayer(pls);
						
						if(afk.containsKey(pls)) {
							
							afk.put(pls, afk.get(pls)+1);
							
							if(afk.get(pls) >= 60) {
								
								cps.setAfk(true);
								
							}
							
						}
						
						if(!cps.isAfk()) {
							
							if(!cps.getPlacement_end().equalsIgnoreCase("none")) {
								
								Date dO = null;
								try {
									dO = sdf.parse(cps.getPlacement_end());
								} catch (ParseException e) {
									e.printStackTrace();
								}
								Date dT = new Date();
								
								if(dO.getTime() < dT.getTime()) {
									
									PointsUtils.placePlayer(pls);
									
								}
								
							}
							
							cps.setR_time_seconds(cps.getR_time_seconds()+1);
							if(cps.getR_time_seconds() == 60) {
								cps.setR_time_seconds(0);
								cps.setR_time_minutes(cps.getR_time_minutes()+1);
							}
							if(cps.getR_time_minutes() == 60) {
								cps.setR_time_minutes(0);
								cps.setR_time_hours(cps.getR_time_hours()+1);
							}
							//#TEST#
							
						}else {
							
							if(pls.hasPermission("mcube.afk")) {
								
								ChatUtils.sendTitle(pls, "§c§lAFK", 5, 12, 5);
								
							}else {
								
								pls.kickPlayer("§c§lVous ne pouvez pas rester AFK !§r\n§eLes §f§lMiniVIP§r§e et §l+§r§e ne sont pas déconnectés.");
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}, 20, 20);
		
	}
	
	public static void start30() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if(!MySQLUtils.isConnected("SELECT * FROM `players`")) {
					
					MySQLUtils.connect();
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						
						CustomPlayer cps = PlayersManager.getCustomPlayer(pls);
						cps.save();
						
					}
					
				}
				
			}
			
		}, 600, 600);
		
	}

}
