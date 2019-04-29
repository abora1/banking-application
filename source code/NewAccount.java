import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class NewAccount
{
	public static void main(String args[])
	{
		NewAccount n=new NewAccount();
	}
    NewAccount()
    {
        newacc na = new newacc();
        na.newaccgui();
    }
}

class newacc extends JFrame
{
    private JButton ADD;
    private JButton CANCEL;
    private JTextField NAME;
    private JTextField DATE;
    private JTextField ADDRESS;
    //private JTextField AGE;
    private JTextField DATE_OF_BIRTH;
    private JTextField ACCOUNT_TYPE;
    private JTextField GENDER;

    private JPanel jpanel1;
    private JPanel jpanel2;
    private JPanel jpanel3;
    private JPanel jpanel4;
    private JPanel jpanel5;

    private JLabel jlabell;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JLabel jlabel4;
    //private JLabel jlabel5;
    private JLabel jlabel6;
    private JLabel jlabel7;
    private JLabel jlabel8;

   // Database db = new Database();

    public void newaccgui()
    {
        System.out.println("New Account Creation");
        jlabel2 = new JLabel("Name");
        jlabel3 = new JLabel("Date");
        jlabel4 = new JLabel("Address");
        //jlabel5 = new JLabel("AGE");
        jlabel6 = new JLabel("Year of birth");
        jlabel7 = new JLabel("Account Type");
        jlabel8 = new JLabel("Gender");

        Date now = new Date();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
        String date = df1.format(now);

        ADD = new JButton("ADD");
        CANCEL = new JButton("CANCEL");
        NAME = new JTextField(25);
        DATE = new JTextField(date);
        ADDRESS = new JTextField(25);
        //AGE = new JTextField(3);
        DATE_OF_BIRTH = new JTextField(20);
        ACCOUNT_TYPE = new JTextField(10);
        GENDER = new JTextField(8);

        jpanel1 = new JPanel();
        jpanel1.setLayout(new GridLayout(10,10,10,10));
        //jpanel1.add(jlabell);

        jpanel2 = new JPanel();
        jpanel2.setLayout(new GridLayout(7,5,31,31));
        jpanel2.add(jlabel2);
        jpanel2.add(jlabel3);
        jpanel2.add(jlabel4);
        //jpanel2.add(jlabel5);
        jpanel2.add(jlabel6);
        jpanel2.add(jlabel7);
        jpanel2.add(jlabel8);


        jpanel3 = new JPanel();
        jpanel3.setLayout(new GridLayout(7,5,31,31));
        jpanel3.add(NAME);
        jpanel3.add(DATE);
        jpanel3.add(ADDRESS);
        //jpanel3.add(AGE);
        jpanel3.add(DATE_OF_BIRTH);
        jpanel3.add(ACCOUNT_TYPE);
        jpanel3.add(GENDER);

        jpanel4 = new JPanel();
        jpanel4.setLayout(new FlowLayout());
        jpanel4.add(ADD);
        jpanel4.add(CANCEL);

        jpanel5 = new JPanel();
        jpanel5.setLayout(new FlowLayout());
        jpanel5.add(jpanel2);
        jpanel5.add(jpanel3);
        //jpanel5.add(jpanel6);
        //jpanel5.add(jpanel7);
        //jpanel5.add(jpanel8);


        Container container1 = getContentPane();
        container1.setLayout(new FlowLayout());

        container1.add(jpanel1);

        Container container2 = getContentPane();
        container2.setLayout(new FlowLayout());

        container2.add(jpanel5);

        Container container3 = getContentPane();
        container3.setLayout(new FlowLayout());

        container3.add(jpanel4);

        setTitle("New Account Creation");
        setBounds(400,300,570,450);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ADD.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

				LocalDateTime now = LocalDateTime.now();
				int year = now.getYear();
				int dobyear=Integer.parseInt(DATE_OF_BIRTH.getText());
				int diff=year-dobyear;
				if(diff<18)
				{
					JOptionPane.showMessageDialog(null,"Age is below 18 years");
				}
				else
				{
					AccountCreate ac=new AccountCreate();
					ac.setAccountCreate(NAME.getText(),DATE.getText(),ADDRESS.getText(),DATE_OF_BIRTH.getText(),ACCOUNT_TYPE.getText(),GENDER.getText());
					ac.getAccountCreate();
					ac.createNewAccount();

				}
				setVisible(false);
                MainMenu mm=new MainMenu();
                mm.menu();
            }
        });

        CANCEL.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                setVisible(false);
                MainMenu mm=new MainMenu();
                mm.menu();
            }
        });
    }
}

