package fr.schawnndev.landcraft.ranks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import fr.schawnndev.landcraft.Main;
import fr.schawnndev.landcraft.datas.DataManager;
import fr.schawnndev.landcraft.server.Server;
import fr.schawnndev.landcraft.users.User;

public class RankManager {
	
	private static ArrayList<Rank> ranks = new ArrayList<Rank>();
	@Getter
	private static Rank defaultRank = new Rank("default", 1, "default", "[Default]");
	
	public static void init() {
		for (String s : new String[1])
			ranks.add(new Rank(s, 1, "", ""));
	}
	
	private static String[] splitRank(User user, Server server) {
		return getRanks(user).split(",");
	}
	
	public static List<Rank> getRanks(UUID uuid, Server server) {
		ArrayList<Rank> rank = new ArrayList<Rank>();
		rank.add(new Rank("VIP", 1, "vip", "[VIP]"));
		return rank;
	}
	
	public static String getRanks(User user) {
		return (String) DataManager.get(user, "profiles", 3, "uuid");
	}
	
	public static void setRank(Rank rank, Server server, UUID uuid, int time){
		
		if (time == 0) {

		} else {

		}
	}
	
	public static void removeRank(Rank rank, UUID uuid, Server server){
		
	}
	
	public static String fetchRank(HashMap<Server, Rank[]> ranks) {
		String fetched = "";

		for (Server s : Main.getServers()) {
			String _aW = s.getName() + "{";
			for (Rank r : ranks.get(s))
				_aW += r.getName() + ",";

			_aW += "},";
			fetched += _aW;
		}

		return fetched;
	}

	public static String fetchDefaultRank(User user){
		String fetched = "";
		
		for (Server s : Main.getServers())
			fetched += (s.getName() + "{ " + getDefaultRank().getName() + " },");

		return fetched;
	}
	
	
	
}
