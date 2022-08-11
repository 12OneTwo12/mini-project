package dev.gifticon.service;

import java.time.LocalDate;
import java.util.Scanner;

import dev.gifticon.model.Gifticon;

public class Service {

	public void getReaction() {
		Scanner react = new Scanner(System.in);
		int answer = react.nextInt();

	}

	public void useGifticon(Gifticon gifticon) {

	}

	public Gifticon createGfticon(int amount) {

		Gifticon newGifticon = new Gifticon();

		int a = (int) (Math.random() * 9);
		int b = (int) (Math.random() * 9);
		int c = (int) (Math.random() * 9);
		int d = (int) (Math.random() * 9);
		int e = (int) (Math.random() * 9);
		int f = (int) (Math.random() * 9);
		int g = (int) (Math.random() * 9);
		int h = (int) (Math.random() * 9);
		int i = (int) (Math.random() * 9);
		int j = (int) (Math.random() * 9);
		int k = (int) (Math.random() * 9);
		int l = (int) (Math.random() * 9);

		String result = a + "" + b + "" + c + "" + d + " " + e + "" + f + "" + g + "" + h + " " + i + "" + j + "" + k
				+ "" + l;

		newGifticon.setSerialNumber(result);

//			int exYear = (int) (1 + 2022);
		LocalDate exMonth = LocalDate.now();
//			LocalDate exDay = LocalDate.now();

		newGifticon.setExpiryDate(exMonth.plusYears(1));

		newGifticon.setAmount(amount);

		return newGifticon;
	}


	public void lookupAmount(String answer) {

	}

	public void lookupUsedData(String answer) {

	}

}
