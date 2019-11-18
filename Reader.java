import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	private File file;
	private String fullPath;
	private Scanner fileScanner;
	private ArrayList<String> code;
	
	Reader(String fileName) throws FileNotFoundException{
		file = new File(fileName);
		fullPath = file.getAbsolutePath();
		file = new File(fullPath);
		fileScanner = new Scanner(file);
		code = new ArrayList<>();
	}
	
	public ArrayList<String> getCode(){
		return code;
	}
	
	public void readFile() {
		String currentLine;
		
		while(fileScanner.hasNext()) {
			currentLine = fileScanner.nextLine();
			code.add(currentLine);
		}
	}
}