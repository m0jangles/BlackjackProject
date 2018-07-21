package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * We will be simulating a deck of cards.

Create a class Deck. It will hold a List of Cards.
In the constructor, initialize the List with all 52 cards.
Add a method checkDeckSize which returns the number of cards still in the deck.
Add a method dealCard that removes a Card from the deck.
Add a method shuffle to shuffle the deck.
 */
public class Deck {
	private List<Card> cards;

	public Deck() {
//		createDeck();
	}

	public List<Card> createDeck() {
		cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(s, r));
			}

		}
		
		return cards;
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
