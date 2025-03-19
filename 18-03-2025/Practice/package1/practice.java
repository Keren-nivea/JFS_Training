package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.Statement;

public class practice {

	public static void main(String[] args){
		String query="SELECT*FROM Users WHERE User_id=3333;";
		String query2="SELECT*FROM Users;";
		String query3="SELECT*FROM Users WHERE Pass_word="+"'nivea2004';";
		String url="jdbc:mysql://localhost:3306/testdb";
		String user="root";
		String password="root";
		try {
			Connection con=DriverManager.getConnection(url,user,password);		//Connection is a data type
			System.out.println("Connection established successfully");
			java.sql.Statement st= con.createStatement();
			ResultSet result=st.executeQuery(query);
			result.next();
			int id=result.getInt("User_id");
			String email=result.getString("Gmail");
			String pass_word=result.getString("pass_word");
			System.out.println();
			System.out.println("Id:"+id+"\nGmail:"+email+"\nPassword:"+pass_word);
//			java.sql.Statement st1=con.createStatement();
			ResultSet result2=st.executeQuery(query2);
			
			while(result2.next()){
				int id2=result2.getInt("User_id");
				String email2=result2.getString("Gmail");
				String pass_word2=result2.getString("pass_word");
				System.out.println();
				System.out.println("Id:"+id2+"\nGmail:"+email2+"\nPassword:"+pass_word2);
			}
			System.out.println("-----------------------------");
			ResultSet result3=st.executeQuery(query3);
			while(result3.next()){
				int id2=result3.getInt("User_id");
				String email2=result3.getString("Gmail");
				String pass_word2=result3.getString("pass_word");
				System.out.println();
				System.out.println("Id:"+id2+"\nGmail:"+email2+"\nPassword:"+pass_word2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
