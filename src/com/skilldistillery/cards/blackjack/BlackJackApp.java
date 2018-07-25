package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.BlackjackHand;
import com.skilldistillery.cards.common.Card;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackJackApp {
	Hand dealerHand = new BlackjackHand();
	Hand playerHand = new BlackjackHand();
	Deck deck = new Deck();
	static BlackJackApp bja = new BlackJackApp();

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		bja.Begin();

	}

	public void run() {

		bja.displayGameName();
		deck.createDeck();
		deck.shuffle(); /// CARDS SHUFFLED
		bja.FirstHand();
	}

	public void FirstHand() {
		System.out.println("YOUR first card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();
		System.out.println("YOUR second card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();
		System.out.println("YOUR current hand is: " + playerHand.getHandValue());
		bja.formattingLines();

		System.out.println("Dealer's first card is: " + dealerHand.addCardsToHand(deck.getCard()));
		System.out.println();
		System.out.println("Dealer's second card is A SECRET ");
		dealerHand.addCardsToHand(deck.getCard());
		System.out.println();
		System.out.println("Dealer's current hand is a SECRET ");
		dealerHand.getHandValue();
		bja.formattingLines();

		if (playerHand.getHandValue() > 21) {
			System.out.println();
			System.out.println("You got over 21 on your first hand.  Aces are hard.");
			bja.EndQuestion();
		}

		if (playerHand.getHandValue() == 21) {
			System.out.println("WINNER");
			System.out.println("You got BLACKJACK");
			System.out.println("WINNER");
			bja.EndQuestion();

		}
		if (dealerHand.getHandValue() == 21) {
			System.out.println("Dealer score: " + dealerHand.getHandValue());
			System.out.println("Dealer got BLACKJACK");
			bja.EndQuestion();
		}
		if (dealerHand.getHandValue() == 21 && playerHand.getHandValue() == 21) {
			System.out.println("This is a tie game, no winner, no chicken dinner");
			bja.EndQuestion();
		}

		if (playerHand.getHandValue() < 21) {
			bja.Hit();
		}
	}

	public void Hit() {

		// this method needs work because when the user chooses stay,
		// the game should evaluate a winner based on what the current
		// hand values are
		// currently, sometimes the game hangs in limbo when the user chooses "S"
		// ideally, whenever the user chooses "S", the game bja object should
		// be able to call the stay() method to move on to the next part of the game
		Scanner sc = new Scanner(System.in);

		while (playerHand.getHandValue() < 21) {
			System.out.println("What would you like to do: HIT (H) or STAY (S)\t");
			String answer = scanner.next();

			if (answer.equalsIgnoreCase("S")) {
				bja.stay();

			}
			if (answer.equalsIgnoreCase("H")) {
				System.out.println("New card is: \t" + playerHand.addCardsToHand(deck.getCard()));
				System.out.println("Your current hand is: \t" + playerHand.getHandValue());

				if (playerHand.getHandValue() > 21) {
					bja.showCards();
					System.out.println("WHAT A BUST!" + "  Your losing score is: \t" + playerHand.getHandValue());
					bja.EndQuestion();

				}
				if (playerHand.getHandValue() == 21) {
					bja.showCards();
					System.out.println("WINNER WINNER, CHICKEN DINNER");
					System.out.println("You got BLACKJACK");
					bja.EndQuestion();
				}
			}
		}
	}

	public void stay() {

		if (playerHand.getHandValue() == 21) {
			bja.showCards();
			System.out.println("You win");
			bja.EndQuestion();
		} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("Your score is: " + playerHand.getHandValue());
			System.out.println("Dealer score is: " + dealerHand.getHandValue());
			System.out.println("You lose, better luck next time.");
			bja.EndQuestion();
		} else if (playerHand.getHandValue() > dealerHand.getHandValue() && dealerHand.getHandValue() >= 17
				&& playerHand.getHandValue() < 21) {
			bja.showCards();
			System.out.println("Your score is: " + playerHand.getHandValue());
			System.out.println("Dealer's score is: " + dealerHand.getHandValue());
			System.out.println("You WIIIIIIIIIIIIIIIN!");
			bja.EndQuestion();

		} else if (playerHand.getHandValue() == dealerHand.getHandValue() && dealerHand.getHandValue() > 17) {
			bja.showCards();
			System.out.println("You have the same score as the dealer, no one wins");
			bja.EndQuestion();
		}

		else if (playerHand.getHandValue() < 21 && playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You lose");
			bja.EndQuestion();

		} else if (playerHand.getHandValue() < 21 && dealerHand.getHandValue() < 17) {

			bja.Dealer();
		}

	}

	public void Dealer() {

		while (dealerHand.getHandValue() < 17) {
			System.out.println("Dealer must hit...");
			dealerHand.addCardsToHand(deck.getCard());
//			System.out.println(dealerHand.getHandValue());
		}
		if (dealerHand.getHandValue() > 21) {
			bja.showCards();
			System.out.println("Dealer BUSTS with: \t" + dealerHand.getHandValue());
			bja.EndQuestion();
		}

		else if (playerHand.getHandValue() <= 21 && playerHand.getHandValue() > dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You win with score: " + playerHand.getHandValue());
			System.out.println("Dealer loses with score: " + dealerHand.getHandValue());
			bja.EndQuestion();
		} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You lose with score: " + playerHand.getHandValue());
			bja.EndQuestion();

		} else if (playerHand.getHandValue() == dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("Player and dealer have the same score, no winner");
			bja.EndQuestion();
		}

	}

	public void displayGameName() {

		System.out.println("=================================");
		System.out.println("=====LET'S PLAY BLACKJACK!!!=====");
		System.out.println("=================================");

		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void Begin() {

		System.out.println("Would you like to play Blackjack (Y) or (N)?\n");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		if (answer.equalsIgnoreCase("Y")) {
			bja.run();

		} else if (answer.equalsIgnoreCase("N")) {
			System.out.println("Ok, bye.");
			System.exit(1);
		} else {
			System.out.println("I did not understand your answer :( ");
			bja.Begin();
		}
	}

	public void EndQuestion() {

		System.out.println("Play again? YES (Y) or NO (N)");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		if (answer.equalsIgnoreCase("Y")) {
			playerHand.clearHand();
			dealerHand.clearHand();
			deck.clear();
			bja.run();
		} else if (answer.equalsIgnoreCase("N")) {
			System.out.println("Bye, Felicia");
			System.exit(1);
		}
		else {
			System.out.println("I did not understand your answer  :(");
			bja.EndQuestion();
	

		}
	}

	public void formattingLines() {
		System.out.println("-------------------------");
	}

	public void showCards() {
		System.out.println("Player cards: " + playerHand.getCards());
		System.out.println("Dealer cards: " + dealerHand.getCards());
	}

}
