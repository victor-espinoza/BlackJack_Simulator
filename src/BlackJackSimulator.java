/*Program #6 - BlackJack Simulator
Victor Espinoza
CECS 174
Spring 2013
Due: May 8, 2013
 */

import java.util.Scanner;

public class BlackJackSimulator {

   /**
<<<<<<< HEAD
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner in = new Scanner(System.in);
      String addCard = "Y"; //user input for additional cards
      String continuePlaying = "Y"; //user input for continuing to play the game

      //Variables needed to keep track of the hand values and bet amounts
      double availIncome = 50.00, betAmount = 0.00, tabValue = 0.00;
      int player1HandValue = 0, dealerHandValue = 0;
      int menuResponse;

      //variable used to control what is displayed to the console when the user
      //is asked to input a Y/N response
      boolean promptType=true;

      //used to determine which appropriate hand configuration to display (dealer or player)
      boolean concealHand=true;

=======
   * @param args
   */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
		
      Scanner in= new Scanner(System.in);
      String addCard= "Y"; //user input for additional cards
      String continuePlaying= "Y"; //user input for continuing to play the game

      //Variables needed to keep track of the hand values and bet amounts
      double availIncome=50.00, betAmount=0.00, tabValue=0.00;
      int player1HandValue=0, dealerHandValue=0;
      int menuResponse;
		
      //variable used to control what is displayed to the console when the user
      //is asked to input a Y/N response
      boolean promptType=true;
		
      //used to determine which appropriate hand configuration to display (dealer or player)
      boolean concealHand=true;
		
>>>>>>> origin/master
      System.out.println("DISCLAIMER:\nThe suit characters used are encoded using " +
       "UTF-8, and the default console encoding in eclipse is not \nUTF-8. In order " +
       "to ensure that you can see the appropriate suit symbols, you need to make " +
       "sure to \nchange the default encoding for the console within eclipse to use " +
       "UTF-8, otherwise the suit characters \nwill be printed as a ? instead of " +
       "their appropriate symbols. In order to change the encoding settings \nfor " +
       "the console, click the drop down arrow on the run program button, select " +
       "Run Configuration -> \nCommon -> Encoding -> other and then Select UTF-8 " +
       "from the drop down menu. This should fix the encoding \nissue and allow you " +
       "to view the correct suit symbols! Sorry for the inconvenience.\n\n\n");

      //Create a new CardDeck and two new hands (1 for the player and one for the dealer)
<<<<<<< HEAD
      CardDeck CardDeck = new CardDeck();		
      Hand player1 = new Hand();
      Hand dealer = new Hand();

      CardDeck.newDeck();
      System.out.println("Welcome to the Blackjack Simulator program. A new deck " +
       "has been created!");

