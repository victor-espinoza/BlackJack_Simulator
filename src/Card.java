
public class Card {
   /*private String rank;
	private char suit; */

   private Ranks rank;
   private Suits suit;


   public enum Ranks {
      ACE("A",11), TWO("2",2), THREE("3",3), FOUR("4",4), FIVE("5",5), SIX("6",6), 
      SEVEN("7",7), EIGHT("8",8), NINE("9",9), TEN("10",10), JACK("J",10), 
      QUEEN("Q",10), KING("K",10);	

      private String rankLetter;
      private int rankValue;

      private Ranks(String letter, int value) {
         //assign the private variables of the Ranks enum
         this.rankLetter = letter;
         this.rankValue = value;
      }//close Ranks constructor


      public String getRankLetter() {
         return rankLetter;		
      }//close getRankLetter()


      public int getRankValue() {
         return rankValue;			
      }//close getRankValue()

   }//close enum Ranks


   public enum Suits {
      //note, the suit characters are encoded using UTF-8, and the default console 
      //encoding in eclipse is not UTF-8. In order to ensure that you can see
      // the appropriate suit symbols, you need to make sure to change the default
      //encoding for the console within eclipse to use UTF-8, otherwise the suit 
      //characters will be printed as a ? instead of their appropriate symbols. In order
      //to change the encoding settings for the console, click the drop down arrow on the 
      //run program button, select Run Configuration -> Common -> Encoding -> other and  
      //then Select UTF-8 from the drop down menu. This should fix the encoding issue and 
      //allow you to view the correct suit symbols!
      HEARTS('♥'), DIAMONDS('♦'), CLUBS('♣'), SPADES('♠');	

      private char suitValue;

      private Suits(char value) {
         //assign the private variables of the Suits enum
         this.suitValue = value;
      }//close Suits Constructor


      public char getSuitValue() {
         return suitValue;		
      }//close getSuitsValue()

   }//close enum Suits


   public Card(Suits suit, Ranks rank){
      //assign the private variables of the Card class
      this.rank = rank;
      this.suit = suit;
   }//close Card Constructor


   public Card(){
      //creates a card that has no suit or rank
   }//close Card()


   public String getRank(){
      return rank.getRankLetter();
   }//close getRank()


   public char getSuit(){
      return suit.getSuitValue();
   }//close getSuit()


   public int getRankValue(){
      return rank.getRankValue();
   }//close getRankValue()

}//close class Card

