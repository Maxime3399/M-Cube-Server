package fr.Maxime3399.MCube.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MCube.cosmetics.CosLister;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class ChestsMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 45, "§8Coffres");
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(!cp.getChests().equalsIgnoreCase("")) {
			
			String[] chests = cp.getChests().split(",");
			int reap = 0;
			
			if(chests.length > 43) {
				
				reap = 43;
				
			}else {
				
				reap = chests.length;
				
			}
			
			for(int it = 0; it < reap; it++) {
				
				String co1 = MySQLUtils.getString("chests", "id", chests[it], "content_1");
				String co2 = MySQLUtils.getString("chests", "id", chests[it], "content_2");
				String co3 = MySQLUtils.getString("chests", "id", chests[it], "content_3");
				String co4 = MySQLUtils.getString("chests", "id", chests[it], "content_4");
				String co5 = MySQLUtils.getString("chests", "id", chests[it], "content_5");
				int stars = MySQLUtils.getInt("chests", "id", chests[it], "stars");
				boolean bypass = Boolean.parseBoolean(MySQLUtils.getString("chests", "id", chests[it], "bypass"));
				
				ItemStack ISg = new ItemStack(Material.ENDER_CHEST);
				ItemMeta IMg = ISg.getItemMeta();
				ArrayList<String> ALg = new ArrayList<>();
				IMg.setDisplayName("§8ID §7§l>§r §5"+chests[it]);
				ALg.add(" ");
				if(stars == 1) {
					ALg.add(" §e§l✮ §r§7 ✮ ✮ ✮ ✮");
				}else if(stars == 2) {
					ALg.add(" §e§l✮ ✮ §r§7✮ ✮ ✮");
				}else if(stars == 2) {
					ALg.add(" §e§l✮ ✮ ✮ §r§7✮ ✮");
				}else if(stars == 2) {
					ALg.add(" §e§l✮ ✮ ✮ ✮ §r§7✮");
				}else {
					ALg.add(" §e§l✮ ✮ ✮ ✮ ✮");
				}
				ALg.add(" ");
				ALg.add("§eContenu :");
				ALg.add("  §f§l-§r "+CosLister.getCosStr(co1));
				ALg.add("  §f§l-§r "+CosLister.getCosStr(co2));
				ALg.add("  §f§l-§r "+CosLister.getCosStr(co3));
				ALg.add("  §f§l-§r "+CosLister.getCosStr(co4));
				ALg.add("  §f§l-§r "+CosLister.getCosStr(co5));
				ALg.add(" ");
				if(bypass || p.hasPermission("mcube.chests."+stars)) {
					ALg.add("§3Clique §7pour ouvrir");
				}else {
					if(stars == 5) {
						ALg.add("§cIl faut être UltraVIP ou plus");
						ALg.add("§cpour ouvrir ce coffre !");
					}else if(stars == 4) {
						ALg.add("§cIl faut être VIP+ ou plus");
						ALg.add("§cpour ouvrir ce coffre !");
					}
					ALg.add(" ");
					ALg.add("§8§mClique§7§m pour ouvrir");
				}
				IMg.setLore(ALg);
				ISg.setItemMeta(IMg);
				i.addItem(ISg);
				
			}
			
		}else {
			
			ItemStack ISn = new ItemStack(Material.BARRIER);
			ItemMeta IMn = ISn.getItemMeta();
			ArrayList<String> ALn = new ArrayList<>();
			IMn.setDisplayName("§c§oTu n'as pas");
			ALn.add("§c§ode coffres !");
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
