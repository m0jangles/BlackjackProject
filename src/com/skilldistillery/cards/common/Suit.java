package com.skilldistillery.cards.common;

public enum Suit {

	HEARTS("\u2665"), SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u2666");

	private String unicode;

	Suit(String name) {
		this.name = name;
//		this.unicode = unicode;
	}

	final private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;

	}
}