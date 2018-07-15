package fr.Maxime3399.MCube.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class PointsUtils {
	
	public static void addPoints(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		
		if(cp.getPlacement_end().equalsIgnoreCase("none")) {
			
			if(cp.getPoints() >= 500) {
				
				if(cp.getR_time_hours() >= 6) {
					cp.setR_time_hours(cp.getR_time_hours()-6);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 800) {
					cp.setR_blocks_place(cp.getR_blocks_place()-800);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 1000) {
					cp.setR_blocks_break(cp.getR_blocks_break()-1000);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 300) {
					cp.setR_chunks(cp.getR_chunks()-300);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 600) {
					cp.setR_damages_give(cp.getR_damages_give()-600);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 40) {
					cp.setR_damages_take(cp.getR_damages_take()-40);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 800) {
					cp.setR_jump(cp.getR_jump()-800);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 300) {
					cp.setR_drop(cp.getR_drop()-300);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 1000) {
					cp.setR_pickup(cp.getR_pickup()-1000);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -6);
				}
				if(cp.getR_kill_animals() >= 300) {
					cp.setR_kill_animals(cp.getR_kill_animals()-300);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 300) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-300);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 30) {
					cp.setR_kill_players(cp.getR_kill_players()-30);
					adx(p, 1);
				}
				if(cp.getR_food() >= 300) {
					cp.setR_food(cp.getR_food()-300);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 600) {
					cp.setR_craft(cp.getR_craft()-600);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 180) {
					cp.setR_chat(cp.getR_chat()-180);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 600) {
					cp.setR_exp(cp.getR_exp()-600);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 60) {
					cp.setR_portal(cp.getR_portal()-60);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 300) {
					cp.setR_shear(cp.getR_shear()-300);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 120) {
					cp.setR_commands(cp.getR_commands()-120);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 12) {
					cp.setR_advancement(cp.getR_advancement()-12);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 60) {
					cp.setR_bed(cp.getR_bed()-60);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 180) {
					cp.setR_armorstand(cp.getR_armorstand()-180);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 70) {
					cp.setR_enchant(cp.getR_enchant()-70);
					adx(p, 1);
				}
				
			}else if(cp.getPoints() >= 400) {
				
				if(cp.getR_time_hours() >= 5) {
					cp.setR_time_hours(cp.getR_time_hours()-5);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 600) {
					cp.setR_blocks_place(cp.getR_blocks_place()-600);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 800) {
					cp.setR_blocks_break(cp.getR_blocks_break()-800);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 250) {
					cp.setR_chunks(cp.getR_chunks()-250);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 500) {
					cp.setR_damages_give(cp.getR_damages_give()-500);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 60) {
					cp.setR_damages_take(cp.getR_damages_take()-60);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 700) {
					cp.setR_jump(cp.getR_jump()-700);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 250) {
					cp.setR_drop(cp.getR_drop()-250);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 900) {
					cp.setR_pickup(cp.getR_pickup()-900);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -5);
				}
				if(cp.getR_kill_animals() >= 250) {
					cp.setR_kill_animals(cp.getR_kill_animals()-250);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 250) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-250);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 25) {
					cp.setR_kill_players(cp.getR_kill_players()-25);
					adx(p, 1);
				}
				if(cp.getR_food() >= 250) {
					cp.setR_food(cp.getR_food()-250);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 500) {
					cp.setR_craft(cp.getR_craft()-500);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 150) {
					cp.setR_chat(cp.getR_chat()-150);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 500) {
					cp.setR_exp(cp.getR_exp()-500);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 50) {
					cp.setR_portal(cp.getR_portal()-50);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 250) {
					cp.setR_shear(cp.getR_shear()-250);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 100) {
					cp.setR_commands(cp.getR_commands()-100);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 10) {
					cp.setR_advancement(cp.getR_advancement()-10);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 50) {
					cp.setR_bed(cp.getR_bed()-50);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 150) {
					cp.setR_armorstand(cp.getR_armorstand()-150);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 60) {
					cp.setR_enchant(cp.getR_enchant()-60);
					adx(p, 1);
				}
				
			}else if(cp.getPoints() >= 300) {
				
				if(cp.getR_time_hours() >= 4) {
					cp.setR_time_hours(cp.getR_time_hours()-4);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 500) {
					cp.setR_blocks_place(cp.getR_blocks_place()-500);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 600) {
					cp.setR_blocks_break(cp.getR_blocks_break()-600);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 200) {
					cp.setR_chunks(cp.getR_chunks()-200);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 400) {
					cp.setR_damages_give(cp.getR_damages_give()-400);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 80) {
					cp.setR_damages_take(cp.getR_damages_take()-80);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 600) {
					cp.setR_jump(cp.getR_jump()-600);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 200) {
					cp.setR_drop(cp.getR_drop()-200);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 800) {
					cp.setR_pickup(cp.getR_pickup()-800);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -4);
				}
				if(cp.getR_kill_animals() >= 200) {
					cp.setR_kill_animals(cp.getR_kill_animals()-200);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 200) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-200);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 20) {
					cp.setR_kill_players(cp.getR_kill_players()-20);
					adx(p, 1);
				}
				if(cp.getR_food() >= 200) {
					cp.setR_food(cp.getR_food()-200);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 400) {
					cp.setR_craft(cp.getR_craft()-400);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 120) {
					cp.setR_chat(cp.getR_chat()-120);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 400) {
					cp.setR_exp(cp.getR_exp()-400);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 40) {
					cp.setR_portal(cp.getR_portal()-40);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 200) {
					cp.setR_shear(cp.getR_shear()-200);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 80) {
					cp.setR_commands(cp.getR_commands()-80);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 8) {
					cp.setR_advancement(cp.getR_advancement()-8);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 40) {
					cp.setR_bed(cp.getR_bed()-40);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 120) {
					cp.setR_armorstand(cp.getR_armorstand()-120);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 50) {
					cp.setR_enchant(cp.getR_enchant()-50);
					adx(p, 1);
				}
				
			}else if(cp.getPoints() >= 200) {
				
				if(cp.getR_time_hours() >= 3) {
					cp.setR_time_hours(cp.getR_time_hours()-3);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 400) {
					cp.setR_blocks_place(cp.getR_blocks_place()-400);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 500) {
					cp.setR_blocks_break(cp.getR_blocks_break()-500);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 150) {
					cp.setR_chunks(cp.getR_chunks()-150);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 300) {
					cp.setR_damages_give(cp.getR_damages_give()-300);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 90) {
					cp.setR_damages_take(cp.getR_damages_take()-90);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 500) {
					cp.setR_jump(cp.getR_jump()-500);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 150) {
					cp.setR_drop(cp.getR_drop()-150);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 700) {
					cp.setR_pickup(cp.getR_pickup()-700);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -3);
				}
				if(cp.getR_kill_animals() >= 150) {
					cp.setR_kill_animals(cp.getR_kill_animals()-150);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 150) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-150);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 15) {
					cp.setR_kill_players(cp.getR_kill_players()-15);
					adx(p, 1);
				}
				if(cp.getR_food() >= 150) {
					cp.setR_food(cp.getR_food()-150);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 300) {
					cp.setR_craft(cp.getR_craft()-300);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 90) {
					cp.setR_chat(cp.getR_chat()-90);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 300) {
					cp.setR_exp(cp.getR_exp()-300);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 30) {
					cp.setR_portal(cp.getR_portal()-30);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 150) {
					cp.setR_shear(cp.getR_shear()-150);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 60) {
					cp.setR_commands(cp.getR_commands()-60);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 6) {
					cp.setR_advancement(cp.getR_advancement()-6);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 30) {
					cp.setR_bed(cp.getR_bed()-30);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 90) {
					cp.setR_armorstand(cp.getR_armorstand()-90);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 40) {
					cp.setR_enchant(cp.getR_enchant()-40);
					adx(p, 1);
				}
				
			}else if(cp.getPoints() >= 100) {
				
				if(cp.getR_time_hours() >= 2) {
					cp.setR_time_hours(cp.getR_time_hours()-2);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 300) {
					cp.setR_blocks_place(cp.getR_blocks_place()-300);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 400) {
					cp.setR_blocks_break(cp.getR_blocks_break()-400);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 100) {
					cp.setR_chunks(cp.getR_chunks()-100);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 200) {
					cp.setR_damages_give(cp.getR_damages_give()-200);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 100) {
					cp.setR_damages_take(cp.getR_damages_take()-100);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 400) {
					cp.setR_jump(cp.getR_jump()-400);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 100) {
					cp.setR_drop(cp.getR_drop()-100);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 600) {
					cp.setR_pickup(cp.getR_pickup()-600);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -2);
				}
				if(cp.getR_kill_animals() >= 100) {
					cp.setR_kill_animals(cp.getR_kill_animals()-100);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 100) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-100);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 10) {
					cp.setR_kill_players(cp.getR_kill_players()-10);
					adx(p, 1);
				}
				if(cp.getR_food() >= 100) {
					cp.setR_food(cp.getR_food()-100);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 200) {
					cp.setR_craft(cp.getR_craft()-200);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 60) {
					cp.setR_chat(cp.getR_chat()-60);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 200) {
					cp.setR_exp(cp.getR_exp()-200);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 20) {
					cp.setR_portal(cp.getR_portal()-20);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 100) {
					cp.setR_shear(cp.getR_shear()-100);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 40) {
					cp.setR_commands(cp.getR_commands()-40);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 4) {
					cp.setR_advancement(cp.getR_advancement()-4);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 20) {
					cp.setR_bed(cp.getR_bed()-20);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 60) {
					cp.setR_armorstand(cp.getR_armorstand()-60);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 30) {
					cp.setR_enchant(cp.getR_enchant()-30);
					adx(p, 1);
				}
				
			}else {
				
				if(cp.getR_time_hours() >= 1) {
					cp.setR_time_hours(cp.getR_time_hours()-1);
					adx(p, 1);
				}
				if(cp.getR_blocks_place() >= 200) {
					cp.setR_blocks_place(cp.getR_blocks_place()-200);
					adx(p, 1);
				}
				if(cp.getR_blocks_break() >= 300) {
					cp.setR_blocks_break(cp.getR_blocks_break()-300);
					adx(p, 1);
				}
				if(cp.getR_chunks() >= 50) {
					cp.setR_chunks(cp.getR_chunks()-50);
					adx(p, 1);
				}
				if(cp.getR_damages_give() >= 100) {
					cp.setR_damages_give(cp.getR_damages_give()-100);
					adx(p, 1);
				}
				if(cp.getR_damages_take() >= 120) {
					cp.setR_damages_take(cp.getR_damages_take()-120);
					adx(p, -1);
				}
				if(cp.getR_jump() >= 300) {
					cp.setR_jump(cp.getR_jump()-300);
					adx(p, 1);
				}
				if(cp.getR_drop() >= 50) {
					cp.setR_drop(cp.getR_drop()-50);
					adx(p, 1);
				}
				if(cp.getR_pickup() >= 500) {
					cp.setR_pickup(cp.getR_pickup()-500);
					adx(p, 1);
				}
				if(cp.getR_deaths() >= 1) {
					cp.setR_deaths(cp.getR_deaths()-1);
					adx(p, -1);
				}
				if(cp.getR_kill_animals() >= 50) {
					cp.setR_kill_animals(cp.getR_kill_animals()-50);
					adx(p, 1);
				}
				if(cp.getR_kill_monsters() >= 50) {
					cp.setR_kill_monsters(cp.getR_kill_monsters()-50);
					adx(p, 1);
				}
				if(cp.getR_kill_players() >= 5) {
					cp.setR_kill_players(cp.getR_kill_players()-5);
					adx(p, 1);
				}
				if(cp.getR_food() >= 50) {
					cp.setR_food(cp.getR_food()-50);
					adx(p, 1);
				}
				if(cp.getR_craft() >= 100) {
					cp.setR_craft(cp.getR_craft()-100);
					adx(p, 1);
				}
				if(cp.getR_chat() >= 30) {
					cp.setR_chat(cp.getR_chat()-30);
					adx(p, 1);
				}
				if(cp.getR_exp() >= 100) {
					cp.setR_exp(cp.getR_exp()-100);
					adx(p, 1);
				}
				if(cp.getR_portal() >= 10) {
					cp.setR_portal(cp.getR_portal()-10);
					adx(p, 1);
				}
				if(cp.getR_shear() >= 50) {
					cp.setR_shear(cp.getR_shear()-50);
					adx(p, 1);
				}
				if(cp.getR_commands() >= 20) {
					cp.setR_commands(cp.getR_commands()-20);
					adx(p, 1);
				}
				if(cp.getR_advancement() >= 2) {
					cp.setR_advancement(cp.getR_advancement()-2);
					adx(p, 1);
				}
				if(cp.getR_bed() >= 10) {
					cp.setR_bed(cp.getR_bed()-10);
					adx(p, 1);
				}
				if(cp.getR_armorstand() >= 30) {
					cp.setR_armorstand(cp.getR_armorstand()-30);
					adx(p, 1);
				}
				if(cp.getR_enchant() >= 20) {
					cp.setR_enchant(cp.getR_enchant()-20);
					adx(p, 1);
				}
				
			}
			
		}
		
	}
	
	private static void adx(Player p, int points) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		cp.setPoints(cp.getPoints()+points);

		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			DisplayUtils.setDisplay(pls);
			
		}
		
	}
	
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
		cp.setPointsBySeason(currentSeason, result);
		cp.setPlacement_end("none");
		
		cp.setR_time_seconds(0);
		cp.setR_time_minutes(0);
		cp.setR_time_hours(0);
		cp.setR_blocks_place(0);
		cp.setR_blocks_break(0);
		cp.setR_chunks(0);
		cp.setR_damages_take(0);
		cp.setR_damages_give(0);
		cp.setR_jump(0);
		cp.setR_drop(0);
		cp.setR_pickup(0);
		cp.setR_deaths(0);
		cp.setR_kill_animals(0);
		cp.setR_kill_monsters(0);
		cp.setR_kill_players(0);
		cp.setR_food(0);
		cp.setR_craft(0);
		cp.setR_chat(0);
		cp.setR_exp(0);
		cp.setR_portal(0);
		cp.setR_shear(0);
		cp.setR_commands(0);
		cp.setR_advancement(0);
		cp.setR_bed(0);
		cp.setR_armorstand(0);
		cp.setR_enchant(0);
		
		cp.save();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			DisplayUtils.setDisplay(pls);
		}
		
		p.sendMessage(" \n     §b§l§k||§r  §a§lPlacement terminé !§r §dTu es "+DisplayUtils.getClass(p, currentSeason)+"§r §e!   §b§l§k||§r\n ");
		p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_DEATH, 100, 2);
		
	}

}
