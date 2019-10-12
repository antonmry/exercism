import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        validateStrands(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {
        return (int) IntStream.range(0, leftStrand.length()).filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i)).count();
    }

    private void validateStrands(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) return;
        if (isEmptyOrNull(leftStrand)) throw new IllegalArgumentException("left strand must not be empty.");
        if (isEmptyOrNull(rightStrand)) throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    private boolean isEmptyOrNull(String s) {
        return ((s == null) || (s.isEmpty()));
    }

}
