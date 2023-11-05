package pl.kurs.zadanie5;

import pl.kurs.zadanie2.InvlaidPeselException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthDateApp {
    public static void main(String[] args) throws InvlaidPeselException {

        Scanner scanner = new Scanner(System.in);
        LocalDate birthDate;
        BirthDateService bds = new BirthDateService();

        System.out.println("Podaj datę urodzenia: [yyyy-mm-dd]");
        String stringBirthDate = scanner.nextLine();
        birthDate = LocalDate.parse(stringBirthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if(!birthDate.isAfter(LocalDate.now())){
            System.out.println("Żyjesz już " + bds.countDaysOfLive(birthDate) + " dni.");
            System.out.println("Żyjesz już " + bds.countMonthsOfLive(birthDate) + " miesięcy.");
            System.out.println("Żyjesz już " + bds.countYearsOfLive(birthDate) + " lat.");
            System.out.println("Twoim dniem urodzenia jest " + bds.getWeekDayNameOfBirthDate(birthDate) + ".");
            System.out.println("Pierwszy piątek 13go wypadający po Twoich urodzinach to " + bds.getNextFriday13thAfterBirthday(birthDate) + ".");
        } else {
            throw new InvlaidPeselException("Podałeś złą datę urodzenia.");
        }


        scanner.close();

    }
}
