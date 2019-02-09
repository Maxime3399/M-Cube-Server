package fr.Maxime3399.MCube.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.Maxime3399.MCube.MainClass;

public class BlockPlaceEvents implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if(e.getBlock().getType() == null || e.getBlock().getType() == Material.AIR) {
			
			return;
			
		}else if(e.getBlock().getType() == Material.SPAWNER) {
			
			Player p = e.getPlayer();
			
			if(p.hasPermission("mcube.spawner.place")) {
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						
						BlockState state = e.getBlock().getState();
						CreatureSpawner cs = (CreatureSpawner) state;
						cs.setSpawnedType(EntityType.EXPERIENCE_ORB);
						state.update();
						
					}
				}, 5);
				
			}else {
				
				e.setCancelled(true);
				p.sendMessage("§cTu n'as pas la permission de poser des spawners !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
	}

}
