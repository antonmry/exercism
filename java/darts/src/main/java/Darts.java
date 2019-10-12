class Darts {

    private double x;
    private double y;
    private int score = -1;

    public Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double calculateDistance(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    private int calculateScore(double x, double y) {
        double d = calculateDistance(x, y);

        if (d <= 1) return 10;
        if (d <= 5) return 5;
        if (d <= 10) return 1;
        return 0;
    }

    int score() {
        if (score < 0) {
            // Lazy initialization
            score = calculateScore(x, y);
        }
        return score;
    }

}
