import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {
    BigInteger fib[];

    Fibonacci(int k){
        fib = new BigInteger[k];
        fib[0] = BigInteger.valueOf(0);
        fib[1] = BigInteger.valueOf(1);
    }

    // n must always equal 2 calling this function
    public BigInteger compute(int n, int k){
        if(k == 1 || k == 2){
            return fib[k-1];
        } else if (n < k){
            fib[n] = fib[n-1].add(fib[n-2]);
            return compute(n+1,k);
        } else {
            return fib[n-1];
        }
    }

}
