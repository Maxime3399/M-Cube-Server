package fr.Maxime3399.MCube.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataUtils {
	
	public static int use = 0;
	
	public static int getCurrentSeason() {
		
		int result = 0;
		
		try {
			result = MySQLUtils.getInt("infos", "type", "currentSeason", "info_int");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static int getData() {
		
		return MySQLUtils.getInt("infos", "type", "data", "info_int");
		
	}
	
	public static String getEndSeason() {
		
		int cs = getCurrentSeason();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date dO = null;
		try {
			dO = sdf.parse(MySQLUtils.getString("infos", "type", "season_"+cs+"_end", "info_string"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dT = new Date();
		Long result = dO.getTime()-dT.getTime();
		
		long d = TimeUnit.MILLISECONDS.toDays(result);
		long h = TimeUnit.MILLISECONDS.toHours(result)-TimeUnit.DAYS.toHours(d);
		long m = TimeUnit.MILLISECONDS.toMinutes(result)-TimeUnit.DAYS.toMinutes(d)-TimeUnit.HOURS.toMinutes(h);
		long s = TimeUnit.MILLISECONDS.toSeconds(result)-TimeUnit.DAYS.toSeconds(d)-TimeUnit.HOURS.toSeconds(h)-TimeUnit.MINUTES.toSeconds(m);
		
		return d+":"+h+":"+m+":"+s;
		
	}
	
	public static boolean getMaintenance() {
		
		return Boolean.parseBoolean(MySQLUtils.getString("infos", "type", "maintenance", "info_string"));
		
	}
	
	public static String getMotd(int line) {
		
		return MySQLUtils.getString("infos", "type", "motd"+line, "info_string");
		
	}
	
	public static int getSlots() {
		
		return MySQLUtils.getInt("infos", "type", "slots", "info_int");
		
	}
	
	public static int getSlotsVIP() {
		
		return MySQLUtils.getInt("infos", "type", "slots_vip", "info_int");
		
	}

}
