package fr.Maxime3399.MCube.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.commands.MenuCMD;

public class CommandsManager {
	
	public static void execute(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase("menu")) {
				
				MenuCMD.command(sender, cmd, label, args);
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			if(cmd.getName().equalsIgnoreCase("menu")) {
				
				Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cCette commande n'est utilisable que par les joueurs !");
				
			}
			
		}
		
	}

}
