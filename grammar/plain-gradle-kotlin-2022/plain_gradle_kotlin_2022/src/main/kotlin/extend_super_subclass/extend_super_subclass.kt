package extend_super_subclass

import java.time.ZonedDateTime
import java.util.UUID

fun main() {
    val createdEvent = UserCreatedEvent(
        age = 11111,
        name = "도깨비",
        createdAt = ZonedDateTime.now(),
    )

    println(">> UserCreatedEvent")
    createdEvent.printUserEvent()
    createdEvent.printUserCreatedEvent()

    val deletedEvent = UserDeletedEvent(
        createdEvent.userId,
    )

    println()
    println(">> UserDeletedEvent")
    deletedEvent.printUserEvent()
    deletedEvent.printUserDeletedEvent()
}

enum class EventType{
    USER_CREATED, USER_DELETED,
}

open class UserEvent(
    val userId: UUID,
    val eventType: EventType,
){
    fun printUserEvent(){
        println("UserEvent { userId = $userId, eventType = $eventType }")
    }
}

data class UserCreatedEvent(
    val age: Int,
    val name: String,
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
) : UserEvent (
    userId = UUID.randomUUID(),
    eventType = EventType.USER_CREATED,
) {

    fun printUserCreatedEvent(){
        println("UserCreatedEvent { age = $age, name = $name, createdAt = $createdAt }")
    }

}

class UserDeletedEvent(
    userId: UUID,
) : UserEvent (
    userId,
    eventType = EventType.USER_DELETED,
) {

    fun printUserDeletedEvent(){
        println("UserDeletedEvent { userId = $userId }")
    }

}