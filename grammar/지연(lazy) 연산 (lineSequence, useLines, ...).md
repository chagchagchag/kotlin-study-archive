## 지연(lazy) 연산 (lineSequence, useLines, ...)

## e.g. use { ... lineSequence() ... }

```kotlin
package use_statement

import java.io.File

fun main(){
    println(">>> ")
    File("t1.txt").inputStream()
        .use {
            it.bufferedReader()
                .lineSequence()
                .forEach (::println)
        }
}
```

lineSequence 함수는 Sequence 를 반환한다. 그리고 이 Sequence 는 지연 계산 컬렉션이다. 지연(lazy) 연산이란 말은 연산을 실제로 각 줄을 사용할 때에 이루어진다는 의미다. 위의 예제에서는 시퀀스 안의 각 줄이 실제로 사용될 때 연산이 이루어진다.

<br>

위의 코드를 아래와 같이 바꿔서 use{} 에서 읽어들인 내용을 Sequence 로 반환하더라도 use{} 블록을 벗어나면 입력스트림이 자동으로 닫힌다. use{} 블록은 사용하는 자원을 반환하기 때문이다. 따라서 아래 코드는 에러를 낸다.

```kotlin
fun main(){
  	// ... 
    // 아래 코드는 에러를 낸다.
    println(">>> ")
    val sequence: Sequence<String> =
        File("t1.txt").inputStream()
            .use {
                it.bufferedReader()
                    .lineSequence()
            }
    sequence.forEach(::println)
}
```

<br>



파일의 내용을 Stream 이 use{...} 블록이 끝나더라도 읽으려면 아래와 같이 Java 의 Stream 에서의 Collect 연산처럼 List 와 같은 컬렉션으로 반환해서 사용해야 한다.

```kotlin
package use_statement

import java.io.File

fun main(){
    println()
    println(">>> ")
    val lines: List<String> =
        File("t1.txt")
            .inputStream()
            .use {
                it.bufferedReader()
                    .lineSequence()
                    .toList()
            }

    println("""
        lines = 
         $lines
    """.trimIndent())
}
```

<br>



## e.g. useLines{...}

그런데 이 코드는 아래와 같이 단순하게 바꾸는 방법도 있다.

```kotlin
package use_statement

import java.io.File

fun main(){
  	
  	// ...
  	
    println()
    println(">>> useLines {...} 예제")
    File("t1.txt")
        .useLines { it.forEach(::println) }
}
```

