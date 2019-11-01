import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Series {

    private String input;

    public Series(String input) {
        this.input = input;
    }

    public List<String> slices(int slice) {
        validate(slice);

        return IntStream.range(0, input.length() - slice + 1)
                .mapToObj(i -> input.substring(i, i + slice))
                .collect(Collectors.toList());
    }

    private void validate(int slice) {
        if (slice < 1)
            throw new IllegalArgumentException("Slice size is too small.");
        if (slice > input.length())
            throw new IllegalArgumentException("Slice size is too big.");
    }
}
