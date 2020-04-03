import java.sql.*;
public class DeleteDemo {
	public static void main(String[] args)

	{

		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt= 0;
		try{	//Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//open a connection
			System.out.println("Connecting to database ");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc","root","root");
			String sql = "Delete from candidates where rtrim(last_name) like 'Y%'; ";
			System.out.println(" ");
			stmt = con.createStatement();
			cnt= stmt.executeUpdate(sql);
			if(cnt>0){
				System.out.println("Record for young is deleted ");
			}
			con.close();

		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}