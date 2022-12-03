fun main() {
    fun part1(input: List<String>): Int {

        var priorities = 0
        for (line in input) {
            val first = line.substring(0..line.length/2 - 1)
            //println(first)
            val second = line.substring(line.length/2  ..line.length - 1)
            //println(second)
            for (char in first) {
                if (char in second) {
                    //println(char)
                    if (char.isLowerCase()) {
                        priorities += char.minus('a') + 1
                    } else {
                        priorities += char.minus('A') + 27
                        //println(char.minus('A') + 27)
                    }
                    break
                    //println(priorities)
                }
            }
            //println(priorities)
        }
        //print(priorities)
        return priorities
    }

    fun part2(input: List<String>): Int {
        var priorities = 0
        for (index in 0..input.size - 1 step 3) {
            for (char in input[index]) {
                if (char in input[index + 1] && char in input[index + 2]) {
                    if (char.isLowerCase()) {
                        priorities += char.minus('a') + 1
                    } else {
                        priorities += char.minus('A') + 27
                        //println(char.minus('A') + 27)
                    }
                    break
                }
            }
        }
        //println(priorities)
        return priorities
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
