package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public final class Clerk extends Employee{
	Clerk(String name,int age){
	    super(name,age,"Clerk",15000);
	    
	}
	public int raiseSalary() {
		int i=0;
		try{Class.forName("com.mysql.jdbc.Driver");  
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","tiger");
	     Statement st=con.createStatement();
	     int c=st.executeUpdate("update employee set salary=salary+3000 where designation='Clerk'");
	     i=1;
	     con.close();
	}finally
		{
		return i;
		}
}

}
