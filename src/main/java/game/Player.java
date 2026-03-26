package game;

import cards.Card;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Player {

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
        System.out.println("===================================");
        System.out.println("Cartas de [" + name + "]");
        System.out.println("===================================");
        for (Card c : cards) {
            System.out.println(c);
        }
        System.out.println("===================================");
        return this;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }
    
}
