package fr.Maxime3399.MCube.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.cosmetics.CosLister;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class ChestCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.chest")) {
				
				if(args.length == 3) {
					
					String name = args[0];
					String uuid = null;
					
					for(String ids : MySQLUtils.getValues("players")) {
						
						if(MySQLUtils.getString("players", "uuid", ids, "name").equalsIgnoreCase(name)) {
							
							uuid = ids;
							
						}
						
					}
					
					if(uuid == null && (!name.equalsIgnoreCase("#ALL"))) {
						
						p.sendMessage("§cCe joueur n'éxiste pas !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}else {
						
						Player target = Bukkit.getPlayer(name);
						boolean serror = false;
						int stars = 0;
						try {
							stars = Integer.parseInt(args[1]);
						}catch (Exception e) {
							serror = true;
						}
						
						if(serror) {
							
							p.sendMessage("§cLe nombre d'étoile doit être un chiffre !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else if((stars > 0) && (stars < 6)) {
							
							String ra = args[2];
							
							if(ra.equals("true") || ra.equals("false")) {
								
								if(name.equalsIgnoreCase("#ALL")) {
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.removePlayer(pls);
										
									}
									
									for(String ids : MySQLUtils.getValues("players")) {
										
										int ran = 0;
										
										for(int it = 0; it <= 100; it++) {
											
											Random r = new Random();
											ran = r.nextInt(99999);
											if(!MySQLUtils.getValues("chests").contains(ran+"")) {
												it = 101;
											}
											
										}
										
										String chg[] = CosLister.genChest(stars);
										MySQLUtils.execute("INSERT INTO `chests` (`id`, `stars`, `bypass`, `content_1`, `content_2`, `content_3`, `content_4`, `content_5`) VALUES ('"+ran+"', '"+stars+"', '"+args[2]+"', '"+chg[0]+"', '"+chg[1]+"', '"+chg[2]+"', '"+chg[3]+"', '"+chg[4]+"');", false);
										
										String g = MySQLUtils.getString("players", "uuid", ids, "chests");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", ids, "chests", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", ids, "chests", g+","+ran);
										}
										
									}
									
									p.sendMessage("§eLes coffres ont étés envoyés !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.addPlayer(pls);
										
									}
									
								}else {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("chests").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									String chg[] = CosLister.genChest(stars);
									MySQLUtils.execute("INSERT INTO `chests` (`id`, `stars`, `bypass`, `content_1`, `content_2`, `content_3`, `content_4`, `content_5`) VALUES ('"+ran+"', '"+stars+"', '"+args[2]+"', '"+chg[0]+"', '"+chg[1]+"', '"+chg[2]+"', '"+chg[3]+"', '"+chg[4]+"');", false);
									if(target == null) {
										String g = MySQLUtils.getString("players", "uuid", uuid, "chests");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", uuid, "chests", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", uuid, "chests", g+","+ran);
										}
									}else {
										CustomPlayer cp = PlayersManager.getCustomPlayer(target);
										if(cp.getChests().equalsIgnoreCase("")) {
											cp.setChests(ran+"");
										}else {
											cp.setChests(cp.getChests()+","+ran);
										}
									}
									p.sendMessage("§eLe coffre a été envoyé !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
								}
								
							}else {
								
								p.sendMessage("§cLe bypass ne peut être que \"true\" ou \"false\" !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}
							
						}else {
							
							p.sendMessage("§cLe nombre d'étoile doit être comprit entre 1 et 5 !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}
						
					}
					
				}else {
					
					p.sendMessage("§eAide : /chest [pseudo] [étoiles] [bypass grade]");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 2);
					
				}
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			if(args.length == 3) {
				
				String name = args[0];
				String uuid = null;
				
				for(String ids : MySQLUtils.getValues("players")) {
					
					if(MySQLUtils.getString("players", "uuid", ids, "name").equalsIgnoreCase(name)) {
						
						uuid = ids;
						
					}
					
				}
				
				if(uuid == null && (!name.equalsIgnoreCase("#ALL"))) {
					
					sender.sendMessage("§cCe joueur n'éxiste pas !");
					
				}else {
					
					Player target = Bukkit.getPlayer(name);
					boolean serror = false;
					int stars = 0;
					try {
						stars = Integer.parseInt(args[1]);
					}catch (Exception e) {
						serror = true;
					}
					
					if(serror) {
						
						sender.sendMessage("§cLe nombre d'étoile doit être un chiffre !");
						
					}else if((stars > 0) && (stars < 6)) {
						
						String ra = args[2];
						
						if(ra.equals("true") || ra.equals("false")) {
							
							if(name.equalsIgnoreCase("#ALL")) {
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.removePlayer(pls);
									
								}
								
								for(String ids : MySQLUtils.getValues("players")) {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("chests").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									String chg[] = CosLister.genChest(stars);
									MySQLUtils.execute("INSERT INTO `chests` (`id`, `stars`, `bypass`, `content_1`, `content_2`, `content_3`, `content_4`, `content_5`) VALUES ('"+ran+"', '"+stars+"', '"+args[2]+"', '"+chg[0]+"', '"+chg[1]+"', '"+chg[2]+"', '"+chg[3]+"', '"+chg[4]+"');", false);
									
									String g = MySQLUtils.getString("players", "uuid", ids, "chests");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", ids, "chests", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", ids, "chests", g+","+ran);
									}
									
								}
								
								sender.sendMessage("§eLes coffres ont étés envoyés !");
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.addPlayer(pls);
									
								}
								
							}else {
								
								int ran = 0;
								
								for(int it = 0; it <= 100; it++) {
									
									Random r = new Random();
									ran = r.nextInt(99999);
									if(!MySQLUtils.getValues("chests").contains(ran+"")) {
										it = 101;
									}
									
								}
								
								String chg[] = CosLister.genChest(stars);
								MySQLUtils.execute("INSERT INTO `chests` (`id`, `stars`, `bypass`, `content_1`, `content_2`, `content_3`, `content_4`, `content_5`) VALUES ('"+ran+"', '"+stars+"', '"+args[2]+"', '"+chg[0]+"', '"+chg[1]+"', '"+chg[2]+"', '"+chg[3]+"', '"+chg[4]+"');", false);
								if(target == null) {
									String g = MySQLUtils.getString("players", "uuid", uuid, "chests");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", uuid, "chests", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", uuid, "chests", g+","+ran);
									}
								}else {
									CustomPlayer cp = PlayersManager.getCustomPlayer(target);
									if(cp.getChests().equalsIgnoreCase("")) {
										cp.setChests(ran+"");
									}else {
										cp.setChests(cp.getChests()+","+ran);
									}
								}
								sender.sendMessage("§eLe coffre a été envoyé !");
								
							}
							
						}else {
							
							sender.sendMessage("§cLe bypass ne peut être que \"true\" ou \"false\" !");
							
						}
						
					}else {
						
						sender.sendMessage("§cLe nombre d'étoile doit être comprit entre 1 et 5 !");
						
					}
					
				}
				
			}else {
				
				sender.sendMessage("§eAide : /chest [pseudo] [étoiles] [bypass grade]");
				
			}
			
		}
		
		return true;
		
	}

}
