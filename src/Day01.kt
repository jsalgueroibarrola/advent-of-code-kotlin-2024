fun part1(input: List<String>): Int {
    val (leftList, rightList) = parseInputToLists(input=input)

    val sortedLeft = leftList.sorted()
    val sortedRight = rightList.sorted()

    val result = sortedLeft.mapIndexed { index, left ->
        calculateDifference(left=left, right=sortedRight[index])
    }.sum()

    return result
}

fun part2(input: List<String>): Int {
    val (leftList, rightList) = parseInputToLists(input=input)

    val frequencyMap = mutableMapOf<Int, Int>()
    rightList.forEach { right ->
        frequencyMap[right] = frequencyMap.getOrDefault(right, 0) + 1
    }

    val result = leftList.sumOf { left ->
        left * frequencyMap.getOrDefault(left, 0)
    }
    return result
}

private fun parseInputToLists(input: List<String>): Pair<List<Int>, List<Int>> {
    return input
        .map {
            val parts = it.split("\\s+".toRegex())
            parts[0].toInt() to parts[1].toInt()
        }.unzip()
}

fun calculateDifference(left: Int, right: Int): Int{
    if(left > right){
        return left - right
    }
    return right - left
}

fun main() {
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}