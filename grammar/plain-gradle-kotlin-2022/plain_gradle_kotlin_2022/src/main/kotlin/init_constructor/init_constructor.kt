package init_constructor

fun main() {
    var a = Player("ABC", 100)
    var b = Player("DDD", 200)
    var c = Player("ZZZ", 300)
}

class Player(var name: String, val age: Int) {
    init {
        println("${this.age}세 ${this.name} 님이 생성되었습니다.")
    }
}