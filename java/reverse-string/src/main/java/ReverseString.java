import java.util.stream.IntStream;

class ReverseString {

    String reverse(String inputString) {

        return IntStream.range(1 - inputString.length(), 1) // Inverse order
                .mapToObj(c -> String.valueOf(inputString.charAt(-c)))
                .reduce(String::concat)
                .orElse("");
    }

}