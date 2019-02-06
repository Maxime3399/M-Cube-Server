package fr.Maxime3399.MCube.actions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.MainClass;

public class TeleportAction {
	
	public static void teleport(Player p, Location loc) {
		
		int time = 5;
		
		if(p.hasPermission("mcube.teleport.0")) {
			time = 0;
		}else if(p.hasPermission("mcube.teleport.4")) {
			time = 4;
		}else if(p.hasPermission("mcube.teleport.3")) {
			time = 3;
		}else if(p.hasPermission("mcube.teleport.2")) {
			time = 2;
		}else if(p.hasPermission("mcube.teleport.1")) {
			time = 1;
		}
		
		if(time == 0) {
			
			a(p, loc);
			
		}else {
			
			p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
			p.sendMessage("§dTéléportation dans §l1§r§d secondes !");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					
					a(p, loc);
					
				}
				
			}, time*20);
			
		}
		
	}
	
	private static void a(Player p, Location loc) {

		p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 1);
		p.teleport(loc);
		
	}

}
