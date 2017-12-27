package arrays.hackerrank;

import java.util.*;

public class MissingNumbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> N_Numbers = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            N_Numbers.putIfAbsent(number, 0);
            N_Numbers.put(number, N_Numbers.get(number) + 1);
        }
        int M = sc.nextInt();
        Map<Integer, Integer> M_Numbers = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int number = sc.nextInt();
            M_Numbers.putIfAbsent(number, 0);
            M_Numbers.put(number, M_Numbers.get(number) + 1);
        }

        printMissingNumbers(N_Numbers, M_Numbers);
    }

    private static void printMissingNumbers(Map<Integer, Integer> n_numbers, Map<Integer, Integer> m_numbers) {
        m_numbers.entrySet()
                .stream()
                .filter(entry -> !(
                        n_numbers.get(entry.getKey()) != null &&
                                n_numbers.get(entry.getKey()).compareTo(entry.getValue()) == 0 ))
                .collect(() -> new HashSet<>(),
                        (hs, entry) -> hs.add(entry.getKey()), (hs1, hs2) -> hs1.addAll(hs2))
                .stream()
                .sorted()
                .forEach(element -> System.out.print(element + " "));
    }
}
