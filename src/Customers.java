
import java.sql.*;
//import java.util.*;
import java.util.Scanner;

public class Customers {
	 Connection con;
	 Statement st;
	 ResultSet res;
	 PreparedStatement ps;
	 
	Customers()
	{
		con = null;
	}
	
	public Connection getConnection()
	{
		 try 
		  {
			//load the driver class  
			 Class.forName("com.mysql.cj.jdbc.Driver");  
				//create  the connection object 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc","root","root"); 
		  } 
		  catch (Exception e) 
		  {
		  System.out.println("Error in connection" + e);
		  }
		 return con;
	}
	
	public void insertCustomer(int CustId,String name, String city, String contact) {
		try {
			con = getConnection();
		    ps = con.prepareStatement("insert into customer values"
		    		+ "(?,?,?,?)");
		    ps.setInt(1, CustId);
		    ps.setString(2, name);
		    ps.setString(3, city);
		    ps.setString(4, contact);
		   
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("Inserted");
		    } else {
		        System.out.println("not Inserted");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		}
	
	public void getCustomer() 
	{
	  try {
	   con = getConnection();
	   st = con.createStatement();
	   res = st.executeQuery("select * from customer order by custId");
	   System.out.println("CustId\t CustomerName\t City \t\t Contact No");
	   System.out.println("-----------------------------------------------------------");
	  while (res.next()) 
	  {
	    System.out.print(res.getInt(1)+"\t");
	    System.out.print(res.getString(2)+"\t\t");
	    System.out.print(res.getString(3)+"\t\t");
	    System.out.println(res.getString(4));
	  }
	  System.out.println("-----------------------------------------------------------");
	  res.close();
	  con.close();
	  } 
	  catch (Exception e) 
	  {
	  System.out.println("Error in fetching data" + e);
	  }
	}
	
	public void updateCustomer(int CustId,String city) 
	{
		try {
			 con = getConnection();
		    ps = con.prepareStatement("update customer"
		    		+ " set city=? where custId=?");
		    ps.setString(3, city);
		    ps.setInt(1,CustId);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("City updated");
		    } else {
		        System.out.println("not updated");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void deleteCustomer(int CustId) 
	{
		try {
			con = getConnection();
		    ps = con.prepareStatement("delete from customer where custId=?");
		    ps.setInt(1, CustId);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("Customer deleted");
		    } else {
		        System.out.println("Customer Doesn't Exist");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Customers c=new Customers();
		String city;
		int CustId;
		
		System.out.println("************** Global Tech Solutions **************");
		System.out.println("----------- Customer Management System ----------");
		while(true)
		{
		System.out.println("Press 1 for New Customer \t Press 2 to Display Customers");
		System.out.println("Press 3 for Update Customer \t Press 4 to Delete Customer");
		System.out.println("Press 5 for Exit"); 
			
		Scanner s=new Scanner(System.in);
		int option=s.nextInt();
		
		switch(option)
		{
		case 1: System.out.println("Enter custID,Customer Name, City & Contact no :");
				CustId = s.nextInt();
		        String name=s.next();
		        city=s.next();
		        String contactno=s.next();
			    c.insertCustomer(CustId,name,city,contactno);
			    break;
		case 2: c.getCustomer();
				break;
		case 3: System.out.println("Enter CustomerId & City to be Updated:");
        		CustId=s.nextInt();
        		city=s.next();
				c.updateCustomer(CustId,city);
				break;
		case 4: System.out.println("Enter CustomerId  to be Deleted:");
				CustId=s.nextInt();
				c.deleteCustomer(CustId);
				break;
		case 5: System.out.println("Program Terminated");
		 		System.exit(0);
		
		default: System.out.println("Invalid Selection");
		          break;
		}
		
		
		}
	}

}