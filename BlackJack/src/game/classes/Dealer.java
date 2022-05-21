package game.classes;

// Singleton class
public final class Dealer extends Player{

    static private Dealer instance = null;

    private Dealer() {}

    public static Dealer getInstance() {
        if(instance == null) {
            instance = new Dealer();
        }
        return instance;
    }

    @Override
    public String toString() {
        return this.toString(true);
    }

    public String toString(boolean closed) {
        if( !closed) return super.toString();
        return cards.get(0).toString() + " XX".repeat(Math.max(0, cards.size() - 1));
    }
}
