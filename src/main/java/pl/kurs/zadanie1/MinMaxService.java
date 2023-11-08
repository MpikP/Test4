package pl.kurs.zadanie1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {

        Optional<T> min = Optional.ofNullable(elements)
                .orElse(null)
                .stream()
                .filter(y -> Objects.nonNull(y))
                .min(Comparator.naturalOrder());


        Optional<T> max = Optional.ofNullable(elements)
                .orElse(null)
                .stream()
                .filter(y -> Objects.nonNull(y))
                .max(Comparator.naturalOrder());


        return new MinMax<>(min.orElse(null), max.orElse(null));

    }


}
