package game.configures;

public enum Suit {
    DIAMONDS("♦"), CLUBS("♣"), HEARTS("♥"), SPADES("♠");

    private String symbol;

    Suit(String aSymbol) {
        symbol = aSymbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return getSymbol();
    }

}
