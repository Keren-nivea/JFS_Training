package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Adding {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con=DriverManager.getConnection(url,"root","root");
			System.out.println("Connection established successfully");
			java.sql.Statement st=con.createStatement();
			System.out.println("Enter your mail id:");
			String mail=sc.next();
			String query="SELECT*FROM Users WHERE Gmail=('"+mail+"')";
			ResultSet result=st.executeQuery(query);
			if(result.next()){
				System.out.println("User name already available");
			}
			else{
				System.out.println("Enter your password");
				String password=sc.next();
				String query1="INSERT INTO Users (Gmail,Pass_word) VALUES('"+mail+"','"+password+"')";
				int rowsaffected= st.executeUpdate(query1);
				if(rowsaffected>0){
					System.out.println("Account successfully created");
				}
				else{
					System.out.println("There is an error in creating the account");
				}
			}
			result.close();
			con.close();
			st.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
