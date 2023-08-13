package Formality;

import java.io.*;
public class Preprocessor {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java ClassName <input_file>");
			System.exit(1);
			}
			String input_file = args[0];
	}
	
	
	public void op(String inputFile) throws IOException {
		//reads input file
		try {
			FileReader f = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		//creates output file
		FileWriter out = new FileWriter("output.txt");
		
		//variable ch stores character while traversing
		int ch;
		//checks if ch is in comment block
		boolean comment = false;
		//checks if ch has encountered import
		boolean isImport = false;
		
		//avoiding comments
		while ((ch==f.read())!=-1) {
			
		}
		
		
		
		
		
		//read input file
		//things to check:
		//empty line
		//take out spaces before and after the content
		//take out comments and blocks
		//more than one space
		//store in array list
		//write it on another output file
	}

}
