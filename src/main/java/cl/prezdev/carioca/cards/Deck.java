package cl.prezdev.carioca.cards;

import cl.prezdev.carioca.util.Shuffler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final Logger log = LoggerFactory.getLogger(Deck.class);
    private static final Random random = new Random();

    private LinkedList<Card> cards;

    public static final byte JOKERS = 2;
    public static final byte CARDS_PER_SUIT = 13;

    public Deck(boolean ordered) {
        cards = new LinkedList<>();

        for (int i = 0; i < Deck.JOKERS; i++) {
            cards.add(new Joker());
        }

        int id = 0;
        for (Suit suit : Suit.values()) {
            for (int cardIndex = 1; cardIndex <= CARDS_PER_SUIT; cardIndex++) {
                switch (suit) {
                    case HEART:
                        cards.add(new Card(id++, cardIndex, Suit.HEART));
                        break;
                    case DIAMOND:
                        cards.add(new Card(id++, cardIndex, Suit.DIAMOND));
                        break;
                    case SPADE:
                        cards.add(new Card(id++, cardIndex, Suit.SPADE));
                        break;
                    case CLUB:
                        cards.add(new Card(id++, cardIndex, Suit.CLUB));
                        break;
                }
            }
        }

        if (!ordered) {
            Shuffler.shuffle(cards);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getRandomCard() {
        int index = random.nextInt(cards.size());
        Card card = cards.get(index);

        cards.remove(card);

        return card;
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + cards + '}';
    }

    public void print() {
        log.info("========================================");
        log.info("Cantidad de cartas: {}", cards.size());
        log.info("========================================");
        cards.forEach(card -> log.info("{}", card));
    }

}
