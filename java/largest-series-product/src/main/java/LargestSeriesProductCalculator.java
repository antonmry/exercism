import java.util.regex.Pattern;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        validateConstructorArgs(inputNumber);
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        validateCalculateArgs(numberOfDigits);
        return IntStream.range(0, inputNumber.length() - numberOfDigits + 1)
                .mapToLong(i -> calculateProduct(i, numberOfDigits))
                .max()
                .getAsLong();
    }

    private long calculateProduct(int index, int numberOfDigits) {
        return inputNumber.substring(index, index + numberOfDigits)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);
    }

    private void validateConstructorArgs(String inputNumber) {
        if (!Pattern.matches("\\d+", inputNumber) && !inputNumber.isEmpty())
            throw new IllegalArgumentException("String to search may only contain digits.");
    }

    private void validateCalculateArgs(int numberOfDigits) {
        if (inputNumber.length() < numberOfDigits)
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");
    }


}
