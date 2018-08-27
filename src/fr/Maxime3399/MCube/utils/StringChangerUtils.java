package fr.Maxime3399.MCube.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class StringChangerUtils {
	
	public static ChatColor TxTColorToChatColor(String TxTColor) {
		
		ChatColor result = ChatColor.WHITE;
		
		if(TxTColor.equalsIgnoreCase("§0") || TxTColor.equalsIgnoreCase("&0")) {
			result = ChatColor.BLACK;
		}else if(TxTColor.equalsIgnoreCase("§2") || TxTColor.equalsIgnoreCase("&2")) {
			result = ChatColor.DARK_GREEN;
		}else if(TxTColor.equalsIgnoreCase("§4") || TxTColor.equalsIgnoreCase("&4")) {
			result = ChatColor.DARK_RED;
		}else if(TxTColor.equalsIgnoreCase("§6") || TxTColor.equalsIgnoreCase("&6")) {
			result = ChatColor.GOLD;
		}else if(TxTColor.equalsIgnoreCase("§8") || TxTColor.equalsIgnoreCase("&8")) {
			result = ChatColor.DARK_GRAY;
		}else if(TxTColor.equalsIgnoreCase("§a") || TxTColor.equalsIgnoreCase("&a")) {
			result = ChatColor.GREEN;
		}else if(TxTColor.equalsIgnoreCase("§c") || TxTColor.equalsIgnoreCase("&c")) {
			result = ChatColor.RED;
		}else if(TxTColor.equalsIgnoreCase("§e") || TxTColor.equalsIgnoreCase("&e")) {
			result = ChatColor.YELLOW;
		}else if(TxTColor.equalsIgnoreCase("§1") || TxTColor.equalsIgnoreCase("&1")) {
			result = ChatColor.DARK_BLUE;
		}else if(TxTColor.equalsIgnoreCase("§3") || TxTColor.equalsIgnoreCase("&3")) {
			result = ChatColor.DARK_AQUA;
		}else if(TxTColor.equalsIgnoreCase("§5") || TxTColor.equalsIgnoreCase("&5")) {
			result = ChatColor.DARK_PURPLE;
		}else if(TxTColor.equalsIgnoreCase("§7") || TxTColor.equalsIgnoreCase("&7")) {
			result = ChatColor.GRAY;
		}else if(TxTColor.equalsIgnoreCase("§9") || TxTColor.equalsIgnoreCase("&9")) {
			result = ChatColor.BLUE;
		}else if(TxTColor.equalsIgnoreCase("§b") || TxTColor.equalsIgnoreCase("&b")) {
			result = ChatColor.AQUA;
		}else if(TxTColor.equalsIgnoreCase("§d") || TxTColor.equalsIgnoreCase("&d")) {
			result = ChatColor.LIGHT_PURPLE;
		}else if(TxTColor.equalsIgnoreCase("§r") || TxTColor.equalsIgnoreCase("&r")) {
			result = ChatColor.RESET;
		}else if(TxTColor.equalsIgnoreCase("§k") || TxTColor.equalsIgnoreCase("&k")) {
			result = ChatColor.MAGIC;
		}else if(TxTColor.equalsIgnoreCase("§m") || TxTColor.equalsIgnoreCase("&m")) {
			result = ChatColor.STRIKETHROUGH;
		}else if(TxTColor.equalsIgnoreCase("§o") || TxTColor.equalsIgnoreCase("&o")) {
			result = ChatColor.ITALIC;
		}else if(TxTColor.equalsIgnoreCase("§l") || TxTColor.equalsIgnoreCase("&l")) {
			result = ChatColor.BOLD;
		}else if(TxTColor.equalsIgnoreCase("§n") || TxTColor.equalsIgnoreCase("&n")) {
			result = ChatColor.UNDERLINE;
		}
		
		return result;
		
	}
	
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
			cp.setCredits(cp.getCredits()+credits);
		}else if(content.startsWith("crystals")) {
			content = content.replaceAll("crystals", "");
			int crystals = 0;
			crystals = Integer.parseInt(content);
			cp.setCrystals(cp.getCrystals()+crystals);
		}else if(content.startsWith("points")) {
			content = content.replaceAll("points", "");
			int points = 0;
			points = Integer.parseInt(content);
			cp.setPoints(cp.getPoints()+points);
		}else if(content.startsWith("+")) {
			content = content.substring(1, content.length());
			content = content.replaceAll("&", "§");
			if(cp.getCos_plus_color().equalsIgnoreCase("")) {
				cp.setCos_plus_color(content);
			}else {
				cp.setCos_plus_color(cp.getCos_plus_color()+","+content);
			}
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
		}else if(type.startsWith("+")) {
			type = type.substring(1, type.length());
			type = type.replaceAll("&", "§");
			result = "Préfixe : "+type+"§l+";
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
			}else if(type.equalsIgnoreCase("yt")) {
				result = "Grade STAFF : YT";
			}else if(type.equalsIgnoreCase("stream")) {
				result = "Grade STAFF : Stream";
			}else if(type.equalsIgnoreCase("part")) {
				result = "Grade STAFF : Part";
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
			}else if(type.equalsIgnoreCase("yt")) {
				result = "Grade STAFF : YT";
			}else if(type.equalsIgnoreCase("stream")) {
				result = "Grade STAFF : Stream";
			}else if(type.equalsIgnoreCase("part")) {
				result = "Grade STAFF : Part";
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
