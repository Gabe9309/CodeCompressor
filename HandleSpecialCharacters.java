
public class HandleSpecialCharacters{
	
	public StringBuffer handleSpecialCharacters(StringBuffer code) {
		
		String codeToString = new String(code);
		codeToString = codeToString.replaceAll("[\\t,\\n]", " ");
		
		code.replace(0, code.length() - 1, codeToString);
		
		return code;
		
	}
	
	public boolean isSpecial(char character) {
		switch(character) {
		case '\t':
			return true;
		case '\n':
			return true;
		default:
			return false;
		}
	}

}
