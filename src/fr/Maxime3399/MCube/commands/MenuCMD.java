package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.menus.MainMenu;

public class MenuCMD {
	
	public static void command(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 2);
		MainMenu.openMenu(p);
		
	}

}
