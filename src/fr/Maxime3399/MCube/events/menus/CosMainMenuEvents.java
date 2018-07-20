package fr.Maxime3399.MCube.events.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.menus.CosPlusMenu;
import fr.Maxime3399.MCube.menus.MainMenu;

public class CosMainMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Cosmétiques")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(item.equalsIgnoreCase("§8§oRetour")) {
					
					MainMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.equalsIgnoreCase("§ePréfixe UltraVIP+")) {
					
					if(p.hasPermission("mcube.menu.+")) {
						
						CosPlusMenu.openMenu(p);
						p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
						
					}else {
						
						p.sendMessage("§cCe menu est réservé aux UltraVIP+ !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
