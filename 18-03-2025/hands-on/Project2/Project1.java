package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con=DriverManager.getConnection(url,"root","root");
			System.out.println("Connection established successfully");
			java.sql.Statement st=con.createStatement();
			System.out.println("Sign in=0 or Sign up=1");
			int decision=sc.nextInt();
			if(decision==0){
				System.out.println("Enter you mail id:");
				String mail=sc.next();
				String query="SELECT*FROM Users WHERE Gmail='"+mail+"';";
				ResultSet result=st.executeQuery(query);
				if(result.next()){
					String password=result.getString("Pass_word");
					System.out.println("Enter your password:");
					String pass=sc.next();
					if(password.equals(pass)){
						System.out.println("Welcome Back "+result.getInt("User_id"));
					}
					else{
						System.out.println("Incorrect password");
					}
				}
				else{
					System.out.println("No such user Please sign up");
				}	
				result.close();
			}
			else{
				System.out.println("Enter your user name:");
				String mail=sc.next();
				String query="SELECT*FROM Users WHERE Gmail='"+mail+"';";
				ResultSet res=st.executeQuery(query);
				if(res.next()){
					System.out.println("User already found");
				}
				else{
					System.out.println("Enter your password");
					String password=sc.next();
					String Query="INSERT INTO Users (Gmail,Pass_word) VALUES ('"+mail+"','"+password+"');";
					int rowsAffected=st.executeUpdate(Query);
					if(rowsAffected>0){
						System.out.println("Account created successfully");
					}
					else{
						System.out.println("Failed to create account");
					}
					
				}
				res.close();
			}
			st.close();
			con.close();
			sc.close();
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
