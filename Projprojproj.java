import  java.util.InputMismatchException;  
import java.util.Scanner ;
import java.sql.*;
       


public class projprojproj2 {

    public static void main(String[] args){


	Scanner input = new Scanner(System.in) ;


Connection connection = null;

String url = "jdbc:mariadb://localhost:3306/proj";

String user = "root";

String pwd = "";
 
try {
	connection = DriverManager.getConnection(url, user, pwd); 
Statement stmt = connection.createStatement();

 


boolean k = false ;
while (k==false){
     System.out.println("Table Centre");
                 System.out.println("1) Insert new record");
 System.out.println("2) Display all records");                    
               System.out.println("3) Exit");
            System.out.println("Choose an operation");
            int inp = input.nextInt();
            
             int c= 0;
ResultSet rs = null;
ResultSet chec = null;
boolean check = false ; 
            switch(inp){///sw
            
            case 1 :{
            	
        		while(check == false) {
            	try {
            		chec = stmt.executeQuery("SELECT * FROM Center"); 
            		
            	System.out.println("Enter the center number");
            	int CN = input.nextInt();
            	while(chec.next()) {
               	 
                	if ( chec.getInt("Center_No")== CN ) {
                		
                		System.out.print("primary key dublicated enter again"); 
                	CN = input.nextInt();
                	break ; }
                	}
           
            	                     System.out.println("Enter the center working time ");
            	int WT = input.nextInt();
            	      
            	                     System.out.println("Enter the center working day ");
            	String WD = input.next();
            	                                       System.out.println("Enter the center city");
            	                                      
            	String C = input.next();


            	                                                                       System.out.println("Enter the center street");
            	                                                      
            	String STR = input.next();
            	                                                                                                       System.out.println("Enter the center postcode");
            	int PC = input.nextInt();
            	rs = stmt.executeQuery("SELECT * FROM Center");
            	

            	String sql = "INSERT INTO Center VALUES("+CN+",'"+WT+"','"+WD+"','"+C+"','"+STR+"',"+PC+")";

            	stmt.executeUpdate(sql);



            	}catch(InputMismatchException  f ){
            	    System.out.println("enter the correct data type ");

            	}
            	c++ ; 
            	System.out.println("Do you want to insert new recored ( Y | N)?");
            	char answer = input.next().charAt(0);
            	if (answer == ('n') || answer == ('N')) {
            	check = true ;
            	break ;
            	}}
            	 
            	}//CASE ONE 


break ;
case 2 :{        
	rs = stmt.executeQuery("SELECT * FROM Center"); 
while(rs.next()) {

System.out.print(rs.getInt("Center_No") + "\t");

System.out.print(rs.getString("Working_Time") + "\t");

System.out.print(rs.getString("Working_Day") + "\t");

System.out.print(rs.getString("City") + "\t");

System.out.print(rs.getString("Street") + "\t");


System.out.print(rs.getInt("PostCode") + "\t");

System.out.println();

}


stmt.close();

connection.close();

}//CASE 2

break;




case 3:{
  
    System.out.println("bye ");
    k=true ;
    break ; 
}

}///SWWW

} }catch (SQLException e) {

 e.printStackTrace();
		
    
	 }





   }}

   

