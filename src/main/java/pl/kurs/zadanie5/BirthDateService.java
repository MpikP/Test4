package pl.kurs.zadanie5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class BirthDateService implements IBirthDateService{
    @Override
    public long countDaysOfLive(LocalDate birthDate) {
        return birthDate.until(LocalDate.now(), DAYS);
    }

    @Override
    public long countMonthsOfLive(LocalDate birthDate) {
        return birthDate.until(LocalDate.now(), MONTHS);
    }

    @Override
    public int countYearsOfLive(LocalDate birthDate) {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public DayOfWeek getWeekDayNameOfBirthDate(LocalDate birthDate) {
        return birthDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextFriday13thAfterBirthday(LocalDate birthDate) {
        LocalDate nextFriday = null;
        int year = birthDate.getYear();
        int month = birthDate.getMonthValue();
        if(birthDate.getDayOfMonth() >= 13)
            month++;
        while (nextFriday == null){
            while (nextFriday == null && month <= 12){
                if(LocalDate.of(year, month, 13).getDayOfWeek().equals(DayOfWeek.FRIDAY))
                    nextFriday = LocalDate.of(year, month, 13);
                month++;
            }
            month = 1;
            year++;
        }
        return nextFriday;
    }
}
