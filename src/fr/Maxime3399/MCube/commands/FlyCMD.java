package fr.Maxime3399.MCube.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class FlyCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.fly")) {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				
				if(cp.isFly()) {
					
					p.setAllowFlight(false);
					cp.setFly(false);
					
					p.sendMessage("§eLe vol est activé !");
					p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
					
				}else {
					
					p.setAllowFlight(true);
					cp.setFly(true);
					
					p.sendMessage("§eLe vol est désactivé !");
					p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
					
				}
				
			}else {
				
				p.sendMessage("§cIl faut minimum être UltraVIP+ !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cCette commande n'est utilisable que par les joueurs !");
			
		}
		
		return true;
		
	}

}
