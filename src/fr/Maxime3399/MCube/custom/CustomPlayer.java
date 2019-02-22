package fr.Maxime3399.MCube.custom;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.Maxime3399.MCube.utils.DataUtils;
import fr.Maxime3399.MCube.utils.MySQLUtils;

public class CustomPlayer {
	
	private UUID uuid;
	private String name;
	private int data;
	private String rank;
	private String staff;
	private String other_ranks;
	private int points;
	private int step;
	private int tokens;
	private int credits;
	private int crystals;
	private boolean legendary_steps;
	private String placement_end;
	private String gifts;
	private String chests;
	private String last_connection;
	private int connection_streak;
	private boolean fly;
	private String cos_active;
	private String cos_plus_color;
	private int season_1_points;
	private int season_2_points;
	private int season_3_points;
	private int season_4_points;
	private int season_5_points;
	private int s_time_seconds;
	private int s_time_minutes;
	private int s_time_hours;
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
	
	private String home1;
	private String home2;
	private String home3;
	private String home4;
	private String home5;
	private String home6;
	private String home7;
	private String home8;
	private String home9;
	private String home10;
	private String home11;
	private String home12;
	private String home13;
	private String home14;
	private String home15;
	private String home16;
	private String home17;
	private String home18;
	private String home19;
	private String home20;
	private String home21;
	private String home22;
	private String home23;
	private String home24;
	private String home25;
	private String home26;
	private String home27;
	private String home28;
	private String home29;
	private String home30;
	private String home31;
	private String home32;
	private String home33;
	private String home34;
	private String home35;
	private String home36;
	private String home37;
	private String home38;
	private String home39;
	private String home40;
	
	private boolean afk;
	private String confirm;
	
