package pl.kurs.zadanie3;

import java.util.*;
import java.util.stream.Collectors;

public class StreamRunner {

    public static void main(String[] args) {


        System.out.println(get5largestElements(List.of(1, 75, 2, 69, 58, 41, 2, 33, 15)));
        System.out.println(get5largestElements(List.of(1, 75, 2)));
        System.out.println(get5largestElements(List.of(1,1,1,1,1,2,2,0)));
        System.out.println(get5largestElements(new ArrayList<>()));

    }

    public static List<Integer> get5largestElements(List<Integer> integers) {

        List<Integer> newList = integers.stream()
                .filter(x -> Objects.nonNull(x))
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
        return newList.size() < 5 ? new ArrayList<>() : newList;

    }

}
