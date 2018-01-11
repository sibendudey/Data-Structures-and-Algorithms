package graphs.hackerrank;

import java.util.*;

public class TorqueDevelopment {
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // Complete this function

        if (c_road > c_lib) return (long) n * c_lib;

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for ( int i = 0 ; i < n ; i++)
            edgeMap.put(i , new ArrayList<>());

        for (int i = 0; i < cities.length; i++) {
            int start = cities[i][0] - 1;
            int end = cities[i][1] - 1;
            edgeMap.get(start).add(end);
            edgeMap.get(end).add(start);
        }

        final boolean visited[] = new boolean[n];

        return edgeMap.entrySet()
                .stream()
                .mapToLong(entry -> {
                    if (!visited[entry.getKey()]) {
                        int noOfVertices = performDFS(edgeMap, entry.getKey(), visited);
                        return (long) (noOfVertices - 1) * c_road + c_lib;
                    } else
                        return 0;
                })
                .sum();

//        for (int i = 0; i < mat.length; i++) {
//            if (!visited[i]) {
//                int noOfVertices = performDFS(mat, i ,visited);
//                cost += (long)(noOfVertices - 1) * c_road + c_lib;
//            }
//        }

//        return cost;
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
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for (int cities_i = 0; cities_i < m; cities_i++) {
                for (int cities_j = 0; cities_j < 2; cities_j++) {
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }
}
