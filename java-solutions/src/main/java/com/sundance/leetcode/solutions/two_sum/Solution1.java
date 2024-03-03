package com.sundance.leetcode.solutions.two_sum;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int sec = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == sec) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
