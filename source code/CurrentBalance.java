import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class CurrentBalance {
	JFrame f;

String accno;
void balanceDisplay(String accno)
	{
		//System.out.println(accno);
		try
		{
			Properties p=new Properties();
			p.load(new FileInputStream("jdbc.properties"));
			String driverstr=p.getProperty("driver");
			Class.forName(driverstr);
			String urlstr=p.getProperty("url");
			Connection conn=DriverManager.getConnection(urlstr,p);
			System.out.println("Successfully connected");
			ResultSet rs=null;
			PreparedStatement pstmt =null;
			String query = "select Accbal from customer where accno = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			  pstmt.setString(1, accno); // set input parameter
			  rs= pstmt.executeQuery();
			  //DisplayDetails dd=new DisplayDetails();
			  // extract data from the ResultSet
			  while (rs.next()) {

				String currentbalance = rs.getString(1);

				JOptionPane.showMessageDialog(null,"Current Balance:"+currentbalance);
				}


			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
