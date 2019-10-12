import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    private static final String[] VOWEL_SOUND = {"a", "e", "i", "o", "u", "xr", "yt"};
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxz";

    public String translate(String phrase) {

        return Arrays.stream(phrase.trim().split("\\s+"))
                .map(PigLatinTranslator::translateWord)
                .collect(Collectors.joining(" "));
    }

    private static String translateWord(String word) {

        return Arrays.stream(VOWEL_SOUND)
                .filter(s -> word.startsWith(s))
                .findAny()
                .map(s -> word.concat("ay"))
                .orElseGet(() -> translateConsonantsWord(word));
    }

    private static String translateConsonantsWord(String word) {
        int l = getConsonantsLength(word);

        if (word.substring(l - 1).startsWith("qu")) {
            return word.substring(l + 1) + word.substring(0, l + 1) + "ay";
        } else {
            return word.substring(l) + word.substring(0, l) + "ay";
        }
    }

    private static int getConsonantsLength(String word) {
        for (int l = 0; l < word.length(); l++) {
            if ((l == 0) && (word.charAt(l) == 'y')) continue;
            if (!isConsonantExceptY(word.charAt(l))) return l;
        }
        throw new UnsupportedOperationException("Word not supported: " + word);
    }

    private static boolean isConsonantExceptY(char c) {
        return CONSONANTS.indexOf(c) != -1;
    }


}
