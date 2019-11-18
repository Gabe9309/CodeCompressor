import java.io.IOException;

public class Driver {

	public static void main(String[] args) {

		try {
			Manager manager = new Manager(args[0]);
			manager.manage();
		}
		catch(IOException e) {
			e.getMessage();
			System.out.println("Something happened");
		}

	}

}
