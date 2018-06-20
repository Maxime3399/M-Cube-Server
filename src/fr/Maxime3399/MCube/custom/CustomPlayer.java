package fr.Maxime3399.MCube.custom;

import java.util.UUID;

import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.MySQLUtils;

public class CustomPlayer {
	
	private UUID uuid;
	private String name;
	private String rank;
	private String staff;
	private int points;
	private int step;
	private int tokens;
	private int credits;
	
	public CustomPlayer(Player p) {
		
		this.uuid = p.getUniqueId();
		this.name = MySQLUtils.getString("players", "uuid", uuid.toString(), "name");
		this.rank = MySQLUtils.getString("players", "uuid", uuid.toString(), "rank");
		this.staff = MySQLUtils.getString("players", "uuid", uuid.toString(), "staff");
		this.points = MySQLUtils.getInt("players", "uuid", uuid.toString(), "points");
		this.tokens = MySQLUtils.getInt("players", "uuid", uuid.toString(), "tokens");
		this.credits = MySQLUtils.getInt("players", "uuid", uuid.toString(), "credits");
		
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

}
