package pl.kurs.zadanie2;

import java.time.LocalDate;
import java.util.Scanner;

public class PeselApp {

    public static void main(String[] args) throws InvlaidPeselException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imię:");
            String firstName = scanner.nextLine();
            if(firstName != null)
                System.out.println("Długość podanego imienia wynosi " + firstName.length());
            else
                System.out.println("Długość podanego imienia wynosi 0");

            System.out.println("Podaj swój PESEL:");
            String pesel = scanner.nextLine();
            LocalDate birthDate = null;
            if (pesel != null && pesel != "" && pesel.length()==11) {
                birthDate = getBirthDate(pesel);
                System.out.println("Twoja data urodenia to " + birthDate);
            }
            else
                throw new InvlaidPeselException("Podano błędny PESEL.");

        scanner.close();

    }



    public static LocalDate getBirthDate(String pesel){
        String[] peselSplit = pesel.split("(?!^)");
        return LocalDate.of(getYearOfBirth(peselSplit), getMonthOfBirth(peselSplit), getDayOfBirth(peselSplit));
    }
    public static int getDayOfBirth(String[] peselSplit){
        return Integer.parseInt(peselSplit[4] + peselSplit[5]);
    }
    public static int getMonthOfBirth(String[] peselSplit){
        int monthInt = Integer.parseInt(peselSplit[2] + peselSplit[3]);
        if(monthInt > 80)
            monthInt =- 80;
        if(monthInt > 60)
            monthInt =- 60;
        if(monthInt > 40)
            monthInt =- 40;
        if(monthInt > 20)
            monthInt =- 20;
        return monthInt;
    }
    public static int getYearOfBirth(String[] peselSplit){
        int monthInt = Integer.parseInt(peselSplit[2] + peselSplit[3]);
        int yearInt = Integer.parseInt(peselSplit[0] + peselSplit[1]);

        if(monthInt > 80)
            yearInt += 1800;
        if(monthInt > 60)
            yearInt += 2200;
        if(monthInt > 40)
            yearInt += 2100;
        if(monthInt > 20)
            yearInt += 2000;
        else
            yearInt += 1900;

        return yearInt;
    }
}