package fr.schawnndev.landcraft.datas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.common.base.Preconditions;

import fr.schawnndev.landcraft.ranks.RankManager;
import fr.schawnndev.landcraft.users.User;

public class DataManager {

	public static void addProfile(User user) {
		//
		Preconditions.checkArgument(user != null, "DataManager: (add) (User) User est null");
		//
		try {
			Statement s = SQLManager.getConnection().createStatement();
			ResultSet rs = null;
			
			rs = s.executeQuery("INSERT INTO profiles(uuid,name,ranks,id) VALUES ('"+user.getUuid()+"', '"+user.getName()+"', '"+RankManager.fetchDefaultRank(user) + "', '"+1+"')");
			

			s.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
	}

	public static void remove() {

	}

	public static boolean contains(User user, String table) {
		//
		Preconditions.checkArgument(user != null, "DataManager: (contains) (User) User est null");
		Preconditions.checkArgument(table != null, "DataManger: (contains) (String) Table est null");
		//
		try {
			Statement s = SQLManager.getConnection().createStatement();
			ResultSet rs = null;

			rs = s.executeQuery("SELECT * FROM " + table + " WHERE uuid='" + user.getUuid() + "'");
			
			while (rs.next()) {
				if (rs != null)
					return true;
			}

			s.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		return false;
		//
	}
	
	public static Object get(User user, String table, int line, String what) {
		//
		Preconditions.checkArgument(user != null, "DataManager: (get) (User) User est null");
		Preconditions.checkArgument(what != null, "DataManger: (get) (String) What est null");
		Preconditions.checkArgument(table != null, "DataManger: (get) (String) Table est null");
		//
		try {
			Statement s = SQLManager.getConnection().createStatement();
			ResultSet rs = null;
			Object returnObject = null;
			
			rs = s.executeQuery("SELECT * FROM " + table + " WHERE " + what + "='" + user.getUuid() + "'");
			
			while (rs.next()) {
				returnObject = rs.getObject(line);
			}

			s.close();
			rs.close();

			return returnObject;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		return "null";
		//
	}
	
}
