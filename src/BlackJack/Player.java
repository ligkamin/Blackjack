package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player{

    private ArrayList<ArrayList<String>> allPlayerCards;
    private ArrayList<ArrayList<Integer>> allHands;
    private ArrayList<String> playerCards;
    private ArrayList<Integer> hands;
    private String status="";
    private boolean splited= false;
    private int money;
    private int bet;

    public Player(Cards cards,Rules rules) {

        allPlayerCards = new ArrayList<>();
        allHands = new ArrayList<>();
        playerCards = new ArrayList<>();
        hands = new ArrayList<>();
        hands.add(0);
        hands.add(0);
        for (int i=0; i<2; i++) {
            String card = cards.drawCard();
            playerCards.add(card);
            int[] value = cards.getCardValue();
                hands.set(0,hands.get(0)+value[0]);
                hands.set(1,hands.get(1)+value[1]);
            cards.removeTheElement();
        }
        if(rules.firstTwoCards(playerCards)[0]==12){
           int value=rules.firstTwoCards(playerCards)[0];
            hands.set(0, value);
            hands.set(1, hands.get(1));
        }
    }

    public void gameChoices(Cards cards, Rules rules){

        if (getHand()!=21) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your options:");
            System.out.println("hit");
            System.out.println("stand");
            if(!status.equals("hit")) {
                System.out.println("double");
            }
            if (cards.getValueByCard(playerCards.get(0))[0] == cards.getValueByCard(playerCards.get(1))[0] && playerCards.size() == 2) {
                System.out.println("split");
            }
            if(!status.equals("hit")) {
                System.out.println("surrender\n");
            }
            System.out.print("Your choice: ");
            String choose = scanner.next();

            switch (choose) {
                case "hit":
                    hit(cards, rules);
                    status="hit";
                    break;
                case "stand":
                    status = "stand";
                    break;
                case "double":
                    if(status.equals("hit")) System.out.println("Wrong cmd");
                    else {
                        doubleBet();
                        System.out.println("Current bet: " + getBet());
                        hit(cards, rules);
                        status = "stand";
                    }
                    break;
                case "split":
                    if(status.equals("hit")) System.out.println("Wrong cmd");
                    else {
                        split(cards,rules);
                        status = "stand";
                    }
                    break;
                case "surrender":
                    if(status.equals("hit")) System.out.println("Wrong cmd");
                    else {
                        status = "surrender";
                        surrender();
                    }
                    break;
                default:
                    System.out.println("Wrong cmd");
            }
        }
    }
    public void hit(Cards cards, Rules rules) {
        String card = cards.drawCard();
        playerCards.add(card);
        setHandsValue(cards, rules, card);
        cards.removeTheElement();
    }

    private void setHandsValue(Cards cards, Rules rules, String card) {
        int[] value = cards.getValueByCard(card);
        if(card.substring(1).equals("A"))
        {
            ArrayList<Integer> valuee= rules.cardAcePlayer(card, hands);
            hands.set(0,valuee.get(0));
            hands.set(1,valuee.get(1));

        } else {
                hands.set(0, hands.get(0) + value[0]);
                hands.set(1, hands.get(1) + value[1]);
        }
    }
    private void setHandsValueByOne(int value1, int value2) {
        this.hands.set(0,value1);
        this.hands.set(1,value2);
    }

    public void doubleBet() {
        setMoney(getMoney()-bet*2);
        setBet(bet*2);
    }
    public void split (Cards cards, Rules rules) {

        splited=true;
        setBet(getBet()*2);
        hit(cards, rules);
        hit(cards, rules);
        Collections.swap(playerCards,1, 2);
        ArrayList<String> temp = new ArrayList<>();
        temp.add(playerCards.get(2));
        temp.add(playerCards.get(3));
        playerCards.remove(3);
        playerCards.remove(2);
        int[] value = new int[4];

        allPlayerCards.add(playerCards);
        this.hands.set(0,0);
        this.hands.set(1,0);
        setHandsValue(cards, rules, playerCards.get(0));
        setHandsValue(cards, rules, playerCards.get(1));
        value[0]=getHands().get(0);
        value[1]=getHands().get(1);

        setPlayerCards(temp);
        allPlayerCards.add(playerCards);
        this.hands.set(0,0);
        this.hands.set(1,0);
        setHandsValue(cards, rules, playerCards.get(0));
        setHandsValue(cards, rules, playerCards.get(1));
        value[2] = getHands().get(0);
        value[3] = getHands().get(1);
        //System.out.println(value[0] + " " + value[1] + " "+ value[2] + " " +value[3]);


        ArrayList<Integer> tempHands1 = new ArrayList<>();
        ArrayList<Integer> tempHands2 = new ArrayList<>();
        tempHands1.add(value[0]);
        tempHands1.add(value[1]);
        tempHands2.add(value[2]);
        tempHands2.add(value[3]);
        allHands.add(tempHands1);
        allHands.add(tempHands2);


        for (int i=0; i<2;i++){
            setPlayerCards(allPlayerCards.get(i));
            setHandsValueByOne(allHands.get(i).get(0),allHands.get(i).get(1));

            if (allHands.get(i).get(0)>=21 || allHands.get(i).get(0)>=21){
            } else {
                System.out.println(toStringSplit());
                while (true) {
                    if (allHands.get(i).get(0) >= 21 || allHands.get(i).get(0) >= 21 || status.equals("stand")) {
                        break;
                    } else {
                        System.out.println("Playing with " + (i + 1) + " hand:");
                        System.out.println(toStringSplit());
                        gameChoices(cards, rules);
                        allPlayerCards.set(i, playerCards);
                        value[0] = getHands().get(0);
                        value[1] = getHands().get(1);
                        allHands.get(i).set(0,value[0]);
                        allHands.get(i).set(1,value[1]);
                    }
                    System.out.println(toStringSplit());
                }
            }
        }
    }
    public void surrender() {
        setMoney(getMoney()-(bet-bet/2));
    }

    public void setPlayerCards(ArrayList<String> playerCards) {
        this.playerCards = playerCards;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public ArrayList<Integer> getHands() {
        return hands;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getCards() {
        return playerCards;
    }

    public int getHand() {
        if (hands.get(1)==0) return hands.get(0);
        else if (hands.get(1)<=21) return hands.get(1);
        return hands.get(0);
    }

    public void setHands(ArrayList<Integer> hands) {
        this.hands = hands;
    }

    public boolean isSplited() {
        return splited;
    }

    @Override
    public String toString() {
        String cards ="";
        for (String playerCard : playerCards) {
            cards += playerCard + " ";
        }
        cards+=getHandsPrint();

        return "-------------------------------\n"
                + "Player: \n"
                + cards
                + "\n-------------------------------\n" ;
    }

    public String toStringSplit() {
        String cards ="";
        int j=0;
        for (ArrayList playerCards : allPlayerCards) {
            for (int i=0; i<playerCards.size(); i++){
                cards += playerCards.get(i) + " ";
            }
            setHandsValueByOne(allHands.get(j).get(0), allHands.get(j).get(1));

            cards += allHands.get(j) + "\n";

           // cards += "\n";
            j++;
        }
        return "-------------------------------\n"
                + "Player: \n"
                + cards
                + "-------------------------------\n" ;
    }

    private String getHandsPrint() {
        if(this.hands.get(0).equals(this.hands.get(1))) return "| "+this.hands.get(0);
        else if (21<this.hands.get(1)) return "| "+this.hands.get(0);
        else if (this.hands.get(1)==21) return  "| "+this.hands.get(1);
        else return  "| " + this.hands.get(0) +" "+this.hands.get(1);
    }
}
