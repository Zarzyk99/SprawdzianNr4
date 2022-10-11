package pl.kurs.zadanie1.service;

import pl.kurs.zadanie1.model.MinMax;

import java.util.List;
import java.util.Objects;

public class MinMaxService {

    public static <T extends Comparable> MinMax<T> getMinAndMax(List<T> elements) {
        Objects.requireNonNull(elements);

        if (elements.isEmpty()) {
            throw new RuntimeException("Lista jest pusta");
        }

        return new MinMax<>(

                elements.stream()
                        .min(((o1, o2) -> o1.compareTo(o2)))
                        .get(),

                elements.stream()
                        .max(((o1, o2) -> o1.compareTo(o2)))
                        .get()
        );
    }

}
