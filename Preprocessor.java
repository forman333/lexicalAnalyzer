package Formality;
import java.io.*;
import java.nio.Buffer;
public class Preprocessor {
public static File output;
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
				String line = f.readLine();
				String nextLine;
				//operational loop
				while ((line = f.readLine()) != null) {
					
					line = annotation(line);		//skips line with annotation
					line = undesiredSpaces(line);	//trims line to eliminate blanksapces
					line = singleLineComments(line);//eliminates single line comments
					if(isBlockComment(line)) {
						line = blockComments(line,f);
					}
					/*
					 * if(line.contains("import ")&&(!line.substring(line.indexOf("import ")).
					 * contains(";"))) { if(line.equals("import"))
					 * 
					 * 
					 * if(line.contains(";")) { int indexOfImport = line.indexOf("import "); int
					 * indexOfSemi = line.indexOf(";", indexOfImport);
					 * 
					 * 
					 * if (indexOfImport != -1 && indexOfSemi != -1) { line = line.substring(0,
					 * indexOfImport) + line.substring(indexOfSemi + 1); } } else {
					 * while(!line.contains(";")&&line!=null) { line = f.readLine(); int
					 * indexOfImport = line.indexOf("import "); int indexOfSemi = line.indexOf(";",
					 * indexOfImport);
					 * 
					 * 
					 * if (indexOfImport != -1 && indexOfSemi != -1) { line = line.substring(0,
					 * indexOfImport) + line.substring(indexOfSemi + 1);
					 * 
					 * } } } }
					 */
					line = importOut(line,f);	
					if( blankLines(line)) {			//if theres a blank line, skips the current iteration of line hence skips the blank line
						continue;
					}
					
					o.write(line);
					
					o.newLine();
					 
				}
				
				Display("C:/Users/Me/Documents/Java Course/Assignment2/out1.txt");
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
	// Method: eliminates annotations
			public static String annotation(String line) {
				 if(line.contains("@")) {
					 int indexOfAnnot = line.indexOf("@");
					 if(line.equals(line)) {
					 return line.substring(0,indexOfAnnot)+line.substring(indexOfAnnot+1); 
					 }
				 }
				 return line;
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
	//Method: checks if same Line import statement
	/*
	 * public static String sameLineImport(String line) {
	 * if(line.contains("import ")&&line.contains(";")) { line =
	 * line.substring(0,line.indexOf("import "))+line.substring(line.indexOf(";"));
	 * if(line.equals(";")) { //to avoid null error return line = " "; } else {
	 * return
	 * line.substring(0,line.indexOf("import "))+line.substring(line.indexOf(";")+1)
	 * ; } } else { return line; } }
	 */
	//Method: handles import statement on multiple lines
			public static String importOut(String line, BufferedReader f) throws IOException {
				if(line.contains("import ")&&line.contains(";")) {
					 line = line.substring(0,line.indexOf("import "))+line.substring(line.indexOf(";"));		
					 if(line.equals(";")) {																		//to avoid null error
						 return line = " ";
					 }
					 else {
						 return line.substring(0,line.indexOf("import "))+line.substring(line.indexOf(";")+1);
					 }
				}
				
				else if((line.contains("import ")||line.contains("import"))&&(!line.contains(";"))) {
					if(line.equals("import")||line.equals("import ")) {
						while(!line.contains(";")&&f.readLine()!=null) {
							line = f.readLine();
					        if (line.contains(";")&&!line.equals(";")) {
					            line = line.substring(line.indexOf(";") + 1);
					            return line;
					        }
					        else if(line.equals(";")){
					        	line = f.readLine();
					        	return line;
					        }
							
						}
					}	
				}
				return line;
			}
	//Method: handles mutiple lines block comments
		
			public static String blockComments(String line, BufferedReader f) throws IOException {
				while(!line.contains("*/")&&f.readLine()!=null) {
					line = f.readLine();
					if(line.contains("*/")) {
						int indexOfInit = line.indexOf("*/");
						line = line.substring(indexOfInit);
						if(line.equals("*/")){
							return line = " ";
							
						}
						else {
							return line.substring(indexOfInit);
						}
					}
				}
				return line;
			}
			
		//Method: Display on console by reading from output file
			public static void Display(String file) throws IOException{
				BufferedReader read = new BufferedReader(new FileReader(file));
				String line=read.readLine();
				while(line!=null) {
					System.out.println(line);
					line=read.readLine();
				}
				read.close();
			}
			
			
}

	

