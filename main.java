/*
Names: Ezio Vento Porth
Student Number: 040865194
 */
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;


public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k;
        long startTime, endTime;
        BigInteger fibAnswer;

        System.out.println("Type a positve integer: ");
        k = scan.nextInt();

        startTime = System.currentTimeMillis();
        Fibonacci fib = new Fibonacci(k);
        fibAnswer = fib.compute(2,k);
        endTime = System.currentTimeMillis();

        System.out.format("The %dth Fibonacci number is %d%n",k,fibAnswer);
        System.out.format("It took %d milliseconds to compute it.", endTime-startTime);
    }
}
