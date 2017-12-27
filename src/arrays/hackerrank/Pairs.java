package arrays.hackerrank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Pairs {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Set<Integer> numbers = new TreeSet<>();
        for ( int i = 0 ;  i < N ; i++)
            numbers.add(sc.nextInt());


        System.out.println(countPairs(numbers, K));
    }

    private static int countPairs(Set<Integer> numbers, int k) {
        AtomicInteger pairs = new AtomicInteger(0);

        numbers.forEach( number -> {
            if ( numbers.contains(k + number))
                pairs.incrementAndGet();
        });

        return pairs.get();
    }
}
