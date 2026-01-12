/**
 * Problem: Kth Largest Element in a Stream (NeetCode - Medium)
 * Author: Steve Eckardt
 * Revision Date: January 12, 2026
 * Description: Maintains the kth largest element in a dynamic stream using a min-heap or a sorted list.
 * Time Complexity: Heap version: O(log k) per insertion. List version: O(n log n) per insertion.
 * Space Complexity: Heap version: O(k). List version: O(n).
 */

class KthLargest {
    private int k;
    private PriorityQueue<Integer> que;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.que = new PriorityQueue<>(); // Min-heap

        // Add initial values
        for (int n : nums)
            que.offer(n);

        // Keep only k largest elements
        while (que.size() > k)
            que.poll();
    }
    
    public int add(int val) {
        que.offer(val);              // Insert new value
        if (que.size() > this.k)
            que.poll();              // Remove smallest to maintain size k

        return que.peek();           // Root is kth largest
    }
}

class KthLargest2 {
    private int k;
    private List<Integer> list;

    // Constructor-style initializer
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();

        // Store all initial values
        for (int n : nums)
            list.add(n);
    }
    
    public int add(int val) {
        list.add(val);               // Add new value
        Collections.sort(list);      // Sort entire list
        return list.get(list.size() - k); // Return kth largest
    }
}
