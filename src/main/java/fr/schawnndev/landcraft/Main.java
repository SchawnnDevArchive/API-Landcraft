package fr.schawnndev.landcraft;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

import fr.schawnndev.landcraft.datas.SQL;
import fr.schawnndev.landcraft.datas.SQLManager;
import fr.schawnndev.landcraft.ranks.RankManager;
import fr.schawnndev.landcraft.server.Server;

public class Main extends JavaPlugin {

	@Getter(value = AccessLevel.PUBLIC)
	private static Main instance;
	@Getter(value = AccessLevel.PUBLIC)
	private static API api;
	@Getter(value = AccessLevel.PUBLIC)
	private static SQL sql;
	@Getter(value = AccessLevel.PUBLIC)
	private static SQLManager sqlManager;
	@Getter(value = AccessLevel.PUBLIC)
	private static Server currentServer;
	@Getter(value = AccessLevel.PUBLIC)
	private static Server[] servers;

	public void onEnable() {
		
		long startMillis = System.currentTimeMillis();

		// -- Instances --

		instance = this;
		api = new API();

		// -- MySQL --

		sql = new SQL("localhost", "landcraft", "root", "");
		
		sqlManager = new SQLManager();
		sqlManager.refreshConnection();
		
		// -- Ranks --
		
		RankManager.init();
		
		// -- Vars --
		
		currentServer = new Server(getConfig().getString("server.currentserver.name"), getConfig().getString("server.currentserver.ip").replace('i', ':'), getConfig().getInt("server.currentserver.port"));
		
		servers = new Server[getConfig().getList("server.servers").size()];
		int count = 0;
		
		for(String s : (List<String>) getConfig().getList("server.servers")){
			String[] infos = s.split("|");
			servers[count] = new Server(infos[0], infos[1].replace('i', ':'), Integer.parseInt(infos[2]));
			count++;
		}
		
		System.out.println("[LANDCRAFT-API] Start time : " + (System.currentTimeMillis() - startMillis) + " ms !");

	}

	public void onDisable() {
		sqlManager.stopConnection();
	}

}
