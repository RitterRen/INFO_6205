//There is an undirected graph with n nodes numbered from 0 to n - 1 (inclusive)
//. You are given a 0-indexed integer array values where values[i] is the value 
//of the iᵗʰ node. You are also given a 0-indexed 2D integer array edges, where 
//each edges[j] = [uj, vj, timej] indicates that there is an undirected edge between 
//the nodes uj and vj, and it takes timej seconds to travel between the two nodes. 
//Finally, you are given an integer maxTime. 
//
// A valid path in the graph is any path that starts at node 0, ends at node 0, 
//and takes at most maxTime seconds to complete. You may visit the same node 
//multiple times. The quality of a valid path is the sum of the values of the unique 
//nodes visited in the path (each node's value is added at most once to the sum). 
//
// Return the maximum quality of a valid path. 
//
// Note: There are at most four edges connected to each node. 
//
// 
// Example 1: 
//
// 
//Input: values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 
//49
//Output: 75
//Explanation:
//One possible path is 0 -> 1 -> 0 -> 3 -> 0. The total time taken is 10 + 10 + 
//10 + 10 = 40 <= 49.
//The nodes visited are 0, 1, and 3, giving a maximal path quality of 0 + 32 + 4
//3 = 75.
// 
//
// Example 2: 
//
// 
//Input: values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 
//30
//Output: 25
//Explanation:
//One possible path is 0 -> 3 -> 0. The total time taken is 10 + 10 = 20 <= 30.
//The nodes visited are 0 and 3, giving a maximal path quality of 5 + 20 = 25.
// 
//
// Example 3: 
//
// 
//Input: values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], 
//maxTime = 50
//Output: 7
//Explanation:
//One possible path is 0 -> 1 -> 3 -> 1 -> 0. The total time taken is 10 + 13 + 
//13 + 10 = 46 <= 50.
//The nodes visited are 0, 1, and 3, giving a maximal path quality of 1 + 2 + 4 
//= 7.
// 
//
// 
// Constraints: 
//
// 
// n == values.length 
// 1 <= n <= 1000 
// 0 <= values[i] <= 10⁸ 
// 0 <= edges.length <= 2000 
// edges[j].length == 3 
// 0 <= uj < vj <= n - 1 
// 10 <= timej, maxTime <= 100 
// All the pairs [uj, vj] are unique. 
// There are at most four edges connected to each node. 
// The graph may not be connected. 
// 
// Related Topics 图 数组 回溯 👍 20 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumPathQualityOfAGraph{
    public static void main(String[] args) {
        Solution solution = new MaximumPathQualityOfAGraph().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, List<int[]>> graph;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        graph = getGraph(edges);

        //we can visit a node multiple times, thus the int[] and not boolean[] type
        int[] visited = new int[values.length];
        int[] max = new int[1];

        dfs(0, 0, 0, max, maxTime, values, visited);

        return max[0];
    }

    private void dfs(int node, int value, int time, int[] max, int maxTime, int[] values, int[] visited) {
        if (time > maxTime) {
            return;
        }

        //we add the value only when we visit the node the first time
        if (visited[node] == 0) {
            value += values[node];
        }

        //the valid path ends with 0
        if (node == 0) {
            max[0] = Math.max(max[0], value);
        }

        if (graph.get(node) == null) {
            return;
        }

        visited[node]++;

        for (int[] next : graph.get(node)) {
            int nextTime = time + next[1];
            dfs(next[0], value, nextTime, max, maxTime, values, visited);
        }

        visited[node]--;
    }

    private Map<Integer, List<int[]>> getGraph(int[][] edges) {
        Map<Integer, List<int[]>> result = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            result.putIfAbsent(from, new ArrayList<>());
            result.putIfAbsent(to, new ArrayList<>());
            result.get(from).add(new int[] {to, time});
            result.get(to).add(new int[] {from, time});
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}