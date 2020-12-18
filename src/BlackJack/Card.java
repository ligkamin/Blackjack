package BlackJack;

public class Card {
  private Ranks rank;
  private Suits suit;

  public Card(Ranks rank, Suits suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Ranks getRank() {
    return rank;
  }

  public Suits getSuit() {
    return suit;
  }

  public int value () {
    return this.rank.getValue();
  }

  @Override
  public String toString() {
    return
        suit.getSymbol() + ""+rank ;
  }
}
