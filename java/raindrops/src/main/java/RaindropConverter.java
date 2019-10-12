import java.util.stream.Stream;

class RaindropConverter {

    String convert(int number) {
        String result = Stream.of(3, 5, 7)
                .map(s -> getString(number, s))
                .filter(RaindropConverter::isNotNull)
                .reduce(String::concat)
                .orElse(Integer.toString(number));

        return result;
    }

    private String getString(int number, int factor) {
        if ((factor == 3) && (number % factor == 0)) return "Pling";
        if ((factor == 5) && (number % factor == 0)) return "Plang";
        if ((factor == 7) && (number % factor == 0)) return "Plong";
        return null;
    }

    private static boolean isNotNull(String s) {
        return s != null;
    }

}
