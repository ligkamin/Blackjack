package BlackJack;

import java.util.Scanner;

import static BlackJack.GameOver.lost;
import static BlackJack.GameOver.whoWonByStatus;

public class Blackjack {

  public static void start(Player p, Dealer d, Scanner scanner) {
    while (true) {
      System.out.println("You have: " + p.getBudget());
      System.out.println("Enter your bet: ");
      Integer input = scanner.nextInt();
      p.setBet(input);
      d.setBet(input);
      p.hand.begin();
      d.hand.begin();
      Move dealer = d;
      Move player = p;
      System.out.println("\nDealer:\n"+d.toStringHide());
      if (!(p.hand.getValue().equals(d.hand.getValue()) && p.hand.getValue()==21)) {
        player.move();
      }
      if (!p.state.equals("lost")) {
        dealer.move();
        whoWonByStatus(p,d);
      } else {
        lost(p,d);
      }
      String result = GameOver.playAgain(scanner);
      if (result.equals("no")) return;
    }
  }
}
