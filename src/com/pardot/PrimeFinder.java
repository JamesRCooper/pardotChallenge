package com.pardot;

import java.util.BitSet;

public class PrimeFinder {

    private int maxValue;
    private int maxPrimeFactor;

    private BitSet arePrime;

    public PrimeFinder(int maxValue) {

        this.maxValue = maxValue;
        this.maxPrimeFactor = findIntSquareRoot(maxValue);
        this.arePrime = new BitSet(maxValue);
    }

    private int findIntSquareRoot(int radicand) {

        int oldGuess, newGuess = 2;
        do {
            oldGuess = newGuess;
            newGuess = (oldGuess + (radicand / oldGuess)) / 2;
        } while (((newGuess - oldGuess > 4) || (newGuess - oldGuess) < -4));

        return newGuess + 3;
    }

    public BitSet getPrimes() {

        if (arePrime.cardinality() == 0)
            reduceArePrimes();
        return arePrime;
    }

    private void reduceArePrimes() {

        for (int potentialPrime = 2; potentialPrime < maxPrimeFactor; potentialPrime++)
            if (!arePrime.get(potentialPrime))
                eliminatePrimeMultiples(potentialPrime);
    }

    private void eliminatePrimeMultiples(int prime) {

        BitSet mask = new BitSet(maxValue);
        for (int i = prime*2; i < maxValue; i += prime)
            mask.flip(i);

        arePrime.or(mask);
    }
}
