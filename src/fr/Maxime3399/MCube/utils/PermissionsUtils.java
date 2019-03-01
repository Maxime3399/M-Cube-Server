package fr.Maxime3399.MCube.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;

import fr.Maxime3399.MCube.MainClass;
import fr.Maxime3399.MCube.custom.CustomPlayer;
import fr.Maxime3399.MCube.managers.PlayersManager;

public class PermissionsUtils {
	
	public static void calculPermissions(Player p) {
		
		CustomPlayer cp = PlayersManager.getCustomPlayer(p);
		ArrayList<String> perms = new ArrayList<>();
		
		if(cp.getStaff().equalsIgnoreCase("créateur") || cp.getOther_ranks().equalsIgnoreCase("créateur")) {
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
		}
		if(cp.getRank().equalsIgnoreCase("ultravipplus") || cp.getOther_ranks().equalsIgnoreCase("ultravipplus")) {
			perms.add("mcube.menu.+");
			perms.add("mcube.chest.5");
			perms.add("mcube.chest.4");
			perms.add("mcube.spawner.take");
			perms.add("mcube.spawner.place");
			perms.add("mcube.command.fly");
			perms.add("mcube.fly");
			perms.add("mcube.sign");
			perms.add("mcube.join");
			perms.add("mcube.expbank.create");
			perms.add("mcube.expbank.300");
			perms.add("mcube.afk");
		}else if(cp.getRank().equalsIgnoreCase("ultravip") || cp.getOther_ranks().equalsIgnoreCase("ultravip")) {
			perms.add("mcube.chest.5");
			perms.add("mcube.chest.4");
			perms.add("mcube.spawner.take");
			perms.add("mcube.spawner.place");
			perms.add("mcube.sign");
			perms.add("mcube.join");
			perms.add("mcube.expbank.create");
			perms.add("mcube.expbank.200");
			perms.add("mcube.afk");
		}else if(cp.getRank().equalsIgnoreCase("vipplus") || cp.getOther_ranks().equalsIgnoreCase("vipplus")) {
			perms.add("mcube.chest.4");
			perms.add("mcube.sign");
			perms.add("mcube.join");
			perms.add("mcube.spawner.place");
			perms.add("mcube.expbank.create");
			perms.add("mcube.expbank.100");
			perms.add("mcube.afk");
		}else if(cp.getRank().equalsIgnoreCase("vip") || cp.getOther_ranks().equalsIgnoreCase("vip")) {
			perms.add("mcube.sign");
			perms.add("mcube.join");
			perms.add("mcube.spawner.place");
			perms.add("mcube.expbank.create");
			perms.add("mcube.expbank.50");
			perms.add("mcube.afk");
		}else if(cp.getRank().equalsIgnoreCase("minivip") || cp.getOther_ranks().equalsIgnoreCase("minivip")) {
			perms.add("mcube.sign");
			perms.add("mcube.join");
			perms.add("mcube.afk");
		}
		
		perms.add("mcube.chest.1");
		perms.add("mcube.chest.2");
		perms.add("mcube.chest.3");
		perms.add("mcube.command.home");
		perms.add("mcube.command.sethome");
		perms.add("mcube.command.delhome");
		
		for(PermissionAttachmentInfo pa : p.getEffectivePermissions()) {
			if(pa.getAttachment() != null) {
				p.removeAttachment(pa.getAttachment());
			}
		}
		PermissionAttachment att = p.addAttachment(MainClass.getInstance());
		for(String s : perms) {
			att.setPermission(s, true);
		}
		
	}

}
