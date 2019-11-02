import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Allergies {

    private final int allergies;

    public Allergies(int allergies) {
        this.allergies = allergies;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (allergen.getScore() & allergies) > 0;
    }

    public List<Allergen> getList() {
        return EnumSet.allOf(Allergen.class).stream()
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }
}
