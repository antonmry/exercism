import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Simple card: x 1
 * 1 Pair: x 100
 * 2 Pairs: x 200
 * 3 of a kind: x 300
 */

public class Poker {

    private HashMap<String, Long> hands = new HashMap<>();
    private long maxValue = 0;

    public Poker(List<String> hands) {

        hands.forEach(hand -> {
            List<Character> cardsValues = Arrays.stream(hand.split(" "))
                    .map(s -> (s.charAt(0)))
                    .sorted()
                    .collect(Collectors.toList());

            long handValue = IntStream.range(0, hand.split(" ").length)
                    .mapToLong(cardPos -> cardsValues.get(cardPos) * (long) Math.pow(100, cardPos))
                    .sum();

            System.out.println(hand + ": " + handValue);
            this.hands.put(hand, handValue);
            if (handValue > maxValue) {
                maxValue = handValue;
            }
        });
    }

    public List<String> getBestHands() {
        return hands.entrySet().stream()
                .filter(hand -> hand.getValue() == maxValue)
                .map(hand -> hand.getKey())
                .collect(Collectors.toList());
    }
}
