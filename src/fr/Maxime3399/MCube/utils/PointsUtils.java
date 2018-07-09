package fr.Maxime3399.MCube.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class PointsUtils {
	
	public static void placePlayer(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		int currentSeason = DataUtils.getCurrentSeason();
		boolean useLastSeason = true;
		
		if(currentSeason <= 1) {
			
			useLastSeason = false;
			
		}
		
		int bronze = 0;
		int silver = 0;
		int gold = 0;
		int platinum = 0;
		int master = 0;
		
		if(cp.getR_time_hours() >= 12) {
			
			master = master+1;
			
		}else if(cp.getR_time_hours() >= 9){
			
			platinum = platinum+1;
			
		}else if(cp.getR_time_hours() >= 6) {
			
			gold = gold+1;
			
		}else if(cp.getR_time_hours() >= 3) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_blocks_place() >= 700) {
			
			master = master+1;
			
		}else if(cp.getR_blocks_place() >= 500){
			
			platinum = platinum+1;
			
		}else if(cp.getR_blocks_place() >= 300) {
			
			gold = gold+1;
			
		}else if(cp.getR_blocks_place() >= 150) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_blocks_break() >= 1000) {
			
			master = master+1;
			
		}else if(cp.getR_blocks_break() >= 700){
			
			platinum = platinum+1;
			
		}else if(cp.getR_blocks_break() >= 500) {
			
			gold = gold+1;
			
		}else if(cp.getR_blocks_break() >= 300) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_chunks() >= 300) {
			
			master = master+1;
			
		}else if(cp.getR_chat() >= 200) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_chunks() >= 150) {
			
			gold = gold+1;
			
		}else if(cp.getR_chunks() >= 75) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_damages_take() <= 35) {
			
			master = master+1;
			
		}else if(cp.getR_damages_take() <= 55) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_damages_take() <= 100) {
			
			gold = gold+1;
			
		}else if(cp.getR_damages_take() <= 135) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_damages_give() >= 300) {
			
			master = master+1;
			
		}else if(cp.getR_damages_give() >= 200) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_damages_give() >= 120) {
			
			gold = gold+1;
			
		}else if(cp.getR_damages_give() >= 75) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_jump() >= 750) {
			
			master = master+1;
			
		}else if(cp.getR_jump() >= 625) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_jump() >= 500) {
			
			gold = gold+1;
			
		}else if(cp.getR_jump() >= 375) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_drop() >= 100) {
			
			master = master+1;
			
		}else if(cp.getR_drop() >= 75) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_drop() >= 50) {
			
			gold = gold+1;
			
		}else if(cp.getR_drop() >= 25) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_pickup() >= 1500) {
			
			master = master+1;
			
		}else if(cp.getR_pickup() >= 1250) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_pickup() >= 800) {
			
			gold = gold+1;
			
		}else if(cp.getR_pickup() >= 450) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_deaths() <= 0) {
			
			master = master+3;
			
		}else if(cp.getR_deaths() <= 3) {
			
			platinum = platinum+3;
			
		}else if(cp.getR_deaths() <= 6) {
			
			gold = gold+3;
			
		}else if(cp.getR_deaths() <= 10) {
			
			silver = silver+3;
			
		}else {
			
			bronze = bronze+3;
			
		}
		
		if(cp.getR_kill_animals() >= 100) {
			
			master = master+1;
			
		}else if(cp.getR_kill_animals() >= 80) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_kill_animals() >= 50) {
			
			gold = gold+1;
			
		}else if(cp.getR_kill_animals() >= 30) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_kill_monsters() >= 125) {
			
			master = master+1;
			
		}else if(cp.getR_kill_monsters() >= 90) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_kill_monsters() >= 60) {
			
			gold = gold+1;
			
		}else if(cp.getR_kill_monsters() >= 40) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_kill_players() >= 30) {
			
			master = master+1;
			
		}else if(cp.getR_kill_players() >= 20) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_kill_players() >= 10) {
			
			gold = gold+1;
			
		}else if(cp.getR_kill_players() >= 5) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_food() >= 700) {
			
			master = master+1;
			
		}else if(cp.getR_food() >= 575) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_food() >= 450) {
			
			gold = gold+1;
			
		}else if(cp.getR_food() >= 300) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_craft() >= 350) {
			
			master = master+1;
			
		}else if(cp.getR_craft() >= 250) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_craft() >= 150) {
			
			gold = gold+1;
			
		}else if(cp.getR_craft() >= 75) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_chat() >= 175) {
			
			master = master+1;
			
		}else if(cp.getR_chat() >= 125) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_chat() >= 75) {
			
			gold = gold+1;
			
		}else if(cp.getR_chat() >= 25) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_exp() >= 800) {
			
			master = master+1;
			
		}else if(cp.getR_exp() >= 600) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_exp() >= 400) {
			
			gold = gold+1;
			
		}else if(cp.getR_chat() >= 200) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_portal() >= 20) {
			
			master = master+1;
			
		}else if(cp.getR_portal() >= 15) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_portal() >= 10) {
			
			gold = gold+1;
			
		}else if(cp.getR_portal() >= 5) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_shear() >= 20) {
			
			master = master+1;
			
		}else if(cp.getR_shear() >= 17) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_shear() >= 13) {
			
			gold = gold+1;
			
		}else if(cp.getR_shear() >= 6) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_commands() >= 30) {
			
			master = master+1;
			
		}else if(cp.getR_commands() >= 22) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_commands() >= 15) {
			
			gold = gold+1;
			
		}else if(cp.getR_commands() >= 7) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_advancement() >= 10) {
			
			master = master+1;
			
		}else if(cp.getR_advancement() >= 7) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_advancement() >= 5) {
			
			gold = gold+1;
			
		}else if(cp.getR_advancement() >= 3) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_bed() >= 20) {
			
			master = master+1;
			
		}else if(cp.getR_bed() >= 15) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_bed() >= 10) {
			
			gold = gold+1;
			
		}else if(cp.getR_bed() >= 5) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_armorstand() >= 15) {
			
			master = master+1;
			
		}else if(cp.getR_armorstand() >= 10) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_armorstand() >= 6) {
			
			gold = gold+1;
			
		}else if(cp.getR_armorstand() >= 2) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(cp.getR_enchant() >= 25) {
			
			master = master+1;
			
		}else if(cp.getR_enchant() >= 18) {
			
			platinum = platinum+1;
			
		}else if(cp.getR_enchant() >= 10) {
			
			gold = gold+1;
			
		}else if(cp.getR_enchant() >= 4) {
			
			silver = silver+1;
			
		}else {
			
			bronze = bronze+1;
			
		}
		
		if(useLastSeason) {
			
			int sc = cp.getPointsBySeason(DataUtils.getCurrentSeason()-1);
			
			if(sc >= 500) {
				
				master = master+8;
				
			}else if(sc >= 400) {
				
				master = master+5;
				
			}else if(sc >= 300) {
				
				platinum = platinum+5;
				
			}else if(sc >= 200) {
				
				gold = gold+5;
				
			}else if(sc >= 100) {
				
				silver = silver+5;
				
			}else {
				
				bronze = bronze+5;
				
			}
			
		}
		
		int result = 50;
		
		if(silver > bronze) {
			result = 150;
			if(gold > silver) {
				result = 250;
				if(platinum > gold) {
					result = 350;
					if(master > platinum) {
						result = 450;
					}
				}
			}
		}
		
		cp.setPoints(result);
		cp.setPointsBySeason(DataUtils.getCurrentSeason(), result);
		cp.setPlacement_end("none");
		cp.save();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			DisplayUtils.setDisplay(pls);
		}
		
		p.sendMessage(" \n     §b§l§k||§r  §a§lPlacement terminé !§r §dTu es "+DisplayUtils.getClass(p, currentSeason)+"§r §e!   §b§l§k||§r\n ");
		p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_DEATH, 100, 1);
		
	}

}
