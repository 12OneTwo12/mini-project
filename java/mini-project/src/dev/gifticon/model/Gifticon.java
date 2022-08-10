package dev.gifticon.model;

import java.time.LocalDate;

public class Gifticon {

	int gifticonId;
	String serialNumber;
	int amount;
	LocalDate expiryDate;
	LocalDate paymentDate;
	int usedAmount;
	
	public Gifticon(int gifticonId, String serialNumber, int amount, LocalDate expiryDate) {
		this.gifticonId = gifticonId;
		this.serialNumber = serialNumber;
		this.amount = amount;
		this.expiryDate = expiryDate;
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
