package br.com.gamemods.levelmanipulator.catalog

import java.util.*

class HumanStringComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        val o1StringPart = o1.replace("\\d".toRegex(), "")
        val o2StringPart = o2.replace("\\d".toRegex(), "")
        return if (o1StringPart == o2StringPart) {
            extractInt(o1) - extractInt(o2)
        } else o1.compareTo(o2)
    }

    private fun extractInt(s: String): Int {
        val num = s.replace("\\D".toRegex(), "")
        // return 0 if no digits found
        return if (num.isEmpty()) 0 else num.toInt()
    }

    companion object {
        val INSTANCE = HumanStringComparator()
    }
}
