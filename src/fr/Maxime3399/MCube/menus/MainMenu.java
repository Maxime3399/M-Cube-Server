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
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.ItemUtils;

public class MainMenu {
	
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 18, "�8Menu Principal");
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		ItemStack ISranked = ItemUtils.getClassItem(DisplayUtils.getClass(p));
		ItemMeta IMranked = ISranked.getItemMeta();
		ArrayList<String> ALranked = new ArrayList<>();
		IMranked.setDisplayName("�eJeu class�");
		if(DisplayUtils.getClassPrefix(p).equalsIgnoreCase("�8")) {
			ALranked.add("�cTu n'es pas class�, participe � la saison");
			ALranked.add("�cpour obtenir des r�compenses exclusives !");
			IMranked.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMranked.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else {
			ALranked.add("�7Consulte ton classement et");
			ALranked.add("�7celui des autres !");
		}
		ALranked.add(" ");
		ALranked.add("�3Clique �7pour ouvir le menu");
		ALranked.add("�7de jeu class�");
		IMranked.setLore(ALranked);
		ISranked.setItemMeta(IMranked);
		i.addItem(ISranked);
		
		ItemStack ISstep = new ItemStack(Material.LADDER);
		ItemMeta IMstep = ISstep.getItemMeta();
		ArrayList<String> ALstep = new ArrayList<>();
		IMstep.setDisplayName("�ePalliers");
		if(cp.isLegendary_steps()) {
			ALstep.add("�7Obtiens de fabuleuses r�compenses");
			ALstep.add("�7gr�ce au pass l�gendaire !");
		}else {
			ALstep.add("�7Obtiens des r�compenses, ou d�bloque");
			ALstep.add("�7en plus avec le pass l�gendaire !");
		}
		ALstep.add(" ");
		ALstep.add("�6Clique gauche �7pour ouvrir le menu");
		ALstep.add("�7des palliers");
		if(cp.isLegendary_steps()) {
			ALstep.add("�8mClique droit�r�7�m pour acheter le");
			ALstep.add("�7�mpass l�gendaire");
			IMstep.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IMstep.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else {
			ALstep.add("�eClique droit �7pour acheter le");
			ALstep.add("�7pass l�gendaire");
		}
		ISstep.setItemMeta(IMstep);
		i.addItem(ISstep);
		
		ItemStack ISsuccess = new ItemStack(Material.PAPER);
		ItemMeta IMsuccess = ISsuccess.getItemMeta();
		ArrayList<String> ALsuccess = new ArrayList<>();
		IMsuccess.setDisplayName("�eSucc�s");
		ALsuccess.add("�7Consulte et d�bloque tous");
		ALsuccess.add("�7les succ�s !");
		ALsuccess.add(" ");
		ALsuccess.add("�7D�bloqu� : #/#");
		ALsuccess.add(" ");
		ALsuccess.add("�3Clique�7 pour ouvrir le");
		ALsuccess.add("�7menu des succ�s");
		ISsuccess.setItemMeta(IMsuccess);
		i.addItem(ISsuccess);
		
		ItemStack IScos = new ItemStack(Material.SLIME_BALL);
		ItemMeta IMcos = IScos.getItemMeta();
		ArrayList<String> ALcos = new ArrayList<>();
		IMcos.setDisplayName("�eCosm�tiques");
		ALcos.add("�7Active tes effets pour en mettre");
		ALcos.add("�7pleins la vue aux autres joueurs !");
		ALcos.add(" ");
		ALcos.add("�7D�bloqu� : #/#");
		ALcos.add(" ");
		ALcos.add("�3Clique�7 pour ouvrir le menu");
		ALcos.add("�7des cosm�tiques");
		IMcos.setLore(ALcos);
		IScos.setItemMeta(IMcos);
		i.addItem(IScos);
		
		ItemStack ISitems = new ItemStack(Material.CHEST);
		ItemMeta IMitems = ISitems.getItemMeta();
		ArrayList<String> ALitems = new ArrayList<>();
		IMitems.setDisplayName("�eObjets");
		ALitems.add("�7Tous tes objets sp�ciaux sont");
		ALitems.add("�7entrepos�s ici.");
		ALitems.add(" ");
		ALitems.add("�3Clique�7 pour ouvrir le");
		ALitems.add("�7menu des objets");
		IMitems.setLore(ALitems);
		ISitems.setItemMeta(IMitems);
		i.addItem(ISitems);
		
		ItemStack ISchests = new ItemStack(Material.ENDER_CHEST);
		ItemMeta IMchests = ISchests.getItemMeta();
		ArrayList<String> ALchests = new ArrayList<>();
		IMchests.setDisplayName("�eCoffres");
		ALchests.add("�7Ouvre des coffres et obtiens de");
		ALchests.add("�7nouveaux cosm�tiques !");
		ALchests.add(" ");
		ALchests.add("�7Tu as # coffres");
		ALchests.add(" ");
		ALchests.add("�3Clique�7pour ouvrir le");
		ALchests.add("�7menu des coffres");
		IMchests.setLore(ALchests);
		ISchests.setItemMeta(IMchests);
		i.addItem(ISchests);
		
		ItemStack ISgift = new ItemStack(Material.BOOK);
		ItemMeta IMgift = ISgift.getItemMeta();
		ArrayList<String> ALgift = new ArrayList<>();
		IMgift.setDisplayName("�eCadeaux");
		ALgift.add("�7Des cadeaux appara�ssent parfois ici");
		ALgift.add("�7ouvre les vite !");
		ALgift.add(" ");
		ALgift.add("�7Tu as # cadeaux");
		ALgift.add(" ");
		ALgift.add("�3Clique�7 pour ouvrir le");
		ALgift.add("�7menu des cadeaux");
		IMgift.setLore(ALgift);
		ISgift.setItemMeta(IMgift);
		i.addItem(ISgift);
		
		ItemStack ISshop = new ItemStack(Material.GOLD_INGOT);
		ItemMeta IMshop = ISshop.getItemMeta();
		ArrayList<String> ALshop = new ArrayList<>();
		IMshop.setDisplayName("�eBoutique");
		ALshop.add("�7D�pense ici tes jetons !");
		ALshop.add(" ");
		ALshop.add("�7Tu as "+cp.getTokens()+" jetons");
		ALshop.add(" ");
		ALshop.add("�6Clique gauche�7 pour ouvrir");
		ALshop.add("�7la boutique");
		ALshop.add("�eClique droit�7 pour obtenir le lien");
		ALshop.add("�7de la boutique en ligne");
		IMshop.setLore(ALshop);
		ISshop.setItemMeta(IMshop);
		i.addItem(ISshop);
		
		p.openInventory(i);
		
	}

}