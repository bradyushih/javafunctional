package org.example.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.imperative.Main.Gender.FEMALE;
import static org.example.imperative.Main.Gender.MALE;

/**
 * @author ${USER} on ${DATE}
 * @project ${PROJECT_NAME}
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // streams approach
        List<Person> females = new ArrayList<>();

        for (Person person: people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female: females){
            System.out.println(female);
        }
        
        // Declarative approach
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}