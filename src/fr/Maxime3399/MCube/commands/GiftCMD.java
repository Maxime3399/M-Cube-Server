package fr.Maxime3399.MCube.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.StringChangerUtils;

public class GiftCMD implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.gift")) {
				
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
						
						String material = args[1];
						Player target = Bukkit.getPlayer(name);
						if(Material.getMaterial(material) == null) {
							
							p.sendMessage("§cL'objet n'est pas valide !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							String content = args[2];
							if(StringChangerUtils.getGift(content) == null) {
								
								p.sendMessage("§cLe contenu n'est pas valide !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}else {
								
								if(name.equalsIgnoreCase("#ALL")) {
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.removePlayer(pls);
										
									}
									
									for(String ids : MySQLUtils.getValues("players")) {
										
										int ran = 0;
										
										for(int it = 0; it <= 100; it++) {
											
											Random r = new Random();
											ran = r.nextInt(99999);
											if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
												it = 101;
											}
											
										}
										
										MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
										
										String g = MySQLUtils.getString("players", "uuid", ids, "gifts");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", ids, "gifts", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", ids, "gifts", g+","+ran);
										}
										
									}
									
									p.sendMessage("§eLes cadeaux ont étés envoyés !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.addPlayer(pls);
										
									}
									
								}else {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
									if(target == null) {
										String g = MySQLUtils.getString("players", "uuid", uuid, "gifts");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", uuid, "gifts", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", uuid, "gifts", g+","+ran);
										}
									}else {
										CustomPlayer cp = PlayersManager.getCustomPlayer(target);
										if(cp.getGifts().equalsIgnoreCase("")) {
											cp.setGifts(ran+"");
										}else {
											cp.setGifts(cp.getGifts()+","+ran);
										}
									}
									p.sendMessage("§eLe cadeau a été envoyé !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
								}
								
							}
							
						}
						
					}
					
				}else if(args.length == 4) {
					
					String name = args[0];
					String uuid = null;
					
					for(String ids : MySQLUtils.getValues("players")) {
						
						if(MySQLUtils.getString("players", "uuid", ""+ids, "name").equalsIgnoreCase(name)) {
							
							uuid = ids;
							
						}
						
					}
					
					if(uuid == null && (!name.equalsIgnoreCase("#ALL"))) {
						
						p.sendMessage("§cCe joueur n'éxiste pas !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}else {
						
						String material = args[1];
						Player target = Bukkit.getPlayer(name);
						if(Material.getMaterial(material) == null) {
							
							p.sendMessage("§cL'objet n'est pas valide !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							String content = args[2];
							if(StringChangerUtils.getGift(content) == null) {
								
								p.sendMessage("§cLe contenu n'est pas valide !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}else {
								
								String desc = args[3].replaceAll("_", " ");

								if(name.equalsIgnoreCase("#ALL")) {
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.removePlayer(pls);
										
									}
									
									for(String ids : MySQLUtils.getValues("players")) {
										
										int ran = 0;
										
										for(int it = 0; it <= 100; it++) {
											
											Random r = new Random();
											ran = r.nextInt(99999);
											if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
												it = 101;
											}
											
										}
										
										MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', '"+desc+"', '"+content+"');", false);
										
										String g = MySQLUtils.getString("players", "uuid", ids, "gifts");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", ids, "gifts", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", ids, "gifts", g+","+ran);
										}
										
									}
									
									p.sendMessage("§eLes cadeaux ont étés envoyés !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
									for(Player pls : Bukkit.getOnlinePlayers()) {
										
										PlayersManager.addPlayer(pls);
										
									}
									
								}else {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
									if(target == null) {
										String g = MySQLUtils.getString("players", "uuid", uuid, "gifts");
										if(g.equalsIgnoreCase("")) {
											MySQLUtils.setString("players", "uuid", uuid, "gifts", ran+"");
										}else {
											MySQLUtils.setString("players", "uuid", uuid, "gifts", g+","+ran);
										}
									}else {
										CustomPlayer cp = PlayersManager.getCustomPlayer(target);
										if(cp.getGifts().equalsIgnoreCase("")) {
											cp.setGifts(ran+"");
										}else {
											cp.setGifts(cp.getGifts()+","+ran);
										}
									}
									p.sendMessage("§eLe cadeau a été envoyé !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
									
								}
								
							}
							
						}
						
					}
					
				}else {
					
					p.sendMessage("§eAide : /gift [pseudo] [objet] [contenu] {description}");
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
					
					if(MySQLUtils.getString("players", "uuid", ""+ids, "name").equalsIgnoreCase(name)) {
						
						uuid = ids;
						
					}
					
				}
				
				if(uuid == null && (!name.equalsIgnoreCase("#ALL"))) {
					
					sender.sendMessage("§cCe joueur n'éxiste pas !");
					
				}else {
					
					String material = args[1];
					Player target = Bukkit.getPlayer(name);
					if(Material.getMaterial(material) == null) {
						
						sender.sendMessage("§cL'objet n'est pas valide !");
						
					}else {
						
						String content = args[2];
						if(StringChangerUtils.getGift(content) == null) {
							
							sender.sendMessage("§cLe contenu n'est pas valide !");
							
						}else {
							
							if(name.equalsIgnoreCase("#ALL")) {
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.removePlayer(pls);
									
								}
								
								for(String ids : MySQLUtils.getValues("players")) {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
									
									String g = MySQLUtils.getString("players", "uuid", ids, "gifts");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", ids, "gifts", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", ids, "gifts", g+","+ran);
									}
									
								}
								
								sender.sendMessage("§eLes cadeaux ont étés envoyés !");
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.addPlayer(pls);
									
								}
								
							}else {
								
								int ran = 0;
								
								for(int it = 0; it <= 100; it++) {
									
									Random r = new Random();
									ran = r.nextInt(99999);
									if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
										it = 101;
									}
									
								}
								
								MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
								if(target == null) {
									String g = MySQLUtils.getString("players", "uuid", uuid, "gifts");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", uuid, "gifts", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", uuid, "gifts", g+","+ran);
									}
								}else {
									CustomPlayer cp = PlayersManager.getCustomPlayer(target);
									if(cp.getGifts().equalsIgnoreCase("")) {
										cp.setGifts(ran+"");
									}else {
										cp.setGifts(cp.getGifts()+","+ran);
									}
								}
								sender.sendMessage("§eLe cadeau a été envoyé !");
								
							}
							
						}
						
					}
					
				}
				
			}else if(args.length == 4) {
				
				String name = args[0];
				String uuid = null;
				
				for(String ids : MySQLUtils.getValues("players")) {
					
					if(MySQLUtils.getString("players", "uuid", ""+ids, "name").equalsIgnoreCase(name)) {
						
						uuid = ids;
						
					}
					
				}
				
				if(uuid == null && (!name.equalsIgnoreCase("#ALL"))) {
					
					sender.sendMessage("§cCe joueur n'éxiste pas !");
					
				}else {
					
					String material = args[1];
					Player target = Bukkit.getPlayer(name);
					if(Material.getMaterial(material) == null) {
						
						sender.sendMessage("§cL'objet n'est pas valide !");
						
					}else {
						
						String content = args[2];
						if(StringChangerUtils.getGift(content) == null) {
							
							sender.sendMessage("§cLe contenu n'est pas valide !");
							
						}else {
							
							String desc = args[3].replaceAll("_", " ");

							if(name.equalsIgnoreCase("#ALL")) {
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.removePlayer(pls);
									
								}
								
								for(String ids : MySQLUtils.getValues("players")) {
									
									int ran = 0;
									
									for(int it = 0; it <= 100; it++) {
										
										Random r = new Random();
										ran = r.nextInt(99999);
										if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
											it = 101;
										}
										
									}
									
									MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', '"+desc+"', '"+content+"');", false);
									
									String g = MySQLUtils.getString("players", "uuid", ids, "gifts");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", ids, "gifts", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", ids, "gifts", g+","+ran);
									}
									
								}
								
								sender.sendMessage("§eLes cadeaux ont étés envoyés !");
								
								for(Player pls : Bukkit.getOnlinePlayers()) {
									
									PlayersManager.addPlayer(pls);
									
								}
								
							}else {
								
								int ran = 0;
								
								for(int it = 0; it <= 100; it++) {
									
									Random r = new Random();
									ran = r.nextInt(99999);
									if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
										it = 101;
									}
									
								}
								
								MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
								if(target == null) {
									String g = MySQLUtils.getString("players", "uuid", uuid, "gifts");
									if(g.equalsIgnoreCase("")) {
										MySQLUtils.setString("players", "uuid", uuid, "gifts", ran+"");
									}else {
										MySQLUtils.setString("players", "uuid", uuid, "gifts", g+","+ran);
									}
								}else {
									CustomPlayer cp = PlayersManager.getCustomPlayer(target);
									if(cp.getGifts().equalsIgnoreCase("")) {
										cp.setGifts(ran+"");
									}else {
										cp.setGifts(cp.getGifts()+","+ran);
									}
								}
								sender.sendMessage("§eLe cadeau a été envoyé !");
								
							}
							
						}
						
					}
					
				}
				
			}else {
				
				sender.sendMessage("§eAide : /gift [pseudo] [objet] [contenu] {description}");
				
			}
			
		}
		
		return true;
		
	}

}
