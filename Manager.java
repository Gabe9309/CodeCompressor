import java.io.IOException;

public class Manager {
	private HandleStrings handleStrings;
	private StringSaver stringSaver;
	private HandleLineComments handleLineComents;
	private HandleBlockComments handleBlockComments;
	private HandleSpecialCharacters handleSpecialCharacters;
	private HandleSpaces handleSpaces;
	private Reader reader;
	private Writer writer;
	private StringBuffer placeHolder;
	
	Manager(String fileName) throws IOException{
		stringSaver = new StringSaver();
		handleStrings = new HandleStrings(stringSaver);
		handleLineComents = new HandleLineComments();
		handleBlockComments = new HandleBlockComments();
		handleSpecialCharacters = new HandleSpecialCharacters();
		handleSpaces = new HandleSpaces();
		reader = new Reader(fileName);
		writer = new Writer(fileName, stringSaver);
		placeHolder = new StringBuffer();
	}
	
	public void manage() throws IOException {
		reader.readFile();
		handleStrings.handleStrings(reader.getCode());
		placeHolder = handleLineComents.checkForLineComments(reader.getCode());
		System.out.println(placeHolder);
		placeHolder = handleBlockComments.handleBlockComments(placeHolder);
		System.out.println(placeHolder);
		placeHolder = handleSpecialCharacters.handleSpecialCharacters(placeHolder);
		System.out.println(placeHolder);
		placeHolder = handleSpaces.handleSpaceAfterChars(placeHolder);
		System.out.println(placeHolder);
		
		
		placeHolder = handleSpaces.handleSpaceAfterSymbols(placeHolder);
		System.out.println(placeHolder);
		writer.write(placeHolder);
	}

}
