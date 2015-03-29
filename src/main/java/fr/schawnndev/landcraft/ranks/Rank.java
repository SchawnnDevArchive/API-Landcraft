package fr.schawnndev.landcraft.ranks;

import lombok.Getter;

public class Rank {

	@Getter
	private String name;
	@Getter
	private int id;
	@Getter
	private String pex_name;
	@Getter
	private String prefix;

	public Rank(String name, int id, String pex_name, String prefix) {
		this.name = name;
		this.id = id;
		this.pex_name = pex_name;
		this.prefix = prefix;
	}

}
