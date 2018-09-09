package fr.Maxime3399.MCube.cosmetics;

import java.util.ArrayList;
import java.util.Random;

public class CosLister {
	
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

}
