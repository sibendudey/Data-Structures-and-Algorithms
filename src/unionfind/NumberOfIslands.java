package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference Leetcode Question 305. Number of Islands
 *
 * Time complexity: O(m * n + P) where P is the number of positions ,
 * Explanation: As we are maintaining a union find data structure, the amortized time complexity can be taken as
 * constant over the complete iteration of positions.
 *
 * Space complexity: O(m * n)
 * Explanation: Space required to maintain the union find data structure.
 */
public class NumberOfIslands {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        final int dir[][] = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        if (m == 0 || n == 0)
            return new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        List<Integer> res = new ArrayList<>();
        for (int pos[] : positions) {
            List<Integer> overLap = new ArrayList<>();
            for (int d[] : dir) {
                int nr = d[0] + pos[0];
                int nc = d[1] + pos[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && uf.isValid(nr * n + nc))
                    overLap.add(nr * n + nc);
            }

            uf.setParent(pos[0] * n + pos[1]);
            for (int o : overLap)
                uf.union(pos[0] * n + pos[1], o);

            res.add(uf.count());
        }

        return res;
    }

    private class UnionFind {
        int parent[];
        int rank[];
        int count;
        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1);
        }

        public boolean isValid(int i)   {
            return parent[i] != -1;
        }
        public void union(int i1, int i2)   {
            int p1 = findParent(i1);
            int p2 = findParent(i2);

            if (p1 != p2)   {
                if (rank[p1] > rank[p2])   {
                    parent[p2] = p1;
                }
                else if (rank[p1] < rank[p2])   {
                    parent[p1] = p2;
                }
                else    {
                    parent[p2] = p1; rank[p1]++;
                }
                count--;
            }
        }

        private int findParent(int p)   {
            if (parent[p] != p)
                parent[p] = findParent(parent[p]);
            return parent[p];
        }

        public int count() {
            return count;
        }

        public void setParent(int i)    {
            parent[i] = i;
            count++;
        }
    }
}
