package pl.kurs.zadanie4;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PersonService implements IPersonService {

    @Override
    public Person getTheOldestWoman(List<Person> personList) throws NoWomenException {

        return Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(z -> z.getFirstName().matches(".*[a]$"))
                        .max(Comparator.comparing(Person::getAge))
                ))
                .orElseThrow(() -> new NoWomenException("Brak kobiet na liście."));
    }

    @Override
    public double getAverageAgeOfPeople(List<Person> personList) {

        return Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .orElseThrow(() -> new RuntimeException("Przekazano pustą listę osób."));

    }

    @Override
    public double getAverageAgeOfMen(List<Person> personList) {

        return Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(y -> !y.getFirstName().matches(".*[a]$"))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .orElseThrow(() -> new RuntimeException("Przekazano pustą listę osób."));

    }

    @Override
    public double getAverageAgeOfWomen(List<Person> personList) throws NoWomenException {

        return Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(y -> y.getFirstName().matches(".*[a]$"))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .orElseThrow(() -> new NoWomenException("Brak kobiet na liście."));

    }


    @Override
    public double getAverageAgeOfGender(List<Person> personList, Supplier<Double> supplier) {
        double averageAge;
        try {
            averageAge = supplier.get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Przekazano pustą listę osób.");
        }
        return averageAge;
    }


    @Override
    public List<String> getCitiesWithTheMostPeople(List<Person> personList) {
        List<String> citiesList;

        Map<String, Long> collect = Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .map(y -> y.getCity())
                        .collect(Collectors.groupingBy(y -> y, Collectors.counting())
                        )
                ));


        Long max = collect
                .values()
                .stream().max(Long::compareTo)
                .orElseThrow(() -> new RuntimeException("Przekazano pustą listę osób."));

        citiesList = collect
                .entrySet()
                .stream()
                .filter(x -> x.getValue().equals(max))
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        return citiesList;
    }

    @Override
    public List<String> getDistinctCities(List<Person> personList) {

        return Optional.ofNullable(personList)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen
                        (toList(), x -> x.stream()
                                .filter(y -> Objects.nonNull(y))
                                .map(Person::getCity)
                                .distinct().collect(toList())
                        ));
    }


}
