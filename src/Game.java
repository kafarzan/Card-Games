import java.util.*;

public class Game
{
	//Test to make sure deck was shuffled
	public static void TestShuffled(Deck deck)
	{
		while(!Deck.empty())
		{
			Card temp = Deck.pop();
			System.out.println(" Card is a : " + temp.getValue() + " of " + temp.getSuit());
		}
	}
	// adds a card to the players hand
	public static Card Hit(Deck deck)
	{
		Card temp = Deck.pop();
		return temp;
	}

	// used to determine winner of BlackJack
	public static String compareHand(Player p, Dealer d, Deck deck)
	{
		System.out.println("The Dealer has");
		Dealer.printHand();
		//dealer must have a value of 17 or above (vegas rules)
		while(Dealer.getBestValue() < 17)
		{
			Dealer.add(Hit(deck));
		}
		if(Dealer.getBestValue() > 21)
		{
			return "Winner";
		}
		else
		{
			if(Player.getBestValue() == Dealer.getBestValue())
			{
				return "Push";
			}
			else if(Player.getBestValue() > Dealer.getBestValue())
			{
				return "Winner";
			}
			else if(Player.getBestValue() < Dealer.getBestValue())
			{
				return "Loser";
			}
		}
		return "Loser";
	}

	public static void main(String[] args)
	{
		//decides what game to play
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("**********What Game would you like to play**********");
		System.out.println();
		System.out.println("1. BlackJack");
		System.out.println("2. Texas Hold Em'");
		System.out.println("3. 5 Card Stud");
		System.out.println("Press 1,2,3 to select");

		//checks that user gives correct input
		boolean game_chosen = false;
		String game_check;
		int game = 0;
		while(game_chosen == false){
			game_check = sc.next();
			if(game_check.length() == 1 && (game_check.charAt(0) < 52 && game_check.charAt(0) >48) ){
				game = Integer.parseInt(game_check);
				game_chosen = true;
			}
			else{ System.out.println("incorrect Input!!!");}
		}
		
		//sets what execution path (game) to play
		boolean play_Blackjack = false;
		boolean play_Texas = false;
		boolean play_Stud = false;
		switch (game){
			case 1: play_Blackjack = true;
					game_chosen = true;
					break;
			case 2: play_Texas = true;
					game_chosen = true;
					break;
			case 3: play_Stud = true;
					game_chosen = true;
					break;
			default: game_chosen = false;
					System.out.println("incorrect input");
		}
		// IDEA move games  (execution paths) to own class and name method Play ****
	
		//BlackJack
		while(play_Blackjack)
		{		
			System.out.println("**********BlackJack!!!**********");
			//sets up both player and Dealers hands
			Deck deck = new Deck();
			Hand dealersHand = new Hand();
			Dealer dealer = new Dealer(dealersHand);
			Dealer.add(Hit(deck));
			Dealer.add(Hit(deck));
			Hand PlayersHand = new Hand();
			Player player = new Player(PlayersHand);
			Player.add(Hit(deck));
			Player.add(Hit(deck));
			
			//begin players turn
			boolean GameDone = false;
			while(!GameDone)
			{
				System.out.println("Your Hand is ");
				System.out.println();
				Player.printHand();
				System.out.println();
				System.out.println("The Dealer's card is");
				System.out.println();
				Dealer.DisplayCard();
				System.out.println();
				Dealer.printCardValue();

				System.out.println();
				System.out.println("Do you want to hit or hold");
				System.out.print("type hit or hold : ");

				String input = sc.next();
				//add card to players hand
				if(input.equalsIgnoreCase("hit"))
				{
					Player.add(Hit(deck));
				}
				//if they hit 21 game is over for player
				if(Player.getBestValue() > 21)
				{
					GameDone = true;
				}
				//hold current cards and check for winner
				else if(input.equalsIgnoreCase("hold"))
				{
					GameDone = true;
				}	
			}
			
			//if player has more than 21 in hand they lose regardless of dealers hand
			if(Player.getBestValue() > 21)
			{
				System.out.println("**********Sorry, You Lost :( **********");
				System.out.println();
				System.out.println("Your Hand is ");
				System.out.println();
				Player.printHand();
				System.out.println();
				System.out.println("The Dealer has");
				Dealer.printHand();
			}
			//if less than 21 check who has the best hand
			else
			{
				String Result;
				//comapre Hand checks for who wins and reveal winner
				Result = compareHand(player, dealer, deck);
				if(Result.equalsIgnoreCase("Winner"))
				{
					System.out.println("**********Congratulations, You Won!!**********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					Player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					Dealer.printHand();
				}
				else if(Result.equalsIgnoreCase("Loser"))
				{
					System.out.println("**********Sorry, You Lost :( **********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					Player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					Dealer.printHand();
				}		
				else if(Result.equalsIgnoreCase("Push"))
				{
					System.out.println("**********You Tied**********");
					System.out.println();
					System.out.println("Your Hand is ");
					System.out.println();
					Player.printHand();
					System.out.println();
					System.out.println("The Dealer has");
					Dealer.printHand();
				}		
			}

			System.out.println("Do You wanna keep playing? (y or n)");
			String playAgain = sc.next();
			if(playAgain.equalsIgnoreCase("y"))
			{
				play_Blackjack = true;
			}
			else if(playAgain.equalsIgnoreCase("n"))
			{
				play_Blackjack = false;
			}
			//uncomment to test that the deck has been created and shuffled
			// TestShuffled(deck);
		}
	}
}