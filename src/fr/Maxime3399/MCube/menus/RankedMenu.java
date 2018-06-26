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
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.DisplayUtils;
import fr.Maxime3399.MCube.utils.ItemUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class RankedMenu {
	
	@SuppressWarnings("deprecation")
	public static void openMenu(Player p) {
		
		Inventory i = Bukkit.createInventory(null, 27, "§8Jeu Classé");
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		ItemStack IS1 = new ItemStack(ItemUtils.getClassItem(DisplayUtils.getClass(p, 1)));
		ItemMeta IM1 = IS1.getItemMeta();
		ArrayList<String> AL1 = new ArrayList<>();
		AL1.add("§rRang : "+DisplayUtils.getClass(p, 1));
		if(cp.getPointsBySeason(1) != -1) {
			AL1.add("§rPoints : "+cp.getPointsBySeason(1));
		}
		AL1.add(" ");
		if(DataUtils.getCurrentSeason() == 1) {
			IM1.setDisplayName("§a§lSaison 1");
			IM1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			IM1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			AL1.add("§aSaison en cours !");
			if(cp.getPointsBySeason(1) == -1) {
				AL1.add(" ");
				AL1.add("§3Clique§7 pour commencer tes");
				AL1.add("§7de placements");
			}
		}else if(DataUtils.getCurrentSeason() < 1) {
			IM1.setDisplayName("§c§lSaison 1");
			AL1.add("§cSaison a venir !");
		}
		IM1.setLore(AL1);
		IS1.setItemMeta(IM1);
		i.setItem(4, IS1);
		
		ArrayList<String> players = MySQLUtils.getSortValues("players", "season_"+DataUtils.getCurrentSeason()+"_points", "ASC");
		ArrayList<String> remove = new ArrayList<>();
		
		if(players.size() > 0) {
			
			for(String pla : players) {
				
				if(MySQLUtils.getInt("players", "uuid", pla, "points") == -1) {
					
					remove.add(pla);
					
				}
				
			}
			
		}
		
		for(String pla : remove) {
			
			players.remove(pla);
			
		}

		for(int it = 0; it <= 8; it++) {
			
			if(players.size() > it) {
				ItemStack IS = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta SM = (SkullMeta) IS.getItemMeta();
				ArrayList<String> AL = new ArrayList<>();
				String name = MySQLUtils.getString("players", "uuid", players.get(it), "name");
				SM.setOwner(name);
				SM.setDisplayName("§d"+name);
				AL.add("§rPoints : "+MySQLUtils.getInt("players", "uuid", players.get(it), "points"));
				SM.setLore(AL);
				IS.setItemMeta(SM);
				i.setItem(18+it, IS);
				
			}
			
		}
		
		ItemStack ISsep = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta IMsep = ISsep.getItemMeta();
		IMsep.setDisplayName(" ");
		ISsep.setItemMeta(IMsep);
		i.setItem(9, ISsep);
		i.setItem(10, ISsep);
		i.setItem(11, ISsep);
		i.setItem(12, ISsep);
		i.setItem(14, ISsep);
		i.setItem(15, ISsep);
		i.setItem(16, ISsep);
		i.setItem(17, ISsep);
		
		ItemStack IScl = new ItemStack(Material.WATCH);
		ItemMeta IMcl = IScl.getItemMeta();
		ArrayList<String> ALcl = new ArrayList<>();
		IMcl.setDisplayName("§3Fin de saison :");
		ALcl.add("  §r§e"+DataUtils.getEndSeason());
		IMcl.setLore(ALcl);
		IScl.setItemMeta(IMcl);
		i.setItem(13, IScl);
		
		p.openInventory(i);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				if(p.getOpenInventory().getTopInventory().equals(i)) {
					
					ItemStack IScl = new ItemStack(Material.WATCH);
					ItemMeta IMcl = IScl.getItemMeta();
					ArrayList<String> ALcl = new ArrayList<>();
					IMcl.setDisplayName("§3Fin de saison :");
					ALcl.add("  §r§e"+DataUtils.getEndSeason());
					IMcl.setLore(ALcl);
					IScl.setItemMeta(IMcl);
					i.setItem(13, IScl);
					
				}else {
					
					this.cancel();
					
				}
				
			}
			
		}.runTaskTimerAsynchronously(MainClass.getInstance(), 10, 10);
		
	}

}
