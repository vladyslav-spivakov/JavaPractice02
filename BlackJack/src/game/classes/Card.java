package game.classes;

import game.configures.Suit;
import game.configures.Value;

public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Value aValue, Suit aSuit) {
        suit = aSuit;
        value = aValue;
    }

    public Value getValue() {
        return value;
    }

    public String toString() {
        return String.format("%s%s",value.toString(),suit.toString());
    }
}
