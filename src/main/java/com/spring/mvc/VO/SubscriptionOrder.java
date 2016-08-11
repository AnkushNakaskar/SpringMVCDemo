package com.spring.mvc.VO;

public class SubscriptionOrder {
	private String type;
	private MarketPlace marketPlace;
	private Creater creater;
	private Payload payload;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MarketPlace getMarketPlace() {
		return marketPlace;
	}

	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}

	public Creater getCreater() {
		return creater;
	}

	public void setCreater(Creater creater) {
		this.creater = creater;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
}
