package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Mail : ");
		String mail = sc.next();
		
		String query = "SELECT * FROM users WHERE gmail = '" + mail + "';";
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established Successfully...");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				String pass = rs.getString("Pass_word");
				
				System.out.print("Enter the Password : ");
				String password = sc.next();
				
				if(password.equals(pass)) {
					System.out.println("Welcome back " + rs.getInt("user_id"));
				}
				else {
					System.out.println("Incorrect password");
				}
			}
			else {
				System.out.println("User not found...");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}