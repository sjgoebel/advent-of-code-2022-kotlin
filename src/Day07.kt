fun main() {
    fun part1(input: List<String>): Int {
        val directory = Folder("/", null)
        var current = directory
        for (line in input)
        {
            val commands = line.split(" ")
            if (commands[0] == "$")
            {
                if (commands[1] == "cd") {
                    for (item in current.contents) {
                        if ((item.name == commands[2])) {
                            current = item as Folder
                            break
                        }
                    }
                    if (commands[2] == "..") {
                        if (current.parent != null) {
                            current = current.parent!! as Folder
                        }
                    }
                }
            }
            else
            {
                if (commands[0] == "dir") {
                    current.contents.add(Folder(commands[1], current))
                } else {
                    current.contents.add(File(commands[1], commands[0].toInt(), current))
                }
            }
            //println(current.value)
        }
        //println(directory)
        val sizes = mutableListOf<Int>()

        fun recordFolderSize(item: DirectoryItem): Int {
            if (item is Folder) {
                var total = 0
                for (content in item.contents) {
                    if (content is Folder) {
                        total += recordFolderSize(content)
                    } else {
                        total += content.sizeOf()
                    }
                }
                sizes.add(total)
                return total
            } else {
                return item.sizeOf()
            }
        }
        recordFolderSize(directory)
        //sizes.add(sizes.sum())
        //println(sizes)
        val result = sizes.filter{it <= 100000}.sum()
        //println(result)
        return result
    }

    fun part2(input: List<String>): Int {
        val directory = Folder("/", null)
        var current = directory
        for (line in input)
        {
            val commands = line.split(" ")
            if (commands[0] == "$")
            {
                if (commands[1] == "cd") {
                    for (item in current.contents) {
                        if ((item.name == commands[2])) {
                            current = item as Folder
                            break
                        }
                    }
                    if (commands[2] == "..") {
                        if (current.parent != null) {
                            current = current.parent!! as Folder
                        }
                    }
                }
            }
            else
            {
                if (commands[0] == "dir") {
                    current.contents.add(Folder(commands[1], current))
                } else {
                    current.contents.add(File(commands[1], commands[0].toInt(), current))
                }
            }
            //println(current.value)
        }
        //println(directory)
        val sizes = mutableListOf<Int>()

        fun recordFolderSize(item: DirectoryItem): Int {
            if (item is Folder) {
                var total = 0
                for (content in item.contents) {
                    if (content is Folder) {
                        total += recordFolderSize(content)
                    } else {
                        total += content.sizeOf()
                    }
                }
                sizes.add(total)
                return total
            } else {
                return item.sizeOf()
            }
        }
        recordFolderSize(directory)
        val spaceleft = 70000000 - sizes.last()
        //sizes.add(sizes.sum())
        //println(spaceleft)
        val result = sizes.filter{it >= 30000000 - spaceleft}.min()


        //println(result)
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 95437)
    check(part2(testInput) == 24933642)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

abstract class DirectoryItem(val name: String) {
    abstract fun sizeOf(): Int
}

data class Folder(val n:String, val parent: DirectoryItem?) : DirectoryItem(n) {
    var contents: MutableList<DirectoryItem> = mutableListOf()
    override fun sizeOf(): Int {
        var result = 0
        for (item in contents) {
            result += item.sizeOf()
        }
        return result
    }
}

data class File(val n: String, val size: Int, val parent: DirectoryItem) : DirectoryItem(n) {
    override fun sizeOf(): Int {
        return size
    }
}

