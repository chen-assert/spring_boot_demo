package com.chenjr.demo.test

import kotlin.random.Random

fun main() {
    class Solution {
        fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
            fun my_sum(a: Int, b: Int): Int {
                var r = 0
                for (i in a..b) {
                    r += nums[i]
                }
                return r
            }
            //val save = Array(nums.size) { IntArray(nums.size) }
            val save2 = IntArray(nums.size)
            val mymap = HashMap<Int, Int>()
            save2[0] = nums[0]
            var divide_k = { n: Int -> if (k != 0) n % k else n }
            mymap[0] = -1
            if (!mymap.containsKey(divide_k(save2[0]))) mymap[divide_k(save2[0])] = 0
            for (i in 1 until nums.size) {
                save2[i] = save2[i - 1] + nums[i]
                if (mymap.containsKey(divide_k(save2[i]))) {
                    if (mymap[divide_k(save2[i])] != i - 1) return true
                } else mymap[divide_k(save2[i])] = i
            }
            return false
            fun my_sum2(a: Int, b: Int): Int {
                return save2[b] - save2[a] + nums[a]
//                if (a == b - 1) {
//                    save[a][b] = nums[a] + nums[b]
//                    return save[a][b]
//                } else {
//                    save[a][b] = save[a][b - 1] + nums[b]
//                    return save[a][b]
//                }
            }
            for (i in 0 until (nums.size - 1)) {
                for (j in (i + 1) until nums.size) {
                    var sum = my_sum2(i, j)
                    if ((k == 0 && sum == k) || (k != 0 && sum % k == 0)) return true
                }
            }
            return false
        }
    }
    //println(Solution().checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 0))
    println(Solution().checkSubarraySum(intArrayOf(0, 1, 0), 0))
    println(Solution().checkSubarraySum(intArrayOf(1, 0), 2))
    println(Solution().checkSubarraySum(intArrayOf(0, 0), 0))
    println(Solution().checkSubarraySum(intArrayOf(5, 0, 0), 0))
    for(i in 1..200){
        print(Random.nextInt(99)+1)
    }
}