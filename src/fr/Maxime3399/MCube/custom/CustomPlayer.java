package fr.Maxime3399.MCube.custom;

import java.util.ArrayList;
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
	private String plus_color;
	private boolean legendary_steps;
	
	public CustomPlayer(Player p) {
		
		this.uuid = p.getUniqueId();
		this.name = MySQLUtils.getString("players", "uuid", uuid.toString(), "name");
		this.rank = MySQLUtils.getString("players", "uuid", uuid.toString(), "rank");
		this.staff = MySQLUtils.getString("players", "uuid", uuid.toString(), "staff");
		this.points = MySQLUtils.getInt("players", "uuid", uuid.toString(), "points");
		this.tokens = MySQLUtils.getInt("players", "uuid", uuid.toString(), "tokens");
		this.credits = MySQLUtils.getInt("players", "uuid", uuid.toString(), "credits");
		this.plus_color = MySQLUtils.getString("players", "uuid", uuid.toString(), "plus_color");
		this.setLegendary_steps(Boolean.parseBoolean(MySQLUtils.getString("players", "uuid", uuid.toString(), "legendary_steps")));
		
	}
	
	public void save() {
		
		MySQLUtils.setString("name", "players", "uuid", uuid.toString(), name);
		MySQLUtils.setString("rank", "players", "uuid", uuid.toString(), rank);
		MySQLUtils.setString("staff", "players", "uuid", uuid.toString(), staff);
		MySQLUtils.setInt("points", "players", "uuid", uuid.toString(), points);
		MySQLUtils.setInt("tokens", "players", "uuid", uuid.toString(), tokens);
		MySQLUtils.setInt("credits", "players", "uuid", uuid.toString(), credits);
		MySQLUtils.setString("plus_color", "players", "uuid", uuid.toString(), plus_color);
		MySQLUtils.setString("legendary_steps", "players", "uuid", uuid.toString(), String.valueOf(legendary_steps));
		
	}
	
	public int getPointClassement() {
		
		int result = 0;
		save();
		
		ArrayList<String> list = MySQLUtils.getSortValues("players", "points", "ASC");
		
		if(list.size() > 0) {
			
			for(String ss : list) {
				
				if(ss == uuid.toString()) {
					
					result = list.indexOf(ss)+1;
					
				}
				
			}
			
		}
		
		return result;
		
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

	public String getPlus_color() {
		return plus_color;
	}

	public void setPlus_color(String plus_color) {
		this.plus_color = plus_color;
	}

	public boolean isLegendary_steps() {
		return legendary_steps;
	}

	public void setLegendary_steps(boolean legendary_steps) {
		this.legendary_steps = legendary_steps;
	}

}
