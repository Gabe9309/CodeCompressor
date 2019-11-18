import java.util.ArrayList;

public class HandleLineComments{
	
	public StringBuffer handleLineComments(StringBuffer code) {
		
		int startOfComment = 0;
		int endOfComment = 0;
		
		for(int i = 0; i < code.length(); i++) {
			
			if((code.charAt(i) == '/') && (startOfComment == 0)) {
				startOfComment = i;
				i++;
			}
			
			else if ((code.charAt(i) == '\n') && (startOfComment != 0)) {
				endOfComment = i;
				code.replace(startOfComment, endOfComment, " ");
			}
		}
		System.out.println("Line Comments Handler: ");
		System.out.println(code);
		return code;
		
	}
	
	public StringBuffer checkForLineComments(ArrayList<String> listOfCode) {
		String currentLine;
		StringBuffer code = new StringBuffer();
		boolean foundFirstSlash = false;
		
		for(int j = 0; j < listOfCode.size(); j++) {
			currentLine = listOfCode.get(j);
			
			for(int i = 0; i < currentLine.length(); i++) {
				
				if((currentLine.charAt(i) == '/') && (foundFirstSlash)) {
					currentLine = currentLine.substring(0, i - 1);
				}
				else if(currentLine.charAt(i) == '/') {
					foundFirstSlash = true;
				}
			}
			foundFirstSlash = false;
			code.append(currentLine);
		}
		
		return code;
	}

}
