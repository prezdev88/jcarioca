import cards.Card;
import cards.Shoe;
import game.Carioca;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Carioca carioca = new Carioca(Shoe.SHUFFLED, 2);

        int option;
        while (true) {
            System.out.println("=====================");
            System.out.println("MENÚ [ACTUAL: " + carioca.getCurrentPlayer() + "]");
            System.out.println("=====================");
            System.out.println("1.- Ver montoncito");
            System.out.println("2.- Sacar carta de montoncito");
            System.out.println("3.- Sacar carta del mazo");
            System.out.println("4.- Jugar");
            System.out.println("5.- Ver mis cartas");
            System.out.println("OP: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    carioca.printDiscardPile();
                    break;

                case 2:
                    Card card = carioca.drawFromDiscardPile();
                    if (card != null) {
                        System.out.println("Carta sacada del montón: " + card);
                        carioca.getCurrentPlayer().addCard(card);
                    } else {
                        System.out.println("No hay cartas en el montoncito");
                    }
                    break;

                case 3:
                    card = carioca.drawFromDeck();
                    System.out.println("Carta sacada del mazo: " + card);
                    carioca.getCurrentPlayer().addCard(card);
                    break;

                case 4:
                    carioca.getCurrentPlayer().printCards();
                    System.out.print("ID CARTA: ");
                    int cardId = scan.nextInt();
                    carioca.play(cardId);
                    carioca.switchPlayer();
                    break;

                case 5:
                    carioca.getCurrentPlayer().printCards();
                    break;
            }

        }

    }

}
