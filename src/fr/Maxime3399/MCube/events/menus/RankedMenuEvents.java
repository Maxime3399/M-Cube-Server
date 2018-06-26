package fr.Maxime3399.MCube.events.menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class RankedMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§8Jeu Classé")) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				
				if(item.equalsIgnoreCase("§a§lSaison 1")) {
					
					if(cp.getPoints() == -1) {
						
						if(cp.getPlacement_points() == -1) {
							
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
							Date dO = null;
							try {
								dO = sdf.parse(MySQLUtils.getString("infos", "type", "season_1_end", "info_string"));
							} catch (ParseException ex) {
								ex.printStackTrace();
							}
							Date dT = new Date();
							Long result = dO.getTime()-dT.getTime();
							long d = TimeUnit.MILLISECONDS.toDays(result);
							
							if(d < 3) {
								
								p.sendMessage("§cTu ne peux pas te classer car la saison se termine dans moins de 3 jours !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}else {
								
								Calendar cal = Calendar.getInstance();
								Date dC = new Date();
								cal.setTime(dC);
								cal.add(Calendar.DAY_OF_MONTH, 3);
								dC.setTime(cal.getTimeInMillis());
								cp.setPlacement_end(sdf.format(dC));
								cp.setPlacement_points(0);
								p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 100, 1);
								p.sendMessage("§a§lTu as commancé tes jours de placement !§r\n§eJoue un maximum durant les trois prochains jours afin d'obtenir un haut classement !");
								p.closeInventory();
								
							}
							
						}
						
					}
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
