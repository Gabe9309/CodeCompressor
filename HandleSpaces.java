
public class HandleSpaces {
	
	public StringBuffer handleSpaceAfterChars(StringBuffer code) {
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < code.length(); i++) {
			
			if(code.charAt(i) == ' ') {
				
				if((Character.isAlphabetic(code.charAt(i - 1))) || (Character.isDigit(code.charAt(i - 1)))) {
					start = i;
					
					for(int j = i + 1; j < code.length(); j++) {
						
						if((Character.isAlphabetic(code.charAt(j))) || (Character.isDigit(code.charAt(j)))) {
							end = j;
							code.replace(start, end, " ");
							start = 0;
							break;
						}
						else if(isChar(code.charAt(j))) {
							end = j;
							code.delete(start, end);
							start = 0;
							break;
						}
					}
				}
			}
		}
		
		return code;
	}

	public StringBuffer handleSpaceAfterSymbols(StringBuffer code) {
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < code.length(); i++) {
			
			if(code.charAt(i) == ' ') {
				
				if((i != 0) && (isChar(code.charAt(i - 1)))) {
					start = i;
					
					for(int j = i + 1; j < code.length(); j++) {
						
						if(code.charAt(j) != ' ') {
							end = j;
							code.delete(start, end);
							start = 0;
							break;
						}
					}
				}
			}
		}
		
		return code;
	}
	public boolean isChar(char character) {
		int asciiValue = character;
		
		if((asciiValue >= 48) && (asciiValue <= 57)) 
			return false;
		else if ((asciiValue >= 65) && (asciiValue <= 90))
			return false;
		else if ((asciiValue >= 97) && (asciiValue <= 122))
			return false;
			else return true;
		
	}

}
