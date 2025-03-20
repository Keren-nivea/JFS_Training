package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Practice6 {

	public static void main(String[] args) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("Connection established successfully.");
			
			java.sql.DatabaseMetaData metadb=con.getMetaData();
			
			System.out.println(metadb.getDriverName());
			System.out.println(metadb.getDriverVersion());
			System.out.println(metadb.getUserName());
			System.out.println(metadb.getDatabaseProductName());
			System.out.println(metadb.getDatabaseProductVersion());
			System.out.println(metadb.getMaxColumnNameLength());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
