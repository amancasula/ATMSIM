package ATMSim;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Connect {

  Connect(){
  
  System.out.println("");
  
  }

  Connect(String regno,String name,String dob,String gender, String card_no, String pin_no)         throws        Exception  {
    
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
    Statement s = con.createStatement();
    
    System.out.println(name);
    
    if (name.equals("ADMIN")){
      
     // JOptionPane.showMessageDialog(null,"Admin access unlocked -- Printing Names");    
      ResultSet rs = s.executeQuery("select * from signup");
      while(rs.next()){
        System.out.println(""+rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
        }
      }  
       
      
    
    else{
    
      s.executeUpdate("insert into signup values('"+regno+"','"+name+"','"+dob+"','"+gender+"')");
      s.executeUpdate("insert into cred values('"+regno+"','"+card_no+"','"+pin_no+"')");
      }
      }
      
      int signInCheck(String card_num, String pin_num) throws Exception{
      
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
        Statement s = con.createStatement();
      
        ResultSet rs = s.executeQuery("select * from cred where card_no = '"+card_num+"' and pin_no = '"+pin_num+ "'");
        if( rs.next()){
          return 0;
          }
        return 2;
      }
      
      
      void deposit_func( String pin_num, String amt){
      
       try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
        Statement s = con.createStatement();
      
        ResultSet rs = s.executeQuery("select * from balance where pin_no = '"+pin_num+ "'");
        
        if( rs.next()){
        
          String prev_bal =  rs.getString(2);
          int prev_bal_ = Integer.parseInt(prev_bal);
          int amt_ = Integer.parseInt(amt);
          int new_bal_ = prev_bal_ + amt_;          
          String new_bal = ""+new_bal_;
          
          String date = new DateConverter().converter();
          
          s.executeUpdate("update balance set amt ='"+new_bal+"' where pin_no = '"+pin_num+"'");
          s.executeUpdate("insert into passbook values('"+pin_num+"','"+date+"','cr','"+amt+"')");
          

          

        
        }
        else{
        
          String date = new DateConverter().converter();
          
          s.executeUpdate("insert into balance values('"+pin_num+"','"+amt+"')");
          s.executeUpdate("insert into passbook values('"+pin_num+"','"+date+"','cr','"+amt+"')");
        }
        }
        catch (Exception exp1){
          exp1.printStackTrace();
          
        }    
      }
      
      
      
       String balance_func( String pin_num){
      
       try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
        Statement s = con.createStatement();

        ResultSet rs = s.executeQuery("select * from balance where pin_no = '"+pin_num+ "'");
        
        if( rs.next()){
        
          String curr_bal =  rs.getString(2);             
          return curr_bal;
          
        }
        else{
          
          return "0";
        }
        }
        catch (Exception exp1){
          exp1.printStackTrace();
          return "ERROR";
          
        }    
      }
      
      
      
      String withdraw_func( String pin_num, String amt){
      
       try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
        Statement s = con.createStatement();
      
        ResultSet rs = s.executeQuery("select * from balance where pin_no = '"+pin_num+ "'");
        
        
        
        if( rs.next()){
        
          String prev_bal =  rs.getString(2);
          int prev_bal_ = Integer.parseInt(prev_bal);
          int amt_ = Integer.parseInt(amt);
          
          if (amt_ <= prev_bal_){
            
            String date = new DateConverter().converter();
            int new_bal_ = prev_bal_ - amt_;          
            String new_bal = ""+new_bal_; 
            s.executeUpdate("update balance set amt ='"+new_bal+"' where pin_no = '"+pin_num+"'");  
            s.executeUpdate("insert into passbook values('"+pin_num+"','"+date+"','dr','"+amt+"')");
            return "SUCC";       
          
          }
          
          else{
          
            return "INSF";
          
          }
         
          
        }
        }
        
        catch (Exception exp1){
          exp1.printStackTrace();
          return "ERROR";
          
        }  
        return "";  
      }
      
      
      void pin_chg_func( String pin_num, String new_pin_num){
      
       try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
        Statement s = con.createStatement();
        
        s.executeUpdate("update balance set pin_no = '"+new_pin_num+"' where pin_no = '"+pin_num+"'");
        s.executeUpdate("update cred set pin_no = '"+new_pin_num+"' where pin_no = '"+pin_num+"'");
        s.executeUpdate("update passbook set pin_no = '"+new_pin_num+"' where pin_no = '"+pin_num+"'");
      
        
        
        
        }
        catch (Exception exp1){
          exp1.printStackTrace();
          
          
        }    
      }
      
      String mini_state_func(String pin_num){
      
       try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","debian-sys-maint","x2YcSV4C62Zzt7Kl");
    
        Statement s = con.createStatement();
        
        ResultSet rs = s.executeQuery("select * from passbook where pin_no = '"+pin_num+"' order by date desc limit 5");
        
        String mini = "   LAST 5 TRANSACTIONS:";
        
        while(rs.next()){
        
          String line = "\n"+rs.getString(2)+"       "+rs.getString(4)+"  "+                                                                                                                   rs.getString(3);
          mini += line;
          
        }
        
      
        return mini;      
        
        
        
        }
        catch (Exception exp1){
          exp1.printStackTrace();
          return "ERROR"; 
          
        }    
      }
      
      
      
      public static void main(String args[]) {
        try{
          Connect c = new Connect("","ADMIN","","","","");
        }
       catch(Exception e){
         e.printStackTrace();
         System.out.print(e.getMessage());      
      }
      }
      }
    
    
    
        
    


  
 

