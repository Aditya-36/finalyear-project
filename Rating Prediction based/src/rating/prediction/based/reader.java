package rating.prediction.based;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class reader {
    public static void main (String args[]){
        try {
            StringBuffer sb=new StringBuffer();
            FileInputStream in = new FileInputStream("D:\\loadd\\level-1.txt");
          BufferedReader br=new BufferedReader(new InputStreamReader(in));
          
          String temp=null;
          while((temp=br.readLine())!=null){
                  sb.append(temp);
              }
          
          String text = sb.toString();
          System.out.println("dsfsd"+sb);
        } catch (IOException ex) {
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        }
           
}

} 