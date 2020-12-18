package BlackJack;

public enum  Suits {
  SPADES('♠'),
  HEARTS('♥'),
  DIAMONDS('♦'),
  CLUBS('♣');

  private final char symbol;
  Suits(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }
}
