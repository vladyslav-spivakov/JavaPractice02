package game.classes;

import game.configures.*;
import java.util.*;


public class Deck {
    private final Stack<Card> cards = new Stack<Card>();
    private final List<Card> discardedCards = new ArrayList<Card>();

    private void reshuffle() {
        Collections.shuffle(discardedCards);
        cards.addAll(discardedCards);
        discardedCards.clear();
    }

    public Deck() {
        var tmpList = new ArrayList<Card>();
        int numOfDecks = 4;
        for(int i = 0; i < numOfDecks; i++) {
            for( var value : Value.values()){
                for( var suit : Suit.values()) {
                    tmpList.add(new Card( value, suit));
                }
            }
        }
        Collections.shuffle(tmpList);
        cards.addAll(tmpList);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean empty() {
        return cards.empty();
    }

    public void returnCards(Collection<Card> aCards) {
        discardedCards.addAll(aCards);
    }

    public Card getCard() {
        if( empty() ) reshuffle();
        return cards.pop();
    }


}
