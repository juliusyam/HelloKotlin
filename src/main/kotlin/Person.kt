class Person(val firstName: String = "Peter", val lastName: String = "Pan") {

    var nickName: String? = null

        set(value) {
            field = value

            println("The new nickname is $value")
        }

        get() {
            println("The returned value is $field")
            return field
        }

    internal fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"

        println("$firstName ($nickNameToPrint) $lastName")
    }

}