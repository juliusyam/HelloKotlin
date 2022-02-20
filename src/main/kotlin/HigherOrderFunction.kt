fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {

    list.forEach {
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

// Storing functions as variables
val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("K") }
}

fun main() {
    val list = listOf("Kotlin", "Java", "Swift", "Typescript", "JavaScript")
    printFilteredStrings(list, predicate)

    printFilteredStrings(list, getPrintPredicate())

    printFilteredStrings(list, null)
}