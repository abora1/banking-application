import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class DisplayDetails {
	JFrame f;
void showUIDetails(String name, String accno){

}
String accno;
void accountDisplay(String accno)
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
			String query = "select * from customer where accno = ?";
			String name=null;
			String accountno=null;
			pstmt = conn.prepareStatement(query); // create a statement
			  pstmt.setString(1, accno); // set input parameter
			  rs= pstmt.executeQuery();
			  //DisplayDetails dd=new DisplayDetails();
			  // extract data from the ResultSet
			  while (rs.next()) {
				name = rs.getString(1);
				String date = rs.getString(2);
				String address = rs.getString(3);
				String dob = rs.getString(4);
				String accounttype = rs.getString(5);
				String gender = rs.getString(6);
				accountno = rs.getString(7);

				f=new JFrame();

				String data[][]={{accno,name,date,address,dob,accounttype,gender}};

				String column[]={"Account Number","Name","Date of Registration","Address","Date of Birth","Account Type","Gender"};

				JTable jt=new JTable(data,column);
				jt.setBounds(30,40,200,300);

				JScrollPane sp=new JScrollPane(jt);
				f.add(sp);

				f.setSize(300,400);
			//	f.setLayout(null);
				f.setVisible(true);}


			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
