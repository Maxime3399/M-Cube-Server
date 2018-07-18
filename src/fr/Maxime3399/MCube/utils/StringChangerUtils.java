package fr.Maxime3399.MCube.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class StringChangerUtils {
	
	public static void giveGift(Player p, String content) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(content.startsWith("tokens")) {
			content = content.replaceAll("tokens", "");
			int tokens = 0;
			tokens = Integer.parseInt(content);
			cp.setTokens(cp.getTokens()+tokens);
		}else if(content.startsWith("credits")) {
			content = content.replaceAll("credits", "");
			int credits = 0;
			credits = Integer.parseInt(content);
			cp.setTokens(cp.getTokens()+credits);
		}else if(content.startsWith("crystals")) {
			content = content.replaceAll("crystals", "");
			int crystals = 0;
			crystals = Integer.parseInt(content);
			cp.setTokens(cp.getTokens()+crystals);
		}else if(content.startsWith("legendarypass")) {
			cp.setLegendary_steps(true);
		}else if(content.startsWith("rank")) {
			content = content.replaceAll("rank", "");
			cp.setRank(content);
			for(Player pls : Bukkit.getOnlinePlayers()) {
				DisplayUtils.setDisplay(pls);
			}
			//#PERMISSIONS#
		}else if(content.startsWith("staff")) {
			content = content.replaceAll("staff", "");
			cp.setStaff(content);
			for(Player pls : Bukkit.getOnlinePlayers()) {
				DisplayUtils.setDisplay(pls);
			}
			//#PERMISSIONS#
		}else if(content.startsWith("otherrank")) {
			if(!cp.getOther_ranks().contains(content)) {
				cp.setOther_ranks(cp.getOther_ranks()+","+content);
				for(Player pls : Bukkit.getOnlinePlayers()) {
					DisplayUtils.setDisplay(pls);
				}
				//#PERMISSIONS#
			}
		}
		
	}
	
	/*else if(type.startsWith("chests")) {
		type = type.replaceAll("chests", "");
		type = type.replaceAll("true", "");
		type = type.replaceAll("false", "");
		result = "Coffre "+type+" étoiles";
	}*/
	
	public static String getGift(String type) {
		
		String result = "";
		
		if(type.startsWith("tokens")) {
			type = type.replaceAll("tokens", "");
			result = type+" jetons";
		}else if(type.startsWith("credits")) {
			type = type.replaceAll("credits", "");
			result = type+" crédits";
		}else if(type.startsWith("crystals")) {
			type = type.replaceAll("crystals", "");
			result = type+" cristaux";
		}else if(type.startsWith("legendarypass")) {
			type = type.replaceAll("legendarypass", "");
			result = "Pass légendaire";
		}else if(type.startsWith("points")) {
			type = type.replaceAll("points", "");
			result = type+" points";
		}else if(type.startsWith("rank")) {
			type = type.replaceAll("rank", "");
			if(type.equalsIgnoreCase("ultravipplus")) {
				result = "Grade : UltraVIP+";
			}else if(type.equalsIgnoreCase("ultravip")) {
				result = "Grade : UltraVIP";
			}else if(type.equalsIgnoreCase("vip")) {
				result = "Grade : VIP";
			}else if(type.equalsIgnoreCase("minivip")) {
				result = "Grade : MiniVIP";
			}
		}else if(type.startsWith("staff")) {
			type = type.replaceAll("staff", "");
			if(type.equalsIgnoreCase("créateur")) {
				result = "Grade STAFF : Créateur";
			}else if(type.equalsIgnoreCase("admin")) {
				result = "Grade STAFF : Admin";
			}else if(type.equalsIgnoreCase("respdev")) {
				result = "Grade STAFF : Resp.Dev";
			}else if(type.equalsIgnoreCase("dev")) {
				result = "Grade STAFF : Dev";
			}else if(type.equalsIgnoreCase("respmod")) {
				result = "Grade STAFF : Resp.Mod";
			}else if(type.equalsIgnoreCase("mod")) {
				result = "Grade STAFF : Mod";
			}else if(type.equalsIgnoreCase("help")) {
				result = "Grade STAFF : Help";
			}
		}else if(type.startsWith("otherrank")) {
			type = type.replaceAll("otherrank", "");
			if(type.equalsIgnoreCase("créateur")) {
				result = "Grade STAFF : Créateur";
			}else if(type.equalsIgnoreCase("admin")) {
				result = "Grade STAFF : Admin";
			}else if(type.equalsIgnoreCase("respdev")) {
				result = "Grade STAFF : Resp.Dev";
			}else if(type.equalsIgnoreCase("dev")) {
				result = "Grade STAFF : Dev";
			}else if(type.equalsIgnoreCase("respmod")) {
				result = "Grade STAFF : Resp.Mod";
			}else if(type.equalsIgnoreCase("mod")) {
				result = "Grade STAFF : Mod";
			}else if(type.equalsIgnoreCase("help")) {
				result = "Grade STAFF : Help";
			}else if(type.equalsIgnoreCase("ultravipplus")) {
				result = "Grade : UltraVIP+";
			}else if(type.equalsIgnoreCase("ultravip")) {
				result = "Grade : UltraVIP";
			}else if(type.equalsIgnoreCase("vip")) {
				result = "Grade : VIP";
			}else if(type.equalsIgnoreCase("minivip")) {
				result = "Grade : MiniVIP";
			}
		}else {
			
			result = null;
			
		}
		
		return result;
		
	}

}
