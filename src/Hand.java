import java.util.ArrayList;

public class Hand {
   private ArrayList<Card> cardArray; //ArrayList of cards represents a hand

   public Hand(){
      cardArray= new ArrayList<Card>();
   }//close Hand()


   public void add(Card C){
      cardArray.add(C);
   }//close add


   public int handCardCount(){
      return cardArray.size();
   }//close handCardCount


   public void displayHand(boolean concealHand){
      //print top-most layer of cards in hand
      for (int i=0; i<cardArray.size(); i++)
         System.out.print("----------  ");

      //print upper rank layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         if(i==0 && concealHand)
            System.out.print("|?       |  ");
         else
            if (cardArray.get(i).getRank()=="10")
               System.out.print("|"+ cardArray.get(i).getRank() +"      |  ");
            else
               System.out.print("|"+ cardArray.get(i).getRank() +"       |  ");

      //print filler layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         System.out.print("|        |  ");

      //print suit layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         if(i==0 && concealHand)
            System.out.print("|   ?    |  ");
         else
            if (cardArray.get(i).getRank()=="10")
               System.out.print("|   "+cardArray.get(i).getSuit()+"    |  ");
            else
               System.out.print("|   "+cardArray.get(i).getSuit()+"    |  ");

      //print filler layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         System.out.print("|        |  ");

      //print bottom rank layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         if(i==0 && concealHand)
            System.out.print("|       ?|  ");
         else
            if (cardArray.get(i).getRank()=="10")
               System.out.print("|      "+cardArray.get(i).getRank()+"|  ");
            else
               System.out.print("|       "+cardArray.get(i).getRank()+"|  ");

      //print bottom-most layer of cards in hand
      System.out.println("");
      for (int i=0; i<cardArray.size(); i++)
         System.out.print("¯¯¯¯¯¯¯¯¯¯  ");
      System.out.println("");
   }//close displayHand


   public int handValue(){
      int handValue=0;
      //aceCount=0;
      //calculate preliminary hand value
      for (int i=0; i<cardArray.size(); i++)
         handValue+=cardArray.get(i).getRankValue();

      //adjust value according to aces held in hand
      for (int i=0; i<cardArray.size(); i++)
         if(cardArray.get(i).getRankValue()==11 && handValue>21)
            handValue-=10;

      return handValue;
   }//close handValue

   
   public void clearHand(){
      cardArray.clear();
   }

}//close class Hand



