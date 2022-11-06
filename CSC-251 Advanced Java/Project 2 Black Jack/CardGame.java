import java.util.*;
import java.util.function.ToDoubleFunction;

public abstract class CardGame {

    // Declare constants SPADES, HEARTS, DIAMONDS, CLUBS
    final String SPADES = "Spades";
    final String HEARTS = "Hearts";
    final String DIAMONDS = "Hearts";
    final String CLUBS = "Clubs";

    final String[] suits = {SPADES, HEARTS, DIAMONDS, CLUBS};

    // declare int constants
    final int ACE_NUM = 0;
    final int JACK_NUM = 10;
    final int QUEEN_NUM = 11;
    final int KING_NUM = 12;

    //declare string constants
    final String ACE_STR = "Ace";
    final String JACK_STR = "Jack";
    final String QUEEN_STR = "Queen";
    final String KING_STR = "King";

    // declare int constants ACE_SCORE, JACK_SCORE, QUEEN_SCORE, KING_SCORE
    final int ACE_SCORE = 11;
    final int JACK_SCORE = 10;
    final int QUEEN_SCORE = 10;
    final int KING_SCORE = 10;

    private Map<Integer, String> rankMap = new HashMap<>();
    private Map<String, Integer> scoreMap = new HashMap<>();

    // create private properties numberOfCardsInDeck, cardsInSuit, AND nextCard set to 0
    private int numberOfCardsInDeck;
    private int cardsInSuit;
    private int nextCard = 0;

    private final ArrayList<Card> deck = new ArrayList<>();

    public Map<Integer, String> getRankMap() {
        return Collections.unmodifiableMap(rankMap);
    }

    // create public getters for the private properties initialized above numberOfCardsInDeck, cardsInSuit, AND nextCard
    public int getNumberOfCardsInDeck() {
        return numberOfCardsInDeck;
    }
    public int getCardsInSuit() {
        return cardsInSuit;
    }
    public int getNextCard() {
        return nextCard;
    }

    public List<Card> getDeck() { return Collections.unmodifiableList(deck); }

    private void setRankMap(Map<Integer, String> rankMap) {
        this.rankMap = rankMap;
    }
    private void setScoreMap(Map<String, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }


    // create private setters for the 3 private properties above numberOfCardsInDeck, cardsInSuit, AND nextCard
    private void setNumberOfCardsInDeck(int numberOfCardsInDeck) {
        this.numberOfCardsInDeck = numberOfCardsInDeck;
    }
    private void setCardsInSuit(int cardsInSuit) {
        this.cardsInSuit = cardsInSuit;
    }
    private void setNextCard(int nextCard) {
        this.nextCard = nextCard;
    }

    // create a private method setDeck that has no arguments and returns no value
    private void setDeck(){
    // declare a local variable of datatype int named "cardsInDeck".
        int cardsInDeck;
         // Invokes the method getNumberOfCardsInDeck and assigns its return value to variable cardsInDeck
        cardsInDeck = getNumberOfCardsInDeck();
            // Invoke the method "clear" on property "deck".
        deck.clear();

    //for-loop that iterates variable "cardsInDeck" times
        for(int i=0; i < cardsInDeck; i++){
            // invokes the ad method on the property deck passing a new Card instance passing 
            //the control varibale to the card constructor
            deck.add(new Card(i));
        }
    }

    // From Project 1, modify the following method "dealCard" below as follows:
    public void dealCard(Player p){
    // Declare local variable int named "nextCardIndex", invoke the method getNextCard and assign its return value to variable nextCardIndex
        int nextCardIndex = getNextCard();
    // Declare local variable datatype "Card" named "nextCard" and assign the value of Using the method invocation "getDeck()" as a reference
    // variable, invoke the method "get" passing the variable "nextCardIndex" as the one argument.
        Card nextCard = getDeck().get(nextCardIndex);
    // From Project 1, modify this line of code: p.addCard2Hand(new Card(1));
    // to pass the variable "nextCard" to method "addCard2Hand" instead.
        p.addCard2Hand(nextCard);
    // Invoke method "setNextCard" passing the prefix increment of variable "nextCardIndex" as the argument.
        setNextCard(++nextCardIndex);
    }

    public void shuffleDeck() {

        // Declare a local int variable named "cardsInDeck". Invoke the method "getNumberOfCardsInDeck" 
        // and assign its return value to variable "cardsInDeck".
        int cardsInDeck = getNumberOfCardsInDeck();
        // Declare a local variable of datatype int named "index".
        int index;
        // Declare a local variable of datatype "Card" named "temp".
        Card temp;
    //for-loop that iterates variable "cardsInDeck" times
    for(int i=0; i < cardsInDeck; i++){
        // invoke the "random" method on Class "Math" and multiply it by variable "cardsInDeck" assigning this to index variable
            index = (int)(Math.random() * cardsInDeck);
        // invove the "get" method on the "deck" property passing the control variable from the for loop and assing to temp
            temp = deck.get(i);
        // Invoke the "set" method on property "deck" passing the for-loop's control variable as the first argument
        // second argument is invoking the "get" method on property "deck" passing the variable "index" as the one argument
            deck.set(i, deck.get(index));
        // Invoke the "set" method on property "deck" passing the variable "index" as the first argument, 
        // and passing the variable "temp" as the second argument.
            deck.set(index, temp);
        }

    }

