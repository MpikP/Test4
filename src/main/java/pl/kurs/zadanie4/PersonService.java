package pl.kurs.zadanie4;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PersonService implements IPersonService {

    @Override
    public Person getTheOldestWoman(List<Person> personList) throws NoWomenException {
        return Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(z -> z.getFirstName().matches(".*[a]$"))
                        .max(Comparator.comparing(Person::getAge))
                ))
                .orElseThrow(() -> new NoWomenException("Brak kobiet na liście."));


    }

    @Override
    public Double getAverageAgeOfPeople(List<Person> personList) {

        return Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .getAsDouble();

    }

    @Override
    public Double getAverageAgeOfMen(List<Person> personList) {

        return Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(y -> !y.getFirstName().matches(".*[a]$"))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .getAsDouble();

    }

    @Override
    public Double getAverageAgeOfWomen(List<Person> personList) throws NoWomenException {

        return Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .filter(y -> y.getFirstName().matches(".*[a]$"))
                        .mapToInt(y -> y.getAge())
                        .average()
                ))
                .getAsDouble();

    }


    @Override
    public Double getAverageAgeOfGender(List<Person> personList, Supplier<Double> supplier) {
        double averageAge;
        try {
            averageAge = supplier.get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Przekazano pustą listę osób.");
        }
        return averageAge;
    }


    @Override
    public String getCityWithTheMostPeople(List<Person> personList) {


        Optional<Map.Entry<String, Long>> city = Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), x -> x.stream()
                        .filter(y -> Objects.nonNull(y))
                        .map(y -> y.getCity())
                        .collect(Collectors.groupingBy(y -> y, Collectors.counting())
                        )
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                ));

        return city.map(x -> x.getKey()).orElse(null);
    }

    @Override
    public List<String> getDistinctCities(List<Person> personList) {

        return Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen
                        (toList(), x -> x.stream()
                                .filter(y -> Objects.nonNull(y))
                                .map(Person::getCity)
                                .distinct().collect(toList())
                        ));
    }


}
