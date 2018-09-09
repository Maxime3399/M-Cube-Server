package fr.Maxime3399.MCube.events.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.menus.ChestsMenu;
import fr.Maxime3399.MCube.menus.CosMainMenu;
import fr.Maxime3399.MCube.menus.GiftsMenu;
import fr.Maxime3399.MCube.menus.RankedMenu;

public class MainMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Menu Principal")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(item.equalsIgnoreCase("§eJeu classé")) {
					
					RankedMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.equalsIgnoreCase("§eCadeaux")) {
					
					GiftsMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.equalsIgnoreCase("§eCosmétiques")) {
					
					CosMainMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.equalsIgnoreCase("§eCoffres")) {
					
					ChestsMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
