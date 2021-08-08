package medium

open class Relation {
    open fun findCelebrity(n: Int): Int {
        TODO()
    }

    fun knows(a: Int, b: Int): Boolean {
        TODO()
    }
}

class FindTheCelebrity: Relation() {
    override fun findCelebrity(n: Int) : Int {
        for (a in 0 until n) {
            var isCelebrity = true
            for (b in 0 until n) {
                if (a == b) continue
                if (!knows(b, a) || knows(a, b)) {
                    isCelebrity = false
                    break
                }
            }
            if (isCelebrity) return a
        }

        return -1
    }
}
