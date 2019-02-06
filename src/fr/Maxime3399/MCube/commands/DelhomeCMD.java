package fr.Maxime3399.MCube.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;
import fr.Maxime3399.MCube.utils.ChatUtils;
import fr.Maxime3399.MCube.utils.HomeUtils;

public class DelhomeCMD implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("mcube.command.delhome")) {
				
				if(args.length == 1) {
					
					String name = args[0];
					
					if(HomeUtils.isHome(p, name)) {
						
						CustomPlayer cp = PlayersManager.getCustomPlayer(p);
						
						ChatUtils.sendMessage(p, "[{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"CONFIRMER\",\"color\":\"green\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/ccmd confirm\"}},"
								+ "{\"text\":\"]\",\"color\":\"yellow\"},{\"text\":\"  \"},{\"text\":\"[\",\"color\":\"yellow\"},{\"text\":\"ANNULER\",\"color\":\"red\",\"bold\":\"true\",\"clickEvent\":{\"action\":\"run_command\","
								+ "\"value\":\"/ccmd cancel\"}},{\"text\":\"]\",\"color\":\"yellow\"}]");
						cp.setConfirm("testDELHOME");
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(!p.isOnline()) {
									this.cancel();
								}else {
									if(cp.getConfirm() == null || !cp.getConfirm().contains("DELHOME")) {
										this.cancel();
									}else {
										if(cp.getConfirm().equalsIgnoreCase("confirmDELHOME")) {
											
											this.cancel();
											cp.setConfirm(null);
											
											HomeUtils.setHome(p, HomeUtils.getHomeByName(p, name), "none");
											p.sendMessage("§eLe home à été supprimé !");
											p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 2);
											
										}else if(cp.getConfirm().equalsIgnoreCase("cancelDELHOME")) {
											this.cancel();
											cp.setConfirm(null);
											p.sendMessage("§cCommande annulée !");
											p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
										}
									}
								}
							}
						}.runTaskTimer(MainClass.getInstance(), 1, 1);
						
					}else {
						
						p.sendMessage("§cCe home n'héxiste pas !");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
						
					}
					
				}else {
					
					p.sendMessage("§eAide : /selhome [home]");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 2);
					
				}
				
			}else {
				
				p.sendMessage("§cTu n'as pas la permission !");
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
				
			}
			
		}
		
		return true;
		
	}

}
