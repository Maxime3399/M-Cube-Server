package fr.Maxime3399.MCube.custom;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.DataUtils;
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
	private int placement_points;
	private String placement_end;
	private int season_1_points;
	
	public CustomPlayer(Player p) {
		
		this.uuid = p.getUniqueId();
		this.name = MySQLUtils.getString("players", "uuid", uuid.toString(), "name");
		this.rank = MySQLUtils.getString("players", "uuid", uuid.toString(), "rank");
		this.staff = MySQLUtils.getString("players", "uuid", uuid.toString(), "staff");
		this.points = MySQLUtils.getInt("players", "uuid", uuid.toString(), "points");
		this.step = MySQLUtils.getInt("players", "uuid", uuid.toString(), "step");
		this.tokens = MySQLUtils.getInt("players", "uuid", uuid.toString(), "tokens");
		this.credits = MySQLUtils.getInt("players", "uuid", uuid.toString(), "credits");
		this.plus_color = MySQLUtils.getString("players", "uuid", uuid.toString(), "plus_color");
		this.setLegendary_steps(Boolean.parseBoolean(MySQLUtils.getString("players", "uuid", uuid.toString(), "legendary_steps")));
		this.setPlacement_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "placement_points"));
		this.setPlacement_end(MySQLUtils.getString("players", "uuid", uuid.toString(), "placement_end"));
		this.setSeason_1_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_1_points"));
		
	}
	
	public void save() {
		
		MySQLUtils.setString("players", "uuid", uuid.toString(), "name", name);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "rank", rank);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "staff", staff);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "points", points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "tokens", tokens);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "credits", credits);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "plus_color", plus_color);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "legendary_steps", String.valueOf(legendary_steps));
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "placement_points", placement_points);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "placement_end", placement_end);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_1_points", season_1_points);
		
	}
	
	public void refreshPoints() {
		
		if(DataUtils.getCurrentSeason() == 1) {
			season_1_points = points;
		}
		
	}
	
	public int getPointClassement(int season) {
		
		int result = 0;
		save();
		
		ArrayList<String> list = MySQLUtils.getSortValues("players", "season_"+season+"_points", "ASC");
		
		if(list.size() != 0) {
			
			for(String pla : list) {
				
				if(MySQLUtils.getInt("players", "uuid", pla, "points") == -1) {
					
					list.remove(pla);
					
				}
				
			}
			
			for(String ss : list) {
				
				if(ss.equalsIgnoreCase(uuid.toString())) {
					
					result = list.indexOf(ss)+1;
					
				}
				
			}
			
		}
		
		return result;
		
	}
	
	public int getPointsBySeason(int season) {
		
		int result = 0;
		refreshPoints();
		
		if(season == 1) {
			result = season_1_points;
		}
		
		return result;
		
	}
	
	public void setPointsBySeason(int season, int points) {
		
		if(season == 1) {
			season_1_points = points;
		}
		
		refreshPoints();
		
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
		refreshPoints();
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

	public int getPlacement_points() {
		return placement_points;
	}

	public void setPlacement_points(int placement_points) {
		this.placement_points = placement_points;
	}

	public String getPlacement_end() {
		return placement_end;
	}

	public void setPlacement_end(String placement_end) {
		this.placement_end = placement_end;
	}

	public int getSeason_1_points() {
		return season_1_points;
	}

	public void setSeason_1_points(int season_1_points) {
		this.season_1_points = season_1_points;
	}

}
