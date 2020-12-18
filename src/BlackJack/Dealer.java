package BlackJack;

public class Dealer extends Player {
  private Deck deck = Deck.getInstance();
  Dealer(){
  }

  @Override
  public void move() {
    strategy = new OperationOver();
    state = strategy.doOperation(hand.getValue());
    while (!state.equals("stand")) {
      System.out.println(hand.toString());
      hand.add();
      state = strategy.doOperation(hand.getValue());
    }
    System.out.println(hand.toString());
    strategy = new OperationFinished();
    state = strategy.doOperation(hand.getValue());
  }

  public String toStringHide() {
    String result ="";
    result+=hand.getCards().get(0);
    for (int i=1; i<hand.getCards().size(); i++) {
      result += " **";
    }
    return "Cards: " + result+"\n"
        + "Value: " +hand.getCards().get(0).getRank().getValue() + "\n";
  }
}
