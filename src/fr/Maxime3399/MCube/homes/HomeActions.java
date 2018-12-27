package fr.Maxime3399.MCube.homes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class HomeActions {
	
	public static Location getHomeLocation(Player p, int home) {
		
		String[] str2loc = getHome(p, home).split(",");
		Location l = new Location(Bukkit.getWorld(str2loc[1]), Double.parseDouble(str2loc[2])+0.5, Double.parseDouble(str2loc[3])+0.5, Double.parseDouble(str2loc[4])+0.5);
		l.setYaw(Float.parseFloat(str2loc[5]));
		l.setPitch(Float.parseFloat(str2loc[6]));
		
		return l;
		
	}
	
	public static String getHomeName(Player p, int home) {
		
		String result = getHome(p, home).split(",")[0];
		
		return result;
		
	}
	
	public static boolean isHome(Player p, int home) {
		
		boolean result = true;
		
		if(getHome(p, home).equalsIgnoreCase("none")) {
			result = false;
		}
		
		return result;
		
	}
	
	public static void defineHome(Player p, int home, String name) {
		
		Location l = p.getLocation();
		String ls = name+","+l.getWorld()+","+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+","+l.getYaw()+","+l.getPitch();
		
		setHome(p, home, ls);
		
	}
	
	public static int getMaxHome(Player p) {
		
		int result = 0;
		
		if(p.hasPermission("mcube.home.40")) {
			result = 40;
		}else if(p.hasPermission("mcube.home.39")) {
			result = 39;
		}else if(p.hasPermission("mcube.home.38")) {
			result = 38;
		}else if(p.hasPermission("mcube.home.37")) {
			result = 37;
		}else if(p.hasPermission("mcube.home.36")) {
			result = 36;
		}else if(p.hasPermission("mcube.home.35")) {
			result = 35;
		}else if(p.hasPermission("mcube.home.34")) {
			result = 34;
		}else if(p.hasPermission("mcube.home.33")) {
			result = 33;
		}else if(p.hasPermission("mcube.home.32")) {
			result = 32;
		}else if(p.hasPermission("mcube.home.31")) {
			result = 31;
		}else if(p.hasPermission("mcube.home.30")) {
			result = 30;
		}else if(p.hasPermission("mcube.home.29")) {
			result = 29;
		}else if(p.hasPermission("mcube.home.28")) {
			result = 28;
		}else if(p.hasPermission("mcube.home.27")) {
			result = 27;
		}else if(p.hasPermission("mcube.home.26")) {
			result = 26;
		}else if(p.hasPermission("mcube.home.25")) {
			result = 25;
		}else if(p.hasPermission("mcube.home.24")) {
			result = 24;
		}else if(p.hasPermission("mcube.home.23")) {
			result = 23;
		}else if(p.hasPermission("mcube.home.22")) {
			result = 22;
		}else if(p.hasPermission("mcube.home.21")) {
			result = 21;
		}else if(p.hasPermission("mcube.home.20")) {
			result = 20;
		}else if(p.hasPermission("mcube.home.19")) {
			result = 19;
		}else if(p.hasPermission("mcube.home.18")) {
			result = 18;
		}else if(p.hasPermission("mcube.home.17")) {
			result = 17;
		}else if(p.hasPermission("mcube.home.16")) {
			result = 16;
		}else if(p.hasPermission("mcube.home.15")) {
			result = 15;
		}else if(p.hasPermission("mcube.home.14")) {
			result = 14;
		}else if(p.hasPermission("mcube.home.13")) {
			result = 13;
		}else if(p.hasPermission("mcube.home.12")) {
			result = 12;
		}else if(p.hasPermission("mcube.home.11")) {
			result = 11;
		}else if(p.hasPermission("mcube.home.10")) {
			result = 10;
		}else if(p.hasPermission("mcube.home.9")) {
			result = 9;
		}else if(p.hasPermission("mcube.home.8")) {
			result = 8;
		}else if(p.hasPermission("mcube.home.7")) {
			result = 7;
		}else if(p.hasPermission("mcube.home.6")) {
			result = 6;
		}else if(p.hasPermission("mcube.home.5")) {
			result = 5;
		}else if(p.hasPermission("mcube.home.4")) {
			result = 4;
		}else if(p.hasPermission("mcube.home.3")) {
			result = 3;
		}else if(p.hasPermission("mcube.home.2")) {
			result = 2;
		}else if(p.hasPermission("mcube.home.1")) {
			result = 1;
		}
		
		return result;
		
	}
	
	public static int getHomeByName(Player p, String name) {
		
		int result = 0;
		
		if(getHomeName(p, 1).equalsIgnoreCase(name)) {
			result = 1;
		}else if(getHomeName(p, 2).equalsIgnoreCase(name)) {
			result = 2;
		}else if(getHomeName(p, 3).equalsIgnoreCase(name)) {
			result = 3;
		}else if(getHomeName(p, 4).equalsIgnoreCase(name)) {
			result = 4;
		}else if(getHomeName(p, 5).equalsIgnoreCase(name)) {
			result = 5;
		}else if(getHomeName(p, 6).equalsIgnoreCase(name)) {
			result = 6;
		}else if(getHomeName(p, 7).equalsIgnoreCase(name)) {
			result = 7;
		}else if(getHomeName(p, 8).equalsIgnoreCase(name)) {
			result = 8;
		}else if(getHomeName(p, 9).equalsIgnoreCase(name)) {
			result = 9;
		}else if(getHomeName(p, 10).equalsIgnoreCase(name)) {
			result = 10;
		}else if(getHomeName(p, 11).equalsIgnoreCase(name)) {
			result = 11;
		}else if(getHomeName(p, 12).equalsIgnoreCase(name)) {
			result = 12;
		}else if(getHomeName(p, 12).equalsIgnoreCase(name)) {
			result = 13;
		}else if(getHomeName(p, 14).equalsIgnoreCase(name)) {
			result = 14;
		}else if(getHomeName(p, 15).equalsIgnoreCase(name)) {
			result = 15;
		}else if(getHomeName(p, 16).equalsIgnoreCase(name)) {
			result = 16;
		}else if(getHomeName(p, 17).equalsIgnoreCase(name)) {
			result = 17;
		}else if(getHomeName(p, 18).equalsIgnoreCase(name)) {
			result = 18;
		}else if(getHomeName(p, 19).equalsIgnoreCase(name)) {
			result = 19;
		}else if(getHomeName(p, 20).equalsIgnoreCase(name)) {
			result = 20;
		}else if(getHomeName(p, 21).equalsIgnoreCase(name)) {
			result = 21;
		}else if(getHomeName(p, 22).equalsIgnoreCase(name)) {
			result = 22;
		}else if(getHomeName(p, 23).equalsIgnoreCase(name)) {
			result = 23;
		}else if(getHomeName(p, 24).equalsIgnoreCase(name)) {
			result = 24;
		}else if(getHomeName(p, 25).equalsIgnoreCase(name)) {
			result = 25;
		}else if(getHomeName(p, 26).equalsIgnoreCase(name)) {
			result = 26;
		}else if(getHomeName(p, 27).equalsIgnoreCase(name)) {
			result = 27;
		}else if(getHomeName(p, 28).equalsIgnoreCase(name)) {
			result = 28;
		}else if(getHomeName(p, 29).equalsIgnoreCase(name)) {
			result = 29;
		}else if(getHomeName(p, 30).equalsIgnoreCase(name)) {
			result = 30;
		}else if(getHomeName(p, 31).equalsIgnoreCase(name)) {
			result = 31;
		}else if(getHomeName(p, 32).equalsIgnoreCase(name)) {
			result = 32;
		}else if(getHomeName(p, 33).equalsIgnoreCase(name)) {
			result = 33;
		}else if(getHomeName(p, 34).equalsIgnoreCase(name)) {
			result = 34;
		}else if(getHomeName(p, 35).equalsIgnoreCase(name)) {
			result = 35;
		}else if(getHomeName(p, 36).equalsIgnoreCase(name)) {
			result = 36;
		}else if(getHomeName(p, 37).equalsIgnoreCase(name)) {
			result = 37;
		}else if(getHomeName(p, 38).equalsIgnoreCase(name)) {
			result = 38;
		}else if(getHomeName(p, 39).equalsIgnoreCase(name)) {
			result = 39;
		}else if(getHomeName(p, 40).equalsIgnoreCase(name)) {
			result = 40;
		}
		
		return result;
		
	}
	
	public static void setHome(Player p, int home, String value) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(home == 1) {
			cp.setHome1(value);
		}else if(home == 2) {
			cp.setHome2(value);
		}else if(home == 3) {
			cp.setHome3(value);
		}else if(home == 4) {
			cp.setHome4(value);
		}else if(home == 5) {
			cp.setHome5(value);
		}else if(home == 6) {
			cp.setHome6(value);
		}else if(home == 7) {
			cp.setHome7(value);
		}else if(home == 8) {
			cp.setHome8(value);
		}else if(home == 9) {
			cp.setHome9(value);
		}else if(home == 10) {
			cp.setHome10(value);
		}else if(home == 11) {
			cp.setHome11(value);
		}else if(home == 12) {
			cp.setHome12(value);
		}else if(home == 13) {
			cp.setHome13(value);
		}else if(home == 14) {
			cp.setHome14(value);
		}else if(home == 15) {
			cp.setHome15(value);
		}else if(home == 16) {
			cp.setHome16(value);
		}else if(home == 17) {
			cp.setHome17(value);
		}else if(home == 18) {
			cp.setHome18(value);
		}else if(home == 19) {
			cp.setHome19(value);
		}else if(home == 20) {
			cp.setHome20(value);
		}else if(home == 21) {
			cp.setHome21(value);
		}else if(home == 22) {
			cp.setHome22(value);
		}else if(home == 23) {
			cp.setHome23(value);
		}else if(home == 24) {
			cp.setHome24(value);
		}else if(home == 25) {
			cp.setHome25(value);
		}else if(home == 26) {
			cp.setHome26(value);
		}else if(home == 27) {
			cp.setHome27(value);
		}else if(home == 28) {
			cp.setHome28(value);
		}else if(home == 29) {
			cp.setHome29(value);
		}else if(home == 30) {
			cp.setHome30(value);
		}else if(home == 31) {
			cp.setHome31(value);
		}else if(home == 32) {
			cp.setHome32(value);
		}else if(home == 33) {
			cp.setHome33(value);
		}else if(home == 34) {
			cp.setHome34(value);
		}else if(home == 35) {
			cp.setHome35(value);
		}else if(home == 36) {
			cp.setHome36(value);
		}else if(home == 37) {
			cp.setHome37(value);
		}else if(home == 38) {
			cp.setHome38(value);
		}else if(home == 39) {
			cp.setHome39(value);
		}else if(home == 40) {
			cp.setHome40(value);
		}
		
	}
	
	public static String getHome(Player p, int home) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		String result = "none";
		
		if(home == 1) {
			result = cp.getHome1();
		}else if(home == 2) {
			result = cp.getHome2();
		}else if(home == 3) {
			result = cp.getHome3();
		}else if(home == 4) {
			result = cp.getHome4();
		}else if(home == 5) {
			result = cp.getHome5();
		}else if(home == 6) {
			result = cp.getHome6();
		}else if(home == 7) {
			result = cp.getHome7();
		}else if(home == 8) {
			result = cp.getHome8();
		}else if(home == 9) {
			result = cp.getHome9();
		}else if(home == 10) {
			result = cp.getHome10();
		}else if(home == 11) {
			result = cp.getHome11();
		}else if(home == 12) {
			result = cp.getHome12();
		}else if(home == 13) {
			result = cp.getHome13();
		}else if(home == 14) {
			result = cp.getHome14();
		}else if(home == 15) {
			result = cp.getHome15();
		}else if(home == 16) {
			result = cp.getHome16();
		}else if(home == 17) {
			result = cp.getHome17();
		}else if(home == 18) {
			result = cp.getHome18();
		}else if(home == 19) {
			result = cp.getHome19();
		}else if(home == 20) {
			result = cp.getHome20();
		}else if(home == 21) {
			result = cp.getHome21();
		}else if(home == 22) {
			result = cp.getHome22();
		}else if(home == 23) {
			result = cp.getHome23();
		}else if(home == 24) {
			result = cp.getHome24();
		}else if(home == 25) {
			result = cp.getHome25();
		}else if(home == 26) {
			result = cp.getHome26();
		}else if(home == 27) {
			result = cp.getHome27();
		}else if(home == 28) {
			result = cp.getHome28();
		}else if(home == 29) {
			result = cp.getHome29();
		}else if(home == 30) {
			result = cp.getHome30();
		}else if(home == 31) {
			result = cp.getHome31();
		}else if(home == 32) {
			result = cp.getHome32();
		}else if(home == 33) {
			result = cp.getHome33();
		}else if(home == 34) {
			result = cp.getHome34();
		}else if(home == 35) {
			result = cp.getHome35();
		}else if(home == 36) {
			result = cp.getHome36();
		}else if(home == 37) {
			result = cp.getHome37();
		}else if(home == 38) {
			result = cp.getHome38();
		}else if(home == 39) {
			result = cp.getHome39();
		}else if(home == 40) {
			result = cp.getHome40();
		}
		
		return result;
		
	}

}
