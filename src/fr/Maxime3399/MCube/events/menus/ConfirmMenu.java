package fr.Maxime3399.MCube.events.menus;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmMenu implements Listener {
	
	private static HashMap<Player, Integer> list = new HashMap<>();
	
	public static int confirm(Player p){
		
		list.put(p, 0);
		int result = 0;
		
		p.closeInventory();
		p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 1);
		
		Inventory i = Bukkit.createInventory(null, 9, "§8§lCONFIRMATION");
		
		ItemStack ISc = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta IMc = ISc.getItemMeta();
		IMc.setDisplayName("§a§lCONFIRMER");
		ISc.setItemMeta(IMc);
		i.setItem(2, ISc);
		
		ItemStack ISa = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta IMa = ISa.getItemMeta();
		IMa.setDisplayName("§c§lANNULER");
		ISa.setItemMeta(IMa);
		i.setItem(6, ISa);
		
		p.openInventory(i);
		
		return result;
		
	}
	
	public static int getPlayer(Player p){
		
		int result = 0;
		
		if(list.containsKey(p)){
			
			result = list.get(p);
			
		}
		
		return result;
		
	}
	
	public static void removePlayer(Player p){
		
		if(list.containsKey(p)){
			
			list.remove(p);
			
		}
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		if(e.getInventory() == null){
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8§lCONFIRMATION")){
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR){
				
				return;
				
			}else{
				
				String name = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				
				if(name.equalsIgnoreCase("§a§lCONFIRMER")){
					
					list.put(p, 1);
					
				}else if(name.equalsIgnoreCase("§c§lANNULER")){
					
					list.put(p, 2);
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		if(e.getInventory().getName().equalsIgnoreCase("§8§lCONFIRMATION")){
			
			if(list.containsKey(e.getPlayer())){
				
				list.put((Player) e.getPlayer(), 2);
				
			}
			
		}
		
	}

}
