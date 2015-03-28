package fr.schawnndev.landcraft;

import lombok.AccessLevel;
import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Getter(value=AccessLevel.PUBLIC)
	private static Main instance;
	@Getter(value=AccessLevel.PUBLIC)
	private static API api;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
		
		instance = this;
		api = new API();
	}

}
