import java.util.stream.IntStream;

public class FoodChain {

    private static final String[] LINES = {"I don't know why she swallowed the fly. Perhaps she'll die.",
            "It wriggled and jiggled and tickled inside her.",
            "How absurd to swallow a bird!", "Imagine that, to swallow a cat!", "What a hog, to swallow a dog!",
            "Just opened her throat and swallowed a goat!", "I don't know how she swallowed a cow!",
            "She's dead, of course!"};

    private static final String[] ANIMALS = {"fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse"};

    private static final String[] ANIMALS_EXTENSION = {"", " that wriggled and jiggled and tickled inside her", "",
            "", "", "", "", ""};

    private static final String INITIAL_LINE = "I know an old lady who swallowed a %s." + System.getProperty("line.separator");
    private static final String REPETITIVE_LINE = "She swallowed the %s to catch the %s%s." + System.getProperty("line.separator");

    public String verse(int verse) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(INITIAL_LINE, ANIMALS[verse - 1]));

        if (verse == ANIMALS.length) return sb.append(LINES[ANIMALS.length - 1]).toString();

        if (verse > 1) {
            sb.append(LINES[verse - 1]).append(System.getProperty("line.separator"));
        }

        sb.append(IntStream.range(1, verse)
                .mapToObj(i -> String.format(REPETITIVE_LINE, ANIMALS[verse - i], ANIMALS[verse - i - 1], ANIMALS_EXTENSION[verse - i - 1]))
                .reduce(String::concat).orElse(""));

        return sb.append(LINES[0]).toString();
    }

    private String verseForRange(int i, int end) {
        if (i != end) {
            return verse(i) + System.getProperty("line.separator") + System.getProperty("line.separator");
        }

        return verse(i);
    }

    public String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(i -> verseForRange(i, endVerse))
                .reduce(String::concat)
                .orElse("");
    }
}