    public CardGame(int numCards) {

        // Invoke method "setNumberOfCardsInDeck" passing the parameter variable "numCards" as the one argument
        setNumberOfCardsInDeck(numCards);
        // Invoke method "setCardsInSuit" passing the following expression as the one argument: 
        //Parameter variable "numCards" divided by the length of array "suits" 
        // This divides by the length of suits no matter the size of the array 
        setCardsInSuit(numCards / suits.length);

        Map<Integer, String> rankMap = new HashMap<>();
        rankMap.put(ACE_NUM, ACE_STR);
        rankMap.put(JACK_NUM, JACK_STR);
        rankMap.put(QUEEN_NUM, QUEEN_STR);
        rankMap.put(KING_NUM, KING_STR);

        this.setRankMap(rankMap);

        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put(ACE_STR, ACE_SCORE);
        scoreMap.put(JACK_STR, JACK_SCORE);
        scoreMap.put(QUEEN_STR, QUEEN_SCORE);
        scoreMap.put(KING_STR, KING_SCORE);

        this.setScoreMap(scoreMap);

        //Invoke the method "setDeck".
        setDeck();

    }

    public class Card {
        private String rank;
        private String suit;
        private int score;

        public String getRank() {
            return rank;
        }
        public String getSuit() {
            return suit;
        }
        public int getScore() {
            return score;
        }

        private void setRank(String rank) {
            this.rank = rank;
        }
        private void setSuit(String suit) {
            this.suit = suit;
        }
        private void setScore(int score) {
            this.score = score;
        }

        public Card(int cardNum) {

            // Declare a local int variable named "rankNum" 
            // Parameter variable "cardNum" modulus property "cardsInSuit" is assigned to the value of rankNum
            int rankNum = cardNum % cardsInSuit;

            if (rankMap.containsKey(rankNum))
                setRank(rankMap.get(rankNum));
            else
                setRank(String.valueOf(rankNum + 1));

            // Invoke method "setSuit" passing as the one argument the array "suits" which is indexed using:
            // Parameter variable "cardNum" divided by property "cardsInSuit".
            setSuit(suits[cardNum / cardsInSuit]);

            if (scoreMap.containsKey(getRank()))
                setScore(scoreMap.get(getRank()));
            else
                setScore(rankNum + 1);
        }

        @Override
        public String toString() {
            return "\t" + rank + " of " + suit;
        }
    }

    public static class Player {
        private String name;
        private int currentScore;
        private final ArrayList<Card> hand = new ArrayList<>();

        public String getName() {
            return name;
        }
        public int getCurrentScore() {
            return currentScore;
        }
        public List<Card> getHand() {
            return Collections.unmodifiableList(hand);
        }

        private void setName(String name) {
            this.name = name;
        }
        private void setCurrentScore(int currentScore) {
            this.currentScore = currentScore;
        }

        // Create a public method named "getCard" that takes one argument and returns a value of datatype "Card".
        // The one argument is datatype int and named "cardIndex".
        public Card getCard(int cardIndex){
            // return the calue of invoking "get" method on property hand passing cardIndex as the variable argument 
            return hand.get(cardIndex);
        }

        // Create a public method named "addCard2Hand" that takes one argument and returns no value.
        // The one argument is of datatype "Card" and named "c".
        public void addCard2Hand(Card c){
        // Invoke the "add" method on property "hand" passing the variable "c" as the one argument.
            hand.add(c);
        // Invoke method "setCurrentScore" passing the following expression
        // invoke the method "getCurrentScore" plus (+) invoke the method "getScore" on parameter variable "c".
            setCurrentScore(getCurrentScore() + c.getScore());
        }
        // Create a public method named "displayFormattedHand" that takes no arguments and returns no value.
        public void displayFormattedHand(){

        // for-loop that iterates the size of array "hand" times
            for(int i=0; i < hand.size(); i++){
        // Invoke the "get" method on property "hand" passing the for-loop's control variable as the one argument.
        // invoke the toString method and send all to console via println 
                System.out.println(hand.get(i).toString());
            }
        }

        // Create a public no-arg constructor for class "Player".
        public Player(){        
        // Declare a variable of datatype Scanner named "input", and assign a new Scanner instance from the console to it.
        Scanner input = new Scanner(System.in);
        // Display "Please enter your name: " to the console; keeping the cursor on the same line as the message.
        System.out.print("Please enter your name: ");
        // Declare a local variable of datatype String named "playerName".
        String playerName;
        // Invoke the "nextLine" on the variable "input" and assign the return value to variable "playerName".
        playerName = input.nextLine();
        // Invoke the "setName" method passing the variable "playerName" as the one argument.
        setName(playerName);
        }

        public Player(String name) {
            setName(name);
        }
    }

    public abstract void determineOutcome(Player p, Player d);
}