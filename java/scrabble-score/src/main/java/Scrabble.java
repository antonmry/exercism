import java.util.AbstractMap;
import java.util.Map;

class Scrabble {

    private final static Map<Character, Integer> SCORES = Map.ofEntries(
            new AbstractMap.SimpleEntry<>('A', 1),
            new AbstractMap.SimpleEntry<>('E', 1),
            new AbstractMap.SimpleEntry<>('I', 1),
            new AbstractMap.SimpleEntry<>('O', 1),
            new AbstractMap.SimpleEntry<>('U', 1),
            new AbstractMap.SimpleEntry<>('L', 1),
            new AbstractMap.SimpleEntry<>('N', 1),
            new AbstractMap.SimpleEntry<>('R', 1),
            new AbstractMap.SimpleEntry<>('S', 1),
            new AbstractMap.SimpleEntry<>('T', 1),
            new AbstractMap.SimpleEntry<>('D', 2),
            new AbstractMap.SimpleEntry<>('G', 2),
            new AbstractMap.SimpleEntry<>('B', 3),
            new AbstractMap.SimpleEntry<>('C', 3),
            new AbstractMap.SimpleEntry<>('M', 3),
            new AbstractMap.SimpleEntry<>('P', 3),
            new AbstractMap.SimpleEntry<>('F', 4),
            new AbstractMap.SimpleEntry<>('H', 4),
            new AbstractMap.SimpleEntry<>('V', 4),
            new AbstractMap.SimpleEntry<>('W', 4),
            new AbstractMap.SimpleEntry<>('Y', 4),
            new AbstractMap.SimpleEntry<>('K', 5),
            new AbstractMap.SimpleEntry<>('J', 8),
            new AbstractMap.SimpleEntry<>('X', 8),
            new AbstractMap.SimpleEntry<>('Q', 10),
            new AbstractMap.SimpleEntry<>('Z', 10)
    );

    private int score;

    Scrabble(String word) {
        this.score = calculateScore(word);
    }

    public int getScore() {
        return score;
    }

    private int calculateScore(String word) {
        return word.toUpperCase().chars().map(this::getScore).sum();
    }

    private int getScore(int c) {
        return SCORES.containsKey((char) c) ? SCORES.get((char) c) : 0;
    }
}

