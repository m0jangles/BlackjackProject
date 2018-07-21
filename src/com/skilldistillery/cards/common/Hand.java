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

	public Card addCardsToHand(Card c) {
		
		cardsInPlay.add(c);
		return c;
	}

	public void clearHand() {

	}

	public List<Card> getCards() {
		return cardsInPlay;
	
	}

	@Override
	public String toString() {
		return "Hand [getHandValue()=" + getHandValue() + "]";
	}
	
	
}
