import java.util.*;

public class BlackJack extends CardGame {

    final String DEALER_NAME = "Dealer";
    final int DEALER_HIT_STAY_THRESHOLD = 16;

    private final BlackJackPlayer player = new BlackJackPlayer();
    private final BlackJackPlayer dealer = new BlackJackPlayer(DEALER_NAME);

    enum Winner {DEALER, PLAYER, TIE}
    private Winner winner;

    public BlackJackPlayer getPlayer() {
        return player;
    }
    public BlackJackPlayer getDealer() {
        return dealer;
    }
    public BlackJack.Winner getWinner() {
        return winner;
    }

    private void setWinner(Winner winner) {
        this.winner = winner;
    }

    public void dealCardWithHit(Player p) {
        dealCard(p);

        // reference variable of datatype "BlackJackPlayer" and named "bjp".
        // Cast parameter variable "p" to datatype "BlackJackPlayer" and assign it to variable "bjp".
        BlackJackPlayer bjp = (BlackJackPlayer) p;
        // Declare a local int variable named "hits" and assign the value of invoking the 
        // getNumberHits method on reference variable bjp
        int hits = bjp.getNumberHits();
        // Invoke method "setNumberHits" on reference variable "bjp" passing the "prefix increment" of variable "hits" as the one argument.
        bjp.setNumberHits(++hits);

    }

    public void determineOutcome(Player p, Player d) {

        // reference variable of datatype "BlackJackPlayer" and named "bjp".
        // Cast parameter variable "p" to datatype "BlackJackPlayer" and assign it to variable "bjp".
        BlackJackPlayer bjp = (BlackJackPlayer) p;
        // reference variable of datatype "BlackJackPlayer" and named "bjd".
        // Cast parameter variable "d" to datatype "BlackJackPlayer" and assign it to variable "bjd".
        BlackJackPlayer bjd = (BlackJackPlayer) d;
        // if bjp.isBust evaluates to true
        if (bjp.isBust()){
                // if players bust the dealer is the winner 
                setWinner(Winner.DEALER);
            }
        else if(bjd.isBust()){
        // if dealer busts then player is set to the winner
                setWinner(Winner.PLAYER);
            }
        else if(bjd.getCurrentScore() > bjp.getCurrentScore()){
            // if dealers score is greater than players score then dealer is winner
                setWinner(Winner.DEALER);
            }
        else if(bjp.getCurrentScore() > bjd.getCurrentScore()){
            // if players score is greater than the dealers score then player is the winner
                setWinner(Winner.PLAYER);
            }
        else{
            //game would be a tie if neither score is greater and neither player or dealer busts
                setWinner(Winner.TIE);
            }

    }

    public BlackJack(int numCards) {
        super(numCards);
   }

    public static class BlackJackPlayer extends Player {
        final int BUST_SCORE = 21;

        private int numberHits;
        private boolean bust;

        public int getNumberHits() {
            return numberHits;
        }
        public boolean isBust() {
            return bust;
        }

        private void setNumberHits(int numberHits) {
            this.numberHits = numberHits;
        }
        private void setBust(boolean bust) {
            this.bust = bust;
        }

        public boolean checkBust() {
            boolean bust = false;

            // Write an if-statement invoking the "getCurrentScore" method and compare for greater-than to the "Bust Score" constant.
            if(getCurrentScore() > BUST_SCORE){
                // if current score is greater than bust score it will set bust to true
                bust = true;
                setBust(bust);
            }

            return bust;
        }

        public BlackJackPlayer(){

        }

        public BlackJackPlayer(String name) {
            super(name);
        }
    }
}