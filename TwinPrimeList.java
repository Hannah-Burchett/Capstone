import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class TwinPrimeList {
  public static void main(String [] args) 
  throws FileNotFoundException {
    // Initializing an empty array of twin prime numbers.
    ArrayList<Integer> twinPrimes = new ArrayList<Integer>();

    // Initializing a maximum value. We will later add to the array all twin prime numbers less than or equal to this value.
    int max = 1000;

    // Adding several initial values to the array.
    twinPrimes.add(3);
    twinPrimes.add(5);
    twinPrimes.add(7);

    // Finding the twin prime numbers less than or equal to the maximum, and adding them to the array.
    for (int i=9; i<=max; i+=2) {
      boolean isPrime = true;
      double n = Math.sqrt(i);
      n = n/1;  // Floor function
      for (int j=2; j<=n; j++) {
        if (i%j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        twinPrimes.add(i);
      }
    }

    // Initializing the element, minus, plus, prev, and next variables.
    int element;
    int minus;
    int plus;
    int prev;
    int next;
    
    // Removing primes that are not twin primes from the array.
    for (int i=3; i<twinPrimes.size()-1; i++) {
      boolean isTwinPrime = true;
      element = (int) twinPrimes.get(i);
      minus = element - 2;
      prev = (int) twinPrimes.get(i-1);
      plus = element + 2;
      next = (int) twinPrimes.get(i+1);
      if (minus != prev && plus != next){
        isTwinPrime = false;
        twinPrimes.remove(i);
        i = i-1;
      }
    }

    // Discovering whether the last element is a twin prime.
    int last = (int) twinPrimes.get(twinPrimes.size()-1);
    int secondLast = (int) twinPrimes.get(twinPrimes.size()-2);
    if (secondLast != last-2) {
      int twoPlusLast = last + 2;
      boolean isPrime = true;
      double n = Math.sqrt(twoPlusLast);
      n = n/1;
      for (int j=2; j<=n; j++) {
        if (twoPlusLast%j == 0) {
          isPrime = false;
          break;
        }
      }
      if (!isPrime) {
        twinPrimes.remove(twinPrimes.size()-1);
      }
    }

    // Initializing a new text file.
    PrintStream p = new PrintStream(new File("twin_primes_up_to_10000.txt"));

    // Switching from printing to the console to printing to the text file.
    PrintStream console = System.out;
    System.setOut(p);

    // Printing the array of twin primes to the text file.
    System.out.println(twinPrimes);
  }
}
