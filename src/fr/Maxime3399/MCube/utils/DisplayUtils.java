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
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		String prefix = getClassPrefix(p);
		if(getRank(p).equalsIgnoreCase("§2UltraVIP+")) {
			prefix = "§2UltraVIP"+cp.getPlus_color()+"+"+" "+prefix;
		}else if(!getRank(p).equalsIgnoreCase("§r")) {
			prefix = getRank(p)+"§r "+prefix;
		}
		String suffix = "";
		if(!getStep(p).equalsIgnoreCase("")) {
			suffix = " "+getStep(p)+"§r";
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
		
		p.setDisplayName(prefix+p.getName()+suffix);
		
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
		
		if(allRanks.contains("§4Créateur")) {
			allRanks.remove("§4Créateur");
			allRanksOrdered.add("§4Créateur");
		}
		if(allRanks.contains("§cAdmin")) {
			allRanks.remove("§cAdmin");
			allRanksOrdered.add("§cAdmin");
		}
		if(allRanks.contains("§3Resp.Dev")) {
			allRanks.remove("§3Resp.Dev");
			allRanksOrdered.add("§3Resp.Dev");
		}
		if(allRanks.contains("§3Dev")) {
			allRanks.remove("§3Dev");
			allRanksOrdered.add("§3Dev");
		}
		if(allRanks.contains("§6Resp.Mod")) {
			allRanks.remove("§6Resp.Mod");
			allRanksOrdered.add("§6Resp.Mod");
		}
		if(allRanks.contains("§6Mod")) {
			allRanks.remove("§6Mod");
			allRanksOrdered.add("§6Mod");
		}
		if(allRanks.contains("§9Helper")) {
			allRanks.remove("§9Helper");
			allRanksOrdered.add("§9Helper");
		}
		if(allRanks.contains("§2UltraVIP+")) {
			allRanks.remove("§2UltraVIP+");
			allRanksOrdered.add("§2UltraVIP+");
		}
		if(allRanks.contains("§aUltraVIP")) {
			allRanks.remove("§aUltraVIP");
			allRanksOrdered.add("§aUltraVIP");
		}
		if(allRanks.contains("§bUltraVIP")) {
			allRanks.remove("§bUltraVIP");
			allRanksOrdered.add("§bUltraVIP");
		}
		if(allRanks.contains("§eVIP")) {
			allRanks.remove("§eVIP");
			allRanksOrdered.add("§eVIP");
		}
		if(allRanks.contains("§fMiniVIP")) {
			allRanks.remove("§fMiniVIP");
			allRanksOrdered.add("§fMiniVIP");
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
		String result = "0";
		
		if(cp.getStep() == -1) {
			
			result = "";
			
		}else {
			
			if(cp.isLegendary_steps()) {
				
				result = "§e"+cp.getStep()+"";
				
			}else {
				
				result = "§f"+cp.getStep()+"";
				
			}
			
		}
		
		
		return result;
		
	}
	
	public static String getRank(Player p) {
		
		String result = "§r";
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(cp.getStaff().equalsIgnoreCase("créateur")) {
			
			result = "§4Créateur";
			
		}else if(cp.getStaff().equalsIgnoreCase("admin")) {
			
			result = "§cAdmin";
			
		}else if(cp.getStaff().equalsIgnoreCase("respdev")) {
			
			result = "§3Resp.Dev";
			
		}else if(cp.getStaff().equalsIgnoreCase("dev")) {
			
			result = "§3Dev";
			
		}else if(cp.getStaff().equalsIgnoreCase("respmod")) {
			
			result = "§6Resp.Mod";
			
		}else if(cp.getStaff().equalsIgnoreCase("mod")) {
			
			result = "§6Mod";
			
		}else if(cp.getStaff().equalsIgnoreCase("help")) {
			
			result = "§9Helper";
			
		}else if(cp.getRank().equalsIgnoreCase("ultravipplus")) {
			
			result = "§2UltraVIP+";
			
		}else if(cp.getRank().equalsIgnoreCase("ultravip")) {
			
			result = "§aUltraVIP";
			
		}else if(cp.getRank().equalsIgnoreCase("vipplus")) {
			
			result = "§bUltraVIP";
			
		}else if(cp.getRank().equalsIgnoreCase("vip")) {
			
			result = "§eVIP";
			
		}else if(cp.getRank().equalsIgnoreCase("minivip")) {
			
			result = "§fMiniVIP";
			
		}
		
		return result;
		
	}
	
	public static String getClassPrefix(Player p) {
		
		String result = "§8";
		String clas = getClass(p, DataUtils.getCurrentSeason());
		
		result = clas.charAt(0)+""+clas.charAt(1);
		
		return result;
		
	}
	
	public static String getClass(Player p, int season) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		int points = cp.getPoints();
		String result = "§7Bronze";
		
		if(points == -1) {
			
			result = "§8Non-Classé";
			
		}else if(cp.getPointClassement(season) == 1) {
			
			result = "§1Top 1";
			
		}else if(cp.getPointClassement(season) == 2) {
			
			result = "§9Top 2";
			
		}else if(cp.getPointClassement(season) == 3) {
			
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
