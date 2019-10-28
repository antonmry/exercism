import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NucleotideCounter {

    private String DNA;
    private Map<Character, Integer> nucleotideCounts;

    public NucleotideCounter(String DNA) {
        validateDNA(DNA);
        this.DNA = DNA;
    }

    public Map<Character, Integer> nucleotideCounts() {
        if (nucleotideCounts == null) {
            lazyCalculation();
        }
        return nucleotideCounts;
    }

    private void lazyCalculation() {
        nucleotideCounts = new HashMap<>();
        nucleotideCounts.put('A', 0);
        nucleotideCounts.put('C', 0);
        nucleotideCounts.put('G', 0);
        nucleotideCounts.put('T', 0);

        DNA.chars().forEach(this::incrementNucleotide);
    }

    private void incrementNucleotide(int nucleotide) {
        nucleotideCounts.put((char) nucleotide, nucleotideCounts.get((char) nucleotide) + 1);
    }

    private void validateDNA(String DNA) {
        if (!Pattern.matches("[A|C|G|T]*", DNA))
            throw new IllegalArgumentException("String to search may only contain valid nucleotides.");
    }


}
