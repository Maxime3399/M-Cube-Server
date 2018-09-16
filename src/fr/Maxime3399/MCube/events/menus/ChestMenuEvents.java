package fr.Maxime3399.MCube.events.menus;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.cosmetics.CosLister;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.menus.ChestsMenu;
import fr.Maxime3399.MCube.menus.MainMenu;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class ChestMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Coffres")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(item.startsWith("§8ID §7§l>§r §5")) {
					
					String id = item.replaceAll("§8ID §7§l>§r §5", "");
					int stars = MySQLUtils.getInt("chests", "id", id, "stars");
					boolean bypass = Boolean.parseBoolean(MySQLUtils.getString("chests", "id", id, "bypass"));
					
					if(bypass || p.hasPermission("mcube.chest."+stars)) {
						
						String content1 = MySQLUtils.getString("chests", "id", id, "content_1");
						String content2 = MySQLUtils.getString("chests", "id", id, "content_2");
						String content3 = MySQLUtils.getString("chests", "id", id, "content_3");
						String content4 = MySQLUtils.getString("chests", "id", id, "content_4");
						String content5 = MySQLUtils.getString("chests", "id", id, "content_5");
						
						String rarity[] = null;
						if(stars == 1) {
							rarity = "common,common,common,common,common".split(",");
						}else if(stars == 2) {
							rarity = "common,common,common,common,rare".split(",");
						}else if(stars == 3) {
							rarity = "common,common,common,rare,epic".split(",");
						}else if(stars == 4) {
							rarity = "common,common,rare,epic,legendary".split(",");
						}else if(stars == 5) {
							rarity = "common,rare,epic,legendary,legendary".split(",");
						}
						
						ArrayList<String> entries = new ArrayList<>();
						int state = 0;
						
						for(String a : rarity) {
							state = state+1;
							if(a.equalsIgnoreCase("common")) {
								for(int i = 0; i <= 50; i++) {
									Random r = new Random();
									if(state == 1) {
										entries.add(content1+r.nextInt(99999)+i);
									}else if(state == 2) {
										entries.add(content2+r.nextInt(99999)+i);
									}else if(state == 3) {
										entries.add(content3+r.nextInt(99999)+i);
									}else if(state == 4) {
										entries.add(content4+r.nextInt(99999)+i);
									}else {
										entries.add(content5+r.nextInt(99999)+i);
									}
								}
							}else if(a.equalsIgnoreCase("rare")) {
								for(int i = 0; i <= 30; i++) {
									Random r = new Random();
									if(state == 1) {
										entries.add(content1+r.nextInt(99999)+i);
									}else if(state == 2) {
										entries.add(content2+r.nextInt(99999)+i);
									}else if(state == 3) {
										entries.add(content3+r.nextInt(99999)+i);
									}else if(state == 4) {
										entries.add(content4+r.nextInt(99999)+i);
									}else {
										entries.add(content5+r.nextInt(99999)+i);
									}
								}
							}else if(a.equalsIgnoreCase("epic")) {
								for(int i = 0; i <= 15; i++) {
									Random r = new Random();
									if(state == 1) {
										entries.add(content1+r.nextInt(99999)+i);
									}else if(state == 2) {
										entries.add(content2+r.nextInt(99999)+i);
									}else if(state == 3) {
										entries.add(content3+r.nextInt(99999)+i);
									}else if(state == 4) {
										entries.add(content4+r.nextInt(99999)+i);
									}else {
										entries.add(content5+r.nextInt(99999)+i);
									}
								}
							}else if(a.equalsIgnoreCase("legendary")) {
								for(int i = 0; i <= 5; i++) {
									Random r = new Random();
									if(state == 1) {
										entries.add(content1+r.nextInt(99999)+i);
									}else if(state == 2) {
										entries.add(content2+r.nextInt(99999)+i);
									}else if(state == 3) {
										entries.add(content3+r.nextInt(99999)+i);
									}else if(state == 4) {
										entries.add(content4+r.nextInt(99999)+i);
									}else {
										entries.add(content5+r.nextInt(99999)+i);
									}
								}
							}
							
						}
						
						CustomPlayer cp = PlayersManager.getCustomPlayer(p);
						String[] g = cp.getChests().split(",");
						if(g.length >= 2) {
							cp.setChests(cp.getChests().replaceAll(","+id, ""));
						}else {
							cp.setChests(cp.getChests().replaceAll(id, ""));
						}
						Random ra = new Random();
						int rc = ra.nextInt(entries.size());
						String cos = entries.get(rc);
						cos = cos.replaceAll("0", "").replaceAll("1", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "").replaceAll("5", "").replaceAll("6", "").replaceAll("7", "").replaceAll("8", "").replaceAll("9", "");
						CosLister.giveCos(p, cos, true);
						MySQLUtils.execute("DELETE FROM `chests` WHERE `chests`.`id` = '"+id+"'", false);
						ChestsMenu.openMenu(p);
						
					}else {
						
						if(stars == 5) {
							p.sendMessage("§cTu dois être UltraVIP ou plus pour ouvrir ce coffre !");
						}else {
							p.sendMessage("§cTu dois être VIP+ ou plus pour ouvrir ce coffre !");
						}
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
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
