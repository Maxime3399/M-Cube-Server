package fr.Maxime3399.MCube.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import fr.Maxime3399.MCube.utils.DataUtils;

public class ServerPingEvents implements Listener {
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		
		String line1 = DataUtils.getMotd(1);
		String line2 = "";
		
		if(DataUtils.getMaintenance()) {
			
			line2 = "§b§lServeur en cours de maintenance !";
			
		}else {
			
			line2 = DataUtils.getMotd(2);
			
		}
		
		e.setMotd(line1+"§r\n"+line2);
		
	}

}
