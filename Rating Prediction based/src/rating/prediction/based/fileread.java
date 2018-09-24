/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rating.prediction.based;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java1
 */
public class fileread {
    
    public static void main(String[] args) throws FileNotFoundException {
        try {
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
        in.close();
        } catch (IOException ex) {
            Logger.getLogger(fileread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
