package graphs.hackerrank;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Astronaut {
    static Long journeyToMoon(int n, int[][] astronaut) {

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for ( int i = 0 ; i < n ; i++)
            edgeMap.put(i , new ArrayList<>());

        for (int i = 0; i < astronaut.length; i++) {
            int start = astronaut[i][0];
            int end = astronaut[i][1];
            edgeMap.get(start).add(end);
            edgeMap.get(end).add(start);
        }

        final boolean visited[] = new boolean[n];

        return combination(n) - edgeMap.entrySet()
                .stream()
                .mapToLong(entry -> {
                    if (!visited[entry.getKey()]) {
                        int noOfVertices = performDFS(edgeMap, entry.getKey(), visited);
                        return combination(noOfVertices);
                    } else
                        return 0;
                })
                .sum();

    }

    private static Long combination(int n) {
        return ((long)n * ( n - 1)) / 2;
    }

    private static int performDFS(Map<Integer, List<Integer>> mat, int node, boolean[] visited) {
        if (visited[node])
            return 0;

//        int noOfVertices = 1;
//        visited[node] = true;
//        for (int i = 0; i < mat[node].length; i++) {
//            if (mat[node][i] == 1)
//                noOfVertices += performDFS(mat, i, visited);
//        }
//        return noOfVertices;

        visited[node] = true;
        return 1 + mat.get(node).stream()
                .mapToInt(adjacentNode -> performDFS(mat, adjacentNode, visited))
                .sum();

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for(int astronaut_i = 0; astronaut_i < p; astronaut_i++){
            for(int astronaut_j = 0; astronaut_j < 2; astronaut_j++){
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}

