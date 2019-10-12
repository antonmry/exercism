import java.util.stream.Collectors;
import java.util.stream.Stream;

class Twofer {

    String twofer(String name) {

        return Stream.of("One", "for", addComma(name), "one", "for", "me.")
                .map(Twofer::defaultTwoFer)
                .collect(Collectors.joining(" "));
    }

    private String addComma(String name) {
        return (name != null ? name + ',' : null);
    }

    private static String defaultTwoFer(String s) {
        return (s == null ? "you," : s);
    }
}
