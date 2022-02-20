interface PersonInfoProvider {
    val providerInfo: String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic info provider"

    protected open val sessionIdPrefix = "take-me-to-church"

    override fun printInfo(person: Person) {
        super.printInfo(person)

        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = object: PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "let-me-give-you-my-life"
    }

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")

        // Smartly cast to SessionInfoProvider
        infoProvider.getSessionId()
    }
}