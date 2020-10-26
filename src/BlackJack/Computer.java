package BlackJack;

import java.util.ArrayList;

public class Computer {
    private ArrayList<String> computerCards;
    private ArrayList<Integer> hands;

    public Computer(Cards cards,Rules rules) {
        computerCards = new ArrayList<>();
        hands = new ArrayList<>();
        hands.add(0);
        hands.add(0);
        for (int i=0; i<2; i++) {
            String card = cards.drawCard();
            computerCards.add(card);
            int[] value = cards.getCardValue();
                hands.set(0,hands.get(0)+value[0]);
                hands.set(1,hands.get(1)+value[1]);
            cards.removeTheElement();
        }
        if(rules.firstTwoCards(computerCards)[0]==12){
            int val=rules.firstTwoCards(computerCards)[0];
            hands.set(0, val);
            hands.set(1, hands.get(0));
        }
    }
    public void gameChoices(Cards cards){
        String card = cards.drawCard();
        computerCards.add(card);
        int[] value = cards.getCardValue();
            hands.set(0,hands.get(0)+value[0]);
        if(hands.size()!=1) {
            hands.set(1,hands.get(1)+value[1]);
        }
        cards.removeTheElement();
        }
    public int getHand() {
        if (hands.get(1)==0) return hands.get(0);
        else if (hands.get(1)<=21) return hands.get(1);
        return hands.get(0);
    }

    @Override
    public String toString() {
        String cards ="";
        for (int i=0; i<computerCards.size()-1;i++) {
            cards += "** ";
        }
        cards+=computerCards.get(computerCards.size()-1);
        return "-------------------------------\n"
                + "Computer: "
                + cards
                + "\n-------------------------------\n" ;
    }
    public String toStringReveal() {
        String cards ="";
        for (String computerCard : computerCards) {
            cards += computerCard + " ";
        }
        if(hands.get(0).equals(hands.get(1))) cards+="\n"+hands.get(0);
        else if (21<hands.get(1)) cards+="\n"+hands.get(0);
        else if (hands.get(1)==21) cards+="\n"+hands.get(1);
        else cards+="\n" + hands.get(0) +" "+hands.get(1);
        return "-------------------------------\n"
                + "Computer: "
                + cards
                + "\n-------------------------------\n" ;
    }
}
