import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
class UserOperations
{
String accno;
String amount;
String accno1;
String amount1;

void deposit(String accno,String amount)
	{
		this.accno=accno;
		this.amount=amount;
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
					String str="Update customer set Accbal=Accbal+? where accno=?";
					PreparedStatement st=conn.prepareStatement(str);
					st.setString(1,amount);
					st.setString(2,accno);
					st.executeUpdate();
					String query = "select Accbal from customer where accno =?";
					PreparedStatement st1=conn.prepareStatement(query);
					st1.setString(1,accno);
					ResultSet rs=null;
					rs= st1.executeQuery();
					while (rs.next()) {
					String Balance = rs.getString(1);
					//System.out.println("The current Balance after Deposit is:"+Balance);
					JOptionPane.showMessageDialog(null,"Current Balance After Deposit: "+Balance);
					}
					st1.executeQuery();
					conn.commit();

					System.out.println("Amount inserted");
					conn.close();
				}
				catch(Exception e)
				{
					System.out.println("Error thrown "+e);
		}
	}
	void withdraw(String accno1,String amount1)
		{
			this.accno1=accno1;
			this.amount1=amount1;
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
						String str="Update customer set Accbal=Accbal-? where accno=? and Accbal>1000 and Accbal>?";
						PreparedStatement st=conn.prepareStatement(str);


						st.setString(1,amount1);
						st.setString(2,accno1);
						st.setString(3,amount1);
						st.executeUpdate();
						//st.setString(2,accno);
						String query = "select Accbal from customer where accno =?";
						PreparedStatement st1=conn.prepareStatement(query);
						st1.setString(1,accno1);
						ResultSet rs=null;
						rs= st1.executeQuery();
                        while (rs.next()) {
						String Balance = rs.getString(1);
						JOptionPane.showMessageDialog(null,"Current Balance After Withdrawal: "+Balance);
						}


						st1.executeQuery();
						conn.commit();

						System.out.println("Amount Withdrawn");
						conn.close();
					}
					catch(Exception e)
					{
						System.out.println("Error thrown "+e);
			}
	}
}
