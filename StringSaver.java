import java.util.ArrayList;
import java.util.Iterator;

public class StringSaver {
	private ArrayList<StringTable> stringTableList;
	private StringTable stringTable;
	
	StringSaver(){
		stringTableList = new ArrayList<StringTable>();
	}

	public int saveString(String string) {
		int stringReceipt = 0;
		
		StringTable stringTable = new StringTable(string);
		stringReceipt = stringTable.getReceipt();
		stringTableList.add(stringTable);
		
		return stringReceipt;
	}
	
	public StringBuffer findReceipts(StringBuffer code) {
		for(int i = 0; i < code.length(); i++) {
			
			if(code.charAt(i) == '@') {
				
				for(int j = i + 1; j < code.length(); j++) {
					
					if(code.charAt(j) == '@') {
						System.out.println("Number>>> " + code.substring(i + 1 , j));
						code.replace(i, j + 1, retrieveString(code.substring(i + 1 , j)));
						i = j + 1;
						break;
					}
				}
			}
		}
		
		return code;
	}
	public String retrieveString(String receipt) {
		int receiptNumber = Integer.parseInt(receipt);
		Iterator<StringTable> iterator = stringTableList.iterator();
		
		while(iterator.hasNext()) {
			stringTable = iterator.next();
			if(stringTable.getReceipt() == receiptNumber) 
				return "\"" + stringTable.getString() + "\"";
		}
		
		return "Could not be found";
	}
}
