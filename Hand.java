import java.util.*;

public class Hand
{
	public Card[] myHand;
	public int totalCards;
	
	public Hand() 
	{
		myHand = new Card[10];
		totalCards = 0;
	}

	public Hand(Card firstCard)
	{
		myHand = new Card[10];
		myHand[0] = firstCard;
		totalCards = 1;
	}

	public Card getCard(int i) { return myHand[i]; }
	public int getTotalCards() { return totalCards; }

}