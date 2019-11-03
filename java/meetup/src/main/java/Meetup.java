import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;


public class Meetup {
    private final int year;
    private final int month;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek day, MeetupSchedule schedule) {
        LocalDate ld = LocalDate.now().withYear(year).withMonth(month);
        return switch (schedule) {
            case FIRST -> ld.with(firstInMonth(day));
            case SECOND -> ld.with(firstInMonth(day)).with(next(day));
            case THIRD -> ld.with(firstInMonth(day)).with(next(day)).with(next(day));
            case FOURTH -> ld.with(firstInMonth(day)).with(next(day)).with(next(day)).with(next(day));
            case LAST -> ld.with(lastInMonth(day));
            case TEENTH -> calculateTeenth(day, ld);
            default -> throw new UnsupportedOperationException();
        };
    }

    private LocalDate calculateTeenth(DayOfWeek day, LocalDate ld) {
        int d = ld.with(firstInMonth(day)).with(next(day)).with(next(day)).getDayOfMonth();
        if (d > 9 && d < 20)
            return ld.with(firstInMonth(day)).with(next(day)).with(next(day));
        else
            return ld.with(firstInMonth(day)).with(next(day));
    }
}
