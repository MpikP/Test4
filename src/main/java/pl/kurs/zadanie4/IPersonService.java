package pl.kurs.zadanie4;

import java.util.List;
import java.util.function.Supplier;

public interface IPersonService {
    Person getTheOldestWoman(List<Person> personList) throws NoWomenException;
    Double getAverageAgeOfPeople(List<Person> personList);
    Double getAverageAgeOfMen(List<Person> personList);
    Double getAverageAgeOfWomen(List<Person> personList) throws NoWomenException;
    Double getAverageAgeOfGender(List<Person> personList, Supplier<Double> supplier);
    String getCityWithTheMostPeople(List<Person> personList);
    List<String> getDistinctCities(List<Person> personList);


}
