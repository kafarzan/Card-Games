public class Card
{
	private static String value;
	private static String type;
	private static String color;

	private Card()
	{
		value = null;
		type = null;
		color = null;
	}
	public Card(int val, int t)
	{
		//System.out.println(val + " " +t);
		switch(val)
		{
		 	case 0:value = "Ace";
		 	break;
		 	case 1:value = "2";
		 	break;
		 	case 2:value = "3";
		 	break;
		 	case 3:value = "4";
		 	break;
		 	case 4:value = "5";
		 	break;
		 	case 5:value = "6";
		 	break;
		 	case 6:value = "7";
		 	break;
		 	case 7:value = "8";
		 	break;
		 	case 8:value = "9";
		 	break;
		 	case 9:value = "10";
		 	break;
		 	case 10:value = "Jack";
		 	break;
		 	case 11:value = "Queen";
		 	break;
		 	case 12:value = "King";
		 	break;
		}
		switch(t)
		{
		 	case 0:type = "Heart";
		 	break;
		 	case 1:type = "Diamond";
		 	break;
		 	case 2:type = "Club";
		 	break;
		 	case 3:type = "Spade";
		 	break;
		}
		switch(t)
		{
		 	case 0:color = "Red";
		 	break;
		 	case 1:color = "Red";
		 	break;
		 	case 2:color = "Red";
		 	break;
		 	case 3:color = "Red";
		 	break;
		}
	}

	public static String getValue() { return value;}
	public static String getType() { return type;}
	public static String getColor() { return color;}

}