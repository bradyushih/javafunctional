package org.example.combinatorpattern;

import java.time.LocalDate;

import static org.example.combinatorpattern.CustomerRegistrationValidator.*;

/**
 * @author Brad Shih on 2023/2/4
 * @project javafunctional
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+098984839483",
                LocalDate.of(2000, 2, 12)
        );

//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        System.out.println(validatorService.isValid(customer));

        // Using combinator pattern
//        ValidationResult result = isEmailValid()
//                .and(isPhoneNumberValid())
//                .and(isAndAdult())
//                .apply(customer);

        CustomerRegistrationValidator validator = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAndAdult());

        // validator will not implement until it apply an Object
        ValidationResult result = validator.apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalArgumentException("result.name");
        }
    }
}
