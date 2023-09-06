# Spring + Kotlin - ClassPathResource 를 이용한 파일 처리

Spring 에서는 jar 파일 안에 리소스들이 말려들어갔을 때 파일 경로가 `src/main/resources` 디렉터리를 인식하지 못하는 경우가 있다. 일반적인 FILE I/O나 Files 의 API를 그대로 사용하지 못한다. 클래스 패스 기준이 아니라 `/out/...` 이나 `/target/ ...` 같은  디렉터리 기준으로 파일 위치를 찾으려고 한다.

이런 이유로 파일 읽어들이는 부분이 스프링 애플리케이션 내에서 런타임에 해당 로직이 있는 경우, 위와 같이 File I/O, Files 의 API 를 그대로 사용하지 못한다.<br>

이런 경우 스프링에서 제공하는 ClassPathResource 를 사용해야 한다.  <br>

<br>

자세한 설명은 생략하고, 예제만 남겨보면 아래와 같다.

아래와 같이 실행하면, 

- Test 코드는 `/src/test/resources` 아래의 파일을 인식하고
- 런타임 코드는 `/src/main/resources` 아래의 파일을 기준으로 인식한다.





### e.g. Test 파일 내에서 실행

파일 위치 : `/src/test/resources/hello/hello.txt`

테스트 코드 : `/src/test/kotlin/io/study/gosgjung/filepractice`

```kotlin
class HelloFileTest {

    @Test
    fun `ClassPathResource 를 활용한 파일 조회 테스트`(){
        val filePath = "hello/hello.txt"
        val resource = ClassPathResource(filePath)
        val reader = resource.inputStream.bufferedReader(StandardCharsets.UTF_8)

        val list = reader.buffered(20)
            .lineSequence()
            .filter { it.isNotBlank() }
            .toList()

        println(list)
    }
}
```



### e.g. 런타임에서 실행

파일 위치 : `/src/main/resources/hello/runtime-test.txt`

런타임 코드 : 

- `/src/main/kotlin/hello/runtime_file/HelloFileReadConfig.kt`

- `/src/main/kotlin/hello/runtime_file/HelloReadComponent.kt`

<br>

#### runtime-test.txt

```plain
런타임에서 실행했어요.
안녕하세요.
```

<br>

#### HelloReadFileConfig.kt

```kotlin
@Configuration
class HelloFileReadConfig {

    @Bean
    fun helloTxtResource() : ClassPathResource{
        val filePath = "hello/hello.txt"
        val resource = ClassPathResource(filePath)
        return resource
    }
}
```

<br>

#### HelloReadComponent.kt

```kotlin
@Component
class HelloReadComponent (
    @Qualifier("helloTxtResource") val classPathResource: ClassPathResource,
){

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun appReadyEvent(){
        requireNotNull(classPathResource){ "classPathResource is null." }
//        check(!classPathResource.){"We must read type of file."}

        val reader = classPathResource.inputStream.bufferedReader(StandardCharsets.UTF_8)

        val list = reader.buffered(20)
            .lineSequence()
            .filter { it.isNotBlank() }
            .toList()

        checkNotNull(list){"list must be not null."}

        assert(list.isNotEmpty()){
            "File Text is Empty"
        }

        logger.info(list.toString())

    }
}
```



#### 실행결과

```plain
[런타임에서 실행했어요., 안녕하세요.]
```











