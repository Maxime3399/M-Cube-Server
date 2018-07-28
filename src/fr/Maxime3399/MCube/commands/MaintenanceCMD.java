package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.ChatUtils;
import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class MaintenanceCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("mcube.command.maintenance")) {
			
			CustomPlayer cp = PlayersManager.getCustomPlayer(p);
			
			ChatUtils.sendMessage(p, "[{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"CONFIRMER\",\"color\":\"green\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/ccmd confirm\"}},"
					+ "{\"text\":\"]\",\"color\":\"yellow\"},{\"text\":\"  \"},{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"ANNULER\",\"color\":\"red\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\","
					+ "\"value\":\"/ccmd cancel\"}},{\"text\":\"]\",\"color\":\"yellow\"}]");
			cp.setConfirm("testMAINTENANCE");
			new BukkitRunnable() {
				@Override
				public void run() {
					if(!p.isOnline()) {
						this.cancel();
					}else {
						if(cp.getConfirm() == null || !cp.getConfirm().contains("MAINTENANCE")) {
							this.cancel();
							cp.setConfirm(null);
						}else {
							if(cp.getConfirm().equalsIgnoreCase("confirmMAINTENANCE")) {
								
								this.cancel();
								cp.setConfirm(null);
								
								if(DataUtils.getMaintenance()) {
									
									MySQLUtils.setString("infos", "type", "maintenance", "info_string", "false");
									p.sendMessage("§eLe serveur n'est plus en maintenance !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 1);
									
								}else {
									
									MySQLUtils.setString("infos", "type", "maintenance", "info_string", "true");
									p.sendMessage("§eLe serveur est en maintenance !");
									p.playSound(p.getLocation(), Sound.BLOCK_PISTON_CONTRACT, 100, 1);
									
								}
								
							}else if(cp.getConfirm().equalsIgnoreCase("cancelMAINTENANCE")){
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
		
		if(DataUtils.getMaintenance()) {
			
			MySQLUtils.setString("infos", "type", "maintenance", "info_string", "false");
			sender.sendMessage("§eLe serveur n'est plus en maintenance !");
			
		}else {
			
			MySQLUtils.setString("infos", "type", "maintenance", "info_string", "true");
			sender.sendMessage("§eLe serveur est en maintenance !");
			
		}
		
	}

}
