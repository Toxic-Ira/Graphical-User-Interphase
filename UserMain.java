/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADPPrac5;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @Inga Mbobo 230711723
 */
public class UserMain extends JFrame implements ActionListener{

    //Declaring all variables
    private JPanel panelSouth, panelCenter, panelUsername, panelPassword;
    private JButton btnLogin, btnClear, btnExit;
    private JTextField txtUser, txtPass;
    private JLabel lblUser, lblPass;
    private JMenuBar bar;
    private JMenu menu1;
    private JMenuItem menLogin, menClear, menExit;
    
    private Font ft1;
    public UserMain()
    {
        super("User Authentication");
        // Instantiate all the instance variables in the constructor
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelUsername = new JPanel();
        panelPassword = new JPanel();
        
        bar = new JMenuBar();
        menu1 = new JMenu("File");
        
        menLogin = new JMenuItem("Login");
        menClear = new JMenuItem("Clear");
        menExit = new JMenuItem("Exit");
        
                
        btnLogin = new JButton("LOGIN");
        btnClear = new JButton("CLEAR");
        btnExit = new JButton("EXIT");
        
        txtUser = new JTextField(15);
        txtPass = new JTextField(15);
        
        lblUser = new JLabel("Username:");
        lblPass = new JLabel("Password:");
        
        ft1 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
        
        btnLogin.setForeground(Color.black);
        btnLogin.setBackground(Color.green);
        btnLogin.setFont(ft1);
        
        btnClear.setForeground(Color.black);
        btnClear.setBackground(Color.blue);
        btnClear.setFont(ft1);
        
        btnExit.setForeground(Color.black);
        btnExit.setBackground(Color.red);
        btnExit.setFont(ft1);
    }
    
    //Setting up the GUI
    public void setGUI()
    {
        panelSouth.setLayout(new GridLayout(1, 3));
       
        //Setting the menu bar to have the menus in it
        this.setJMenuBar(bar);
            bar.add(menu1);
            menu1.add(menLogin);
            menu1.add(menClear);
            menu1.add(menExit);
        
        //Adding all the gui components to respective panels
        panelSouth.add(btnLogin);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);
        panelUsername.add(lblUser);
        panelUsername.add(txtUser);
        panelPassword.add(lblPass);
        panelPassword.add(txtPass);
        panelCenter.add(panelUsername);
        panelCenter.add(panelPassword);
        
        //Organising the panels into one gui
        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelCenter, BorderLayout.CENTER);
        
        //Adding event listeners to GUI
        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        menLogin.addActionListener(this);
        menClear.addActionListener(this);
        menExit.addActionListener(this);
    }
    
    public static void main(String[] args) {
        // Declaring all the variables
        String Name = "";            
        String Password = "";
        
        //Code to create the gui itself
        UserMain guiObject = new UserMain();
        guiObject.pack();	 
        guiObject.setSize(400, 300);
        guiObject.setVisible(true);
        guiObject.setDefaultCloseOperation(EXIT_ON_CLOSE);
        guiObject.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding the action listener for the buttons
        if (e.getSource()==btnLogin || e.getSource()==menLogin) {               //Checking whether the Login button or Login menu button was pressed
            //Declaring the array, taking the input from text field adding to the user object.
            ArrayList<User> users = new ArrayList<User>();
            String Name = txtUser.getText();
            String Password = txtPass.getText();
            User newUser = new User(Name, Password);
            users.add(newUser);
            //checking whether the password contains and special characters || Data Validation
            if (newUser.isValid()) {
            JOptionPane.showMessageDialog(null, newUser);
            } else {
            JOptionPane.showMessageDialog(null, "Your password does not contain any special characters");    
            }
        } else if (e.getSource()==btnClear || e.getSource()==menClear) {        //Checking whether the Clear button or Clear menu button was pressed
            //Setting the text fields back to no value
            txtUser.setText("");
            txtPass.setText("");
        } else if (e.getSource()==btnExit || e.getSource()==menExit) {          //Checking whether the Exit button or menu button was pressed
            System.exit(0);    
        }
       
    }
    
}
