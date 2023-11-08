package pl.kurs.zadanie1;

import java.util.ArrayList;
import java.util.List;

public class MinMaxApp {
    public static void main(String[] args) {


        System.out.println(MinMaxService.getMinAndMax(List.of("Ala", "Ewa", "Ola", "Sara", "Ela")).getMin());
        System.out.println(MinMaxService.getMinAndMax(List.of(1,2,4,6,3,56)).getMin());
        System.out.println(MinMaxService.getMinAndMax(List.of(1,2,4,6,3,56)).getMin());

        List<Integer> ints = new ArrayList<>();
        ints.add(null);
        ints.add(null);
        ints.add(null);

        System.out.println(MinMaxService.getMinAndMax(ints).getMax());


    }
}