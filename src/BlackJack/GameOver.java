package BlackJack;

import java.util.Scanner;

public class GameOver {
  public static String playAgain(Scanner scanner) {
    while (true) {
      System.out.println("Play agian? yes/no");
      String result = scanner.next();
      if (result.equals("yes") || result.equals("no")){
        return result;
      } else {
        System.out.println("Wrong answer");
      }
    }
  }
  public static void whoWonByStatus(Player p, Dealer d) {
    if(p.state.equals("won") && d.state.equals("won")) {
      System.out.println("IT'S A TIE");
    } else if (p.state.equals("won")){
      won(p,d);
    } else {
      whoWonByValue(p,d);
    }
  }

  public static void whoWonByValue(Player p, Dealer d) {
    if(p.hand.getValue() == d.hand.getValue()) {
      System.out.println("IT'S A TIE");
    } else if (p.hand.getValue()>d.hand.getValue() || d.hand.getValue()>21){
      won(p,d);
    } else {
      lost(p,d);
    }
  }
  public static void won(Player p, Dealer d) {
    System.out.println("YOU WON");
    p.setBudget(p.getBudget()+p.getBet());
  }

  public static void lost(Player p, Dealer d) {
    System.out.println("YOU LOST");
    p.setBudget(p.getBudget()-p.getBet());
  }


}
