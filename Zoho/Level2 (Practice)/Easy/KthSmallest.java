import java.util.*;

public class KthSmallest {
    public static void main(String[] args) {
        int arr[] = {4, 5, 3, 1, 2};
        int arr2[] = {};
        int arr3[] = {5, 5, 5};
        int arr4[] = {5, 5, 4};

        System.out.println(findKthSmallest(arr, 2));  // 2nd smallest → 2
        System.out.println(findKthSmallest(arr, 3));  // 3rd smallest → 3
        System.out.println(findKthSmallest(arr2, 1)); // invalid → -1
        System.out.println(findKthSmallest(arr3, 2)); // duplicates → 5
        System.out.println(findKthSmallest(arr4, 2)); // 2nd smallest → 5
    }

    public static int findKthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) return -1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest
            }
        }

        return maxHeap.peek(); // root of maxHeap is kth smallest
    }
}
