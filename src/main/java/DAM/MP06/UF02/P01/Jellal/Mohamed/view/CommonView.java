package DAM.MP06.UF02.P01.Jellal.Mohamed.view;

import java.util.Scanner;

public class CommonView {

	private CommonView() {
		scanner = new Scanner(System.in);
	}

	public static CommonView getInstance() {
		if (instance == null) {
			instance = new CommonView();
		}
		return instance;
	}

	private static CommonView instance = null;

	public int getInt(String message) {
		showMessage(message, false);
		return scanner.nextInt();
	}

	public String getString(String message) {
		showMessage(message, false);
		return scanner.next();
	}

	public void showMessage(String message, boolean isError) {
		if (isError) {
			System.err.println(message);
		} else {
			System.out.println(message);
		}
	}

	public void destroy() {
		if (scanner != null) {
			scanner.close();
		}
	}

	private Scanner scanner;

}
