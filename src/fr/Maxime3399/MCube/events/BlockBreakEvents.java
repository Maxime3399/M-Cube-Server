package fr.Maxime3399.MCube.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakEvents implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if(e.getBlock() == null || e.getBlock().getType() == Material.AIR) {
			
			return;
			
		}else if(e.getBlock().getType() == Material.SPAWNER) {
			
			Player p = e.getPlayer();
			
			if(p.hasPermission("mcube.spawner.take")) {
				
				CreatureSpawner cs = (CreatureSpawner) e.getBlock().getState();
				
				ItemStack ISa = new ItemStack(Material.STONE);
				
				if(cs.getSpawnedType() == EntityType.BAT) {
					ISa.setType(Material.BAT_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.BLAZE) {
					ISa.setType(Material.BLAZE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.CAVE_SPIDER) {
					ISa.setType(Material.CAVE_SPIDER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.CHICKEN) {
					ISa.setType(Material.CHICKEN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.COD) {
					ISa.setType(Material.COD_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.COW) {
					ISa.setType(Material.COW_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.CREEPER) {
					ISa.setType(Material.CREEPER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.DOLPHIN) {
					ISa.setType(Material.DOLPHIN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.DONKEY) {
					ISa.setType(Material.DONKEY_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.DROWNED) {
					ISa.setType(Material.DROWNED_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ELDER_GUARDIAN) {
					ISa.setType(Material.ELDER_GUARDIAN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ENDERMAN) {
					ISa.setType(Material.ENDERMAN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ENDERMITE) {
					ISa.setType(Material.ENDERMITE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.EVOKER) {
					ISa.setType(Material.EVOKER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.GHAST) {
					ISa.setType(Material.GHAST_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.GUARDIAN) {
					ISa.setType(Material.GUARDIAN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.HORSE) {
					ISa.setType(Material.HORSE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.HUSK) {
					ISa.setType(Material.HUSK_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.LLAMA) {
					ISa.setType(Material.LLAMA_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.MAGMA_CUBE) {
					ISa.setType(Material.MAGMA_CUBE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.MUSHROOM_COW) {
					ISa.setType(Material.MOOSHROOM_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.MULE) {
					ISa.setType(Material.MULE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.OCELOT) {
					ISa.setType(Material.OCELOT_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.PARROT) {
					ISa.setType(Material.PARROT_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.PHANTOM) {
					ISa.setType(Material.PHANTOM_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.PIG) {
					ISa.setType(Material.PIG_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.POLAR_BEAR) {
					ISa.setType(Material.POLAR_BEAR_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.PUFFERFISH) {
					ISa.setType(Material.PUFFERFISH_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.RABBIT) {
					ISa.setType(Material.RABBIT_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SALMON) {
					ISa.setType(Material.SALMON_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SHEEP) {
					ISa.setType(Material.SHEEP_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SHULKER) {
					ISa.setType(Material.SHULKER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SILVERFISH) {
					ISa.setType(Material.SILVERFISH_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SKELETON_HORSE) {
					ISa.setType(Material.SKELETON_HORSE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SKELETON) {
					ISa.setType(Material.SKELETON_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SLIME) {
					ISa.setType(Material.SLIME_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SPIDER) {
					ISa.setType(Material.SPIDER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.SQUID) {
					ISa.setType(Material.SQUID_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.STRAY) {
					ISa.setType(Material.STRAY_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.TROPICAL_FISH) {
					ISa.setType(Material.TROPICAL_FISH_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.TURTLE) {
					ISa.setType(Material.TURTLE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.VEX) {
					ISa.setType(Material.VEX_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.VILLAGER) {
					ISa.setType(Material.VILLAGER_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.VINDICATOR) {
					ISa.setType(Material.VINDICATOR_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.WITCH) {
					ISa.setType(Material.WITCH_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.WITHER_SKELETON) {
					ISa.setType(Material.WITHER_SKELETON_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.WOLF) {
					ISa.setType(Material.WOLF_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ZOMBIE_HORSE) {
					ISa.setType(Material.ZOMBIE_HORSE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.PIG_ZOMBIE) {
					ISa.setType(Material.ZOMBIE_PIGMAN_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ZOMBIE) {
					ISa.setType(Material.ZOMBIE_SPAWN_EGG);
				}else if(cs.getSpawnedType() == EntityType.ZOMBIE_VILLAGER) {
					ISa.setType(Material.ZOMBIE_VILLAGER_SPAWN_EGG);
				}
				
				e.setExpToDrop(0);
				e.setDropItems(false);
				
				ItemStack IS = new ItemStack(Material.LEGACY_MOB_SPAWNER);
				p.getInventory().addItem(IS);
				p.getInventory().addItem(ISa);
				p.playSound(p.getLocation(), Sound.BLOCK_GRAVEL_BREAK, 100, 2);
				
			}else {
				
				e.setExpToDrop(1000);
				
			}
			
		}else if(e.getBlock().getType() == Material.LEGACY_MOB_SPAWNER) {
			
			Player p = e.getPlayer();
			e.setExpToDrop(0);
			
			if(p.hasPermission("mcube.spawner.take")) {
				
				e.setDropItems(false);
				
				ItemStack IS = new ItemStack(Material.LEGACY_MOB_SPAWNER);
				p.getInventory().addItem(IS);
				p.playSound(p.getLocation(), Sound.BLOCK_GRAVEL_BREAK, 100, 2);
				
			}
		}
		
	}

}
