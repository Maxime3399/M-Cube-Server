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

import fr.Maxime3399.MCube.cosmetics.CosCount;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.ItemUtils;

public class MainMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 18, "§8Menu Principal");
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		ItemStack ISranked = ItemUtils.getClassItem(DisplayUtils.getClass(p, DataUtils.getCurrentSeason()));
		ItemMeta IMranked = ISranked.getItemMeta();
		ArrayList<String> ALranked = new ArrayList<>();
		IMranked.setDisplayName("§eJeu classé");
		if(cp.getPoints() == -1) {
			ALranked.add("§cTu n'es pas classé, participe à la saison");
			ALranked.add("§cpour obtenir des récompenses exclusives !");
			IMranked.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMranked.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else {
			ALranked.add("§7Consulte ton classement");
			ALranked.add("§7et celui des autres !");
		}
		ALranked.add(" ");
		ALranked.add("§3Clique §7pour ouvir le menu");
		ALranked.add("§7de jeu classé");
		IMranked.setLore(ALranked);
		ISranked.setItemMeta(IMranked);
		i.addItem(ISranked);
		
		ItemStack ISstep = new ItemStack(Material.LADDER);
		ItemMeta IMstep = ISstep.getItemMeta();
		ArrayList<String> ALstep = new ArrayList<>();
		IMstep.setDisplayName("§ePalliers");
		if(cp.isLegendary_steps()) {
			ALstep.add("§7Obtiens de fabuleuses récompenses");
			ALstep.add("§7grâce au pass légendaire !");
		}else {
			ALstep.add("§7Obtiens des récompenses, ou débloque");
			ALstep.add("§7en plus avec le pass légendaire !");
		}
		ALstep.add(" ");
		ALstep.add("§6Clique gauche §7pour ouvrir le menu");
		ALstep.add("§7des palliers");
		if(cp.isLegendary_steps()) {
			ALstep.add("§8§mClique droit§r§7§m pour acheter le");
			ALstep.add("§7§mpass légendaire");
			IMstep.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMstep.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else {
			ALstep.add("§eClique droit §7pour acheter le");
			ALstep.add("§7pass légendaire");
		}
		IMstep.setLore(ALstep);
		ISstep.setItemMeta(IMstep);
		i.addItem(ISstep);
		
		ItemStack ISsuccess = new ItemStack(Material.PAPER);
		ItemMeta IMsuccess = ISsuccess.getItemMeta();
		ArrayList<String> ALsuccess = new ArrayList<>();
		IMsuccess.setDisplayName("§eSuccès");
		ALsuccess.add("§7Consulte et débloque tous");
		ALsuccess.add("§7les succès !");
		ALsuccess.add(" ");
		ALsuccess.add("§7Débloqué : #/#");
		ALsuccess.add(" ");
		ALsuccess.add("§3Clique§7 pour ouvrir le");
		ALsuccess.add("§7menu des succès");
		IMsuccess.setLore(ALsuccess);
		ISsuccess.setItemMeta(IMsuccess);
		i.addItem(ISsuccess);
		
		ItemStack IScos = new ItemStack(Material.SLIME_BALL);
		ItemMeta IMcos = IScos.getItemMeta();
		ArrayList<String> ALcos = new ArrayList<>();
		IMcos.setDisplayName("§eCosmétiques");
		ALcos.add("§7Active tes effets pour en mettre");
		ALcos.add("§7pleins la vue aux autres joueurs !");
		ALcos.add(" ");
		ALcos.add("§7Débloqué : "+CosCount.getGeneralCount(p)+"/"+CosCount.getCosPlusColorMax());
		ALcos.add(" ");
		ALcos.add("§3Clique§7 pour ouvrir le menu");
		ALcos.add("§7des cosmétiques");
		IMcos.setLore(ALcos);
		IScos.setItemMeta(IMcos);
		i.addItem(IScos);
		
		ItemStack ISitems = new ItemStack(Material.CHEST);
		ItemMeta IMitems = ISitems.getItemMeta();
		ArrayList<String> ALitems = new ArrayList<>();
		IMitems.setDisplayName("§eObjets");
		ALitems.add("§7Tous tes objets spéciaux");
		ALitems.add("§7sont entreposés ici.");
		ALitems.add(" ");
		ALitems.add("§3Clique§7 pour ouvrir le");
		ALitems.add("§7menu des objets");
		IMitems.setLore(ALitems);
		ISitems.setItemMeta(IMitems);
		i.addItem(ISitems);
		
		ItemStack ISchests = new ItemStack(Material.ENDER_CHEST);
		ItemMeta IMchests = ISchests.getItemMeta();
		ArrayList<String> ALchests = new ArrayList<>();
		IMchests.setDisplayName("§eCoffres");
		ALchests.add("§7Ouvre des coffres et obtiens");
		ALchests.add("§7de nouveaux cosmétiques !");
		ALchests.add(" ");
		int chests = 0;
		int chestC = 1;
		if(!cp.getGifts().equalsIgnoreCase("")) {
			String g[] = cp.getGifts().split(",");
			chests = g.length;
			IMchests.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMchests.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			if(chests > 64) {
				chestC = 64;
			}else {
				chestC = chests;
			}
		}
		ALchests.add("§7Tu as "+chestC+" coffres");
		ALchests.add(" ");
		ALchests.add("§3Clique §7pour ouvrir le");
		ALchests.add("§7menu des coffres");
		IMchests.setLore(ALchests);
		ISchests.setItemMeta(IMchests);
		i.addItem(ISchests);
		
		ItemStack ISgift = new ItemStack(Material.BOOK);
		ItemMeta IMgift = ISgift.getItemMeta();
		ArrayList<String> ALgift = new ArrayList<>();
		IMgift.setDisplayName("§eCadeaux");
		ALgift.add("§7Des cadeaux apparaîssent");
		ALgift.add("§7parfois ici ouvre les vite !");
		ALgift.add(" ");
		int gifts = 0;
		int giftC = 1;
		if(!cp.getGifts().equalsIgnoreCase("")) {
			String g[] = cp.getGifts().split(",");
			gifts = g.length;
			IMgift.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMgift.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			if(gifts > 64) {
				giftC = 64;
			}else {
				giftC = gifts;
			}
		}
		ALgift.add("§7Tu as "+gifts+" cadeaux");
		ALgift.add(" ");
		ALgift.add("§3Clique§7 pour ouvrir le");
		ALgift.add("§7menu des cadeaux");
		IMgift.setLore(ALgift);
		ISgift.setItemMeta(IMgift);
		ISgift.setAmount(giftC);
		i.addItem(ISgift);
		
		ItemStack ISshop = new ItemStack(Material.GOLD_INGOT);
		ItemMeta IMshop = ISshop.getItemMeta();
		ArrayList<String> ALshop = new ArrayList<>();
		IMshop.setDisplayName("§eBoutique");
		ALshop.add("§7Dépense ici tes jetons !");
		ALshop.add(" ");
		ALshop.add("§7Tu as "+cp.getTokens()+" jetons");
		ALshop.add(" ");
		ALshop.add("§6Clique gauche§7 pour ouvrir");
		ALshop.add("§7la boutique");
		ALshop.add("§eClique droit§7 pour obtenir le");
		ALshop.add("§7lien de la boutique en ligne");
		IMshop.setLore(ALshop);
		ISshop.setItemMeta(IMshop);
		i.addItem(ISshop);
		
		p.openInventory(i);
		
	}

}
