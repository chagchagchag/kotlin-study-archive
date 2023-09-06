# Snake Case, Camel Case

만약 아래 처럼 카멜케이스와 스네이크케이스 형식의 응답이 섞여있는 응답을 내려줘야 한다고 해보자. (이런 경우는 많지 않다.)

```json
{
    "result": {
        "resultCode": "OK",
        "resultMessage": "NO ERROR",
        "description": "안냐세용",
    },
    "body": [
        {"name": "피터린치", "email": "tenbagger@gmail.com", "author_id": 1},
        {"name": "워런버핏", "email": "buffet@gmail.com", "author_id": 2}
    ]
}
```

<br>



자세히 보면 result 라는 데이터는 카멜케이스를 사용하고 있고, body 라는 데이터는 배열을 가지고 있는데, 각 요소의 데이터가 스네이크 케이스를 사용하고 있다.<br>

그리고 kotlin 코드에서는 모든 필드를 카멜케이스 형식으로 정의하기로 약속된 상태라고 해보자. 이 경우 body 라는 데이터의 각 요소들의 `authorId` 라는 필드는  `author_id`  필드로 변환해주는 작업이 필요한데, 이런 작업 역시 jackson 에서 제공하는 Object Mapper 에서는 기본으로 라이브러리로 제공해주고 있다.

<br>



아래는 위의 응답 구조를 표현하기 위해 작성한 코틀린 코드다.

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



이것을 사용하기 위해 아래와 같이 간단한 Request를 처리하는 컨트롤러를 작성했다.

```kotlin
@RestController
@RequestMapping("/api/v1/author/object-mapping")
class AuthorApiV1ObjectMappingController {

    @PutMapping(path = ["/apply"])
    fun sample (@RequestBody authorModifyRequest: AuthorModifyRequest): AuthorResponse {
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
}
```

<br>



위와 같은 요청을 처리하고 나면 아래와 같이 스네이크 케이스와 카멜케이스가 섞여서 나오는 것을 확인할 수 있다.

```json
{
    "result": {
        "resultCode": "OK",
        "resultMessage": "SUCCESS",
        "description": null
    },
    "body": [
        {
            "name": "피터린치",
            "author_id": 1,
            "email": "tenbagger@gmail.com"
        },
        {
            "name": "워런버핏",
            "author_id": 2,
            "email": "buffet@gmail.com"
        }
    ]
}
```



참고)

코틀린에서는 아래 구문 사용시 java 에서는 Deprecated 되었다는 Warning 이 나올때도 있다.

```kotlin
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class AuthorDto(
        var name: String? = null,
        var authorId: Long? = null,
        var email: String? = null,
)
```

<br>

위와 같은 코드는 아래와 같이 작성하면 Warning 이 없어진다.

```kotlin
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AuthorDto(
        var name: String? = null,
        var authorId: Long? = null,
        var email: String? = null,
)
```















