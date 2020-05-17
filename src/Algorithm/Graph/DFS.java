package Algorithm.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DFS{
    //有向无环非负数
    /*@param 输入: [[1,2], [3], [3], []] 输出: [[0,1,3],[0,2,3]]
     */

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            return solve(graph, 0);
        }

        public List<List<Integer>> solve(int[][] graph, int node) {
            int N = graph.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (node == N - 1) {
                List<Integer> path = new ArrayList<>();
                path.add(N-1);
                ans.add(path);
                return ans;
            }

            for (int nei: graph[node]) {
                for (List<Integer> path: solve(graph, nei)) {
                    path.add(0, node);
                    ans.add(path);
                }
            }
            return ans;
        }

    /*
     * Return true if there is a path from cur to target.
     */
    /*
    boolean DFS(Node cur, Node target, Set<Node> visited) {
        return true if cur is target;
        for (next : each neighbor of cur) {
            if (next is not in visited) {
                add next to visted;
                return true if Training.DFS(next, target, visited) == true;
            }
        }
        return false;
    }

     */

    /*
     * Return true if there is a path from cur to target.
     */
    /*
    boolean DFS(int root, int target) {
        Set<Node> visited;
        Stack<Node> s;
        add root to s;
        while (s is not empty) {
            Node cur = the top element in s;
            return true if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in visited) {
                    add next to s;
                    add next to visited;
                }
            }
            remove cur from s;
        }
        return false;
    }
    */
}

