package fr.schawnndev.landcraft.server;

import lombok.Getter;

public class Server {
	
	@Getter
	private String id;
	@Getter
	private int port;
	@Getter
	private String name;
	
	public Server(String name, String id, int port) {
		this.id = id;
		this.name = name;
		this.port = port;
	}

}
