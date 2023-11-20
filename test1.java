package ATMSim;


import java.io.*;

class Test{

  public static void main(String args[]) throws Exception{
  
    FileWriter writer = new FileWriter("Test.txt");
    
    writer.write("ONE\n");
    //writer.write("TWO\n");
    
    writer.close();
    
    FileReader reader = new FileReader("Test.txt");
    BufferedReader br=  new BufferedReader(reader);
    
    String str = "abc";
    while(br.readLine() != null){
      str = str + br.readLine();
    
    }
    System.out.println(str);
    
    br.close();
    reader.close();
    }
  }  

