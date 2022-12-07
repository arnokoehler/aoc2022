package com.adventofcode.io.dayone

class DayFour {

    companion object {
        fun splitLinesGroupedBySection(s: String): List<Ranges> {
            val lines = FileUtils.getLines(s)
            return lines.map { ranges(it) }
        }

        private fun ranges(setsToCompare: String): Ranges {
            val set = setsToCompare.split(",")
            return Ranges(set[0].toIntRange(), set[1].toIntRange())
        }
    }
}

data class Ranges(val firstRange: IntRange, val secondRange: IntRange) {

    fun intersectFull(): Boolean {

        println("$firstRange")
        println("$secondRange")


        val doesItIntersect = firstRange intersectAll secondRange
        println("--- intersect: $doesItIntersect")

        println("-----------")

        return doesItIntersect
    }

    fun intersectPartial(): Boolean {
        val intersect = firstRange.intersect(secondRange)
        return !intersect.isEmpty()
    }
}

fun String.toIntRange(): IntRange{
    return this.split("-").let {
        it[0].toInt()..it[1].toInt()
    }
}

private infix fun IntRange.intersectAll(other: IntRange) = this.count {
    it in other
}.let {
    it == this.count() || it == other.count()
}
