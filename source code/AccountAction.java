import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class AccountAction
{
  AccountAction()
   {
       System.out.println("Hello World");
       AAction mm=new AAction();
       mm.menu();
   }
}

class AAction extends JFrame
{
    private JButton NewAccount;
    private JButton DeleteAccount;
    private JPanel panel;
    private JLabel label;

    void menu()
    {
        System.out.println("Creating Main Menu");

        panel = new JPanel();

        label = new JLabel("Main Menu");
        NewAccount = new JButton("New Account");
        DeleteAccount = new JButton("DeleteAccount");

        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());

        panel.setLayout(new GridLayout(6,1,20,20));

        panel.add(label);
        panel.add(NewAccount);
        panel.add(DeleteAccount);

        cont.add(panel,BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();
        NewAccount.addActionListener(handler);
        DeleteAccount.addActionListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setBounds(300,300,412,500);
        setResizable(false);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == NewAccount)
            {
                setVisible(false);
                new NewAccount();
            }
            if(e.getSource() == DeleteAccount)
            {
                setVisible(false);
                new DeleteAccount();
            }
        }
    }
}