	public CustomPlayer(Player p) {
		
		this.setUuid(p.getUniqueId());
		this.setName(MySQLUtils.getString("players", "uuid", uuid.toString(), "name"));
		this.setData(MySQLUtils.getInt("players", "uuid", uuid.toString(), "data"));
		this.setRank(MySQLUtils.getString("players", "uuid", uuid.toString(), "rank"));
		this.setStaff(MySQLUtils.getString("players", "uuid", uuid.toString(), "staff"));
		this.setOther_ranks(MySQLUtils.getString("players", "uuid", uuid.toString(), "other_ranks"));
		this.setPoints(MySQLUtils.getInt("players", "uuid", uuid.toString(), "points"));
		this.setStep(MySQLUtils.getInt("players", "uuid", uuid.toString(), "step"));
		this.setTokens(MySQLUtils.getInt("players", "uuid", uuid.toString(), "tokens"));
		this.setCredits(MySQLUtils.getInt("players", "uuid", uuid.toString(), "credits"));
		this.setCrystals(MySQLUtils.getInt("players", "uuid", uuid.toString(), "crystals"));
		this.setLegendary_steps(Boolean.parseBoolean(MySQLUtils.getString("players", "uuid", uuid.toString(), "legendary_steps")));
		this.setPlacement_end(MySQLUtils.getString("players", "uuid", uuid.toString(), "placement_end"));
		this.setGifts(MySQLUtils.getString("players", "uuid", uuid.toString(), "gifts"));
		this.setChests(MySQLUtils.getString("players", "uuid", uuid.toString(), "chests"));
		this.setLast_connection(MySQLUtils.getString("players", "uuid", uuid.toString(), "last_connection"));
		this.setConnection_streak(MySQLUtils.getInt("players", "uuid", uuid.toString(), "connection_streak"));
		this.setCos_active(MySQLUtils.getString("players", "uuid", uuid.toString(), "cos_active"));
		this.setCos_plus_color(MySQLUtils.getString("players", "uuid", uuid.toString(), "cos_plus_color"));
		this.setFly(Boolean.parseBoolean(MySQLUtils.getString("players", "uuid", uuid.toString(), "fly")));
		this.setSeason_1_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_1_points"));
		this.setSeason_2_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_2_points"));
		this.setSeason_3_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_3_points"));
		this.setSeason_4_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_4_points"));
		this.setSeason_5_points(MySQLUtils.getInt("players", "uuid", uuid.toString(), "season_5_points"));
		this.setS_time_seconds(MySQLUtils.getInt("players", "uuid", uuid.toString(), "s_time_seconds"));
		this.setS_time_minutes(MySQLUtils.getInt("players", "uuid", uuid.toString(), "s_time_minutes"));
		this.setS_time_hours(MySQLUtils.getInt("players", "uuid", uuid.toString(), "s_time_hours"));
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
		this.setHome1(MySQLUtils.getString("players", "uuid", uuid.toString(), "home1"));
		this.setHome2(MySQLUtils.getString("players", "uuid", uuid.toString(), "home2"));
		this.setHome3(MySQLUtils.getString("players", "uuid", uuid.toString(), "home3"));
		this.setHome4(MySQLUtils.getString("players", "uuid", uuid.toString(), "home4"));
		this.setHome5(MySQLUtils.getString("players", "uuid", uuid.toString(), "home5"));
		this.setHome6(MySQLUtils.getString("players", "uuid", uuid.toString(), "home6"));
		this.setHome7(MySQLUtils.getString("players", "uuid", uuid.toString(), "home7"));
		this.setHome8(MySQLUtils.getString("players", "uuid", uuid.toString(), "home8"));
		this.setHome9(MySQLUtils.getString("players", "uuid", uuid.toString(), "home9"));
		this.setHome10(MySQLUtils.getString("players", "uuid", uuid.toString(), "home10"));
		this.setHome11(MySQLUtils.getString("players", "uuid", uuid.toString(), "home11"));
		this.setHome12(MySQLUtils.getString("players", "uuid", uuid.toString(), "home12"));
		this.setHome13(MySQLUtils.getString("players", "uuid", uuid.toString(), "home13"));
		this.setHome14(MySQLUtils.getString("players", "uuid", uuid.toString(), "home14"));
		this.setHome15(MySQLUtils.getString("players", "uuid", uuid.toString(), "home15"));
		this.setHome16(MySQLUtils.getString("players", "uuid", uuid.toString(), "home16"));
		this.setHome17(MySQLUtils.getString("players", "uuid", uuid.toString(), "home17"));
		this.setHome18(MySQLUtils.getString("players", "uuid", uuid.toString(), "home18"));
		this.setHome19(MySQLUtils.getString("players", "uuid", uuid.toString(), "home19"));
		this.setHome20(MySQLUtils.getString("players", "uuid", uuid.toString(), "home20"));
		this.setHome21(MySQLUtils.getString("players", "uuid", uuid.toString(), "home21"));
		this.setHome22(MySQLUtils.getString("players", "uuid", uuid.toString(), "home22"));
		this.setHome23(MySQLUtils.getString("players", "uuid", uuid.toString(), "home23"));
		this.setHome24(MySQLUtils.getString("players", "uuid", uuid.toString(), "home24"));
		this.setHome25(MySQLUtils.getString("players", "uuid", uuid.toString(), "home25"));
		this.setHome26(MySQLUtils.getString("players", "uuid", uuid.toString(), "home26"));
		this.setHome27(MySQLUtils.getString("players", "uuid", uuid.toString(), "home27"));
		this.setHome28(MySQLUtils.getString("players", "uuid", uuid.toString(), "home28"));
		this.setHome29(MySQLUtils.getString("players", "uuid", uuid.toString(), "home29"));
		this.setHome30(MySQLUtils.getString("players", "uuid", uuid.toString(), "home30"));
		this.setHome31(MySQLUtils.getString("players", "uuid", uuid.toString(), "home31"));
		this.setHome32(MySQLUtils.getString("players", "uuid", uuid.toString(), "home32"));
		this.setHome33(MySQLUtils.getString("players", "uuid", uuid.toString(), "home33"));
		this.setHome34(MySQLUtils.getString("players", "uuid", uuid.toString(), "home34"));
		this.setHome35(MySQLUtils.getString("players", "uuid", uuid.toString(), "home35"));
		this.setHome36(MySQLUtils.getString("players", "uuid", uuid.toString(), "home36"));
		this.setHome37(MySQLUtils.getString("players", "uuid", uuid.toString(), "home37"));
		this.setHome38(MySQLUtils.getString("players", "uuid", uuid.toString(), "home38"));
		this.setHome39(MySQLUtils.getString("players", "uuid", uuid.toString(), "home39"));
		this.setHome40(MySQLUtils.getString("players", "uuid", uuid.toString(), "home40"));
		
		this.setAfk(false);
		this.setConfirm(null);
		
	}
	
