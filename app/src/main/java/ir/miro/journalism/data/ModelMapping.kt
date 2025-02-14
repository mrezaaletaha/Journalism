package ir.miro.journalism.data

import ir.miro.journalism.data.sources.local.LocalNews
import ir.miro.journalism.data.sources.network.NetworkNews

/**
 * @author mrezaaletaha
 */


fun NetworkNews.toLocal() = LocalNews(
    id = id,
    title = title,
    summary = summary,
    imageUrl = img,
    url = url,
    publishedAt = publishedAt,
    updatedAt = updatedAt,
    createdAt = System.currentTimeMillis()
)

fun List<NetworkNews>.toLocal() = map(NetworkNews::toLocal)

fun LocalNews.toExternal() = News(
    id = id,
    title = title,
    summary = summary,
    img = imageUrl,
    url = url,
    updatedAt = updatedAt,
    publishedAt = publishedAt
)

fun List<LocalNews>.toExternal() = map(LocalNews::toExternal)