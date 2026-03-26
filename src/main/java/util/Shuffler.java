package util;

import cards.Card;
import cards.Deck;
import cards.Shoe;
import java.util.Collections;
import java.util.LinkedList;

public class Shuffler {
    public static void shuffle(LinkedList<Card> cards){
        Collections.shuffle(cards);
    }
    
    public static void shuffle(Deck deck){
        Shuffler.shuffle(deck.getCards());
    }
    
    public static void shuffle(Shoe shoe){
        shoe.getDecks().forEach((d) -> {
            Shuffler.shuffle(d.getCards());
        });
    }
}
