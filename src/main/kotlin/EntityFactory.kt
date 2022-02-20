import java.util.*

//interface IdProvider {
//    fun getId(): String
//}
//
//class Entity private constructor(val id: String) {
//
//    companion object Factory: IdProvider {
//        override fun getId(): String {
//            return "shine-me-a-light"
//        }
//
//        const val id = "id"
//
//        fun create() = Entity(getId())
//    }
//}

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().replaceFirstChar(Char::titlecase)
}

object EntityFactory {
    fun create(type: EntityType): Entity {

        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> type.getFormattedName()
            EntityType.HELP -> type.getFormattedName()
        }
        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity() {

    object Help: Entity() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
}

fun main() {

    val msg = when(EntityFactory.create(EntityType.EASY)) {
        Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Hard -> "hard class"
        is Entity.Medium -> "medium class"
    }

    println(msg)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)

    val helpEntity = EntityFactory.create(EntityType.HELP)
    println(helpEntity)
}