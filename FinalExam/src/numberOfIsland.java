import java.awt.*;
import java.util.LinkedList;

public class numberOfIsland {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid)
    {
        if(grid.length == 0 )
            return 0;

        int visited[][] = new int[grid.length][grid[0].length];

        int num = 0;

        for(int i = 0; i<grid.length ; i++)
            for(int j = 0; j<grid[i].length ; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    bfs(grid, visited, i, j);
                    num++;
                }
            }

        return num;
    }

    static void bfs(char mat[][], int visited[][], int i, int j)
    {
        LinkedList<Point> queue = new LinkedList<>();

        queue.addFirst(new Point(i,j));

        while(!queue.isEmpty())
        {
            Point p = queue.pollLast();

            if((p.x<0 || p.x >= mat.length || p.y<0 || p.y >= mat[0].length ))
                continue;

            if(mat[p.x][p.y] != '1' || visited[p.x][p.y] == 1)
                continue;

            visited[p.x][p.y] = 1;

            queue.addFirst(new Point(p.x-1,p.y));
            queue.addFirst(new Point(p.x+1,p.y));
            queue.addFirst(new Point(p.x,p.y-1));
            queue.addFirst(new Point(p.x,p.y+1));
        }
    }

}
