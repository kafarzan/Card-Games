
public class Dealer {

	private static Hand myHand;
	private static int bestValue;
	
	
	public Dealer(Hand h)
	{
		myHand = h;
//		publicCard = h.getCard(0);
//		for(int i = 0; i < myHand.totalCards; i++)
//		{
//			if(myHand.getCard(i).getValue() == "King" || myHand.getCard(i).getValue() == "Queen" || myHand.getCard(i).getValue() == "Jack")
//			{
//				bestValue = 10;
//			}
//			else if(myHand.getCard(i).getValue() == "Ace" )
//			{
//				bestValue = 11;
//			}
//			else
//			{
//				bestValue = Integer.parseInt(myHand.getCard(i).getValue());
//			}
//		}
	}
	
	public static void DisplayCard() { System.out.println(myHand.getCard(0).getValue() + " of " + myHand.getCard(0).getSuit()); }
	public static int getBestValue() { return bestValue; }
	public static String PublicCardValue() { return myHand.getCard(0).getValue(); }
	public static Hand getHand() { return myHand; }
	public static void printCardValue()
	{
		if(myHand.getCard(0).getValue() == "King" || myHand.getCard(0).getValue() == "Queen" || myHand.getCard(0).getValue() == "Jack")
		{
			System.out.println("The dealers current value is 10");
		}
		else if(myHand.getCard(0).getValue() == "Ace")
		{
			System.out.println("The dealers current value is 11 or 1");			
		}
		else
		{
			System.out.println("The dealers current value is : " + Integer.parseInt(myHand.getCard(0).getValue()));
		}
	}
	
	
	public static void printHand()
	{
		for(int i = 0; i< myHand.totalCards; i++)
		{
			System.out.println(myHand.getCard(i).getValue() + " of " + myHand.getCard(i).getSuit());
		}
		System.out.println();
		System.out.println("Your highest Value is :" + bestValue);

	}

	public static boolean add(Card current)
	{
		int AceCount = 0;
		myHand.myHand[myHand.totalCards] = current;
		myHand.totalCards++;
		int temp = 0;
		for(int i = 0; i < myHand.totalCards; i++)
		{
			if(myHand.getCard(i).getValue() == "King" || myHand.getCard(i).getValue() == "Queen" || myHand.getCard(i).getValue() == "Jack")
			{	
				temp += 10;
			}
			else if(myHand.getCard(i).getValue() == "Ace")
			{
				++AceCount;
			}
			else
			{
				temp+= Integer.parseInt(myHand.getCard(i).getValue());
			}
		}
		bestValue = temp;
		if(AceCount > 0)
		{
			if(AceCount == 1)
			{
				if(bestValue + 11 <= 21)
				{
					bestValue += 11;
				}
				else if(bestValue + 1 <= 21)
				{
					bestValue += 1;
				}
				else
				{
					bestValue += 1;
					return false;
				}
			}
			else if(AceCount == 2)
			{
				if(bestValue + 12 <= 21)
				{
					bestValue += 12;
				}
				else if(bestValue + 2 <= 21)
				{
					bestValue += 2;
				}
				else
				{
					bestValue += 2;
					return false;
				}
			}
			else if(AceCount == 3)
			{
				if(bestValue + 13 <= 21)
				{
					bestValue += 13;
				}
				else if(bestValue + 3 <= 21)
				{
					bestValue += 3;
				}
				else
				{
					bestValue += 3;
					return false;
				}
			}
			else if(AceCount == 4)
			{
				if(bestValue + 14 <= 21)
				{
					bestValue += 14;
				}
				else if(bestValue + 4 <= 21)
				{
					bestValue += 4;
				}
				else
				{
					bestValue += 4;
					return false;
				}
			}
		}
		if(bestValue <=21)
			return true;
		else
			return false;
	}

	public static void clear()
	{
		for(int i = 0; i<5;i++)
		{
			myHand.myHand[i] = null;
		}
		myHand.totalCards = 0;
		bestValue = 0;
	}
	
}
