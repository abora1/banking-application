import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
   public static void main(String[] args)
   {
       MainMenu mm=new MainMenu();
       mm.menu();
   }
}

class MainMenu extends JFrame
{
    private JButton AccountAction;
    private JButton UserAction;
    private JPanel panel;
    private JLabel label;

    void menu()
    {

        panel = new JPanel();
        label = new JLabel("Main Menu");
        AccountAction = new JButton("Account Action");
        UserAction = new JButton("User Action");
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());

        panel.setLayout(new GridLayout(100,70,50,50));

        panel.add(label);
        panel.add(AccountAction);
        panel.add(UserAction);

    	cont.add(panel,BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();
        AccountAction.addActionListener(handler);
        UserAction.addActionListener(handler);

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
            if(e.getSource() == AccountAction)
            {
                setVisible(false);
                new AccountAction();
            }
            if(e.getSource() == UserAction)
            {
                setVisible(false);
                new UserAction();
            }

        }
    }
}

