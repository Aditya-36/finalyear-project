package searchh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dem {

    public static void main(String[] args){

       int word=1;
                           
  String str = "1647,1967,1601,550,1218,453,1177,833,523,1786,1693,1865,107,1307,709,1852,630,51,223,119,";
 
  for(int i=0;i<str.length();++i)
  {
   if(str.charAt(i)==',')
    word++;
  }
 
  System.out.println("Number of words="+word);
  System.out.println("Number of spaces="+(word-1));
    }

}