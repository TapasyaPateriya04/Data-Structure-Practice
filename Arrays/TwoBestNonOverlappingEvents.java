import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        TwoBestNonOverlappingEvents soln = new TwoBestNonOverlappingEvents();
        System.out.println(soln.maxTwoEvents(arr));
    }  

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int eventCount = events.length;
        int[] maxEventValues = new int[eventCount];
        maxEventValues[0] = events[0][2];

        for (int i = 1; i < eventCount; i++) {
            maxEventValues[i] = Math.max(maxEventValues[i - 1], events[i][2]);
        }

        int maxTotal = 0;

        for (int i = 0; i < eventCount; i++) {
            int eventStart = events[i][0];
            int eventValue = events[i][2];

            int latestIndex = findLatestEvent(events, eventStart - 1);

            int currentTotal = eventValue;
            if (latestIndex != -1) {
                currentTotal += maxEventValues[latestIndex];
            }

            maxTotal = Math.max(maxTotal, currentTotal);
        }

        return maxTotal;
    }

    private int findLatestEvent(int[][] events, int targetTime) {
        int left = 0, right = events.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] <= targetTime) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
