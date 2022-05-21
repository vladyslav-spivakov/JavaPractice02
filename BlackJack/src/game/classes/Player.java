package game.classes;

import game.configures.Value;

public class Player extends Hand{

    @Override
    public void addCard(Card c) {
        cards.add(c);
    }

    @Override
    public void addCard(Deck deck) {
        cards.add(deck.getCard());
    }

    @Override
    public final int getSum() {
        int numOfAces = 0;
        int sum = 0;
        for( Card c : cards) {
            Value cardValue = c.getValue();
            if( cardValue.getValue().equals("A")) numOfAces++;
            else {
                sum += cardValue.getPrice();
            }
        }
        if( numOfAces == 0) return sum;
        if( sum+11+numOfAces-1 > 21) return sum+numOfAces;
        return sum+11+numOfAces-1;
    }

    @Override
    public void discardCards(Deck deck) {
        deck.returnCards(cards);
        cards.clear();
    }

    @Override
    public void showHand() {
        for(Card c : cards) {
            System.out.print(c+" ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for(Card c : cards) {
            b.append(c.toString()).append(" ");
        }
        b.append("(").append(getSum()).append(")");
        return b.toString();
    }
}
