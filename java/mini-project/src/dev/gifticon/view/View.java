package dev.gifticon.view;

import dev.gifticon.model.Gifticon;
import dev.gifticon.scanner.GifticonScanner;
import dev.gifticon.service.Service;

public class View {

	private final GifticonScanner gifticonScanner = new GifticonScanner();
	private final Service service = new Service();
	
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
//			gifticonScanner.getUseAmount();
			int useAmout = gifticonScanner.getUseAmount();
			Gifticon gifticon = new Gifticon(answer, useAmout);
			service.useGifticon(gifticon);
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
//		gifticonScanner.amount();
		int amount = gifticonScanner.amount();
		if(amount > 0) {
//			Gifticon gifticon = new Gifticon(amount);
//			service.createGifticon(gifticon);
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
			service.lookupAmount(answer);
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
			service.lookupUsedData(answer);
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
		System.out.println("[ 결제 내역 확인 ]  ( 메인 페이지로 돌아가기 : 입력 값 없이 엔터 )");
		System.out.println("첫번 째 기프티콘 일련 번호를 입력해주세요");
		System.out.println("첫번 째 기프티콘 일련 번호 : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String firstGifticon = gifticonScanner.getGifticonSerialNumberNumber();
		if (firstGifticon.length() == 14) {
			
		} else if (firstGifticon.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
		System.out.println("두번 째 기프티콘 일련 번호를 입력해주세요");
		System.out.println("두번 째 기프티콘 일련 번호 : ");
		gifticonScanner.getGifticonSerialNumberNumber();
		String secondGifticon = gifticonScanner.getGifticonSerialNumberNumber();
		if (secondGifticon.length() == 14) {
			
		} else if (secondGifticon.length() == 0) {
			viewMain();
		} else {
			System.out.println("잘못 입력되었습니다.");
			System.out.println("일련번호 12자리를 입력해주세요");
			return;
		}
		
	}

}
