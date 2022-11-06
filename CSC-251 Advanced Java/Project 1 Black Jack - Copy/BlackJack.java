//Define a public class named "BlackJack" that subclasses class "CardGame".
public class BlackJack extends CardGame{
//Define an enumerated type by adding the following line of code to the class: enum Winner {DEALER, PLAYER, TIE}*/
	enum Winner {DEALER, PLAYER, TIE}
	
   //Defining private property winner and constants DEALER_HIT_STAY_THRESHOLD & DEALER_NAME
	private Winner winner;
   final static int DEALER_HIT_STAY_THRESHOLD = 16;
	final String DEALER_NAME = "Dealer";

   // private reference variable datatype BlackJackPlayer named player and assigned a new instance of BlackJackPlayer
	private BlackJackPlayer player = new BlackJackPlayer();
   // private reference variable datatype BlackJackPlayer named dealer and assigned a new instance of BlackJackPlayer with DEALER_NAME as argument
	private BlackJackPlayer dealer = new BlackJackPlayer(DEALER_NAME);
   
   //public getter for each of these three properties "winner", "player", and "dealer" that just returns the property.
   public Winner getWinner() {
      return winner;
   }
   public BlackJackPlayer getPlayer() {
      return player;
   }
   public BlackJackPlayer getDealer() {
      return dealer;
   }
   
   //private setter for property "winner" that assigns the parameter variable to the property and returns no value
   private void setWinner(Winner winner) {
      this.winner = winner;
   }
   // public method that takes an argument datatype Player named p
	public void dealCardWithHit(Player p) {
      //invokes the inherited method of dealCard passing p as the argument
		dealCard(p);
	}


   //Implement the abstract method "determineOutcome" having no method code. In other words, it is an empty method for now.*/	
	@Override
   public void determineOutcome(CardGame.Player p, CardGame.Player d) {
      
   }

   // public constructor for BlackJack class int argument numCards is the argument 
   public BlackJack(int numCards) {
      // invokes the superclass with numCards as the argument 
		super(numCards);
	}
	
   //public inner class BlackJackPlayer will subclass Player
   public static class BlackJackPlayer extends Player {
      //constant of datatype int, named "BUST_SCORE", having a value of 21.
		final int BUST_SCORE = 21;
      //First property is of datatype int and named "numberHits".
      private int numberHits;
      //Second property is of datatype boolean and named "bust".		
		private boolean bust;

      //public getter for each of these two properties that just returns the property.
      public int getNumberHits() {
         return numberHits;
      }
      public boolean isBust() {
			return bust;
		}

      //private setter for each of these two properties
		private void setNumberHits(int numberHits) {
			this.numberHits = numberHits;
		}
		private void setBust(boolean bust) {
			this.bust = bust;
		}

      //public method named "checkBust" that takes no arguments and returns boolean.
      public boolean checkBust() {
         //Declare a local variable of datatype boolean named "bust", and assign the value of false to it.
         boolean bust = false;
         setBust(bust);
         //return statement that returns the variable "bust".
			return bust;
		}

      //public no-arg constructor for class "BlackJackPlayer".
       public BlackJackPlayer(){
         //The method contains no code
       }

      //public one-arg constructor for class "BlackJackPlayer" with 1 String argument named "name"
		public BlackJackPlayer(String name) {
         //invoke the superclass' one-arg constructor passing parameter variable "name" as the one argument.
			super(name);
		}
	}

   
}