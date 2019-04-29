
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserAction
{
	public static void main(String args[])
	{
		UserAction u=new UserAction();
	}
	UserAction ()
	{
      		UInfo UI = new UInfo();
        	UI.Display1();
    	}
}

class UInfo extends JFrame
{

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JTextField Account_Num;

    private JButton AccountInfo;
    private JButton Deposit;
    private JButton Withdraw;
    private JButton Current_Transaction;

    private JPanel jpanel1;
    private JPanel jpanel2;
    private JPanel jpanel3;
    private JPanel jpanel4;

   // Database db = new Database();
   // Display2 d2 = new Display2();

    public void Display1()
    {

        jlabel2 = new JLabel("Enter Account Number");
        Account_Num = new JTextField(10);
        jpanel1 = new JPanel();
        jpanel1.setLayout(new GridLayout(2,2,1,1));


        jpanel3 = new JPanel();
        jpanel3.setLayout(new GridLayout(1,1,1,1));
        jpanel3.add(jlabel2);

        jpanel4 = new JPanel();
        jpanel4.setLayout(new GridLayout(1,1,1,1));
        jpanel4.add(jlabel2);
        jpanel4.add(Account_Num);

        AccountInfo = new JButton("AccountInfo");
        Deposit = new JButton("Deposit");
        Withdraw = new JButton("Withdraw");
        Current_Transaction = new JButton("Current Balance");
        jpanel2 = new JPanel();
        jpanel2.setLayout(new GridLayout(2,2,10,10));
        jpanel2.add(AccountInfo);
        jpanel2.add(Deposit);
        jpanel2.add(Withdraw);
        jpanel2.add(Current_Transaction);

        Container conn = getContentPane();
        conn.setLayout(new FlowLayout());
        conn.add(jpanel1);

        Container conn2 = getContentPane();
        conn2.setLayout(new FlowLayout());
        conn2.add(jpanel3);

        Container conn3 = getContentPane();
        conn3.setLayout(new FlowLayout());
        conn3.add(jpanel4);

        Container conn1 = getContentPane();
        conn1.setLayout(new FlowLayout());
        conn1.add(jpanel2);

        setBounds(300,300,500,400);
        setTitle("Display Info");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AccountInfo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              //  db.DisplayInfo(Account_Num.getText(),1);
              	DisplayDetails dd=new DisplayDetails();
              	dd.accountDisplay(Account_Num.getText());
                setVisible(false);
            }
        });

        Deposit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              //  db.DisplayInfo(Account_Num.getText(),2);
              Deposit ud=new Deposit();
                setVisible(false);
            }
        });

        Withdraw.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              //  d2.displaydeposit(Account_Num.getText(),1);
              Withdrawal wd=new Withdrawal();
                setVisible(false);
            }
        });

        Current_Transaction.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              //  d2.displaydeposit(Account_Num.getText(),2);
              	CurrentBalance bal=new CurrentBalance();
              	bal.balanceDisplay(Account_Num.getText());
                setVisible(false);
            }
        });
    }

    public void displayaccount(String s1,String s2,String s3,String s4,String s5)
    {
        System.out.println("HI");
    }
}
