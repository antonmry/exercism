import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {

        String s = candidate.replace(" ", "");

        return s.length() > 1 &&
                s.chars().filter(this::isValidDigit).count() == s.length() &&
                IntStream.rangeClosed(1, s.length()).map(i -> doubleOnlyIfEvenPositionByEnd(s, i)).sum() % 10 == 0;
    }

    private boolean isValidDigit(int c) {
        return Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) < 10;
    }

    private int doubleOnlyIfEvenPositionByEnd(String s, int i) {
        int v = Character.getNumericValue(s.charAt(s.length() - i));
        return isEvenPositionStartingByEnd(s, i) ? v : getDoubledSmallerThanTen(v);
    }

    private boolean isEvenPositionStartingByEnd(String s, int i) {
        return (s.length() - i) % 2 != s.length() % 2;
    }

    private int getDoubledSmallerThanTen(int v) {
        return v * 2 > 9 ? v * 2 - 9 : v * 2;
    }
}
