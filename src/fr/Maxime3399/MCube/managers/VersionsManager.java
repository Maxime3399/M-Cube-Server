package fr.Maxime3399.MCube.managers;

import org.bukkit.Bukkit;

public class VersionsManager {
	
	private static String version;
	//private static Version vclass;
	
	public static boolean setupVersion() {
		
		boolean result = true;
		
		try {
			
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
			e.printStackTrace();
			
		}
		
		if(!version.equals("v1_13_R2")) {
			
			result = false;
			
		}
		
		return result;
		
	}

}
