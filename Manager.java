package employee;

import java.sql.DriverManager;
import java.sql.*;

public final class Manager extends Employee {
	Manager(String name,int age){
	    super(name,age,"Manager",30000);
	    
	}
	public int raiseSalary() {
		int i=0;
		try{Class.forName("com.mysql.jdbc.Driver");  
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","tiger");
	     Statement st=con.createStatement();
	     int c=st.executeUpdate("update employee set salary=salary+7000 where designation='Manager'");
	     i=1;
		}
		finally
		{ 
			return i;
		}
}
}

