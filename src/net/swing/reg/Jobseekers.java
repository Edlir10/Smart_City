package net.swing.reg;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Jobseekers extends JFrame 
{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Jobseekers student1 = new Jobseekers();
                    student1.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
	

	
	public Jobseekers(){
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
       
        contentPane.setLayout(null);
        
        JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("Select item");
        cmb.addItem("Jobs");
        cmb.addItem("Job News");

        cmb.setBounds(70,51,162,34);
        contentPane.add(cmb);

        JButton sb = new JButton("Search it!");
        sb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent b)
            {
            	String link = "";
                if( cmb.getSelectedItem() != "Select item" )
                {
                	switch(cmb.getSelectedIndex())
                	{
                		case 1:
                			link = "https://www.millionmakers.com/jobs/jobs-in-albania/";
                			try {
                				Desktop d= Desktop.getDesktop();
                                URI uri = new URI(link.toString());
                                d.browse(uri);  
                                break;
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }
                		case 2:
                			link = "https://shqiptarja.com/kategoria/pune";
                			try {
                				Desktop d= Desktop.getDesktop();
                                URI uri = new URI(link.toString());
                                d.browse(uri);  
                                break;
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }     		
                		default:
                			break;
                	}
                }
            
            }});
        sb.setBounds(270,51, 162,34);
        contentPane.add(sb);
        
	}
	
}
