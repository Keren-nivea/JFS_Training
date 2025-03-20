package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {
public static void main(String[] args){
		
		String query="DELETE FROM Users WHERE userid=?;";
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("Connection established successfully.");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,3005);
			int rows=ps.executeUpdate();
			System.out.println("Rows affected:"+rows);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
