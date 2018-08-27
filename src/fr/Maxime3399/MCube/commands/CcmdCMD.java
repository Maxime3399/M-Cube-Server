package fr.Maxime3399.MCube.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CcmdCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
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
		
		if(sender instanceof ConsoleCommandSender) {
			
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cCette commande n'est utilisable que par les joueurs !");
			
		}
		
		return true;
		
	}

}
