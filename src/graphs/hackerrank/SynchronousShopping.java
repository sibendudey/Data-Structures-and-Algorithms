package graphs.hackerrank;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class SynchronousShopping {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        List<List<Integer>> fishes = new ArrayList<>();
        List<List<Edge>> adjacencyList = new ArrayList<>();

        for ( int i = 1 ; i <= N ; i++)  {
            int T = sc.nextInt();
            fishes.add(new ArrayList<>());
            for ( int j = 1 ; j <= T ; j++) {
                fishes.get(i-1).add(sc.nextInt());
            }
            adjacencyList.add(new ArrayList<>());
        }

        for ( int i = 1 ; i <= M ; i++) {
            int source = sc.nextInt() - 1;
            int destination = sc.nextInt() - 1;
            int weight = sc.nextInt();
            adjacencyList.get(source).add(new Edge(destination, weight));
        }
    }

    private static class Node   {
        List<Integer> fishes;
        int NodeName;

        public Node(int nodeName, List<Integer> fishes) {
            NodeName = nodeName;
            this.fishes = fishes;
        }

    }
    private static class Edge{
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
