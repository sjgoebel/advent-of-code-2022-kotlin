fun main() {
    fun part1(input: List<String>): Int {
        val signal = input[0]
        for (i in signal.indices) {
            val chars = signal.substring(i until i + 4).toCharArray().toSet()
            //println(chars)
            if (chars.size == 4) {
                //println(i)
                return i + 4
            }
        }

        return input.size
    }

    fun part2(input: List<String>): Int {
        val signal = input[0]
        for (i in signal.indices) {
            val chars = signal.substring(i until i + 14).toCharArray().toSet()
            //println(chars)
            if (chars.size == 14) {
                //println(i)
                return i + 14
            }
        }
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 10)
    check(part2(testInput) == 29)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}