import java.util.*;

// public enum Value {
// 	"Ace","2","3","4","5","6","7","8","9","10","King","Queen","King" 
// }
// public enum Type{
// 	"Heart", "Diamond", "Club", "Spade"
// }
// public enum Color{
// 	"Red", "Black"
// }

public class Card
{

	public String value;
	public String type;
	public String color;

	public Card()
	{
		value = null;
		type = null;
		color = null;
	}
	public Card(String val, String t, String col)
	{
		value = val;
		type = t;
		color = col;
		//System.out.println(val + " " +t);
	}

	public String getValue() { return value;}
	public String getType() { return type;}
	public String getColor() { return color;}

}