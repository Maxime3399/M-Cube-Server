package fr.Maxime3399.MCube.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class PermissionsUtils {
	
	public static void calculPermissions(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		ArrayList<String> perms = new ArrayList<>();
		
		if(cp.getStaff().equalsIgnoreCase("cr�ateur") || cp.getOther_ranks().equalsIgnoreCase("cr�ateur")) {
			perms.add("mcube.command.gift");
			perms.add("mcube.command.maintenance");
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.stop");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("admin") || cp.getOther_ranks().equalsIgnoreCase("admin")) {
			perms.add("mcube.command.gift");
			perms.add("mcube.command.maintenance");
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.stop");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("respdev") || cp.getOther_ranks().equalsIgnoreCase("respdev")) {
			perms.add("mcube.command.maintenance");
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("dev") || cp.getOther_ranks().equalsIgnoreCase("dev")) {
			perms.add("mcube.command.maintenance");
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("respmod") || cp.getOther_ranks().equalsIgnoreCase("respmod")) {
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("mod") || cp.getOther_ranks().equalsIgnoreCase("mod")) {
			perms.add("mcube.command.playercount");
			perms.add("mcube.command.lastconnexion");
			perms.add("mcube.command.playertime");
		}else if(cp.getStaff().equalsIgnoreCase("help") || cp.getOther_ranks().equalsIgnoreCase("help")) {
			perms.add("mcube.command.playercount");
		}else if(cp.getStaff().equalsIgnoreCase("part") || cp.getOther_ranks().equalsIgnoreCase("part")) {
			perms.add("mcube.command.playercount");
		}else if(cp.getStaff().equalsIgnoreCase("yt") || cp.getOther_ranks().equalsIgnoreCase("yt")) {
			perms.add("mcube.command.playercount");
		}else if(cp.getStaff().equalsIgnoreCase("stream") || cp.getOther_ranks().equalsIgnoreCase("stream")) {
			perms.add("mcube.command.playercount");
		}else if(cp.getStaff().equalsIgnoreCase("ultravipplus") || cp.getOther_ranks().equalsIgnoreCase("ultravipplus")) {
			perms.add("mcube.menu.+");
			perms.add("mcube.chest.5");
			perms.add("mcube.chest.4");
		}else if(cp.getStaff().equalsIgnoreCase("ultravip") || cp.getOther_ranks().equalsIgnoreCase("ultravip")) {
			perms.add("mcube.chest.5");
			perms.add("mcube.chest.4");
		}else if(cp.getStaff().equalsIgnoreCase("vipplus") || cp.getOther_ranks().equalsIgnoreCase("vipplus")) {
			perms.add("mcube.chest.4");
		}else if(cp.getStaff().equalsIgnoreCase("vip") || cp.getOther_ranks().equalsIgnoreCase("vip")) {
			
		}else if(cp.getStaff().equalsIgnoreCase("minivip") || cp.getOther_ranks().equalsIgnoreCase("minivip")) {
			
		}
		
		perms.add("mcube.chest.1");
		perms.add("mcube.chest.2");
		perms.add("mcube.chest.3");
		perms.add("mcube.command.home");
		perms.add("mcube.command.sethome");
		perms.add("mcube.command.delhome");
		
		p.removeAttachment((PermissionAttachment) p.getEffectivePermissions());
		PermissionAttachment att = p.addAttachment(MainClass.getInstance());
		for(String s : perms) {
			att.setPermission(s, true);
		}
		
	}

}