fun main() {
    fun part1(input: List<String>): Int {
        val gridsize = input.size
        val array = Array(input.size) { IntArray(input.size)}
        for (i in input.indices) {
            for (j in input[i].indices) {
                array[i][j] = input[i].substring(j until j + 1).toInt()
            }
        }
        val visible = mutableSetOf<Pair<Int, Int>>()
        for (i in 1 until array.size - 1) {
            var curmaxleft = array[i][0]
            val farright = gridsize - 1
            var curmaxright = array[i][farright]
            for (j in 1 until array[i].size - 1) {

                if (array[i][j] > curmaxleft) {
                    println("${array[i][j]} is current val at $i , $j and max is $curmaxleft")
                    visible.add(Pair(i,j))
                    curmaxleft = array[i][j]
                }
                if (array[i][farright - j] > curmaxright) {
                    visible.add(Pair(i,farright - j))
                    curmaxright = array[i][farright - j]
                }
            }
        }

        for (j in 1 until gridsize - 1) {
            var curmaxtop = array[0][j]
            val bottom = gridsize - 1
            var curmaxbot = array[bottom][j]
            for (i in 1 until gridsize - 1) {
                if (array[i][j] > curmaxtop) {
                    println("${array[i][j]} is current val at $i , $j and max is $curmaxtop")
                    visible.add(Pair(i,j))
                    curmaxtop = array[i][j]
                }
                if (array[bottom - i][j] > curmaxbot) {
                    visible.add(Pair(bottom - i,j))
                    curmaxbot = array[bottom - i][j]
                }
            }
        }
        //println(visible)
        //println(visible.size + (2 * array.size) + (2 * (array[0].size - 2)))
            return visible.size + (2 * array.size) + (2 * (array[0].size - 2))
    }

    fun part2(input: List<String>): Int {
        val gridsize = input.size
        val array = Array(input.size) { IntArray(input.size)}
        for (i in input.indices) {
            for (j in input[i].indices) {
                array[i][j] = input[i].substring(j until j + 1).toInt()
            }
        }
        val visible = mutableSetOf<Pair<Int, Int>>()
        for (i in 1 until array.size - 1) {
            var curmaxleft = array[i][0]
            val farright = gridsize - 1
            var curmaxright = array[i][farright]
            for (j in 1 until array[i].size - 1) {

                if (array[i][j] > curmaxleft) {
                    //println("${array[i][j]} is current val at $i , $j and max is $curmaxleft")
                    visible.add(Pair(i,j))
                    curmaxleft = array[i][j]
                }
                if (array[i][farright - j] > curmaxright) {
                    visible.add(Pair(i,farright - j))
                    curmaxright = array[i][farright - j]
                }
            }
        }

        for (j in 1 until gridsize - 1) {
            var curmaxtop = array[0][j]
            val bottom = gridsize - 1
            var curmaxbot = array[bottom][j]
            for (i in 1 until gridsize - 1) {
                if (array[i][j] > curmaxtop) {
                    //println("${array[i][j]} is current val at $i , $j and max is $curmaxtop")
                    visible.add(Pair(i,j))
                    curmaxtop = array[i][j]
                }
                if (array[bottom - i][j] > curmaxbot) {
                    visible.add(Pair(bottom - i,j))
                    curmaxbot = array[bottom - i][j]
                }
            }
        }
        //println(visible)
        //println(visible.size + (2 * array.size) + (2 * (array[0].size - 2)))
        var maxScore = 0
        for (point in visible) {
            var downscore = 1
            val curTreeHeight = array[point.first][point.second]
            val i = point.first
            val j = point.second
            var add = 1
            while (i + add < gridsize && array[i + add][j] < curTreeHeight) {
                downscore++
                add++
                if (i + add == gridsize - 1) {
                    downscore--
                }
            }
            var upscore = 1
            add = 1
            while (i - add > -1 && array[i - add][j] < curTreeHeight) {
                upscore++
                add++
                if (i - add == 0) {
                    upscore--
                }
            }
            var rightscore = 1
            add = 1
            while (j + add < gridsize && array[i][j + add] < curTreeHeight) {
                rightscore++
                add++
                if (j + add == gridsize - 1) {
                    rightscore--
                }
            }
            var leftscore = 1
            add = 1
            while (j - add > -1 && array[i][j - add] < curTreeHeight) {
                leftscore++
                add++
                if (j - add == 0) {
                    leftscore--
                }
            }
            val thisTreeScore = upscore * rightscore * downscore * leftscore
            if (thisTreeScore > maxScore) {
                maxScore = thisTreeScore
                println("new max at $i , $j with upscore: $upscore down: $downscore left: $leftscore right: $rightscore")
            }
        }
        println(maxScore)
        return maxScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 21)
    check(part2(testInput) == 8)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}