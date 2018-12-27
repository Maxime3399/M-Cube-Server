package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelhomeCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.delhome")) {
				
				
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		return true;
		
	}

}
