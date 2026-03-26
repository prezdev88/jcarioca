package game;

import cards.Card;
import cards.Shoe;
import java.util.LinkedList;

public class Carioca {

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
                    .setCards(shoe.getCards(12))
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

    public LinkedList<Card> getCards(int playerIndex) {
        return players.get(playerIndex).getCards();
    }

    public void play(int cardId) {
        Card card = currentPlayer.getCard(cardId);
        currentPlayer.remove(card);
        discardPile.add(card);

        printDiscardPile();
    }

    public LinkedList<Card> getDiscardPile() {
        return discardPile;
    }

    public Card drawFromDiscardPile() {
        Card last = discardPile.peekLast();
        discardPile.remove(last);
        return last;
    }

    public void printDiscardPile() {
        System.out.println("=======================");
        System.out.println("Montoncito:");
        System.out.println("=======================");
        for (Card c : discardPile) {
            System.out.println(c);
        }
        System.out.println("=======================");
    }
}
