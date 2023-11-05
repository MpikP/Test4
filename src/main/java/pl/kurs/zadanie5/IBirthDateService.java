package pl.kurs.zadanie5;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface IBirthDateService {
    long countDaysOfLive(LocalDate birthDate);
    long countMonthsOfLive(LocalDate birthDate);
    int countYearsOfLive(LocalDate birthDate);
    DayOfWeek getWeekDayNameOfBirthDate(LocalDate birthDate);
    LocalDate getNextFriday13thAfterBirthday(LocalDate birthDate);
}
