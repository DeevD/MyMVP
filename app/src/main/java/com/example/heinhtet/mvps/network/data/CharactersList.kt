package com.example.heinhtet.mvps.network.data

import com.squareup.moshi.Json


/**
 * Created by heinhtet on 11/24/2017.
 */

data class CharactersList(
        @Json(name = "code") val code: Int?, //200
        @Json(name = "status") val status: String?, //Ok
        @Json(name = "copyright") val copyright: String?, //© 2017 MARVEL
        @Json(name = "attributionText") val attributionText: String?, //Data provided by Marvel. © 2017 MARVEL
        @Json(name = "attributionHTML") val attributionHTML: String?, //<a href="http://marvel.com">Data provided by Marvel. © 2017 MARVEL</a>
        @Json(name = "etag") val etag: String?, //325e38f64f0361402c304e65e0b1a585d530de84
        @Json(name = "data") val data: Data?
)

data class Data(
        @Json(name = "offset") val offset: Int?, //0
        @Json(name = "limit") val limit: Int?, //20
        @Json(name = "total") val total: Int?, //1491
        @Json(name = "count") val count: Int?, //20
        @Json(name = "results") val results: List<Result>?
)

data class Result(
        @Json(name = "id") val id: Int?, //1011334
        @Json(name = "name") val name: String?, //3-D Man
        @Json(name = "description") val description: String?,
        @Json(name = "modified") val modified: String?, //2014-04-29T14:18:17-0400
        @Json(name = "thumbnail") val thumbnail: Thumbnail?,
        @Json(name = "resourceURI") val resourceURI: String?, //http://gateway.marvel.com/v1/public/characters/1011334
        @Json(name = "comics") val comics: Comics?,
        @Json(name = "series") val series: Series?,
        @Json(name = "stories") val stories: Stories?,
        @Json(name = "events") val events: Events?,
        @Json(name = "urls") val urls: List<Url?>?
)

data class Stories(
        @Json(name = "available") val available: Int?, //21
        @Json(name = "collectionURI") val collectionURI: String?, //http://gateway.marvel.com/v1/public/characters/1011334/stories
        @Json(name = "items") val items: List<StoriesItem>?,
        @Json(name = "returned") val returned: Int? //20
)

data class StoriesItem(
        @Json(name = "resourceURI") val resourceURI: String?, //http://gateway.marvel.com/v1/public/stories/19947
        @Json(name = "name") val name: String?, //Cover #19947
        @Json(name = "type") val type: String? //cover
)

data class Comics(
        @Json(name = "available") val available: Int?, //12
        @Json(name = "collectionURI") val collectionURI: String?, //http://gateway.marvel.com/v1/public/characters/1011334/comics
        @Json(name = "items") val items: List<ComicItem>?,
        @Json(name = "returned") val returned: Int? //12
)

data class ComicItem(
        @Json(name = "resourceURI") val resourceURI: String?, //http://gateway.marvel.com/v1/public/comics/21366
        @Json(name = "name") val name: String? //Avengers: The Initiative (2007) #14
)

data class Url(
        @Json(name = "type") val type: String?, //detail
        @Json(name = "url") val url: String? //http://marvel.com/characters/74/3-d_man?utm_campaign=apiRef&utm_source=760ae134816e306a326152392a80f6a0
)

data class Events(
        @Json(name = "available") val available: Int?, //1
        @Json(name = "collectionURI") val collectionURI: String?, //http://gateway.marvel.com/v1/public/characters/1011334/events
        @Json(name = "items") val items: List<EventItem>?,
        @Json(name = "returned") val returned: Int? //1
)

data class EventItem(
        @Json(name = "resourceURI") val resourceURI: String?, //http://gateway.marvel.com/v1/public/events/269
        @Json(name = "name") val name: String? //Secret Invasion
)

data class Thumbnail(
        @Json(name = "path") val path: String?, //http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784
        @Json(name = "extension") val extension: String? //jpg
)

data class Series(
        @Json(name = "available") val available: Int?, //3
        @Json(name = "collectionURI") val collectionURI: String?, //http://gateway.marvel.com/v1/public/characters/1011334/series
        @Json(name = "items") val items: List<SeriesItem>?,
        @Json(name = "returned") val returned: Int? //3
)

data class SeriesItem(
        @Json(name = "resourceURI") val resourceURI: String?, //http://gateway.marvel.com/v1/public/series/1945
        @Json(name = "name") val name: String? //Avengers: The Initiative (2007 - 2010)
)