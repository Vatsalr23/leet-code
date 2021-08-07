package hard

// INCOMPLETE
class JumpGameIV {
    fun minJumps(arr: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val visited = BooleanArray(arr.size) { false }
        for (i in arr.indices) {
            if (!map.containsKey(arr[i])) {
                map[arr[i]] = mutableListOf<Int>(i)
            } else {
                map[arr[i]]!!.add(i)
            }
        }
        println(map)

        val jumps = minJumps(arr, map, visited, 0)
        println(visited.toList())
        return if (jumps == Int.MAX_VALUE) -1 else jumps
    }

    fun minJumps(arr: IntArray, map: Map<Int, List<Int>>, visited: BooleanArray, startIndex: Int): Int {
        if (startIndex < 0 || startIndex > arr.size - 1 || visited[startIndex]) return Int.MAX_VALUE - 10000
        if (startIndex == arr.size - 1) return 0

        visited[startIndex] = true
        val sameValueIndices = map[arr[startIndex]]!!
        var jumps = Int.MAX_VALUE
        for (i in sameValueIndices.indices) {
            jumps = kotlin.math.min(minJumps(arr, map, visited, sameValueIndices[i]) + 1, jumps)
        }
        jumps = kotlin.math.min(jumps, minJumps(arr, map, visited, startIndex + 1) + 1)
        jumps = kotlin.math.min(jumps, minJumps(arr, map, visited, startIndex - 1) + 1)
        return jumps
    }
}

fun main() {
//    JumpGameIV().minJumps(intArrayOf(100,-23,-23,404,100,23,23,23,3,404))
    val map = MyClass<Int, Int>(2)

    map.put(1, 1)
    map.put(2, 4)

    map.get(1)

    map.put(3, 3)
    println(map.toMap())
}

class MyClass<K, V>: LinkedHashMap<K, V> {

    val capacity: Int

    constructor(capacity: Int): super() {
        this.capacity = capacity
    }

    override fun get(key: K): V? {
        val value = super.remove(key)
        if (value != null) {
            super.put(key, value)
        }
        return value
    }

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return this.capacity < size
    }
}
