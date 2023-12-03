package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class signuptwo extends JFrame implements ActionListener{
    
    JComboBox educ,occu,accc;
  JTextField  eduTextField,occTextField,aadharTextField,panTextField,acctypeTextField,sencitizenTextField;
  JButton Next;
  JRadioButton male,Female,Others;
 
  JRadioButton yes,no,senno,senyes;
    String formno;
    signuptwo(String formno){
    this.formno = formno;
        setLayout(null);
        
        
        JLabel adddetails = new JLabel("Additional Details:-" ); 
        adddetails.setBounds(350,10,800,100);
        adddetails.setFont(new Font("osward", Font.BOLD,30));
        add(adddetails);
        
        JLabel details = new JLabel("Fill in the details :-" ); 
        details.setBounds(50,70,800,100);
        details.setFont(new Font("osward", Font.BOLD,18));
        add(details);
        
        JLabel edu = new JLabel ("Education Qualification:");
        edu.setBounds(110,120,250,100);
        edu.setFont(new Font("ariel",Font.BOLD,22));
        add(edu);
        
        JLabel occ = new JLabel ("Occupation:");
        occ.setBounds(234,170,150,100);
        occ.setFont(new Font("ariel",Font.BOLD,22));
        add(occ);
              
        
        
        JLabel aadhar = new JLabel ("Aadhar No:");
        aadhar.setBounds(245,220,200,100);
        aadhar.setFont(new Font("ariel",Font.BOLD,22));
        add(aadhar);
        
        JLabel pan = new JLabel ("Pan No:");
        pan.setBounds(280,270,150,100);
        pan.setFont(new Font("ariel",Font.BOLD,22));
        add(pan);
        
        
        JLabel acctype = new JLabel ("Account type:");
        acctype.setBounds(216,320,150,100);
        acctype.setFont(new Font("ariel",Font.BOLD,22));
        add(acctype);
        
        JLabel exacc = new JLabel ("Existing Acoount:");
        exacc.setBounds(173,370,200,100);
        exacc.setFont(new Font("ariel",Font.BOLD,22));
        add(exacc);
        
        JLabel sencitizen = new JLabel ("Senior Citizen:");
        sencitizen.setBounds(204,420,250,100);
        sencitizen.setFont(new Font("ariel",Font.BOLD,22));
        add(sencitizen);
        
        
       String eduu[] = { "10th" , "12th" , "Diploma" , "Bachelors degree"};
    educ = new JComboBox (eduu);    
    educ.setFont(new Font("ariel",Font.BOLD,19));
       educ.setBounds(380,156,500,30);
        add(educ);
        
         String occupation[] = { "Salaried" , "Business" , "Freelancerd" , "Unemployed"};
     occu = new JComboBox (occupation);    
    occu.setFont(new Font("ariel",Font.BOLD,19));
       occu.setBounds(380,206,500,30);
        add(occu);
        
        aadharTextField = new JTextField();
        aadharTextField.setBounds(380,256,500,30);
        aadharTextField.setFont(new Font("ariel",Font.BOLD,19));
        add(aadharTextField);
        
        panTextField = new JTextField();
        panTextField.setBounds(380,306,500,30);
        panTextField.setFont(new Font("ariel",Font.BOLD,19));
        add(panTextField);
        
        String type[] = { "Savings" , "Current" };
     accc = new JComboBox (type);    
            accc.setFont(new Font("ariel",Font.BOLD,19));
       accc.setBounds(380,356,500,30);
        add(accc);
        
        
        yes = new JRadioButton("Yes");
        yes.setFont(new Font("ariel",Font.BOLD,13));
        yes.setBounds(380,398,50,50);
        
        add(yes);
        
        
        no = new JRadioButton("No");
        no.setBounds(480,398,50,50);
        no.setFont(new Font("ariel",Font.BOLD,13));
        add(no);
        
         senyes = new JRadioButton("Yes");
        senyes.setFont(new Font("ariel",Font.BOLD,13));
        senyes.setBounds(380,448,100,50);
        add(senyes);
        
        
        senno = new JRadioButton("No");
        senno.setBounds(480,448,100,50);
        senno.setFont(new Font("ariel",Font.BOLD,13));
        add(senno);
        
        
        
        
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
String edu = (String)educ.getSelectedItem();
String occ = (String)occu.getSelectedItem();
String aadhar = aadharTextField.getText();
String span = panTextField.getText();
String actype = (String)accc.getSelectedItem();
String exacc = null;
   if(yes.isSelected()){
       exacc = "Yes";
   }
       else if(no.isSelected()){
       exacc = ("No");
   }
   
   String seniorciti = null;
   if(senyes.isSelected()){
       seniorciti = "Yes";
   }
       else if(senno.isSelected()){
       seniorciti = ("No");
   }
  try{
   
        con c = new con();
        String query = "insert into signuptwo value('"+edu+"','"+occ+"','"+aadhar+"','"+span+"','"+actype+"','"+exacc+"','"+seniorciti+"','"+formno+"')";
    c.s.executeUpdate(query);
    new Signupthree(formno).setVisible(true);

}
catch(Exception e){
    System.out.println(e);
}
}    






public static void main (String args[]){
new signuptwo("");
    
    
    
}
}

