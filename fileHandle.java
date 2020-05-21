package manageStudent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileHandle {
     
    public void inputFile(String filepath , ArrayList<String> arr) throws IOException 
     {
    	 try (BufferedReader bin = new BufferedReader(new FileReader(filepath))){
    		String line;
    		while((line = bin.readLine()) != null)
			{
				 String readfile = new String();
				 readfile = line;
				 arr.add(readfile);
			}	
    	 }
   
     }
     public void outputFile(String filepath , ArrayList<String> arr) throws IOException 
     {
    	 try (BufferedWriter bout = new BufferedWriter(new FileWriter(filepath))){
    		for(int i = 0 ; i < arr.size() ; i++)
    		{
    			bout.write(arr.get(i));
    			bout.newLine();
    		}	
    	 }
    	 
     }
}
