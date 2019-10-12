import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DiamondPrinter {

    List<String> printToList(char a) {

        return Stream.concat(IntStream.rangeClosed('A', a)
                        .mapToObj(s -> printRow(s, a)),
                IntStream.range('A', a)
                        .map(i -> a + ('A' - 1 - i)) // Reversing the stream
                        .mapToObj(s -> printRow(s, a)))
                .collect(Collectors.toList());
    }

    private String printRow(int letter, int lastLetter) {

        int length = 2 * (lastLetter - 'A') + 1;
        int order = letter - 'A';

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++)
            result.append(' ');

        result.setCharAt(length / 2 - order, (char) letter);
        result.setCharAt(length / 2 + order, (char) letter);
        return result.toString();
    }
}
