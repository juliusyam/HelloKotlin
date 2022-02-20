
// Variable amount of arguments
fun sayHello(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")

fun main() {

    sayHello("Hello", "Kotlin", "Programming", "Comic Books")

    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHello(greeting = "Hola", itemsToGreet = *interestingThings)

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map[4] = "d"
    map.forEach { (key, value) -> println("$key, $value") }

    greetPerson(name = "Stacy")

    val person = Person()
    person.printInfo()
}

