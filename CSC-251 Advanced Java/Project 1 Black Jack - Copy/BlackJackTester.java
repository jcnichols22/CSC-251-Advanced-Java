import java.util.Scanner;

// creates the BlackJackTester class
public class BlackJackTester {
    //creates the main method
    public static void main(String[] args) {
        //initialize constants and datatypes
        final int CARDS_IN_DECK = 52;
        final int FIRST_CARD_IN_HAND = 0;
        final int SECOND_CARD_IN_HAND = 1;
        final String CHOICE_HIT = "H";
        final String CHOICE_STAY = "S";
        final int NUMBER_OF_SHUFFLES = 5;
        boolean playerHit;
        boolean validChoice;
        String choice;
        Scanner input = new Scanner(System.in);

        //prints Welvome to Black-Jack to the console
        System.out.println("\nWelcome to Black-Jack\n");


        //create reference variables
        BlackJack game1 = new BlackJack(CARDS_IN_DECK);
        BlackJack.BlackJackPlayer player = game1.getPlayer();
        BlackJack.BlackJackPlayer dealer = game1.getDealer();

        // for loop shuffles the deck NUMBER_OF_SHUFFLES times
        for(int i=0; i < NUMBER_OF_SHUFFLES; i++){
            game1.shuffleDeck();
        }
        //Invoke the "dealCard" method on the appropriate existing reference variable passing reference variable "player" as the one argument.
        game1.dealCard(player);
        //Invoke the "dealCard" method on the appropriate existing reference variable passing reference variable "dealer" as the one argument.*/
        game1.dealCard(dealer);

        System.out.println("\nThe " + dealer.getName() + "'s first card is: ");

        //invokes the getCard method on the reference variable dealer passing FIRST_CARD_IN_HAND to print the dealers first card 
        System.out.println (dealer.getCard(FIRST_CARD_IN_HAND));
        
        // prints "dealer's second card is face-down"
        System.out.println("\nThe " + dealer.getName() + "'s second card is face-down.");

        // deals card to player and dealer
        game1.dealCard(player);
        game1.dealCard(dealer);
        //invokes the showcurrenthand method with player as the argument
        showCurrentHand(player);
        //invoked the showCurrentScore method with player as the argument
        showCurrentScore(player);
        
        //checks if player busted 
        if(player.checkBust()){
            playerHit = false;
        }
        else{
            playerHit = true;
        }
        // while loop loops while playerHit is equal to true
        while(playerHit){
            //do while loops while validChoice is true 
            do {
                System.out.print("Would you like to Hit(H) or Stay(S): ");
                choice = input.nextLine();  //storing user's choice
                
                //converting all text to lower case so case is insensitive 
                if(choice.toUpperCase().equals(CHOICE_HIT) || choice.toUpperCase().equals(CHOICE_STAY)) { 
                    validChoice = false;     
                }
                else{
                    validChoice = true;
                }
                
                //if player chooses to hit
                if(choice.toUpperCase().equals(CHOICE_HIT)){
                    //deals card with hit to player 
                    game1.dealCardWithHit(player);
                    //shows players current hand
                    showCurrentHand(player);
                    //shows players current score
                    showCurrentScore(player);
                    //checks if player busted
                    player.checkBust();

                    if(player.checkBust()){
                        playerHit = false;
                    }
                    else{
                        playerHit = true;
                    }
                }
                else{
                    playerHit = false;
                }

                //if-statement with the negation of the invocation of the "isBust" method on the reference variable "player"  
                if(!player.isBust()){
                    System.out.println("\nThe " + dealer.getName() + "'s second card is: ");
                    System.out.println(dealer.getCard(SECOND_CARD_IN_HAND));
                    showCurrentScore(dealer); // shows dealers current score
                    
                    while (dealer.getCurrentScore() <= BlackJack.DEALER_HIT_STAY_THRESHOLD) {                

                        game1.dealCardWithHit(dealer);
                    }
                }
                //Invoke the "checkBust" method on reference variable "dealer".
                dealer.checkBust();
                //Display the number of hits by the dealer using the following line of code:
                System.out.print("\nAfter 'Hitting' " + dealer.getNumberHits() + " time(s),");
                showCurrentHand(dealer); 
                showCurrentScore(dealer);
                game1.determineOutcome(player, dealer);    

                
            }while(validChoice);
        }
                  
        if (game1.getWinner() == BlackJack.Winner.DEALER)
            System.out.println("\nUnfortunately " + player.getName() + ", the " + dealer.getName() + " won this hand.");
        else if (game1.getWinner() == BlackJack.Winner.PLAYER)
            System.out.println("\n" + player.getName() + ", you have won this hand!");
        else
            System.out.println("\n" + player.getName() + ", you and the " + dealer.getName() + " have tied on this hand.");

        System.out.println("\n" + player.getName() + ", you 'Hit' " + player.getNumberHits() + " time(s).");
        System.out.println("\nThank you for playing!\n");
        input.close();
                
        }    
             
    static void showCurrentHand(BlackJack.BlackJackPlayer p){
        //The method body consists of two lines of code as follows:
        System.out.println("\n" + p.getName() + "'s current hand is:");
        //Invoke the "displayFormattedHand" method on reference variable "p".
        p.displayFormattedHand();

    }

    static void showCurrentScore(BlackJack.BlackJackPlayer p){
        //The method body consists of two lines of code as follows:
        System.out.print("\n" + p.getName() + "'s current score is: ");
        //Retrieve the current score by invoking the getter for property "currentScore" on reference variable "p", 
        System.out.println(p.getCurrentScore());
        //and send the return value to the console
    }

}