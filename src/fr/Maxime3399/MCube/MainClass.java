package fr.Maxime3399.MCube;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.Maxime3399.MCube.managers.CommandsManager;
import fr.Maxime3399.MCube.managers.EventsManager;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.managers.SchedulersManager;
import fr.Maxime3399.MCube.managers.VersionsManager;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	private static boolean enable;
	
	public void onEnable() {
		
		plugin = this;
		enable = false;
		PlayersManager.use = true;
		DataUtils.use = 1;
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				
				Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �eLe fichier de configuration \"config.yml\" a �t� cr��. Merci de configurer le plugin.");
				disable();
				
			}else if(MySQLUtils.connect()) {
				
				if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `players` (\r\n" + 
						"  `uuid` varchar(255) NOT NULL,\r\n" + 
						"  `name` varchar(255) NOT NULL,\r\n" + 
						"  `data` int(255) NOT NULL,\r\n" + 
						"  `rank` varchar(255) NOT NULL DEFAULT 'default',\r\n" + 
						"  `staff` varchar(255) NOT NULL DEFAULT 'default',\r\n" + 
						"  `other_ranks` varchar(255) NOT NULL DEFAULT '',\r\n" + 
						"  `points` int(255) NOT NULL DEFAULT '-1',\r\n" + 
						"  `step` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `tokens` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `credits` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `crystals` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `legendary_steps` varchar(255) NOT NULL DEFAULT 'false',\r\n" + 
						"  `placement_end` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `gifts` varchar(255) NOT NULL DEFAULT '',\r\n" + 
						"  `chests` varchar(255) NOT NULL DEFAULT '',\r\n" + 
						"  `last_connection` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `connection_streak` varchar(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `fly` varchar(255) NOT NULL DEFAULT 'false',\r\n" + 
						"  `cos_active` varchar(255) NOT NULL DEFAULT 'cosplus2',\r\n" + 
						"  `cos_plus_color` varchar(255) NOT NULL DEFAULT 'cosplus2',\r\n" + 
						"  `season_1_points` int(255) NOT NULL DEFAULT '-1',\r\n" + 
						"  `season_2_points` int(255) NOT NULL DEFAULT '-1',\r\n" + 
						"  `season_3_points` int(255) NOT NULL DEFAULT '-1',\r\n" + 
						"  `season_4_points` int(255) DEFAULT '-1',\r\n" + 
						"  `season_5_points` int(255) NOT NULL DEFAULT '-1',\r\n" + 
						"  `s_time_seconds` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `s_time_minutes` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `s_time_hours` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_time_seconds` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_time_minutes` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_time_hours` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_blocks_place` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_blocks_break` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_chunks` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_damages_take` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_damages_give` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_jump` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_drop` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_pickup` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_deaths` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_kill_animals` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_kill_monsters` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_kill_players` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_food` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_craft` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_chat` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_exp` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_portal` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_shear` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_commands` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_advancement` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_bed` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_armorstand` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `r_enchant` int(255) NOT NULL DEFAULT '0',\r\n" + 
						"  `home1` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home2` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home3` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home4` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home5` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home6` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home7` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home8` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home9` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home10` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home11` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home12` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home13` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home14` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home15` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home16` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home17` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home18` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home19` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home20` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home21` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home22` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home23` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home24` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home25` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home26` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home27` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home28` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home29` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home30` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home31` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home32` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home33` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home34` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home35` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home36` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home37` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home38` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home39` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  `home40` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
						"  PRIMARY KEY (`uuid`),\r\n" + 
						"  UNIQUE KEY `uuid` (`uuid`)\r\n" + 
						") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
					
					if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `infos` (\r\n" + 
							"  `type` varchar(255) NOT NULL,\r\n" + 
							"  `info_int` int(255) NOT NULL,\r\n" + 
							"  `info_string` varchar(255) NOT NULL,\r\n" + 
							"  PRIMARY KEY (`type`),\r\n" + 
							"  UNIQUE KEY `type` (`type`)\r\n" + 
							") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
						
						if(MySQLUtils.getValues("infos").size() == 0) {
							
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
							Date dNew = new Date();
							Calendar cal = Calendar.getInstance();
							cal.setTime(dNew);
							cal.add(Calendar.DAY_OF_MONTH, 60);
							dNew.setTime(cal.getTimeInMillis());
							String nd = sdf.format(dNew);
							
							MySQLUtils.execute("INSERT INTO `infos` (`type`, `info_int`, `info_string`) VALUES\r\n" + 
									"('currentSeason', 1, ''),\r\n" + 
									"('season_1_end', 0, '"+nd+"'),\r\n" + 
									"('maintenance', 0, 'false'),\r\n" + 
									"('data', 0, ''),\r\n" + 
									"('motd1', 0, '�6�lM-Cube�r      �dVersion 1.13.2'),\r\n" + 
									"('motd2', 0, '�3Le serveur est en d�veloppement !'),\r\n" + 
									"('slots', 8, ''),\r\n" + 
									"('slots_vip', 6, ''),\r\n" + 
									"('maintenance_start', 0, '');", false);
							
						}
						
						if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `gifts` (\r\n" + 
								"  `id` varchar(255) NOT NULL,\r\n" + 
								"  `item` varchar(255) NOT NULL DEFAULT 'STONE',\r\n" + 
								"  `description` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
								"  `content` varchar(255) NOT NULL,\r\n" + 
								"  PRIMARY KEY (`id`),\r\n" + 
								"  UNIQUE KEY `id` (`id`)\r\n" + 
								") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
							
							if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `chests` (\r\n" + 
									"  `id` varchar(255) NOT NULL,\r\n" + 
									"  `stars` int(255) NOT NULL DEFAULT '1',\r\n" + 
									"  `bypass` varchar(255) NOT NULL DEFAULT 'false',\r\n" + 
									"  `content_1` varchar(255) NOT NULL,\r\n" + 
									"  `content_2` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
									"  `content_3` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
									"  `content_4` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
									"  `content_5` varchar(255) NOT NULL DEFAULT 'none',\r\n" + 
									"  PRIMARY KEY (`id`)\r\n" + 
									") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
								
								enable = true;
								EventsManager.registerEvents();
								SchedulersManager.registerSchedulers();
								CommandsManager.registerCommands();
								
							}
							
						}else {
							
							Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �cLa cr�ation de la table \"gifts\" a �chou�e.");
							disable();
							
						}
						
					}else {
						
						Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �cLa cr�ation de la table \"infos\" a �chou�e.");
						disable();
						
					}
					
				}else {
					
					Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �cLa cr�ation de la table \"players\" a �chou�e.");
					disable();
					
				}
				
			}else {
				
				Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �cConnexion a la base de donn�es impossible.");
				disable();
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �cLa version de spigot n'est pas compatible !");
			disable();
			
		}
		
	}
	
	public void onDisable() {
		
		if(enable) {
			
			Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();
			
			for(Team ts : s.getTeams()) {
				
				ts.unregister();
				
			}
			
			for(Player pls : Bukkit.getOnlinePlayers()) {
				
				PlayersManager.getCustomPlayer(pls).save();
				pls.kickPlayer("�6Red�marrage du serveur...");
				
			}
			
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
