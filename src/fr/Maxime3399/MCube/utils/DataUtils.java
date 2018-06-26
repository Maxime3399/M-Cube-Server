package fr.Maxime3399.MCube.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
	
	public static int getCurrentSeason() {
		
		return MySQLUtils.getInt("infos", "type", "currentSeason", "info_int");
		
	}
	
	public static String getEndSeason() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date dO = null;
		try {
			dO = sdf.parse(MySQLUtils.getString("infos", "type", "season_"+getCurrentSeason()+"_end", "info_string"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dT = new Date();
		Long result = dO.getTime()-dT.getTime();
		
		int y = 60*60*1000;
		long h = result/y;
		long m = (result-(h*y))/(y/60);
		long s = (result-(h*y)-(m*(y/60)))/1000;
		
		return h+":"+m+":"+s;
		
	}

}
