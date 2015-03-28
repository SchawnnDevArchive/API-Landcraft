package fr.schawnndev.landcraft;

import lombok.AccessLevel;
import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

import fr.schawnndev.landcraft.datas.SQL;

public class Main extends JavaPlugin {

	@Getter(value = AccessLevel.PUBLIC)
	private static Main instance;
	@Getter(value = AccessLevel.PUBLIC)
	private static API api;
	@Getter(value = AccessLevel.PRIVATE)
	private static SQL sql;

	public void onDisable() {
	}

	public void onEnable() {

		// -- Instances --

		instance = this;
		api = new API();

		// -- MySQL --

		sql = new SQL("localhost", "", "", "");

	}

}
