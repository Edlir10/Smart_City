package net.swing.reg;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class UserHome extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton studentButton;
    private JButton webButton;
    private JLabel lblSearch;
    private JTextField text;

    
    public UserHome() {
    }

    public UserHome(String userSes) 
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(450, 190, 1014, 597);
        setBounds(200, 150, 1300, 900);
        setResizable(false);
        contentPane = new JPanel();
        
       // lets add a small menu bar to make it look cooler
        MenuBar menu = new MenuBar();
        Menu filemenu,filemenu2,filemenu3,theme;
        MenuItem project_root,exit,white,black,red,blue,yellow,orange,green,original,search;
        
        // add the menus first then the sub ones
        filemenu = new Menu("File");
        filemenu2 = new Menu("Settings");
        filemenu3 = new Menu("Tools");
        
        
        project_root = new MenuItem("Project root folder");
        exit = new MenuItem("exit");
        theme = new Menu("theme");
        white = new MenuItem("white");
        black = new MenuItem("black");
        red = new MenuItem("red");
        yellow = new MenuItem("yellow");
        blue = new MenuItem("blue");
        orange = new MenuItem("orange");
        green = new MenuItem("green");
        original = new MenuItem("original");
        search = new MenuItem("Search in web");
        
        // including the submenus in their own menus 
        filemenu.add(project_root);
        filemenu.addSeparator();
        filemenu.add(exit);
        filemenu2.add(theme);
        filemenu3.addSeparator();
        filemenu3.add(search);
        
        theme.add(white);
        theme.addSeparator();
        theme.add(black);
        theme.addSeparator();
        theme.add(red);
        theme.addSeparator();
        theme.add(yellow);
        theme.addSeparator();
        theme.add(blue);
        theme.addSeparator();
        theme.add(orange);
        theme.addSeparator();
        theme.add(green);
        theme.addSeparator();
        theme.add(original);
   
        menu.add(filemenu);
        menu.add(filemenu2);
        menu.add(filemenu3);
        
        
        setMenuBar(menu);
        
        project_root.addActionListener(new ActionListener(){   // a small function to browse directly 
            public void actionPerformed(ActionEvent e){        // to the root folder of the project
                Desktop desktop = Desktop.getDesktop();
                File dir= null;
                try {
                    dir = new File("C:\\Users\\edlir\\eclipse-workspace\\swing-reg");
                    try {
                        desktop.open(dir);} 
                    catch (IOException e1) {
                        e1.printStackTrace();
                        }
                    } 
                catch (IllegalArgumentException iae) {
                    System.out.println("File Not Found");
                    }
                }
            });
        
        exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}});
        
        white.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(255, 255, 255));
        	}});
        black.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(1, 1, 1));
        	}});
        red.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(255, 1, 1));
        	}});
        yellow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(255, 255, 1));
        	}});
        blue.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
           		 getContentPane().setBackground(new Color(1, 1, 255));
           	}});
        orange.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(255, 69, 1));
        	}});
        green.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 getContentPane().setBackground(new Color(1, 128, 1));
        	}});
        original.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(new Color(255, 217, 254));
        	}});
     
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	UserHome h = new UserHome();
        	h.setLayout(null);
        	h.setResizable(true);
        	h.setTitle("Search");
        	h.setSize(800,250);
        	
        	JButton btn = new JButton("Search");
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Desktop d= Desktop.getDesktop();
                    String src = "https://www.google.com/search?q=";
                    String lastSearch = src+text.getText();
                    lastSearch = lastSearch.replaceAll(" ", "%20");
                    try {
                        URL u = new URL(lastSearch.toString());
                        URI uri = new URI(u.toString());
                        d.browse(uri);    
                    }
                    catch(Exception E)
                    {
                        E.printStackTrace();
                    }
                }});
        	btn.setFont(new Font("Tahoma", Font.PLAIN, 29));
            btn.setBackground(new Color(240, 240, 240));
            btn.setBounds(338, 127, 170, 59);
            h.add(btn);
            
            lblSearch = new JLabel("Search on web");
            lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lblSearch.setBounds(45, 37, 326, 67);
            h.add(lblSearch);
            
            text = new JTextField();
            text.setFont(new Font("Tahoma", Font.PLAIN, 34));
            text.setBounds(250, 35, 409, 67);
            h.add(text);
            text.setColumns(10);
        	
        	h.setVisible(true);
        	
        	
        	}});
	       

        // done with the bar
    	
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        getContentPane().setBackground(new Color(255, 217, 254));
        contentPane.setLayout(null);
        
        // lets add a logout button
        
        JButton btnNewButton = new JButton("   Logout       ");
        ImageIcon logoutIcon;
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) 
                {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
            }
        });
        logoutIcon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\logout_icon.png");
        btnNewButton.setIcon(logoutIcon);
        btnNewButton.setBackground( Color.white);
        btnNewButton.setIconTextGap(50);
        btnNewButton.setBounds(120, 68, 491, 114);

        contentPane.add(btnNewButton);
        
        // lets change the password cos why not
        
        JButton button = new JButton("Change-password\r\n");
        ImageIcon passwordIcon;
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(120, 270, 491, 114);
        button.setBackground( Color.white);
        passwordIcon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\change_password.png");
        button.setIcon(passwordIcon);
        button.setIconTextGap(26);
        //button.setBackground(Color.BLUE);
        contentPane.add(button);
        ////////////////////////////
        //
        //     STUDENT MODULE BUTTON
        //
        ////////////////////////////
        
        studentButton = new JButton("Student Section\r\n");
        studentButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        ImageIcon studentIcon;
        studentButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Student student = new Student();
            	student.setTitle("Student Module");
            	student.setVisible(true);
            	student.setSize(500, 250);
            	student.setResizable(false);
                  
            }
        });
        studentButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        studentButton.setBounds(120, 470, 491, 114);
        studentButton.setBackground( Color.white);
        //studentButton.setIcon(studentIcon = new ImageIcon("icons/student_icon.png"));
        studentIcon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\student_icon.png");
        studentButton.setIcon(studentIcon);
        studentButton.setIconTextGap(50);
        //button.setBackground(Color.BLUE);
        contentPane.add(studentButton);
			////////////////////////////
			//
			//    MAIN WEB PAGEM BUTTON
			//
			////////////////////////////
			
			webButton = new JButton("Web page\r\n");
			webButton.setBackground(UIManager.getColor("Button.disabledForeground"));
			//ImageIcon mainweb;
			webButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				File file = new File("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\SmartCity.html");
		        
		        if(!Desktop.isDesktopSupported()){
		            System.out.println("Desktop is not supported");
		            return;
		        }
		        
		        try {
		        	Desktop desktop = Desktop.getDesktop();
			        if(file.exists()) 
			        	desktop.open(file);

		        }catch(Exception es) {
		        	es.printStackTrace();
		        }
		        
		     
			}});
			webButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
			webButton.setBounds(320, 670, 491, 114);
			webButton.setBackground( Color.white);
			ImageIcon mainweb = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\web_icon.png");
			webButton.setIcon(mainweb);
			webButton.setIconTextGap(50);
			contentPane.add(webButton);
		////////////////////////////
		//
		//     TOURISM MODULE BUTTON
		//
		////////////////////////////
        JButton tourism = new JButton("   Tourism       ");
        ImageIcon tourismIcon;
        tourism.setForeground(new Color(0, 0, 0));
        tourism.setBackground(UIManager.getColor("Button.disabledForeground"));
        tourism.setFont(new Font("Tahoma", Font.PLAIN, 39));
        tourism.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.setRootFrame(null);
                
                Tourism tourism = new Tourism();
            	tourism.setTitle("Tourism Module");
            	tourism.setVisible(true);
            	tourism.setSize(500, 250);
            }
        });
        tourismIcon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\tourismIcon.png");
        tourism.setIcon(tourismIcon);
        tourism.setIconTextGap(50);
        tourism.setBounds(720, 68, 491, 114);
        tourism.setBackground( Color.white);
        contentPane.add(tourism);
        
        ////////////////////////////
        //
        //     JOBS MODULE BUTTON
        //
        ////////////////////////////
        JButton jobs = new JButton("   Jobs          ");
        ImageIcon jobs_icon;
        jobs.setForeground(new Color(0, 0, 0));
        jobs.setBackground(UIManager.getColor("Button.disabledForeground"));
        jobs.setFont(new Font("Tahoma", Font.PLAIN, 39));
        jobs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.setRootFrame(null);
                
                Jobseekers jobj = new Jobseekers();
            	jobj.setTitle("Jobseeker's Module");
            	jobj.setVisible(true);
            	jobj.setSize(500, 250);
            }
        });
        jobs_icon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\jobs_icon.png");
        jobs.setIcon(jobs_icon);
        jobs.setIconTextGap(70);
        jobs.setBounds(720, 270, 491, 114);
        jobs.setBackground( Color.white);
        contentPane.add(jobs);
        
			////////////////////////////
			//
			//     BUSINESS MODULE BUTTON
			//
			////////////////////////////
			JButton business = new JButton("   Business      ");
			ImageIcon business_icon;
			business.setForeground(new Color(0, 0, 0));
			business.setBackground(UIManager.getColor("Button.disabledForeground"));
			business.setFont(new Font("Tahoma", Font.PLAIN, 39));
			business.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.setRootFrame(null);
				
				Business b1 = new Business();
				b1.setTitle("Business Module");
				b1.setVisible(true);
				b1.setSize(500, 250);
			}
			});
			business_icon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\buss_icon.png");
			business.setIcon(business_icon);
			business.setIconTextGap(70);
			business.setBounds(720, 470, 491, 114);
			business.setBackground( Color.white);
			contentPane.add(business);
        
			////////////////////////////
			//
			//    DELET ACCOUNT
			//
			////////////////////////////
			
			    JButton deletButton = new JButton("");
		        deletButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		        ImageIcon deletIcon;
		        deletButton.addActionListener(new ActionListener()
		        {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	Delet del = new Delet();
		            	del.setTitle("Delet this account");
		            	del.setVisible(true);
		            	del.setSize(500, 300);
		            	del.setResizable(false);
		                  
		            }
		        });
		        deletButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		        deletButton.setBounds(920, 670, 114, 114);
		        deletButton.setBackground( Color.white);
		        deletIcon = new ImageIcon("C:\\Users\\edlir\\eclipse-workspace\\swing-reg\\web_content\\icons\\gear.png");
		        deletButton.setIcon(deletIcon);
		        deletButton.setIconTextGap(0);
		        contentPane.add(deletButton);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}