import java.util.ArrayList;
import java.util.List;

/**
 * Simple card: x 1
 * 1 Pair: x 100
 * 2 Pairs: x 200
 * 3 of a kind: x 300
 */

public class Poker {


    private List<String> hands;

    public Poker(List<String> hands) {
        this.hands = hands;
    }

    public List<String> getBestHands() {
        return hands;
    }
}
