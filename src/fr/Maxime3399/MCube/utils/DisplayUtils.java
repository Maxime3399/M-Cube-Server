package fr.Maxime3399.MCube.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class DisplayUtils {
	
	@SuppressWarnings("deprecation")
	public static void setDisplay(Player p) {
		
		String prefix = getClassPrefix(p);
		if(!getRank(p).equalsIgnoreCase("§r")) {
			prefix = getRank(p)+"§r "+prefix;
		}
		String suffix = "";
		if(!getStep(p).equalsIgnoreCase("")) {
			suffix = "§r"+getStep(p);
		}
		
		Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();
		for(Team t : s.getTeams()) {
			
			if(t.hasPlayer(p)) {
				
				t.unregister();
				
			}
			
		}
		
		Team te = s.registerNewTeam(calculTeamsOrder(p)+p.getName());
		te.setPrefix(prefix);
		te.setSuffix(suffix);
		te.addPlayer(p);
		
	}
	
	public static String calculTeamsOrder(Player p) {
		
		String result = "99999";
		
		ArrayList<String> allRanks = new ArrayList<>();
		ArrayList<String> allRanksOrdered = new ArrayList<>();
		ArrayList<Player> players = new ArrayList<>();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			players.add(pls);
			
			if(!allRanks.contains(getRank(pls))) {
				
				allRanks.add(getRank(pls));
				
			}
			
		}
		
		if(allRanks.contains("§4§l[§r§4Créateur§l]")) {
			allRanks.remove("§4§l[§r§4Créateur§l]");
			allRanksOrdered.add("§4§l[§r§4Créateur§l]");
		}
		if(allRanks.contains("§c§l[§r§cAdmin§l]")) {
			allRanks.remove("§c§l[§r§cAdmin§l]");
			allRanksOrdered.add("§c§l[§r§cAdmin§l]");
		}
		if(allRanks.contains("§3§l[§r§3Resp.Dev§l]")) {
			allRanks.remove("§3§l[§r§3Resp.Dev§l]");
			allRanksOrdered.add("§3§l[§r§3Resp.Dev§l]");
		}
		if(allRanks.contains("§3§l[§r§3Dev§l]")) {
			allRanks.remove("§3§l[§r§3Dev§l]");
			allRanksOrdered.add("§3§l[§r§3Dev§l]");
		}
		if(allRanks.contains("§6§l[§r§6Resp.Mod§l]")) {
			allRanks.remove("§6§l[§r§6Resp.Mod§l]");
			allRanksOrdered.add("§6§l[§r§6Resp.Mod§l]");
		}
		if(allRanks.contains("§6§l[§r§6Mod§l]")) {
			allRanks.remove("§6§l[§r§6Mod§l]");
			allRanksOrdered.add("§6§l[§r§6Mod§l]");
		}
		if(allRanks.contains("§9§l[§r§9Helper§l]")) {
			allRanks.remove("§9§l[§r§9Helper§l]");
			allRanksOrdered.add("§9§l[§r§9Helper§l]");
		}
		if(allRanks.contains("§2§l[§r§2UltraVIP+§2§l]")) {
			allRanks.remove("§2§l[§r§2UltraVIP+§2§l]");
			allRanksOrdered.add("§2§l[§r§2UltraVIP+§2§l]");
		}
		if(allRanks.contains("§a§l[§r§aUltraVIP§l]")) {
			allRanks.remove("§a§l[§r§aUltraVIP§l]");
			allRanksOrdered.add("§a§l[§r§aUltraVIP§l]");
		}
		if(allRanks.contains("§b§l[§r§bVIP+§l]")) {
			allRanks.remove("§b§l[§r§bVIP+§l]");
			allRanksOrdered.add("§b§l[§r§bVIP+§l]");
		}
		if(allRanks.contains("§e§l[§r§eVIP§l]")) {
			allRanks.remove("§e§l[§r§eVIP§l]");
			allRanksOrdered.add("§e§l[§r§eVIP§l]");
		}
		if(allRanks.contains("§f§l[§r§fMiniVIP§l]")) {
			allRanks.remove("§f§l[§r§fMiniVIP§l]");
			allRanksOrdered.add("§f§l[§r§fMiniVIP§l]");
		}
		if(allRanks.contains("§r")) {
			allRanks.remove("§r");
			allRanksOrdered.add("§r");
		}
		
		int order = 0;
		int place = 0;
		
		for(String rank : allRanksOrdered) {
			
			for(Player pls : players) {
				
				if(getRank(pls).equalsIgnoreCase(rank)) {
					
					order = order+1;
					
					if(p == pls) {
						
						place = order;
						
					}
					
				}
				
			}
			
		}
		
		if(place > 99) {
			
			result = "00"+place;
			
		}else if(place > 9) {
			
			result = "000"+place;
			
		}else {
			
			result = "0000"+place;
			
		}
		
		return result;
		
	}
	
	public static String getStep(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		String result = "§7§l|§r§f0§7§l|";
		
		if(cp.getStep() == -1) {
			
			result = "";
			
		}else {
			
			if(cp.isLegendary_steps()) {
				
				result = "§6§l|§r§e"+cp.getStep()+"§6§l|";
				
			}else {
				
				result = "§7§l|§r§f"+cp.getStep()+"§7§l|";
				
			}
			
		}
		
		
		return result;
		
	}
	
	public static String getRank(Player p) {
		
		String result = "§r";
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(cp.getStaff().equalsIgnoreCase("créateur")) {
			
			result = "§4§l[§r§4Créateur§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("admin")) {
			
			result = "§c§l[§r§cAdmin§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("respdev")) {
			
			result = "§3§l[§r§3Resp.Dev§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("dev")) {
			
			result = "§3§l[§r§3Dev§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("respmod")) {
			
			result = "§6§l[§r§6Resp.Mod§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("mod")) {
			
			result = "§6§l[§r§6Mod§l]";
			
		}else if(cp.getStaff().equalsIgnoreCase("help")) {
			
			result = "§9§l[§r§9Helper§l]";
			
		}else if(cp.getRank().equalsIgnoreCase("ultravipplus")) {
			
			result = "§2§l[§r§2UltraVIP+§2§l]";
			
		}else if(cp.getRank().equalsIgnoreCase("ultravip")) {
			
			result = "§a§l[§r§aUltraVIP§l]";
			
		}else if(cp.getRank().equalsIgnoreCase("vipplus")) {
			
			result = "§b§l[§r§bVIP+§l]";
			
		}else if(cp.getRank().equalsIgnoreCase("vip")) {
			
			result = "§e§l[§r§eVIP§l]";
			
		}else if(cp.getRank().equalsIgnoreCase("minivip")) {
			
			result = "§f§l[§r§fMiniVIP§l]";
			
		}
		
		return result;
		
	}
	
	public static String getClassPrefix(Player p) {
		
		String result = "§8";
		String clas = getClass(p);
		
		result = clas.charAt(0)+""+clas.charAt(1);
		
		return result;
		
	}
	
	public static String getClass(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		int points = cp.getPoints();
		String result = "§8Bronze";
		
		if(cp.getPointClassement() == 1) {
			
			result = "§1Top 1";
			
		}else if(cp.getPointClassement() == 2) {
			
			result = "§9Top 2";
			
		}else if(cp.getPointClassement() == 3) {
			
			result = "§bTop 3";
			
		}else if(points >= 500) {
			
			result = "§2Légende";
			
		}else if(points >= 400) {
			
			result = "§aMaître";
			
		}else if(points >= 300) {
			
			result = "§6Platine";
			
		}else if(points >= 200) {
			
			result = "§eOr";
			
		}else if(points >= 100) {
			
			result = "§fArgent";
			
		}
		
		return result;
		
	}

}
