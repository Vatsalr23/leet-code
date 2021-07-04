package medium

import common.LeetCodeUrl
import common.Topic.*
import common.Topics

@Topics([MATH, SORTING])
@LeetCodeUrl("https://leetcode.com/problems/car-fleet/")
class CarFleet {

    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        // When there are 0 or 1 car(s) then simply return the count.
        if (speed.size <= 1) return speed.size

        // Before sorting the position to iterate in the correct order, save speed for each position
        // We can assume each position is unique because cars can't be in the same position.
        val positionToSpeedMap: Map<Int, Int> = position.zip(speed).toMap()
        var carFleets = 1

        // Sort positions
        position.sort()

        // Iterate from 2nd to last car down to the first car.
        for (i in (position.size - 2) downTo 0) {
            val timeToTargetFrontCar = calculateTime(target, position, positionToSpeedMap, i+1)
            val timeToTargetCurrentCar = calculateTime(target, position, positionToSpeedMap, i)

            // If front car is taking more/equal time to reach target then we can assume the current car is going to
            // join the front car to form a fleet. Therefore update current car's position to the car in front to help
            // cascade and form fleets as we loop backwards.
            if (timeToTargetCurrentCar <= timeToTargetFrontCar) {
                position[i] = position[i+1]
            } else {
                // If current car is not going to catch up that means it's the start of another car fleet.
                carFleets += 1
            }
        }

        return carFleets
    }

    // Time to reach target = Distance to target / Speed
    private fun calculateTime(target: Int, position: IntArray, map: Map<Int, Int>, carPositionIndex: Int): Double {
        return ((target - position[carPositionIndex] + 0.0))/(map.getValue(position[carPositionIndex]))
    }
}