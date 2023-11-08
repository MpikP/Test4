package pl.kurs.zadanie3;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamRunner {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(null);
        integers.add(null);
        integers.add(4);
        System.out.println(get5largestElements(List.of(1, 75, 2, 69, 58, 41, 2, 33, 15)));
        System.out.println(get5largestElements(List.of(1, 75, 2)));
        System.out.println(get5largestElements(integers));
        System.out.println(get5largestElements(null));
        System.out.println(get5largestElements(new ArrayList<>()));

    }

    public static List<Integer> get5largestElements(List<Integer> integers) {

        return Optional.ofNullable(integers)
                .filter(list -> list.stream().filter(x -> Objects.nonNull(x)).count() >= 5)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.collectingAndThen(toList(), (list2 -> list2.stream()
                        .filter(x -> Objects.nonNull(x))
                        .sorted(Comparator.reverseOrder())
                        .limit(5)
                        .collect(toList())
                )));

    }

}
