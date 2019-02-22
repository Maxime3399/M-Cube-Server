package fr.Maxime3399.MCube.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MCube.cosmetics.CosCount;

public class CosMainMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 9, "§8Cosmétiques");
		
		ItemStack ISp = new ItemStack(Material.BEACON);
		ItemMeta IMp = ISp.getItemMeta();
		ArrayList<String> ALp = new ArrayList<>();
		IMp.setDisplayName("§ePréfixe UltraVIP+");
		ALp.add("§7Modifie le \"+\" de ton");
		ALp.add("§7grade UltraVIP+ !");
		ALp.add(" ");
		ALp.add("§7Débloqué : "+CosCount.getPlusColorCount(p)+"/"+CosCount.getCosPlusColorMax());
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
		
		ItemStack ISt = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta IMt = ISt.getItemMeta();
		ArrayList<String> ALt = new ArrayList<String>();
		IMt.setDisplayName("§eEffets de course");
		ALt.add("§7Fait apparaître des particules");
		ALt.add("§7lors de tes déplacements !");
		ALt.add(" ");
		ALt.add("§7Débloqué : "+CosCount.getTrailCount(p)+"/"+CosCount.getCosTrailMax());
		ALt.add(" ");
		ALt.add("§c§lIndisponible");
		IMt.setLore(ALt);
		ISt.setItemMeta(IMt);
		i.addItem(ISt);
		
		ItemStack ISa = new ItemStack(Material.FEATHER);
		ItemMeta IMa = ISa.getItemMeta();
		ArrayList<String> ALa = new ArrayList<String>();
		IMa.setDisplayName("§eEffets ambiants");
		ALa.add("§7Effet permanant de particules");
		ALa.add("§7pour un style garantit !");
		ALa.add(" ");
		ALa.add("§7Débloqué : "+CosCount.getAmbientCount(p)+"/"+CosCount.getCosAmbientMax());
		ALa.add(" ");
		ALa.add("§c§lIndisponible");
		IMa.setLore(ALa);
		ISa.setItemMeta(IMa);
		i.addItem(ISa);
		
		ItemStack ISc = new ItemStack(Material.SPRUCE_DOOR);
		ItemMeta IMc = ISc.getItemMeta();
		ArrayList<String> ALc = new ArrayList<String>();
		IMc.setDisplayName("§eEffets de connexion");
		ALc.add("§7Effet qui se produit lors");
		ALc.add("§7de ta connexion !");
		ALc.add(" ");
		ALc.add("§7Débloqué : "+CosCount.getConnectCount(p)+"/"+CosCount.getCosConnectMax());
		ALc.add(" ");
		ALc.add("§c§lIndisponible");
		IMc.setLore(ALc);
		ISc.setItemMeta(IMc);
		i.addItem(ISc);
		
		ItemStack ISd = new ItemStack(Material.IRON_DOOR);
		ItemMeta IMd = ISd.getItemMeta();
		ArrayList<String> ALd = new ArrayList<String>();
		IMd.setDisplayName("§eEffets de déconnexion");
		ALd.add("§7Effet qui se produit lors");
		ALd.add("§7de ta déconnexion !");
		ALd.add(" ");
		ALd.add("§7Débloqué : "+CosCount.getDisconnectCount(p)+"/"+CosCount.getCosDisconnectMax());
		ALd.add(" ");
		ALd.add("§c§lIndisponible");
		IMd.setLore(ALd);
		ISd.setItemMeta(IMd);
		i.addItem(ISd);
		
		ItemStack ISde = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta IMde = ISde.getItemMeta();
		ArrayList<String> ALde = new ArrayList<String>();
		IMde.setDisplayName("§eEffets de morts");
		ALde.add("§7Effet qui se produit lors");
		ALde.add("§7de ta mort !");
		ALde.add(" ");
		ALde.add("§7Débloqué : "+CosCount.getDeathCount(p)+"/"+CosCount.getCosDeathMax());
		ALde.add(" ");
		ALde.add("§c§lIndisponible");
		IMde.setLore(ALde);
		ISde.setItemMeta(IMde);
		i.addItem(ISde);
		
		ItemStack ISr = new ItemStack(Material.ELYTRA);
		ItemMeta IMr = ISr.getItemMeta();
		ArrayList<String> ALr = new ArrayList<String>();
		IMr.setDisplayName("§eEffets de réapparition");
		ALr.add("§7Effet qui se produit lors");
		ALr.add("§7de ta déconnexion !");
		ALr.add(" ");
		ALr.add("§7Débloqué : "+CosCount.getRespawnCount(p)+"/"+CosCount.getCosRespawnMax());
		ALr.add(" ");
		ALr.add("§c§lIndisponible");
		IMr.setLore(ALr);
		ISr.setItemMeta(IMr);
		i.addItem(ISr);
		
		ItemStack ISback = new ItemStack(Material.ARROW);
		ItemMeta IMback = ISback.getItemMeta();
		ArrayList<String> ALback = new ArrayList<>();
		IMback.setDisplayName("§8§oRetour");
		ALback.add(" ");
		ALback.add("§3Clique §7pour retourner au");
		ALback.add("§7menu principal");
		IMback.setLore(ALback);
		ISback.setItemMeta(IMback);
		i.setItem(8, ISback);
		
		p.openInventory(i);
		
	}

}
