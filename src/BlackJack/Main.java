package BlackJack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dealer d = new Dealer();
        Player p = new Player();
        p.setBudget(100);
        Scanner scanner = new Scanner(System.in);
        Blackjack.start(p,d,scanner);
    }
}
