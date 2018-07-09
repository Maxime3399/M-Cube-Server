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
	private String placement_end;
	private int season_1_points;
	//here ==============================================
	private int r_time_seconds;
	private int r_time_minutes;
	private int r_time_hours;
	private int r_blocks_place;
	private int r_blocks_break;
	private int r_chunks;
	private int r_damages_take;
	private int r_damages_give;
	private int r_jump;
	private int r_drop;
	private int r_pickup;
	private int r_deaths;
	private int r_kill_animals;
	private int r_kill_monsters;
	private int r_kill_players;
	private int r_food;
	private int r_craft;
	private int r_chat;
	private int r_exp;
	private int r_portal;
	private int r_shear;
	private int r_commands;
	private int r_advancement;
	private int r_bed;
	private int r_armorstand;
	private int r_enchant;
	
	public CustomPlayer(Player p) {
		
		this.setUuid(p.getUniqueId());
		this.setName(MySQLUtils.getString("players", "uuid", uuid.toString(), "name"));
		this.setRank(MySQLUtils.getString("players", "uuid", uuid.toString(), "rank"));
		this.setStaff(MySQLUtils.getString("players", "uuid", uuid.toString(), "staff"));
		this.setPoints(MySQLUtils.getInt("players", "uuid", uuid.toString(), "points"));
		this.setStep(MySQLUtils.getInt("players", "uuid", uuid.toString(), "step"));
		this.setTokens(MySQLUtils.getInt("players", "uuid", uuid.toString(), "tokens"));
		this.setCredits(MySQLUtils.getInt("players", "uuid", uuid.toString(), "credits"));
		this.setPlus_color(MySQLUtils.getString("players", "uuid", uuid.toString(), "plus_color"));
		this.setLegendary_steps(Boolean.parseBoolean(MySQLUtils.getString("players", "uuid", uuid.toString(), "legendary_steps")));
		this.setPlacement_end(MySQLUtils.getString("players", "uuid", uuid.toString(), "placement_end"));
		this.setSeason_1_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_1_points"));
		//here ==============================================
		this.setR_time_seconds(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_time_seconds"));
		this.setR_time_minutes(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_time_minutes"));
		this.setR_time_hours(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_time_hours"));
		this.setR_blocks_place(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_blocks_place"));
		this.setR_blocks_break(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_blocks_break"));
		this.setR_chunks(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_chunks"));
		this.setR_damages_take(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_damages_take"));
		this.setR_damages_give(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_damages_give"));
		this.setR_jump(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_jump"));
		this.setR_drop(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_drop"));
		this.setR_pickup(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_pickup"));
		this.setR_deaths(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_deaths"));
		this.setR_kill_animals(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_kill_animals"));
		this.setR_kill_monsters(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_kill_monsters"));
		this.setR_kill_players(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_kill_players"));
		this.setR_food(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_food"));
		this.setR_craft(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_craft"));
		this.setR_chat(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_chat"));
		this.setR_exp(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_exp"));
		this.setR_portal(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_portal"));
		this.setR_shear(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_shear"));
		this.setR_commands(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_commands"));
		this.setR_advancement(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_advancement"));
		this.setR_bed(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_bed"));
		this.setR_armorstand(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_armorstand"));
		this.setR_enchant(MySQLUtils.getInt("players", "uuid", uuid.toString(), "r_enchant"));
		
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
		MySQLUtils.setString("players", "uuid", uuid.toString(), "placement_end", placement_end);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_1_points", season_1_points);
		//here ===============================================
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_time_seconds", r_time_seconds);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_time_minutes", r_time_minutes);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_time_hours", r_time_hours);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_blocks_place", r_blocks_place);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_blocks_break", r_blocks_break);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_chunks", r_chunks);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_damages_take", r_damages_take);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_damages_give", r_damages_give);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_jump", r_jump);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_drop", r_drop);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_pickup", r_pickup);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_deaths", r_deaths);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_kill_animals", r_kill_animals);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_kill_monsters", r_kill_monsters);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_kill_players", r_kill_players);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_food", r_food);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_craft", r_craft);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_chat", r_chat);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_exp", r_exp);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_portal", r_portal);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_shear", r_shear);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_commands", r_commands);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_advancement", r_advancement);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_bed", r_bed);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_armorstand", r_armorstand);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "r_enchant", r_enchant);
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

	public int getR_time_seconds() {
		return r_time_seconds;
	}

	public void setR_time_seconds(int r_time_seconds) {
		this.r_time_seconds = r_time_seconds;
	}

	public int getR_time_minutes() {
		return r_time_minutes;
	}

	public void setR_time_minutes(int r_time_minutes) {
		this.r_time_minutes = r_time_minutes;
	}

	public int getR_time_hours() {
		return r_time_hours;
	}

	public void setR_time_hours(int r_time_hours) {
		this.r_time_hours = r_time_hours;
	}

	public int getR_blocks_place() {
		return r_blocks_place;
	}

	public void setR_blocks_place(int r_blocks_place) {
		this.r_blocks_place = r_blocks_place;
	}

	public int getR_blocks_break() {
		return r_blocks_break;
	}

	public void setR_blocks_break(int r_blocks_break) {
		this.r_blocks_break = r_blocks_break;
	}

	public int getR_chunks() {
		return r_chunks;
	}

	public void setR_chunks(int r_chunks) {
		this.r_chunks = r_chunks;
	}

	public int getR_damages_take() {
		return r_damages_take;
	}

	public void setR_damages_take(int r_damages_take) {
		this.r_damages_take = r_damages_take;
	}

	public int getR_damages_give() {
		return r_damages_give;
	}

	public void setR_damages_give(int r_damages_give) {
		this.r_damages_give = r_damages_give;
	}

	public int getR_jump() {
		return r_jump;
	}

	public void setR_jump(int r_jump) {
		this.r_jump = r_jump;
	}

	public int getR_drop() {
		return r_drop;
	}

	public void setR_drop(int r_drop) {
		this.r_drop = r_drop;
	}

	public int getR_pickup() {
		return r_pickup;
	}

	public void setR_pickup(int r_pickup) {
		this.r_pickup = r_pickup;
	}

	public int getR_deaths() {
		return r_deaths;
	}

	public void setR_deaths(int r_deaths) {
		this.r_deaths = r_deaths;
	}

	public int getR_kill_animals() {
		return r_kill_animals;
	}

	public void setR_kill_animals(int r_kill_animals) {
		this.r_kill_animals = r_kill_animals;
	}

	public int getR_kill_monsters() {
		return r_kill_monsters;
	}

	public void setR_kill_monsters(int r_kill_monsters) {
		this.r_kill_monsters = r_kill_monsters;
	}

	public int getR_kill_players() {
		return r_kill_players;
	}

	public void setR_kill_players(int r_kill_players) {
		this.r_kill_players = r_kill_players;
	}

	public int getR_food() {
		return r_food;
	}

	public void setR_food(int r_food) {
		this.r_food = r_food;
	}

	public int getR_craft() {
		return r_craft;
	}

	public void setR_craft(int r_craft) {
		this.r_craft = r_craft;
	}

	public int getR_chat() {
		return r_chat;
	}

	public void setR_chat(int r_chat) {
		this.r_chat = r_chat;
	}

	public int getR_exp() {
		return r_exp;
	}

	public void setR_exp(int r_exp) {
		this.r_exp = r_exp;
	}

	public int getR_portal() {
		return r_portal;
	}

	public void setR_portal(int r_portal) {
		this.r_portal = r_portal;
	}

	public int getR_shear() {
		return r_shear;
	}

	public void setR_shear(int r_shear) {
		this.r_shear = r_shear;
	}

	public int getR_commands() {
		return r_commands;
	}

	public void setR_commands(int r_commands) {
		this.r_commands = r_commands;
	}

	public int getR_advancement() {
		return r_advancement;
	}

	public void setR_advancement(int r_advancement) {
		this.r_advancement = r_advancement;
	}

	public int getR_bed() {
		return r_bed;
	}

	public void setR_bed(int r_bed) {
		this.r_bed = r_bed;
	}

	public int getR_armorstand() {
		return r_armorstand;
	}

	public void setR_armorstand(int r_armorstand) {
		this.r_armorstand = r_armorstand;
	}

	public int getR_enchant() {
		return r_enchant;
	}

	public void setR_enchant(int r_enchant) {
		this.r_enchant = r_enchant;
	}

}
