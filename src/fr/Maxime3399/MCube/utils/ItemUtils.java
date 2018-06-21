package fr.Maxime3399.MCube.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {
	
	public static ItemStack getClassItem(String clas) {
		
		ItemStack IS = null;
		
		if(clas.equalsIgnoreCase("§1Top 1")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 11);
		}else if(clas.equalsIgnoreCase("§9Top 2")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 9);
		}else if(clas.equalsIgnoreCase("§bTop 3")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 3);
		}else if(clas.equalsIgnoreCase("§2Légende")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 13);
		}else if(clas.equalsIgnoreCase("§aMaître")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 5);
		}else if(clas.equalsIgnoreCase("§6Platine")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 1);
		}else if(clas.equalsIgnoreCase("§eOr")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 4);
		}else if(clas.equalsIgnoreCase("§fArgent")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 0);
		}else if(clas.equalsIgnoreCase("§8Non-Classé")) {
			IS = new ItemStack(Material.WOOL, 1, (short) 7);
		}else {
			IS = new ItemStack(Material.WOOL, 1, (short) 8);
		}
		
		return IS;
		
	}

}
