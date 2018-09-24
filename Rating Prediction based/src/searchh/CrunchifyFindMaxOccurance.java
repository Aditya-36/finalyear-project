package searchh;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import rating.prediction.based.dobc;
 
public class CrunchifyFindMaxOccurance {
 
	/**
	 * @author Crunchify.com
	 */
 
	public static void main(String[] args) throws FileNotFoundException, IOException {
        try {         
            ResultSet rs; 
           
        Connection  con =  dobc.getConne();
        Statement  st = (Statement) con.createStatement();
         rs = (ResultSet) st.executeQuery("SELECT *  FROM  pet_user_feedback where pet_itemid  = 10 ");
              while(rs.next())
               {
 
                try {
                   String userids = rs.getString("pet_userid");
                   String  useriddd = rs.getString("pet_itemid");
                   String feed = rs.getString("pet_feedback");
                
                 File file = new File(feed);
                 BufferedReader bufferedReader = null;
                 bufferedReader = new BufferedReader(new FileReader(file));
                 String inputLine = null;
                 Map<String, Integer> crunchifyMap = new HashMap<>();
  
                 try {
                         while ((inputLine = bufferedReader.readLine()) != null) {
                                 String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
  
                                 for (int counter = 0; counter < words.length; counter++) {
                                         String key = words[counter].toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                                         if (key.length() > 0) {
                                                 if (crunchifyMap.get(key) == null) {
                                                         crunchifyMap.put(key, 1);
                                                 } else {
                                                         int value = crunchifyMap.get(key).intValue();
                                                         value++;
                                                         crunchifyMap.put(key, value);
                                                 }
                                         }
                                 }
                         }
                 
                 
                         Set<Map.Entry<String, Integer>> entrySet = crunchifyMap.entrySet();
                         System.out.println("Words" + "\t\t" + "# of Occurances");
                         for (Map.Entry<String, Integer> entry : entrySet) {
                                 System.out.println(entry.getKey() + "\t\t" + entry.getValue());
                         }
                         List<String> myTopOccurrence = crunchifyFindMaxOccurance(crunchifyMap, 1);
                         System.out.println("\nMaixmum Occurance of Word in file: ");
                         for (String result : myTopOccurrence) {
                                 System.out.println("==> " + result);
                         }
                 
                 }
  
                 catch (IOException error) {
                         System.out.println("Invalid File");
                 } finally {
                         bufferedReader.close();
                 }
                
         }
 
                catch (SQLException ex) {
                        Logger.getLogger(CrunchifyFindMaxOccurance.class.getName()).log(Level.SEVERE, null, ex);
                }
               
        }
        } catch (SQLException ex) {
            Logger.getLogger(CrunchifyFindMaxOccurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

 
	/**
	 * @param map
	 *            = All Words in map
	 * @param n
	 *            = How many top elements you want to print? If n=1 it will print highest occurrence word. If n=2 it
	 *            will print top 2 highest occurrence words.
	 * @returns list of String
	 */
	public static List<String> crunchifyFindMaxOccurance(Map<String, Integer> map, int n) {
		List<CrunchifyComparable> l = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet())
			l.add(new CrunchifyComparable(entry.getKey(), entry.getValue()));
 
		Collections.sort(l);
		List<String> list = new ArrayList<>();
		for (CrunchifyComparable w : l.subList(0, n))
			list.add(w.wordFromFile + ":" + w.numberOfOccurrence);
		return list;
	}
}
 
class CrunchifyComparable implements Comparable<CrunchifyComparable> {
	public String wordFromFile;
	public int numberOfOccurrence;
 
	public CrunchifyComparable(String wordFromFile, int numberOfOccurrence) {
		super();
		this.wordFromFile = wordFromFile;
		this.numberOfOccurrence = numberOfOccurrence;
	}
 
	@Override
	public int compareTo(CrunchifyComparable arg0) {
		int crunchifyCompare = Integer.compare(arg0.numberOfOccurrence, this.numberOfOccurrence);
		return crunchifyCompare != 0 ? crunchifyCompare : wordFromFile.compareTo(arg0.wordFromFile);
	}
 
	@Override
	public int hashCode() {
		final int uniqueNumber = 19;
		int crunchifyResult = 9;
		crunchifyResult = uniqueNumber * crunchifyResult + numberOfOccurrence;
		crunchifyResult = uniqueNumber * crunchifyResult + ((wordFromFile == null) ? 0 : wordFromFile.hashCode());
		return crunchifyResult;
	}
 
	@Override
	public boolean equals(Object crunchifyObj) {
		if (this == crunchifyObj)
			return true;
		if (crunchifyObj == null)
			return false;
		if (getClass() != crunchifyObj.getClass())
			return false;
		CrunchifyComparable other = (CrunchifyComparable) crunchifyObj;
		if (numberOfOccurrence != other.numberOfOccurrence)
			return false;
		if (wordFromFile == null) {
			if (other.wordFromFile != null)
				return false;
		} else if (!wordFromFile.equals(other.wordFromFile))
			return false;
		return true;
	}
}
