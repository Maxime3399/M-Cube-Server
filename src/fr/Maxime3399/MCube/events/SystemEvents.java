package fr.Maxime3399.MCube.events;

import java.util.HashMap;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.schedulers.GeneralSheduler;
import fr.Maxime3399.MCube.utils.PointsUtils;

@SuppressWarnings("deprecation")
public class SystemEvents implements Listener {
	
	HashMap<Player, Location> place = new HashMap<>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		boolean event = false;
		if(!place.containsKey(e.getPlayer())) {
			place.put(e.getPlayer(), e.getBlock().getLocation());
			event = true;
		}else {
			if(place.get(e.getPlayer()) != e.getBlock().getLocation()) {
				place.put(e.getPlayer(), e.getBlock().getLocation());
				event = true;
			}
		}
		
		if(event) {
			
			GeneralSheduler.action(e.getPlayer());
			CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
			cp.setR_blocks_place(cp.getR_blocks_place()+1);
			PointsUtils.addPoints(e.getPlayer());
			
		}
		
	}
	
	HashMap<Player, Location> brea = new HashMap<>();
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		boolean event = false;
		if(!brea.containsKey(e.getPlayer())) {
			brea.put(e.getPlayer(), e.getBlock().getLocation());
			event = true;
		}else {
			if(brea.get(e.getPlayer()) != e.getBlock().getLocation()) {
				brea.put(e.getPlayer(), e.getBlock().getLocation());
				event = true;
			}
		}
		
		if(event) {
			
			GeneralSheduler.action(e.getPlayer());
			CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
			cp.setR_blocks_break(cp.getR_blocks_break()+1);
			PointsUtils.addPoints(e.getPlayer());
			
		}
		
	}
	
	HashMap<Player, Chunk> chunks = new HashMap<>();
	
	HashMap<Player, Location> bl = new HashMap<>();
	
	@EventHandler
	public void onMoove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		boolean moove = false;
		
		if(!bl.containsKey(p)) {
			bl.put(p, p.getLocation());
			moove = true;
		}else {
			if(p.getLocation().distance(bl.get(p)) > 1.5) {
				moove = true;
				bl.put(p, p.getLocation());
			}
		}
		
		if(moove) {
			
			GeneralSheduler.action(e.getPlayer());
			
			if(chunks.containsKey(p)) {
				
				if(p.getLocation().getChunk() != chunks.get(p)) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer(p);
					cp.setR_chunks(cp.getR_chunks()+1);
					chunks.put(p, p.getLocation().getChunk());
					PointsUtils.addPoints(e.getPlayer());
					
				}
				
			}else {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				cp.setR_chunks(cp.getR_chunks()+1);
				chunks.put(p, p.getLocation().getChunk());
				PointsUtils.addPoints(e.getPlayer());
				
			}
			
			final double STILL = -0.0784000015258789;
			
			if(!p.isFlying() && p.getVelocity().getY() > STILL) {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				cp.setR_jump(cp.getR_jump()+1);
				PointsUtils.addPoints(e.getPlayer());
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity().getType() == EntityType.PLAYER) {
			
			if(e.getCause() != DamageCause.ENTITY_ATTACK && e.getCause() != DamageCause.ENTITY_SWEEP_ATTACK) {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer((Player) e.getEntity());
				cp.setR_damages_take((int) (cp.getR_damages_take()+e.getDamage()));
				PointsUtils.addPoints((Player) e.getEntity());
				GeneralSheduler.action((Player) e.getEntity());
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onDamageBE(EntityDamageByEntityEvent e) {
		
		if(e.getEntity().getType() == EntityType.PLAYER) {
			
			if(e.getDamager().getType() != EntityType.PLAYER) {
				
				if(e.getCause() == DamageCause.ENTITY_ATTACK || e.getCause() == DamageCause.ENTITY_SWEEP_ATTACK) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer((Player) e.getEntity());
					cp.setR_damages_take((int) (cp.getR_damages_take()+e.getDamage()));
					PointsUtils.addPoints((Player) e.getEntity());
					GeneralSheduler.action((Player) e.getEntity());
					
				}
				
			}
			
		}else {
			
			if(e.getDamager().getType() == EntityType.PLAYER) {
				
				if(e.getEntity().getType() != EntityType.PLAYER) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer((Player) e.getDamager());
					cp.setR_damages_give((int) (cp.getR_damages_give()+e.getDamage()));
					PointsUtils.addPoints((Player) e.getDamager());
					GeneralSheduler.action((Player) e.getDamager());
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_drop(cp.getR_drop()+1);
		PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_pickup(cp.getR_pickup()+1);
		PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getEntity());
		cp.setR_deaths(cp.getR_deaths()+1);
		PointsUtils.addPoints(e.getEntity());
		GeneralSheduler.action(e.getEntity());
		
	}
	
	@EventHandler
	public void onEDeath(EntityDeathEvent e) {
		
		if(e.getEntity().getKiller() == null) {
			
			return;
			
		}else if(e.getEntity().getKiller().getType() == EntityType.PLAYER) {
			
			if(e.getEntity().getType() == EntityType.PLAYER) {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer(e.getEntity().getKiller());
				cp.setR_kill_players(cp.getR_kill_players()+1);
				PointsUtils.addPoints(e.getEntity().getKiller());
				
			}else {
				
				if(e.getEntity() instanceof Animals) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer(e.getEntity().getKiller());
					cp.setR_kill_animals(cp.getR_kill_animals()+1);
					PointsUtils.addPoints(e.getEntity().getKiller());
					
				}else {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer(e.getEntity().getKiller());
					cp.setR_kill_monsters(cp.getR_kill_monsters()+1);
					PointsUtils.addPoints(e.getEntity().getKiller());
					
				}
				
			}
			
		}
		
	}
	
	private static HashMap<Player, Integer> food = new HashMap<>();
	
	public static void registerFood(Player p) {
		
		food.put(p, p.getFoodLevel());
		
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		
		Player p = (Player) e.getEntity();
		
		if(food.get(p) < e.getFoodLevel()) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer(p);
			cp.setR_food(cp.getR_food()+e.getFoodLevel()-food.get(p));
			PointsUtils.addPoints((Player) e.getEntity());
			GeneralSheduler.action((Player) e.getEntity());
			
		}
		
		food.put(p, e.getFoodLevel());
		
	}
	
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer((Player) e.getWhoClicked());
		cp.setR_craft(cp.getR_craft()+e.getCurrentItem().getAmount());
		PointsUtils.addPoints((Player) e.getWhoClicked());
		GeneralSheduler.action((Player) e.getWhoClicked());
		
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_chat(cp.getR_chat()+1);
		PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onExp(PlayerExpChangeEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(e.getAmount() > 0) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer(p);
			cp.setR_exp(cp.getR_exp()+e.getAmount());
			PointsUtils.addPoints(e.getPlayer());
			
		}
		
	}
	
	@EventHandler
	public void onPortal(PlayerTeleportEvent e) {
		
		if(e.getCause() == TeleportCause.NETHER_PORTAL || e.getCause() == TeleportCause.END_PORTAL) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
			cp.setR_portal(cp.getR_portal()+1);
			PointsUtils.addPoints(e.getPlayer());
			GeneralSheduler.action(e.getPlayer());
			
		}
		
	}
	
	@EventHandler
	public void onShear(PlayerShearEntityEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_shear(cp.getR_shear()+1);
					PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onAdvanc(PlayerAdvancementDoneEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_advancement(cp.getR_advancement());
					PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onBed(PlayerBedEnterEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_bed(cp.getR_bed()+1);
		PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onAS(PlayerArmorStandManipulateEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getPlayer());
		cp.setR_armorstand(cp.getR_armorstand()+1);
		PointsUtils.addPoints(e.getPlayer());
		GeneralSheduler.action(e.getPlayer());
		
	}
	
	@EventHandler
	public void onEnchant(EnchantItemEvent e) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(e.getEnchanter());
		cp.setR_enchant(cp.getR_enchant()+1);
		PointsUtils.addPoints(e.getEnchanter());
		GeneralSheduler.action(e.getEnchanter());
		
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		
		GeneralSheduler.action((Player) e.getWhoClicked());
		
	}

}
