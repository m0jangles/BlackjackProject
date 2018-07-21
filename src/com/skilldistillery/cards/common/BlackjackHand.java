package com.skilldistillery.cards.common;

import java.util.List;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	
	@Override
	public int getHandValue() {
		List<Card> cardsInPlay = this.getCards();
		int value = 0;
		for(int i = 0; i < cardsInPlay.size(); i++) {
			Card c = cardsInPlay.get(i);
			value += c.getValue();
			System.out.println(c);
		}
		
		return value;
	}
	

}
