package fr.schawnndev.landcraft.ranks;

import java.util.ArrayList;
import java.util.UUID;

public class RankManager {
	
	private static ArrayList<Rank> ranks = new ArrayList<Rank>();
	
	public static void init(){
		for(String s : new String[1])
			ranks.add(new Rank(s, 1, "", ""));
	}
	
	public static Rank getRank(UUID uuid, String server){
		return new Rank("VIP", 1, "vip", "[VIP]");
	}
	
	public static void setRank(Rank rank, String server, UUID uuid, int time){
		boolean perm = time >= (60 * 24 * 30 * 12) ? true : false;
		
		if (perm) {

		} else {

		}
	}
	
	public static void removeRank(Rank rank, UUID uuid, String server){
		
	}

}
