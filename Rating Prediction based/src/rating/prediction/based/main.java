/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rating.prediction.based;

import java.util.Scanner;

/**
 *
 * @author java1
 */
public class main {
    
     public static void main(String[] args) {
         
         
         String text = "Question : how to search for a particular word in a " +
        "text file containing texts of words and return return its " +
        "frequency or occurrences occurrences  occurrences  occurrences  occurrences search search search search ?";

String[] word = {"Search","occurrences","how","return"};
//String word = "how";
for (int i=0;i<=word.length-1;i++)
{
   int totalCount = 0;
int wordCount = 0;
Scanner s = new Scanner(text);
while (s.hasNext()) {
    totalCount++;
    if (s.next().equals(word[i])) wordCount++;
}

System.out.println("Word count:  " + wordCount);
System.out.println("Total count: " + totalCount);
System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount); 
}


         
     }
     
}
