package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.MySQLUtils;

public class LcCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.lastconnection")) {
				
				if(args.length == 1) {
					
					String target = args[0];
					
					boolean exist = false;
					
					for(String ids : MySQLUtils.getValues("players")) {
						
						if(MySQLUtils.getString("players", "uuid", ""+ids, "name").equalsIgnoreCase(target)) {
							
							exist = true;
							
							String lc = MySQLUtils.getString("players", "uuid", ""+ids , "last_connection");
							
							p.sendMessage("§aDernière connection de §b"+target+"§a : §e"+lc);
							p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 1);
							
						}
						
					}
					
					if(!exist) {
						
						p.sendMessage("§cCe joueur n'éxiste pas !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}
					
				}else {
					
					p.sendMessage("§eAide : /lc [pseudo]");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 2);
					
				}
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			if(args.length == 1) {
				
				String target = args[0];
				
				boolean exist = false;
				
				for(String ids : MySQLUtils.getValues("players")) {
					
					if(MySQLUtils.getString("players", "uuid", ""+ids, "name").equalsIgnoreCase(target)) {
						
						exist = true;
						
						String lc = MySQLUtils.getString("players", "uuid", ""+ids , "last_connection");
						
						sender.sendMessage("§aDernière connection de §b"+target+"§a : §e"+lc);
						
					}
					
				}
				
				if(!exist) {
					
					sender.sendMessage("§cCe joueur n'éxiste pas !");
					
				}
				
			}else {
				
				sender.sendMessage("§eAide : /lc [pseudo]");
				
			}
			
		}
		
		return true;
		
	}

}
