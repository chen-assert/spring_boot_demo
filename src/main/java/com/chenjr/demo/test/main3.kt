package com.chenjr.demo.test

import java.util.*
import kotlin.math.max

fun main() {
    class step_class(var step: Int, var word: String, var list: LinkedList<String>) : Comparable<step_class> {
        override fun compareTo(other: step_class): Int {
            return this.step.compareTo(other.step)
        }
    }

    var a: PriorityQueue<step_class> = PriorityQueue()
    val stepClass = step_class(1, "2", LinkedList())
    a.add(stepClass)
    stepClass.word = "3"
    println(a.peek().word)
    println(max(1,2))
}