package database;

import java.sql.*;


public class UserLogin {

	// Variabeln Datenbank Verbindung

	private static String	url			= "jdbc:mariadb://192.168.3.150:3306/userdb";
	private static String	username	= "prototyp";
	private static String	password	= "prototyp";
	private static String	driver		= "com.mysql.jdbc.Driver";

	/**
	 * F�gt der Datenbank einen neuen User hinzu
	 * 
	 * @param values
	 *            --> String Array mit 3 Werten. Username, E-Mail, Passwort
	 * @param teacher
	 *            --> Boolean: true = Lehrer, false = Sch�ler
	 */

	public static void newUser (String[] values, boolean teacher) {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);
			stmt = c.createStatement();

			String studValues = "";

			for (int i = 0; i < values.length; i++) {

				if (i < values.length - 1) {

					studValues += "'" + values[i] + "',";

				}
				else {

					studValues += "'" + values[i] + "'";

				}

			}

			String teachValues = "";

			for (int i = 0; i < values.length; i++) {

				if (i < values.length - 1) {

					teachValues += "'" + values[i] + "',";

				}
				else {

					teachValues += "'" + values[i] + "'";

				}

			}

			String usedb = "USE " + "userdb";
			stmt.executeQuery(usedb);

			System.out.println("Opened database successfully");

			String sql1 = "CREATE TABLE IF NOT EXISTS Teachers " +
					"(PK_Teachers INT PRIMARY KEY AUTO_INCREMENT," +
					" Username TEXT NOT NULL," +
					" Email TEXT NOT NULL," +
					" Password TEXT NOT NULL" + ")";

			System.out.println(sql1);
			stmt.executeUpdate(sql1);
			System.out.println("Lehrertabelle erstellt!");

			String sql2 = "CREATE TABLE IF NOT EXISTS Students " +
					"(PK_Students INT PRIMARY KEY AUTO_INCREMENT," +
					" Username TEXT NOT NULL," +
					" Email TEXT NOT NULL," +
					" Password TEXT NOT NULL" + ")";

			System.out.println(sql2);
			stmt.executeUpdate(sql2);
			System.out.println("Sch�lertabelle erstellt!");

			if (teacher) {

				String newTeach = "INSERT INTO Teachers (Username, Email, Password) VALUES (" + teachValues + ")";
				stmt.executeUpdate(newTeach);
				System.out.println(newTeach);
				System.out.println("Teacher sucessfully added!");

			}
			else if (!teacher) {

				String newStud = "INSERT INTO Students (Username, Email, Password) VALUES (" + studValues + ")";
				System.out.println(newStud);
				stmt.executeUpdate(newStud);
				System.out.println("Student sucessfully added!");

			}

			stmt.close();
			c.close();
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	/**
	 * �berpr�ft ob ein Wert bereits vorhanden ist
	 * 
	 * @param values
	 *            --> String Array mit 2 Werten, Username und Email
	 * @return --> Retourniert true, wenn m�glich, sonst false
	 */

	public static boolean checkPossible (String[] values) {

		boolean possible = true;
		boolean noTeacher = true;
		boolean noStudent = true;

		// �berpr�fen ob ein Lehrer mit dem Username oder Email vorhanden ist

		Connection c = null;
		Statement stmt = null;

		String url = "jdbc:mariadb://192.168.3.150:3306/userdb";
		String username = "prototyp";
		String password = "prototyp";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);
			stmt = c.createStatement();

			String sql1 = "CREATE TABLE IF NOT EXISTS Teachers " +
					"(PK_Lehrer INT PRIMARY KEY AUTO_INCREMENT," +
					" Username TEXT NOT NULL," +
					" Email TEXT NOT NULL," +
					" Password TEXT NOT NULL" + ")";

			System.out.println(sql1);
			stmt.executeUpdate(sql1);
			System.out.println("Lehrertabelle erstellt!");

			String sql2 = "CREATE TABLE IF NOT EXISTS Students " +
					"(PK_Lehrer INT PRIMARY KEY AUTO_INCREMENT," +
					" Username TEXT NOT NULL," +
					" Email TEXT NOT NULL," +
					" Password TEXT NOT NULL" + ")";

			System.out.println(sql2);
			stmt.executeUpdate(sql2);
			System.out.println("Sch�lertabelle erstellt!");

			c.setAutoCommit(false);
			ResultSet rsUsern = stmt
					.executeQuery("SELECT Username FROM Teachers WHERE Username = " + "'" + values[0] + "'");
			ResultSet rsEmail = stmt.executeQuery("SELECT Email FROM Teachers WHERE Email = " + "'" + values[1] + "'");

			if (rsUsern.next() || rsEmail.next()) {

				noTeacher = false;

			}

			rsUsern.close();
			rsEmail.close();
			stmt.close();
			c.close();
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		// �berpr�fen ob ein Sch�ler mit dem Username oder Email vorhanden ist

		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			ResultSet rsUsern = stmt
					.executeQuery("SELECT Username FROM Students WHERE Username = " + "'" + values[0] + "'");
			ResultSet rsEmail = stmt.executeQuery("SELECT Email FROM Students WHERE Email = " + "'" + values[1] + "'");

			if (rsUsern.next() || rsEmail.next()) {

				noStudent = false;

			}

			rsUsern.close();
			rsEmail.close();
			stmt.close();
			c.close();
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		// Wenn keine Lehrer und keine Sch�ler mit passendem Username oder Email
		// vorhanden ist, ist es m�glich

		if (noTeacher && noStudent) {

			possible = true;

		}
		else {

			possible = false;

		}

		return possible;

	}

	/**
	 * L�scht den angegebenen User
	 * 
	 * @param delName
	 *            --> String mit Username
	 * 
	 */

	public static void delUser (String delName) {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);
			stmt = c.createStatement();

			String delStudent = "DELETE FROM Students WHERE Username = " + delName;
			String delTeacher = "DELETE FROM Teachers WHERE Username = " + delName;

			stmt.executeUpdate(delStudent);
			stmt.executeUpdate(delTeacher);

			System.out.println("Successfully deleted User: " + delName);

			stmt.close();
			c.close();
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
	
	/**
	 * �berpr�ft die Login Daten
	 * 
	 * @param userData --> Ben�tigt ein String Array mit Username, Password
	 * @return --> True = Korrekt, False = Inkorrekt
	 */
	
	public static boolean loginUser (String[] userData) {
		
		boolean loggedIn = false;
		String password = null;
		
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, username, password);
			stmt = c.createStatement();
			c.setAutoCommit(false);
			
			ResultSet rs = stmt.executeQuery("SELECT Password FROM Students WHERE Username = '" + userData[0] + "'");
			
			while (rs.next()) {
				
				password = rs.getString("Password");
				
			}
			
			stmt.close();
			c.close();
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		if (userData[1].equals(password)) {
			
			loggedIn = true;
			
		}
		
		return loggedIn;
	}

}