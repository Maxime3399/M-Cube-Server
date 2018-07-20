package fr.Maxime3399.MCube.cosmetics;

import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CosCount {
	
	public static int getGeneralMax() {
		
		return getCosPlusColorMax();
		
	}
	
	public static int getGeneralCount(Player p) {
		
		return getPlusColorCount(p);
		
	}
	
	public static int getCosPlusColorMax() {
		
		return 16;
		
	}
	
	public static int getPlusColorCount(Player p) {
		
		int result = 0;
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		String po = cp.getCos_plus_color();
		
		if(!po.equalsIgnoreCase("")) {
			
			String g[] = po.split(",");
			result = result+g.length;
			
		}
		
		return result;
		
	}

}
