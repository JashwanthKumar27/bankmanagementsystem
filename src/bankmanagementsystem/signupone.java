
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupone extends JFrame implements ActionListener{
    
    long random;
  JTextField  nameTextField,dobTextField,disTextField,addTextField,stTextField,mailTextField,pinTextField;
  JButton Next;
  JRadioButton male,Female,Others;
  JDateChooser date;
    
    signupone(){
    
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L  )+1000L);
        
        JLabel formno = new JLabel("Application no: "+ random ); 
        formno.setBounds(320,10,800,100);
        formno.setFont(new Font("osward", Font.BOLD,30));
        add(formno);
        
        JLabel perdetails = new JLabel("Fill in the personal details :-" ); 
        perdetails.setBounds(50,70,800,100);
        perdetails.setFont(new Font("osward", Font.BOLD,18));
        add(perdetails);
        
        JLabel name = new JLabel ("Name:");
        name.setBounds(172 ,120,150,100);
        name.setFont(new Font("ariel",Font.BOLD,22));
        add(name);
        
        JLabel dob = new JLabel ("DOB: ");
        dob.setBounds(185,170,150,100);
        dob.setFont(new Font("ariel",Font.BOLD,22));
        add(dob);
              
        
        
        JLabel gen = new JLabel ("Gender:");
        gen.setBounds(152,220,150,100);
        gen.setFont(new Font("ariel",Font.BOLD,22));
        add(gen);
        
        JLabel mail = new JLabel ("Email:");
        mail.setBounds(170,270,150,100);
        mail.setFont(new Font("ariel",Font.BOLD,22));
        add(mail);
        
        
        JLabel st = new JLabel ("State:");
        st.setBounds(172,320,150,100);
        st.setFont(new Font("ariel",Font.BOLD,22));
        add(st);
        
        JLabel dis = new JLabel ("District:");
        dis.setBounds(150,370,150,100);
        dis.setFont(new Font("ariel",Font.BOLD,22));
        add(dis);
        
        JLabel add = new JLabel ("Address:");
        add.setBounds(137,420,150,100);
        add.setFont(new Font("ariel",Font.BOLD,22));
        add(add);
        
        JLabel pin = new JLabel ("Pincode:");
        pin.setBounds(137,470,150,100);
        pin.setFont(new Font("ariel",Font.BOLD,22));
        add(pin);
        
         nameTextField = new JTextField();
        nameTextField.setFont(new Font("ariel",Font.BOLD,19));
       nameTextField.setBounds(300,156,500,30);
        add(nameTextField);
        
        
        
         date = new JDateChooser();
        date.setBounds(300,206,500,30);
        add(date);        
        
                
                 male = new JRadioButton("Male");
        male.setBounds(300,256,100,30);
        add(male);
        
         Female = new JRadioButton("Female");
        Female.setBounds(400,256,100,30);
        add(Female);
        
         Others = new JRadioButton("Other");
        Others.setBounds(500,256,100,30);
        add(Others);
        
        
        
        
        
         mailTextField = new JTextField();
        mailTextField.setFont(new Font("ariel",Font.BOLD,19));
       mailTextField.setBounds(300,306,500,30);
        add(mailTextField);
        
         stTextField = new JTextField();
        stTextField.setFont(new Font("ariel",Font.BOLD,19));
       stTextField.setBounds(300,356,500,30);
        add(stTextField);
        
         disTextField = new JTextField();
        disTextField.setFont(new Font("ariel",Font.BOLD,19));
       disTextField.setBounds(300,406,500,30);
        add(disTextField);
        
         addTextField = new JTextField();
        addTextField.setFont(new Font("ariel",Font.BOLD,19));
       addTextField.setBounds(300,456,500,30);
        add(addTextField);
        
         pinTextField = new JTextField();
        pinTextField.setFont(new Font("ariel",Font.BOLD,19));
       pinTextField.setBounds(300,506,500,30);
        add(pinTextField);
        
        JButton next = new JButton ("Next");
        next.setFont(new Font("raleway",Font.BOLD,15));
        next.setBounds(700,570,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        setSize(1000,650);
        setVisible(true);
        setLocation(100,100);
}

public void actionPerformed(ActionEvent ae){
   String formno = ""+ random; //long converted to string as values are stored in databse as string;
   String name = nameTextField.getText();
   String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
   String gen = null;
   if(male.isSelected()){
       gen = "Male";
   }
       else if(Female.isSelected()){
       gen = ("Female");
   }
       else if (Others.isSelected()){
           gen = ("Other");
       }
   String mail = mailTextField.getText();  
   String st = stTextField.getText();
   String dis = disTextField.getText();
   String add = addTextField.getText();
   String pin = pinTextField.getText();

try{
    if(name.equals("")){
        JOptionPane.showMessageDialog(null, "Name is required");
    }
    else{
        con c = new con();
        String query = "insert into signupone value('"+formno+"','"+name+"','"+dob+"','"+gen+"','"+mail+"','"+st+"','"+dis+"','"+add+"','"+pin+"')";
    c.s.executeUpdate(query);
   setVisible(false);
   new signuptwo(formno).setVisible(true);
    
    }

}
catch(Exception e){
    System.out.println(e);
}
}


public static void main (String args[]){
new signupone();
    
    
    
}
}
