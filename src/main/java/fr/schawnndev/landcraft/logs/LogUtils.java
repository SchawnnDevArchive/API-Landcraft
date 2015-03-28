package fr.schawnndev.landcraft.logs;

import fr.schawnndev.landcraft.users.User;

public class LogUtils {
	
	public static void printConnection(User user){
		System.out.println("Connection: Player " + user.getName() + " with uuid " + user.getUuid() + " {rank: " + user.getRanks().toString() + " }");
	}
	
	public static void printDeconnection(User user){
		System.out.println("Deconnection: Player " + user.getName() + " with uuid " + user.getUuid() + " {rank: " + user.getRanks().toString() + " }");
	}

}
