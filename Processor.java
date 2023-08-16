package Formality;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Processor {
	private String inFile;
    public static void main(String[] args) throws IOException {
//    	if (args.length < 1) {
//			System.err.println("Usage: java ClassName <input_file>");
//			System.exit(1);
//			}
//			String input_file = args[0];
			String input_file = "C:/Users/Me/Documents/Java Course/Assignment2/out1.txt";
			String out_file = "C:/Users/Me/Documents/Java Course/Assignment2/out2.txt";
			Processor object = new Processor(input_file);
			object.process("out2");
			
			
			
			
    }
    //constructor
    public Processor(String inFile) {
        this.inFile = inFile;
    }
  //Method: Displaying on console
    public void Display(String outFile) throws IOException {
    	BufferedReader read = new BufferedReader(new FileReader(outFile));
    	System.out.print(read.readLine());	//since its a 1d array and there's only 1 line
    	read.close();
    }
	
    //Method: reads, writes and displays file
    public void process(String outFile) throws IOException   { 
		 FileReader r = new FileReader(this.inFile);		//to read character by character
		 FileWriter w = new FileWriter(outFile);			//to write
		// File f = new File(this.inFile);
		// Scanner s = new Scanner(new File(this.inFile));

		// ArrayList<Character> charList = new ArrayList<>();;
		 int checker;
		 char ch;
		 while ((checker=r.read())!=-1) {
			 	ch = (char) checker;
			 	if (ch!='\n'&& ch!='\r') {
			 	w.write(ch);
			 	}
			 	else if(ch=='\n'){
			 		continue;
			 	}	
		 }
		 w.write('$');
		 w.close();
		 Display(outFile);
		 
	 }
}
	/*
	 * // Method: reading from file and determining array size public void read()
	 * throws IOException { BufferedReader read = new BufferedReader(new
	 * FileReader(inFile));
	 * 
	 * int chint; while ((chint = read.read()) != -1) { char ch = (char) chint; if
	 * (ch != '\n') { arrSize++; } } read.close();
	 * 
	 * arr = new char[arrSize+1]; int i = 0;
	 * 
	 * BufferedReader n = new BufferedReader(new FileReader(inFile)); int chint2;
	 * while ((chint2 = n.read()) != -1) { char ch = (char) chint2; if (ch == '\n')
	 * { continue; } else { arr[i] = ch; i++;; }
	 * 
	 * } arr[arrSize]='$';
	 * 
	 * n.close(); }
	 */
    
	 //Method: reads from input file, writes on output file
//	 public void process(String outFile) throws IOException   { 
//		// FileReader r = new FileReader(this.inFile);		//to read character by character
//		 FileWriter w = new FileWriter(outFile);			//to write
//		// File f = new File(this.inFile);
//		 Scanner s = new Scanner(new File(this.inFile));
//
//		 ArrayList<Character> charList = new ArrayList<>();;
//		 while (s.hasNext()) {
//			 	String str = s.next();
//			 	for (char ch : str.toCharArray()) {
//	                
//	                    charList.add(ch);
//	                
//			 	}
//	        
//		 }
//	        for (char c : charList) {
//	            if (c == '\n') {
//	                continue;
//	            } else {
//	                System.out.print(c);
//	            }
//	        }
//		 
//		 w.close();
//		 s.close();
//	 }
    //Method: writing on output file
	/*
	 * public void write(String outFile) throws IOException { FileWriter out = new
	 * FileWriter(outFile); for(int i=0; i<=arrSize;i++) { if(arr[i]=='\n') {
	 * continue; } else { out.write(arr[i]);
	 * 
	 * 
	 * } System.out.print(arr[i]);
	 * 
	 * } out.close(); }
	 */
    
