import java.util.stream.IntStream;

class IsbnVerifier {

    public static final int ISBN_LENGTH = 10;

    boolean isValid(final String s) {

        String isbn = s.replace("-", "");

        return isbn.length() == ISBN_LENGTH &&
                IntStream.rangeClosed(0, ISBN_LENGTH - 2).
                        filter(c -> isValidDigit(isbn.charAt(c)))
                        .count() == 9 &&
                (isValidDigit(isbn.charAt(ISBN_LENGTH - 1)) ||
                        isbn.charAt(ISBN_LENGTH - 1) == 'X') &&
                IntStream.rangeClosed(0, ISBN_LENGTH - 1)
                        .map(i -> (ISBN_LENGTH - i) * calculateNumber(isbn.charAt(i)))
                        .sum() % 11 == 0;
    }

    private static boolean isValidDigit(char c) {
        return Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) < 10;
    }

    private int calculateNumber(char c) {
        return (c == 'X') ? 10 : Character.getNumericValue(c);
    }

}
