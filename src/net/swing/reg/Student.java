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

public class Student extends JFrame 
{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Student student1 = new Student();
                    student1.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
	

	
	public Student(){
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
       
        contentPane.setLayout(null);
        
        JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("Select item");
        cmb.addItem("School's");
        cmb.addItem("UAMD");
        cmb.addItem("Libraries");
        cmb.addItem("Sport");
        cmb.addItem("Apartments");
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
                			link = "http://www.albaniayp.com/category/Schools/city:Durres";
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
                			link = "https://www.uamd.edu.al/index.php/en/";
                			try {
                				Desktop d= Desktop.getDesktop();
                                URI uri = new URI(link.toString());
                                d.browse(uri);  
                                break;
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }
                		case 3:
                			link = "https://www.instagram.com/libraridyrrahu5/?hl=en";
                			try {
                				Desktop d= Desktop.getDesktop();
                                URI uri = new URI(link.toString());
                                d.browse(uri);  
                                break;
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }
                		case 4:
                			link = "https://shqiptarja.com/kategoria/sport";
                			try {
                				Desktop d= Desktop.getDesktop();
                                URI uri = new URI(link.toString());
                                d.browse(uri);  
                                break;
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }
                		case 5:
                			link = "https://www.booking.com/apartments/city/al/durres.en-gb.html?aid=375802;label=durres-lIU0nuAEmVQiZjL_hS%2A2IQS260537787988%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atiaud-297601666475%3Akwd-28064376083%3Alp9069994%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YasQqy722txiHYUINjZjDPc;sid=3feef1bfdb95e973f9411436f802233e";
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
