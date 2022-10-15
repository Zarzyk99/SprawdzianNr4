package pl.kurs.zadanie4.service;

import pl.kurs.zadanie4.exception.NoWomenException;
import pl.kurs.zadanie4.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    public static Person getTheOldestWoman(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Nie znaleziono kobiet na liście"));
    }

    public static Double getAverageAge(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()

                .filter(Objects::nonNull)
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static Double getAverageAgeOfMen(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(person -> !person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static Double getAverageAgeOfWomen(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static Double getAverageAgeOfSex(List<Person> personList, String sex) {
        Objects.requireNonNull(personList);

        if (sex.equals("male")) {
            return getAverageAgeOfMen(personList);
        } else if (sex.equals("female")) {
            return getAverageAgeOfWomen(personList);
        } else throw new UnsupportedOperationException();
    }

    public static String getCityWithTheMostPeople(List<Person> personList) {
        Objects.requireNonNull(personList);

        Map<String, Integer> cities = new HashMap<>();

        personList.stream()
                .filter(Objects::nonNull)
                .forEach(person -> {
                    if (!cities.containsKey(person.getCity())) cities.put(person.getCity(), 1);
                    else cities.replace(person.getCity(), cities.get(person.getCity()) + 1);
                });

        return cities.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("No cities mapped"))
                .getKey();
    }

    public static List<String> getCities(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

}
