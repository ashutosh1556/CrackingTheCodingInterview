package arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) System.out.print(num + " ");
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums2 == null || m < 0 || n < 0) {
            throw new IllegalArgumentException();
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}

