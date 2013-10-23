// import java.util.*;

// public class Hand
// {
// 	private static myHand[] Hand;
// 	private static int bestValue;
// 	private static int totalCards;
	
// 	private Hand() 
// 	{
// 		myHand = null;
// 		bestValue = 0;
// 		totalCards = 0;
// 	}

// 	public Hand(Card firstCard, int value)
// 	{
// 		myHand[0] = firstCard;
// 		value = firstCard.getValue();
// 		totalCards = 1;
// 	}

// 	public static Card[] getHand() { return myHand; }
// 	public static int getBestValue() { return bestValue; }
// 	public static int getTotalCards() { return totalCards; }

// 	public static void add(Card current)
// 	{
// 		this.myHand[totalCards] = current;
// 		this.totalCards++;
// 		int temp = 0;
// 		for(int i = 0; i < totalCards; i++)
// 		{
// 			temp+= myHand[i].getValue();
// 		}
// 		this.bestValue = temp;
// 	}

// 	public static void clear()
// 	{
// 		myHand = null;
// 		this.totalCards = 0;
// 		this.bestValue = 0;
// 	}

// }