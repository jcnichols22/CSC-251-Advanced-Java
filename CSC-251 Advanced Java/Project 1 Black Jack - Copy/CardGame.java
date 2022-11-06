//Define a public abstract class named "CardGame".
public abstract class CardGame{
   //public method named "dealCard" that takes one argument datatype Player name "p" and returns no value      
   public void dealCard(Player p){
      //invokes the addCard2Hand method on p with argument create new instance of the card method passing number of cards 1
      p.addCard2Hand(new Card(1));
   }
    
   //public method "shuffleDeck" that takes no arguments and returns no value.
   public void shuffleDeck() {
      //The method contains no code.
   }

   //public one-arg constructor for class "CardGame" The one argument is of datatype int and named "numCards".*/      
   public CardGame(int numCards) {
      //The method contains no code.
   }

   /*public abstract method named "determineOutcome" that takes two arguments
   (datatype "Player" and named "p", datatype "Player" and named "d") and returns no value*/
   public abstract void determineOutcome(Player p, Player d);

      //public inner class named "Card" inside the CardGame class
      public class Card {
         //three private properties per the following:
         //First property is of datatype String and named "rank".
         private String rank;
         //Second property is of datatype String and named "suit".
         private String suit;
         //Third property is of datatype int and named "score".
         private int score;

         //public getter for each of these three properties
         public String getRank() {
            return rank;
         }
         public String getSuit() {
            return suit;
         }
         public int getScore() {
            return score;
         }
         //private setter for each of these three properties that assigns the parameter variable to the property and returns no value.
         private void setRank(String rank) {
            this.rank = rank;
         }            
         private void setSuit(String suit) {
            this.suit = suit;
         }            
         private void setScore(int score) {
            this.score = score;
         }

         // public one arg constructor for Card class argument is int numCards
         public Card(int numCards) {
                //method contains no code
            }

         //Override the toString method       
         @Override
         public String toString() {
            //Add the following one line of code to this method: return "\t" + rank + " of " + suit;*/
            return "\t" + rank + " of " + suit;
            }
         }
      //public static inner class named "Player" nested inside class "CardGame".*/    
      public static class Player{
      
         //private properties per the following: datatype String and named "name" & datatype int and named "currentScore"
         private String name;
         private int currentScore;

            //public getter for each of these two properties
         public String getName() {
            return name;
         }
         public int getCurrentScore() {
            return currentScore;
         }

         //private setter for each of these two properties that assigns the parameter variable to the property and returns no value.
         private void setName(String name) {
            this.name = name;
         }                
         private void setCurrentScore(int currentScore) {
            this.currentScore = currentScore;
         }
         //public method getCard takes one argument(int cardIndex) and returns a string
         public String getCard(int cardIndex){
            return "";
         }

         //public method named "addCard2Hand" that takes one argument and returns no value The one argument is of datatype "Card" and named "c".
         public void addCard2Hand(Card c){
            //invokes the setCurrentScore method setting score to 22
            setCurrentScore(22);
            }

            //public method named "displayFormattedHand" that takes no arguments and returns no value.
            public void displayFormattedHand(){
               //The method contains no code.
               }
            
            //public no-arg constructor for class "Player".    
            public Player(){
               //The method contains no code
               }
    
            //public one-arg constructor for class "Player" The one argument is of datatype String and named "name".
            public Player(String name){
               //invokes setName method taking parameter name to set name
               setName(name);
               }
            }          
        }