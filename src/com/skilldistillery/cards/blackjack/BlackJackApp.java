package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.BlackjackHand;
import com.skilldistillery.cards.common.Card;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Menu;

public class BlackJackApp {

	/*
	 * create the deck of cards dealer shuffles deck dealer deals a card to a player
	 * dealer deals a card to themselves face down dealer deals another card to
	 * player dealer gives themselves another card
	 * 
	 */
	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.run();

	}

	public void run() {
		Menu menu = new Menu();
		menu.displayGameName();
		Scanner scanner = new Scanner(System.in);

		Hand dealerHand = new BlackjackHand();
		Hand playerHand = new BlackjackHand();

		Deck deck = new Deck();

		deck.createDeck();

		int value = 0;

		deck.shuffle(); /// CARDS SHUFFLED

		System.out.println("Your first card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();

		System.out.println("Dealer's first card is: " + dealerHand.addCardsToHand(deck.getCard()));
		System.out.println();

		System.out.println("Your second card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();

		System.out.println("Dealer's second card is A SECRET: " + dealerHand.addCardsToHand(deck.getCard())); // PROJECT
		System.out.println();

		System.out.println("Your current hand is: " + playerHand.getHandValue());
		System.out.println();
		System.out.println("Dealer's current hand is: " + dealerHand.getHandValue());
		System.out.println();

		System.out.println("What would you like to do: HIT (H) or STAY (S)");
		String answer = scanner.nextLine();

		while (answer != null && !answer.equalsIgnoreCase("S")) {
			if (answer.equalsIgnoreCase("H")) {
				playerHand.addCardsToHand(deck.getCard());

			} else {
				System.out.println("Your hand remains at: " + playerHand.getHandValue());
			}
			System.out.println("What would you like to do: HIT (H) or STAY (S)");
			String answer1 = scanner.nextLine();

		}

		while (dealerHand.getHandValue() != 17) {
			if (dealerHand.getHandValue() < 17) {
				dealerHand.addCardsToHand(deck.getCard());
			} else {
				dealerHand.toString();
			}

		}
	}
}
