package BlackJack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String gameStatus = "play";
        Scanner scanner = new Scanner(System.in);
        int money = 100;
        while(gameStatus.equals("play"))
        {
            Cards cards = new Cards();
            Rules rules = new Rules();
            Player player = new Player(cards,rules);
            Computer computer = new Computer(cards,rules);
            player.setMoney(money);
            System.out.println("Your money: "+player.getMoney());
            System.out.print("Place a bet: \n");
            player.setBet(scanner.nextInt());

            System.out.println(computer.toString());
            System.out.println(player.toString());

            while(true){

                if(player.getHand()<21 && !player.getStatus().equals("stand")) {
                    player.gameChoices(cards,rules);
                    if (!player.isSplited()){
                        System.out.println(player.toString());
                    } else {
                        System.out.println(player.toStringSplit());
                    }

                    if(player.getHand()>21){
                        player.setStatus("lost");
                        break;
                    }
                    if(player.getStatus().equals("stand") || player.getStatus().equals("surrender")) break;
                }else{
                    break;
                }
            }
            while(true){
                System.out.println(computer.toStringReveal());
                if(player.getStatus().equals("surrender")) break;
                if (!player.getStatus().equals("lost") && !(rules.isBlackJack(player.getHand()) && player.getCards().size()==2)) {
                    if (computer.getHand() < 17) {
                        computer.gameChoices(cards);
                    } else {
                        if(rules.isTie(player,computer)) {
                            System.out.println("IT'S A TIE\n");
                        }else{
                            if(rules.isWinner(player,computer)){
                                System.out.println("YOU WON!");
                                player.setMoney(player.getMoney()+player.getBet());
                            } else{
                                System.out.println("YOU LOST!");
                                player.setMoney(player.getMoney()-player.getBet());
                            }
                        }
                        break;
                    }
                } else {
                    if (rules.isTie(player,computer)){
                        System.out.println("IT'S A TIE\n");
                        break;
                    } else if (rules.isBlackJack(player.getHand())) {
                        System.out.println("YOU WON!\n");
                        player.setMoney(player.getMoney()+player.getBet());
                        break;
                    } else{
                        System.out.println("YOU LOST!\n");
                        player.setMoney(player.getMoney()-player.getBet());
                        break;
                    }
                }
            }
            scanner = new Scanner(System.in);
            while (true){
                money= player.getMoney();
                System.out.println("Your money: "+player.getMoney());
                System.out.println("Play again?");
                System.out.println("yes");
                System.out.println("no\n");
                System.out.print("Your choice: ");
                String choose = scanner.next();
                switch (choose) {
                    case "yes":
                        System.out.println("*************************************************");
                        break;
                    case "no":
                        gameStatus="end";
                        break;
                    default:
                        System.out.println("Wrong cmd");
                }
                if (choose.equals("yes") || choose.equals("no")) {
                    break;
                }
            }
        }
    }
}
