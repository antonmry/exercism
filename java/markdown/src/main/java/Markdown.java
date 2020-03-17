import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Markdown {

    private Optional<String> endList = Optional.empty();

    public String parse(String markdown) {
        return Arrays.stream(markdown.split("\n")).map(line ->
                switch (line.substring(0, 1)) {
                    case "#" -> parseHeader(line);
                    case "*" -> parseListItem(line);
                    default -> parseParagraph(line);
                }
        ).collect(Collectors.joining()) + endList.orElse("");
    }

    private String parseHeader(String line) {
        return IntStream.range(1, line.length()).mapToObj(i -> {
            if (line.startsWith(generateHeaderChars(i))
                    && line.charAt(i) != '#') {
                return "<h" + i + ">" + line.substring(i + 1) + "</h" + i + ">";
            } else {
                return "";
            }
        }).collect(Collectors.joining());
    }

    private String generateHeaderChars(int i) {
        return IntStream.range(0, i).mapToObj(j -> "#").collect(Collectors.joining());
    }

    private String parseListItem(String line) {
        return endList.map(o -> {
            return "<li>" + parseBoldAndCursiveText(line.substring(2)) + "</li>";
        }).orElseGet(() -> {
            endList = Optional.of("</ul>");
            return "<ul><li>" + parseBoldAndCursiveText(line.substring(2)) + "</li>";
        });
    }

    private String parseParagraph(String line) {
        return endList.map(o -> {
            endList = Optional.empty();
            return "</ul><p>" + parseBoldAndCursiveText(line) + "</p>";
        }).orElse("<p>" + parseBoldAndCursiveText(line) + "</p>");
    }

    private String parseBoldAndCursiveText(String line) {
        return line.replaceAll("__(.+)__", "<strong>$1</strong>")
                .replaceAll("_(.+)_", "<em>$1</em>");
    }
}

