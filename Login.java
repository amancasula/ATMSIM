package ATMSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Login implements ActionListener{

  JFrame frame;
  JPanel north, center, center_top, center_bottom, south, south_top;
  JLabel logo, title, cardNo, pinNo;
  JPasswordField pinNo_;
  JTextField cardNo_;
  JButton clear, signin, signup;
  Connect c1;
  int con_ret;


  public static void main(String args[]){
  
    Login l = new Login();
    l.start();
        
    }
    
  void start(){
  
    frame = new JFrame();
    frame.setSize(800,800);
    frame.setVisible(true);
    frame.setLocation(350,250);
    frame.setTitle("ATM");
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setState(JFrame. MAXIMIZED_BOTH) ;
    
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setLayout(null);
    
    
    north = new JPanel();
    north.setBackground(Color.WHITE);
    frame.getContentPane().add(BorderLayout.NORTH,north);
  
    ImageIcon i1 = new ImageIcon("/home/aman/JAVA/PROJ1/ATMSim/logo1.jpg");
    Image img = i1.getImage();
    Image img2 = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(img2);
    logo = new JLabel(i2);
    //logo.setBounds(200,50,100,100);
    //frame.getContentPane().add(BorderLayout.NORTH,logo);
    north.add(logo);
    
    title = new JLabel("WELCOME TO ATM");
    title.setFont(new Font("Osward",Font.BOLD,38));
    //title.setBounds(350, 50,1000,100);
    //frame.getContentPane().add(BorderLayout.NORTH,title);
    north.add(title);
    
    
    center = new JPanel();
    center.setBackground(Color.WHITE);
    frame.getContentPane().add(BorderLayout.CENTER,center);
    
    center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
    
   // Box.Filler glue2 = (Box.Filler)Box.createVerticalGlue();
   // glue2.changeShape(glue2.getMinimumSize(), new Dimension(0,Short.MAX_VALUE),glue2.getMaximumSize());
   // center.add(glue2);
   center.add(Box.createRigidArea(new Dimension(100, 200)));
    
    center_top =  new JPanel();
    center_top.setBackground(Color.WHITE);
    center.add(center_top);
    
    center_bottom =  new JPanel();
    center_bottom.setBackground(Color.WHITE);
    center.add(center_bottom);
    
    
    cardNo = new JLabel("Card No.");
    cardNo.setFont(new Font("Raleway",Font.BOLD,28));
    center_top.add(cardNo);
    
    cardNo_ = new JTextField(15);
    cardNo_.setFont(new Font("Ariel",Font.BOLD,14));
    center_top.add(cardNo_);
    
    pinNo = new JLabel("PIN No.");
    pinNo.setFont(new Font("Raleway",Font.BOLD,28));
    center_bottom.add(pinNo);
    
    center_bottom.add(Box.createRigidArea(new Dimension(15,15)));
    
    pinNo_ = new JPasswordField(15);
    pinNo_.setFont(new Font("Ariel",Font.BOLD,14));
    center_bottom.add(pinNo_);
    
   // Box.Filler glue = (Box.Filler)Box.createVerticalGlue();
   // glue.changeShape(glue.getMinimumSize(), new Dimension(0,Short.MAX_VALUE),glue.getMaximumSize());
   // center.add(glue);
   center.add(Box.createRigidArea(new Dimension(100, 300)));

   
   
   
   south = new JPanel();
   south.setBackground(Color.WHITE);
   frame.getContentPane().add(BorderLayout.SOUTH, south); 
   south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
   
   south_top = new JPanel();
   south_top.setBackground(Color.WHITE);
   south.add(south_top); 
     
   clear = new JButton("Clear");
   clear.addActionListener(this);
   south_top.add(clear);
   
   signin = new JButton("Sign In");
   signin.addActionListener(this);
   south_top.add(signin);
   
   signup = new JButton("Sign Up");
   signup.addActionListener(this);
   south_top.add(signup);
     
   south.add(Box.createRigidArea(new Dimension(50,50)));
   
 
    
    }
    
    public void actionPerformed(ActionEvent e){
    
      if(e.getSource() == clear){
        cardNo_.setText("");
        pinNo_.setText("");
        }
      
      else if(e.getSource() == signup){
    //System.out.println(cardNo_.getText()+" "+pinNo_.getText());
    
    frame.setVisible(false);
    frame.dispose();  
    
    new SignUp().start();
    
        }
        
      else if(e.getSource() == signin){
      
       //deBUG
       
       System.out.println(    "signin clicked");
        
        String card_num = cardNo_.getText();
        String pin_No = pinNo_.getText();
        
        //deBUG
        
        System.out.println(card_num+pin_No);
        
       
        try{
          c1 = new Connect();
          con_ret = c1.signInCheck(card_num,pin_No);
          
          //deBU
          System.out.println(    "try completed cleanly");
          
        }
        catch(Exception exp)
        {
          System.out.println(exp.getMessage());
          
        }
        
        
        //
        System.out.println(    "con_re =="+con_ret);
        
        
        
        if (con_ret == 0){
          frame.setVisible(false);
          frame.dispose();
          
          //deBug
          
          System.out.println(" calling tanx start");
          new Tranx().start(pin_No);
          }
        else if(con_ret ==2){
        
          System.out.println(" opening Joptpane");      
          JOptionPane.showMessageDialog(null,"recheck Card Number or PIN");
          //JOptionPane.showMessageDialog(null,"Card No. - "+card_num+"\nPin - "+pin);
        }
        
    
   } 
  }
  }
