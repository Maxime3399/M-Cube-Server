package fr.Maxime3399.MCube.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;
import fr.Maxime3399.MCube.utils.StringChangerUtils;

public class GiftsMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 45, "§8Cadeaux");
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(!cp.getGifts().equalsIgnoreCase("")) {
			
			String[] gifts = cp.getGifts().split(",");
			int reap = 0;
			
			if(gifts.length > 53) {
				
				reap = 53;
				
			}else {
				
				reap = gifts.length;
				
			}
			
			for(int it = 0; it < reap; it++) {
				
				ItemStack ISg = new ItemStack(Material.getMaterial(MySQLUtils.getString("gifts", "id", gifts[it], "item")));
				ItemMeta IMg = ISg.getItemMeta();
				ArrayList<String> ALg = new ArrayList<>();
				IMg.setDisplayName("§8ID §7§l>§r §5"+gifts[it]);
				ALg.add(" ");
				ALg.add("§eContenu :");
				ALg.add("§b"+StringChangerUtils.getGift(MySQLUtils.getString("gifts", "id", gifts[it], "content")));
				String desc = MySQLUtils.getString("gifts", "id", gifts[it], "description");
				if(!desc.equalsIgnoreCase("none")) {
					ALg.add(" ");
					ALg.add("§eDescription :");
					String[] de = desc.split("#");
					for(String sd : de) {
						ALg.add("  §f"+sd);
					}
				}
				ALg.add(" ");
				ALg.add("§3Clique §7pour ouvrir");
				IMg.setLore(ALg);
				ISg.setItemMeta(IMg);
				i.addItem(ISg);
				
			}
			
		}else {
			
			ItemStack ISn = new ItemStack(Material.BARRIER);
			ItemMeta IMn = ISn.getItemMeta();
			ArrayList<String> ALn = new ArrayList<>();
			IMn.setDisplayName("§cTu n'as pas");
			ALn.add("§c§ode cadeaux !");
			IMn.setLore(ALn);
			ISn.setItemMeta(IMn);
			i.setItem(22, ISn);
			
		}
		
		ItemStack ISback = new ItemStack(Material.ARROW);
		ItemMeta IMback = ISback.getItemMeta();
		ArrayList<String> ALback = new ArrayList<>();
		IMback.setDisplayName("§8§oRetour");
		ALback.add(" ");
		ALback.add("§3Clique §7pour retourner au");
		ALback.add("§7menu principal");
		IMback.setLore(ALback);
		ISback.setItemMeta(IMback);
		i.setItem(44, ISback);
		
		p.openInventory(i);
		
	}

}
