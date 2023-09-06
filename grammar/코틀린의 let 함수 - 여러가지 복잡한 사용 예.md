# 코틀린의 let 함수 - 여러가지 복잡한 사용 예

null 이 아닌 경우 적용할 로직을 통해 새로운 결과를 반환하고자 할 때 사용한다.<br>

단적으로 비유를 들면, map 함수를 null 이 아닐때 사용하는 그런 경우를 예로 들 수 있다.<br>

<br>



#### null 데이터, null 이 아닌 데이터에 대해 let 사용시

e.g. null 데이터에 let 함수를 적용해서 실행되는 지 확인

```kotlin
fun main() {
    val str: String? = null
    
    str?.let{
        println(it)
    }
    
    // 출력결과
    // 아무것도 출력되지 않는다.
}
```

<br>



e.g. null 이 아닌 데이터에 let 함수를 적용했을 때 실행되는지 확인

```kotlin
fun main(){
    val str: Stirng? = "Hello~"
    
    str?.let{
        println(it)
    }
    
    // 출력결과
    // Hello~
}
```

<br>



#### let 함수를 map 함수처럼 결과를 매핑

e.g. let 함수를 map 함수처럼 결과를 매핑해주는 역할로 사용

```kotlin
val str1: String? = "대한민국~!!"

val result1 = str1?.let{
    println("it = $it")
    str1.length
}

println("result1 = $result1")
println()

val str2: String? = "hello ~ "

val result2 = str2?.let{
    println("it = $it")
    str2.uppercase()
}

println("result2 = $result2")
```

<br>



출력결과

```plain
it = 대한민국~!!
result1 = 7

it = hello ~ 
result2 = HELLO ~ 
```

<br>



#### let이 여러번 중첩되어 있는 경우 

e.g. let 이 여러번 중첩되어 다소 복잡한 코드

```kotlin
val str: String? = "대한민국~!!"
val result = str?.let{
    println("it = $it")

    val hello: String? = "hello ~ "
    hello?.let{
        val HELLO: String? = it.uppercase()
        println("str, hello 모두 null 이 아님")
    }

    "world".uppercase()
}

println("result = $result")
```

<br>



출력결과

```plain
it = 대한민국~!!
str, hello 모두 null 이 아님
result = WORLD
```

<br>



#### let 이 너무 중첩되어 불편하면 if문 사용을 고려하자

e.g. let 이 너무 중첩되어 스파게티코드 처럼 된다면, if 식을 사용하면 유용하다.

```kotlin
val str: String? = "대한민국~!!"
val result = str?.let{
    println("it = $it")

    val hello: String? = "hello ~ "
    val HELLO: String? = "HELLO ~ "

    if(!hello.isNullOrBlank() && !HELLO.isNullOrBlank()){
        println("hello, HELLO 모두 null 이 아님")
    }

    "world".uppercase()
}

println("result = $result")
```

<br>



