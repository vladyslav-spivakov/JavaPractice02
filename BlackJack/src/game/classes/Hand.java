package game.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    List<Card> cards = new ArrayList<>();

    public abstract void addCard(Card c);
    public abstract void addCard(Deck deck);
    public abstract int getSum();
    public abstract void discardCards(Deck deck);
    public abstract void showHand();
}
