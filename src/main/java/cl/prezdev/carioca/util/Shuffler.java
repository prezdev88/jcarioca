package cl.prezdev.carioca.util;

import cl.prezdev.carioca.cards.Card;
import cl.prezdev.carioca.cards.Deck;
import cl.prezdev.carioca.cards.Shoe;
import java.util.Collections;
import java.util.List;

public class Shuffler {

    private Shuffler() {
    }

    public static void shuffle(List<Card> cards){
        Collections.shuffle(cards);
    }
    
    public static void shuffle(Deck deck){
        Shuffler.shuffle(deck.getCards());
    }
    
    public static void shuffle(Shoe shoe){
        shoe.getDecks().forEach(d -> Shuffler.shuffle(d.getCards()));
    }
}
