package Formality;
import java.io.*;

public class Processor {
	private String inFile;
    private char[] arr;
    private int arrSize=0;
    public static void main(String[] args) throws IOException {
//    	if (args.length < 1) {
//			System.err.println("Usage: java ClassName <input_file>");
//			System.exit(1);
//			}
//			String input_file = args[0];
			String input_file = "C:/Users/Me/Documents/Java Course/Assignment2/out1.txt";
			
			Processor object = new Processor(input_file);
			object.op("out2");
			
			
			
    }
    //constructor
    public Processor(String inFile) {
        this.inFile = inFile;
    }
    //Method: reading from file and determining array size
    public void read() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(inFile));
        
        int chint;
        while ((chint = read.read()) != -1) {
            char ch = (char) chint;
            if (ch != '\n') {
                arrSize++;
            }
        }
        read.close();

        arr = new char[arrSize+1];
        int i = 0;
        
        BufferedReader n = new BufferedReader(new FileReader(inFile));
        int chint2;
        while ((chint2 = n.read()) != -1) {
            char ch = (char) chint2;
            if (ch == '\n') {
                continue;
            }
            else {
            	arr[i] = ch;
                i++;;
            }
            
        }
        arr[arrSize]='$';
        
        n.close();
    }
    //Method: writing on output file
    public void write(String outFile) throws IOException {
    	FileWriter out = new FileWriter(outFile);
    	for(int i=0; i<=arrSize;i++) {
    		if(arr[i]=='\n') {
    			continue;
    		}
    		else {
    			out.write(arr[i]);
    			
    			
    		}
    		System.out.print(arr[i]);
    		
    	}
    	out.close();
    }
    //Method: Displaying on console
    public void Display(String outFile) throws IOException {
    	BufferedReader read = new BufferedReader(new FileReader(outFile));
    	System.out.print(read.readLine());	//since its a 1d array and there's only 1 line
    	read.close();
    }
    //Method: operational method
    public void op(String outFile) throws IOException {
    	read();
    	write(outFile);
    	Display(outFile);
    }
}
