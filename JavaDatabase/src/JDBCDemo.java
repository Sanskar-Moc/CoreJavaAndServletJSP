import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		//1. load and register the JDBC driver(type 4)
		//2. get the connection object by passing URL,username,Password
		//3. get the Statements from the Connection
		//4. get the ResultSet from Statement
		//5. print the result
		
		Connection conn=null;
		try {
			// all the imports should be from java.sql package
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt?useSSL=false","root","password");
			System.out.println("connection object is "+conn);
			Statement stat=conn.createStatement();
			String insert="INSERT INTO dept VALUES(70,'TECH','PUNE')";
//			int n =stat.executeUpdate(insert);
//			System.out.println("no. of rows inserted are "+n);
			String select="SELECT * FROM dept";
			String update="update dept set loc='MUMBAI' where deptid=50";
			String delete="delete from dept where deptid = 70";
//			stat.executeUpdate(update); // update query fired
			stat.executeUpdate(delete); // delete query will fire
			ResultSet rs=stat.executeQuery(select);
			displayMetaData(rs);
			display(rs);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void display(ResultSet rs) {
		try {
			while(rs.next()) {
				System.out.println(rs.getString("deptid")+" "+rs.getString("dname")+" "+rs.getString("loc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void displayMetaData(ResultSet rs) {
		try {
			ResultSetMetaData rsm=rs.getMetaData();
			int n=rsm.getColumnCount();
			for(int i=1;i<=n;i++) {
				System.out.print(rsm.getColumnName(i)+" ");
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
