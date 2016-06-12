import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class CalendarRnD {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(c.getTimeInMillis());
		System.out.println(c.getTimeInMillis());
		
		System.out.println(c2.getTime());
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybaby", "root", "root");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from Timer");
			while(rs.next()){
				Timestamp ts = rs.getTimestamp(1);
				c2.setTimeInMillis(ts.getTime());
				System.out.println("hello timestamp " + rs.getTimestamp(1)+"c2 = ");
				
				//c2.setTimeInMillis(rs.getTimestamp(1));
				//System.out.println("c2 time "+c2.getTime());
			}
			/*Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			//st.execute("insert into Timer values("+startDate.getTime()+")");
			 calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		     
			 String sqlTimestampInsertStatement = "INSERT INTO Timer (datetime) VALUES (?)";
			    PreparedStatement preparedStatement = connection.prepareStatement(sqlTimestampInsertStatement);
			    preparedStatement.setTimestamp(1, ourJavaTimestampObject);
			 
			    // (4) execute the sql timestamp insert statement, then shut everything down
			    preparedStatement.executeUpdate();
			    preparedStatement.close();
			    
			//connection.commit();*/
			
			Date date = new Date();
			System.out.println("current day = "+date.toLocaleString());
			long prevto10days = date.getTime()-10*24*60*60*1000;
			Timestamp timestamp = new Timestamp(prevto10days);
			System.out.println("10 day prev = "+timestamp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
