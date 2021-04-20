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

public class Tourism extends JFrame 
{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tourism student1 = new Tourism();
                    student1.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
	

	
	public Tourism(){
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
       
        contentPane.setLayout(null);
        
        JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("Select item");
        cmb.addItem("Tourist Attractions");
        cmb.addItem("Hotels");
        cmb.addItem("Resturants");
        cmb.addItem("Banks");
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
                			link = "https://www.thecrazytourist.com/15-best-things-durres-albania/";
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
                			link = "https://www.booking.com/city/al/durres.en.html?aid=303948;label=durres-zCpOiHmRwTDadJFOXiMfWgS392989379673:pl:ta:p190:p2:ac:ap:neg:fi:tikwd-11484251318:lp9069994:li:dec:dm:ppccp=UmFuZG9tSVYkc2RlIyh9Yf5EcukO1MOGLSSAuId8ToA;ws=&gclid=Cj0KCQiAst2BBhDJARIsAGo2ldXISCcHjy1R3-jIqvvdVxqP6TzYVxHbYnkwih-DgAILdhkKWBg8zf0aAgCTEALw_wcB";
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
                			link = "https://www.tripadvisor.com/Restaurants-g318866-Durres_Durres_County.html";
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
                			link = "http://al.statex.info/city/66454";
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
