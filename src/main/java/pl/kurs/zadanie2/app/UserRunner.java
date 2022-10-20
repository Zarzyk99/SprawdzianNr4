package pl.kurs.zadanie2.app;

import pl.kurs.zadanie2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserRunner {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj swoje imię");
        String name = input.nextLine();

        Optional<String> nameOptional = Optional.of(name);
        nameOptional.ifPresentOrElse(n -> System.out.println("Długość imienia " + n.length()), () -> System.out.println("0"));

        System.out.println("Podaj pesel");
        String peselInput = input.nextLine();


        String pesel = Optional.ofNullable(peselInput)
                .filter(x -> x.length() == 11)
                .orElseThrow(() -> new InvalidPeselException("Podano błędny pesel"))
                .substring(0, 6);

        LocalDate birthDate = Stream.of(pesel)
                .map((p) -> {
                    int year = Integer.parseInt(p.substring(0, 2)) + 2000;

                    if (year > Calendar.getInstance().get(Calendar.YEAR)) {
                        year -= 100;
                    }

                    String newPesel = year + p.substring(2, 6);

                    try {

                        return LocalDate.parse(newPesel, DateTimeFormatter.ofPattern("yyyyMMdd"));
                    } catch (Exception e) {
                        return LocalDate.now();
                    }

                })
                .collect(Collectors.toList())
                .get(0);
        System.out.println("Twoja data urodzenia" + birthDate);


    }
}
