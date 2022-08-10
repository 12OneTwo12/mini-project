package dev.gifticon.scanner;

import java.util.Scanner;

public class GifticonScanner {
	
	Scanner react = new Scanner(System.in);
	
	public int getReaction() {
		int answer = react.nextInt();
		return answer;
	}
	
	public String getGifticonSerialNumberNumber() {
		String answer = react.nextLine();
		return answer;
	}

	public int getUseAmount() {
		int answer = react.nextInt();
		return answer;
	}
	
	public int amount() {
		int answer = react.nextInt();
		return answer;
	}
}
