package pl.kurs.zadanie4.service;

import pl.kurs.zadanie4.exception.NoWomenException;
import pl.kurs.zadanie4.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    public static Person getTheOldestWoman(List<Person> personList) {

        Person theOldestWoman = personList.stream()
                .filter(person -> person.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Nie znaleziono kobiet na liście"));

        return theOldestWoman;
    }

    public static Double getAverageAge(List<Person> personList) {

        Double averageAge = personList.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        return averageAge;
    }

    public static Double getAverageAgeOfMen(List<Person> personList) {

        Double averageAgeOfMen = personList.stream()
                .filter(person -> !person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
        return averageAgeOfMen;
    }

    public static Double getAverageAgeOfWomen(List<Person> personList) {

        Double averageAgeOfMen = personList.stream()
                .filter(person -> person.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge));
        return averageAgeOfMen;
    }

    public static Double getAverageAgeOfSex(List<Person> personList, String sex) {
        if (sex.equals("male")) {
            return getAverageAgeOfMen(personList);
        } else if (sex.equals("female")) {
            return getAverageAgeOfWomen(personList);
        } else throw new UnsupportedOperationException();


    }

    public static String getCityWithTheMostPeople(List<Person> personList) {
        Map<String, Integer> cities = new HashMap<>();
        personList.stream()
                .forEach(person -> {
                    if (!cities.containsKey(person.getCity())) cities.put(person.getCity(), 1);
                    else cities.replace(person.getCity(), cities.get(person.getCity()) + 1);
                });
        return cities.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow(RuntimeException::new)
                .getKey();
    }

    public static List<String> getCities(List<Person> personList) {

        return personList.stream()
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

}
