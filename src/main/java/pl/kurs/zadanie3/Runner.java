package pl.kurs.zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList1 = List.of(12, 32, 43, 54, 62, 41, 32, 23, 75, 1, 6);
        List<Integer> integerList2 = List.of(2, 4, 33, 1);
        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(null);
        integerList3.add(null);
        integerList3.add(null);
        integerList3.add(null);
        integerList3.add(null);

        System.out.println(getTheBiggest5Elements(integerList1));
        System.out.println(getTheBiggest5Elements(integerList2));
        System.out.println(getTheBiggest5Elements(integerList3));

    }

    private static List<Integer> getTheBiggest5Elements(List<Integer> integers) {
        Objects.requireNonNull(integers);

        if (integers.size() < 5) return List.of();

        return integers.stream()
                .flatMap(Stream::ofNullable)
                .sorted((i1, i2) -> i2 - i1)
                .limit(5)
                .collect(Collectors.toList());
    }
}
