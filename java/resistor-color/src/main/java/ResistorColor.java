import java.util.Arrays;

enum Colors {
    black,
    brown,
    red,
    orange,
    yellow,
    green,
    blue,
    violet,
    grey,
    white;
}

class ResistorColor {
    int colorCode(String color) {
        return Colors.valueOf(color).ordinal();
    }

    String[] colors() {
        return Arrays.stream(Colors.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}

/*
    // This is a better solution, but boring :-)

    private String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        return Arrays.asList(colors).indexOf(color);
    }

    String[] colors() {
        return colors;
    }
*/
