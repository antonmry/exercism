import java.math.BigInteger;

class Grains {

    BigInteger computeNumberOfGrainsOnSquare(final int square) {
        if ((square < 1) || (square > 64)) throw new IllegalArgumentException("square must be between 1 and 64");
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger totalRecursive(final int square) {
        if (square == 1) {
            return BigInteger.valueOf(2).pow(square - 1);
        }

        return BigInteger.valueOf(2).pow(square - 1).add(totalRecursive(square - 1));
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {
        return totalRecursive(64);
    }

}
