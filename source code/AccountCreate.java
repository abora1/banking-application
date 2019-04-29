import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

class AccountCreate
{
	String name,date,address,dateofbirth,accounttype,gender;
  	void setAccountCreate(String name, String date, String address, String dateofbirth, String accounttype, String gender)
  	{
		this.name=name;
		this.date=date;
		this.address=address;
		this.dateofbirth=dateofbirth;
		this.accounttype=accounttype;
		this.gender=gender;
  	}
  	void getAccountCreate()
  	{
		System.out.println(name);
		System.out.println(date);
		System.out.println(address);
		System.out.println(dateofbirth);
		System.out.println(accounttype);
		System.out.println(gender);
	}
	void createNewAccount()
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
			String str="Insert into customer values(?,?,?,?,?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(str);

			String accno=JOptionPane.showInputDialog("Allocate 10 digit account number");
			st.setString(1,name);
			st.setString(2,date);
			st.setString(3,address);
			st.setString(4,dateofbirth);
			st.setString(5,accounttype);
			st.setString(6,gender);
			st.setString(7,accno);
			st.setString(8,"1000");

			st.executeUpdate();
			conn.commit();

			System.out.println("Values inserted");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error thrown "+e);
		}
	}

  /*public static void main(String args[])
  {
	  AccountCreate ac=new AccountCreate();
	  ac.setAccountCreate("name","date","address","dateofbirth","accounttype","gender");
	  ac.getAccountCreate();
	}*/
}