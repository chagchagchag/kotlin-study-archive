## use { ... } : 사용한 자원 자동으로 닫기

Java 에서는 Closable, AutoClosable 둘 중 하나를 구현(implements)한 자원을 try 구문을 사용한다. 코틀린에서는 use 라는 함수를 사용한다.

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

<br>



**t1.txt**<br>

t1.txt 파일의 내용은 아래와 같다.

```plain
ABCDE
FGHIJ
KLMNO
PQRST
UVWXYZ
```

<br>



출력결과

```plain
>>> 
ABCDE
FGHIJ
KLMNO
PQRST
UVWXYZ
```

<br>