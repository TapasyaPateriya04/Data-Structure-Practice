import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfKDivisibleComponents {

    public static void main(String[] args) {
        MaximumNumberOfKDivisibleComponents maximumNumberOfKDivisibleComponents = new MaximumNumberOfKDivisibleComponents();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        int[] vals = {1, 2, 3, 4, 5, 6};
        int k = 3;
        System.out.println(maximumNumberOfKDivisibleComponents.maxKDivisibleComponents(n, edges, vals, k));
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {
        if (n < 2) return 1;
        if (k == 0) throw new IllegalArgumentException("k cannot be zero");

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] deg = new int[n];

        for (int[] edge : edges) {
            if (edge[0] >= n || edge[1] >= n) throw new IllegalArgumentException("Invalid edge");
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }

        long[] nodeValues = new long[n];
        for (int i = 0; i < n; i++) nodeValues[i] = vals[i];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) if (deg[i] == 1) queue.add(i);

        int componentCount = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            deg[current]--;
            long carry = 0;

            if (nodeValues[current] % k == 0) componentCount++;
            else carry = nodeValues[current];

            for (int neighbor : graph.get(current)) {
                if (deg[neighbor] == 0) continue;
                deg[neighbor]--;
                nodeValues[neighbor] += carry;
                if (deg[neighbor] == 1) queue.add(neighbor);
            }
        }
        return componentCount;
    }
}