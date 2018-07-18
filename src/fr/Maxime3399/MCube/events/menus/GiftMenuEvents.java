package fr.Maxime3399.MCube.events.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.menus.GiftsMenu;
import fr.Maxime3399.MCube.menus.MainMenu;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.StringChangerUtils;

public class GiftMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Cadeaux")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(item.equalsIgnoreCase("§8§oRetour")) {
					
					MainMenu.openMenu(p);
					p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 100, 1);
					
				}else if(item.startsWith("§8ID §7§l>§r §5")) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer(p);
					String id = item.replaceAll("§8ID §7§l>§r §5", "");
					String content = MySQLUtils.getString("gifts", "id", id, "content");
					StringChangerUtils.giveGift(p, content);
					p.sendMessage("§aTu as obtenus : §b"+StringChangerUtils.getGift(content)+" §r§a!");
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
					String[] g = cp.getGifts().split(",");
					if(g.length >= 2) {
						cp.setGifts(cp.getGifts().replaceAll(","+id, ""));
					}else {
						cp.setGifts(cp.getGifts().replaceAll(id, ""));
					}
					MySQLUtils.execute("DELETE FROM `gifts` WHERE `gifts`.`id` = '"+id+"'", false);
					GiftsMenu.openMenu(p);
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
