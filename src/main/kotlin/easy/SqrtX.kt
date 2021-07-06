package easy

class SqrtX {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x
        return search(x)
    }

    private fun search(x: Int): Int {
        var start = 0
        var end = x

        while (start <= end) {
            val mid = start + (end - start) / 2 // Equivalent to (start + end) / 2. This way we avoid Int overflow.
            val target = mid.toLong() * mid.toLong() // Convert to long to avoid overflow.
            if (target == x.toLong()) return mid

            if (x < target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return end
    }
}
