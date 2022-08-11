package dev.gifticon.model;

import java.time.LocalDate;

public class Gifticon {

	int gifticonId;
	int recordId;
	String serialNumber;
	int amount;
	LocalDate expiryDate;
	LocalDate paymentDate;
	int usedAmount;
	
	
	// Gifticon 테이블에 관한 생성자 
	public Gifticon(int gifticonId, String serialNumber, int amount, LocalDate expiryDate) {
		this.gifticonId = gifticonId;
		this.serialNumber = serialNumber;
		this.amount = amount;
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return "Gifticon [gifticonId=" + gifticonId + ", recordId=" + recordId + ", serialNumber=" + serialNumber
				+ ", amount=" + amount + ", expiryDate=" + expiryDate + ", paymentDate=" + paymentDate + ", usedAmount="
				+ usedAmount + "]";
	}

	// RECORD 테이블에 관한 생성자. record_id, gifticon_id, payment_date, used_amount
	public Gifticon(int recordId, int gifticonId, LocalDate paymentDate, int usedAmount, int amount) {
		this.recordId = recordId;
		this.gifticonId = gifticonId;
		this.paymentDate = paymentDate;
		this.usedAmount = usedAmount;
		this.amount = amount;
	}
	
	public Gifticon(int gifticonId, String serialNumber, int amount, LocalDate expiryDate, LocalDate paymentDate,
			int usedAmount) {
		this.gifticonId = gifticonId;
		this.serialNumber = serialNumber;
		this.amount = amount;
		this.expiryDate = expiryDate;
		this.paymentDate = paymentDate;
		this.usedAmount = usedAmount;
	}

	public Gifticon() {}

	public Gifticon(String serialNumber, int amount) {
		this.serialNumber = serialNumber;
		this.amount = amount;
	}

	public Gifticon(int amount) {
		this.amount = amount;
	}



	public Gifticon(int recordId, int gifticon_id, LocalDate paymentDate, int usedAmount){
	}

	public Gifticon(int gifticonId, LocalDate expiryDate, int amount) {
		this.gifticonId = gifticonId;
		this.expiryDate = expiryDate;
		this.amount = amount;
		
	}

	public int getGifticonId() {
		return gifticonId;
	}

	public void setGifticonId(int gifticonId) {
		this.gifticonId = gifticonId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(int usedAmount) {
		this.usedAmount = usedAmount;
	}
	
}
