package BlackJack;

public class OperationFinished implements Strategy {
  @Override
  public String doOperation(int value) {
    if (value<21) return "not over";
    else if (value == 21) return "won";
    else return "lost";
  }
}
