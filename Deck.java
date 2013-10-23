import java.util.*;

public class Deck
{
	public static Stack<Card> deck;
	// 	Stack<Card> deck1 = new Stack<Card>();
	public String[] values;
	public String[] types;
	public Deck()
	{
		deck = new Stack<Card>();

		String[] values = {"Ace","2","3","4","5","6",
					"7","8","9","10","King","Queen","King"};
		String[] types = {"Heart", "Diamond", "Club", "Spade"};

		for(int i = 0; i< values.length;i++)
		{
			for(int j = 0; j<types.length;j++)
			{
				if(types[j].equals("Heart") || types[j].equals("Diamond"))
				{
					deck.push(new Card(values[i], types[j], "Red"));
					// System.out.println(deck.peek().getValue() + " of " + deck.peek().getType());

				}
				else
				{
					deck.push(new Card(values[i], types[j], "Black"));
					// System.out.println(deck.peek().getValue() + " of " + deck.peek().getType());
				}
			}
		}
		Collections.shuffle(deck);
	}

	public static Card pop(){ return deck.pop(); }
	public static Card peek(){ return deck.peek(); }
	public static boolean empty(){ return deck.empty(); }
}