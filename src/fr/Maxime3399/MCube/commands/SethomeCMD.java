package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.HomeUtils;

public class SethomeCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.sethome")) {
				
				if(args.length == 1) {
					
					String name = args[0];
					
					if(name.contains(",")) {
						
						p.sendMessage("§cLe nom d'un home ne peut pas contenir de virgule !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}else {
						
						if(HomeUtils.isHome(p, name)) {
							
							p.sendMessage("§cCe home éxiste déjà !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							int count = 0;
							for(int i = 1; i <= 40; i++) {
								if(HomeUtils.isHome(p, i)) {
									count++;
								}
							}
							
							if(count >= HomeUtils.getMaxHome(p)) {
								
								p.sendMessage("§cVous ne pouvez pas avoir plus de homes !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}else {
								
								int un = 1;
								for(int i = 1; i <= 40; i++) {
									
									if(!HomeUtils.isHome(p, i)) {
										un = i;
										i = 41;
									}
									
								}
								
								HomeUtils.defineHome(p, un, name);
								
								p.sendMessage("§aHome définit !");
								p.playSound(p.getLocation(), Sound.BLOCK_GRAVEL_PLACE, 100, 1);
								
							}
							
						}
						
					}
					
				}else {
					
					p.sendMessage("§eAide : /sethome [home]");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 2);
					
				}
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		return true;
		
	}

}
