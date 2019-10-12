public class BeerSong {

    private final static String PHRASE_1 = "%d bottle%s of beer on the wall, %d bottle%s of beer."
            + System.getProperty("line.separator");
    private final static String PHRASE_2 = "Take %s down and pass it around, %d bottle%s of beer on the wall."
            + System.getProperty("line.separator") + System.getProperty("line.separator");
    private final static String PHRASE_ONE_BOTTLE = "Take it down and pass it around, no more bottles of beer on the wall."
            + System.getProperty("line.separator") + System.getProperty("line.separator");
    private final static String PHRASE_ZERO_BOTTLE_1 = "No more bottles of beer on the wall, no more bottles of beer."
            + System.getProperty("line.separator");
    private final static String PHRASE_ZERO_BOTTLE_2 = "Go to the store and buy some more, 99 bottles of beer on the wall."
            + System.getProperty("line.separator") + System.getProperty("line.separator");

    public String sing(int bottles, int verses) {
        StringBuilder sb = new StringBuilder();

        // This is a signal to end recursion
        if (verses == 0) {
            return "";
        }

        if (bottles == 0) {
            // Last two sentences of the song aren't reusable
            return sb.append(PHRASE_ZERO_BOTTLE_1).append(PHRASE_ZERO_BOTTLE_2).toString();
        }

        // Note: after this, we'll invoke again sing method in the return statements: recursion to build the song

        if (bottles == 1) {
            // Take care of singular and no more bottles
            sb.append(String.format(PHRASE_1, bottles, "", bottles, ""));
            return sb.append(PHRASE_ONE_BOTTLE).append(sing(bottles - 1, verses - 1)).toString();
        }

        sb.append(String.format(PHRASE_1, bottles, "s", bottles, "s"));

        if (bottles == 2) {
            // Take care of singular in the second phrase
            return sb.append(String.format(PHRASE_2, "one", bottles - 1, ""))
                    .append(sing(bottles - 1, verses - 1)).toString();
        }

        return sb.append(String.format(PHRASE_2, "one", bottles - 1, "s"))
                .append(sing(bottles - 1, verses - 1)).toString();

    }

    public String singSong() {
        return sing(99, 100);
    }
}
