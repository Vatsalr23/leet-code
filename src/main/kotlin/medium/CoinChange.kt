package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.DYNAMIC_PROGRAMMING, Topic.TOP_DOWN])
@LeetCodeUrl("https://leetcode.com/problems/coin-change/")
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = mutableMapOf<Int, Int>()
        coinChange(coins, amount, memo)
        return checkNotNull(memo[amount])
    }

    fun coinChange(coins: IntArray, amount: Int, memo: MutableMap<Int, Int>): Int {
        if (memo.containsKey(amount)) {
            return checkNotNull(memo[amount])
        }
        if (amount == 0) {
            return 0
        } else if (amount < 0) {
            return -1
        }

        var minCoins = Int.MAX_VALUE
        for (i in coins.indices) {
            val coin = coins[i]
            val coinsUsedResult = coinChange(coins, amount - coin, memo)
            if (coinsUsedResult == -1) continue
            minCoins = kotlin.math.min(minCoins, coinsUsedResult + 1)
        }

        if (minCoins == Int.MAX_VALUE) {
            memo[amount] = -1
        } else {
            memo[amount] = minCoins
        }

        return checkNotNull(memo[amount])
    }
}

fun main() {
    CoinChange().coinChange(intArrayOf(1, 2, 5), 11)
}