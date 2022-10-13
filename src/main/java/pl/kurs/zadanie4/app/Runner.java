package pl.kurs.zadanie4.app;

import pl.kurs.zadanie4.model.Person;
import pl.kurs.zadanie4.service.PersonService;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Agata", "Kapusta", "Wrocław", 24),
                new Person("Patryk", "Tracz", "Katowice", 25),
                new Person("Monika", "Kopka", "Poznań", 35),
                new Person("Dominika", "Nowak", "Warszawa", 17),
                new Person("Tomek", "Wtorek", "Katowice", 24),
                new Person("Marcin", "Krawiec", "Warszawa", 43),
                new Person("Agnieszka", "Bąk", "Wrocław", 16),
                new Person("Adrian", "Brak", "Warszawa", 35)
        );

        System.out.println(PersonService.getTheOldestWoman(personList));
        System.out.println(PersonService.getAverageAge(personList));
        System.out.println(PersonService.getAverageAgeOfMen(personList));
        System.out.println(PersonService.getAverageAgeOfWomen(personList));
        System.out.println(PersonService.getAverageAgeOfSex(personList, "male"));
        System.out.println(PersonService.getCityWithTheMostPeople(personList));
        System.out.println(PersonService.getCities(personList));
    }
}
