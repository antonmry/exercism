import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime future;

    private final static long GIGASECOND_TO_SECONDS = 1_000_000_000L;

    Gigasecond(LocalDateTime moment) {
        this.future = moment.plusSeconds(GIGASECOND_TO_SECONDS);
    }

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    LocalDateTime getDateTime() {
        return future;
    }
}
