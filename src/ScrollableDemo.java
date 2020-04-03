import java.sql.*;
public class ScrollableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		try{	//Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//open a connection
			System.out.println("Connecting to database ");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","root");
			 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 rs= stmt.executeQuery("select *From customers LIMIT 20");
			 rs.afterLast();
			 while(rs.previous())
			 {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2));
			 }
			 System.out.println("************************");
			 rs.absolute(3);
			 System.out.println(rs.getInt(1)+ "  " +rs.getString(2));
			 System.out.println("********************" ); //move the cursor to 2nd record using relative()
			 rs.relative(-1);
			 System.out.println(rs.getInt(1)+ "  " +rs.getString(2));
			 System.out.println("********************" ); 
			 int i= rs.getRow(); //get cursor position
			 System.out.println("cursor position = "+i);
		
			 //cleanup
			 rs.close();
			 stmt.close();
			 con.close();
		}
		catch(Exception e){
			System.out.println(e);
	}
		}

}
