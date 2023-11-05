package pl.kurs.zadanie4;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PersonService implements IPersonService {

    @Override
    public Person getTheOldestWoman(List<Person> personList) throws NoWomenException {
        if (personList != null) {
            Person oldestWoman = personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .filter(x -> x.getFirstName().matches(".*[a]$"))
                    .max(Comparator.comparing(Person::getAge))
                    .orElseThrow(() -> new NoWomenException("Brak kobiet na liście."));

            return oldestWoman;

        } else
            throw new RuntimeException("Przekazano pustą listę osób.");
    }

    @Override
    public double getAverageAgeOfPeople(List<Person> personList) {
        if (personList != null) {
            double averageAge = personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .mapToInt(x -> x.getAge())
                    .average()
                    .orElseThrow();

            return averageAge;

        } else
            throw new RuntimeException("Przekazano pustą listę osób.");

    }

    @Override
    public double getAverageAgeOfMen(List<Person> personList) {
        if (personList != null) {
            double averageAge = personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .filter(x -> !x.getFirstName().matches(".*[a]$"))
                    .mapToInt(x -> x.getAge())
                    .average()
                    .orElseThrow();

            return averageAge;

        } else
            throw new RuntimeException("Przekazano pustą listę osób.");
    }

    @Override
    public double getAverageAgeOfWomen(List<Person> personList) throws NoWomenException {
        if (personList != null) {
            double averageAge = personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .filter(x -> x.getFirstName().matches(".*[a]$"))
                    .mapToInt(x -> x.getAge())
                    .average()
                    .orElseThrow(() -> new NoWomenException("Brak kobiet na liście."));

            return averageAge;

        } else
            throw new RuntimeException("Przekazano pustą listę osób.");
    }


    @Override
    public double getAverageAgeOfGender(List<Person> personList, Supplier<Double> supplier) {
        double averageAge = 0;
        try {
            averageAge = supplier.get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Przekazano pustą listę osób.");
        }
        return averageAge;
    }


    @Override
    public List<String> getCitiesWithTheMostPeople(List<Person> personList) {
        List<String> citiesList = null;
        if (personList != null) {
            Map<String, Long> collect = personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .map(x -> x.getCity())
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

            Long max = collect
                    .values()
                    .stream().max(Long::compareTo)
                    .orElseThrow();

            citiesList = collect
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() == max)
                    .map(x -> x.getKey())
                    .collect(Collectors.toList());
        }
        return citiesList;
    }

    @Override
    public List<String> getDistinctCities(List<Person> personList) {
        List<String> distinctCities = new ArrayList<>();
        if (personList != null) {
            personList.stream()
                    .filter(x -> Objects.nonNull(x))
                    .map(x -> x.getCity())
                    .distinct()
                    .forEach(x -> distinctCities.add(x.toString()));
        } else
            throw new RuntimeException("Przekazano pustą listę osób.");
        return distinctCities;
    }


}
