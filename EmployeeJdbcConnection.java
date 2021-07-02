package employee;

import java.sql.*;
import java.util.*;
public class EmployeeJdbcConnection {

	public static void main(String[] args) {

		int choice=0,select=0;
		Scanner scan= new Scanner(System.in);
		try{Class.forName("com.mysql.jdbc.Driver");  
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","tiger");
		     Statement st=con.createStatement();
		     ResultSet rs=null;
		     do {
		    	 System.out.println("1.Create an Employee \n2.Display all Employees \n3.Raise the salaries of all Employees \n4.Exit \nEnter your choice");
		       choice=scan.nextInt();
		       if(choice==4) break;
		       switch(choice){
		       case 1: do { System.out.println("You would like to create \n1.Manager \n2.Clerk \n3.Programmer \n4.Quit");
		               select=scan.nextInt();
		              if(select==4) break;
		              System.out.println("Enter name");
		              String name=scan.next();
		              System.out.println("Enter age");
		              int age=scan.nextInt();
		              switch(select) {
		              case 1 :   Employee m=new Manager(name,age);
		                         m.create();
		                         break;
		              case 2:    Employee c= new Clerk(name,age);
		                         c.create();
		                         break;
		              case 3 :   Employee p= new Programmer(name,age);
		                         p.create();
		                         break;
		              default:   System.out.println("Invalid selection!");
		                         
		              }
		            }while(select!=4);
		             break;
		     case 2:      rs=st.executeQuery("select * from employee");
		                  while(rs.next()) {
		                	  System.out.println("-----------------------------------------------------------------------------------------");
		                	  System.out.println("    EmpId : "+rs.getInt(1)+" | Name : "+rs.getString(2)+" | Age : "+rs.getInt("age")+" | Designation : "+
		                	  rs.getString("designation")+" | Salary :"+rs.getInt("salary"));
		                	  System.out.println("-----------------------------------------------------------------------------------------");
		                  }
		                  break;
		     case 3:      rs=st.executeQuery("select * from employee");
		                  while(rs.next()) {
		                	  if(rs.getString("designation").equals("Manager")) {
		                		  Manager m1= new Manager(rs.getString("name"),rs.getInt("age"));
		                		  m1.raiseSalary();
		                	  }
		                	  if(rs.getString("designation").equals("Clerk")) {
		                		  Clerk m1= new Clerk(rs.getString("name"),rs.getInt("age"));
		                		  m1.raiseSalary();
		                	  }
		                	  if(rs.getString("designation").equals("Programmer")) {
		                		  Programmer m1= new Programmer(rs.getString("name"),rs.getInt("age"));
		                		  m1.raiseSalary();
		                	  }
		                	  
		                  }
		                  break;
		      default: System.out.println("Invalid Choice!");
		     }          
		     
		            
		     }while(choice!=4);
		     con.close();
		}catch(Exception e) { e.printStackTrace();}
	}

}