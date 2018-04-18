package edu.ap.spring;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class Exam {

	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
			return Arrays.stream(numbers)
                    .filter(PrimeStreamTest::isPrime)
                    .toArray();

	}

	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {
        return (int)string.chars().filter(Character::isLowerCase).count();
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	public int sumOfX(List<Point> points) {
		return points.stream()
                .map(point -> point.x)
                .mapToInt(Integer::intValue)
                .sum();
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
        /*
        String s = points.stream()
                .map(point -> point.x)
                .filter(x -> x >= 2)
                .mapToInt(Integer::intValue)
                .collect(Collectors.joining(","));

        return  s;
        */
        return  "";
    }
}
