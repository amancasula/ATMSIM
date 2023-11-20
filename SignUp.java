package ATMSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;
import com.toedter.calendar.JDateChooser;
//import java.util.stream;


class SignUp implements ActionListener, ItemListener{

  JFrame frame2;
  JPanel north2, center2, name_pan, gender_pan,date_pan , citizen_pan, services_pan;
  JLabel title2 , name, gender, date_lab, services_lab;
  JTextField name_ , country;
  ButtonGroup bg1;
  JRadioButton male, female;
  JButton submit;
  JDateChooser date;
  JComboBox citizen_status  ;
  JCheckBox c1, c2, c3;
  int rand_num, pin;
  long card_num;
  
  
  
  public static void main(String args[]){
  
    SignUp o = new SignUp();
    o.start(); 
  
    }
  
  void start(){
    
    frame2 = new JFrame();
    frame2.setVisible(true);
    frame2.setSize(400,400);
    frame2.setLocation(350,250);
    frame2.setTitle("Sign Up");
    frame2.getContentPane().setBackground(Color.WHITE);
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
//    Random random = new Random();
//    IntStream is = random.ints(1,1111,9999);
//    OptionalInt opt = is.findFirst();
//    int rand_num = opt.getAsInt(); 
//          OR
//    String rand_str = is.toString();
//    int rand_num = Integer.parseInt(rand_str);
//    WORKING IN JSHELL BUT NOT WITH JAVAC
  
    
    Random rand = new Random();
    rand_num = rand.nextInt(9999 - 1111) + 1111;
    card_num = Math.abs(rand.nextLong() % (9999999999999999l - 1111111111111111l) + 1111111111111111l);
    pin = rand.nextInt(9999 - 1111) + 1111;
     
    
    north2 = new JPanel();
    north2.setBackground(Color.WHITE);
    frame2.getContentPane().add(BorderLayout.NORTH,north2);
    
    
    title2 = new JLabel("Regestration Form No. "+rand_num);
    title2.setFont(new Font("Raleway",Font.BOLD,32));   
    north2.add(title2);
    
    
    center2 = new JPanel();
    center2.setBackground(Color.WHITE);
    frame2.getContentPane().add(BorderLayout.CENTER,center2);
    center2.setLayout(new BoxLayout(center2, BoxLayout.Y_AXIS));
    
    center2.add(Box.createRigidArea(new Dimension(30,30)));
    
    name_pan = new JPanel();
    name_pan.setBackground(Color.WHITE);
    center2.add(name_pan);
    
    
    
    name = new JLabel("Enter Name: ");
    name.setFont(new Font("Raleway",Font.PLAIN,18));
    name_pan.add(name);
    
    //
    name_pan.add(Box.createRigidArea(new Dimension(55,55)));
    
    name_ = new JTextField(9);
    name_.setFont(new Font("Raleway",Font.PLAIN,18));  
    name_pan.add(name_); 
    
    //name_pan.setBackground(Color.CYAN);
    

    
    gender_pan = new JPanel();
    gender_pan.setBackground(Color.WHITE);
    center2.add(gender_pan);
    
    gender = new JLabel("Enter Gender: " );
    gender.setFont(new Font("Raleway",Font.PLAIN,18));
    gender_pan.add(gender);
    
    //
    gender_pan.add(Box.createRigidArea(new Dimension(40,40)));
    
    male = new JRadioButton("Male");
    male.setFont(new Font("Raleway",Font.PLAIN,18));
    male.setBackground(Color.WHITE);
    female = new JRadioButton("Female");
    female.setFont(new Font("Raleway",Font.PLAIN,18));
    female.setBackground(Color.WHITE);
    gender_pan.add(male);
    gender_pan.add(female);
    
    bg1= new ButtonGroup();
    bg1.add(male);
    bg1.add(female);
    
    date_pan = new JPanel();
    date_pan.setBackground(Color.WHITE);
    center2.add(date_pan);
    
    date_lab = new JLabel("Enter DOB: ");
    date_lab.setFont(new Font("Raleway",Font.PLAIN,18));
    date_pan.add(date_lab);
    
    //
    date_pan.add(Box.createRigidArea(new Dimension(65,55)));
    
   
    date = new JDateChooser();
    date.setFont(new Font("Raleway",Font.PLAIN,9));
    date.setPreferredSize(new Dimension(160,20));
    //date.getComponent(0).setPreferredSize(new Dimension(100,20)); //JFormattedTextField
    //date.getComponent(1).setPreferredSize(new Dimension(15,15));//JButton
    date_pan.add(date);
    
    citizen_pan = new JPanel();
    citizen_pan.setBackground(Color.WHITE);
    center2.add(citizen_pan);
    
    
    citizen_pan.add(Box.createRigidArea(new Dimension(4 ,55))          );
    
    String[] citizen = {"citizen","NRI","Non citizen"};
    citizen_status = new JComboBox(citizen);
    citizen_status.setFont(new Font("Raleway",Font.PLAIN,16));
    citizen_status.setBackground(Color.WHITE);
    citizen_pan.add(citizen_status);
    citizen_status.addItemListener(this);   
    
    
    //
    citizen_pan.add(Box.createRigidArea(new Dimension(50 ,55))          );
    
    country = new JTextField(11);
    country.setFont(new Font("Raleway",Font.PLAIN,16));
    country.setEditable(false);
    country.setVisible(false);
    citizen_pan.add(country);
    country.setText("INDIA");
    
    
    services_pan = new JPanel(); 
    services_pan.setBackground(Color.WHITE);
    center2.add(services_pan);
    
    services_pan.add(Box.createRigidArea(new Dimension(370 ,55)));
      
    services_lab = new JLabel("Opt Services: ");
    services_lab.setFont(new Font("Raleway",Font.PLAIN,18));
    services_pan.add(services_lab);
    
    
    //
    services_pan.add(Box.createRigidArea(new Dimension(62 ,55)));
    
    c1 = new JCheckBox("Internet & Mobile banking");
    c1.setFont(new Font("Raleway",Font.PLAIN,18));
    c1.setBackground(Color.WHITE);
    services_pan.add(c1);
    
    services_pan.add(Box.createRigidArea(new Dimension(15 ,55)));
    
    c2 = new JCheckBox("E-Statement");
    c2.setFont(new Font("Raleway",Font.PLAIN,18));
    c2.setBackground(Color.WHITE);
    services_pan.add(c2);
    
    services_pan.add(Box.createRigidArea(new Dimension(15 ,55)));
    
    c3 = new JCheckBox("Cheque");
    c3.setFont(new Font("Raleway",Font.PLAIN,18));
    c3.setBackground(Color.WHITE);
    services_pan.add(c3);
    
    
    center2.add(Box.createRigidArea(new Dimension(15 ,40)));

    
    submit = new JButton("SUBMIT");
    center2.add(submit);
    submit.addActionListener(this);
    
    
   center2.add(Box.createRigidArea(new Dimension(450,450)));
   
   //north2.setBackground(Color.CYAN);
   //name_pan.setBackground(Color.CYAN);
   //date_pan.setBackground(Color.CYAN);
   //services_pan.setBackground(Color.CYAN);
   //submit.setBackground(Color.CYAN);
    
    
    }
    
