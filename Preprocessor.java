package Formality;
import java.io.*;
public class Preprocessor {

	public static void main(String[] args) throws IOException {
//		if (args.length < 1) {
//			System.err.println("Usage: java ClassName <input_file>");
//			System.exit(1);
//			}
//			String input_file = args[0];
			String input_file = "C:/Users/Me/Documents/Java Course/Assignment2/src/Formality/inp1.txt";
			
			//using buffered reader/writer for file handling
			try {
				BufferedReader f = new BufferedReader(new FileReader(input_file));
				BufferedWriter o = new BufferedWriter(new FileWriter("out1.txt"));
				String line;
				//operational loop
				while ((line = f.readLine()) != null) {
					
					line = annotation(line);
					line = undesiredSpaces(line);	//trims line to eliminate blanksapces
					line = noImport(line);			//eliminates everything from import till ;
					line = singleLineComments(line);//eliminates single line comments
					if(isBlockComment(line)) {		//checks if block comment consisting over more than 1 line, if it is then skips till end of block is reached
						while(!line.contains("*/")&&line!=null) {
							line = f.readLine();
							if(line.contains("*/")) {
								int indexOfInit = line.indexOf("*/");
								line = line.substring(indexOfInit);
								if(line.equals("*/")){
									line = " ";
									break;
								}
							}
						}
					}
					
					
					if( blankLines(line)) {			//if theres a blank line, skips the current iteration of line hence skips the blank line
						continue;
					}
					
					System.out.println(line);
				}
				
				f.close();
				o.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
	}
	}
	
	//Method: eliminate blank lines
			public static boolean blankLines(String line) {
				if (line.trim().isEmpty()) {
					return true;
				}
				else {
					return false;
				}
			}
				
	//Method: eliminate undesired spaces
			public static String undesiredSpaces(String line) {
				return line.replaceAll("\\s+", " ").trim();

			}
	// Method: eliminate import statement
			public static String noImport(String line) {
				if (line.contains("import")){
					
					int indexOfImport = line.indexOf("import ");
			        int indexOfSemi = line.indexOf(";", indexOfImport);
			        
			        
			        if (indexOfImport != -1 && indexOfSemi != -1) {
			            return line.substring(0, indexOfImport) + line.substring(indexOfSemi + 1);
			        } 
			        else {
			        	return line;	
			        }
			    }
				else {
					return line;
				}				
			}
	// Method eliminate annotations
			public static String annotation(String line) {
				 if(line.contains("@")) {
					 int indexOfAnnot = line.indexOf("@");
					 return line.substring(0,indexOfAnnot)+line.substring(indexOfAnnot+1); 
				 }
				 else {
					 return line;
				 }
			}
	//Method: eliminate comments
			public static boolean isBlockComment(String line) {
				 if(line.contains("/*")) {
					 return true;
				 }
				 else {
					 return false;
				 }
			}
			
	//Method: eliminates single line comments
			public static String singleLineComments(String line) {
				if((line.contains("//"))||(line.contains("/*")&&line.contains("*/"))) {
					return line = " ";
				}
				else {
					return line;
				}
			}
			
			
			
}

	

