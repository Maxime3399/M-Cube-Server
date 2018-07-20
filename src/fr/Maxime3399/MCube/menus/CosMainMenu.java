package fr.Maxime3399.MCube.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CosMainMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 27, "§8Cosmétiques");
		
		ItemStack ISp = new ItemStack(Material.BEACON);
		ItemMeta IMp = ISp.getItemMeta();
		ArrayList<String> ALp = new ArrayList<>();
		IMp.setDisplayName("§ePréfixe UltraVIP+");
		ALp.add("§7Modifie le \"+\" de ton");
		ALp.add("§7grade UltraVIP+ !");
		ALp.add(" ");
		ALp.add("§7Débloqué : #/#");
		ALp.add(" ");
		if(p.hasPermission("mcube.menu.+")) {
			ALp.add("§3Clique§7 pour ouvrir le menu");
			ALp.add("§7de préfixe UltraVIP+");
		}else {
			ALp.add("§cCe menu est réservé");
			ALp.add("§caux UltraVIP+");
			ALp.add(" ");
			ALp.add("§8§mClique§7§m pour ouvrir le menu");
			ALp.add("§7§mde préfixe UltraVIP+");
		}
		IMp.setLore(ALp);
		ISp.setItemMeta(IMp);
		i.addItem(ISp);
		
		ItemStack ISback = new ItemStack(Material.ARROW);
		ItemMeta IMback = ISback.getItemMeta();
		ArrayList<String> ALback = new ArrayList<>();
		IMback.setDisplayName("§8§oRetour");
		ALback.add(" ");
		ALback.add("§3Clique §7pour retourner au");
		ALback.add("§7menu principal");
		IMback.setLore(ALback);
		ISback.setItemMeta(IMback);
		i.setItem(26, ISback);
		
		p.openInventory(i);
		
	}

}
