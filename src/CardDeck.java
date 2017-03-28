import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class CardDeck {
	Random r= new Random();
	ArrayList <Card> cardsInDeck = new ArrayList <Card>();//ArrayList of cards comprises the deck
	
	public void createCardDeck(){
		//Create a new card for each combination of Suit and Rank (total of 52 cards).
		//Also, add that created card to the deck.
		for (Card.Suits s : Card.Suits.values()) 
		    for (Card.Ranks r : Card.Ranks.values()) 
		    	cardsInDeck.add(new Card(s,r)); 	
	}//close createCardDeck
	
	
	public void printCardDeck(){
		//print top-most layer of cards in deck
		for (int i=0; i<cardsInDeck.size(); i++)
			System.out.print("----------  ");
		
		//print upper rank layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			if (cardsInDeck.get(i).getRank()=="10")
				System.out.print("|"+ cardsInDeck.get(i).getRank() +"      |  ");
			else
				System.out.print("|"+ cardsInDeck.get(i).getRank() +"       |  ");
		
		//print filler layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			System.out.print("|        |  ");
		
		//print suit layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			if (cardsInDeck.get(i).getRank()=="10")
				System.out.print("|   "+cardsInDeck.get(i).getSuit()+"    |  ");
			else
				System.out.print("|   "+cardsInDeck.get(i).getSuit()+"    |  ");
		
		//print filler layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			System.out.print("|        |  ");
		
		//print bottom rank layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			if (cardsInDeck.get(i).getRank()=="10")
				System.out.print("|      "+cardsInDeck.get(i).getRank()+"|  ");
			else
				System.out.print("|       "+cardsInDeck.get(i).getRank()+"|  ");
		
		//print bottom-most layer of cards in deck
		System.out.println("");
		for (int i=0; i<cardsInDeck.size(); i++)
			System.out.print("¯¯¯¯¯¯¯¯¯¯  ");
		System.out.println("");
	}//close printCardDeck
	
	
	public void newDeck(){
		//clear any cards that are currently in the deck
		cardsInDeck.clear();
		//create a new deck
		createCardDeck();
	}//close newDeck
	
	
	public int totalCards(){
		return cardsInDeck.size();
	}//close cardCount
	
	
	public Card dealCard(){
		if(cardsInDeck.isEmpty()){ 
			System.out.println("There are no more cards in the deck! If you wish to " +
		     "continue playing, get a new deck.");
			return null; 
			}//end if
		else
			return cardsInDeck.remove(0);
	}//close dealCard
	
	
	public void shuffle(){
		Collections.shuffle(cardsInDeck);
	}//close shuffle
	
}//close CardDeck
