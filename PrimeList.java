import java.util.ArrayList;
import java.io.*;

public class PrimeList {
  public static void main(String [] args) 
  throws FileNotFoundException {
    // Initializing an empty array of prime numbers.
    ArrayList<Integer> primes = new ArrayList<Integer>();
    
    // Initializing a maximum value. We will later add to the array all prime numbers less than or equal to this value.
    int max = 10000;

    // Adding several initial values to the array.
    primes.add(2);
    primes.add(3);
    primes.add(5);
    primes.add(7);

    // Finding the prime numbers less than or equal to the maximum, and adding them to the array.
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
        primes.add(i);
      }
    }

    // Initializing a new text file.
    PrintStream p = new PrintStream(new File("primes_up_to_10000.txt"));
    
    // Switching from printing to the console to printing to the text file.
    PrintStream console = System.out;
    System.setOut(p);

    // Printing the array of primes to the text file.
    System.out.println(primes);
  }
}
