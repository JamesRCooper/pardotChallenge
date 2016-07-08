package com.pardot;

import java.util.BitSet;

public class Main {

    public static void main(String[] args) {

        String firstArg = args[0];
        int maxValue = Integer.parseInt(firstArg);

        PrimeFinder pFinder = new PrimeFinder(maxValue);
        BitSet arePrime = pFinder.getPrimes();

        FunctionTester tester = new FunctionTester(arePrime, maxValue);
        if (tester.testFunctionIsLinear(Secret::secret))
            print("result", "passed");
        else
            print("result", "failed");
    }

    private static void print(String id, Object obj) {

        System.out.print(id + ": ");
        System.out.println(obj);
    }
}