	public void save() {
		
		MySQLUtils.setString("players", "uuid", uuid.toString(), "name", name);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "rank", rank);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "data", data);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "staff", staff);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "other_ranks", other_ranks);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "points", points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "tokens", tokens);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "credits", credits);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "crystals", crystals);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "legendary_steps", String.valueOf(legendary_steps));
		MySQLUtils.setString("players", "uuid", uuid.toString(), "placement_end", placement_end);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "gifts", gifts);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "chests", chests);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "last_connection", last_connection);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "connection_streak", connection_streak);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "fly", String.valueOf(fly));
		MySQLUtils.setString("players", "uuid", uuid.toString(), "cos_active", cos_active);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "cos_plus_color", cos_plus_color);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_1_points", season_1_points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_2_points", season_2_points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_3_points", season_3_points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_4_points", season_4_points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "season_5_points", season_5_points);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "s_time_seconds", s_time_seconds);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "s_time_minutes", s_time_minutes);
		MySQLUtils.setInt("players", "uuid", uuid.toString(), "s_time_hours", s_time_hours);
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
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home1", home1);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home2", home2);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home3", home3);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home4", home4);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home5", home5);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home6", home6);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home7", home7);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home8", home8);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home9", home9);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home10", home10);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home11", home11);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home12", home12);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home13", home13);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home14", home14);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home15", home15);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home16", home16);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home17", home17);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home18", home18);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home19", home19);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home20", home20);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home21", home21);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home22", home22);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home23", home23);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home24", home24);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home25", home25);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home26", home26);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home27", home27);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home28", home28);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home29", home29);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home30", home30);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home31", home31);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home32", home32);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home33", home33);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home34", home34);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home35", home35);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home36", home36);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home37", home37);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home38", home38);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home39", home39);
		MySQLUtils.setString("players", "uuid", uuid.toString(), "home40", home40);
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
		}else if(season == 2) {
			result = season_2_points;
		}else if(season == 3) {
			result = season_3_points;
		}else if(season == 4) {
			result = season_4_points;
		}else if(season == 5) {
			result = season_5_points;
		}
		
		return result;
		
	}
	
	public void setPointsBySeason(int season, int points) {
		
		if(season == 1) {
			season_1_points = points;
		}else if(season == 2) {
			season_2_points = points;
		}else if(season == 3) {
			season_3_points = points;
		}else if(season == 4) {
			season_4_points = points;
		}else if(season == 5) {
			season_5_points = points;
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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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

	public String getOther_ranks() {
		return other_ranks;
	}

	public void setOther_ranks(String other_ranks) {
		this.other_ranks = other_ranks;
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

	public int getCrystals() {
		return crystals;
	}

	public void setCrystals(int crystals) {
		this.crystals = crystals;
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

	public String getGifts() {
		return gifts;
	}

	public void setGifts(String gifts) {
		this.gifts = gifts;
	}

	public String getChests() {
		return chests;
	}

	public void setChests(String chests) {
		this.chests = chests;
	}

	public String getLast_connection() {
		return last_connection;
	}

	public void setLast_connection(String last_connection) {
		this.last_connection = last_connection;
	}

	public int getConnection_streak() {
		return connection_streak;
	}

	public void setConnection_streak(int connection_streak) {
		this.connection_streak = connection_streak;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}

	public String getCos_active() {
		return cos_active;
	}

	public void setCos_active(String cos_active) {
		this.cos_active = cos_active;
	}

	public String getCos_plus_color() {
		return cos_plus_color;
	}

	public void setCos_plus_color(String cos_plus_color) {
		this.cos_plus_color = cos_plus_color;
	}

	public int getSeason_1_points() {
		return season_1_points;
	}

	public void setSeason_1_points(int season_1_points) {
		this.season_1_points = season_1_points;
	}

	public int getSeason_2_points() {
		return season_2_points;
	}

	public void setSeason_2_points(int season_2_points) {
		this.season_2_points = season_2_points;
	}

	public int getSeason_3_points() {
		return season_3_points;
	}

	public void setSeason_3_points(int season_3_points) {
		this.season_3_points = season_3_points;
	}

	public int getSeason_4_points() {
		return season_4_points;
	}

	public void setSeason_4_points(int season_4_points) {
		this.season_4_points = season_4_points;
	}

	public int getSeason_5_points() {
		return season_5_points;
	}

	public void setSeason_5_points(int season_5_points) {
		this.season_5_points = season_5_points;
	}

	public int getS_time_seconds() {
		return s_time_seconds;
	}

	public void setS_time_seconds(int s_time_seconds) {
		this.s_time_seconds = s_time_seconds;
	}

	public int getS_time_minutes() {
		return s_time_minutes;
	}

	public void setS_time_minutes(int s_time_minutes) {
		this.s_time_minutes = s_time_minutes;
	}

	public int getS_time_hours() {
		return s_time_hours;
	}

	public void setS_time_hours(int s_time_hours) {
		this.s_time_hours = s_time_hours;
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

	public String getHome1() {
		return home1;
	}

	public void setHome1(String home1) {
		this.home1 = home1;
	}

	public String getHome2() {
		return home2;
	}

	public void setHome2(String home2) {
		this.home2 = home2;
	}

	public String getHome3() {
		return home3;
	}

	public void setHome3(String home3) {
		this.home3 = home3;
	}

	public String getHome4() {
		return home4;
	}

	public void setHome4(String home4) {
		this.home4 = home4;
	}

	public String getHome5() {
		return home5;
	}

	public void setHome5(String home5) {
		this.home5 = home5;
	}

	public String getHome6() {
		return home6;
	}

	public void setHome6(String home6) {
		this.home6 = home6;
	}

	public String getHome7() {
		return home7;
	}

	public void setHome7(String home7) {
		this.home7 = home7;
	}

	public String getHome8() {
		return home8;
	}

	public void setHome8(String home8) {
		this.home8 = home8;
	}

	public String getHome9() {
		return home9;
	}

	public void setHome9(String home9) {
		this.home9 = home9;
	}

	public String getHome10() {
		return home10;
	}

	public void setHome10(String home10) {
		this.home10 = home10;
	}

	public String getHome11() {
		return home11;
	}

	public void setHome11(String home11) {
		this.home11 = home11;
	}

	public String getHome12() {
		return home12;
	}

	public void setHome12(String home12) {
		this.home12 = home12;
	}

	public String getHome13() {
		return home13;
	}

	public void setHome13(String home13) {
		this.home13 = home13;
	}

	public String getHome14() {
		return home14;
	}

	public void setHome14(String home14) {
		this.home14 = home14;
	}

	public String getHome15() {
		return home15;
	}

	public void setHome15(String home15) {
		this.home15 = home15;
	}

	public String getHome16() {
		return home16;
	}

	public void setHome16(String home16) {
		this.home16 = home16;
	}

	public String getHome17() {
		return home17;
	}

	public void setHome17(String home17) {
		this.home17 = home17;
	}

	public String getHome18() {
		return home18;
	}

	public void setHome18(String home18) {
		this.home18 = home18;
	}

	public String getHome19() {
		return home19;
	}

	public void setHome19(String home19) {
		this.home19 = home19;
	}

	public String getHome21() {
		return home21;
	}

	public void setHome21(String home21) {
		this.home21 = home21;
	}

	public String getHome20() {
		return home20;
	}

	public void setHome20(String home20) {
		this.home20 = home20;
	}

	public String getHome22() {
		return home22;
	}

	public void setHome22(String home22) {
		this.home22 = home22;
	}

	public String getHome23() {
		return home23;
	}

	public void setHome23(String home23) {
		this.home23 = home23;
	}

	public String getHome24() {
		return home24;
	}

	public void setHome24(String home24) {
		this.home24 = home24;
	}

	public String getHome25() {
		return home25;
	}

	public void setHome25(String home25) {
		this.home25 = home25;
	}

	public String getHome26() {
		return home26;
	}

	public void setHome26(String home26) {
		this.home26 = home26;
	}

	public String getHome27() {
		return home27;
	}

	public void setHome27(String home27) {
		this.home27 = home27;
	}

	public String getHome28() {
		return home28;
	}

	public void setHome28(String home28) {
		this.home28 = home28;
	}

	public String getHome29() {
		return home29;
	}

	public void setHome29(String home29) {
		this.home29 = home29;
	}

	public String getHome30() {
		return home30;
	}

	public void setHome30(String home30) {
		this.home30 = home30;
	}

	public String getHome31() {
		return home31;
	}

	public void setHome31(String home31) {
		this.home31 = home31;
	}

	public String getHome32() {
		return home32;
	}

	public void setHome32(String home32) {
		this.home32 = home32;
	}

	public String getHome33() {
		return home33;
	}

	public void setHome33(String home33) {
		this.home33 = home33;
	}

	public String getHome34() {
		return home34;
	}

	public void setHome34(String home34) {
		this.home34 = home34;
	}

	public String getHome35() {
		return home35;
	}

	public void setHome35(String home35) {
		this.home35 = home35;
	}

	public String getHome36() {
		return home36;
	}

	public void setHome36(String home36) {
		this.home36 = home36;
	}

	public String getHome37() {
		return home37;
	}

	public void setHome37(String home37) {
		this.home37 = home37;
	}

	public String getHome38() {
		return home38;
	}

	public void setHome38(String home38) {
		this.home38 = home38;
	}

	public String getHome39() {
		return home39;
	}

	public void setHome39(String home39) {
		this.home39 = home39;
	}

	public String getHome40() {
		return home40;
	}

	public void setHome40(String home40) {
		this.home40 = home40;
	}

	public boolean isAfk() {
		return afk;
	}

	public void setAfk(boolean afk) {
		this.afk = afk;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
