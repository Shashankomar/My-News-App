package com.mynewsapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsModel(

    /* @Json(name = "articles")
     val articles: List<Article>,
     @Json(name = "status")
     val status: String,
     @Json(name = "totalResults")
     val totalResults: Int
 */

//    Example 2 if 1 not works-

    @field:Json(name = "status")
    val s: String

)