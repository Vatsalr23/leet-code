package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics

/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

// Dummy class
open class VersionControl {
    fun isBadVersion(version: Int): Boolean {
        if (version == 0) {
            return false
        }
        return true
    }

    open fun firstBadVersion(n: Int) : Int {
        return 0
    }
}

@Topics([Topic.BST])
@LeetCodeUrl("https://leetcode.com/problems/first-bad-version/")
class FirstBadVersion: VersionControl() {

    override fun firstBadVersion(n: Int): Int {
        if (isBadVersion(1)) return 1

        var start = 1
        var end = n

        while (end >= start) {
            val mid = start + (end - start)/2
            val isMidBadVersion = isBadVersion(mid)
            if (!isMidBadVersion && isBadVersion(mid + 1)) {
                return mid + 1
            }

            if (isMidBadVersion) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return 1
    }
}
