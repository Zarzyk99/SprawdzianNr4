package pl.kurs.zadanie1.app;

import pl.kurs.zadanie1.service.MinMaxService;

import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<String> stringList = List.of("jabłko", "pomarańcza", "śliwka", "gruszka", "mirabelka", "arbuz");
        List<Double> doubles = List.of(2.5, 13.2, 7.8, 2.3, 123.43, 17.4, 256.56, 13.4);


        System.out.println(MinMaxService.getMinAndMax(stringList));
        //MinMax{min=arbuz, max=śliwka}

        System.out.println(MinMaxService.getMinAndMax(doubles));
        //MinMax{min=2.3, max=256.56}

    }
}
