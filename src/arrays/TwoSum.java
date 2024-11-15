package arrays;

import org.jetbrains.annotations.NotNull;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 0, 5, 6};
        int target = 10;
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
            System.out.println("Elements: " + nums[result[0]] + ", " + nums[result[1]]);
        } else {
            System.out.println("No solution found.");
        }
    }

    static int @NotNull [] twoSum(int @NotNull [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] a = {i, j};
                    return a;
                }
            }
        }
    }
}
