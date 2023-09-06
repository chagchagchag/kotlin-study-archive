# 코틀린의 스코프 함수들 - let, run, with, apply, also

객체의 컨텍스트 내에서 코드 블록을 실행하기 위해 존재하는 함수들 중 `let`, `run`, `with`, `apply` 함수는 스코프함수라고 부른다. 이 `let`, `with`, `run`, `apply` 함수는 모두 코틀린의 표준 라이브러리에 포함된 함수들이다.<br>

스코프 함수들을 유연하게 잘 사용하면, 불필요한 변수 선언들이 없어지고, 코드도 더 간결하고 명확해진다. 스코프 함수의 코드 블록 내에서는 변수명을 사용하지 않아도 객체에 접근할 수 있다. 이 것은 **수신자 객체**에 접근할 수 있기 때문에 접근이 가능한 것이다. <br>

이 **수신자 객체**는 람다식 내부에서 사용할 수 있는 객체의 참조다. 스코프 함수를 사용하면 수신자 객체에 대한 참조로 `this`, `it` 를 사용한다. 

<br>



### 참고자료 

- [StackOverflow - Is Kotlin `?.let` thread-safe?](https://stackoverflow.com/questions/57324180/is-kotlin-let-thread-safe)

<br>



### 기본적인 용법들

#### let

let 함수에 대한 복잡한 사용 예는 [코틀린의 let 함수 - 여러가지 복잡한 사용예] 에 정리해두었다.

이 문서에서는 단순한 사용법만을 정리하기로 결정했다.



e.g.

```kotlin
@PutMapping(path = ["/let"])
fun let_sample(@RequestParam(required = false) age: Int?): ResponseEntity<String> {
    return age?.let{
        if(it<20){
            return ResponseEntity.status(400).body("19세 미만은 접근할 수 없습니다.")
        }
        ResponseEntity.ok("OK")
    } ?: kotlin.run { 
        return ResponseEntity.status(400).body("age 파라미터가 누락되었습니다.")
    }
}
```

<br>



#### apply

- 객체의 스코프 내에서 수행할 객체의 필드에 대한 초기화 작업 등을 정의한다.

<br>



e.g. 

객체 생성을 하는 비교적 단순한 예제다. 예제를 위해 약간은 억지스러운 코드를 작성했다.

```kotlin
fun sample (): AuthorResponse {
    return AuthorResponse().apply {
        this.result = Result().apply{
            this.resultCode = "OK"
            this.resultMessage = "SUCCESS"
        }
    }.apply {
        val list = mutableListOf<AuthorDto>()

        list.add(AuthorDto("피터린치", 1,"tenbagger@gmail.com"))

        list.add(AuthorDto().apply{
            name = "워런버핏"
            authorId = 2
            email = "buffet@gmail.com"
        })

        this.body = list
    }
}
```

<br>



위에서 사용한 각각의 `AuthorResponse`, `Result`, `AuthorDto` 객체에 대한 코드는 아래와 같다.

```kotlin
data class AuthorResponse(
        var result: Result? = null,
        var body: MutableList<AuthorDto>? = mutableListOf(),
)

data class Result(
        var resultCode: String? = null,
        var resultMessage: String? = null,
        var description: String? = null,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AuthorDto(
        var name: String? = null,
        var authorId: Long? = null,
        var email: String? = null,
)
```

<br>





#### run



<br>



#### with



<br>

### also



<br>





### 정리

let

- 수신자 객체 : it 로 접근
- 반환 값: 함수의 결과
- 확장함수 **적용가능**



run

- 수신자 객체 : this 로 접근
- 반환 값: 함수의 결과
- 확장함수 **적용가능**



with

- 수신자 객체 : this 로 접근
- 반환 값: 함수의 결과
- 확장함수 **적용 불가**



apply

- 수신자 객체 : this 로 접근
- 반환 값: 컨텍스트 객체
- 확장함수 **적용가능**



also

- 수신자 객체 : it 로 접근
- 반환 값: 컨텍스트 객체
- 확장함수 **적용가능**

<br>



### 왜 쓰는 걸까?

결론부터 정리해보면 이렇다.

- 생성자에 인자가 많아지는 것으로 인해 setter를 사용하는 경우가 있다. 이렇게 setter 를 쓰는 것은 동시성 이슈로 인해 위험한데
- let, apply, run, with, also 를 사용하면 람다 처럼 새로운 익명의 객체 인스턴스 내에서 필드를 수정하는 불변성이 보장된 데이터 접근을 할수 있다.
- 고전적인 방식으로는 내부클래스를 이용한 Builder 패턴 방식으로도 비슷한 처리를 한다.
- 람다를 통한 처리 역시 익명 객체를 새로 생성해서 하는 연산이기에 불변성이 보장된다.

<br>



조금 더 짧게 이야기하면 이렇게 무뚝뚝하게 이야기할 수도 있을 것 같다.

- 그냥 setter 안쓰고 불변성이 보장되는 객체 내의 필드를 수정/접근을 하거나 객체 생성시 해야 하는 초기화 작업을 정의하기 위해서

<br>



### 조금 길게 생각해보면

**Java의 생성자와 setter**<br>

흔히 Java 의 생성자는 Thread 에 안전하다고 한다. 그런데 생성자에 인자가 많아진다면, 객체의 생성과 동시에 필드를 초기화하기 쉽지않다. 이런 이유로 setter를 사용하는 경우가 있다. 그런데 setter 는 객체가 생성된 후에 필드에 접근하기에 Thread Safe 하지 않다고 이야기한다. <br>



**Builder**<br>

그래서 내부에 Inner Class 를 두어서 임시객체를 만들어두고 이 객체를 통해 필드를 세팅하는 개별 메서드들을 통해  필드들을 접근하고 수정한다. 그리고 그 Inner Class 내에 해당 타입의 인스턴스를 생성하는 역할을 하는 `build()` 라는 메서드를 사용해서 최종적으로 필드들이 초기화된 인스턴스를 생성한다.<br>



**apply, let, run, with, also**<br>

그런데 apply, let, run, with, also 는 builder 에 비해서 작성해야 하는 코드의 양은 줄어들면서 불변성을 보장하면서 객체의 생성시 필요한 초기화작업을 할 수 있다. 

apply, let, run, with, also 는 객체의 스코프에서 동작하는 함수다. 스코프 함수는 람다와 같이 하나의 익명 객체의 영역이라고 생각할수 있다. 그리고 이 스코프 함수의 `{ ... }` 내에에서는 객체의 수신자(Receiver) 라는 것을 얻어서 접근한다. 그리고 이 `{...}` 스코프는 외부에서 접근이 불가능하다. 익명으로 생성된 객체 내부이기에 변경가능성이 없는 불변 상태다.<br>



**자바의 Optional, lambda**<br>

코틀린이 아니더라도 Java에서도 람다를 이용해서 이런 스코프 내에서 처리를 하는 것이 가능하다. 예를 들면 Optional 을 이용한 아래의 코드는 ifPresent 내에서 실행되는 람다는 불변성이 보장된다. 람다는 내부적으로는 새롭게 생성된 익명 객체 인스턴스이기 때문이다.

```java
Optional.ofNullable(msg)
    .ifPresent(str -> System.out.println(msg));
```

Optional 은 ifPresent 말고도 map, orElse 같은 편리한 함수들을 제공해주고 있다.

그런데 코틀린은 모든 객체에 대해 이런 연산을 apply, let, run, with, also 같은 편의성 함수를 이용해서 수행가능하다.

<br>

