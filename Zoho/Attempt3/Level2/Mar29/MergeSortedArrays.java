import java.util.ArrayList;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int A[] = {2, 3, 56, 78, 90};
        int B[] = {4, 4, 4, 56, 56, 78, 90, 90};

        ArrayList<Integer> C = new ArrayList<>();
        int i = 0, j = 0;

        // Ensure both arrays are sorted in ascending order
        if (A.length > 1 && A[0] > A[A.length - 1]) {
            reverse(A);
        }
        if (B.length > 1 && B[0] > B[B.length - 1]) {
            reverse(B);
        }

        // Merge while removing duplicates
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                addIfNotDuplicate(C, A[i]);
                i++;
            } else if (A[i] > B[j]) {
                addIfNotDuplicate(C, B[j]);
                j++;
            } else {
                addIfNotDuplicate(C, A[i]);
                i++;
                j++;
            }
        }

        while (i < A.length) {
            addIfNotDuplicate(C, A[i++]);
        }
        while (j < B.length) {
            addIfNotDuplicate(C, B[j++]);
        }

        System.out.println(C);
    }

    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void addIfNotDuplicate(ArrayList<Integer> list, int num) {
        if (list.isEmpty() || list.get(list.size() - 1) != num) {
            list.add(num);
        }
    }
}
