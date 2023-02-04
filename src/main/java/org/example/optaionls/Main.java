package org.example.optaionls;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Brad Shih on 2023/2/4
 * @project javafunctional
 */
public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println("value = " + value);

        Object value2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        System.out.println("value2 = " + value2);

        Supplier<IllegalArgumentException> illegalArgumentExceptionSupplier = () -> new IllegalArgumentException();
        Object value3 = Optional.ofNullable("Hello")
                .orElseThrow(illegalArgumentExceptionSupplier);

        Optional.ofNullable("test@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to "+ email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to "+ email),
                        () -> System.out.println("Cannot send email"));

    }
}
