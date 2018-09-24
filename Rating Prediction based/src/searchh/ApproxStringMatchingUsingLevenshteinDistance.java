package searchh;
 
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class ApproxStringMatchingUsingLevenshteinDistance
{
    public static int distance(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = "In computer science, approximate string matching, "
                + "often colloquially referred to as fuzzy string searching is the technique of finding strings that match a pattern approximately rather than exactly. "
                + "The problem of aproximalive string matching is typically divided into two sub-problems: finding approximate substring matches inside a given string and finding "
                + "dictionary strings that match the pattern approximately.";
        System.out.println("System genetated string is: \n'" + text + "'");
        System.out.println("Enter the keyword to search: ");
//        String keyword = sc.nextLine();
//         String keyword = "science";
         String[] keyword = {"science","approximate   ","string","return"};
         for (int k=0;k<=keyword.length-1;k++)
{
        String[] data = text.split(" ");
        List<Integer> dist = new ArrayList<Integer>();
        for (int i = 0; i < data.length; i++)
        {
            dist.add(distance(data[i], keyword[k]));
//            System.out.println(dist.get(0));
        }

        Collections.sort(dist);
          System.out.print("\n ");
        System.out.print("Did you mean: ");
        int wordCount = 0;
        for (int i = 0; i < data.length; i++)
        { 
          
          
            if (distance(data[i], keyword[k]) == dist.get(0)) 
            {      
               wordCount++;          
                System.out.print(data[i]+" ");
                 String dsfsd = data[i];
            if(distance(data[i],keyword[k]) == dist.get(0)){
                  
           System.out.println("view"+wordCount);  
                
            }
                

          }
          
          
           
          
            
          
        }
        }
        sc.close();
    }
}