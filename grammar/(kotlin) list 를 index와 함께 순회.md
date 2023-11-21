## (kotlin) list 를 index와 함께 순회



e.g.

```kotlin
data class GoogleSearchKeywordResponse (
    val meta: GoogleSearchKeywordMeta,
    val documents: List<GoogleSearchKeywordDocument>
){
}

val list = googleSearchKeywordResponse.documents

val l = list.mapIndexed{ i, document -> 
  PlaceItem(
    index = i,
    keyword = keyword,
    placeName = document.placeName,
    from = FromType.GOOGLE,
  )
}
```

