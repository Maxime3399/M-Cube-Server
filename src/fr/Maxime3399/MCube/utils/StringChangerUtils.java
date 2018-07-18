package fr.Maxime3399.MCube.utils;

public class StringChangerUtils {
	
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
		}else if(type.startsWith("pluscolors")) {
			type = type.replaceAll("pluscolor", "");
			result = "Couleur : §"+type+"§l+";
		}else if(type.startsWith("legendarypass")) {
			type = type.replaceAll("legendarypass", "");
			result = "Pass légendaire";
		}else if(type.startsWith("chests")) {
			type = type.replaceAll("chests", "");
			type = type.replaceAll("true", "");
			type = type.replaceAll("false", "");
			result = "Coffre "+type+" étoiles";
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
		}
		
		return result;
		
	}

}
