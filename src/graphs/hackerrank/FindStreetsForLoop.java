//package graphs.hackerrank;
//
//import graphs.Graph;
//import graphs.GraphBuilder;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * Created by deysi on 6/28/2017.
// */
//public class FindStreetsForLoop {
//
//    public static void main(String args[])  {
//
//        Scanner sc = new Scanner(System.in);
//
//        int noOfTestCases = sc.nextInt();
//        for ( int i = 0 ; i < noOfTestCases ; i++)  {
//
//            Graph graph = GraphBuilder.createGraphWithAdjacencyListAndIndegree();
//            findJunctions(graph);
//
//        }
//    }
//    private static void findJunctions(Graph graph) {
//
//        boolean visited[] = new boolean[graph.getVertices()];
//        for ( int startVertex = 0 ; startVertex < graph.getVertices() ; startVertex++)    {
//                Queue<Integer> queue = new LinkedList<>();
//                findLoop( graph , startVertex , queue);
//            }
//        }
//
//    }
//
//    private static void findLoop(Graph graph, int startVertex, Queue<Integer> queue) {
//
//        boolean visited[] = new boolean[graph.getVertices()];
//        int count = 0;
//        queue.add(startVertex);
//        for ( int currVertex  : graph.getAdjList()[startVertex])  {
//            count += findLoopUtil(graph , startVertex , currVertex , queue );
//        }
//
//    }
//
//    private static int findLoopUtil(Graph graph, int startVertex, int currVertex, Queue<Integer> queue) {
//
//        int count = 0;
//        if ( currVertex == startVertex) {
//            calculateStreets(queue);
//        }
//        for ( int)
//
//        return count;
//    }
//
//    private static void calculateStreets(Queue<Integer> queue) {
//    }
//}
