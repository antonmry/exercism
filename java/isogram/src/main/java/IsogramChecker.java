import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {

        Set<Integer> allItems = new HashSet<>();
        return phrase.toLowerCase().chars()
                .filter(IsogramChecker::cleanIsogram)
                .filter(c -> !allItems.add(c)).count() == 0;
    }

    private static boolean cleanIsogram(int c) {
        return c != ' ' && c != '-';
    }

}
