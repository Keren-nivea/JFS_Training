package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//prepared statement

public class Practice1 {
	public static void main(String[] args){
		
		String query="INSERT INTO Users (username,gmail,userpass) VALUES (?,?,?);";
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("Connection established successfully.");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,"keren");
			ps.setString( 2,"kerennivea2004@gmail.com");
			ps.setString(3,"nivea2004");
			int rows=ps.executeUpdate();
			System.out.println("Rows affected:"+rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