    public void actionPerformed(ActionEvent e) {
    
    /*if (e.getSource() == citizen_status){
        
    /  country.setVisible(true);
      
      String status = (String)citizen_status.getSelectedItem();
      
      if(status.equals("NRI") || status.equals("Non citizen")) {
      
        country.setEditable(true);
        }
      
      else
      {
        country.setText("INDIA");      
        country.setEditable(                                                                   false           );
      }
        
    
      return;
    }*/
    
    String reg_field = ""+rand_num;
    
    //System.out.println(name_.getText()+" is Name");
    String name_field = name_.getText();
    
    JTextField date_tf = (JTextField)(date.getDateEditor());
    //System.out.println(date_tf.getText());
    String dob_field = date_tf.getText();
    
    String gender_field = null;
    if(male.isSelected()){
      //System.out.println(male.getText()+" is selected");
      gender_field = male.getText();
      }
    else if (female.isSelected()) {
      //System.out.println(female.getText()+" is selected");
      gender_field = male.getText();
      }
      
      
    String card_num_str = ""+card_num;
    String pin_str = ""+pin;
    try{
      Connect c = new Connect(reg_field, name_field, dob_field, gender_field, card_num_str, pin_str);
    }
    catch(Exception exp){
    System.out.println("WRROR");
    }
    
    Map<JCheckBox, String> hp = new HashMap<>();
    hp.put(c1,"M&I");
    hp.put(c2,"ES");
    hp.put(c3,"CQ");
    
    String serv = "";
    for(JCheckBox i : hp.keySet()){
      if (i.isSelected())
        serv = serv +"+"+hp.get(i);
         }
    
    System.out.println(serv);
    
    /*
    OR
    for(String i : hp.vaues()){
      System.out.println(i);
      }
    */
    
    JOptionPane.showMessageDialog(null,"Card No. - "+card_num+"\nPin - "+pin);
    
    frame2.setVisible(false);
    frame2.dispose();    

 
   }
   
   public void itemStateChanged(ItemEvent e){
     if (e.getSource() == citizen_status){
        
      country.setVisible(true);
      
      String status = (String)citizen_status.getSelectedItem();
      
      if(status.equals("NRI") || status.equals("Non citizen")) {
      
        country.setEditable(true);
        }
      
      else
      {
        country.setText("INDIA");      
        country.setEditable(                                                                   false           );
      }
        
    
    }
   
   
   } 
  }
