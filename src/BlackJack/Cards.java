package BlackJack;

import java.util.ArrayList;
import java.util.Random;

public class Cards {

    private ArrayList<String> CardDeck;
    int index;

    public Cards() {
        CardDeck = new ArrayList<>();
        char[] suits = {'♥', '♦', '♣', '♠'};
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};//
        for (char suit : suits) {
            for (String symbol : symbols) {
                CardDeck.add(suit + symbol);
                index++;
            }
        }
    }

    public ArrayList<String> getCardDeck() {
        return CardDeck;
    }

    public int[] getCardValue() {
        int[] value = new int[2];
        String symbol = CardDeck.get(index).substring(1);
        if(symbol.equals("A")){
            value[0] = 1;
            value[1] = 11;

        } else if(symbol.equals("J") || symbol.equals("Q") || symbol.equals("K")) {
            value[0] = 10;
            value[1] = value[0];
        } else {
            value[0] = Integer.parseInt(symbol);
            value[1] = value[0];
        }
        return value;
    }
    public String drawCard() {
        Random random = new Random();
        index = random.nextInt(CardDeck.size());
        setIndex(index);
        return CardDeck.get(index);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void removeTheElement()
    {
        CardDeck.remove(index);
    }
    public int[] getValueByCard( String card) {
        int[] value = new int[2];
        String symbol = card.substring(1);
        if(symbol.equals("A")){
            value[0] = 1;
            value[1] = 11;

        } else if(symbol.equals("J") || symbol.equals("Q") || symbol.equals("K")) {
            value[0] = 10;
            value[1] = value[0];
        } else {
            value[0] = Integer.parseInt(symbol);
            value[1] = value[0];
        }
        return value;
    }


}
