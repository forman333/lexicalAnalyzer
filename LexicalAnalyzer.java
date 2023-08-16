package Formality;
import java.io.*;
import java.util.Scanner;
public class LexicalAnalyzer {
	private String inFile;	
	public LexicalAnalyzer(String inputFile) {
		this.inFile = inputFile;
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.err.println("Usage: java ClassName <input_file>");
			System.exit(1);
			}
		String input_file = args[0];
		
		LexicalAnalyzer object = new LexicalAnalyzer(input_file);
		object.op();
		
	}
	
	public void op() throws IOException {
		//FileReader r = new FileReader(this.inFile);
		Scanner s = new Scanner(new File(this.inFile));
		String[][] lexemes = {
				{ "{", "}", "[", "]", "(", ")", ",", ";", ":", "." },											// Punctuators
	            { "if", "else", "while", "for", "do", "int", "float", "double", "char", "void", "boolean",		// Keywords
	              "true", "false", "return", "class", "public", "private", "protected", "static", "final",
	              "try", "catch", "throw", "interface" },
	            { "x", "y", "z", "sum", "count", "temp", "myVar", "myFunction" },								// Identifiers
	            { "+", "-", "*", "/", "%", "=", "+=", "-=", "*=", "/=", "==", "!=", "<", ">", "<=", ">=",		// Operators
	              "++", "--", "&&", "`" },
	            											
	            { "42", "3.14", "\"Hello, world!\"", "'A'", "'9'", "true", "false", "null" },					// Literals
	            { "//", "/*"," */" },																			// Comments
	            { "@Override", "@Deprecated", "@SuppressWarnings" },											// Annotations
	            { "import java.util.List;", "import static java.lang.Math.*;" }									// Imports
	        };
		
		
		
		while (s.hasNext()) {
            String ch = s.next();

            if (ch.equals("$")) {								//to terminate the program.
                break;
            }

            boolean found = false;
            for (int i = 0; i < lexemes.length; i++) {						//checks each word if it is present in array
                for (int j = 0; j < lexemes[i].length; j++) {
                    if (ch.equals(lexemes[i][j])&&!ch.equals("$")) {
                        System.out.println("Lexeme: " + lexemes[i][j]);
                        found = true;										//added this so that there is a way to exit inner and outer loop
                        break;
                    } else if (ch.contains(lexemes[i][j])&&!ch.equals("$")) {			//checks if the word contains lexemes and prints them separately
                        String sub1 = ch.substring(0, ch.indexOf(lexemes[i][j]));
                        System.out.println("Lexeme: " + sub1);
                        System.out.println("Lexeme: " + lexemes[i][j]);
                        String sub2 = ch.substring(ch.indexOf(lexemes[i][j]) + lexemes[i][j].length());
                        if (!sub2.isEmpty()&&!ch.equals("$")) {
                            System.out.println("Lexeme: " + sub2);
                        }
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found&&!ch.equals("$")) {
                System.out.println("Lexeme: " + ch);
            }
        }

        s.close();
    }
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		