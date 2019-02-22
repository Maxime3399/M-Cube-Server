package fr.Maxime3399.MCube.cosmetics;

import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CosCount {
	
	public static int getGeneralMax() {
		
		return getCosPlusColorMax()+getCosTrailMax()+getCosAmbientMax()+getCosConnectMax()+getCosDisconnectMax()+getCosDeathMax()+getCosRespawnMax();
		
	}
	
	public static int getGeneralCount(Player p) {
		
		return getPlusColorCount(p)+getTrailCount(p)+getAmbientCount(p)+getConnectCount(p)+getDisconnectCount(p)+getDeathCount(p)+getRespawnCount(p);
		
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
	
	public static int getCosTrailMax() {
		
		return 0;
		
	}
	
	public static int getTrailCount(Player p) {
		
		return 0;
		
	}
	
	public static int getCosAmbientMax() {
		
		return 0;
		
	}
	
	public static int getAmbientCount(Player p) {
		
		return 0;
		
	}
	
	public static int getCosConnectMax() {
		
		return 0;
		
	}
	
	public static int getConnectCount(Player p) {
		
		return 0;
		
	}
	
	public static int getCosDisconnectMax() {
		
		return 0;
		
	}
	
	public static int getDisconnectCount(Player p) {
		
		return 0;
		
	}
	
	public static int getCosDeathMax() {
		
		return 0;
		
	}
	
	public static int getDeathCount(Player p) {
		
		return 0;
		
	}
	
	public static int getCosRespawnMax() {
		
		return 0;
		
	}
	
	public static int getRespawnCount(Player p) {
		
		return 0;
		
	}

}
