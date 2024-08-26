import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class JDBCfirst {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			
			//1.Load the Driver
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				String url="jdbc:mysql://localhost:3306/dbone";
				
				Properties props=new Properties();
				props.put("user", "root");
				props.put("password", "root");
				
				
				//2.get the connection via Driver by using properties info
				con=DriverManager.getConnection(url, props);
				
				//3.issue sql query via connection
				String qry="select * from student";
				stmt=con.createStatement();
				rs=stmt.executeQuery(qry);
				
				//4.process the results returned by sql queries
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String age=rs.getString("age");
//					String ln=rs.getString("lastname");
					
					System.out.println("id :"+id);
					System.out.println("name :"+name);
					System.out.println("age :"+age);
//					System.out.println("LastName :"+ln);
					
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					if(con!=null) {
						con.close();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				try {
					if(stmt!=null) {
						stmt.close();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				try {
					if(rs!=null) {
						rs.close();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}


