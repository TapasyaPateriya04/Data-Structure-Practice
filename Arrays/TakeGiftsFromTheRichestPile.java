import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {

    public static void main(String[] args) {
        int [] gifts={25,64,9,4,100};
        int k=4;
        TakeGiftsFromTheRichestPile soln=new TakeGiftsFromTheRichestPile();
        System.out.println(soln.pickGifts(gifts, k));
        
    }
    

    public long pickGifts(int[] g, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : g)
            pq.add(gift);

        for (int i = 0; i < k && pq.peek() > 1; i++) {
            int cur = pq.poll();
            pq.add((int) Math.sqrt(cur));
        }

        long total = 0;
        for (int gift : pq)
            total += gift;

        return total;
    }
}
