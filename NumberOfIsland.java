/*
Using BSF

Example 1:
Input:
11110
11010
11000
00000
No of Islands: 1

Example 2:
Input:
11000
11000
00100
00011
No of Islands: 3

Example 3:
Input:
11110
00010
00010
11110
No of Islands: 1


*/

import java.util.*;

public class NumberOfIsland {

	public static int numIslands(char[][] islandGrid) {

		int h = islandGrid.length;
		
		if (h == 0)
			return 0;

		int l = islandGrid[0].length;
		int islands = 0;

		boolean[][] visited = new boolean[h][l];

		for (int i = 0; i < h; i++)
			for (int j = 0; j < l; j++)
				visited[i][j] = false;

		Queue<String> queue =  new LinkedList<>();

		for (int i=0; i<h; i++)
			for (int j=0; j<l; j++)
				if (!visited[i][j] && islandGrid[i][j] == '1') {
					queue.add(i + "," + j);
					BFS(queue, islandGrid, visited);
					islands++;
				}

		return islands;

	}

	public static void BFS(Queue<String> queue, char[][] islandGrid, boolean[][] visited) {

		int H =  islandGrid.length;
		int L =  islandGrid[0].length;

		while (queue.isEmpty() == false) {
			
			String x = queue.remove();
			
			int row = Integer.parseInt(x.split(",")[0]);
			int col = Integer.parseInt(x.split(",")[1]);

			if (row<0 || col<0 || row>H || col>L || visited[row][col] || islandGrid[row][col] == '1')
				continue;

			visited[row][col] = true;
			queue.add(row + ", " + (col - 1));
			queue.add(row + ", " + (col + 1));
			queue.add((row + 1) + ", " + col);
			queue.add((row - 1) + ", " + col);

		}


	}


	public static void main(String[] args) {

        char [][] islandGrid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NumberOfIsland noOfIslands = new NumberOfIsland();
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));

        islandGrid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
    }
}
