package fr.Maxime3399.MCube.utils;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;

public class ChatUtils {
	
	public static void sendTitle(Player p, String title, int in, int time, int out) {
		
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\":\""+title+"\"}");
		
		PacketPlayOutTitle Ptitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle Ptime = new PacketPlayOutTitle(in, time, out);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(Ptitle);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(Ptime);
		
	}

}
