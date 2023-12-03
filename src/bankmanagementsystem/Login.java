
package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
   JTextField cardTextField;
   JPasswordField pinTextField;
   JButton login,signup;
   private String pin;
    
    Login(){
    setTitle("BANKING");
         setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/blogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label =  new JLabel(i3);
        label.setBounds(60,25,100,100);
        add(label);
        
        JLabel text = new JLabel ("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,65));
        text.setBounds(220,25 ,1500,100);
        add(text);
        
        JLabel cardno = new JLabel ("Card no:");
        cardno.setFont(new Font("Osward",Font.BOLD,40));
        cardno.setBounds(90,200 ,1500,100);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300,233,400,40);
       cardTextField.setFont(new Font("osward",Font.CENTER_BASELINE,18));
        add(cardTextField);
        
        
        JLabel pin = new JLabel ("Pin no:");
        pin.setFont(new Font("Osward",Font.BOLD,40));
        pin.setBounds(115,300,1500,100);
        
        add(pin);
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,333,400,40);
        pinTextField.setFont(new Font("osward",Font.CENTER_BASELINE,18));
        add(pinTextField);
        
         login  = new JButton("Login");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
         login.setBounds(300,450,190,40);
        login.addActionListener(this);
         add(login);
        
         signup  = new JButton("Sign up");
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
         signup.setBounds(510,450,190,40);
        signup.addActionListener(this);
         add(signup);
        
              
        
        getContentPane().setBackground(Color.white);
        setSize(1000,650);
        setVisible(true);
        setLocation(200,200);
      
        
    }
    
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource()==login){
         con c = new con();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String q = "select * from login where cardno = '"+ cardnumber +"' and pinno = '"+pinnumber+"' ";
        try{
            ResultSet rs = c.s.executeQuery(q);
            if(rs.next()){
                login.setVisible(false);
         new transactions(pin).setVisible(true);
            }else {
                 JOptionPane.showMessageDialog(null, "Incorrect Account Number or Pin Number");
            }
        }
            catch(Exception e){
                    System.out.println(e);
                    }
    }
    else if (ae.getSource()==signup){
        login.setVisible(false);
         new signupone().setVisible(true);
    }
    
        
        
        
    }
    
    

public static void main(String args[]){
new Login().setVisible(true);
}
}
