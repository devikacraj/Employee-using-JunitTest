package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

abstract public class Employee {
	String name;
	int age;
	String job;
	int sal;
	
	Employee(String n,int a, String j,int s){
		name=n;
		age=a;
		job=j;
		sal=s;
	}
abstract public int raiseSalary();
	public String create() {
		
		Connection con=null;
		Statement st=null;
		try{Class.forName("com.mysql.jdbc.Driver");  
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","tiger");
	    st=con.createStatement();
	    st.executeUpdate("insert into employee(name,age,designation,salary) values('"+this.name+"',"+this.age+",'"+this.job+"',"+this.sal+");");
	     return "created";
	}catch(Exception e) {e.printStackTrace();
	                       return "not created";}
		
	}	
	

}