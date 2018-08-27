package fr.Maxime3399.MCube.managers;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.commands.CcmdCMD;
import fr.Maxime3399.MCube.commands.GiftCMD;
import fr.Maxime3399.MCube.commands.MaintenanceCMD;
import fr.Maxime3399.MCube.commands.MenuCMD;
import fr.Maxime3399.MCube.commands.PcCMD;
import fr.Maxime3399.MCube.commands.PlayercountCMD;
import fr.Maxime3399.MCube.commands.StopCMD;

public class CommandsManager {
	
	public static void registerCommands() {
		
		Plugin p = MainClass.getInstance();
		
		PluginCommand cmd1 = p.getServer().getPluginCommand("menu");
		cmd1.setExecutor(new MenuCMD());
		PluginCommand cmd2 = p.getServer().getPluginCommand("maintenance");
		cmd2.setExecutor(new MaintenanceCMD());
		PluginCommand cmd3 = p.getServer().getPluginCommand("playercount");
		cmd3.setExecutor(new PlayercountCMD());
		PluginCommand cmd4 = p.getServer().getPluginCommand("pc");
		cmd4.setExecutor(new PcCMD());
		PluginCommand cmd5 = p.getServer().getPluginCommand("gift");
		cmd5.setExecutor(new GiftCMD());
		PluginCommand cmd6 = p.getServer().getPluginCommand("ccmd");
		cmd6.setExecutor(new CcmdCMD());
		PluginCommand cmd7 = p.getServer().getPluginCommand("stop");
		cmd7.setExecutor(new StopCMD());
		
	}

}
