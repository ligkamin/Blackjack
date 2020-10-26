package BlackJack;

import java.util.ArrayList;

public class Rules {

    private boolean gameOver=true;

    public int[] firstTwoCards(ArrayList<String> cards) {
        int[] value=new int[]{0,0};

        if (cards.get(0).substring(1).equals("A") && cards.get(1).substring(1).equals("A")){
            value[0]=12;
            value[1]=12;
        }
        return value;
    }
    public ArrayList<Integer> cardAcePlayer(String card, ArrayList<Integer> hands){
        if (hands.get(0)+11<=21){
            hands.set(0, hands.get(0)+11);
            hands.set(1, hands.get(1)+11);
        } else {
            hands.set(0, hands.get(0)+1);
            hands.set(1, hands.get(1)+1);
        }
        return hands;
    }

    public boolean isTie(Player player, Computer computer){
        int playerHand = player.getHand();
        int computerHand = computer.getHand();
        return playerHand == computerHand;
    }
    public boolean isWinner(Player player, Computer computer){
        int playerHand = player.getHand();
        int computerHand = computer.getHand();
        if (computerHand>21) return true;
        return playerHand > computerHand;
    }
    public boolean isBlackJack(int hand) {
        return hand == 21;
    }
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
