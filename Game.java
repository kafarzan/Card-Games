import java.util.*;

public class Game
{

	// public static Stack<Card> createDeck()
	// {
		// Stack<Card> deck1 = new Stack<Card>();
	// 	for(int i = 0; i< 13;i++)
	// 	{
	// 		for(int j = 0; j<4;j++)
	// 		{
	// 			Card temp = new Card(i,j);
	// 			//System.out.println(temp.getValue() + " " + temp.getType());
	// 			deck1.push(temp);
	// 		}
	// 	}
	// 	for(int i = 0; i<52;i++)
	// 	{
	// 		System.out.println(deck1.peek().getValue() + " " + deck1.pop().getType());
	// 	}
	// 	return deck1;
	// }
	public static void TestShuffled(Deck deck)
	{
		while(!deck.empty())
		{
			Card temp = deck.pop();
			System.out.println(" Card is a : " + temp.getValue() + " of " + temp.getType());
		}
	}

	public static Card Hit(Stack<Card> deck)
	{
		Card temp = deck.pop();
		return temp;
	}

	public static void main(String[] args)
	{
		Deck deck = new Deck();

		//uncomment to test that the deck has been created and shuffled
		TestShuffled(deck);
	}
}