      menuResponse = mainMenuPrompt(in);
      //Input a number corresponding to the choice you want to perform.
      while(menuResponse !=5){
         switch(menuResponse){
            //create a new deck
            case 1: CardDeck.newDeck();
               System.out.println("A new deck has been created! " +
                "Make sure to shuffle the deck before you start playing...\n");
               break;
            //shuffle the deck
            case 2: CardDeck.shuffle();
               System.out.println("The deck has been shuffled.\n");
               break;
            //print all of the cards in the deck
            case 3: System.out.println("The deck will now be printed...\n");
               CardDeck.printCardDeck();
               break;
            //play blackjack
            case 4:
               if (availIncome<1.00){
                  //add money to the player's tab so they can continue playing
                  System.out.println("$50.00 has been added to your tab so you can "
                   + "continue playing.");
                  tabValue+=50.00;
                  availIncome+=50.00;
               }//end if
               if (CardDeck.totalCards()<=5){
                  System.out.println("There are not enough cards to continue the game! " +
                   "Create a new deck if you wish to continue.");
                  continuePlaying="N";
               }//end if
               else
                  continuePlaying="Y";
               while ((continuePlaying.equals("Y") || continuePlaying.equals("y")) && 
                CardDeck.totalCards()>6){
                  if(availIncome>0){
                     //prompt user to input how much money they want to bet
                     betAmount = betAmountPrompt(in, availIncome);
                     System.out.println("Bet recieved...");
                     //deal the cards to each player
                     player1.add(CardDeck.dealCard());
                     dealer.add(CardDeck.dealCard());
                     player1.add(CardDeck.dealCard());
                     dealer.add(CardDeck.dealCard());

                     //Display both hands (first card of dealer is concealed)
                     displayHands(concealHand, dealer, player1);

                     //get the values of the player's hand
                     player1HandValue = player1.handValue();

                     //prompt for if player wants another card or not.
                     addCard = yesNoPrompt(in, promptType);

                     while(addCard.equals("Y") || addCard.equals("y")){
                        if(CardDeck.totalCards()==0)
                           System.out.println("There are not enough cards to continue the" +
                            " game. Create a new deck if you wish to continue playing.");
                        else{
                           //add the new card to the player's hand
                           player1.add(CardDeck.dealCard());
                           player1HandValue = player1.handValue();
                           //display both hands
                           displayHands(concealHand, dealer, player1);

                           if (CardDeck.totalCards()>2 && player1HandValue<=21)
                              addCard = yesNoPrompt(in, promptType);
                           else
                              addCard= "N";	
                        }//end else	
                     }//end while
                     System.out.println("\nPlayer stands.\n");

                     //check to see if player has busted
                     if(player1HandValue>21){
                        System.out.println("Your score is " +player1HandValue +
                         ", which is over 21. You automatically lose pal. Better " +
                         "luck next time!");
                        availIncome-=betAmount;
                     }//end if
                     else{
                        //calculate the dealer's hand value
                        dealerHandValue = dealer.handValue();
                        while (dealerHandValue<17 && CardDeck.totalCards()>=1){
                           System.out.println("\nDealer requested a card!\n");
                           //add card to dealer's hand if they have a score less than 17
                           dealer.add(CardDeck.dealCard());
                           dealerHandValue = dealer.handValue();
                           //Display both hands 
                           displayHands(!concealHand, dealer, player1);
                        }//end while
                        
                        //once the dealer has a hand that totals 17 or more, they are 
                        //required to stand. Calculate the final results.
                        System.out.println("Dealer stands.\n\nFINAL RESULTS:");

                        //Display both hands 
                        displayHands(!concealHand, dealer, player1);

                        //Display the final results
                        if(player1HandValue<dealerHandValue && dealerHandValue<=21){
                           System.out.println("Dealer wins! You lose pal...");
                           availIncome-=betAmount;
                        }//end if
                        else if (player1HandValue==dealerHandValue) {
                           System.out.println("Looks like its a tie game! The " + 
                            "amount of money that you bet will be returned to you.");
                        }//end else if
                        else {
                           System.out.println("You win, congratulations!");
                           availIncome+=betAmount;
                        }//end else
                     }//end else
                     //display the player's current income
                     System.out.println("You have $" + String.format("%.2f", availIncome) 
                      +". ");

                     //give user the option to add money to their tab if they no longer
                     //have sufficient funds to play.
                     if (availIncome<1.00){
                        System.out.println("The minimum bid is $1. You do not have " +
                         "enough money to continue playing. You will be redirected to " +
                         "the\nmain menu. If you want to add $50.00 to your tab so you " +
                         "can continue playing, please select option #4.\n");
                        continuePlaying="N";
                     }//end if
                     else{
                        if (CardDeck.totalCards()>6)
                           continuePlaying=yesNoPrompt(in, !promptType);
                        else{
                           System.out.println("\nThere are not enough cards to continue " +
                            "playing. Create a new deck to continue playing...");
                           continuePlaying= "N";
                        }//end else
                     }//end else
                     
                     //clear each player's hand so they can start fresh with a new hand
                     player1.clearHand();
                     dealer.clearHand();
                  }//end if
               }//end while				
               break;
            //Default case	
            default: System.out.println("The default case has been reached!");
               break;
         }//end switch
         menuResponse= mainMenuPrompt(in);
      }//end while

      //hold player accountable for their tab if necessary
      if(tabValue>0.00)
         System.out.println("Your current tab is $" + String.format("%.2f", tabValue) +
          ". Don't forget to pay off your debt before you leave!!!");

      //inform the user that the program will terminate
      System.out.println("The program will now exit. Thank you for playing and enjoy " +
       "the rest of your day!");

