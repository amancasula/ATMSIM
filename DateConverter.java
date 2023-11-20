package ATMSim;

import java.time.LocalDate;


class DateConverter{
  
  public static void main(String args[]){
    
    new DateConverter().converter();  
  
  }
  
  String converter(){
    
    LocalDate date = LocalDate.now();
    //System.out.println(date);
    
    String date_str = "" + date;
    //System.out.println(date_str);
    
    char[] dt = date_str.toCharArray();
   // System.out.println(dt);
    
    char[] dt2 = new char[dt.length];
    int j = 0;
    
    for( char i : dt){
      //System.out.println(i);
      if (i != '-'){
        
        dt2[j] = i;
        j++;
        
        }     
      }
    
    //System.out.println(dt2);
    //System.out.println(new String(dt2)); 
    return new String(dt2);
    }
    
  }
