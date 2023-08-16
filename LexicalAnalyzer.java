package Formality;
import java.io.*;
public class LexicalAnalyzer {
	private String inFile;	
	public LexicalAnalyzer(String inputFile) {
		this.inFile = inputFile;
	}

	public static void main(String[] args) throws IOException {
		String input = "C:/Users/Me/Documents/Java Course/Assignment2/src/Formality/lexiTest.txt";
		LexicalAnalyzer object = new LexicalAnalyzer(input);
		object.op();
		
	}
	
	public void op() throws IOException {
		FileReader r = new FileReader(this.inFile);
		char[][] lexemes = {
	            { "if", "else", "while", "for", "do", "int", "float", "double", "char", "void", "boolean",		// Keywords
	              "true", "false", "return", "class", "public", "private", "protected", "static", "final",
	              "try", "catch", "throw", "interface" },
	            { "x", "y", "z", "sum", "count", "temp", "myVar", "myFunction" },								// Identifiers
	            { "+", "-", "*", "/", "%", "=", "+=", "-=", "*=", "/=", "==", "!=", "<", ">", "<=", ">=",		// Operators
	              "++", "--", "&&", "`" },
	            { "{", "}", "[", "]", "(", ")", ",", ";", ":", "." },											// Punctuators
	            { "42", "3.14", "\"Hello, world!\"", "'A'", "'9'", "true", "false", "null" },					// Literals
	            { "//", "/*"," */" },																			// Comments
	            { "@Override", "@Deprecated", "@SuppressWarnings" },											// Annotations
	            { "import java.util.List;", "import static java.lang.Math.*;" }									// Imports
	        };
		int chint;
		while((chint =r.read())!=-1) {
			//		char ch = (char) chint; 
				String ch = Integer.toString(chint);
				for(int i = 0;i<lexemes.length;i++) {						//checks if char is present in the the array. There is no real implementation here though.
					for(int j = 0;j<lexemes[i].length;j++) {				//only to show how to handle it if required\
						if(ch==(lexemes[i][j])) {
							System.out.print("Lexeme: "+lexemes[i][j]);
						}
						else if(ch=="$") {									//marks end of code/file
							break;
						}
						else if(ch==" ") {
							continue;
						}
						else {
							System.out.println("Lexeme: "+ch);
						}
					}
				}
				
				
		}
		
		r.close();
		

	
	}

}
