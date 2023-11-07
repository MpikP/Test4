package pl.kurs.zadanie1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {

        Optional.ofNullable(elements).orElseThrow(() -> new RuntimeException("Przekazano pustą listę."));

        Optional<T> min = Optional.ofNullable(elements.stream()
                                                        .collect(Collectors.collectingAndThen(toList(), (x -> x.stream()
                                                                .filter(y -> Objects.nonNull(y))
                                                                .min(Comparator.naturalOrder()))))
                                                        .orElseThrow(() -> new RuntimeException("Przekazano listę z pustymi elementami.")));


        Optional<T> max = elements.stream()
                                    .collect(Collectors.collectingAndThen(toList(), (x -> x.stream()
                                            .filter(y -> Objects.nonNull(y))
                                            .max(Comparator.naturalOrder()))));



        return new MinMax<>(min.get(), max.get());
//        return new MinMax<>(elements.stream().filter(y -> Objects.nonNull(y)).min(Comparator.naturalOrder()).orElseThrow(),
//                elements.stream().filter(y -> Objects.nonNull(y)).max(Comparator.naturalOrder()).orElseThrow());

    }


}
