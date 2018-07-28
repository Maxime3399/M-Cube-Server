package fr.Maxime3399.MCube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CcmdCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(args.length == 1) {
			
			if(cp.getConfirm() != null) {
				
				String arg = args[0];
				
				if(arg.equalsIgnoreCase("confirm")) {
					
					cp.setConfirm(cp.getConfirm().replaceAll("test", "confirm"));
					
				}else {
					
					cp.setConfirm(cp.getConfirm().replaceAll("test", "cancel"));
					
				}
				
			}
			
		}
		
	}

}
