package cl.prezdev.carioca.game;

import cl.prezdev.carioca.cards.Card;
import cl.prezdev.carioca.cards.Shoe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Carioca {

    private static final Logger log = LoggerFactory.getLogger(Carioca.class);
    private static final String SEPARATOR = "=======================";

    private Shoe shoe;
    private LinkedList<Player> players;
    private LinkedList<Card> discardPile;
    private Player currentPlayer;

    public Carioca(boolean ordered, int numPlayers) {
        shoe = new Shoe(ordered);
        players = new LinkedList<>();
        discardPile = new LinkedList<>();

        for (int i = 0; i < numPlayers; i++) {
            players.add(
                    new Player("j" + i)
                    .setCards(new LinkedList<>(shoe.getCards(12)))
            );
        }
        switchPlayer();
    }
    
    public final void switchPlayer(){
        if(currentPlayer == null){
            currentPlayer = players.get(0);
        }else if(currentPlayer == players.get(0)){
            currentPlayer = players.get(1);
        }else{
            currentPlayer = players.get(0);
        }
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Card drawFromDeck(){
        return shoe.drawCard();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Card> getCards(int playerIndex) {
        return players.get(playerIndex).getCards();
    }

    public void play(int cardId) {
        Card card = currentPlayer.getCard(cardId);
        currentPlayer.remove(card);
        discardPile.add(card);

        printDiscardPile();
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public Card drawFromDiscardPile() {
        Card last = discardPile.peekLast();
        discardPile.remove(last);
        return last;
    }

    public void printDiscardPile() {
        log.info(SEPARATOR);
        log.info("Montoncito:");
        log.info(SEPARATOR);
        for (Card c : discardPile) {
            log.info("{}", c);
        }
        log.info(SEPARATOR);
    }
}
