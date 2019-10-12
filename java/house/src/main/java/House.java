public class House {

    private static final String[] NAMES = {"house that Jack built", "malt", "rat", "cat", "dog",
            "cow with the crumpled horn", "maiden all forlorn", "man all tattered and torn",
            "priest all shaven and shorn", "rooster that crowed in the morn", "farmer sowing his corn",
            "horse and the hound and the horn"};

    private static final String[] VERBS = {"lay in", "ate", "killed", "worried", "tossed", "milked", "kissed",
            "married", "woke", "kept", "belonged to"};

    public String verse(int verse) {

        StringBuilder sb = new StringBuilder();

        sb.append("This is the ").append(NAMES[verse - 1]);

        for (int i = verse - 1; i > 0; i--) {
            sb.append(" that ").append(VERBS[i - 1]).append(" the ").append(NAMES[i - 1]);
        }

        return sb.append(".").toString();
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();

        for (int i = startVerse; i < endVerse; i++) {
            sb.append(verse(i)).append(System.getProperty("line.separator"));
        }

        return sb.append(verse(endVerse)).toString();
    }

    public String sing() {
        return verses(1, NAMES.length);
    }
}
