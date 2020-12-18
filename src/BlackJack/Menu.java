package BlackJack;

import java.util.Scanner;

public class Menu {
  public String choose() {
    while (true) {
      print();
      Scanner scanner = new Scanner(System.in);
      String choose = scanner.next();
      if (choose.toLowerCase().equals("hit")) {
        return "hit";
      } else if (choose.toLowerCase().equals("stand")) {
        return "stop";
      } else {
        System.out.println("wrong cmd");
      }
    }
  }
  public void print(){
    System.out.println("\nPlease choose an action:\n"
                           + "\t hit\n"
                           + "\t stand"
    );
  }
}
