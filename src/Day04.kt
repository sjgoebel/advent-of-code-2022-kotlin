fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val (a, b) = line.split(',')
            val (c, d) = a.split("-").map(String::toInt)
            val (e, f) = b.split("-").map(String::toInt)
            if ((e >= c && f <= d) || (c >= e) && (d <= f)) {
                count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val (a, b) = line.split(',')
            val (c, d) = a.split("-").map(String::toInt)
            val (e, f) = b.split("-").map(String::toInt)
            if ((e in c..d) || c in e..f || f in c .. d || d in e .. f) {
                count++
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}