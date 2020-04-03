import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class InsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt= 0;
		try{	//Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//open a connection
			System.out.println("Connecting to database ");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc","root","root");
			String str = "INSERT INTO skills(name)" + "VALUES('css')";
			stmt = con.createStatement();
			int rowcount = stmt.executeUpdate(str);
			if(rowcount>0)
			{
				System.out.println("Record inserted successfully ");
			}
			String str1 = "select count(id) from skills";
			rs= stmt.executeQuery(str1);
			while(rs.next())
			{
				cnt =rs.getInt(1);
			}
			System.out.println("Total numbr of records is : "+cnt);
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
