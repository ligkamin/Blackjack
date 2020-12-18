package BlackJack;

public class OperationOver implements Strategy {

  @Override
  public String doOperation(int value) {
    if (value<17) return "draw";
    else return "stand";
  }
}
