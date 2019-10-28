import java.util.regex.Pattern;

class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {

        if (Pattern.matches(".*[a-zA-Z]+.*", number))
            throw new IllegalArgumentException("letters not permitted");

        if (Pattern.matches(".*[:punct:]+.*", number))
            throw new IllegalArgumentException("punctuations not permitted");

        this.number = number.replaceAll("\\D+", "");

        if (this.number.length() == 11 ) {
            if (this.number.startsWith("1")) {
                // Valid number, we skip it
                this.number = this.number.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }

        if (this.number.length() > 10) throw new IllegalArgumentException("more than 11 digits");
        if (this.number.length() < 10) throw new IllegalArgumentException("incorrect number of digits");

        if (this.number.charAt(0) == '0')
            throw new IllegalArgumentException("area code cannot start with zero");

        if (this.number.charAt(0) == '1')
            throw new IllegalArgumentException("area code cannot start with one");

        if (this.number.charAt(3) == '0')
            throw new IllegalArgumentException("exchange code cannot start with zero");

        if (this.number.charAt(3) == '1')
            throw new IllegalArgumentException("exchange code cannot start with one");
    }

    public String getNumber() {
        return number;
    }

}