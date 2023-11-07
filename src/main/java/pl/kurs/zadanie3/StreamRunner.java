package pl.kurs.zadanie3;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamRunner {

    public static void main(String[] args) {


        System.out.println(get5largestElements(List.of(1, 75, 2, 69, 58, 41, 2, 33, 15)));
        System.out.println(get5largestElements(List.of(1, 75, 2)));
        System.out.println(get5largestElements(List.of(1, 1, 1, 1, 1, 2, 2, 0)));
        System.out.println(get5largestElements(new ArrayList<>()));
        System.out.println(get5largestElements(null));

    }

    public static List<Integer> get5largestElements(List<Integer> integers) {

        return  Optional.ofNullable(integers)
                        .stream()
                        .flatMap(List::stream)
                        .collect(Collectors.collectingAndThen(toList(),(x -> x.stream()
                                                                                .filter(y -> Objects.nonNull(y))
                                                                                .sorted()
                                                                                .limit(5)
                                                                                .collect(toList()))));


    }

}
