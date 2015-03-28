package fr.schawnndev.landcraft.datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import fr.schawnndev.landcraft.Main;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class SQL {
	@Setter(value = AccessLevel.PUBLIC)
	private String host;
	@Setter(value = AccessLevel.PUBLIC)
	private String table;
	@Setter(value = AccessLevel.PUBLIC)
	private String password;
	@Setter(value = AccessLevel.PUBLIC)
	private String user;
	@Getter(value = AccessLevel.PUBLIC)
	private static Connection connection;

	public SQL(String host, String table, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.table = table;

		openConnection();
	}

	private void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + table, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void refreshConnection() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			public void run() {
				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + table,user, password);
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
