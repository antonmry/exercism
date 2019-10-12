import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class House {

    private final static String[] SONG = {
            "This is the horse and the hound and the horn",
            "belonged to the farmer sowing his corn",
            "kept the rooster that crowed in the morn",
            "woke the priest all shaven and shorn",
            "married the man all tattered and torn",
            "kissed the maiden all forlorn",
            "milked the cow with the crumpled horn",
            "tossed the dog",
            "worried the cat",
            "killed the rat",
            "ate the malt",
            "lay in the house that Jack built.",
    };

    public String verse(int verse) {
        return Arrays.stream(sing().split("\\n"))
                .skip(verse - 1)
                .limit(1)
                .collect(Collectors.joining());
    }

    public String verses(int startVerse, int endVerse) {

        return Arrays.stream(sing().split("\\n"))
                .skip(startVerse - 1)
                .limit(endVerse - startVerse + 1)
                .collect(Collectors.joining("\n"));
    }

    public String sing() {
        return sing(SONG.length);
    }

    private String sing(int verses) {
        return printFirstVerse(SONG[SONG.length - verses]) + "\n" +
                IntStream.range(SONG.length - verses + 1, SONG.length)
                        .mapToObj(i -> printNormalVerse(SONG[i]))
                        .collect(Collectors.joining("\n"));
    }

    private String printNormalVerse(String s) {
        return "that " + s;
    }

    private String printFirstVerse(String s) {
        return "This is " + s.substring(s.indexOf("the"));
    }

    /**
     *This is the house that Jack built.
     *
     * This is the malt
     * that lay in the house that Jack built.
     *
     * This is the rat
     * that ate the malt
     * that lay in the house that Jack built.
     */

}
