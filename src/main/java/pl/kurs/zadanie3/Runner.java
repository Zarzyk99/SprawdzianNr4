package pl.kurs.zadanie3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList1 = List.of(12, 32, 43, 54, 62, 41, 32, 23, 75, 1, 6);
        List<Integer> integerList2 = List.of(2, 4, 33, 1);
        System.out.println(getTheBiggest5Elements(integerList1));

    }


    private static List<Integer> getTheBiggest5Elements(List<Integer> integers) {
       return integers.stream()
               .sorted((i1, i2) -> i2 - i1)
               .limit(5)
               .collect(Collectors.toList());
    }
}
