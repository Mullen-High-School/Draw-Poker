import java.util.Collections;
import java.util.Scanner;

public class CardDealer
	{
		static int randomNumber = (int) (Math.random() * 50);
		static boolean stillPlayingPart1 = true;
		static boolean stillPlayingPart2 = true;

		public static void main(String[] args)
			{
				GreetUser.greetUser();
				DeckCreator.fillCardDeck();
				while (stillPlayingPart1)
					{
						// ROUND 1
						shuffleCards();
						dealCards();
						Hand.sortHand1();
						Hand.sortHand2();
						HandValueAssignments.mainButNotReally();
						DisplayDeck.menu();
						Betting.compBetting();
						if (!Betting.compFold)
							{
								Betting.playerBetting();
							} else if (Betting.playerBet == 0)
							{
								HandValueComparisons.doYouWantToPlayAgain();
								stillPlayingPart1 = true;
								stillPlayingPart2 = false;
							} else if (Betting.compFold)
							{
								Betting.calculatePot();
								stillPlayingPart1 = true;
								stillPlayingPart2 = false;
							} else
							{
								Betting.calculatePot();
								HandValueComparisons.handValueComparisons();
								stillPlayingPart1 = true;
							}
					}

				while (stillPlayingPart2)
					{
						// ROUND 2
						TradeCards.tradeCards();
						Hand.sortHand1();
						Hand.sortHand2();
						HandValueAssignments.mainButNotReally();
						DisplayDeck.menu();
						Betting.compBetting();
						if (!Betting.compFold)
							{
								Betting.playerBetting();
							}
						if (Betting.playerBet == 0)
							{
								HandValueComparisons.doYouWantToPlayAgain();
								stillPlayingPart2 = true;
							} else if (Betting.compFold)
							{

								Betting.calculatePot();
								stillPlayingPart2 = true;
							} else
							{
								Betting.calculatePot();
								HandValueComparisons.handValueComparisons();
								stillPlayingPart2 = true;
							}
					}
				System.out.println("See you next time!");
				System.exit(0);
			}

		public static void shuffleCards()
			{
				Collections.shuffle(DeckCreator.deck);
			}

		public static void dealCards()
			{
				for (int i = 0; i < 10; i++)
					{
						if (i % 2 == 0)
							{
								Hand.hand1.add(DeckCreator.deck.get(0));
								DeckCreator.deck.remove(0);
							} else if (i % 2 == 1)
							{
								Hand.hand2.add(DeckCreator.deck.get(0));
								DeckCreator.deck.remove(0);
							} else
							{
								System.out.println("That's a problem...");
							}
					}
			}
	}