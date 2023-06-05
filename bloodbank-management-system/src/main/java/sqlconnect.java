import java.sql.*;
public class sqlconnect {
	public Connection connect() {
		Connection db= null;
		try {
			db = DriverManager.getConnection("jdbc:postgresql://localhost/bloodbank", "postgres", "987987");
			if(db!=null)
				System.out.println("Connected!");
			}catch(Exception e) {
				System.out.println(e);
			}
		return db;
	}
	public static void main(String[] args) {
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st;
		String query="";
		try {
		st = con.createStatement();
		query = "Select * from blood_bank";
		//System.out.println(st.executeQuery(query));
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
		    System.out.print("Column 1 returned ");
		    System.out.println(rs.getString(1));
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
