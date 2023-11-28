## Wiremock 라이브러리와 Spring Cloud Contract Wiremock

이번 문서는 CDC의 개념이나 테스트 코드를 예제로 설명하는 것은 아니고 spring cloud contract 를 사용할 때 도대체, 대체!!! 어떤 wiremock 라이브러리를 사용하는 것인지 혼동될 때가 있을 것 같아서 wiremock 라이브러리가 대체 뭔지 줄거리만 간략하게 정리해보는 문서입니다.<br>

이 리포지터리에 누가 와서 본다는 생각을 해본적이 없기에 이번에도 그냥 독백체로 정리했는데요. 혹시라도 제가 모르는 어떤 분이 와서 이 글을 보고 계신다면 그냥 귀엽게 봐주세요…;;; ㅋㅋ<br>

<br>



### spring cloud contract 가 채택하는 wiremock 라이브러리는?

Spring Cloud Contract Wiremock 에서 채택하고 있는 wiremock 라이브러리의 원본 출처는 아래와 같다.

- com.github.tomakehurst.wiremock

- https://mvnrepository.com/artifact/com.github.tomakehurst/wiremock .

<br>



만약 spring-cloud-contract-wiremock 를 사용하면, spring-cloud 팀에서 특정 버전에 대한 wiremock 버전을 알맞게 채택해서 관리해주고 있다.

```kotlin
implementation("org.springframework.cloud:spring-cloud-contract-wiremock")
```

<br>



### wiremock

> github 공식 페이지 https://github.com/wiremock/wiremock 의 내용을 의역, 요약한 내용입니다.

wiremock 은 2011 년도 [Tom Akehurst](https://github.com/tomakehurst) 가 java 라이브러리로 만들기 시작해서 여러 프로그래밍 언어와 여러가지 스택으로 전파됐다. 현재 wiremock 은 매월 5백만 다운로드를 기록하는 굉장히 대중적인 API Mock 테스팅을 위한 오픈소스라이브러리가 됐다. wiremock 을 사용하면 안정적인 테스트와 개발환경을 만들수 있다. 그리고 연동해야 하는 서드파티 API에서 예외상황이 발생하거나 아직 서드파티 API 등이 없을때 서드파티로부터 고립되게끔 한 후 시뮬레이팅을 할 수 있게끔 도와준다.<br>

예를 들면 결제 서버 연동과 관련되서 아직 뭔가 전달받은게 없거나 연동이 안되거나, 아직 PG사와 계약을 하지 않은 상황에서 아무것도 안하고 있으면 시간적, 인적 리소스가 낭비되는데, 이때 보통 Mocking Server 기반으로 개발을 하면, 특정 HttpStatus 에 어떻게 동작할지를 정의해서 기능 개발을 시작할 수 있다. wiremock 은 이런 Mocking Server 기반의 개발을 가능하게끔 해주는 하나의 라이브러리다.<br>

제공되는 주요 기능은 아래와 같다.(영어 번역은 생략)

- HTTP response stubbing, matchable on URL, header and body content patterns
- Configuration via a fluent Java API, JSON files and JSON over HTTP
- Record/playback of stubs
- Request verification
- Fault and response delays injection
- Per-request conditional proxying
- Browser proxying for request inspection and replacement
- Stateful behaviour simulation
- Extensibility

<br>

wiremock 공식 github https://github.com/wiremock  에 등록된 리포지터리들 https://github.com/orgs/wiremock/repositories 을 둘러보면 docker 이미지, python-wiremock, go-wiremock, grpc-wiremock, wiremock-cloud-postman-collections 등 굉장히 다양한 언어와 다양한 프레임워크, 다양한 개발툴, 다양한 통신환경을 지원하고 있음을 확인할 수 있다.

<br>



### wiremock 관련 주요 자료 모음

주관적이지만 가장 이해가 쉬웠던 자료 순으로 나열<br>

<br>

**github/wiremock/wiremock**

- 공식 github
- https://github.com/wiremock/wiremock

<br>

**geeks for geeks - wiremock : Verifying with JUnit Test**

- 처음 기능을 만들어보면서 스터디하기엔 가장 쉬웠던 자료
- https://www.geeksforgeeks.org/wiremock-verifying-with-junit-test/

<br>

**[docs.spring.io](http://docs.spring.io) - Spring Cloud Contract Reference Documentation**

- 스프링 공식 도큐먼트 찾아보는 법 다들 아시죠?
- ([spring.io](http://spring.io) \> Projects \> Spring Cloud \> Spring Cloud Contract \> Learn \> 버전 선택)
- https://docs.spring.io/spring-cloud-contract/docs/current/reference/html/

<br>

**An Intro to Spring Cloud Contract**

- https://www.baeldung.com/spring-cloud-contract

<br>

**[cloud.spring.io](http://cloud.spring.io) - Spring Cloud Contract WireMock**

- https://cloud.spring.io/spring-cloud-contract/2.1.x/multi/multi__spring_cloud_contract_wiremock.html

<br>