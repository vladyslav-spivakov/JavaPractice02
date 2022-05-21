package game.classes;

import java.util.Scanner;

public class Game {

    private Game(){}

    public static void run() {
        Dealer dealer = Dealer.getInstance();
        Player pl = new Player();

        Deck deck = new Deck();
        Scanner in = new Scanner(System.in);
        String inp;
        do {
            System.out.print("Type something to continue...");
            inp = in.next();
            System.out.println("\n\n");
            dealer.discardCards(deck);
            pl.discardCards(deck);
            dealer.addCard(deck);
            dealer.addCard(deck);
            pl.addCard(deck);
            pl.addCard(deck);

            boolean flag = false;
            while(true) {
                System.out.println("Dealer`s hand: " + dealer);
                System.out.println("Your hand:     " + pl);

                if(pl.getSum() > 21) {
                    System.out.println("Your sum is " + pl.getSum() + ". You`ve lost!");
                    break;
                }
                System.out.println("\nt. Take card\nn. Open cards\nq. Leave\n");
                System.out.print("Input:");
                inp = in.next();
                if (inp.equals("t")) {
                    pl.addCard(deck);
                } else if( inp.equals("n")) {
                    while(dealer.getSum() < 17) {
                        dealer.addCard(deck);
                    }
                    System.out.println("Dealer`s hand: " + dealer.toString(false));
                    System.out.println("Your hand:     " + pl);
                    if(dealer.getSum() > 21 || dealer.getSum() < pl.getSum()) {
                        if(pl.getSum() == 21) {
                            System.out.println("BLACK JACK! YOU WON!");
                            break;
                        }
                        System.out.println("YOU WON!");
                        break;
                    }
                    if(dealer.getSum() == pl.getSum()) {
                        System.out.println("DRAW!");
                        break;
                    }
                    System.out.println("YOU LOST!");
                    break;
                } else if (inp.equals("q")) {
                    System.out.println("Good luck!");
                    return;
                }
            }

        } while( true);
    }

}
