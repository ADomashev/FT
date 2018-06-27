package by.alex.itcourses.util;

import java.util.Scanner;

public enum ScannerSingleton {
	SCANNER_INSTANCE;
	
	private Scanner scanner;
	
	public Scanner getInstance() {
		if(scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
}
