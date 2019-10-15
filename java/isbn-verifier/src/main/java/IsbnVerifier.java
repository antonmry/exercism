import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String isbn = stringToVerify.replace("-", "");

        return isbn.length() == 10 &&
                IntStream.rangeClosed(0, 8).filter(c -> isValidDigit(isbn.charAt(c))).count() == 9 &&
                (isValidDigit(isbn.charAt(9)) || isbn.charAt(9) == 'X') &&
                IntStream.rangeClosed(0, 9).map(i -> (10 - i) * calculateNumber(isbn.charAt(i))).sum() % 11 == 0;
    }

    private static boolean isValidDigit(char c) {
        return (Character.getNumericValue(c) >= 0) && (Character.getNumericValue(c) < 10);
    }

    private int calculateNumber(char c) {
        if (c == 'X') return 10;
        return Character.getNumericValue(c);
    }

}
