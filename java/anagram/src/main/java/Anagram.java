import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private static String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> list) {
        return list.parallelStream()
                .filter(Anagram::isAnagram)
                .collect(Collectors.toList());
    }

    private static boolean isAnagram(String candidate) {
        if (word.equalsIgnoreCase(candidate)) return false;

        StringBuilder c = new StringBuilder(candidate.toLowerCase());

        for (char w : word.toLowerCase().toCharArray()) {
            if (c.indexOf(String.valueOf(w)) == -1) return false;
            c.deleteCharAt(c.indexOf(String.valueOf(w)));
        }

        return c.toString().isEmpty();
    }
}
