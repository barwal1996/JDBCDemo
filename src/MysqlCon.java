import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MysqlCon {
	public static void main(String[] args)
	{
		try{	//Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//open a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","root");
			Statement stmt = con.createStatement(); // Executing a query
			ResultSet rs = stmt.executeQuery("SELECT city, COUNT(*) FROM employees e, offices o WHERE e.officeCode = o.officeCode GROUP BY city");
			while(rs.next()) //Extract data from Result set
				System.out.println(rs.getString(1)+ "        "+rs.getInt(2));
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
