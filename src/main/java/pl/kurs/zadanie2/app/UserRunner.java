package pl.kurs.zadanie2.app;

import pl.kurs.zadanie2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;
import java.util.Scanner;

public class UserRunner {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj swoje imię");
        String name = input.nextLine();

        Integer nameLength = Optional.of(name)
                .map(String::length)
                .orElse(0);

        System.out.println("Długość imienia " + nameLength);

        System.out.println("Podaj pesel");
        String inputPesel = input.nextLine();

        String pesel = Optional.of(inputPesel)
                .orElseThrow(() -> new InvalidPeselException("Podany pesel jest nieprawidłowy"));

        if (pesel.length() < 6) throw new InvalidPeselException("Podany pesel jest nieprawidłowy");
        pesel = pesel.substring(0, 6);

        try {
            int year = Integer.parseInt(pesel.substring(0, 2)) + 2000;

            if (year > Calendar.getInstance().get(Calendar.YEAR)) {
                year -= 100;
            }

            String newPesel = year + pesel.substring(2, 6);

            LocalDate birthDate = LocalDate.parse(newPesel, DateTimeFormatter.ofPattern("yyyyMMdd"));
            System.out.println("Twoja data urodzenia " + birthDate);
        } catch (Exception e) {
            throw e;
        }
    }
}