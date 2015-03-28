package fr.schawnndev.landcraft.datas;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class SQL {
	@Getter @Setter(value = AccessLevel.PUBLIC)
	private String host;
	@Getter @Setter(value = AccessLevel.PUBLIC)
	private String table;
	@Getter @Setter(value = AccessLevel.PUBLIC)
	private String password;
	@Getter @Setter(value = AccessLevel.PUBLIC)
	private String user;

	public SQL(String host, String table, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.table = table;
	}

}
