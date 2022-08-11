package dev.gifticon.view;

import java.util.List;
import java.util.Scanner;

import dev.gifticon.dao.DAO;
import dev.gifticon.model.Gifticon;
import dev.gifticon.scanner.GifticonScanner;
import dev.gifticon.service.Service;

public class View {

	Scanner scan = new Scanner(System.in);
	private final GifticonScanner gifticonScanner = new GifticonScanner();
	private final Service service = new Service();
	private final DAO dao = new DAO();
	
	public void viewMain() {
		System.out.println("==================================================");
		System.out.println("����Ƽ�� ���� ���� �����մϴ�.");
		System.out.println("���ϴ� �޴��� �������ּ���");
		System.out.println("1: ����Ƽ�� ���  | 2: ����Ƽ�� ���� | 3: �ܾ� ��ȸ  | 4: ���� ���� Ȯ�� | 5: ����Ƽ�� �ջ� | 6: ���α׷� ����");
        System.out.print("��ȣ�� �Է��ϼ���: ");
		viewMenu(gifticonScanner.getReaction());
	}

	public void viewMenu(int reaction) {
		if(reaction == 1) {
			viewGifticonUse();
		} else if (reaction == 2) {
			viewBuyGifticon();
		} else if (reaction == 3) {
			viewBalanceAmount();
		} else if (reaction == 4) {
			viewUsedAmount();
		} else if (reaction == 5) {
			viewSummation();
		} else if (reaction == 6) {
			System.out.println("���α׷��� �����մϴ�");
			return;
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			viewMain();
		}
		
	}
	
	public void viewGifticonUse() {
		System.out.println("==================================================");
		System.out.println("[ ����Ƽ�� ��� ]  ( ���� �������� ���ư��� : �Է� �� ���� ���� )");
		System.out.println("�Ϸ� ��ȣ�� �Է����ּ���");
		System.out.println("�Ϸ� ��ȣ : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		if (answer.length() == 14) {
			System.out.println("���� �ݾ��� �Է����ּ���");
			System.out.println("���� �ݾ� : ");
			int useAmout = gifticonScanner.getUseAmount();
			Gifticon gifticon = service.findBySerialNumber(answer);
			service.useAmount(gifticon,useAmout);
//			Gifticon gifticon = new Gifticon(answer, useAmout);
//			service.useGifticon(gifticon);
			System.out.println("���������� ��� �Ǽ̽��ϴ�.");
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
			return;
		}
	
	}
	
	public void viewBuyGifticon() {
		System.out.println("==================================================");
		System.out.println("[ ����Ƽ�� ���� ]  ( ���� �������� ���ư��� : ���� 0 �Է� )");
		System.out.println("���� �ݾ��� �Է����ּ���");
		System.out.println("���� �ݾ� : ");
		int amount = gifticonScanner.amount();
		if(amount > 0) {
			Gifticon newGifticon = service.createGfticon(amount);
			System.out.println("�Ϸ� ��ȣ : " + newGifticon.getSerialNumber());
			System.out.println("��ȿ�Ⱓ : " + newGifticon.getExpiryDate());
		} else if (amount == 0) {
			viewMain();
		} else {
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
			return;
		}
	}
	
	public void viewBalanceAmount() {
		System.out.println("==================================================");
		System.out.println("[ �ܾ� ��ȸ ]  ( ���� �������� ���ư��� : �Է� �� ���� ���� )");
		System.out.println("�Ϸ� ��ȣ�� �Է����ּ���");
		System.out.println("�Ϸ� ��ȣ : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		
		if (answer.length() == 14) {
			Gifticon gifticon = service.findBySerialNumber(answer);
			System.out.println("�ܾ��� " + gifticon.getAmount() + "�� �Դϴ�");
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
			return;
		}
	}
	
	public void viewUsedAmount() {
		System.out.println("==================================================");
		System.out.println("[ ���� ���� Ȯ�� ]  ( ���� �������� ���ư��� : �Է� �� ���� ���� )");
		System.out.println("�Ϸ� ��ȣ�� �Է����ּ���");
		System.out.println("�Ϸ� ��ȣ : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		if (answer.length() == 14) {
//			try {
				List<Gifticon> gifticons = service.findBySerialNumbers(answer);
				for(Gifticon gifticon : gifticons) {
					System.out.println(gifticon.getPaymentDate()+ "�� " + gifticon.getUsedAmount() + "�� ����ϼ̽��ϴ�");
//				}
//			} catch(Exception e) {
//				System.out.println("���� ������ �����ϴ�.");
			}
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
			return;
		}
	}
	
	public void viewSummation() {
		System.out.println("==================================================");
		System.out.println("[ ����Ƽ�� �ջ� ]  ( ���� �������� ���ư��� : �Է� �� ���� ���� )");
		System.out.println("ù�� ° ����Ƽ�� �Ϸ� ��ȣ�� �Է����ּ���");
		System.out.println("ù�� ° ����Ƽ�� �Ϸ� ��ȣ : ");
//		gifticonScanner.getGifticonSerialNumberNumber();
		String firstGifticon = scan.nextLine();
		if (firstGifticon.length() == 14) {
			Gifticon firstGifticonn = service.findBySerialNumber(firstGifticon);
			System.out.println("�ι� ° ����Ƽ�� �Ϸ� ��ȣ�� �Է����ּ���");
			System.out.println("�ι� ° ����Ƽ�� �Ϸ� ��ȣ : ");
			String secondGifticon = scan.nextLine();
			if (secondGifticon.length() == 14) {
				Gifticon secondGifticonn = service.findBySerialNumber(secondGifticon);
				Gifticon newGifticon = service.pulsCreateGifticon(firstGifticonn,secondGifticonn);
				
				dao.zeroAmount(firstGifticonn);
				dao.zeroAmount(secondGifticonn);
				System.out.println("���� ������� ����Ƽ�� �Ϸ� ��ȣ : " + newGifticon.getSerialNumber());
			} else if (secondGifticon.length() == 0) {
				viewMain();
			} else {
				System.out.println("�߸� �ԷµǾ����ϴ�.");
				System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
				return;
			}
		} else if (firstGifticon.length() == 0) {
			viewMain();
		} else {
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			System.out.println("�Ϸù�ȣ 12�ڸ��� �Է����ּ���");
			return;
		}
		
	}
	
}
