package fr.Maxime3399.MCube.menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
		
		String end = MySQLUtils.getString("infos", "type", "season_1_end", "info_string");
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
			if(cp.getPoints() == -1) {
				if(!cp.getPlacement_end().equalsIgnoreCase("none")){
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
					Date dO = null;
					try {
						dO = sdf.parse(cp.getPlacement_end());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Date dT = new Date();
					Long result = dO.getTime()-dT.getTime();
					long d = TimeUnit.MILLISECONDS.toDays(result);
					long h = TimeUnit.MILLISECONDS.toHours(result)-TimeUnit.DAYS.toHours(d);
					long m = TimeUnit.MILLISECONDS.toMinutes(result)-TimeUnit.DAYS.toMinutes(d)-TimeUnit.HOURS.toMinutes(h);
					long s = TimeUnit.MILLISECONDS.toSeconds(result)-TimeUnit.DAYS.toSeconds(d)-TimeUnit.HOURS.toSeconds(h)-TimeUnit.MINUTES.toSeconds(m);
					AL1.add(" ");
					AL1.add("§fTemps de placement");
					AL1.add("§frestant : §e"+d+":"+h+":"+m+":"+s);
					AL1.add(" ");
					AL1.add("§8§mClique§r§7§m pour commencer tes");
					AL1.add("§7§mjours de placement");
				}else {
					AL1.add(" ");
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
					Date dO = null;
					try {
						dO = sdf.parse(end);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Date dT = new Date();
					Long result = dO.getTime()-dT.getTime();
					long d = TimeUnit.MILLISECONDS.toDays(result);
					if(d < 3) {
						AL1.add("§cTu ne peux pas te placer, la saison");
						AL1.add("§cse termine dans moins de 3 jours");
						AL1.add(" ");
						AL1.add("§8§mClique§r§7§m pour commencer tes");
						AL1.add("§7§mjours de placements");
					}else {
						AL1.add("§3Clique§7 pour commencer tes");
						AL1.add("§7jours de placements");
					}
				}
			}else {
				AL1.add(" ");
				AL1.add("§fPoints : "+cp.getPoints());
			}
		}else if(DataUtils.getCurrentSeason() < 1) {
			IM1.setDisplayName("§c§lSaison 1");
			AL1.add("§cSaison a venir !");
		}else {
			IM1.setDisplayName("§6§lSaison 1");
			AL1.add("§eSaison terminée !");
			AL1.add(" ");
			AL1.add("§fPoints : "+cp.getPointsBySeason(1));
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
			
			boolean plac = true;
			
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
					
					if(plac) {
						
						plac = false;
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
							if(cp.getPoints() == -1) {
								if(!cp.getPlacement_end().equalsIgnoreCase("none")){
									SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
									Date dO = null;
									try {
										dO = sdf.parse(cp.getPlacement_end());
									} catch (ParseException e) {
										e.printStackTrace();
									}
									Date dT = new Date();
									Long result = dO.getTime()-dT.getTime();
									long d = TimeUnit.MILLISECONDS.toDays(result);
									long h = TimeUnit.MILLISECONDS.toHours(result)-TimeUnit.DAYS.toHours(d);
									long m = TimeUnit.MILLISECONDS.toMinutes(result)-TimeUnit.DAYS.toMinutes(d)-TimeUnit.HOURS.toMinutes(h);
									long s = TimeUnit.MILLISECONDS.toSeconds(result)-TimeUnit.DAYS.toSeconds(d)-TimeUnit.HOURS.toSeconds(h)-TimeUnit.MINUTES.toSeconds(m);
									AL1.add(" ");
									AL1.add("§fTemps de placement");
									AL1.add("§frestant : §e"+d+":"+h+":"+m+":"+s);
									AL1.add(" ");
									AL1.add("§8§mClique§r§7§m pour commencer tes");
									AL1.add("§7§mjours de placement");
									plac = true;
								}else {
									AL1.add(" ");
									SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
									Date dO = null;
									try {
										dO = sdf.parse(end);
									} catch (ParseException e) {
										e.printStackTrace();
									}
									Date dT = new Date();
									Long result = dO.getTime()-dT.getTime();
									long d = TimeUnit.MILLISECONDS.toDays(result);
									if(d < 3) {
										AL1.add("§cTu ne peux pas te placer, la saison");
										AL1.add("§cse termine dans moins de 3 jours");
										AL1.add(" ");
										AL1.add("§8§mClique§r§7§m pour commencer tes");
										AL1.add("§7§mjours de placements");
									}else {
										AL1.add("§3Clique§7 pour commencer tes");
										AL1.add("§7jours de placements");
									}
								}
							}else {
								AL1.add(" ");
								AL1.add("§fPoints : "+cp.getPoints());
							}
						}else if(DataUtils.getCurrentSeason() < 1) {
							IM1.setDisplayName("§c§lSaison 1");
							AL1.add("§cSaison a venir !");
						}else {
							IM1.setDisplayName("§6§lSaison 1");
							AL1.add("§eSaison terminée !");
							AL1.add(" ");
							AL1.add("§fPoints : "+cp.getPointsBySeason(1));
						}
						IM1.setLore(AL1);
						IS1.setItemMeta(IM1);
						i.setItem(4, IS1);
						
					}
					
				}else {
					
					this.cancel();
					
				}
				
			}
			
		}.runTaskTimerAsynchronously(MainClass.getInstance(), 5, 5);
		
	}

}
