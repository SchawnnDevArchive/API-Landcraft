package fr.schawnndev.landcraft.datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import fr.schawnndev.landcraft.Main;
import lombok.AccessLevel;
import lombok.Getter;

public class SQLManager {
	
	@Getter(value = AccessLevel.PUBLIC)
	private static Connection connection;
	@Getter(value = AccessLevel.PUBLIC)
	private static SQL sql;
	
	public SQLManager() {
		sql = Main.getSql();
	}

	public synchronized void refreshConnection() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			public void run() {
				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://" + sql.getHost() + ":3306/" + sql.getTable(), sql.getUser(), sql.getPassword());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}, 0L, 20 * 60 * 5);
	}
	
	public void stopConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
