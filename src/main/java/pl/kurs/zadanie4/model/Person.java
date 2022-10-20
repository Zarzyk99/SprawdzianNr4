package pl.kurs.zadanie4.model;

import java.util.Objects;
import java.util.function.Predicate;

public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private Integer age;

    public Person(String firstName, String lastName, String city, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
    }

    public static Predicate<Person> requireNonNull = person -> {
        boolean firstName = !Objects.equals(person.firstName, null);
        boolean lastName = !Objects.equals(person.lastName, null);
        boolean city = !Objects.equals(person.city, null);
        boolean age = !Objects.equals(person.age, null);

        return firstName && lastName && city && age;
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }


}
