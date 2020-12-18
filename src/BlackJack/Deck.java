package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
  private ArrayList<Card> deck;

  private static Deck instance;
  private Deck() {
    this.deck = new ArrayList<>();
    for (Ranks ranks : Ranks.values()) {
      for (Suits suits : Suits.values()) {
        Card card = new Card(ranks, suits);
        deck.add(card);
      }
    }
    Collections.shuffle(this.deck);
  }
  public static Deck getInstance() {
    if (instance == null) {
      instance = new Deck();
    }
    return instance;
  }

  public Card drawCard(){
    Random random = new Random();
    int index = random.nextInt(this.deck.size());
    Card card = this.deck.get(index);
    removeCard(index);
    return card;
  }
  public void removeCard(int index) {
    this.deck.remove(index);
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }

  @Override
  public String toString() {
    return "Deck :" + deck;
  }
}
