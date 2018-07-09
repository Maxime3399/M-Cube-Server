package fr.Maxime3399.MCube.schedulers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.PointsUtils;

public class GeneralSheduler {
	
	public static void start1() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				for(Player pls : Bukkit.getOnlinePlayers()) {
					
					CustomPlayer cps = PlayersManager.getCustomPlayer(pls);
					
					if(!cps.getPlacement_end().equalsIgnoreCase("none")) {
						
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
						Date dO = null;
						try {
							dO = sdf.parse(cps.getPlacement_end());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Date dT = new Date();
						
						if(dO.getTime() < dT.getTime()) {
							
							PointsUtils.placePlayer(pls);
							
						}
						
					}
					
					cps.setR_time_seconds(cps.getR_time_seconds()+1);
					if(cps.getR_time_seconds() == 60) {
						cps.setR_time_seconds(0);
						cps.setR_time_minutes(cps.getR_time_minutes()+1);
					}
					if(cps.getR_time_minutes() == 60) {
						cps.setR_time_minutes(0);
						cps.setR_time_hours(cps.getR_time_hours()+1);
					}
					//#TEST#
					
				}
				
			}
			
		}, 20, 20);
		
	}

}
