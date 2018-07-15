package fr.Maxime3399.MCube.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.commands.MaintenanceCMD;
import fr.Maxime3399.MCube.commands.MenuCMD;
import fr.Maxime3399.MCube.commands.PlayercountCMD;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.schedulers.GeneralSheduler;
import fr.Maxime3399.MCube.utils.PointsUtils;

public class CommandsManager {
	
	public static void execute(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer((Player) sender);
			cp.setR_commands(cp.getR_commands()+1);
			PointsUtils.addPoints((Player) sender);
			GeneralSheduler.action((Player) sender);
			
			if(cmd.getName().equalsIgnoreCase("menu")) {
				
				MenuCMD.command(sender, cmd, label, args);
				
			}else if(cmd.getName().equalsIgnoreCase("maintenance")) {
				
				MaintenanceCMD.commandPlayer(sender, cmd, label, args);
				
			}else if(cmd.getName().equalsIgnoreCase("playercount") || cmd.getName().equalsIgnoreCase("pc")) {
				
				PlayercountCMD.commandPlayer(sender, cmd, label, args);
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			if(cmd.getName().equalsIgnoreCase("menu")) {
				
				Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cCette commande n'est utilisable que par les joueurs !");
				
			}else if(cmd.getName().equalsIgnoreCase("maintenance")) {
				
				MaintenanceCMD.commandConsole(sender, cmd, label, args);
				
			}else if(cmd.getName().equalsIgnoreCase("playercount") || cmd.getName().equalsIgnoreCase("pc")) {
				
				PlayercountCMD.commandConsole(sender, cmd, label, args);
				
			}
			
		}
		
	}

}
