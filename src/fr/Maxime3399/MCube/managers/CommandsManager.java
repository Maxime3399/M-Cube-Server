package fr.Maxime3399.MCube.managers;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.commands.CcmdCMD;
import fr.Maxime3399.MCube.commands.ChestCMD;
import fr.Maxime3399.MCube.commands.DelhomeCMD;
import fr.Maxime3399.MCube.commands.GiftCMD;
import fr.Maxime3399.MCube.commands.HomeCMD;
import fr.Maxime3399.MCube.commands.LastconnectionCMD;
import fr.Maxime3399.MCube.commands.LcCMD;
import fr.Maxime3399.MCube.commands.MaintenanceCMD;
import fr.Maxime3399.MCube.commands.MenuCMD;
import fr.Maxime3399.MCube.commands.PcCMD;
import fr.Maxime3399.MCube.commands.PlayercountCMD;
import fr.Maxime3399.MCube.commands.PlayertimeCMD;
import fr.Maxime3399.MCube.commands.PtCMD;
import fr.Maxime3399.MCube.commands.SethomeCMD;
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
		PluginCommand cmd8 = p.getServer().getPluginCommand("playertime");
		cmd8.setExecutor(new PlayertimeCMD());
		PluginCommand cmd9 = p.getServer().getPluginCommand("pt");
		cmd9.setExecutor(new PtCMD());
		PluginCommand cmd10 = p.getServer().getPluginCommand("lastconnection");
		cmd10.setExecutor(new LastconnectionCMD());
		PluginCommand cmd11 = p.getServer().getPluginCommand("lc");
		cmd11.setExecutor(new LcCMD());
		PluginCommand cmd12 = p.getServer().getPluginCommand("chest");
		cmd12.setExecutor(new ChestCMD());
		PluginCommand cmd13 = p.getServer().getPluginCommand("home");
		cmd13.setExecutor(new HomeCMD());
		PluginCommand cmd14 = p.getServer().getPluginCommand("sethome");
		cmd14.setExecutor(new SethomeCMD());
		PluginCommand cmd15 = p.getServer().getPluginCommand("delhome");
		cmd15.setExecutor(new DelhomeCMD());
		
	}

}
