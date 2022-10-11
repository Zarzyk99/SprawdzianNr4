package pl.kurs.zadanie2.app;

import pl.kurs.zadanie2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class UserRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imię");
        String name = scanner.nextLine();
        Optional<String> nameOptional = Optional.of(name);

        if (nameOptional.isPresent()) {
            if (nameOptional.get().length() > 0)
                System.out.println("Długość imienia " + nameOptional.get().length());
            else System.out.println("0");
        } else System.out.println("0");

        System.out.println("Podaj pesel");
        String pesel = scanner.nextLine();
        Optional<String> peselOptional = Optional.of(pesel);

        if (peselOptional.isPresent()){
            if (peselOptional.get().length() == 11){
                pesel = pesel.substring(0, 6);
                LocalDate birthDate = LocalDate.parse(pesel, DateTimeFormatter.ofPattern("yyMMdd"));
                System.out.println("Twoja data urodzenia " + birthDate);
            }else try {
                throw new InvalidPeselException("Podany pesel jest nieprawidłowy");
            } catch (InvalidPeselException e) {
                e.printStackTrace();
            }
        }
    }
}
