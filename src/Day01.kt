fun main() {
    fun part1(input: List<String>): Int {
        var nums = mutableListOf<Int>()
        var sum = 0
        for (s in input) {
            if (s != "") {
                sum += Integer.parseInt(s)
            } else {
                nums.add(sum)
                sum = 0
            }
        }
        nums.add(sum)
        //print(nums)
        return nums.max()
    }

    fun part2(input: List<String>): Int {
        var nums = mutableListOf<Int>()
        var sum = 0
        for (s in input) {
            if (s != "") {
                sum += Integer.parseInt(s)
            } else {
                nums.add(sum)
                sum = 0
            }
        }
        nums.add(sum)

        var result = 0
        for (item in 1..3) {
            result += nums.max()
            nums.remove(nums.max())
        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
