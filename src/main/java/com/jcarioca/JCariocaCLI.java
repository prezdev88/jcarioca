package com.jcarioca;

import cards.Card;
import cards.Shoe;
import game.Carioca;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class JCariocaCLI implements CommandLineRunner {

    private final Carioca carioca;
    private final Shoe shoe;

    public JCariocaCLI(Carioca carioca, Shoe shoe) {
        this.carioca = carioca;
        this.shoe = shoe;
    }

    @Override
    public void run(String... args) {
        Scanner scan = new Scanner(System.in);

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
            System.out.println("0.- Salir");
            System.out.print("OP: ");
            option = scan.nextInt();

            if (option == 0) {
                System.out.println("¡Gracias por jugar!");
                break;
            }

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

                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
