//You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
//You are given an array graph where graph[i] is a list of all the nodes connected 
//with node i by an edge. 
//
// Return the length of the shortest path that visits every node. You may start 
//and stop at any node, you may revisit nodes multiple times, and you may reuse 
//edges. 
//
// 
// Example 1: 
//
// 
//Input: graph = [[1,2,3],[0],[0],[0]]
//Output: 4
//Explanation: One possible path is [1,0,2,0,3]
// 
//
// Example 2: 
//
// 
//Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
//Output: 4
//Explanation: One possible path is [0,1,4,2,3]
// 
//
// 
// Constraints: 
//
// 
// n == graph.length 
// 1 <= n <= 12 
// 0 <= graph[i].length < n 
// graph[i] does not contain i. 
// If graph[a] contains b, then graph[b] contains a. 
// The input graph is always connected. 
// 
// Related Topics 位运算 广度优先搜索 图 动态规划 状态压缩 👍 280 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes{
    public static void main(String[] args) {
        Solution solution = new ShortestPathVisitingAllNodes().new Solution();
        System.out.println(1 << 1);
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 0) return 0;

        return bfs(graph);
    }

    private int bfs(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }
}

class GraphNode {
    public int number;
    public int mask;
    public int distance;

    public GraphNode(int number, int mask, int distance) {
        this.number = number;
        this.mask = mask;
        this.distance = distance;
    }

    @Override
    public String toString() {
        String res = "graphNode{ ";

        res += "number = " + number + " ";
        res += "mask = " + mask + " ";
        res += "distance = " + distance + " ";
        res += " }";

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}