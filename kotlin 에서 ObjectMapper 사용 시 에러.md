### kotlin 에서 ObjectMapper 사용 시 에러 

여러가지 방법이 있겠지만 `jackson-module-kotlin` 모듈을 사용해서 `KotlinModule` 클래스를 이용해 객체를 생성하는데 이 때 `nullIsSameAsDefault` 속성을 `true` 로 정의해주어서 문제를 해결 가능하다.

<br>



### e.g.

build.gradle.kts

```kotlin
implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
```

<br>



예제 코드

```kotlin
private val objectMapper = ObjectMapper().registerModule(
  KotlinModule.Builder()
  .withReflectionCacheSize(512)
  .configure(KotlinFeature.NullToEmptyCollection, false)
  .configure(KotlinFeature.NullToEmptyMap, false)
  .configure(KotlinFeature.NullIsSameAsDefault, true)
  .configure(KotlinFeature.StrictNullChecks, false)
  .build()
)


val signupRequest = SignupRequest(
  name = "asdf",
  email = "asdf@gmail.com",
  password = "1234"
)

val requestBody = objectMapper.writeValueAsString(signupRequest)

println("string data = $requestBody")
```

<br>



출력 결과

```plain
string data = {"email":"asdf@gmail.com","name":"asdf","password":"1234"}
```

<br>



### 참고자료

- [Kotlin and Jackson (ObjectMapper)](https://kapentaz.github.io/kotlin/json/Kotlin-and-Jackson-(ObjectMapper)/#)

<br>







