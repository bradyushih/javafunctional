package org.example.functionInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Brad Shih on 2023/2/4
 * @project javafunctional
 *
 * Represents a predicate (boolean-valued function) of one argument.
 */
public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("07000000001"));
        System.out.println(isPhoneNumberValid("0700000001"));
        System.out.println(isPhoneNumberValid("09021240002"));

        System.out.println(isPhoneNumberValidPredicate.test("07000000001"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000001"));
        System.out.println(isPhoneNumberValidPredicate.test("09021240002"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("09009877300")
        );
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003")
        );

        System.out.println(
                isPhoneNumberValidBiPredicate.test("0723451313", "1212412401")
        );

    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static BiPredicate<String, String> isPhoneNumberValidBiPredicate = (phoneNumber, phoneNumber2) ->
            phoneNumber.startsWith("07") || phoneNumber2.endsWith("03");

}
