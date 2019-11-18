
public class HandleBlockComments{


	public StringBuffer handleBlockComments(StringBuffer code) {
		
		int startOfComment = 0;
		int endOfComment = 0;
		
		for(int i = 0; i < code.length(); i++) {
			
			if((code.charAt(i) == '/') && (startOfComment == 0)) {
				startOfComment = i;
			}
			
			else if ((code.charAt(i) == '/') && (startOfComment != 0)) {
				endOfComment = i;
				code.replace(startOfComment - 1, endOfComment + 1, " ");
			}
		}
		return code;
		
	}
}
