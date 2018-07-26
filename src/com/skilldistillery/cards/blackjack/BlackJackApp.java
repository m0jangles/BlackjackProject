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
		//player gets a card
		System.out.println("YOUR first card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();
		
		//dealer gets a card
		dealerHand.addCardsToHand(deck.getCard());
		
		//player gets a card
		System.out.println("YOUR second card is: " + playerHand.addCardsToHand(deck.getCard()));
		System.out.println();
		
		//dealer gets face down card
		dealerHand.addCardsToHand(deck.getCard());
		
		//show player their current hand value
		System.out.println("YOUR current hand is: " + playerHand.getHandValue());
		bja.formattingLines();
		//only show the dealer's first card
		System.out.println("Dealer's first card is: " + dealerHand.getCards().get(0));
		System.out.println();
		System.out.println("Dealer's second card is A SECRET ");
		//dealerHand.addCardsToHand(deck.getCard());
		System.out.println();
		System.out.println("Dealer's current hand is a SECRET ");
		dealerHand.getHandValue();
		bja.formattingLines();
		//checks if you player gets 2 Aces in first hand, they automatically lose
		if (playerHand.getHandValue() > 21) {
			System.out.println();
			System.out.println("You got over 21 on your first hand.  Aces are hard.");
			bja.EndQuestion();
		}
		//checks if player gets 21 on first hand, they win
		if (playerHand.getHandValue() == 21) {
			System.out.println("WINNER");
			System.out.println("You got BLACKJACK");
			System.out.println("WINNER");
			bja.EndQuestion();

		}
		//checks if dealer gets 21 on first hand
//		if (dealerHand.getHandValue() == 21) {
//			System.out.println("Dealer score: " + dealerHand.getHandValue());
//			System.out.println("Dealer got BLACKJACK");
//			bja.EndQuestion();
//		}
		//checks if both dealer and player have blackjack, this is a tie game
		if (dealerHand.getHandValue() == 21 && playerHand.getHandValue() == 21) {
			System.out.println("This is a tie game, no winner, no chicken dinner");
			bja.EndQuestion();
		}
		//checks if player has less than 21, player hand enter method to choose to hit or stay
		//probably could have used player hand as the caller, might rework this later
		if (playerHand.getHandValue() < 21) {
			bja.Hit();
		}
	}

	public void Hit() {
		Scanner sc = new Scanner(System.in);
		
		//this loop is designed to keep asking the player if they want to hit if their
		//hand value is under 21, once the player is happy with their cards, they
		//should enter the stay method
		while (playerHand.getHandValue() < 21) {
			System.out.println("What would you like to do: HIT (H) or STAY (S)\t");
			String answer = scanner.next();
			//player hand can enter the stay method after hitting or immediately after
			//choosing to stay
			if (answer.equalsIgnoreCase("S")) {
				bja.stay();

			}
			//if player immediately hits, they will be dealt a new card
			if (answer.equalsIgnoreCase("H")) {
				System.out.println("New card is: \t" + playerHand.addCardsToHand(deck.getCard()));
				System.out.println("Your current hand is: \t" + playerHand.getHandValue());
				//this condition will evaluate based on the players hit to see if they
				//have a score over 21, they will lose if condition is true
				if (playerHand.getHandValue() > 21) {
					bja.showCards();
					System.out.println("WHAT A BUST!" + "  Your losing score is: \t" + playerHand.getHandValue());
					bja.EndQuestion();

				}
				//this condition will evaluate if the player has Blackjack, if
				//true they win
				if (playerHand.getHandValue() == 21) {
					bja.showCards();
					System.out.println("WINNER, WINNER, CHICKEN DINNER");
					System.out.println("You got BLACKJACK");
					bja.EndQuestion();
				}
			}
		}
	}

	//if player chooses to stay while in the hit, they move to the stay method
	public void stay() {
		//this condition will evaluate whether the player's hand is 21,
		//if true, they win
		if (playerHand.getHandValue() == 21) {
			bja.showCards();
			System.out.println("You win");
			bja.EndQuestion();
			//this condition will evaluate whether the player's end hand is less
			//than the dealer's end hand, the player loses if true
		} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("Your score is: " + playerHand.getHandValue());
			System.out.println("Dealer score is: " + dealerHand.getHandValue());
			System.out.println("You lose, better luck next time.");
			bja.EndQuestion();
			//this condition will evaluate whether the player hand value is greater than the dealer
			//hand but less than 21.  This will also check if the dealer hand value
			//is greater than or equal to 17 but less than 21, player will win
		} else if (playerHand.getHandValue() > dealerHand.getHandValue() && dealerHand.getHandValue() >= 17
				&& playerHand.getHandValue() < 21) {
			bja.showCards();
			System.out.println("Your score is: " + playerHand.getHandValue());
			System.out.println("Dealer's score is: " + dealerHand.getHandValue());
			System.out.println("You WIIIIIIIIIIIIIIIN!");
			bja.EndQuestion();
			//this condition will check if the player hand is equal to the dealer hand and also
			//if the dealer hand is greater than 21, this will be a tie
		} else if (playerHand.getHandValue() == dealerHand.getHandValue() && dealerHand.getHandValue() > 17) {
			bja.showCards();
			System.out.println("You have the same score as the dealer, no one wins");
			bja.EndQuestion();
		}
			//this condition will check if the player hand is both less than 21 and less than
			//dealer hand, player has a losing hand
		else if (playerHand.getHandValue() < 21 && playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You lose");
			bja.EndQuestion();
			//checks if player hand is less than 21 and dealer hand less than 17, game contineus
			//dealer will need to hit in the dealer method
		} else if (playerHand.getHandValue() < 21 && dealerHand.getHandValue() < 17) {

			bja.Dealer();
		}

	}

	public void Dealer() {
		//this loop is designed to make the dealer continue to hit as long 
		//as their hand value is less than 17
		while (dealerHand.getHandValue() < 17) {
			System.out.println("Dealer must hit...");
			dealerHand.addCardsToHand(deck.getCard());
//			System.out.println(dealerHand.getHandValue());
		}
		//this condition will check if the dealer's hand is greater than
		//21, if true, dealer loses
		if (dealerHand.getHandValue() > 21) {
			bja.showCards();
			System.out.println("Dealer BUSTS with: \t" + dealerHand.getHandValue());
			bja.EndQuestion();
		}
		//this condition will check one last time if the player hand value is greater than or
		//equal to 21 and also greater than the dealer's hand, if true, the player
		//will win
		else if (playerHand.getHandValue() <= 21 && playerHand.getHandValue() > dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You win with score: " + playerHand.getHandValue());
			System.out.println("Dealer loses with score: " + dealerHand.getHandValue());
			bja.EndQuestion();
			
		//this condition will check final hands to see if player hand value is less than
			//the dealer's
		} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("You lose with score: " + playerHand.getHandValue());
			bja.EndQuestion();
			//this will condition will check if final tie exits, if true, there is no winner
		} else if (playerHand.getHandValue() == dealerHand.getHandValue()) {
			bja.showCards();
			System.out.println("Player and dealer have the same score, no winner");
			bja.EndQuestion();
		}

	}
	//created this method to add a little glitter/sparkle/pizzaz to an otherwise
	//black and white, plain text user interface
	//unicode is fun
	public void displayGameName() {

		System.out.println("=================================");
		System.out.println("\u2665" + "\u2660" + " LET'S PLAY BLACKJACK!!! " + " \u2663" + "\u2666");
		System.out.println("=================================");

		System.out.println();
		System.out.println();
		System.out.println();
	}
	//This method is the initial question to the user for whether
	//they want to play a game of Blackjack
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
	//This is the end question that appears after every game to check
	//if the user wants to play another game.
	//This endQuestion method is different from the Begin method because 
	//This, one clears both hands and the deck for a fresh game of BlackJack
	//The game calls the run method which creates a new deck and shuffles it
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
		} else {
			System.out.println("I did not understand your answer  :(");
			bja.EndQuestion();

		}
	}
	//this is just a line to help break up the chunks of text that
	//the user sees
	public void formattingLines() {
		System.out.println("-------------------------");
	}
	//this method is to show the final hands dealt during each game so
	//player can be sure that they won or lost.
	public void showCards() {
		System.out.println("Player cards: " + playerHand.getCards());
		System.out.println("Dealer cards: " + dealerHand.getCards());
	}

}
