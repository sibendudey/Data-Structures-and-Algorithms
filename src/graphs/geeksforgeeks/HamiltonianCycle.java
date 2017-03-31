package graphs.geeksforgeeks;

/**
 * Created by Sibendu Dey on 3/28/2017.
 *
 * Why -> The purpose of this algorithm is to find an hamiltonian cycle where there is an back path exists from
 * source to end present in the hamiltonian path
 *
 * How -> Find an hamiltonian edge and at the end check whether there exists an edge from end to source
 *
 * Applicable -> This algorithm applies to Directed Graphs
 *
 * Time complexity -> O(V!)
 */
public class HamiltonianCycle {

    public static void main(String args[])  {

        int adjacencyList[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        int V = adjacencyList.length;
        int startingVertex = 0;
        findHAMCycle( adjacencyList );


        int adjacencyList2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        findHAMCycle(adjacencyList2);
    }

    private static void findHAMCycle(int[][] adjacencyList) {

        int numberOfVertices = adjacencyList.length;

        int [] path = new int[adjacencyList.length];
        boolean visited[] = new boolean[adjacencyList.length];

        for ( int i = 0 ; i < path.length ; i++)
            path[i] = -1;

        path[0] = 0;
        visited[0] = true;

        if ( !findHAMCycleUtil(adjacencyList , path , 1 , visited))    {
            System.out.println("Solution doesn't exist");
            return;
        }

        printSolution(path);

    }

    private static void printSolution(int[] path) {
        for ( int vertex : path)
            System.out.print(vertex + "->" );

        System.out.print(path[0]);
    }

    private static boolean findHAMCycleUtil(int[][] adjacencyList, int[] path, int pos, boolean[] visited) {

        if ( pos == adjacencyList.length)  {
            if ( adjacencyList[path[pos-1]][path[0]] == 1)
                return true;

            return false;
        }

        for ( int V = 1 ; V < adjacencyList.length ; V++)   {
            if ( isSafe( path[pos - 1] , V , adjacencyList , visited )) {
                visited[V] = true;
                path[pos] = V;

                if (  findHAMCycleUtil(adjacencyList, path , pos+1 , visited))
                    return true;

                visited[V] = false;
                path[pos] = -1;
             }
        }

        return false;

    }

    private static boolean isSafe(int lastVertex, int currVertex, int[][] adjacencyList, boolean[] visited) {

        if ( visited[currVertex] || adjacencyList[lastVertex][currVertex] != 1 )
            return false;
        
        return true;

    }

}
