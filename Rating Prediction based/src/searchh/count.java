/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java1
 */
public class count {
    
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("D:\\loadd\\users.txt");
                            
                            BufferedReader br = new BufferedReader(fr);
                            String line;
                            int total_no_of_words = 0;
                            
                            while((line=br.readLine())!=null)
                            {		
//                                    System.out.println("Read line" + line);
                                    String[] words_arr = line.split("\n");
                                    total_no_of_words += words_arr.length;
 int word=1;
                           
  String str = line;
 
  for(int i=0;i<str.length();++i)
  {
   if(str.charAt(i)==',')
    word++;
  }
     System.out.println("" + line+":"+(word-1));
  
                            }
                            System.out.println("Total no of words = " + total_no_of_words);
                            
                            
                           
        } catch (IOException ex) {
            Logger.getLogger(count.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
