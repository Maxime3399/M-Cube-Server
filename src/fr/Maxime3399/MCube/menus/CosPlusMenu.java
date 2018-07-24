package fr.Maxime3399.MCube.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CosPlusMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 18, "§8Préfixe UltraVIP+");
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
		
		ItemStack IS2 = new ItemStack(Material.GREEN_WOOL);
		ItemMeta IM2 = IS2.getItemMeta();
		ArrayList<String> AL2 = new ArrayList<>();
		IM2.setDisplayName("§2§l+");
		AL2.add("§7Change la couleur du \"+\"");
		AL2.add("§7de ton grade");
		AL2.add(" ");
		AL2.add("§6Rareté : §aCommun");
		AL2.add(" ");
		if(equi.equalsIgnoreCase("§2")) {
			AL2.add("§eCosmétique actif");
			AL2.add(" ");
			AL2.add("§8§mClique§7§m pour équipper");
			IM2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IM2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else {
			AL2.add("§3Clique§7 pour équipper");
		}
		IM2.setLore(AL2);
		IS2.setItemMeta(IM2);
		i.setItem(0, IS2);
		
		ItemStack ISa = new ItemStack(Material.LIME_WOOL);
		ItemMeta IMa = ISa.getItemMeta();
		ArrayList<String> ALa = new ArrayList<>();
		IMa.setDisplayName("§a§l+");
		ALa.add("§7Change la couleur du \"+\"");
		ALa.add("§7de ton grade");
		ALa.add(" ");
		ALa.add("§6Rareté : §aCommun");
		ALa.add(" ");
		if(cp.getCos_plus_color().contains("§a")) {
			if(equi.equalsIgnoreCase("§a")) {
				ALa.add("§eCosmétique actif");
				ALa.add(" ");
				ALa.add("§8§mClique§7§m pour équipper");
				IMa.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALa.add("§3Clique§7 pour équipper");
			}
		}else {
			ALa.add("§7Obtenable dans les coffres de");
			ALa.add("§7cosmétiques ou achetable");
			ALa.add(" ");
			ALa.add("§7Prix : §a50 cristaux");
			ALa.add(" ");
			if(cp.getCrystals() >= 50) {
				ALa.add("§3Clique§7 pour acheter");
			}else {
				ALa.add("§cTu n'as pas assez");
				ALa.add("§cde cristaux");
				ALa.add(" ");
				ALa.add("§8§mClique§7§m pour acheter");
			}
		}
		IMa.setLore(ALa);
		ISa.setItemMeta(IMa);
		i.setItem(1, ISa);
		
		ItemStack IS5 = new ItemStack(Material.PURPLE_WOOL);
		ItemMeta IM5 = IS5.getItemMeta();
		ArrayList<String> AL5 = new ArrayList<>();
		IM5.setDisplayName("§5§l+");
		AL5.add("§7Change la couleur du \"+\"");
		AL5.add("§7de ton grade");
		AL5.add(" ");
		AL5.add("§6Rareté : §3Rare");
		AL5.add(" ");
		if(cp.getCos_plus_color().contains("§5")) {
			if(equi.equalsIgnoreCase("§5")) {
				AL5.add("§eCosmétique actif");
				AL5.add(" ");
				AL5.add("§8§mClique§7§m pour équipper");
				IM5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL5.add("§3Clique§7 pour équipper");
			}
		}else {
			AL5.add("§7Obtenable dans les coffres de");
			AL5.add("§7cosmétiques ou achetable");
			AL5.add(" ");
			AL5.add("§7Prix : §a100 cristaux");
			AL5.add(" ");
			if(cp.getCrystals() >= 100) {
				AL5.add("§3Clique§7 pour acheter");
			}else {
				AL5.add("§cTu n'as pas assez");
				AL5.add("§cde cristaux");
				AL5.add(" ");
				AL5.add("§8§mClique§7§m pour acheter");
			}
		}
		IM5.setLore(AL5);
		IS5.setItemMeta(IM5);
		i.setItem(2, IS5);
		
		ItemStack ISd = new ItemStack(Material.MAGENTA_WOOL);
		ItemMeta IMd = ISd.getItemMeta();
		ArrayList<String> ALd = new ArrayList<>();
		IMd.setDisplayName("§d§l+");
		ALd.add("§7Change la couleur du \"+\"");
		ALd.add("§7de ton grade");
		ALd.add(" ");
		ALd.add("§6Rareté : §dEpique");
		ALd.add(" ");
		if(cp.getCos_plus_color().contains("§d")) {
			if(equi.equalsIgnoreCase("§d")) {
				ALd.add("§eCosmétique actif");
				ALd.add(" ");
				ALd.add("§8§mClique§7§m pour équipper");
				IMd.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMd.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALd.add("§3Clique§7 pour équipper");
			}
		}else {
			ALd.add("§7Obtenable dans les coffres de");
			ALd.add("§7cosmétiques ou achetable");
			ALd.add(" ");
			ALd.add("§7Prix : §a150 cristaux");
			ALd.add(" ");
			if(cp.getCrystals() >= 150) {
				ALd.add("§3Clique§7 pour acheter");
			}else {
				ALd.add("§cTu n'as pas assez");
				ALd.add("§cde cristaux");
				ALd.add(" ");
				ALd.add("§8§mClique§7§m pour acheter");
			}
		}
		IMd.setLore(ALd);
		ISd.setItemMeta(IMd);
		i.setItem(3, ISd);
		
		ItemStack IS4 = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta IM4 = IS4.getItemMeta();
		ArrayList<String> AL4 = new ArrayList<>();
		IM4.setDisplayName("§4§l+");
		AL4.add("§7Change la couleur du \"+\"");
		AL4.add("§7de ton grade");
		AL4.add(" ");
		AL4.add("§6Rareté : §eLégendaire");
		AL4.add(" ");
		if(cp.getCos_plus_color().contains("§4")) {
			if(equi.equalsIgnoreCase("§4")) {
				AL4.add("§eCosmétique actif");
				AL4.add(" ");
				AL4.add("§8§mClique§7§m pour équipper");
				IM4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL4.add("§3Clique§7 pour équipper");
			}
		}else {
			AL4.add("§7Obtenable dans les coffres de");
			AL4.add("§7cosmétiques ou achetable");
			AL4.add(" ");
			AL4.add("§7Prix : §a200 cristaux");
			AL4.add(" ");
			if(cp.getCrystals() >= 200) {
				AL4.add("§3Clique§7 pour acheter");
			}else {
				AL4.add("§cTu n'as pas assez");
				AL4.add("§cde cristaux");
				AL4.add(" ");
				AL4.add("§8§mClique§7§m pour acheter");
			}
		}
		IM4.setLore(AL4);
		IS4.setItemMeta(IM4);
		i.setItem(4, IS4);
		
		ItemStack ISc = new ItemStack(Material.RED_WOOL);
		ItemMeta IMc = ISc.getItemMeta();
		ArrayList<String> ALc = new ArrayList<>();
		IMc.setDisplayName("§c§l+");
		ALc.add("§7Change la couleur du \"+\"");
		ALc.add("§7de ton grade");
		ALc.add(" ");
		ALc.add("§6Rareté : §aCommun");
		ALc.add(" ");
		if(cp.getCos_plus_color().contains("§c")) {
			if(equi.equalsIgnoreCase("§c")) {
				ALc.add("§eCosmétique actif");
				ALc.add(" ");
				ALc.add("§8§mClique§7§m pour équipper");
				IMc.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMc.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALc.add("§3Clique§7 pour équipper");
			}
		}else {
			ALc.add("§7Récompense de la");
			ALc.add("§7ligue bronze");
			ALc.add(" ");
			ALc.add("§8§mClique§7§m pour équipper");
		}
		IMc.setLore(ALc);
		ISc.setItemMeta(IMc);
		i.setItem(5, ISc);
		
		ItemStack IS6 = new ItemStack(Material.ORANGE_WOOL);
		ItemMeta IM6 = IS6.getItemMeta();
		ArrayList<String> AL6 = new ArrayList<>();
		IM6.setDisplayName("§6§l+");
		AL6.add("§7Change la couleur du \"+\"");
		AL6.add("§7de ton grade");
		AL6.add(" ");
		AL6.add("§6Rareté : §aCommun");
		AL6.add(" ");
		if(cp.getCos_plus_color().contains("§6")) {
			if(equi.equalsIgnoreCase("§6")) {
				AL6.add("§eCosmétique actif");
				AL6.add(" ");
				AL6.add("§8§mClique§7§m pour équipper");
				IM6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL6.add("§3Clique§7 pour équipper");
			}
		}else {
			AL6.add("§7Récompense de la");
			AL6.add("§7ligue argent");
			AL6.add(" ");
			AL6.add("§8§mClique§7§m pour équipper");
		}
		IM6.setLore(AL6);
		IS6.setItemMeta(IM6);
		i.setItem(6, IS6);
		
		ItemStack ISe = new ItemStack(Material.YELLOW_WOOL);
		ItemMeta IMe = ISe.getItemMeta();
		ArrayList<String> ALe = new ArrayList<>();
		IMe.setDisplayName("§e§l+");
		ALe.add("§7Change la couleur du \"+\"");
		ALe.add("§7de ton grade");
		ALe.add(" ");
		ALe.add("§6Rareté : §3Rare");
		ALe.add(" ");
		if(cp.getCos_plus_color().contains("§e")) {
			if(equi.equalsIgnoreCase("§e")) {
				ALe.add("§eCosmétique actif");
				ALe.add(" ");
				ALe.add("§8§mClique§7§m pour équipper");
				IMe.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALe.add("§3Clique§7 pour équipper");
			}
		}else {
			ALe.add("§7Récompense de la");
			ALe.add("§7ligue or");
			ALe.add(" ");
			ALe.add("§8§mClique§7§m pour équipper");
		}
		IMe.setLore(ALe);
		ISe.setItemMeta(IMe);
		i.setItem(7, ISe);
		
		ItemStack IS1 = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta IM1 = IS1.getItemMeta();
		ArrayList<String> AL1 = new ArrayList<>();
		IM1.setDisplayName("§1§l+");
		AL1.add("§7Change la couleur du \"+\"");
		AL1.add("§7de ton grade");
		AL1.add(" ");
		AL1.add("§6Rareté : §dEpique");
		AL1.add(" ");
		if(cp.getCos_plus_color().contains("§1")) {
			if(equi.equalsIgnoreCase("§1")) {
				AL1.add("§eCosmétique actif");
				AL1.add(" ");
				AL1.add("§8§mClique§7§m pour équipper");
				IM1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL1.add("§3Clique§7 pour équipper");
			}
		}else {
			AL1.add("§7Récompense de la");
			AL1.add("§7ligue platine");
			AL1.add(" ");
			AL1.add("§8§mClique§7§m pour équipper");
		}
		IM1.setLore(AL1);
		IS1.setItemMeta(IM1);
		i.setItem(8, IS1);
		
		ItemStack IS9 = new ItemStack(Material.BLUE_WOOL);
		ItemMeta IM9 = IS9.getItemMeta();
		ArrayList<String> AL9 = new ArrayList<>();
		IM9.setDisplayName("§9§l+");
		AL9.add("§7Change la couleur du \"+\"");
		AL9.add("§7de ton grade");
		AL9.add(" ");
		AL9.add("§6Rareté : §eLégendaire");
		AL9.add(" ");
		if(cp.getCos_plus_color().contains("§9")) {
			if(equi.equalsIgnoreCase("§9")) {
				AL9.add("§eCosmétique actif");
				AL9.add(" ");
				AL9.add("§8§mClique§7§m pour équipper");
				IM9.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL9.add("§3Clique§7 pour équipper");
			}
		}else {
			AL9.add("§7Récompense de la");
			AL9.add("§7ligue maître");
			AL9.add(" ");
			AL9.add("§8§mClique§7§m pour équipper");
		}
		IM9.setLore(AL9);
		IS9.setItemMeta(IM9);
		i.setItem(9, IS9);
		
		ItemStack IS3 = new ItemStack(Material.CYAN_WOOL);
		ItemMeta IM3 = IS3.getItemMeta();
		ArrayList<String> AL3 = new ArrayList<>();
		IM3.setDisplayName("§3§l+");
		AL3.add("§7Change la couleur du \"+\"");
		AL3.add("§7de ton grade");
		AL3.add(" ");
		AL3.add("§6Rareté : §eLégendaire");
		AL3.add(" ");
		if(cp.getCos_plus_color().contains("§3")) {
			if(equi.equalsIgnoreCase("§3")) {
				AL3.add("§eCosmétique actif");
				AL3.add(" ");
				AL3.add("§8§mClique§7§m pour équipper");
				IM3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL3.add("§3Clique§7 pour équipper");
			}
		}else {
			AL3.add("§7Récompense de la");
			AL3.add("§7ligue légende");
			AL3.add(" ");
			AL3.add("§8§mClique§7§m pour équipper");
		}
		IM3.setLore(AL3);
		IS3.setItemMeta(IM3);
		i.setItem(10, IS3);
		
		ItemStack ISb = new ItemStack(Material.LIGHT_BLUE_WOOL);
		ItemMeta IMb = ISb.getItemMeta();
		ArrayList<String> ALb = new ArrayList<>();
		IMb.setDisplayName("§b§l+");
		ALb.add("§7Change la couleur du \"+\"");
		ALb.add("§7de ton grade");
		ALb.add(" ");
		ALb.add("§6Rareté : §eLégendaire");
		ALb.add(" ");
		if(cp.getCos_plus_color().contains("§b")) {
			if(equi.equalsIgnoreCase("§b")) {
				ALb.add("§eCosmétique actif");
				ALb.add(" ");
				ALb.add("§8§mClique§7§m pour équipper");
				IMb.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMb.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALb.add("§3Clique§7 pour équipper");
			}
		}else {
			ALb.add("§7Terminer top 3");
			ALb.add(" ");
			ALb.add("§8§mClique§7§m pour équipper");
		}
		IMb.setLore(ALb);
		ISb.setItemMeta(IMb);
		i.setItem(11, ISb);
		
		ItemStack IS0 = new ItemStack(Material.BLACK_WOOL);
		ItemMeta IM0 = IS0.getItemMeta();
		ArrayList<String> AL0 = new ArrayList<>();
		IM0.setDisplayName("§0§l+");
		AL0.add("§7Change la couleur du \"+\"");
		AL0.add("§7de ton grade");
		AL0.add(" ");
		AL0.add("§6Rareté : §eLégendaire");
		AL0.add(" ");
		if(cp.getCos_plus_color().contains("§0")) {
			if(equi.equalsIgnoreCase("§0")) {
				AL0.add("§eCosmétique actif");
				AL0.add(" ");
				AL0.add("§8§mClique§7§m pour équipper");
				IM0.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM0.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL0.add("§3Clique§7 pour équipper");
			}
		}else {
			AL0.add("§7Terminer top 2");
			AL0.add(" ");
			AL0.add("§8§mClique§7§m pour équipper");
		}
		IM0.setLore(AL0);
		IS0.setItemMeta(IM0);
		i.setItem(12, IS0);
		
		ItemStack IS8 = new ItemStack(Material.GRAY_WOOL);
		ItemMeta IM8 = IS8.getItemMeta();
		ArrayList<String> AL8 = new ArrayList<>();
		IM8.setDisplayName("§8§l+");
		AL8.add("§7Change la couleur du \"+\"");
		AL8.add("§7de ton grade");
		AL8.add(" ");
		AL8.add("§6Rareté : §eLégendaire");
		AL8.add(" ");
		if(cp.getCos_plus_color().contains("§8")) {
			if(equi.equalsIgnoreCase("§8")) {
				AL8.add("§eCosmétique actif");
				AL8.add(" ");
				AL8.add("§8§mClique§7§m pour équipper");
				IM8.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL8.add("§3Clique§7 pour équipper");
			}
		}else {
			AL8.add("§7Terminer top 1");
			AL8.add(" ");
			AL8.add("§8§mClique§7§m pour équipper");
		}
		IM8.setLore(AL8);
		IS8.setItemMeta(IM8);
		i.setItem(13, IS8);
		
		ItemStack IS7 = new ItemStack(Material.LIGHT_GRAY_WOOL);
		ItemMeta IM7 = IS7.getItemMeta();
		ArrayList<String> AL7 = new ArrayList<>();
		IM7.setDisplayName("§7§l+");
		AL7.add("§7Change la couleur du \"+\"");
		AL7.add("§7de ton grade");
		AL7.add(" ");
		AL7.add("§6Rareté : §eLégendaire");
		AL7.add(" ");
		if(cp.getCos_plus_color().contains("§7")) {
			if(equi.equalsIgnoreCase("§7")) {
				AL7.add("§eCosmétique actif");
				AL7.add(" ");
				AL7.add("§8§mClique§7§m pour équipper");
				IM7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IM7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				AL7.add("§3Clique§7 pour équipper");
			}
		}else {
			AL7.add("§7Obtenable lors d'un achat");
			AL7.add("§7dans le boutique en ligne");
			AL7.add(" ");
			AL7.add("§8§mClique§7§m pour équipper");
		}
		IM7.setLore(AL7);
		IS7.setItemMeta(IM7);
		i.setItem(14, IS7);
		
		ItemStack ISf = new ItemStack(Material.WHITE_WOOL);
		ItemMeta IMf = ISf.getItemMeta();
		ArrayList<String> ALf = new ArrayList<>();
		IMf.setDisplayName("§f§l+");
		ALf.add("§7Change la couleur du \"+\"");
		ALf.add("§7de ton grade");
		ALf.add(" ");
		ALf.add("§6Rareté : §eLégendaire");
		ALf.add(" ");
		if(cp.getCos_plus_color().contains("§f")) {
			if(equi.equalsIgnoreCase("§f")) {
				ALf.add("§eCosmétique actif");
				ALf.add(" ");
				ALf.add("§8§mClique§7§m pour équipper");
				IMf.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMf.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}else {
				ALf.add("§3Clique§7 pour équipper");
			}
		}else {
			ALf.add("§7Récompense spéciale");
			ALf.add(" ");
			ALf.add("§8§mClique§7§m pour équipper");
		}
		IMf.setLore(ALf);
		ISf.setItemMeta(IMf);
		i.setItem(15, ISf);
		
		ItemStack ISback = new ItemStack(Material.ARROW);
		ItemMeta IMback = ISback.getItemMeta();
		ArrayList<String> ALback = new ArrayList<>();
		IMback.setDisplayName("§8§oRetour");
		ALback.add(" ");
		ALback.add("§3Clique §7pour retourner au");
		ALback.add("§7menu principal");
		IMback.setLore(ALback);
		ISback.setItemMeta(IMback);
		i.setItem(17, ISback);
		
		p.openInventory(i);
		
	}

}
