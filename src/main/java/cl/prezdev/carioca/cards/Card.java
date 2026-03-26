package cl.prezdev.carioca.cards;

public class Card {
    private int id;
    private int rank;
    private Suit suit;

    public Card(int id, int rank, Suit suit) {
        this.id = id;
        this.rank = rank;
        this.suit = suit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", rank=" + rank + ", suit=" + suit + '}';
    }
    
    
    
}
