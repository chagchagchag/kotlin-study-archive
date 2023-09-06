# 코루틴 Junit (2) - 단순 흐름을 제어해보기



### 참고자료

- [Kotlin Coroutine 테스트 코드 작성 예제](https://velog.io/@picbel/Kotlin-Coroutine-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1-%EC%98%88%EC%A0%9C)
- [Testing Kotlin coroutines on Android](https://lovestudycom.tistory.com/237)
- [Unit Testing with Kotlin Coroutines: The Android Way](https://medium.com/swlh/unit-testing-with-kotlin-coroutines-the-android-way-19289838d257)

<br>



### Overview

코루틴을 처음 배울 때 Dispatcher 라는 것을 배운다. 코루틴은 어떤 디스패처에서 실행시키느냐에 따라 코루틴을 제어하는 방식이 달라진다. 테스트 코드 내에서 코루틴을 실행하는 것은 org.jetbrains.kotlinx 에서 제공해주는 확장 라이브러리를 통해 junit 테스트 용도의 Dispatcher들을 사용할 수 있다.

오늘 예제로 사용해볼 디스패처들은 아래의 두 디스패처다.

- StandardTestDispatcher
- UnconfinedTestDispatcher



처음 배우는 입장이라 해외 자료를 보면 뭐가 중요한지 잘 모른다. 그래서 국내 자료를 보면서 예제를 작성하다 보니 어느 정도의 주관적인 관점이 생긴 것 같다.<br>



### StandardTestDispatcher





### UniconfinedTestDispatcher







