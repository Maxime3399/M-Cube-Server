package fr.Maxime3399.MCube.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.events.JoinEvents;
import fr.Maxime3399.MCube.events.QuitEvents;
import fr.Maxime3399.MCube.events.SystemEvents;
import fr.Maxime3399.MCube.events.menus.GiftMenuEvents;
import fr.Maxime3399.MCube.events.menus.MainMenuEvents;
import fr.Maxime3399.MCube.events.menus.RankedMenuEvents;

public class EventsManager {
	
	public static void registerEvents() {
		
		Plugin p = MainClass.getInstance();
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new JoinEvents(), p);
		pm.registerEvents(new QuitEvents(), p);
		pm.registerEvents(new SystemEvents(), p);
		
		pm.registerEvents(new MainMenuEvents(), p);
		pm.registerEvents(new RankedMenuEvents(), p);
		pm.registerEvents(new GiftMenuEvents(), p);
		
	}

}
