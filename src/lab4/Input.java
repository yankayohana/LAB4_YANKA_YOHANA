package lab4;

import java.util.Scanner;

public class Input {

	private Scanner sc;

	public Input() {
		this.sc = new Scanner(System.in);
	}

	public String leString() {
		return this.sc.nextLine();

	}
	
	public String leString(String frase) {
		System.out.print(frase);
		return leString();
		
	}

}
