import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	private File file;
	private StringSaver stringSaver;
	private BufferedWriter writer;
	boolean wasCreated = false;

	Writer(String fileName, StringSaver stringSaver) throws IOException{
		this.stringSaver = stringSaver;
		file = new File(fileName);
		file = file.getAbsoluteFile();
		file = file.getParentFile();
		wasCreated = new File(file, "//Compressed").mkdir();
		if(wasCreated)
			file = new File(file, "//Compressed//" + fileName);
		writer = new BufferedWriter(new FileWriter(file));

	}

	
	public void write(StringBuffer code) throws IOException {
		code = stringSaver.findReceipts(code);
		
		String toSave = code.toString();
		writer.write(toSave);
		
		writer.close();
	}
}
