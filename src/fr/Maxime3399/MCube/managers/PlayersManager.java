package fr.Maxime3399.MCube.managers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;

public class PlayersManager {
	
	private static ArrayList<CustomPlayer> list = new ArrayList<>();
	public static boolean use;
	
	public static CustomPlayer addPlayer(Player p) {
		
		CustomPlayer cp = new CustomPlayer(p);
		list.add(cp);
		
		return cp;
		
	}
	
	public static void removePlayer(CustomPlayer cp) {
		
		cp.save();
		list.remove(cp);
		
	}
	
	public static void removePlayer(Player p) {
		
		CustomPlayer cp = getCustomPlayer(p);
		
		if(cp != null) {
			
			cp.save();
			list.remove(cp);
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("�6�l[�r�3M-Cube�6�l]�r �dLe CustomPlayer ne peut pas �tre nul.");
			
		}
		
	}
	
	public static CustomPlayer getCustomPlayer(Player p) {
		
		CustomPlayer cp = null;
		
		for(CustomPlayer cps : list) {
			
			if(cps.getUuid().equals(p.getUniqueId())) {
				
				cp = cps;
				
			}
			
		}
		
		return cp;
		
	}
	
	public static ArrayList<CustomPlayer> getCustomPlayers(){
		
		return list;
		
	}

}
