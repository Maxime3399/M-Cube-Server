package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.homes.HomeActions;

public class HomeCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.home")) {
				
				if(args.length == 0) {
					
					String message = "§eHomes : ";
					int count = 0;
					
					for(int i = 0; i <= 39; i++) {
						
						if(HomeActions.isHome(p, i)) {
							if(i == 0) {
								message = message+HomeActions.getHomeName(p, i);
							}else {
								message = message+", "+HomeActions.getHome(p, i);
							}
							count++;
						}
						
					}
					
					if(count == 0) {
						message = "§eVous n'avez définit aucun home !";
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
					}else {
						message = message+" ("+count+"/"+HomeActions.getMaxHome(p)+")";
						p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 1);
					}
					
					p.sendMessage(message);
					
				}
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		return true;
		
	}

}
