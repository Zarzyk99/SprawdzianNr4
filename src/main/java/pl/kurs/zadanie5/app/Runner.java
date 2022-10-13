package pl.kurs.zadanie5.app;

import pl.kurs.zadanie5.exception.InvalidBirthDateException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoją datę urodzenia (yyyy/MM/dd)");
        String dateInput = scanner.nextLine();

        LocalDate birth = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        if (birth.isAfter(LocalDate.now())) throw new InvalidBirthDateException();
        System.out.println("Twoja data urodzenia " + birth);

        LocalDate currentDate = LocalDate.now();
        Period diff = birth.until(currentDate);
        LocalDateTime dateOfBirth = LocalDateTime.of(birth, LocalTime.now());
        Duration different = Duration.between(dateOfBirth, LocalDateTime.now());

        LocalDate nextFriday13 = LocalDate.of(birth.getYear(), birth.getMonth(), birth.getDayOfMonth());

        do {
            nextFriday13 = nextFriday13.plusMonths(1);
            nextFriday13 = nextFriday13.withDayOfMonth(13);
        } while (nextFriday13.getDayOfMonth() != 13 || nextFriday13.getDayOfWeek() != DayOfWeek.FRIDAY || nextFriday13.isBefore(birth));

        System.out.println("Żyjesz już " + different.toDays() + " dni");
        System.out.println("Żyjesz już " + diff.toTotalMonths() + " miesięcy");
        System.out.println("Zyjesz już " + (int) diff.toTotalMonths() / 12 + " lat");
        System.out.println("Urodziłeś się w " + birth.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("PL")));
        System.out.printf("Następny piątek 13 po twoich urodzinach to %s%n", nextFriday13);
    }
}
