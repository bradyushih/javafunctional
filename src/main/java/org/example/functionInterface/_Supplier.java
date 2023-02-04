package org.example.functionInterface;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Brad Shih on 2023/2/4
 * @project javafunctional
 *
 * Represents a supplier of results.
 */
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlSupplierV2.get());
    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () ->
            "jdbc://localhost:5432/users";
    static Supplier<List<String>> getDBConnectionUrlSupplierV2 = () ->
            List.of("jdbc://localhost:5432/users",
                    "jdbc://localhost:1234/roles");
}
