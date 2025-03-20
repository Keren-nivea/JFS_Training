package tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
			Statement st=con.createStatement();
			System.out.println("Welcome to this Symposium");
			System.out.println("Click '1' to register\nClick '2' to edit the information\nClick '3' to Delete the user");
			int choice=sc.nextInt();
			if(choice==1){
				String query="INSERT INTO eventinfo (College_name, Event_name, Part1_name, Part2_name, Mail, Team_name) VALUES (?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				System.out.println("Enter your mail id:");
				String mail=sc.next();
				String querymail="SELECT*FROM eventinfo WHERE Mail='"+mail+"';";
				ResultSet res= st.executeQuery(querymail);
				
				if(res.next()){
					System.out.println("This mail id has already registered in the symposium...");
				}
				else{
					System.out.println("Enter your college name:");
					String college=sc.next();
					System.out.println("Enter the event name:");
					String event=sc.next();
					System.out.println("Enter the first participant name:");
					String part1=sc.next();
					System.out.println("Enter the second paticipant name:");
					String part2=sc.next();
					System.out.println("Enter your team name:");
					String teamname=sc.next();
					ps.setString(1,college);
					ps.setString(2,event);
					ps.setString(3, part1);
					ps.setString(4, part2);
					ps.setString(5, mail);
					ps.setString(6, teamname);
					int rows=ps.executeUpdate();
					if(rows>0){
						System.out.println("You have been registered successfully");
					}
					else{
						System.out.println("There is some problem with your registration or"+teamname+"is already taken\n Please try again");
					}
				}	
			}
			else if(choice==2){
				System.out.println("Enter your registration number:");
				int num=sc.nextInt();
				System.out.println("Enter your mail id:");
				String mail=sc.next();
				String query="SELECT*FROM eventinfo WHERE Reg_no="+num+" AND Mail='"+mail+"';";
				ResultSet res=st.executeQuery(query);
				if(res.next()){
					System.out.println("What to you want to change\n1.College_name\n2.Event_name\n3.Participant_1\n4.participant_2\n5.Team_name");
					int edit=sc.nextInt();
					if(edit==1){
						String queryup="UPDATE eventinfo SET College_name=? WHERE Reg_no=?";
						PreparedStatement ps1=con.prepareStatement(queryup);
						System.out.println("Enter your college name:");
						String college=sc.next();
						ps1.setString(1, college);
						ps1.setInt(2,num);
						int rows=ps1.executeUpdate();
						if(rows>0){
						System.out.println("Updated successfully");}
						else{
							System.out.println("The update has failed");
						}
					}
					else if(edit==2){
						String queryup="UPDATE eventinfo SET Event_name=? WHERE Reg_no=?";
						PreparedStatement ps1=con.prepareStatement(queryup);
						System.out.println("Enter Event name:");
						String event=sc.next();
						ps1.setString(1, event);
						ps1.setInt(2,num);
						int rows=ps1.executeUpdate();
						if(rows>0){
						System.out.println("Updated successfully");}
						else{
							System.out.println("The update has failed");
						}
					}
					else if(edit==3){
						String queryup="UPDATE eventinfo SET Part1_name=? WHERE Reg_no=?";
						PreparedStatement ps1=con.prepareStatement(queryup);
						System.out.println("Enter Part1 name:");
						String name=sc.next();
						ps1.setString(1, name);
						ps1.setInt(2,num);
						int rows=ps1.executeUpdate();
						if(rows>0){
						System.out.println("Updated successfully");}
						else{
							System.out.println("The update has failed");
						}
					}
					else if(edit==4){
						String queryup="UPDATE eventinfo SET Part2_name=? WHERE Reg_no=?";
						PreparedStatement ps1=con.prepareStatement(queryup);
						System.out.println("Enter Part2 name:");
						String name=sc.next();
						ps1.setString(1, name);
						ps1.setInt(2,num);
						int rows=ps1.executeUpdate();
						if(rows>0){
						System.out.println("Updated successfully");}
						else{
							System.out.println("The update has failed");
						}
					}
					else if(edit==5){
						String queryup="UPDATE eventinfo SET Team_name=? WHERE Reg_no=?";
						PreparedStatement ps1=con.prepareStatement(queryup);
						System.out.println("Enter Team name:");
						String tname=sc.next();
						ps1.setString(1, tname);
						ps1.setInt(2,num);
						int rows=ps1.executeUpdate();
						if(rows>0){
						System.out.println("Updated successfully");}
						else{
							System.out.println("The update has failed");
						}
					}
				}
				else{
					System.out.println("Please enter your correct credentials to edit");
				}
			}
			else if(choice==3){
				String query="DELETE FROM eventinfo WHERE Reg_no=?";
				PreparedStatement ps=con.prepareStatement(query);
				System.out.println("Enter the your registration number to delete your event participation");
				int num=sc.nextInt();
				ps.setInt(1,num);
				int row=ps.executeUpdate();
				if(row>0){
					System.out.println("your registrations has been cancelled successfully");
				}
				else{
					System.out.println("Something went wrong");
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

