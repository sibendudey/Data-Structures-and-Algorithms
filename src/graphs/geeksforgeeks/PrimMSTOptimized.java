//package graphs.geeksforgeeks;
//
//import graphs.*;
//
///**
// * Created by Sibendu Dey on 3/30/2017.
// *
// * Why -> To find the minimum spanning tree for a connected graph
// *
// * How ->
// *    1. Create a minheap to track the vertices with minimum key values.
// *    2. For every minimum heap node , adjust the key values of all the adjacent vertices if the
// *       present key value is greater than the edge weight. and mark the heap node as visited
// *    3. Update the parent array to keep track of edges involved in forming the MST.
// *
// * Time complexity -> To be investigated by 1st April 2017.
// *
// *
// */
//public class PrimMSTOptimized {
//
//    public static void main(String args[]) {
//
//        Graph graph = GraphBuilder.createGraphWithWeight();
//        MinHeap minHeap = new MinHeap(graph.getVertices());
//        performPRIMOptimized(graph, minHeap);
//    }
//
//    private static void performPRIMOptimized(Graph graph, MinHeap minHeap) {
//
//        boolean visited[] = new boolean[graph.getVertices()];
//        int parent[] = new int[graph.getVertices()];
//        parent[0] = -1;
//        while (minHeap.getSize() != 0) {
//            MinHeapNode node = minHeap.extractMin();
//            System.out.print(node.getVertex() + " ");
//            visited[node.getVertex()] = true;
//            for (Edge edge : graph.getEdgesListStreamed(node.getVertex())) {
//                if (!visited[edge.getDest()] && minHeap.getNodes()[minHeap.getPos()[edge.getDest()]].getKey() > edge.getWeight()) {
//                    minHeap.decreaseKey(edge.getDest(), edge.getWeight());
//                    parent[edge.getDest()] = edge.getSrc();
//                }
//            }
//        }
//        printSolution(parent);
//    }
//
//    private static void printSolution(int[] parent) {
//
//        for ( int i = 1 ; i < parent.length ; i++)
//            System.out.println(parent[i] + "->" + i);
//    }
//
//
//}
