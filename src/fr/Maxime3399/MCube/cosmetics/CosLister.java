package fr.Maxime3399.MCube.cosmetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class CosLister {
	
	public static void giveCos(Player p, String cos, boolean chest) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(cos.startsWith("cosplus")) {
			if(cp.getCos_plus_color().equalsIgnoreCase("")) {
				cp.setCos_plus_color(cp.getCos_plus_color()+cos);
			}else {
				cp.setCos_plus_color(cp.getCos_plus_color()+","+cos);
			}
		}
		
		if(chest) {
			String ca = getCosStr(cos);
			if(ca.startsWith("§e")) {
				
				for(Player pls : Bukkit.getOnlinePlayers()) {
					
					pls.playSound(pls.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 1);
					pls.sendMessage(p.getDisplayName()+"§r §aa trouvé le cosmétique §r"+ca+"§r §adans un coffre !");
					
				}
				
			}else {
				p.sendMessage("§aTu as trouvé le cosmétique "+ca+"§r §a!");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 1);
			}
		}
		
	}
	
	public static String[] genChest(int stars) {
		
		String[] result = null;
		
		if(stars == 1) {
			result = "common,common,common,common,common".split(",");
		}else if(stars == 2) {
			result = "common,common,common,common,rare".split(",");
		}else if(stars == 3) {
			result = "common,common,common,rare,epic".split(",");
		}else if(stars == 4) {
			result = "common,common,rare,epic,legendary".split(",");
		}else if(stars == 5) {
			result = "common,rare,epic,legendary,legendary".split(",");
		}
		
		for(String a : result) {
			
			ArrayList<String> list = null;
			
			if(a.equalsIgnoreCase("common")) {
				list = getCommonCos();
			}else if(a.equalsIgnoreCase("rare")) {
				list = getRareCos();
			}else if(a.equalsIgnoreCase("epic")) {
				list = getEpicCos();
			}else if(a.equalsIgnoreCase("legendary")) {
				list = getLegendaryCos();
			}
			
			Random r = new Random();
			String rs = list.get(r.nextInt(list.size()));
			String fs = result[0]+","+result[1]+","+result[2]+","+result[3]+","+result[4];
			fs = fs.replaceFirst(a, rs);
			result = fs.split(",");
			
		}
		
		return result;
		
	}
	
	public static ArrayList<String> getCommonCos(){
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("cosplusa");
		
		return list;
		
	}
	
	public static ArrayList<String> getRareCos(){
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("cosplus5");
		
		return list;
		
	}
	
	public static ArrayList<String> getEpicCos(){
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("cosplusd");
		
		return list;
		
	}
	
	public static ArrayList<String> getLegendaryCos(){
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("cosplus4");
		
		return list;
		
	}
	
	public static String getCosStr(String cos) {
		
		String result = "";
		
		if(cos().containsKey(cos)) {
			result = cos().get(cos);
		}
		
		return result;
		
	}
	
	private static HashMap<String, String> cos(){
		
		HashMap<String, String> result = new HashMap<>();
		
		result.put("cosplus2", "§aPréfixe UltraVIP+ : §2§l+");
		result.put("cosplusa", "§aPréfixe UltraVIP+ : §a§l+");
		result.put("cosplus5", "§3Préfixe UltraVIP+ : §5§l+");
		result.put("cosplusd", "§dPréfixe UltraVIP+ : §d§l+");
		result.put("cosplus4", "§ePréfixe UltraVIP+ : §4§l+");
		result.put("cosplusc", "§aPréfixe UltraVIP+ : §c§l+");
		result.put("cosplus6", "§aPréfixe UltraVIP+ : §6§l+");
		result.put("cospluse", "§3Préfixe UltraVIP+ : §e§l+");
		result.put("cosplus1", "§dPréfixe UltraVIP+ : §1§l+");
		result.put("cosplus9", "§ePréfixe UltraVIP+ : §9§l+");
		result.put("cosplus3", "§ePréfixe UltraVIP+ : §3§l+");
		result.put("cosplusb", "§ePréfixe UltraVIP+ : §b§l+");
		result.put("cosplus0", "§ePréfixe UltraVIP+ : §0§l+");
		result.put("cosplus8", "§ePréfixe UltraVIP+ : §8§l+");
		result.put("cosplus7", "§ePréfixe UltraVIP+ : §7§l+");
		result.put("cosplusf", "§ePréfixe UltraVIP+ : §f§l+");
		
		return result;
		
	}

}
