import java.util.ArrayList;

public class HandleStrings{
	private StringSaver stringSaver;
	
	HandleStrings(StringSaver stringSaver){
		this.stringSaver = stringSaver;
	}
	
	public void handleStrings(ArrayList<String> listOfCode) {
		int receipt = 0;
		int startOfString = 0;
		int endOfString = 0;
		StringBuffer code = new StringBuffer();
		
		for(int j = 0; j < listOfCode.size(); j++) {
			code.delete(0, code.length());
			code.append(listOfCode.get(j));
			
			for(int i = 0; i < code.length(); i++) {
			
				if((code.charAt(i) == '"') && (startOfString == 0)) {
					startOfString = i + 1;
				}
			
				else if ((code.charAt(i) == '"') && (startOfString != 0)) {
					endOfString = i;
					receipt = stringSaver.saveString(code.substring(startOfString, endOfString));
					code.replace((startOfString - 1), (endOfString + 2), ("@" + receipt + "@"));
					startOfString = 0;
					listOfCode.set(j, (code.toString()));
				}
			}
		}
		System.out.println("String Handler: ");
		System.out.println(listOfCode);
	}

}
