package fr.Maxime3399.MCube;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Maxime3399.MCube.utils.MySQLUtils;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		File f = new File(getDataFolder(), "config.yml");
		if(!f.exists()) {
			
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §eLe fichier de configuration \"config.yml\" a été créé. Merci de configurer le plugin.");
			disable();
			
		}else if(MySQLUtils.connect()) {
			
			if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `players` (\r\n" + 
					"  `uuid` varchar(255) NOT NULL,\r\n" + 
					"  `name` varchar(255) NOT NULL,\r\n" + 
					"  `rank` varchar(255) NOT NULL,\r\n" + 
					"  `staff` varchar(255) NOT NULL,\r\n" + 
					"  `points` int(255) NOT NULL,\r\n" + 
					"  `step` int(255) NOT NULL,\r\n" + 
					"  `tokens` int(255) NOT NULL,\r\n" + 
					"  `credits` int(255) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`uuid`),\r\n" + 
					"  UNIQUE KEY `uuid` (`uuid`)\r\n" + 
					") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
				
				//start
				
			}else {
				
				Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Bropocalypse§6§l]§r §cLa création de la table \"players\" a échouée.");
				disable();
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3M-Cube§6§l]§r §cConnexion a la base de données impossible.");
			disable();
			
		}
		
	}
	
	public static Configuration getConfiguration() {
		
		return plugin.getConfig();
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}
	
	private static void disable() {
		
		Bukkit.getPluginManager().disablePlugin(plugin);
		
	}

}
