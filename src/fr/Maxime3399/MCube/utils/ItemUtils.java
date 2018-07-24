package fr.Maxime3399.MCube.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {
	
	public static ItemStack getClassItem(String clas) {
		
		ItemStack IS = null;
		
		if(clas.equalsIgnoreCase("§1Top 1")) {
			IS = new ItemStack(Material.BLUE_WOOL);
		}else if(clas.equalsIgnoreCase("§9Top 2")) {
			IS = new ItemStack(Material.CYAN_WOOL);
		}else if(clas.equalsIgnoreCase("§bTop 3")) {
			IS = new ItemStack(Material.LIGHT_BLUE_WOOL);
		}else if(clas.equalsIgnoreCase("§2Légende")) {
			IS = new ItemStack(Material.GREEN_WOOL);
		}else if(clas.equalsIgnoreCase("§aMaître")) {
			IS = new ItemStack(Material.LIME_WOOL);
		}else if(clas.equalsIgnoreCase("§6Platine")) {
			IS = new ItemStack(Material.ORANGE_WOOL);
		}else if(clas.equalsIgnoreCase("§eOr")) {
			IS = new ItemStack(Material.YELLOW_WOOL);
		}else if(clas.equalsIgnoreCase("§fArgent")) {
			IS = new ItemStack(Material.WHITE_WOOL);
		}else if(clas.equalsIgnoreCase("§8Non-Classé")) {
			IS = new ItemStack(Material.GRAY_WOOL);
		}else {
			IS = new ItemStack(Material.LIGHT_GRAY_WOOL);
		}
		
		return IS;
		
	}

}
