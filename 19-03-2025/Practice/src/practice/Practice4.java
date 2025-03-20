package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Practice4 {

	public static void main(String[] args) {
String query="SELECT*FROM Users";
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("Connection established successfully.");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet result=ps.executeQuery();
			while(result.next()){
				System.out.println(result.getInt("userid")+" | "+result.getString("username")+" | "+result.getString("gmail")+" | "+result.getString("userpass"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
