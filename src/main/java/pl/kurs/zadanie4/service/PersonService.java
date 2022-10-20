package pl.kurs.zadanie4.service;

import pl.kurs.zadanie4.exception.NoWomenException;
import pl.kurs.zadanie4.model.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static Person getTheOldestWoman(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Nie znaleziono kobiet na liście"));
    }

    public static Double getAverageAge(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()

                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static Double getAverageAgeOfMen(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
                .filter(person -> !person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static Double getAverageAgeOfWomen(List<Person> personList) {
        Objects.requireNonNull(personList);

        return personList.stream()
                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public static double getAverageAgeOfSexByPredicate(List<Person> personList, Predicate<Person> predicate) {

        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList).stream()
                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
                .filter(predicate)
                .mapToDouble(Person::getAge).average()
                .orElse(0);

    }

    public static String getCityWithTheMostPeople(List<Person> personList) {
        Objects.requireNonNull(personList);

        Map<String, Integer> cities = new HashMap<>();

        personList.stream()
                .filter(Objects::nonNull)
                .filter(Person.requireNonNull)
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
                .filter(Person.requireNonNull)
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

}
