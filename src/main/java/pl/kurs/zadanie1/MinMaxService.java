package pl.kurs.zadanie1;

import java.util.Comparator;
import java.util.List;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        return elements != null ?
                new MinMax<>(elements.stream().min(Comparator.naturalOrder()).orElseThrow(),
                            elements.stream().max(Comparator.naturalOrder()).orElseThrow())
                : null;
    }

}
