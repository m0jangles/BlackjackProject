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

		System.out.println("Dealer's first card is: " + dealerHand.addCardsToHand(deck.getCard()));
		System.out.println();

		System.out.println("YOUR second card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();

		System.out.println("Dealer's second card is A SECRET ");
		dealerHand.addCardsToHand(deck.getCard());
		System.out.println();

		System.out.println("YOUR current hand is: " + playerHand.getHandValue());
		System.out.println();

		System.out.println("Dealer's current hand is a SECRET ");
		dealerHand.getHandValue();
		System.out.println();
		if (playerHand.getHandValue() > 21) {
			System.out.println("What a BUST, you went over 21 ");
		}

		if (playerHand.getHandValue() == 21) {
			System.out.println("WINNER");
			System.out.println("You got BLACKJACK");
			System.out.println("WINNER");
			bja.EndQuestion();

		}
		if (dealerHand.getHandValue() == 21) {
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
		
		//this method needs work because when the user chooses stay,
		//the game should evaluate a winner based on what the current
		//hand values are
		//currently, sometimes the game hangs in limbo when the user chooses "S"
		Scanner sc = new Scanner(System.in);

		while (playerHand.getHandValue() < 21) {
			System.out.println("What would you like to do: HIT (H) or STAY (S)\t");
			String answer = scanner.nextLine();
			
			if (answer.equalsIgnoreCase("S")) {
				bja.stay();
			}
			if (answer.equalsIgnoreCase("H")) {
				System.out.println("New card is: \t" + playerHand.addCardsToHand(deck.getCard()));
				System.out.println("Your current hand is: \t" + playerHand.getHandValue());
			}

			if (playerHand.getHandValue() > 21) {

				System.out.println("WHAT A BUST!" + "Your losing score is: \t" + playerHand.getHandValue());
				bja.EndQuestion();

			}
			if (playerHand.getHandValue() == 21) {
				System.out.println("WINNER WINNER, CHICKEN DINNER");
				System.out.println("You got BLACKJACK");
			}
		}
	}

	public void stay() {

		if (playerHand.getHandValue() == 21) {
			System.out.println("You win");
			bja.EndQuestion();
		} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
			System.out.println("Your score is: " + playerHand.getHandValue());
			System.out.println("Dealer score is: " + dealerHand.getHandValue());
			System.out.println("You lose, better luck next time.");
		}

		else if (playerHand.getHandValue() < 21 && dealerHand.getHandValue() < 17) {

			bja.Dealer();
		}

	}

	public void Dealer() {

		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCardsToHand(deck.getCard());
//			System.out.println(dealerHand.getHandValue());
		}
		if (dealerHand.getHandValue() > 21) {
			System.out.println("Dealer BUSTS with: \t" + dealerHand.getHandValue());
			bja.EndQuestion();

		} else if (playerHand.getHandValue() <= 21 && playerHand.getHandValue() > dealerHand.getHandValue()) {
			System.out.println("You win with score: " + playerHand.getHandValue());
			System.out.println("Dealer loses with score: " + dealerHand.getHandValue());
		}
		{
		}

	}

	public void displayGameName() {

		System.out.println("****$LET'S PLAY BLACKJACK!!!$****");
		System.out.println("*********************************");
		System.out.println("****$LET'S PLAY BLACKJACK!!!$****");
		System.out.println("*********************************");
		System.out.println("****$LET'S PLAY BLACKJACK!!!$****");

		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void Begin() {
	
			System.out.println("Would you like to play Blackjack (Y) or (N)?\n");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				bja.run();

			} 
			else if (answer.equalsIgnoreCase("N")){
				System.out.println("Ok, bye.");
				System.exit(1);
			}
			else {
			System.out.println("(Y) or (N) ");
			bja.Begin();
		}
	}

	

	public void EndQuestion() {

		System.out.println("Play again? YES (Y) or NO (N)");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		if (answer.equalsIgnoreCase("Y")) {
			playerHand.clearHand();
			dealerHand.clearHand();
			deck.clear();
			bja.run();
		} else if (answer.equalsIgnoreCase("N")) {
			System.out.println("goodbye");
			System.exit(1);
		}
	}

}
