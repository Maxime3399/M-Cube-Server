package fr.Maxime3399.MCube.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.menus.MainMenu;

public class MenuCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 2);
			MainMenu.openMenu(p);
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cCette commande n'est utilisable que par les joueurs !");
			
		}
		
		return true;
		
	}

}
