package com.chenjr.demo.test;

import java.util.Arrays;

class Solution {
    int iter = 0;

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        return canPartition(nums, nums.length - 1, sum, sum);
    }

    private boolean canPartition(int[] nums, int idx, int had, int pass) {
        System.out.println(iter++);
        if (had == 0 || pass == 0) {
            return true;
        } else if (had < 0 || pass < 0) {
            return false;
        } else {
            return canPartition(nums, idx - 1, had - nums[idx], pass) || canPartition(nums, idx - 1, had, pass - nums[idx]);
        }
    }
}