import java.util.*;

public class Game
{
	//Test to make sure deck was shuffled
	public static void TestShuffled(Deck deck)
	{
		while(!deck.empty())
		{
			Card temp = deck.pop();
			System.out.println(" Card is a : " + temp.getValue() + " of " + temp.getSuit());
		}
	}

	public static Card Hit(Deck deck)
	{
		Card temp = deck.pop();
		return temp;
	}


	public static String compareHand(Player p, Dealer d, Deck deck)
	{
		System.out.println("The Dealer has");
		d.printHand();
		boolean bust = false;
		while(d.getBestValue() < 17)
		{
			d.add(Hit(deck));
		}
		if(d.getBestValue() > 21)
		{
			return "Winner";
		}
		else
		{
			if(p.getBestValue() == d.getBestValue())
			{
				return "Push";
			}
			else if(p.getBestValue() > d.getBestValue())
			{
				return "Winner";
			}
			else if(p.getBestValue() < d.getBestValue())
			{
				return "Loser";
			}
		}
		return "Loser";
	}

	public static void main(String[] args)
	{
		boolean play = true;
		while(play)
		{		
			System.out.println("**********Let's Play A Game**********");
			Scanner sc = new Scanner(System.in);

			Deck deck = new Deck();
			Hand dealersHand = new Hand();
			Dealer dealer = new Dealer(dealersHand);
			dealer.add(Hit(deck));
			dealer.add(Hit(deck));
			Hand PlayersHand = new Hand();
			Player player = new Player(PlayersHand);
			player.add(Hit(deck));
			player.add(Hit(deck));
			boolean GameDone = false;
			while(!GameDone)
			{
				System.out.println("Your Hand is ");
				System.out.println();
				player.printHand();
				System.out.println();
				System.out.println("The Dealer's card is");
				System.out.println();
				dealer.DisplayCard();
				System.out.println();
				dealer.printCardValue();

				System.out.println();
				System.out.println("Do you want to hit or hold");
				System.out.print("type hit or hold : ");

				String input = sc.next();
				if(input.equalsIgnoreCase("hit"))
				{
					player.add(Hit(deck));
				}
				if(player.getBestValue() > 21)
				{
					GameDone = true;
				}
				else if(input.equalsIgnoreCase("hold"))
				{
					GameDone = true;
				}	
			}

			if(player.getBestValue() > 21)
			{
				System.out.println("**********Sorry, You Lost :( **********");
				System.out.println();
				System.out.println("Your Hand is ");
				System.out.println();
				player.printHand();
				System.out.println();
				System.out.println("The Dealer has");
				dealer.printHand();
			}
			else
			{
				String Result;
				Result = compareHand(player, dealer, deck);
				if(Result.equalsIgnoreCase("Winner"))
				{
					System.out.println("**********Congratulations, You Won!!**********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					dealer.printHand();
				}
				else if(Result.equalsIgnoreCase("Loser"))
				{
					System.out.println("**********Sorry, You Lost :( **********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					dealer.printHand();
				}		
				else if(Result.equalsIgnoreCase("Push"))
				{
					System.out.println("**********You Tied**********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					dealer.printHand();
				}		
			}
			
			System.out.println("Do You wanna keep playing? (y or n)");
			String playAgain = sc.next();
			if(playAgain.equalsIgnoreCase("y"))
			{
				play = true;
			}
			else if(playAgain.equalsIgnoreCase("n"))
			{
				play = false;
			}
			//uncomment to test that the deck has been created and shuffled
			// TestShuffled(deck);
		}
	}
}