      //close the scanner since it is no longer needed.
      in.close();

   }//close main


   public static void displayHands(boolean dHandConceal, Hand dealerHand, Hand playerHand){
      //Display the dealer's final hand and the final hand total
      System.out.println("Dealer Hand: ");
      dealerHand.displayHand(dHandConceal);
      if(dHandConceal)
         System.out.println("Dealer Hand Total: ???");
      else
         System.out.println("Dealer Hand Total: " + dealerHand.handValue());
      System.out.println("\nPlayer Hand: ");
      //display the player's final hand and the final hand total
      playerHand.displayHand(false);
      System.out.println("Player Hand Total: " + playerHand.handValue() + "\n");		
   }//close displayHands()


   public static int mainMenuPrompt(Scanner in){
      int userChoice;

      //Prompt user to select a choice
      do {		
         System.out.println("Main Menu:\n1) New Deck\n2) Shuffle cards in Deck\n" +
          "3) Display cards in Deck\n4) Play Black Jack\n5) Exit");

         //make sure the input is a number
         while (!in.hasNextInt()) {
            System.out.println("Please Enter A Valid INTEGER NUMBER Between 1-5!");
            System.out.println("Main Menu:\n1) New Deck\n2) Shuffle cards in Deck.\n" +
             "3) Display cards in Deck\n4) Play Black Jack\n5) Exit");
            in.next(); //advance the scanner for the next input attempt
         }//end inner while loop

         userChoice = in.nextInt();	

         //inform the user if the number entered is invalid
         if(userChoice<1 || userChoice>5)
            System.out.println("Please Enter A Valid Integer Number Between 1-5!");				
      } while(userChoice<1 || userChoice>5);

      return userChoice;		
   }//close mainMenuPrompt()


   public static double betAmountPrompt(Scanner in, double availIncome){
      double betAmount;

      //Prompt user to select how much money to bet
      do {		
         System.out.println("\nThe minimum bid is $1. You have $" +String.format("%.2f",availIncome)
          + ". How much do you want to bet (Do not include the $)?");

         //make sure the input is a number
         while (!in.hasNextDouble()) {
            System.out.println("Please Enter A Valid NUMBER That is greater Than $1 and " +
             "Doesn't Exceed Your Current Income (Exclude the $)!");
            in.next(); //advance the scanner for the next input attempt
         }//end inner while loop

         betAmount = in.nextDouble();	

         //inform the user if the number entered is invalid
         if(betAmount<1.00 || betAmount>availIncome)
            System.out.println("Please Enter A Valid Number That is greater Than $1 and " +
             "Doesn't Exceed Your Current Income (Exclude the $)!");	

      } while(betAmount<1.00 || betAmount>availIncome);

      return betAmount;		
   }//close betAmountPrompt()


   public static String yesNoPrompt(Scanner in, boolean promptType){
      String userResponse;

      //Prompt user to select how much money to bet
      do {
         if(promptType)
            System.out.println("\nDo you want another card?[Y/N]");
         else
            System.out.println("\nDo you want to play again?[Y/N]");

         userResponse = in.next();	

         //inform the user if the number entered is invalid
         if(!userResponse.equals("Y") && !userResponse.equals("y") && !userResponse.equals("N")
          && !userResponse.equals("n"))		
            System.out.println("Please Enter A Valid response (Y/N/y/n)!");	

      } while(!userResponse.equals("Y") && !userResponse.equals("y") && !userResponse.equals("N")
       && !userResponse.equals("n")); //end while

      return userResponse;		
   }//close betAmountPrompt()

