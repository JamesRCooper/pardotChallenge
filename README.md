# Pardot Challenge

A coding challenge was presented by Pardot as a first step in interviewing.

>You are given a function 'secret()' that accepts a single integer 
parameter and returns an integer. In your favorite programming language, 
write a command-line program that takes one command-line argument (a number) 
and determines if the secret() function is additive 
[secret(x+y) = secret(x) + secret(y)], for all combinations x and y, 
where x and y are all prime numbers less than the number passed via the 
command-line argument.  Describe how to run your examples. 
Please generate the list of primes without using built-in functionality.

This task was completed using java.

In order to run the code, with the argument, in a shell command, use the 
following:
>$./run a #Where 'a' is a positive integer

The secret method being tested can be found in /src/com/pardot/Secret.
It is f(x) = 3x where x != 27 and x!= 9967, else 0. As 27 is the
smallest composite number that is not the sum of two primes, if 'a' is 
less than or equal to 9967, the test will pass. As 9967 is a prime 
number, the test will fail for 'a' greater than 9967.

If it is desired to test a different secret, the 'secret' method in
/src/com/pardot/Secret class should be overrident with the new secret.
Then just run the following commands.
>$./compile
$./run 1000000 #or whichever a is desired

# About the Code

The code is brute forced by finding all primes less than a, and testing
every combination against the secret. Since addition is
commutative, each unordered set of primes is only tested once. This
leads to N! / (N-2)! + N tests begin performed, instead of N! tests.

The src/com/pardot/PrimeFinder class is used to find all the prime 
values less than a. It uses the Sieve of Erotosthenes for performing 
this action. In order to reserve space in the case of large a's, java
BitSets are used, which store arrays of bits/boolean values in Longs.

When created, the BitSets contain 0's for all bits. When using the sieve,
bits are set to 1 if their index is found to be a composite value.

In order to reduce the run time of the sieve, it is only run up to the
square root of a. Since there are no imported libraries, the rounded
square root was found using the Babylonian/Newton iterative method. Due
to using integer values in this calculation, error windows were used.
This may lead to up to 2 additional unnecessary iterations in the sieve.
However, this leads to a negligible amount of extra run time.
