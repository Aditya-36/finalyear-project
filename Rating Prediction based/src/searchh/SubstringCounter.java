package searchh;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
 
public class SubstringCounter {
    public static void main(String[] args) {
       
             Integer count=0;
              List<String> timesArray = new ArrayList<String>();
              
            File file = new File("D:\\loadd\\level\\tt.txt");
           
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SubstringCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (scanner.hasNextLine()) {
            try {
                String[] times = scanner.nextLine().split("\t");
                for (String time : times) {
                    timesArray.add(time);
                }
                System.out.println(timesArray);
            String text=null;
            String userids;
             String  itemid;
            
            ResultSet rs; 
            Connection  con =  rating.prediction.based.dobc.getConne();
            Statement  st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery("SELECT *  FROM  homeser_user_feedback where homeser_itemid  = 296 ");
                  while(rs.next())
                   {
                try {
                    userids = rs.getString("homeser_userid");
                    itemid = rs.getString("homeser_itemid");
                     String feed = rs.getString("homeser_userfeed");
      text = feed;


     String[] regexp = times;
     for (int i=0;i<=regexp.length-1;i++)
     {
     System.out.println(regexp[i]);
         Pattern pattern = Pattern.compile(regexp[i]);
     Matcher matcher = pattern.matcher(text);
    
     for (count = 0; matcher.find(); count++)
         ;
     String status = "dsfds";
      String textt = "fgdfg";
     System.out.println("Count: " + count);
     Connection  con1 =  dobc.getConne();
    Statement st1=con1.createStatement();
    String sql="insert into userresult(item_id,user_id,count,status,feed) values ('"+itemid+"','"+ userids+"','"+count+"','"+regexp[i]+"','"+textt+"')";
    int x=st1.executeUpdate(sql);
    if(x!=0){
		System.out.println("not inserted");
	
		}
				else{
		
		System.out.println("uninserted");
		}
//        con.close();
//        st.close();
     }   
     
     System.out.println("userid: " + userids);
     System.out.println("Count: " +text);
     
     
        
                   }
                    catch (SQLException ex) {                  
                        Logger.getLogger(SubstringCounter.class.getName()).log(Level.SEVERE, null, ex);
                    }                  
       
    }       } catch (SQLException ex) {
                Logger.getLogger(SubstringCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
}
