import java.util.Objects;
import java.util.function.BiPredicate;

public class QueenAttackCalculator {
    private final Queen queen1;
    private final Queen queen2;

    private final BiPredicate<Queen, Queen> isSameRow = (queen1, queen2) -> queen1.getX() == queen2.getX();
    private final BiPredicate<Queen, Queen> isSameColumn = (queen1, queen2) -> queen1.getY() == queen2.getY();
    private final BiPredicate<Queen, Queen> isDiagonal = (queen1, queen2) -> Math.abs(queen1.getX() - queen2.getX()) - Math.abs(queen1.getY() - queen2.getY()) == 0;

    public QueenAttackCalculator(Queen queen1, Queen queen2) {
        validateQueenAttackCalculator(queen1, queen2);

        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    public boolean canQueensAttackOneAnother() {
        return isSameRow.or(isSameColumn).or(isDiagonal).test(queen1, queen2);
    }

    private void validateQueenAttackCalculator(Queen queen1, Queen queen2) {
        if ((queen1 == null) || (queen2 == null))
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");

        if (queen1.equals(queen2)) throw new IllegalArgumentException("Queens cannot occupy the same position.");
    }

}

class Queen {
    private final int x;
    private final int y;

    public Queen(int x, int y) {
        validateQueen(x, y);

        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void validateQueen(int x, int y) {
        if (x < 0) throw new IllegalArgumentException("Queen position must have positive row.");

        if (x > 7) throw new IllegalArgumentException("Queen position must have row <= 7.");

        if (y < 0) throw new IllegalArgumentException("Queen position must have positive column.");

        if (y > 7) throw new IllegalArgumentException("Queen position must have column <= 7.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return x == queen.x &&
                y == queen.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
