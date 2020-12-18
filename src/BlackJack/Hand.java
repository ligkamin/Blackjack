package BlackJack;

import java.util.ArrayList;

public class Hand {
  private ArrayList<Card> cards;
  private Integer value;

  public Hand(){
    begin();
  }
  public void begin(){
    cards = new ArrayList<>();
    value = 0;
    add();
    add();
  }
  public void add() {
    Deck deck = Deck.getInstance();
    Card card = deck.drawCard();
    cards.add(card);
    setValue(card);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public void setValue(Card card){
    if (card.getRank().getValue() == 1 && this.value+11<=21) {
      this.value+=11;
    } else {
      this.value+=card.value();
    }
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    String result ="";
    for (Card card :cards) {
        result+=" "+card;
    }
    return "Cards:"+result + "\n" +
           "Value: " +value;
  }
}
