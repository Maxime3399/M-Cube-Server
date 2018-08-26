package fr.Maxime3399.MCube.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.ChatUtils;

public class StopCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("mcube.command.stop")) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer(p);
			
			ChatUtils.sendMessage(p, "[{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"CONFIRMER\",\"color\":\"green\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/ccmd confirm\"}},"
					+ "{\"text\":\"]\",\"color\":\"yellow\"},{\"text\":\"  \"},{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"ANNULER\",\"color\":\"red\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\","
					+ "\"value\":\"/ccmd cancel\"}},{\"text\":\"]\",\"color\":\"yellow\"}]");
			cp.setConfirm("testSTOP");
			new BukkitRunnable() {
				@Override
				public void run() {
					if(!p.isOnline()) {
						this.cancel();
					}else {
						if(cp.getConfirm() == null || !cp.getConfirm().contains("STOP")) {
							this.cancel();
							cp.setConfirm(null);
						}else {
							if(cp.getConfirm().equalsIgnoreCase("confirmSTOP")) {
								
								this.cancel();
								cp.setConfirm(null);
								
								Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 5 secondes §4§l§k|||");
								for(Player pls : Bukkit.getOnlinePlayers()) {
									pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
								}
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 4 secondes §4§l§k|||");
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
										}
									}
								}, 20);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 3 secondes §4§l§k|||");
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 2 secondes §4§l§k|||");
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
										}
									}
								}, 60);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 1 secondes §4§l§k|||");
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
										}
									}
								}, 80);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur §4§l§k|||");
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.playSound(pls.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 1);
										}
									}
								}, 100);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										for(Player pls : Bukkit.getOnlinePlayers()) {
											pls.kickPlayer("§cArrêt du serveur");
										}
									}
								}, 110);
								Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
									@Override
									public void run() {
										Bukkit.getServer().shutdown();
									}
								}, 115);
								
							}else if(cp.getConfirm().equalsIgnoreCase("cancelSTOP")){
								this.cancel();
								cp.setConfirm(null);
								p.sendMessage("§cCommande annulée !");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
							}
						}
					}
				}
			}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
			
		}else {
			
			p.sendMessage("§cTu n'as pas la permission !");
			p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
			
		}
		
	}
	
	public static void commandConsole(CommandSender sender, Command cmd, String label, String[] args) {
		
		Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 5 secondes §4§l§k|||");
		for(Player pls : Bukkit.getOnlinePlayers()) {
			pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 4 secondes §4§l§k|||");
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
				}
			}
		}, 20);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 3 secondes §4§l§k|||");
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
				}
			}
		}, 40);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 2 secondes §4§l§k|||");
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
				}
			}
		}, 60);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur dans 1 secondes §4§l§k|||");
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.playSound(pls.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 1);
				}
			}
		}, 80);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("  §4§l§k|||§r §cArrêt du serveur §4§l§k|||");
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.playSound(pls.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 1);
				}
			}
		}, 100);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(Player pls : Bukkit.getOnlinePlayers()) {
					pls.kickPlayer("§cArrêt du serveur");
				}
			}
		}, 110);
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.getServer().shutdown();
			}
		}, 115);
		
	}

}
