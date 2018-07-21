package com.skilldistillery.cards.common;

import java.util.List;

public class PlayerHand extends Hand {

	public PlayerHand() {
		
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return super.getHandValue();
	}

	@Override
	public void addCardValue(Card c) {
		//increment the values as a card is added
		//LIST of cards 
		
		super.addCardValue(c);
	}

	@Override
	public void clearHand() {
		// TODO Auto-generated method stub
		super.clearHand();
	}

	@Override
	public List<Card> getCards(List<Card> list) {
		// TODO Auto-generated method stub
		return super.getCards(list);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
