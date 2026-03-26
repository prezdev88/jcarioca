package cl.prezdev.carioca.game;

import cl.prezdev.carioca.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Player {

    private static final Logger log = LoggerFactory.getLogger(Player.class);

    private String name;
    private LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }

    public Player setCards(LinkedList<Card> cards) {
        this.cards = cards;
        return this;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getCard(int cardId) {
        return cards.stream()
                .filter(item -> item.getId() == cardId)
                .collect(Collectors.toList()).get(0);
    }

    public void remove(Card card) {
        cards.remove(card);
    }

    public Player printCards() {
        log.info("===================================");
        log.info("Cartas de [{}]", name);
        log.info("===================================");
        for (Card c : cards) {
            log.info("{}", c);
        }
        log.info("===================================");
        return this;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }
    
}
