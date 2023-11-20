package ATMSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



class Tranx implements ActionListener{


  JFrame frame3;
  Image img;
  ImageIcon atm ;
  JLabel img_lab, title_lab; 
  JButton deposit, exit, withdrawal, mini_state, pin_chg, bal_enq, button_x, button_y;
  JTextField tb1;
  String pin_No;
  
  
  public static void main(String ags[]){
  
    new Tranx().start("1111");
    
    }
    
    void start(String pin_No){
    
      this.pin_No = pin_No;
      frame3 = new JFrame();
      frame3.setVisible(true);
      frame3.setSize(900,900);
      frame3.setLocation(900,900);
      frame3.setTitle("ATM");
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //f? rame3.setUndecorated(true);
      frame3.setLayout(null);
      
      ImageIcon atm = new ImageIcon("/home/aman/JAVA/PROJ1/ATMSim/atm.jpg");
      Image  img = atm.getImage();
      img = img.getScaledInstance(900,900,Image.SCALE_DEFAULT);
      atm = new ImageIcon(img);
      
      img_lab = new JLabel(atm);
      img_lab.setBounds(180, 0, 900, 900); 
       
      frame3.getContentPane().add(img_lab);
       
      deposit = new JButton("DEPOSIT");
      withdrawal = new JButton("WITHDRAW");
      mini_state = new JButton("MINI-STATEMENT");
      pin_chg = new JButton("PIN CHANGE");
      bal_enq = new JButton("BALENCE ENQ");
      exit = new JButton("EXIT");
      button_x = new JButton();
      button_y = new JButton();
      
      deposit.setBounds(160,415,150,35);
      withdrawal.setBounds(160, 460, 150, 35);
      pin_chg.setBounds(160, 505,150,35);
      button_x.setBounds(160,370,150,35);
      bal_enq.setBounds(360,415,150,35);
      mini_state.setBounds(360, 460,150, 35);
      exit.setBounds(360,505,150,35);
      button_y.setBounds(360,370,150,35);
      
      
      deposit.addActionListener(this);
      withdrawal.addActionListener(this);
      pin_chg.addActionListener(this);
      bal_enq.addActionListener(this);
      mini_state.addActionListener(this);
      exit.addActionListener(this);
      button_x.addActionListener(this);
      button_y.addActionListener(this);
      
      
      
      img_lab.add(deposit);
      img_lab.add(withdrawal);
      img_lab.add(mini_state);
      img_lab.add(pin_chg);
      img_lab.add(bal_enq);
      img_lab.add(exit);
      img_lab.add(button_x);
      img_lab.add(button_y);
      
     
      
      title_lab = new JLabel();
      title_lab.setBounds(195,280,400,35);
      title_lab.setFont(new Font("System",Font.BOLD,16));
      title_lab.setForeground(Color.WHITE);
      title_lab.setBackground(Color.BLACK);
      img_lab.add(title_lab);
      
      tb1 = new JTextField();
      tb1.setBounds(175,320,320,25);
      img_lab.add(tb1);
     
      title_lab.setVisible(false);
      button_x.setVisible(false);
      button_y.setVisible(false);
      tb1.setVisible(false);
      
      
      
      
      
      }

