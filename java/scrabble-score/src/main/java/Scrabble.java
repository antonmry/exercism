class Scrabble {

    private int score;

    Scrabble(String word) {
        this.score = calculateScore(word);
    }

    public int getScore() {
        return score;
    }

    private int calculateScore(String word) {
        return word.toUpperCase().chars().map(this::getScore).sum();
    }

    private int getScore(int c) {
        return switch ((char) c) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> throw new UnsupportedOperationException();
        };
    }
}

