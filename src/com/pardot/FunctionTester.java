package com.pardot;

import java.util.BitSet;
import java.util.function.Function;

public class FunctionTester {

    private BitSet arePrimes;
    private int maxTestValue;

    public FunctionTester(BitSet arePrimes, int maxTestValue) {

        this.arePrimes = arePrimes;
        this.maxTestValue = maxTestValue;
    }

    public boolean testFunctionIsLinear(Function<Integer, Integer> questionedFunction) {

        for (int i = 2; i < maxTestValue; i++)
            if (!arePrimes.get(i))
                for (int j = i; j < maxTestValue; j++)
                    if (!arePrimes.get(j))
                        if (!functionPassesWithValues(questionedFunction, i, j))
                            return false;
        return true;
    }

    private boolean functionPassesWithValues(
            Function<Integer, Integer> function, int i, int j) {

        //System.out.println("x: " + i + ", y: " + j + ", x + y: " + (i + j));
        return function.apply(i + j) == function.apply(i) + function.apply(j);
    }
}
