package fr.Maxime3399.MCube.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.StringChangerUtils;

public class GiftCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("mcube.command.gift")) {
			
			if(args.length == 3) {
				
				String name = args[0];
				if(Bukkit.getPlayer(name) == null) {
					
					p.sendMessage("§cCe joueur n'est pas connecté !");
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
							
							int ran = 0;
							
							for(int it = 0; it <= 100; it++) {
								
								Random r = new Random();
								ran = r.nextInt(99999);
								if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
									it = 101;
								}
								
							}
							
							CustomPlayer cp = PlayersManager.getCustomPlayer(target);
							MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
							if(cp.getGifts().equalsIgnoreCase("")) {
								cp.setGifts(ran+"");
							}else {
								cp.setGifts(cp.getGifts()+","+ran);
							}
							p.sendMessage("§eLe cadeau a été envoyé !");
							p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
							
						}
						
					}
					
				}
				
			}else if(args.length == 4) {
				
				String name = args[0];
				if(Bukkit.getPlayer(name) == null) {
					
					p.sendMessage("§cCe joueur n'est pas connecté !");
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
							int ran = 0;
							
							for(int it = 0; it <= 100; it++) {
								
								Random r = new Random();
								ran = r.nextInt(99999);
								if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
									it = 101;
								}
								
							}
							
							CustomPlayer cp = PlayersManager.getCustomPlayer(target);
							MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', '"+desc+"', '"+content+"');", false);
							if(cp.getGifts().equalsIgnoreCase("")) {
								cp.setGifts(ran+"");
							}else {
								cp.setGifts(cp.getGifts()+","+ran);
							}
							p.sendMessage("§eLe cadeau a été envoyé !");
							p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 2);
							
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
	
	public static void commandConsole(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 3) {
			
			String name = args[0];
			if(Bukkit.getPlayer(name) == null) {
				
				sender.sendMessage("§cCe joueur n'est pas connecté !");
				
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
						
						int ran = 0;
						
						for(int it = 0; it <= 100; it++) {
							
							Random r = new Random();
							ran = r.nextInt(99999);
							if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
								it = 101;
							}
							
						}
						
						CustomPlayer cp = PlayersManager.getCustomPlayer(target);
						MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', 'none', '"+content+"');", false);
						if(cp.getGifts().equalsIgnoreCase("")) {
							cp.setGifts(ran+"");
						}else {
							cp.setGifts(cp.getGifts()+","+ran);
						}
						sender.sendMessage("§eLe cadeau a été envoyé !");
						
					}
					
				}
				
			}
			
		}else if(args.length == 4) {
			
			String name = args[0];
			if(Bukkit.getPlayer(name) == null) {
				
				sender.sendMessage("§cCe joueur n'est pas connecté !");
				
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
						int ran = 0;
						
						for(int it = 0; it <= 100; it++) {
							
							Random r = new Random();
							ran = r.nextInt(99999);
							if(!MySQLUtils.getValues("gifts").contains(ran+"")) {
								it = 101;
							}
							
						}
						
						CustomPlayer cp = PlayersManager.getCustomPlayer(target);
						MySQLUtils.execute("INSERT INTO `gifts` (`id`, `item`, `description`, `content`) VALUES ('"+ran+"', '"+material+"', '"+desc+"', '"+content+"');", false);
						if(cp.getGifts().equalsIgnoreCase("")) {
							cp.setGifts(ran+"");
						}else {
							cp.setGifts(cp.getGifts()+","+ran);
						}
						sender.sendMessage("§eLe cadeau a été envoyé !");
						
					}
					
				}
				
			}
			
		}else {
			
			sender.sendMessage("§eAide : /gift [pseudo] [objet] [contenu] {description}");
			
		}
		
	}

}
