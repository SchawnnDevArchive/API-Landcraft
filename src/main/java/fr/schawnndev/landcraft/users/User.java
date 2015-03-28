package fr.schawnndev.landcraft.users;

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
	private Rank rank;
	
	public User(String name, String uuid) {
		this.uuid = UUID.fromString(uuid);
		this.name = name;
		rank = RankManager.getRank(this.uuid, Main.getServerName());
	}
	
	

}