=======
      CardDeck CardDeck= new CardDeck();		
      Hand player1= new Hand();
      Hand dealer= new Hand();
	
      CardDeck.newDeck();
      System.out.println("Welcome to the Blackjack Simulator program. A new deck " +
       "has been created!");
		
      menuResponse = mainMenuPrompt(in);
      //Input a number corresponding to the choice you want to perform.
      while(menuResponse !=5){
			switch(menuResponse){
				//create a new deck
				case 1: CardDeck.newDeck();
					System.out.println("A new deck has been created! " +
				     "Make sure to shuffle the deck before you start playing...\n");
					break;
				//shuffle the deck
				case 2: CardDeck.shuffle();
					//
					System.out.println("The deck has been shuffled.\n");
					break;
				//print all of the cards in the deck
				case 3: System.out.println("The deck will now be printed...\n");
					CardDeck.printCardDeck();
					break;
				//play blackjack
				case 4:
					if (availIncome<1.00){
						//add money to the player's tab so they can continue playing
						System.out.println("$50.00 has been added to your tab so you can "
						 + "continue playing.");
						tabValue+=50.00;
						availIncome+=50.00;
					}
					if (CardDeck.totalCards()<=5){
						System.out.println("There are not enough cards to continue the game! " +
					     "Create a new deck if you wish to continue.");
						continuePlaying="N";
					}//end if
					else
						continuePlaying="Y";
					while ((continuePlaying.equals("Y") || continuePlaying.equals("y")) && 
					 CardDeck.totalCards()>6){
						if(availIncome>0){
							
							betAmount = betAmountPrompt(in, availIncome);
							System.out.println("Bet recieved...");
							//deal the cards to each player
							player1.add(CardDeck.dealCard());
							dealer.add(CardDeck.dealCard());
							player1.add(CardDeck.dealCard());
							dealer.add(CardDeck.dealCard());
							
							//Display both hands (first card of dealer is concealed)
							displayHands(concealHand, dealer, player1);
							
							//get the values of the player's hand
							player1HandValue = player1.handValue();
							
							//prompt for if player wants another card or not.
							addCard = yesNoPrompt(in, promptType);

							while(addCard.equals("Y") || addCard.equals("y")){
								if(CardDeck.totalCards()==0)
									System.out.println("There are not enough cards to continue the" +
									 " game. Create a new deck if you wish to continue playing.");
								else{
									
									//add the new card to the player's hand
									player1.add(CardDeck.dealCard());
									player1HandValue = player1.handValue();
									//display both hands
									displayHands(concealHand, dealer, player1);
									
									if (CardDeck.totalCards()>2 && player1HandValue<=21)
										addCard = yesNoPrompt(in, promptType);
									else
										addCard= "N";	
								}//end else	
							}//end while
							System.out.println("\nPlayer stands.\n");

							//check to see if player has busted
							if(player1HandValue>21){
								System.out.println("Your score is " +player1HandValue +
								 ", which is over 21. You automatically lose pal. Better " +
								 "luck next time!");
								availIncome-=betAmount;
							}//end if
							else{
								//calculate the dealer's hand value
								dealerHandValue = dealer.handValue();
								while (dealerHandValue<17 && CardDeck.totalCards()>=1){
									System.out.println("\nDealer requested a card!\n");
									//add card to dealer's hand if they have a score less than 17
									dealer.add(CardDeck.dealCard());
									dealerHandValue = dealer.handValue();
									//Display both hands 
									displayHands(!concealHand, dealer, player1);
									
								}//end while
								//once the dealer has a hand that totals 17 or more, they are 
								//required to stand. Calculate the final results.
								System.out.println("Dealer stands.\n\nFINAL RESULTS:");
								
								//Display both hands 
								displayHands(!concealHand, dealer, player1);
															
								//Display the final results
								if(player1HandValue<dealerHandValue && dealerHandValue<=21){
									System.out.println("Dealer wins! You lose pal...");
									availIncome-=betAmount;
								}//end if
								else if (player1HandValue==dealerHandValue) {
									System.out.println("Looks like its a tie game! The " + 
								     "amount of money that you bet will be returned to you.");
								}
								else {
									System.out.println("You win, congratulations!");
									availIncome+=betAmount;
								}//end else
							}//end else
							//display the player's current income
							System.out.println("You have $" + String.format("%.2f", availIncome) 
							 +". ");
							
							//give user the option to add money to their tab if they no longer
							//have sufficient funds to play.
							if (availIncome<1.00){
								System.out.println("The minimum bid is $1. You do not have " +
								 "enough money to continue playing. You will be redirected to " +
								 "the\nmain menu. If you want to add $50.00 to your tab so you " +
								 "can continue playing, please select option #4.\n");
								continuePlaying="N";
							}//end if
							else{
								if (CardDeck.totalCards()>6)
									continuePlaying=yesNoPrompt(in, !promptType);
								else{
									System.out.println("\nThere are not enough cards to continue " +
									 "playing. Create a new deck to continue playing...");
									continuePlaying= "N";
								}//end else
							}//end else
							//clear each player's hand so they can start fresh with a new hand
							player1.clearHand();
							dealer.clearHand();
						}//end if
					}//end while				
					break;
				//Default case	
				default: System.out.println("The default case has been reached!");
					break;
			}//end switch
			menuResponse= mainMenuPrompt(in);
		}//end while
		
		//hold player accountable for their tab if necessary
		if(tabValue>0.00)
			System.out.println("Your current tab is $" + String.format("%.2f", tabValue) +
			 ". Don't forget to pay off your debt before you leave!!!");
		
		//inform the user that the program will terminate
		System.out.println("The program will now exit. Thank you for playing and enjoy " +
	     "the rest of your day!");
		
		//close the scanner since it is no longer needed.
		in.close();
						
	}//close main
	
	
	public static void displayHands(boolean dHandConceal, Hand dealerHand, Hand playerHand){
		//Display the dealer's final hand and the final hand total
		System.out.println("Dealer Hand: ");
		dealerHand.displayHand(dHandConceal);
		if(dHandConceal)
			System.out.println("Dealer Hand Total: ???");
		else
			System.out.println("Dealer Hand Total: " + dealerHand.handValue());
		System.out.println("\nPlayer Hand: ");
		//display the player's final hand and the final hand total
		playerHand.displayHand(false);
		System.out.println("Player Hand Total: " + playerHand.handValue() + "\n");		
	}//close displayHands()
	
	
	public static int mainMenuPrompt(Scanner in){
		int userChoice;
			
		//Prompt user to select a choice
		do {		
			System.out.println("Main Menu:\n1) New Deck\n2) Shuffle cards in Deck\n" +
			 "3) Display cards in Deck\n4) Play Black Jack\n5) Exit");
					
			//make sure the input is a number
			while (!in.hasNextInt()) {
				System.out.println("Please Enter A Valid INTEGER NUMBER Between 1-5!");
				System.out.println("Main Menu:\n1) New Deck\n2) Shuffle cards in Deck.\n" +
				 "3) Display cards in Deck\n4) Play Black Jack\n5) Exit");
				in.next(); //advance the scanner for the next input attempt
			}//end inner while loop
							
			userChoice = in.nextInt();	
					
			//inform the user if the number entered is invalid
			if(userChoice<1 || userChoice>5)
				System.out.println("Please Enter A Valid Integer Number Between 1-5!");				
		} while(userChoice<1 || userChoice>5);
					
		return userChoice;		
	}//close mainMenuPrompt()
	
	
	public static double betAmountPrompt(Scanner in, double availIncome){
		double betAmount;
			
		//Prompt user to select how much money to bet
		do {		
			System.out.println("\nThe minimum bid is $1. You have $" +String.format("%.2f",availIncome)
		     + ". How much do you want to bet (Do not include the $)?");
					
			//make sure the input is a number
			while (!in.hasNextDouble()) {
				System.out.println("Please Enter A Valid NUMBER That is greater Than $1 and " +
				"Doesn't Exceed Your Current Income (Exclude the $)!");
				in.next(); //advance the scanner for the next input attempt
			}//end inner while loop
							
			betAmount = in.nextDouble();	
			
			//inform the user if the number entered is invalid
			if(betAmount<1.00 || betAmount>availIncome)
				System.out.println("Please Enter A Valid Number That is greater Than $1 and " +
				"Doesn't Exceed Your Current Income (Exclude the $)!");	
							
		} while(betAmount<1.00 || betAmount>availIncome);
					
		return betAmount;		
	}//close betAmountPrompt()
		
	
	public static String yesNoPrompt(Scanner in, boolean promptType){
		String userResponse;
		
		//Prompt user to select how much money to bet
		do {
			if(promptType)
				System.out.println("\nDo you want another card?[Y/N]");
			else
				System.out.println("\nDo you want to play again?[Y/N]");
						
			userResponse = in.next();	
			
			//inform the user if the number entered is invalid
			if(!userResponse.equals("Y") && !userResponse.equals("y") && !userResponse.equals("N")
			 && !userResponse.equals("n"))		
				System.out.println("Please Enter A Valid response (Y/N/y/n)!");	
							
		} while(!userResponse.equals("Y") && !userResponse.equals("y") && !userResponse.equals("N")
		   && !userResponse.equals("n"));
					
		return userResponse;		
	}//close betAmountPrompt()
	
>>>>>>> origin/master

}//close class BlackJackSimulator




