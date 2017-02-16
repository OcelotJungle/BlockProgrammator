package ru.ocelotjungle.blockprogrammer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static Connection connection;
	public static Statement statement;
	public static ResultSet result;

	public static boolean Connect() {

		File file = Main.plugin.getDataFolder();

		file.mkdir();

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ Main.plugin.getDataFolder() + "\\table_blocks.s3db");

			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	public static boolean Create() {

		try {
			statement = connection.createStatement();
			/*
			 * statement.execute("CREATE TABLE if not exists 'blocks' (" //+
			 * "'id' INT PRIMARY KEY AUTOINCREMENT" + "'x' INT NOT NULL, " +
			 * "'y' INT NOT NULL, " + "'z' INT NOT NULL, " +
			 * "'info' TEXT NOT NULL);");
			 */
			statement.execute("CREATE TABLE IF NOT EXISTS 'blocks' ("
					+ "'players' TEXT NOT NULL, " + "'clan' INT, "
					+ "'guild' INT, " + "'level' INT);");

			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	public static boolean Fill() {

		try {
			statement.execute("DELETE FROM 'blocks'");
			statement.execute("VACUUM");
			statement
					.execute("INSERT INTO 'blocks' ('x', 'y', 'z', 'info') VALUES (110, 120, 130, 'abcde1');");
			statement
					.execute("INSERT INTO 'blocks' ('x', 'y', 'z', 'info') VALUES (210, 220, 230, 'abcde2');");
			statement
					.execute("INSERT INTO 'blocks' ('x', 'y', 'z', 'info') VALUES (310, 320, 330, 'abcde3');");

			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			return false;
		}
	}

	public static boolean Log() {

		try {
			result = statement.executeQuery("SELECT * from 'blocks'");

			while (result.next()) {

				Logger.logF("BLOCK_DB: (%d; %d; %d;) is '%s'.",
						result.getInt("clan"), result.getInt("guild"),
						result.getInt("level"), result.getString("players"));
			}

			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			return false;
		}
	}

	public static boolean Close() {

		try {
			statement.close();
			result.close();
			connection.close();

			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			return false;
		}
	}

}