  public void actionPerformed(ActionEvent e){
  
    if (e.getSource() == exit){
    
      frame3.setVisible(false);
      frame3.dispose();
    
    }
    
    if(e.getSource() == deposit){
    
      title_lab.setBounds(210,280,400,35);   
      title_lab.setText("ENTER AMOUNT TO DEPOSIT");
      title_lab.setVisible(true);
      button_x.setText("BACK");
      button_y.setText("DEPOSIT");
      button_x.setVisible(true);
      button_y.setVisible(true);
      tb1.setVisible(true);
      deposit.setVisible(false);
      withdrawal.setVisible(false);
      pin_chg.setVisible(false);
      bal_enq.setVisible(false);
      mini_state.setVisible(false);
      exit.setVisible(false);
      tb1.setEditable(true);
      tb1.setText("");
        
       }
    if (e.getSource() == withdrawal){
    
      title_lab.setBounds(195,280,400,35);
      title_lab.setText("ENTER AMOUNT TO WITHDRAW");
      title_lab.setVisible(true);
      button_x.setText("BACK");
      button_y.setText("WITHDRAW");
      button_x.setVisible(true);
      button_y.setVisible(true);
      tb1.setVisible(true);
      deposit.setVisible(false);
      withdrawal.setVisible(false);
      pin_chg.setVisible(false);
      bal_enq.setVisible(false);
      mini_state.setVisible(false);
      exit.setVisible(false);
      tb1.setEditable(true);
      tb1.setText("");
      
       }
     
    if (e.getSource() == pin_chg){
    
      title_lab.setBounds(255,280,400,35);
      title_lab.setText("ENTER NEW TO PIN");
      title_lab.setVisible(true);
      button_x.setText("BACK");
      button_y.setText("CONFIRM");
      button_x.setVisible(true);
      button_y.setVisible(true);
      tb1.setVisible(true);
      deposit.setVisible(false);
      withdrawal.setVisible(false);
      pin_chg.setVisible(false);
      bal_enq.setVisible(false);
      mini_state.setVisible(false);
      exit.setVisible(false);
      tb1.setEditable(true); 
      tb1.setText("");
      
       }     
     
    if (e.getSource() == bal_enq){
    
      title_lab.setBounds(255,280,400,35);
      title_lab.setText("YOUR BALENCE IS");
      title_lab.setVisible(true);
      button_x.setText("BACK");
     // button_y.setText("CONFIRM");
      button_x.setVisible(true);
     // button_y.setVisible(true);
      tb1.setVisible(true);
      deposit.setVisible(false);
      withdrawal.setVisible(false);
      pin_chg.setVisible(false);
      bal_enq.setVisible(false);
      mini_state.setVisible(false);
      exit.setVisible(false);
      Connect c = new Connect();
      String curr_bal = c.balance_func(pin_No);
      tb1.setText(curr_bal);
      tb1.setEditable(false); 
    
       }
       
    if (e.getSource() == mini_state){
    
       
        Connect c = new Connect();
        String mini = c.mini_state_func(pin_No);
        JOptionPane.showMessageDialog(null,mini);
    
       } 
       
   if (e.getSource() == button_x){
    
      //title_lab.setBounds(245,280,400,35);
      //title_lab.setText("ENTER NEW TO PIN");
      title_lab.setVisible(false);
      //button_x.setText("BACK");
      //button_y.setText("CONFIRM");
      button_x.setVisible(false);
      button_y.setVisible(false);
      tb1.setVisible(false);
      deposit.setVisible(true);
      withdrawal.setVisible(true);
      pin_chg.setVisible(true);
      bal_enq.setVisible(true);
      mini_state.setVisible(true);
      exit.setVisible(true);
    
       } 
       
       
  if (e.getSource() == button_y){
    
      if(button_y.getText().equals("DEPOSIT")){
      
        String amt = tb1.getText();     
        Connect c = new Connect();
        c.deposit_func(pin_No,amt);
        button_x.doClick();
      
      
      }
      
      if(button_y.getText().equals("WITHDRAW")){
      
        String amt = tb1.getText();     
        Connect c = new Connect();
        String code = c.withdraw_func(pin_No,amt);
        if (code.equals("SUCC")){  
          button_x.doClick();
        }
        else if (code.equals("INSF")){
        
          JOptionPane.showMessageDialog(null,"INSUFFICENT BALENCE!!!");
        
        }
        
        }
        
        if(button_y.getText().equals("CONFIRM")){
      
        String pin = tb1.getText();     
        Connect c = new Connect();
        c.pin_chg_func(pin_No,pin);
        button_x.doClick();       
    
        
        
        
        }
      
      
      }
      
      
      
    
       }                 
  }    
    
