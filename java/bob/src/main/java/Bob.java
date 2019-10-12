public class Bob {

    public String hey(String phrase) {
        String s = phrase.trim();

        if (s.isEmpty()) return "Fine. Be that way!";

        boolean isQuestion = s.endsWith("?");
        boolean isYelling = s.toUpperCase().equals(s) && !s.toLowerCase().equals(s);

        if (isYelling && isQuestion) return "Calm down, I know what I'm doing!";
        if (isQuestion) return "Sure.";
        if (isYelling) return "Whoa, chill out!";
        return "Whatever.";
    }
}
