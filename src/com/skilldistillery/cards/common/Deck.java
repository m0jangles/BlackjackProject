package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> cards;

	public Deck() {
//		createDeck();
	}

	public void createDeck() {
		cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(s, r));
			}

		}
		
	}

	public int checkDeckSize(Deck size) {
		return cards.size();
	}

	public Card getCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	//

}
