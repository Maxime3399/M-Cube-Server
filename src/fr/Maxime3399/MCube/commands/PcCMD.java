package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.MySQLUtils;

public class PcCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.playercount")) {
				
				int count = MySQLUtils.getValues("players").size();
				p.sendMessage("§eIl y a §a"+count+"§e joueurs uniques inscrits sur §6M-Cube§e.");
				p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 1);
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			int count = MySQLUtils.getValues("players").size();
			sender.sendMessage("§eIl y a §a"+count+"§e joueurs uniques inscrits sur §6M-Cube§e.");
			
		}
		
		return true;
		
	}

}
