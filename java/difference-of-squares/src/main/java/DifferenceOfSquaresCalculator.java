import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {

        return IntStream.rangeClosed(1, input).sum() * IntStream.rangeClosed(1, input).sum();
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).map(v -> v*v).sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
