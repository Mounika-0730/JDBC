import java.sql.*;  
public class Firstjdbc {

	
		// TODO Auto-generated method stub
		
		
		public static void main(String args[]){  
		try{  
			System.out.println("1.Load the driver ");
		Class.forName("com.mysql.jdbc.Driver");  
		
		System.out.println("2. Get db connection via driver");
		
		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/example","root","root");  
		//here example is database name, root is username and password  
		
		System.out.println("3.Issue sql query via connection");
		
		Statement stmt=con.createStatement(); 
		
		System.out.println("Inserting Records:");	
		
		System.out.println("4. Process resultset");
		
		ResultSet rs=stmt.executeQuery("select * from book");  
		//String sql="Insert into book values(43)";
		//stmt.executeUpdate(sql);
	while(rs.next())  
		
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
	System.out.println("5. Close all jdbc connections");
	con.close();  
		}catch(Exception e){ 
			System.out.println(e);}  
		}  
}
