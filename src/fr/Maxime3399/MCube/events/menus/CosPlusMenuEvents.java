package fr.Maxime3399.MCube.events.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.menus.CosPlusMenu;
import fr.Maxime3399.MCube.menus.MainMenu;
import fr.Maxime3399.MCube.utils.DisplayUtils;

public class CosPlusMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Préfixe UltraVIP+")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(item.equalsIgnoreCase("§8§oRetour")) {
					
					MainMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.contains("+")) {
					
					String color = item.substring(0, 2);
					String equi = "§2";
					CustomPlayer cp = PlayersManager.getCustomPlayer(p);
					if(!cp.getCos_active().equalsIgnoreCase("")) {
						String g[] = cp.getCos_active().split(",");
						for(String ss : g) {
							if(ss.startsWith("§")) {
								equi = ss;
							}
						}
					}
					
					if(cp.getCos_plus_color().contains(color)) {
						
						if(color.equalsIgnoreCase(equi)) {
							
							p.sendMessage("§cCe cosmétique est déjà équippé !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							p.sendMessage("§eCe cosmétique a été équippé !");
							p.playSound(p.getLocation(), Sound.BLOCK_PISTON_CONTRACT, 100, 1);
							cp.setCos_active(cp.getCos_active().replaceAll(equi, color));
							DisplayUtils.setDisplay(p);
							CosPlusMenu.openMenu(p);
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getLore().size() > 8) {
						
						if(e.getCurrentItem().getItemMeta().getLore().get(8).contains("§7Prix")) {
							
							String sp = e.getCurrentItem().getItemMeta().getLore().get(8).replaceAll("§7Prix : §a", "");
							sp = sp.replaceAll(" cristaux", "");
							int price = Integer.parseInt(sp);
							
							if(cp.getCrystals() >= price) {
								
								if(cp.getCos_plus_color().equalsIgnoreCase("")) {
									cp.setCos_plus_color(cp.getCos_plus_color()+color);
								}else {
									cp.setCos_plus_color(cp.getCos_plus_color()+","+color);
								}
								cp.setCos_active(cp.getCos_active().replaceAll(equi, color));
								p.sendMessage("§aAchat effectué ! Le cosmétique a été équippé.");
								cp.setCrystals(cp.getCrystals()-price);
								p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 100, 2);
								DisplayUtils.setDisplay(p);
								CosPlusMenu.openMenu(p);
								
							}else {
								
								p.sendMessage("§cTu n'as pas assez de cristaux !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}
							
						}
						
					}
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
