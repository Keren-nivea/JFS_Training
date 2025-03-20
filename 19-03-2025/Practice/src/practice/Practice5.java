package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Practice5 {

	public static void main(String[] args) {
String query="SELECT*FROM Users";
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("Connection established successfully.");
			java.sql.Statement ps=con.createStatement();
			ResultSet result=ps.executeQuery(query);
			
			ResultSetMetaData meta = result.getMetaData();
			System.out.println("Number of Columns:"+meta.getColumnCount());
			System.out.println("Columns name of specific number:"+meta.getColumnName(3));
			System.out.println(meta.getColumnTypeName(4));
			System.out.println(meta.getTableName(1));
			System.out.println();
			while(result.next()){
				System.out.println(result.getInt("userid")+" | "+result.getString("username")+" | "+result.getString("gmail")+" | "+result.getString("userpass"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
