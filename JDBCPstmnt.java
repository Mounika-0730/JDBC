import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class JDBCPstmnt {

		//private static int count;

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Connection con = null;
			try (ResultSet rs = null) {
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PreparedStatement pstmt=null;
			
			//1.load the driver
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String url ="jdbc:mysql://localhost:3306/dbone";
				String un="root";
				String pwd="root";
				
				//2.Get the connection via driver
				con=DriverManager.getConnection(url, un, pwd);
				
				//3.issue sql query
				String qry="insert into student values(3,'love',25)";
				pstmt=con.prepareStatement(qry);
				
				int count = pstmt.executeUpdate();
				
				//4.process the results
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					if(con!=null) {
						con.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				try {
					if(pstmt!=null) {
						pstmt.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		}
	}
