fun main() {
    fun part1(input: List<String>): String {
        var numStacks = 0
        for (line in input) {
            if (line[1] == '1') {
                numStacks = (line.length) / 4
                break
            }
        }
        //print(input)
        val stacks = MutableList(numStacks){(mutableListOf<Char>())}

        for (i in 0 until numStacks)
            stacks.add(mutableListOf<Char>())
        for (line in input) {
            if (line != "" && line[line.length-1] == ']') {
                for (index in 1 until line.length - 1 step 4) {
                    if (line[index] != ' ') {
                        (stacks[index / 4]).add(line[index])
                    }
                }
            }
            else if (line.startsWith("move")) {
                //println(stacks)
                val parts = line.split(" ")
                val numItems = parts[1].toInt()
                val startStack = parts[3].toInt() - 1
                val endStack = parts[5].toInt() - 1
                //println("$numItems , $startStack, $endStack")
                for (i in 0 until numItems) {
                    val removed = (stacks[startStack]).removeFirstOrNull()
                    if (removed != null) {
                        (stacks[endStack]).add(0,removed)
                    }

                }

            }
        }
        //println(stacks)
        var result = ""
        for (i in 0 .. numStacks) {
            result += stacks[i].firstOrNull()
        }
        //println(result)
        return result
    }

    fun part2(input: List<String>): String {
        var numStacks = 0
        for (line in input) {
            if (line[1] == '1') {
                numStacks = (line.length) / 4
                break
            }
        }
        //print(input)
        val stacks = MutableList(numStacks){(mutableListOf<Char>())}

        for (i in 0 until numStacks)
            stacks.add(mutableListOf<Char>())
        for (line in input) {
            if (line != "" && line[line.length-1] == ']') {
                for (index in 1 until line.length - 1 step 4) {
                    if (line[index] != ' ') {
                        (stacks[index / 4]).add(line[index])
                    }
                }
            }
            else if (line.startsWith("move")) {
                //println(stacks)
                val parts = line.split(" ")
                val numItems = parts[1].toInt()
                val startStack = parts[3].toInt() - 1
                val endStack = parts[5].toInt() - 1
                //println("$numItems , $startStack, $endStack")
                for (i in 0 until numItems) {
                    val removed = (stacks[startStack]).removeFirstOrNull()
                    if (removed != null) {
                        (stacks[endStack]).add(i, removed)
                    }

                }

            }
        }
        //println(stacks)
        var result = ""
        for (i in 0 .. numStacks) {
            result += stacks[i].firstOrNull()
        }
        //println(result)
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}