package pl.kurs.zadanie4;

import java.util.ArrayList;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) throws NoWomenException {

        Person p1 = new Person("Anna", "Nowak", "Warszawa", 20);
        Person p2 = new Person("Maria", "Nowakowska", "Krakow", 22);
        Person p3 = new Person("Piotr", "Nowak", "Warszawa", 30);
        Person p4 = new Person("Marek", "Kowal", "Gdansk", 18);
        Person p5 = new Person("Ewa", "Kowalska", "Gdansk", 42);
        Person p6 = new Person("Magda", "Sas", "Radom", 38);
        Person p7 = new Person("Roman", "Rosol", "Kielce", 22);
        Person p8 = new Person("Stefan", "Kowalski", "Kielce", 35);
        Person p9 = new Person("Anna", "Maj", "Zakopane", 55);

        PersonService personService = new PersonService();

        List<Person> personList = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9);

        System.out.println("----------------getTheOldestWoman-------------------");
        System.out.println(personService.getTheOldestWoman(personList));

        System.out.println("----------------getAverageAgeOfPeople-------------------");
        System.out.println(personService.getAverageAgeOfPeople(personList));


        System.out.println("----------------getAverageAgeOfMen-------------------");
        System.out.println(personService.getAverageAgeOfMen(personList));

        System.out.println("----------------getAverageAgeOfWomen-------------------");
        System.out.println(personService.getAverageAgeOfWomen(personList));



        System.out.println("----------------getAverageAgeOfGender-------------------");
        System.out.println(personService.getAverageAgeOfGender(personList, () -> personService.getAverageAgeOfMen(personList)));
        System.out.println(personService.getAverageAgeOfGender(personList, () -> personService.getAverageAgeOfMen(new ArrayList<>())));


        System.out.println("----------------getDistinctCities-------------------");
        System.out.println(personService.getDistinctCities(personList));

        System.out.println("----------------getCityWithTheMostPeople-------------------");
        System.out.println(personService.getCitiesWithTheMostPeople(personList));


    }
}
