package cl.prezdev.carioca.menu;

import cl.prezdev.carioca.cards.Card;
import cl.prezdev.carioca.cards.Shoe;
import cl.prezdev.carioca.game.Carioca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Menu.class);

    @Override
    public void run(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            Carioca carioca = new Carioca(Shoe.SHUFFLED, 2);

            int option;
            while (true) {
                log.info("=====================");
                log.info("MENÚ [ACTUAL: {}]", carioca.getCurrentPlayer());
                log.info("=====================");
                log.info("1.- Ver montoncito");
                log.info("2.- Sacar carta de montoncito");
                log.info("3.- Sacar carta del mazo");
                log.info("4.- Jugar");
                log.info("5.- Ver mis cartas");
                log.info("0.- Salir");
                log.info("OP: ");
                option = scan.nextInt();

                if (option == 0) {
                    log.info("¡Gracias por jugar!");
                    break;
                }

                switch (option) {
                    case 1:
                        carioca.printDiscardPile();
                        break;

                    case 2:
                        Card card = carioca.drawFromDiscardPile();
                        if (card != null) {
                            log.info("Carta sacada del montón: {}", card);
                            carioca.getCurrentPlayer().addCard(card);
                        } else {
                            log.info("No hay cartas en el montoncito");
                        }
                        break;

                    case 3:
                        card = carioca.drawFromDeck();
                        log.info("Carta sacada del mazo: {}", card);
                        carioca.getCurrentPlayer().addCard(card);
                        break;

                    case 4:
                        carioca.getCurrentPlayer().printCards();
                        log.info("ID CARTA: ");
                        int cardId = scan.nextInt();
                        carioca.play(cardId);
                        carioca.switchPlayer();
                        break;

                    case 5:
                        carioca.getCurrentPlayer().printCards();
                        break;

                    default:
                        log.info("Opción inválida");
                        break;
                }
            }
        }
    }
}
