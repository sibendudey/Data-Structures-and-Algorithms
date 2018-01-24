package hash.tables.leetcode;

public class IslandPerimeter {

    public static void main(String args[]) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(new int[][]{{1}}));
    }

    static int perimeter;

    public int islandPerimeter(int[][] grid) {
        perimeter = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startDFS(i, j, visited, grid);
                }
            }
        }

        return perimeter;
    }

    public static boolean valid(int x, int y, int width, int height) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public static void startDFS(int x, int y, boolean[][] visited, int[][] grid) {
        if (visited[x][y])
            return;

        if (grid[x][y] == 0) {
            perimeter++;
            return;
        }

        visited[x][y] = true;

        for (int i = -1; i <= 1; i++) {
            if (valid(x + i, y, grid.length, grid[0].length)) {
                if (!visited[x + i][y])
                    startDFS(x + i, y, visited, grid);
            } else
                perimeter++;

            if (valid(x, y + i, grid.length, grid[0].length)) {
                if (!visited[x][y + i])
                    startDFS(x, y + i, visited, grid);
            } else
                perimeter++;
        }
    }
}


