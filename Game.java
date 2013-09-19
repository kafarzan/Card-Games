import java.util.*;

public class Game
{
	public static void main(String[] args)
	{
		Stack<Card> deck = new Stack<Card>();
		for(int i = 0; i< 13;i++)
		{
			for(int j = 0; j<4;j++)
			{
				Card temp = new Card(i,j);
		//		System.out.println(temp.getValue() + " " + temp.getType());
				deck.push(temp);
			}
		}
		System.out.println(deck.peek().getValue() + " " + deck.peek().getType());
		deck.pop();
		Card temp = Hit(deck);

		System.out.println(deck.peek().getValue() + " " + deck.peek().getType());
		System.out.println(temp.getValue() + " " + temp.getType());
		//Collections.shuffle(deck);

	}	

	public static Card Hit(Stack<Card> deck)
	{
		Card temp = deck.pop();
		return temp;
	}

}