package fr.Maxime3399.MCube.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.ChatUtils;

public class XPBankEvents implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		
		boolean color = false;
		for(String li : e.getLines()) {
			
			if(li.contains("&")) {
				
				color = true;
				
			}
			
		}
		
		if(color == true) {
			
			Player p = e.getPlayer();
			
			if(p.hasPermission("mcube.sign")) {
				
				e.setLine(0, e.getLine(0).replaceAll("&", "§"));
				e.setLine(1, e.getLine(1).replaceAll("&", "§"));
				e.setLine(2, e.getLine(2).replaceAll("&", "§"));
				e.setLine(3, e.getLine(3).replaceAll("&", "§"));
				
			}
			
		}
		
		if(e.getLine(0).equalsIgnoreCase("[xpbank]") || e.getLine(0).equalsIgnoreCase("[expbank]")) {
			
			Player p = e.getPlayer();
			
			if(p.hasPermission("mcube.expbank.create")) {
				
				CustomPlayer cp = PlayersManager.getCustomPlayer(p);
				
				if(cp.getCredits() >= 100) {
					
					e.setLine(0, "§a§l[§r§aXP Bank§l]");
					e.setLine(1, p.getName());
					e.setLine(2, "0");
					e.setLine(3, "§9§l=====");
					
					cp.setCredits(cp.getCredits()-100);
					
				}else {
					
					e.setCancelled(true);
					p.sendMessage("§cTu n'as pas assez de crédits, il t'en faut 100 !");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
					
				}
				
			}else {
				
				e.setCancelled(true);
				p.sendMessage("§cTu dois au minimum être VIP !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}else if(e.getLine(0).contains("XP Bank")) {
			
			Player p = e.getPlayer();
			p.sendMessage("§cVous ne pouvez pas mettre le texte \"XP Bank\" dans la première ligne de votre pancarte !");
			p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
			e.setCancelled(true);
			
			
		}
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		if(e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) {
			
			return;
			
		}else if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.WALL_SIGN) {
			
			Sign s = (Sign) e.getClickedBlock().getState();
			Player p = e.getPlayer();
			
			if(s.getLine(0).contains("XP Bank")) {
				
				if(s.getLine(1).equalsIgnoreCase(p.getName())) {
					
					int xp = 0;
					try {
						xp = Integer.parseInt(s.getLine(2));
					}catch (Exception ex) {
						ex.printStackTrace();
					}
					
					if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
						
						if(xp == 0) {
							
							p.sendMessage("§cVous n'avez pas d'XP à récupérer !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							xp = xp-5;
							p.setLevel(p.getLevel()+5);
							s.setLine(2, ""+xp);
							s.update();
							p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
							
						}
						
					}else if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						
						if(p.getLevel() < 5) {
							
							p.sendMessage("§cVous devez posséder 5 niveaux au minumum !");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							
						}else {
							
							xp = xp+5;
							int max = 0;
							if(p.hasPermission("mcube.expbank.300")) {
								max = 300;
							}else if(p.hasPermission("mcube.expbank.200")) {
								max = 200;
							}else if(p.hasPermission("mcube.expbank.100")) {
								max = 100;
							}else if(p.hasPermission("mcube.expbank.50")) {
								max = 50;
							}
							
							if(xp <= max) {
								
								p.setLevel(p.getLevel()-5);
								s.setLine(2, ""+xp);
								s.update();
								p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
								
							}else {
								
								p.sendMessage("§cVous ne pouvez pas stocker plus d'XP dans cette banque d'XP !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
								
							}
							
						}
						
					}
					
				}else {
					
					p.sendMessage("§cCe n'est pas votre banque d'XP !");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if(e.getBlock() == null || e.getBlock().getType() == Material.AIR) {
			
			return;
			
		}else if(e.getBlock().getType() == Material.SIGN || e.getBlock().getType() == Material.WALL_SIGN) {
			
			Sign s = (Sign) e.getBlock().getState();
			
			if(s.getLine(0).contains("XP Bank")) {
				
				e.setCancelled(true);
				Player p = e.getPlayer();
				
				if(s.getLine(1).equalsIgnoreCase(p.getName())) {
					
					CustomPlayer cp = PlayersManager.getCustomPlayer(p);
					
					p.sendMessage("§bÊtes vous sûr de vouloir détruire votre banque d'XP ( vous ne serez pas remboursé ) ?");
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_HIT, 100, 2);
					
					ChatUtils.sendMessage(p, "[{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"CONFIRMER\",\"color\":\"green\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/ccmd confirm\"}},"
							+ "{\"text\":\"]\",\"color\":\"yellow\"},{\"text\":\"  \"},{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"ANNULER\",\"color\":\"red\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\","
							+ "\"value\":\"/ccmd cancel\"}},{\"text\":\"]\",\"color\":\"yellow\"}]");
					cp.setConfirm("testBREAKXPBANK");
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if(!p.isOnline()) {
								this.cancel();
							}else {
								if(cp.getConfirm() == null || !cp.getConfirm().contains("BREAKXPBANK")) {
									this.cancel();
								}else {
									if(cp.getConfirm().equalsIgnoreCase("confirmBREAKXPBANK")) {
										
										this.cancel();
										cp.setConfirm(null);
										
										int xp = 0;
										try {
											xp = Integer.parseInt(s.getLine(2));
										}catch (Exception ex) {
											ex.printStackTrace();
										}
										
										p.setLevel(p.getLevel()+xp);
										
										p.sendMessage("§eBanque d'XP détruite !");
										p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 100, 2);
										
										s.getBlock().breakNaturally();
										
									}else if(cp.getConfirm().equalsIgnoreCase("cancelBREAKXPBANK")) {
										this.cancel();
										cp.setConfirm(null);
										p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
									}
								}
							}
						}
					}.runTaskTimer(MainClass.getInstance(), 1, 1);
					
				}else {
					
					p.sendMessage("§cCe n'est pas votre banque d'XP !");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
					
				}
				
			}
			
		}
		
	}

}
