import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    private static final String[] ROMAN_NUMBERS = new String[]{"I", "V", "X", "L",
            "C", "D", "M"};

    private final List<Integer> number;

    public RomanNumeral(int number) {
        this.number = String.valueOf(number).chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public String getRomanNumeral() {
        return IntStream.range(0, number.size())
                .mapToObj(i -> translate(number.get(i),
                        2 * (number.size() - i - 1)))
                .reduce(String::concat)
                .orElse("");
    }

    private String translate(int number, int position) {
        switch (number) {
            case 0:
                return "";
            case 1:
                return ROMAN_NUMBERS[position];
            case 2:
                return ROMAN_NUMBERS[position] + ROMAN_NUMBERS[position];
            case 3:
                return ROMAN_NUMBERS[position] + ROMAN_NUMBERS[position]
                        + ROMAN_NUMBERS[position];
            case 4:
                return ROMAN_NUMBERS[position] + ROMAN_NUMBERS[position + 1];
            case 5:
                return ROMAN_NUMBERS[position + 1];
            case 6:
                return ROMAN_NUMBERS[position + 1] + ROMAN_NUMBERS[position];
            case 7:
                return ROMAN_NUMBERS[position + 1] + ROMAN_NUMBERS[position]
                        + ROMAN_NUMBERS[position];
            case 8:
                return ROMAN_NUMBERS[position + 1] + ROMAN_NUMBERS[position]
                        + ROMAN_NUMBERS[position] + ROMAN_NUMBERS[position];
            case 9:
                return ROMAN_NUMBERS[position] + ROMAN_NUMBERS[position + 2];
            default:
                throw new UnsupportedOperationException();
        }
    }
}
