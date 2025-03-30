public class SortKElem {
    public static void main(String[] args) {
        int arr[] = {2,1,3,5,8,6,7,9};
        int k = 3;
        int n = arr.length;

        System.out.println("K value: " + k);

        for (int start = 0; start < n; start += k) {
            int left = start;
            int right = Math.min(start + k - 1, n - 1); // Ensure right index does not exceed array bounds
            
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
