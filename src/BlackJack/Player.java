package BlackJack;

public class Player extends Move {
  protected String state;
  protected Hand hand;
  protected Strategy strategy;
  protected Integer bet;
  protected Integer budget;

  public Player() {
    Deck.getInstance();
    hand = new Hand();
    state="";
  }

  public Integer getBet() {
    return bet;
  }

  public Integer getBudget() {
    return budget;
  }

  public void setBet(Integer bet) {
    this.bet = bet;
  }

  public void setBudget(Integer budget) {
    this.budget = budget;
  }

  @Override
  public void move() {
    while (true) {
      System.out.println("Player:\n"+hand.toString());
      strategy = new OperationFinished();
      state = strategy.doOperation(hand.getValue());
      if (state.equals("won") || state.equals("lost")) return;
      Menu menu = new Menu();
      state = menu.choose();
      if (state.equals("hit")) hand.add();
      else {
        state = "stand";
        return;
      }
    }
  }
}
