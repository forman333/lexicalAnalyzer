package Formality;

import java.io.*;
public class Preprocessor {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java ClassName <input_file>");
			System.exit(1);
			}
			String inputFile = args[0];
			
			
	}
	
	//dont use f.read in (loop conditions)
	public void op(String inputFile) throws IOException {
		//reads input file
		try {
			FileReader f = new FileReader(inputFile);
			//creates output file
			FileWriter out = new FileWriter("output.txt");
			
			//variable ch stores character while traversing
			int ch;
			//checks if ch is in comment block
			boolean isComment = false;
			//checks if ch has encountered import
			boolean isImport = false;
			
			ch=f.read();
			do{	
				//checks if comment
				if(ch=='/') {
					int nextCh = f.read();
					if(nextCh=='/'){	//condition checks if single line comment
						while(nextCh!=-1 && nextCh!='\n') {//keeps reading the comment until line is finished
							ch=nextCh;	//to avoid confusion
							ch=f.read();
						}
					}
					else if(nextCh=='*') {	//condition to check block comment
						while(nextCh!=-1) {
							nextCh = f.read();
							ch=nextCh;
							if(nextCh=='*') {
								nextCh=f.read();
								ch=nextCh;
								if(nextCh=='/') {
									nextCh=f.read();
									ch=nextCh;
								}
							}
							while((nextCh!='*'&& (nextCh=f.read())!='/')) {
								ch=f.read();
							}
						}
					}
				}
				//checks if import statement
				if(ch=='i') {
					int nextCh = f.read();
                    if (nextCh == 'm') {
                        nextCh = f.read();
                        ch=nextCh;					//i know its for my piece of mind
                        if (nextCh == 'p') {
                            nextCh = f.read();
                            ch=nextCh;
                            if (nextCh == 'o') {
                                nextCh = f.read();
                                ch=nextCh;
                                if (nextCh == 'r') {
                                    nextCh = f.read();
                                    ch=nextCh;
                                    if (nextCh == 't') {
                                        nextCh = f.read();
                                        ch=nextCh;
                                        if (nextCh == ' ') {
                                           // isImport = true;
                                            while(nextCh!='\n'&&nextCh!=-1) { //condition to end the import line/file 
                                            	ch=nextCh;	//so that i dont get confused
                                            	ch=f.read();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
				}
				//checks if annotation
				if(ch=='@') {
					while(ch!='\n'&&ch!=-1) {
						ch=f.read();
					}
				}
				//discards blank line and unnecessary spaces before character in a new line
				if (ch == '\n') {  
                    while (ch  != -1 && (ch == ' ' || ch == '\t')) {
                    	ch=f.read();
                    }
                }
				//remove tabs
				if(ch=='\t') {
					while(ch!=-1 && ch!='\n') {
						ch=f.read();					}
				}
				//checks extra spaces
				
				
				
				
				
			}while ((ch=f.read())!=-1); //condition checks if file has ended
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
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
