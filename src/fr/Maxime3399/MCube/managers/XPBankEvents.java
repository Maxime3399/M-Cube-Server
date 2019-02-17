package fr.Maxime3399.MCube.managers;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import fr.Maxime3399.MCube.custom.CustomPlayer;

public class XPBankEvents implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		
		if(e.getLine(0).equalsIgnoreCase("[xpbank]") || e.getLine(0).equalsIgnoreCase("[expbank]")) {
			
			Player p = e.getPlayer();
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
			
		}
		
	}

}
