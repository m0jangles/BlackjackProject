package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.DealerHand;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.PlayerHand;

public class BlackJackApp {

	/*
	 * create the deck of cards dealer shuffles deck 
	 * dealer deals a card to a player
	 * dealer deals a card to themselves face down 
	 * dealer deals another card to player
	 * dealer gives themselves another card
	 * 
	 */
	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.run();

	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		List<Card> cards = new ArrayList<>();
		DealerHand dealerHand = new DealerHand();
		PlayerHand playerHand = new PlayerHand();
		Deck deck = new Deck();
		cards = deck.createDeck();
		int value = 0;
		
		

		try {
			System.out.println("LET'S PLAY BLACKJACK!!!");
			System.out.println("LET'S PLAY BLACKJACK!!!");
			
			Collections.shuffle(cards); ///CARDS SHUFFLED
			
			Card playerFirstCard = deck.getCard();
			System.out.println("This is your first card: " + playerFirstCard);
			System.out.println();
			playerHand.addCardValue(playerFirstCard);
			
			Card dealerFirstCard = deck.getCard();
			System.out.println("Dealer's first card is: " + dealerFirstCard);
			System.out.println();
			dealerHand.addCardValue(dealerFirstCard);
			
			Card playerSecondCard = deck.getCard();
			System.out.println("Player's second card: " + playerSecondCard);
			System.out.println();
			playerHand.addCardValue(playerSecondCard);
			
			Card dealerSecondCard = deck.getCard();
			System.out.println("Dealer's second card is A SECRET: " + dealerSecondCard); //REMOVE BEFORE FINAL PROJECT
			System.out.println();
			dealerHand.addCardValue(dealerSecondCard);
			
			System.out.println("Your current hand is: " + playerFirstCard + " and " + playerSecondCard);
			System.out.println("Dealer's current hand is: " + dealerFirstCard + " " + dealerSecondCard);
			System.out.println("What would you like to do: HIT (H) or STAY (S)");
			String answer = scanner.nextLine();
			
			if (answer.equalsIgnoreCase("H")) {
				Card playerThirdCard = deck.getCard();
			}
			else {
				System.out.println("Your hand remains at: " + playerFirstCard + " and " + playerSecondCard);
			}
			
			
			
			
			//maybe can add the values of each of the players cards now
			//maybe here add a menu to see if user wants to choose something
			
			
			int numCards = scanner.nextInt();
			if (numCards <= 52) {
				for (int i = 0; i < numCards; i++) {
					Card c = deck.getCard();
					value += c.getValue();
					System.out.println(c);
				}

				System.out.println(value);
				// Deal the cards and display them on the screen.
				// Also display the total value of all cards.

				System.out.println();

			}
		} catch (Exception e) {
			System.out.println("your answer must be an integer less than 52");
		}

	}

}
