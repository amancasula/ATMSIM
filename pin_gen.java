package ATMSim;

import java.io.*;
import java.util.*;




class PinGenerator{

  public static void main(String args[]) throws Exception{
    
    
    
  
    
    
    
    
    
   
    new PinGenerator().gen(); 
  
    }
    
  int gen() throws Exception{
  
    Random rand = new Random();
    int pin = rand.nextInt(9999 - 1111) + 1111;
    //int pin = 1111;
    String pin_ = String.valueOf(pin);
    System.out.println(pin_);
    
    
    BufferedReader br = new BufferedReader(new FileReader("ATMSim/Pin.txt"));
    
    String page = "";
    String line = " ";
    
    while( (line = br.readLine()) != null){
    
      page+=line;
    
    }
    
    
    
    System.out.println(page);
    String[] pin_arr = page.split("X");
    System.out.println(pin_arr);
    
    ArrayList<String> pin_arrl = new ArrayList<>();
    for(String i : pin_arr){
      pin_arrl.add(i);
      }
      
    System.out.println(pin_arrl);
    
    
    
    
    while(pin_arrl.contains(pin_)){
    
      pin = rand.nextInt(9999 - 1111) + 1111;
      pin_ = String.valueOf(pin);
      System.out.println(pin_);
      
      
    }
    
return 100;
      
      }
    
      
    
    
      
      
      }  
    
    
     
  
  
 
  
  
  
 
