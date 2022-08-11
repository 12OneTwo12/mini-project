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
		System.out.println("기프티콘 관리 서비스 시작합니다.");
		System.out.println("원하는 메뉴를 선택해주세요");
		System.out.println("1: 기프티콘 사용  | 2: 기프티콘 구매 | 3: 잔액 조회  | 4: 결제 내역 확인 | 5: 기프티콘 합산 | 6: 프로그램 종료");
        System.out.print("번호를 입력하세요: ");
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
			System.out.println("프로그램을 종료합니다");
			return;
		} else {
			System.out.println("잘못 입력하셨습니다");
			viewMain();
		}
		
	}
	
	public void viewGifticonUse() {
		System.out.println("==================================================");
		System.out.println("[ 기프티콘 사용 ]  ( 메인 페이지로 돌아가기 : 입력 값 없이 엔터 )");
		System.out.println("일련 번호를 입력해주세요");
		System.out.println("일련 번호 : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		if (answer.length() == 14) {
			System.out.println("결제 금액을 입력해주세요");
			System.out.println("결제 금액 : ");
			int useAmout = gifticonScanner.getUseAmount();
			Gifticon gifticon = service.findBySerialNumber(answer);
			service.useAmount(gifticon,useAmout);
//			Gifticon gifticon = new Gifticon(answer, useAmout);
//			service.useGifticon(gifticon);
			System.out.println("정상적으로 사용 되셨습니다.");
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
	
	}
	
	public void viewBuyGifticon() {
		System.out.println("==================================================");
		System.out.println("[ 기프티콘 구매 ]  ( 메인 페이지로 돌아가기 : 숫자 0 입력 )");
		System.out.println("충전 금액을 입력해주세요");
		System.out.println("충전 금액 : ");
		int amount = gifticonScanner.amount();
		if(amount > 0) {
			Gifticon newGifticon = service.createGfticon(amount);
			System.out.println("일련 번호 : " + newGifticon.getSerialNumber());
			System.out.println("유효기간 : " + newGifticon.getExpiryDate());
		} else if (amount == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
	}
	
	public void viewBalanceAmount() {
		System.out.println("==================================================");
		System.out.println("[ 잔액 조회 ]  ( 메인 페이지로 돌아가기 : 입력 값 없이 엔터 )");
		System.out.println("일련 번호를 입력해주세요");
		System.out.println("일련 번호 : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		
		if (answer.length() == 14) {
			Gifticon gifticon = service.findBySerialNumber(answer);
			System.out.println("잔액은 " + gifticon.getAmount() + "원 입니다");
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
	}
	
	public void viewUsedAmount() {
		System.out.println("==================================================");
		System.out.println("[ 결제 내역 확인 ]  ( 메인 페이지로 돌아가기 : 입력 값 없이 엔터 )");
		System.out.println("일련 번호를 입력해주세요");
		System.out.println("일련 번호 : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String answer = gifticonScanner.getGifticonSerialNumberNumber();
		if (answer.length() == 14) {
//			try {
				List<Gifticon> gifticons = service.findBySerialNumbers(answer);
				for(Gifticon gifticon : gifticons) {
					System.out.println(gifticon.getPaymentDate()+ "에 " + gifticon.getUsedAmount() + "원 사용하셨습니다");
//				}
//			} catch(Exception e) {
//				System.out.println("결제 내역이 없습니다.");
			}
		} else if (answer.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
	}
	
	public void viewSummation() {
		System.out.println("==================================================");
		System.out.println("[ 기프티콘 합산 ]  ( 메인 페이지로 돌아가기 : 입력 값 없이 엔터 )");
		System.out.println("첫번 째 기프티콘 일련 번호를 입력해주세요");
		System.out.println("첫번 째 기프티콘 일련 번호 : ");
//		gifticonScanner.getGifticonSerialNumberNumber();
		String firstGifticon = scan.nextLine();
		if (firstGifticon.length() == 14) {
			Gifticon firstGifticonn = service.findBySerialNumber(firstGifticon);
			System.out.println("두번 째 기프티콘 일련 번호를 입력해주세요");
			System.out.println("두번 째 기프티콘 일련 번호 : ");
			String secondGifticon = scan.nextLine();
			if (secondGifticon.length() == 14) {
				Gifticon secondGifticonn = service.findBySerialNumber(secondGifticon);
				Gifticon newGifticon = service.pulsCreateGifticon(firstGifticonn,secondGifticonn);
				
				dao.zeroAmount(firstGifticonn);
				dao.zeroAmount(secondGifticonn);
				System.out.println("새로 만들어진 기프티콘 일련 번호 : " + newGifticon.getSerialNumber());
			} else if (secondGifticon.length() == 0) {
				viewMain();
			} else {
				System.out.println("잘못 입력되었습니다.");
				System.out.println("일련번호 12자리를 입력해주세요");
				return;
			}
		} else if (firstGifticon.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
		
	}
	
}
