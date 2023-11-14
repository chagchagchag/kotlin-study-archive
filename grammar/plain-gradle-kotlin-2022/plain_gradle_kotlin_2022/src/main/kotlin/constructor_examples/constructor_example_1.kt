package constructor_examples
fun main(){
    var a = Player("ABC", 100)
    var b = Player("DDD", 200)
    var c = Player("ZZZ", 300)

    println()

    var d = Player("AAAAA")
    var e = Player("BBBBB")
    var f = Player("CCCCC")
}

class Player(var name: String, val age: Int){
    init{
        println("${this.age}세 ${this.name} 님이 생성되었습니다.")
    }

    constructor(name: String) : this(name, 9999){
        println("${age}세 $name 의 보조생성자 입니다.\n")
    }
}