import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

class AccountDelete
{
	String accno;
	void setAccountDelete(String accno)
	  	{
			this.accno=accno;

  	}
  	void getAccountDelete()
  	{
		System.out.println(accno);
	}
  	void deleteacc()
  	{
		try
				{
					Properties p=new Properties();
					p.load(new FileInputStream("jdbc.properties"));
					String driverstr=p.getProperty("driver");
					Class.forName(driverstr);
					String urlstr=p.getProperty("url");
					Connection conn=DriverManager.getConnection(urlstr,p);
					System.out.println("Successfully connected");
					conn.setAutoCommit(false);
					String deleteSQL = "DELETE from customer WHERE accno = ?";
					PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
					preparedStatement.setString(1, accno);
					// execute delete SQL stetement
					preparedStatement.executeUpdate();
					conn.commit();

					System.out.println("Values inserted");
					conn.close();
				}
				catch(Exception e)
				{
					System.out.println("Error thrown "+e);
		}
	}


}