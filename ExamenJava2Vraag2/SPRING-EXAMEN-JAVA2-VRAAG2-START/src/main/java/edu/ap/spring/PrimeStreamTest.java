package edu.ap.spring;

import java.util.stream.LongStream;

public class PrimeStreamTest {

     static boolean isPrime(final int number) {
        return number == 2 || (number % 2 != 0 && LongStream
                .range(2, (int) Math.ceil(Math.sqrt(number + 1)))
                .filter(n -> n % 2 != 0)
                .noneMatch(divisor -> number % divisor == 0)
        );
    }
}
