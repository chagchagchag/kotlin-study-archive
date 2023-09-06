# boot 2.7.x, kotlin 환경에서 JPA 적용시 트러블 슈팅 (build.gradle 일때)

JPA에서는 강제로 기본 생성자를 생성해야 JPA를 사용할 수 있다. 이런 이유로 kotlin 에서 Entity 클래스를 아무 생각없이 작성하면 에러를 만나게 된다.

```kotlin
@Entity
class Book(
	val name: String,
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
```

<br>



참고로 에러 문구는 컴파일타임에 IDE 에서 아래처럼 나온다.

```plain
Class 'Book' should have [public, protected] no-arg constructor
```

<br>



build.gradle 에 아래의 설정들을 해준다.



### plugins 에 jpa plugin  추가

build.gradle 에 아래와 같이 kotlin jpa plugin 을 추가해주면 된다.<br>

```groovy
plugins {
    // ...
	id 'org.jetbrains.kotlin.plugin.jpa' version '1.6.21'
}
```

<bR>



### dependencies 에 kotlin reflect 추가

```groovy
dependencies {
    implementation 'org.jetbrains.kotlin:kotlin-reflect:1.6.21'
    // ...
}
```

