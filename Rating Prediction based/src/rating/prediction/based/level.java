/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rating.prediction.based;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java1
 */
public class level {
    
    public static void main(String[] args) {
          
        Integer  wordCount = 0 ;
       Integer  totalCount = 0;
       
        String userids ;
               String useriddd ;
               String feed ;
        try {
            ResultSet rs; 
            
            FileInputStream in = new FileInputStream("D:\\loadd\\level-1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            String[] filearray;
           filearray = new String[12];

            while ((strLine = br.readLine()) != null) {

            for (int j = 0; j < filearray.length-1; j++){
            filearray[j] = br.readLine();
            
            System.out.println(filearray[j]);
            }

            }
               Connection  con =  dobc.getConne();
               Statement  st = (Statement) con.createStatement();
               rs = (ResultSet) st.executeQuery("SELECT *  FROM  pet_user_feedback where pet_itemid  = 10 ");
              
               
               
               while(rs.next())
               {
                    
                   userids = rs.getString("pet_userid");
                   useriddd = rs.getString("pet_itemid");
                     feed = rs.getString("pet_feedback");
                   
    String[] word = {"Pizza","something","taste","probably","delivery"};
//    String[] word = {filearray};
    //String word = "occurrences";
    for (int i=0;i<=word.length-1;i++)
    {
        totalCount = 0;
     wordCount = 0;
    Scanner s = new Scanner(feed);
    while (s.hasNext()) {
        totalCount++;
        if (s.next().equals(word[i])) wordCount++;
//         System.out.println("file  array:  " + word[i]);
    }
//     System.out.println("Word count:  " + wordCount);
//     
//    System.out.println("Total count: " + totalCount);
//    System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount); 
//    System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount); 
//               System.out.println("userid:  " + userids);
//               System.out.println("itemid:  " + useriddd);
//               System.out.println("itemid:  " + feed);
    
    }
                                  System.out.println("Word count:  " + wordCount);     
                System.out.println("Total count: " + totalCount);
               System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount); 
              System.out.println("userid:  " + userids);
              System.out.println("itemid:  " + useriddd);
               System.out.println("itemid:  " + feed);
               }
               
               
        } catch (SQLException ex) {
            Logger.getLogger(level.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(level.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
        
    }
    
}
