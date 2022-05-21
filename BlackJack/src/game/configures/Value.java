package game.configures;

public enum Value {
    TWO("2", 2), THREE("3", 3), FOUR("4", 4),
    FIVE("5", 5), SIX("6", 6), SEVEN("7",7),
    EIGHT("8", 8), NINE("9", 9), TEN("10", 10), J("J", 10),
    Q("Q", 10), K("K", 10), A("A");

    private String value;
    private int price;


    Value(String aValue, int aPrice) {
        this(aValue);
        price = aPrice;
    }

    Value(String aValue) {
        value = aValue;
    }


    public int getPrice() {return price;}

    public String getValue() {
        return value;
    }


    public String toString() {
        return getValue();
    }
}
