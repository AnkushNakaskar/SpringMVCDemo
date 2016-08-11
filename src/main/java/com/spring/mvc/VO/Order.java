package com.spring.mvc.VO;

public class Order {
	private String editionCode;
	private String pricingDuration;
	private Item item;

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
