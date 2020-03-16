package com.chenjr.demo.test

import java.util.*
import kotlin.collections.HashMap

fun main() {
    class step_class(var step: Int, var word: String, var list: LinkedList<String>) : Comparable<step_class> {
        override fun compareTo(other: step_class): Int {
            return this.step.compareTo(other.step)
        }
    }

    class map_class(var step: Int, var list_list: LinkedList<LinkedList<String>>) : Comparable<step_class> {
        override fun compareTo(other: step_class): Int {
            return this.step.compareTo(other.step)
        }
    }

    fun str_compare(a: String, b: String): Boolean {
        var s = 0
        for (i in a.indices) {
            if (a[i] != b[i]) s++
            if (s == 2) break
        }
        return s == 1
    }

    class Solution {
        fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
            val wordDict: HashMap<String, Boolean> = HashMap()
            for (word: String in wordList) {
                wordDict[word] = true
            }
            val r_sum = LinkedList<List<String>>()
            if (endWord !in wordDict) return r_sum
            var start_min_step = Int.MAX_VALUE
            var end_min_step = Int.MAX_VALUE
            val start_list = LinkedList<String>()
            start_list.add(beginWord)
            val start_step_map = HashMap<String, map_class>()
            val end_step_map = HashMap<String, map_class>()
            val start_pq = PriorityQueue<step_class>()
            start_pq.add(step_class(0, beginWord, start_list))
            val end_list = LinkedList<String>()
            end_list.add(endWord)
            val end_pq = PriorityQueue<step_class>()
            end_pq.add(step_class(0, endWord, end_list))
            run {
                var type: Boolean = true
                loop@ while (!start_pq.isEmpty() || !end_pq.isEmpty()) {
                    if (end_pq.isEmpty()) {
                        type = true
                    } else if (start_pq.isEmpty()) {
                        type = false
                    } else type = start_pq.peek().step <= end_pq.peek().step
                    when (type) {
                        true -> {
                            val poll = start_pq.poll()
                            if (poll.step > start_min_step) continue@loop
                            if (poll.word in end_step_map) {
                                start_min_step = poll.step
                                end_min_step = end_step_map[poll.word]!!.step
                                for (list in end_step_map[poll.word]!!.list_list) {
                                    val linkedList = poll.list.clone() as LinkedList<String>
                                    linkedList.removeLast()
                                    linkedList.addAll(list)
                                    r_sum.add(linkedList)
                                }
                                continue@loop
                            }
                            if (poll.word in start_step_map) {
                                if (start_step_map[poll.word]!!.step < poll.step) {
                                    continue@loop
                                } else {
                                    start_step_map[poll.word]!!.list_list.add(poll.list)
                                }
                            } else {
                                val mapClass = map_class(poll.step, LinkedList())
                                start_step_map[poll.word] = mapClass
                                start_step_map[poll.word]!!.list_list.add(poll.list)
                            }
                            wordDict.remove(poll.word)
                            for (word_in_list in wordDict) {
                                if (str_compare(word_in_list.key, poll.word)) {
                                    val new_list = poll.list.clone() as LinkedList<String>
                                    new_list.add(word_in_list.key)
                                    start_pq.add(step_class(poll.step + 1, word_in_list.key, new_list))
                                }
                            }
                        }
                        false -> {
                            val poll = end_pq.poll()
                            if (poll.step > end_min_step) continue@loop
                            if (poll.word in start_step_map) {
                                start_min_step = start_step_map[poll.word]!!.step
                                end_min_step = poll.step
                                for (list in start_step_map[poll.word]!!.list_list) {
                                    val linkedList = list.clone() as LinkedList<String>
                                    linkedList.removeLast()
                                    linkedList.addAll(poll.list)
                                    r_sum.add(linkedList)
                                }
                                continue@loop
                            }
                            if (poll.word in end_step_map) {
                                if (end_step_map[poll.word]!!.step < poll.step) {
                                    continue@loop
                                } else {
                                    end_step_map[poll.word]!!.list_list.add(poll.list)
                                }
                            } else {
                                val mapClass = map_class(poll.step, LinkedList())
                                end_step_map[poll.word] = mapClass
                                end_step_map[poll.word]!!.list_list.add(poll.list)
                            }
                            wordDict.remove(poll.word)
                            for (word_in_list in wordDict) {
                                if (str_compare(word_in_list.key, poll.word)) {
                                    val new_list = poll.list.clone() as LinkedList<String>
                                    new_list.add(0, word_in_list.key)
                                    end_pq.add(step_class(poll.step + 1, word_in_list.key, new_list))
                                }
                            }
                        }
                    }
                }
            };
            return r_sum
        }
    }

    println(Solution().findLadders(beginWord = "red", endWord = "tax", wordList = listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")))
    println(Solution().findLadders(beginWord = "lost", endWord = "cost", wordList = listOf("most", "fist", "lost", "cost", "fish")))
    //println(Solution().findLadders(beginWord = "magic", endWord = "pearl", wordList = listOf("flail", "halon", "lexus", "joint", "pears", "slabs", "lorie", "lapse", "wroth", "yalow", "swear", "cavil", "piety", "yogis", "dhaka", "laxer", "tatum", "provo", "truss", "tends", "deana", "dried", "hutch", "basho", "flyby", "miler", "fries", "floes", "lingo", "wider", "scary", "marks", "perry", "igloo", "melts", "lanny", "satan", "foamy", "perks", "denim", "plugs", "cloak", "cyril", "women", "issue", "rocky", "marry", "trash", "merry", "topic", "hicks", "dicky", "prado", "casio", "lapel", "diane", "serer", "paige", "parry", "elope", "balds", "dated", "copra", "earth", "marty", "slake", "balms", "daryl", "loves", "civet", "sweat", "daley", "touch", "maria", "dacca", "muggy", "chore", "felix", "ogled", "acids", "terse", "cults", "darla", "snubs", "boats", "recta", "cohan", "purse", "joist", "grosz", "sheri", "steam", "manic", "luisa", "gluts", "spits", "boxer", "abner", "cooke", "scowl", "kenya", "hasps", "roger", "edwin", "black", "terns", "folks", "demur", "dingo", "party", "brian", "numbs", "forgo", "gunny", "waled", "bucks", "titan", "ruffs", "pizza", "ravel", "poole", "suits", "stoic", "segre", "white", "lemur", "belts", "scums", "parks", "gusts", "ozark", "umped", "heard", "lorna", "emile", "orbit", "onset", "cruet", "amiss", "fumed", "gelds", "italy", "rakes", "loxed", "kilts", "mania", "tombs", "gaped", "merge", "molar", "smith", "tangs", "misty", "wefts", "yawns", "smile", "scuff", "width", "paris", "coded", "sodom", "shits", "benny", "pudgy", "mayer", "peary", "curve", "tulsa", "ramos", "thick", "dogie", "gourd", "strop", "ahmad", "clove", "tract", "calyx", "maris", "wants", "lipid", "pearl", "maybe", "banjo", "south", "blend", "diana", "lanai", "waged", "shari", "magic", "duchy", "decca", "wried", "maine", "nutty", "turns", "satyr", "holds", "finks", "twits", "peaks", "teems", "peace", "melon", "czars", "robby", "tabby", "shove", "minty", "marta", "dregs", "lacks", "casts", "aruba", "stall", "nurse", "jewry", "knuth")))
}