package com.chenjr.demo.test

import java.util.*
import kotlin.math.abs

fun main() {
    class Solution {
        fun threeSumClosest(nums: List<Int>, target: Int): Int {
            var dev = Int.MAX_VALUE
            var r_sum = 0
            //nums.sort()
            for (i in 0 until nums.size - 2) {
                for(j in i+1 until nums.size-1){
                    for(k in j+1 until nums.size){
                        var sum = nums[i] + nums[j] + nums[k]
                        if (abs(sum - target) < dev) {
                            dev = abs(sum - target)
                            r_sum = sum
                        }
                    }
                }
            }
            return r_sum
        }
    }
    var a=LinkedList<Int>()
    for(i in 1..1000){
        a.add(Random().nextInt())
    }
    println(
    Solution().threeSumClosest(a,5000)
    )
}