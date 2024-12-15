import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        int [][] classes={{1,2},{3,5},{2,2}};
        int extraStudents=2;
        MaximumAveragePassRatio soln = new MaximumAveragePassRatio();
        System.out.println(soln.maxAverageRatio(classes, extraStudents));
    }
    
     public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double totalSum = 0.0;

        for (int[] cls : classes) {
            int passed = cls[0], total = cls[1];
            double currRatio = (double) passed / total;
            double diff = ((double) (passed + 1) / (total + 1)) - currRatio;
            totalSum += currRatio;
            pq.offer(new double[]{diff, passed, total});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            double diff = top[0];
            int passed = (int) top[1];
            int total = (int) top[2];

            totalSum -= (double) passed / total;
            passed++;
            total++;
            totalSum += (double) passed / total;

            double newDiff = ((double) (passed + 1) / (total + 1)) - ((double) passed / total);
            pq.offer(new double[]{newDiff, passed, total});
        }

        return totalSum / classes.length;
    }
}
