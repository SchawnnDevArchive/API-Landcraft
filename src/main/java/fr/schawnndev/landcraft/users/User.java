package fr.schawnndev.landcraft.users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import fr.schawnndev.landcraft.Main;
import fr.schawnndev.landcraft.ranks.Rank;
import fr.schawnndev.landcraft.ranks.RankManager;

public class User {
	
	@Getter
	private UUID uuid;
	@Getter
	private String name;
	@Getter
	private List<Rank> ranks = new ArrayList<Rank>();
	
	public User(String name, String uuid) {
		this.uuid = UUID.fromString(uuid);
		this.name = name;
		ranks = RankManager.getRanks(this.uuid, Main.getCurrentServer());
	}
	
	

}
