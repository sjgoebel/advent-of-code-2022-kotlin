fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("DayXX_test")
    check(part1(testInput) == testInput.size)
    check(part2(testInput) == testInput.size)

    val input = readInput("DayXX")
    println(part1(input))
    println(part2(input))
}