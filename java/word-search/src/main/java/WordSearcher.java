import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordSearcher {
    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] chars) {

        // Java doesn't provide tuples so AbstractMap.SimpleEntry is used instead.
        return searchWords.stream()
                .map(s -> new AbstractMap.SimpleEntry<String, Optional<WordLocation>>(s, getWordLocation(s, chars)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }

    private Optional<WordLocation> getWordLocation(String word, char[][] chars) {
        return Stream.concat(Stream.concat(Stream.concat(Stream.concat(Stream.concat(Stream.concat(Stream.concat(
                searchHorizontal(word, chars),
                reverseSearchHorizontal(word, chars)),
                searchVertical(word, chars)),
                reverseSearchVertical(word, chars)),
                searchDiagonal(word, chars)),
                reverseSearchDiagonal(word, chars)),
                searchInvertedDiagonal(word, chars)),
                reverseSearchInvertedDiagonal(word, chars)
        ).findFirst();
    }

    private Stream<WordLocation> searchHorizontal(String word, char[][] chars) {
        return IntStream.range(0, chars.length)
                .mapToObj(y -> new AbstractMap.SimpleEntry<Integer, String>(y, new String(chars[y])))
                .map(s -> {
                    int startX = s.getValue().indexOf(word);
                    if (startX >= 0) {
                        return new WordLocation(
                                new Pair(startX + 1, s.getKey() + 1),
                                new Pair(startX + word.length(), s.getKey() + 1)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> reverseSearchHorizontal(String word, char[][] chars) {
        String reverseWord = new StringBuilder(word).reverse().toString();

        return IntStream.range(0, chars.length)
                .mapToObj(y -> new AbstractMap.SimpleEntry<Integer, String>(y, new String(chars[y])))
                .map(s -> {
                    int startX = s.getValue().indexOf(reverseWord);
                    if (startX >= 0) {
                        return new WordLocation(
                                new Pair(reverseWord.length() - startX, s.getKey() + 1),
                                new Pair(startX + 1, s.getKey() + 1)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> searchVertical(String word, char[][] chars) {

        return IntStream.range(0, chars.length)
                .mapToObj(y -> new AbstractMap.SimpleEntry<Integer, String>(
                        y,
                        Arrays.stream(chars)
                                .map(c -> c[y])
                                .map(Object::toString)
                                .collect(Collectors.joining()))
                )
                .map(s -> {
                    int startX = s.getValue().indexOf(word);
                    if (startX >= 0) {
                        return new WordLocation(
                                new Pair(s.getKey() + 1, startX + 1),
                                new Pair(startX + word.length(), s.getKey() + 1)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);

    }

    private Stream<WordLocation> reverseSearchVertical(String word, char[][] chars) {

        String reverseWord = new StringBuilder(word).reverse().toString();

        return IntStream.range(0, chars.length)
                .mapToObj(y -> new AbstractMap.SimpleEntry<Integer, String>(
                        y,
                        Arrays.stream(chars)
                                .map(c -> c[y])
                                .map(Object::toString)
                                .collect(Collectors.joining()))
                )
                .map(s -> {
                    int startX = s.getValue().indexOf(reverseWord);
                    if (startX >= 0) {
                        return new WordLocation(
                                new Pair(s.getKey() + 1, startX + reverseWord.length()),
                                new Pair(s.getKey() + 1, startX + 1)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> searchDiagonal(String word, char[][] chars) {

        return generateDiagonalWords(chars).stream()
                .map(s -> {
                    int start = s.getDiagonal().indexOf(word);
                    if (start >= 0) {
                        return new WordLocation(
                                new Pair(s.getX() + start + 1, s.getY() + start + 1),
                                new Pair(s.getX() + start + word.length(),
                                        s.getY() + start + word.length())
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> reverseSearchDiagonal(String word, char[][] chars) {

        String reverseWord = new StringBuilder(word).reverse().toString();

        return generateDiagonalWords(chars).stream()
                .map(s -> {
                    int start = s.getDiagonal().indexOf(reverseWord);
                    if (start >= 0) {
                        return new WordLocation(
                                new Pair(s.getY() + start + reverseWord.length(), s.getX() + start + reverseWord.length()),
                                new Pair(s.getY() + start + 1, s.getX() + start + 1)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> searchInvertedDiagonal(String word, char[][] chars) {

        return generateInvertedDiagonalWords(chars).stream()
                .map(s -> {
                    int start = s.getDiagonal().indexOf(word);
                    if (start >= 0) {
                        return new WordLocation(
                                new Pair(s.getX() + start + 1, s.getY() - start + 1),
                                new Pair(s.getX() + start + word.length(),
                                        s.getY() - start - word.length() + 2)
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private Stream<WordLocation> reverseSearchInvertedDiagonal(String word, char[][] chars) {
        String reverseWord = new StringBuilder(word).reverse().toString();

        return generateInvertedDiagonalWords(chars).stream()
                .map(s -> {
                    int start = s.getDiagonal().indexOf(reverseWord);
                    if (start >= 0) {
                        return new WordLocation(
                                new Pair(s.getX() - (s.getDiagonal().length() - start - reverseWord.length()) + 1,
                                        s.getY() + (s.getDiagonal().length() - start - reverseWord.length()) + 1),
                                new Pair(s.getX() - (s.getDiagonal().length() - start) + 2,
                                        s.getY() + (s.getDiagonal().length() - start))
                        );
                    }
                    return null;
                })
                .filter(wl -> wl != null);
    }

    private ArrayList<DiagonalWords> generateDiagonalWords(char[][] chars) {
        ArrayList<DiagonalWords> charsDiagonal = new ArrayList<>();
        int l = chars.length;

        for (int x = 0; x < l; x++) {
            String temp = "";
            for (int i = 0; i < l - x; i++) {
                temp = temp + chars[x + i][i];
            }
            charsDiagonal.add(new DiagonalWords(x, 0, temp));
        }

        for (int y = 1; y < l; y++) {
            String temp = "";
            for (int i = 0; i < l - y; i++) {
                temp = temp + chars[i][y + i];
            }
            charsDiagonal.add(new DiagonalWords(l, y, temp));
        }

        return charsDiagonal;
    }

    private ArrayList<DiagonalWords> generateInvertedDiagonalWords(char[][] chars) {
        ArrayList<DiagonalWords> charsDiagonal = new ArrayList<>();
        int l = chars.length;

        for (int x = 0; x < l; x++) {
            String temp = "";
            for (int i = 0; i < x + 1; i++) {
                temp = temp + chars[x - i][i];
            }
            charsDiagonal.add(new DiagonalWords(0, x, temp));
        }

        for (int x = 1; x < l; x++) {
            String temp = "";
            for (int i = 0; i < l - x; i++) {
                temp = temp + chars[l - 1 - i][x + i];
            }
            charsDiagonal.add(new DiagonalWords(l - 1, x, temp));
        }
        return charsDiagonal;
    }
}

class DiagonalWords {
    private int x;
    private int y;
    private String diagonal;

    public DiagonalWords(int x, int y, String diagonal) {
        this.x = x;
        this.y = y;
        this.diagonal = diagonal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDiagonal() {
        return diagonal;
    }
}
