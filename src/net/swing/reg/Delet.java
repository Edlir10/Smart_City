package net.swing.reg;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Delet extends JFrame 
{
	private static final long serialVersionUID = 1L;

	
	public Delet(){
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
        setBounds(720, 670, 591, 114);
        JLabel usernamelbl = new JLabel("Your username:");
        JLabel passwordlbl = new JLabel("Your password:");
        
        usernamelbl.setBounds(15,20,200,45);
        usernamelbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(usernamelbl);
        
        passwordlbl.setBounds(15,70,200,45);
        passwordlbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(passwordlbl);
        
        JTextField usernametext = new JTextField();
        JPasswordField passwordtext = new JPasswordField();
        
        usernametext.setBounds(200,20,200,45);
        usernametext.setFont(new Font("Tahoma", Font.PLAIN, 34));
        add(usernametext);
        
        passwordtext.setBounds(200,70,200,45);
        passwordtext.setFont(new Font("Tahoma", Font.PLAIN, 34));
        add(passwordtext);
        
        JButton delete = new JButton("Delete Account");
        delete.setFont(new Font("Tahoma", Font.PLAIN, 24));
        delete.setBounds(150,170,200,45);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	UserLogin obj = new UserLogin();
                  
                String username_delet = usernametext.getText();
                String password_delet = passwordtext.getText();

            	int a = JOptionPane.showConfirmDialog(delete, "Are you sure you want to delete your account?");
                if (a == JOptionPane.YES_OPTION)
                {
                	//System.out.println(obj.valid_username +"and password is: "+obj.valid_password);
                	if(username_delet.equals(obj.username_text) && password_delet.equals(obj.password_text))
                	{
                		//System.out.println("Account with the username "+username_delet +" and password "+password_delet+"is successfully deleted");
                		try {
                            java.sql.Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?serverTimezone=UTC", "root", "root");
                            PreparedStatement st = (PreparedStatement) ((java.sql.Connection) connection)
                                    .prepareStatement("DELETE FROM account WHERE user_name = '"+username_delet+"' AND password = '"+password_delet+"';");
                            st.executeUpdate();
                            dispose();
                            System.exit(0);
             		   }catch(SQLException el){
             			   
             			   el.printStackTrace();
             		   }}
                	}
                }
                
            });
         add(delete);
         dispose();
	}

}
