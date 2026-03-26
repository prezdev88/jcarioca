package cl.prezdev.carioca.cards;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shoe {
    
    private final LinkedList<Deck> decks;
    private Random random;
    private LinkedList<Card> cards;
    
    private static final byte NUM_DECKS = 2;
    public static final boolean ORDERED = true; 
    public static final boolean SHUFFLED = false; 
    
    public Shoe(boolean ordered){
        decks = new LinkedList<>();
        cards = new LinkedList<>();
        
        for (int i = 0; i < Shoe.NUM_DECKS; i++) {
            decks.add(new Deck(ordered));
        }
        
        for(Deck deck : decks){
            for(Card card: deck.getCards()){
                cards.add(card);
            }
        }
    }

    public List<Deck> getDecks() {
        return decks;
    }
    
    public List<Card> getCards(int numCards){
        random = new Random();
        
        Deck deck;
        
        LinkedList<Card> selectedCards = new LinkedList<>();
        
        for (int i = 0; i < numCards; i++) {
            deck = getRandomDeck();
            selectedCards.add(deck.getRandomCard());
        }
        
        return selectedCards;
    }
    
    public Card drawCard(){
        Card card = cards.peekLast();
        cards.remove(card);
        return card;
    }
    
    private Deck getRandomDeck() {
        return decks.get(random.nextInt(NUM_DECKS));
    }
    
    public void print(){
        for(Deck deck : decks){
            deck.print();
        }
    }

}
