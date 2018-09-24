package searchh;

import java.util.*;
 import java.io.*;
 public class WordCount {
//throws the exception
public static void main(String[] args) throws FileNotFoundException {
    //calls on each counter method and prints each one
    System.out.println("Number of Words: " + wordCounter());
    System.out.println("Number of Lines: " + lineCounter());
    System.out.println("Number of Characters: " + charCounter());

}

//static method that counts words in the text file  
public static int wordCounter() throws FileNotFoundException { 
//inputs the text file
Scanner input = new Scanner(new File("D:\\loadd\\users.txt")); 
    int countWords = 0;
    //while there are more lines
    while (input.hasNextLine()) {
        //goes to each next word
        String word = input.next();
        //counts each word
        countWords++;
    }
    return countWords;
}

//static method that counts lines in the text file  
public static int lineCounter() throws FileNotFoundException {
//inputs the text file
Scanner input2 = new Scanner(new File("D:\\loadd\\users.txt"));
    int countLines = 0;
    //while there are more lines
    while (input2.hasNextLine()) {
        //casts each line as a string
        String line = input2.nextLine();
        //counts each line
        countLines++;
    }
    return countLines;
   }    

//static method that counts characters in the text file 
public static int charCounter() throws FileNotFoundException {
//inputs the text file
Scanner input3 = new Scanner(new File("D:\\loadd\\users.txt"));
    int countChar = 0;
    int character = 0;
    //while there are more lines
    while(input3.hasNextLine()) {
       //casts each line as a string
        String line = input3.nextLine();
        //goes through each character of the line
        for(int i=0; i < line.length(); i++){
            character = line.charAt(i);
             //if character is not a space (gets rid of whitespace)
            if (character != 32){
                //counts each character
                countChar++;
            }
        }           
    }
   return countChar;
}
} 