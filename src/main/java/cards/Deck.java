package cards;

import util.Shuffler;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {

    private LinkedList<Card> cards;
    private Random random;

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

    public LinkedList<Card> getCards() {
        return cards;
    }

    public Card getRandomCard() {
        random = new Random();

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
        System.out.println("========================================");
        System.out.println("Cantidad de cartas: " + cards.size());
        System.out.println("========================================");
        cards.forEach((card) -> {
            System.out.println(card);
        });
    }

}
