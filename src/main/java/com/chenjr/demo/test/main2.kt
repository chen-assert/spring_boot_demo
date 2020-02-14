package com.chenjr.demo.test

fun main() {
    class Solution {
        fun canPartition(nums: IntArray): Boolean {
            var iter=0
            var presum = IntArray(nums.size)
            presum[0] = nums[0]
            for (i in 1 until nums.size) {
                presum[i] = presum[i - 1] + nums[i]
            }
            var sum = nums.sum()
            if (sum % 2 == 1) return false
            var hsum = sum / 2
            var save = Array<HashMap<Int, Boolean>>(nums.size) { HashMap() }
            fun dfs(p: Int, got: Int): Boolean {
                println(iter++)
                if (got == hsum) return true
                if (got > hsum) return false
                if (p != 0 && sum - presum[p - 1] + got < hsum) return false
                if (p == nums.size || save[p].containsKey(got)) return false
                save[p][got] = true
                return dfs(p + 1, got + nums[p]) || dfs(p + 1, got)
            }
            return dfs(0, 0)
        }
    }
    println(Solution().canPartition(intArrayOf(2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,99,99,99,99,99,99,99,99,99)))
}
