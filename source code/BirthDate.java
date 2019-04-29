
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

private Stage stage;
    private DatePicker checkInDatePicker;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        //stage.setTitle("DatePickerSample ");
        initUI();
        stage.show();
    }
class initUI
{
	VBox vbox = new VBox(20);
	        vbox.setStyle("-fx-padding: 10;");
	        Scene scene = new Scene(vbox, 400, 400);
	        stage.setScene(scene);

	        checkInDatePicker = new DatePicker();

	        GridPane gridPane = new GridPane();
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);

	        Label checkInlabel = new Label("Please enter Date of Birth");
	        gridPane.add(checkInlabel, 0, 0);

	        GridPane.setHalignment(checkInlabel, HPos.LEFT);
	        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
    private JButton ADD;
    private JButton CANCEL;
    private JTextField NAME;
    private JTextField DATE;
    private JTextField ADDRESS;
    private JTextField AGE;
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
    private JLabel jlabel5;
    private JLabel jlabel6;
    private JLabel jlabel7;
    private JLabel jlabel8;

   // Database db = new Database();

    public void newaccgui()
    {
        System.out.println("New Account Creation");
        jlabel2 = new JLabel("NAME");
        jlabel3 = new JLabel("DATE");
        jlabel4 = new JLabel("ADDRESS");
        jlabel5 = new JLabel("AGE");
        jlabel6 = new JLabel("DATE_OF_BIRTH");
        jlabel7 = new JLabel("ACCOUNT_TYPE");
        jlabel8 = new JLabel("GENDER");

        Date now = new Date();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
        String date = df1.format(now);

        ADD = new JButton("ADD");
        CANCEL = new JButton("CANCEL");
        NAME = new JTextField(25);
        DATE = new JTextField(date);
        ADDRESS = new JTextField(25);
        AGE = new JTextField(3);
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
        jpanel2.add(jlabel5);
        jpanel2.add(jlabel6);
        jpanel2.add(jlabel7);
        jpanel2.add(jlabel8);


        jpanel3 = new JPanel();
        jpanel3.setLayout(new GridLayout(7,5,31,31));
        jpanel3.add(NAME);
        jpanel3.add(DATE);
        jpanel3.add(ADDRESS);
        jpanel3.add(AGE);
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


             	AccountCreate ac=new AccountCreate();
             	ac.setAccountCreate(NAME.getText(),DATE.getText(),ADDRESS.getText(),DATE_OF_BIRTH.getText(),ACCOUNT_TYPE.getText(),GENDER.getText());
             	ac.getAccountCreate();
             	ac.createNewAccount();
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

