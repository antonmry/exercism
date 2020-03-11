import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BowlingGame {

    private List<Integer> scores = new ArrayList<>();
    private boolean negativeRoll = false;
    private boolean excesivePins = false;

    public void roll(int pins) {
        validateRoll(pins);

        scores.add(pins);
        if (scores.size() % 2 == 1 && pins == 10 && scores.size() < 19) scores.add(-1);
    }

    public int score() {
        validateScores();

        return (int) IntStream.range(0, scores.size())
                .mapToLong(i -> calculateSpare(i) * calculateStrike(i) * scores.get(i))
                .sum();
    }

    private void validateRoll(int pins) {
        if (pins < 0) negativeRoll = true;
        if (pins > 10) excesivePins = true;
    }

    private void validateScores() {
        if (scores.size() > 21)
            throw new IllegalStateException("Cannot roll after game is over");
        if (negativeRoll) throw new IllegalStateException("Negative roll is invalid");
        if (excesivePins) throw new IllegalStateException("Pin count exceeds pins on the lane");

        for (int i = 0; i < scores.size() - 1; i += 2) {
            if ((scores.get(i) + scores.get(i + 1) > 10) && (scores.get(18) != 10))
                throw new IllegalStateException("Pin count exceeds pins on the lane");
        }

        if (scores.size() == 21 && ((scores.get(18) != 10) || scores.get(19) + scores.get(18) == 10))
            throw new IllegalStateException("Cannot roll after game is over");
        if (scores.size() < 20 || (scores.size() == 20 && scores.get(19) == 10) ||
                (scores.size() == 20 && (scores.get(18) + scores.get(19) == 10)))
            throw new IllegalStateException("Score cannot be taken until the end of the game");

    }

    private int calculateSpare(int i) {
        if ((i % 2 == 1) || (i < 2) || i == 20 || scores.get(i - 1) == 10 || scores.get(i - 2) == 10) return 1;
        if (scores.get(i - 1) + scores.get(i - 2) == 10) return 2;
        return 1;
    }

    private int calculateStrike(int i) {
        // Special case: it's a strike so we ignore the even value
        if (scores.get(i) == -1) return 0;

        if (i > 19) return 1;
        int strikes = 1;

        if (i % 2 == 0) {
            if (i > 1 && scores.get(i - 2) == 10) strikes++;
            if (i > 3 && scores.get(i - 4) == 10) strikes++;
        } else {
            if (i > 2 && scores.get(i - 3) == 10) strikes++;
        }

        return strikes;
    }


}
