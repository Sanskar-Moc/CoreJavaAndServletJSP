import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCDemo1 {

	public static MysqlDataSource getDataSource() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		// sets server name
		ds.setServerName("localhost");
		// sets port
		ds.setPort(3306);
		// sets database
		ds.setDatabaseName("empmgmt");
		// sets user
		ds.setUser("root");
		//set password
		ds.setPassword("password");
		//Server Timezone helps the server know how to handle dates and times correctly.
		ds.setServerTimezone("America/Chicago");
		// Use SSL toggles SSL encryption. We would typically set this to true, but for our local development, 
		// it would be overkill to set up the infrastructure. We default to false for this activity.
		ds.setUseSSL(false);
		//Allow Public Key Retrieval allows our JDBC driver to send the password to our database securely.
		ds.setAllowPublicKeyRetrieval(true);
		
		return ds;
		
	}
	public static void display(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println(rs.getString("deptid")+"\t"+rs.getString("dname")+"\t"+rs.getString("loc"));
		}
	}
	public static void displayMetaData(ResultSet rs) throws SQLException {
		ResultSetMetaData rsm=rs.getMetaData();
		int n=rsm.getColumnCount();
		for(int i=1;i<=n;i++) {
			System.out.print(rsm.getColumnName(i)+"\t");
		}
		System.out.println();
	}
	public static void insertRecord(int id,String dep,String loc) throws SQLException {
//		String insert="INSERT INTO dept VALUES("+id+",'"+dep.toUpperCase()+"','"+loc.toUpperCase()+"')";
		Connection con=getDataSource().getConnection();
//		Statement stat=con.createStatement();
		PreparedStatement pstat=con.prepareStatement("INSERT INTO DEPT(DEPTID,DNAME,LOC) VALUES(?,?,?);"); //?  = PLACEHOLDER
		pstat.setInt(1, id);
		pstat.setString(2, dep.toUpperCase());
		pstat.setString(3, loc.toUpperCase());
		boolean n =pstat.execute();
//		int n =stat.executeUpdate(insert);
		System.out.println("rows inserted :"+!n);
	}
	public static void displayRecords() throws SQLException {
		String select="select * from dept;";
		Connection con=getDataSource().getConnection();
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery(select);
		displayMetaData(rs);
		display(rs);
	}
	public static void updateRecord(int id,String what, String value ) throws SQLException {
//		String update= "update dept set loc = 'Mumbai' where deptid = 80";
		Connection con=getDataSource().getConnection();
		PreparedStatement pstat=con.prepareStatement("update dept set "+what+" = ? where deptid =?"); //?  = PLACEHOLDER
//		pstat.setString(1, what);
		pstat.setString(1, value.toUpperCase());
		pstat.setInt(2, id);
		boolean n =pstat.execute();
		System.out.println("record updated :"+!n);
	}
	public static void deleteRecord(int id) throws SQLException {
		Connection con=getDataSource().getConnection();
		PreparedStatement pstat=con.prepareStatement("delete from dept where deptid = ?"); //?  = PLACEHOLDER
		pstat.setInt(1, id);
		boolean n =pstat.execute();
		System.out.println("record deleted :"+!n);
	}
	public static void main(String[] args) {
		try {
			displayRecords();
//			insertRecord(80, "TECH", "KANPUR");
//			updateRecord(60, "dname","tech");
//			deleteRecord(70);
			displayRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
