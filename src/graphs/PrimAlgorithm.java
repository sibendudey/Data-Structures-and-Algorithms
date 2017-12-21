//package graphs;
//
///**
// * Created by sibendu on 27/3/17.
// */
//public class PrimAlgorithm {
//
//    public static void main(String args[]) throws Exception {
//
//        Graph graph = GraphBuilder.createGraphWithWeight();
//        prim(graph);
//    }
//
//    private static void prim(Graph graph) throws Exception {
//
//        int key[] = new int[graph.getVertices()];
//        int parent[] = new int[graph.getVertices()];
//        boolean mstSet[] = new boolean[graph.getVertices()];
//
//        for (int i = 1; i < key.length; i++)
//            key[i] = Integer.MAX_VALUE;
//
//        parent[0] = -1;
//        key[0] = 0;
//
//        for (int count = 0; count < graph.getVertices() - 1; count++) {
//            int u = fetchMinKey(key, mstSet);
//            if ( u == Integer.MAX_VALUE)
//                throw new Exception();
//
//            mstSet[u] = true;
//            for (Edge edge : graph.getEdgesList()) {
//                if (edge.getSrc() == u) {
//                    int v = edge.getDest();
//                    if (!mstSet[v] && edge.getWeight() < key[v]) {
//                        key[v] = edge.getWeight();
//                        parent[v] = u;
//                    }
//                }
//            }
//        }
//
//        primMST(parent);
//
//    }
//
//    private static void primMST(int[] parent) {
//        for ( int i = 1 ; i < parent.length ; i++)
//            System.out.println(parent[i] + " -> " + i );
//    }
//
//    private static int fetchMinKey(int[] keys, boolean[] mstSet) {
//
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int index = 0; index < keys.length; index++) {
//            if (!mstSet[index] && min > keys[index]) {
//                min = keys[index];
//                minIndex = index;
//            }
//        }
//
//        return minIndex;
//    }
//
//}
