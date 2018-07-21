package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	private List<Card> cardsInPlay = new ArrayList<>();

	public Hand() {
		super();
	}

	public int getHandValue() {
		return 0;

	}

	public void addCardValue(Card c) {
		cardsInPlay.add(c);
//		System.out.println("TEST          " + cardsInPlay.size());

	}

	public void clearHand() {

	}

	public List<Card> getCards(List<Card> list) {
		return list;
	
	}

	@Override
	public String toString() {
		return "Hand [getHandValue()=" + getHandValue() + "]";
	}
	
	
}
