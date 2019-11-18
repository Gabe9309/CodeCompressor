
public class StringTable {
	private int receipt;
	private String string;
	
	StringTable(String string){
		this.string = string;
		receipt = setReceiptNumber();
	}
	
	private int setReceiptNumber() {
		int midChar = 0;
		int firstChar = 0;
		int lastChar = 0;
		int receiptNumber = 0;
		int length = string.length();
		
		if(length == 1)
			receiptNumber = string.charAt(0);
		else if(length == 2)
			receiptNumber = string.charAt(0) + string.charAt(1);
		else if (length > 2){
			firstChar = string.charAt(0);
			midChar = string.charAt(string.length() / 2);
			lastChar = string.charAt(string.length() - 1);
		
			receiptNumber = firstChar + midChar + lastChar;
		}
		return receiptNumber;
	}

	public int getReceipt() {
		return receipt;
	}

	public String getString() {
		return string;
	}
}
