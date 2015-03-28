package fr.schawnndev.landcraft;

import lombok.AccessLevel;
import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

import fr.schawnndev.landcraft.datas.SQL;
import fr.schawnndev.landcraft.datas.SQLManager;
import fr.schawnndev.landcraft.ranks.RankManager;

public class Main extends JavaPlugin {

	@Getter(value = AccessLevel.PUBLIC)
	private static Main instance;
	@Getter(value = AccessLevel.PUBLIC)
	private static API api;
	@Getter(value = AccessLevel.PUBLIC)
	private static SQL sql;
	private static SQLManager sqlManager;
	@Getter(value = AccessLevel.PUBLIC)
	private static String serverName;

	public void onEnable() {

		// -- Instances --

		instance = this;
		api = new API();

		// -- MySQL --

		sql = new SQL("localhost", "", "", "");
		
		sqlManager = new SQLManager();
		sqlManager.refreshConnection();
		
		// -- Ranks --
		
		RankManager.init();
		
		// -- Vars --
		
		serverName = "pvp"; // TODO: Config file

	}

	public void onDisable() {
		sqlManager.stopConnection();
	}

}
