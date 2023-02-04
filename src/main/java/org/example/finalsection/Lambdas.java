package org.example.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Brad Shih on 2023/2/4
 * @project javafunctional
 */
public class Lambdas {
    public static void main(String[] args) {

        Function<String, String> upperCaseName  = name -> {
            // logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
        BiFunction<String, Integer, String> upperCaseNameAnd  = (name, age) -> {
            // logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseNameAnd.apply("Alex", 20));
    }
}
