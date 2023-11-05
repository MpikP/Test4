package pl.kurs.zadanie4;

import java.util.List;
import java.util.function.Supplier;

public interface IPersonService {
    Person getTheOldestWoman(List<Person> personList) throws NoWomenException;
    double getAverageAgeOfPeople(List<Person> personList);
    double getAverageAgeOfMen(List<Person> personList);
    double getAverageAgeOfWomen(List<Person> personList) throws NoWomenException;
    double getAverageAgeOfGender(List<Person> personList, Supplier<Double> supplier);
    List<String> getCitiesWithTheMostPeople(List<Person> personList);
    List<String> getDistinctCities(List<Person> personList);


}
